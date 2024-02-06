import {Component, computed, effect, signal} from '@angular/core';
import {HelloWorldComponent} from "../../hello-world/hello-world.component";

@Component({
  selector: 'app-signal-demo',
  standalone: true,
  imports: [
    HelloWorldComponent,
  ],
  templateUrl: './signal-demo.component.html',
  styleUrl: './signal-demo.component.css'
})
export class SignalDemoComponent {
  //counter: number = 0;
  counter = signal(0);
  derivedCounter = computed(() => {

    return this.counter() * 10;

  })
  constructor() {
    effect(() => {
      // We just have to use the source signals
      // somewhere inside this effect
      const currentCount = this.counter();
      const derivedCounter = this.derivedCounter();

      console.log(`current values: ${currentCount}
    ${derivedCounter}`);

    });
  }
  ngOnInit()
  {

  }
  ngOnChanges()
  {
    console.log('OnChange');
  }
  increment() {
    //this.counter++;
    this.counter.set(this.counter() + 1);
  }
  ngDoCheck()
  {
    console.log('SignalDemoComponent DoCheck');
  }
  mouseOverHandler()
  {
    console.log('Mouse over');
  }
}
