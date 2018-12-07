import { Component, ElementRef, OnInit } from '@angular/core';
import { TweenMax } from 'gsap/TweenMax';

@Component({
    selector: 'ezkr-carousel2',
    templateUrl: './carousel2.component.html',
    styleUrls: ['./carousel2.component.scss']
})
export class Carousel2Component implements OnInit {

    private delay: any;

    constructor(private element: ElementRef) {
    }

    ngOnInit() {
        const cards = this.element.nativeElement.querySelectorAll('#card-slider .slider-item');
        this.startAnimation( Array.apply(null, cards));
    }

    startAnimation(array) {
        TweenMax.fromTo(array[0], 0.5, { x: 0, y: 0, opacity: 0.75 }, {
            x: 0,
            y: -120,
            opacity: 0,
            zIndex: 0,
            delay: 0.03,
            ease: Cubic.easeInOut,
            onComplete: this.sortArray(array)
        });

        TweenMax.fromTo(array[1], 0.5, { x: 79, y: 125, opacity: 1, zIndex: 1 }, {
            x: 0,
            y: 0,
            opacity: 0.75,
            zIndex: 0,
            boxShadow: '-5px 8px 8px 0 rgba(82,89,129,0.05)',
            ease: Cubic.easeInOut
        });

        TweenMax.to(array[2], 0.5, {
            bezier: [{ x: 0, y: 250 }, { x: 65, y: 200 }, { x: 79, y: 125 }],
            boxShadow: '-5px 8px 8px 0 rgba(82,89,129,0.05)',
            zIndex: 1,
            opacity: 1,
            ease: Cubic.easeInOut
        });

        TweenMax.fromTo(array[3], 0.5, { x: 0, y: 400, opacity: 0, zIndex: 0 }, {
            x: 0,
            y: 250,
            opacity: 0.75,
            zIndex: 0,
            ease: Cubic.easeInOut
        });

        TweenMax.fromTo(array[3], 0.5, { x: 0, y: 400, opacity: 0, zIndex: 0 }, {
            x: 0,
            y: 250,
            opacity: 0.75,
            zIndex: 0,
            ease: Cubic.easeInOut
        });
    }

    sortArray(array) {
        if (this.delay) {
            clearTimeout(this.delay);
        }

        const _this = this;
        this.delay = setTimeout(function() {
            array.push(array.shift());
            return _this.startAnimation(array);
        }, 50000);
    }

}
