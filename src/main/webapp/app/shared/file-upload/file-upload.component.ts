import { animate, state, style, transition, trigger } from '@angular/animations';
import { HttpClient, HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { IUser } from 'app/core';
import { DocumentService } from 'app/entities/document';
import { DocumentType, IDocument } from 'app/shared/model/document.model';
import { JhiDataUtils } from 'ng-jhipster';
import { Observable, Subscription } from 'rxjs';

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
    @Input() param = 'file';
    /** File extension that accepted, same as 'accept' of <input type="file" />. By the default, it's set to 'image/*'. */
    @Input() accept = 'multipart/form-data';
    /** Allow you to add handler after its completion. Bubble up response text from remote. */
    @Output() complete = new EventEmitter<string>();

    files: Array<FileUploadModel> = [];

    constructor(private _http: HttpClient,
                private documentService: DocumentService,
                private dataUtils: JhiDataUtils) {
    }

    ngOnInit() {
    }

    onClick() {
        const fileUpload = document.getElementById('fileUpload') as HTMLInputElement;
        fileUpload.onchange = (event) => {
            for (let index = 0; index < fileUpload.files.length; index++) {
                const file = fileUpload.files[index];
                let fileUploadModel = {
                    data: file,
                    state: 'in',
                    inProgress: false,
                    progress: 0,
                    canRetry: false,
                    canCancel: true,

                    user: this.user,
                    // document: file,
                    documentContentType: file.type,
                    documentType: DocumentType.FORM_16,
                    documentDescription: file.name
                };
                const eventSake = {
                    target: {
                        files: [file]
                    }
                };
                this.setFileData(eventSake, fileUploadModel, 'document', false);
                this.files.push(fileUploadModel);
                console.log(`fileUploadModel: ${JSON.stringify(fileUploadModel)}`);
            }
            this.uploadFiles();
        };
        fileUpload.click();
    }

    setFileData(event, entity, field: string, isImage: boolean) {
        if (event && event.target.files && event.target.files[0]) {
            const file = event.target.files[0];
            // if (isImage && !/^image\//.test(file.type)) {
            //     return;
            // }
            this.toBase64(file, (base64Data) => {
                entity[field] = base64Data;
                entity[`${field}ContentType`] = file.type;
                console.log(`entity.document: ${JSON.stringify(entity.document)}`);
                console.log(`entity.documentContentType: ${JSON.stringify(entity.documentContentType)}`);
            });
        }
    }
    toBase64(file: File, cb: Function) {
        const fileReader: FileReader = new FileReader();
        fileReader.onloadend = function(e: any) {

            const result = e.target.result;
            console.log(`result: ${JSON.stringify(result)}`);
            const base64Data = result.substr(result.indexOf('base64,') + 'base64,'.length);
            console.log(`base64Data: ${JSON.stringify(base64Data)}`);
            cb(base64Data);
        };
        fileReader.readAsDataURL(file);
    }

    cancelFile(file: FileUploadModel) {
        if (file) {
            if (file.sub) {
                file.sub.unsubscribe();
            }
            this.removeFileFromArray(file);
        }
    }

    retryFile(file: FileUploadModel) {
        this.uploadFile(file);
        file.canRetry = false;
    }

    save(document: IDocument) {
        // this.isSaving = true;
        if (document.id !== undefined) {
            this.subscribeToSaveResponse(this.documentService.update(document));
        } else {
            this.subscribeToSaveResponse(this.documentService.create(document));
        }
    }

    private uploadFile(file: FileUploadModel) {
        // const fd = new FormData();
        // fd.append(this.param, file.data);

        // const req = new HttpRequest('POST', this.target, fd, {
        //     reportProgress: true
        // });

        file.inProgress = true;
        // file.sub = this._http.request(req).pipe(
        //     map(event => {
        //         switch (event.type) {
        //             case HttpEventType.UploadProgress:
        //                 file.progress = Math.round(event.loaded * 100 / event.total);
        //                 break;
        //             case HttpEventType.Response:
        //                 return event;
        //         }
        //     }),
        //     tap(message => {
        //     }),
        //     last(),
        //     catchError((error: HttpErrorResponse) => {
        //         file.inProgress = false;
        //         file.canRetry = true;
        //         return of(`${file.data.name} upload failed.`);
        //     })
        // ).subscribe(
        //     (event: any) => {
        //         if (typeof (event) === 'object') {
        //             this.removeFileFromArray(file);
        //             this.complete.emit(event.body);
        //         }
        //     }
        // );

        this.save(file);
    }

    private uploadFiles() {
        const fileUpload = document.getElementById('fileUpload') as HTMLInputElement;
        fileUpload.value = '';

        this.files.forEach(file => {
            if (!file.inProgress) {
                this.uploadFile(file);
            }
        });
    }

    private removeFileFromArray(file: FileUploadModel) {
        const index = this.files.indexOf(file);
        if (index > -1) {
            this.files.splice(index, 1);
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<IDocument>>) {
        result.subscribe((res: HttpResponse<IDocument>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
    }

    private onSaveSuccess() {
        // this.isSaving = false;
        // this.previousState();
    }

    private onSaveError() {
        // this.isSaving = false;
    }

}

export class FileUploadModel implements IDocument {
    id?: number;
    documentType?: DocumentType;
    documentContentType?: string;
    document?: any;
    documentDescription?: string;
    user?: IUser;

    data: File;
    state: string;
    inProgress: boolean;
    progress: number;
    canRetry: boolean;
    canCancel: boolean;
    sub?: Subscription;
}
