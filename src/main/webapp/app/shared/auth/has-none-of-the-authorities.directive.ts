import { Directive, Input, TemplateRef, ViewContainerRef } from '@angular/core';
import { Principal } from 'app/core';

@Directive({
    selector: '[ezkrHasNoneOfTheAuthorities]'
})
export class HasNoneOfTheAuthoritiesDirective {
    private authorities: string[];

    constructor(private principal: Principal, private templateRef: TemplateRef<any>, private viewContainerRef: ViewContainerRef) {
    }

    @Input()
    set ezkrHasNoneOfTheAuthorities(value: string | string[]) {
        this.authorities = typeof value === 'string' ? [value] : value;
        this.updateView();
        // Get notified each time authentication state changes.
        this.principal.getAuthenticationState().subscribe(identity => this.updateView());
    }

    private updateView(): void {
        this.principal.hasAnyAuthority(this.authorities).then(result => {
            this.viewContainerRef.clear();
            if (!result) {
                this.viewContainerRef.createEmbeddedView(this.templateRef);
            }
        });
    }
}
