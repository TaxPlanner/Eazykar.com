import { animate, state, style, transition, trigger } from '@angular/animations';
import { HttpClient, HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Component, ElementRef, EventEmitter, Input, OnInit, Output, Renderer2 } from '@angular/core';
import { IUser } from 'app/core';
import { DocumentService } from 'app/shared/file-upload/document.service';
import { DocumentType, IDocument } from 'app/shared/model/document.model';
import * as _ from 'lodash';
import { JhiDataUtils } from 'ng-jhipster';
import { Observable } from 'rxjs';

@Component({
    selector: 'ezkr-file-upload',
    templateUrl: './file-upload.component.html',
    styleUrls: ['./file-upload.component.scss'],
    animations: [
        trigger('fadeInOut', [
            state('in', style({ opacity: 100 })),
            transition('* => void', [
                animate(300, style({ opacity: 0 }))
            ])
        ])
    ]
})
export class FileUploadComponent implements OnInit {

    /** Link text */
    @Input() text = 'Upload';
    @Input() user: IUser;
    /** Name used in form which will be sent in HTTP request. */
    @Input() documentType: DocumentType;
    /** File extension that accepted, same as 'accept' of <input type="file" />. By the default, it's set to 'image/*'. */
    @Input() accept = 'multipart/form-data';
    @Input() matTooltip = 'Choose a file to upload';
    @Input() matTooltipPosition = 'above';

    /** Allow you to add handler after its completion. Bubble up response text from remote. */
    @Output() complete = new EventEmitter<string>();

    documents: Array<IDocument> = [];
    errors = [];

    constructor(private _http: HttpClient,
                private documentService: DocumentService,
                private dataUtils: JhiDataUtils,
                private renderer: Renderer2,
                private elementRef: ElementRef) {
    }

    ngOnInit() {
    }

    onClick() {
        this.documents = [];
        this.errors = [];
        this.renderer.selectRootElement('#fileUpload').click();
    }

    onFileInputChange() {
        const fileUpload = this.elementRef.nativeElement.querySelector('#fileUpload');
        for (let index = 0; index < fileUpload.files.length; index++) {
            const file = fileUpload.files[index];
            const document = {
                data: file,
                user: this.user,
                documentType: this.documentType,
                documentDescription: file.name
            };
            this.documents.push(document);
            this.setFileDataAndSave(document);
        }
    }

    setFileDataAndSave(document: IDocument) {
        const file = document.data;
        this.toBase64(file, base64Data => {
            document.document = base64Data;
            document.documentContentType = file.type;
            this.save(document);
        });
    }

    toBase64(file: File, cb: Function) {
        const fileReader: FileReader = new FileReader();
        fileReader.onload = function(e: any) {
            const result = e.target.result;
            const base64Data = result.substr(result.indexOf('base64,') + 'base64,'.length);
            cb(base64Data);
        };
        fileReader.onerror = function(e: any) {
            console.error(`Error: ${e}`);
        };
        fileReader.readAsDataURL(file);
    }

    save(document: IDocument) {

        document.inProgress = true;

        if (document.data.size / 1024 / 1024 > 5) {
            console.error(`${document.data.name} has size larger than max size of 5 MB`);
            this.errors.push(document.data.name);
            document.inProgress = false;
            this.emitIfComplete();
            return;
        }

        if (document.id === undefined) {
            this.subscribeToSaveResponse(this.documentService.create(document), document);
        } else {
            this.subscribeToSaveResponse(this.documentService.update(document), document);
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<IDocument>>, document: IDocument) {
        result.subscribe(() => this.onSaveSuccess(document), (res: HttpErrorResponse) => this.onSaveError(res, document));
    }

    private onSaveSuccess(document: IDocument) {
        document.inProgress = false;
        this.emitIfComplete();
    }

    private onSaveError(errorResponse, document: IDocument) {
        document.inProgress = false;
        console.error(`error: ${JSON.stringify(errorResponse)}`);
        this.emitIfComplete();
    }

    private emitIfComplete() {
        const documentsInProgress = this.documents.filter(d => d.inProgress === true);
        if (documentsInProgress.length === 0) {

            let message = `'${this.documents[0].data.name}' has been uploaded successfully.`;
            if (this.errors.length > 0) {
                const filesInError = _.join(this.errors, ',');
                message = `${filesInError} exceeds the max size of 5 MB.`;
            }

            this.complete.emit(message);
        }

    }

}
