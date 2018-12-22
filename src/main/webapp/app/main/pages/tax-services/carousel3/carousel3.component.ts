import { Component, OnInit } from '@angular/core';
import { NgbCarouselConfig } from '@ng-bootstrap/ng-bootstrap';

@Component({
    selector: 'ezkr-carousel3',
    templateUrl: './carousel3.component.html',
    styleUrls: ['./carousel3.component.scss'],
    providers: [NgbCarouselConfig]
})
export class Carousel3Component implements OnInit {

    images = [1, 2, 3, 4].map(() => `https://picsum.photos/900/500?random&t=${Math.random()}`);

    constructor(config: NgbCarouselConfig) {
        // customize default values of carousels used by this component tree
        config.interval = 10000;
        config.wrap = false;
        config.keyboard = false;
        config.pauseOnHover = false;
    }

    ngOnInit() {
    }

}
