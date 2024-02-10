import { Component } from '@angular/core';
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-second-page',
  standalone: true,
  imports: [],
  templateUrl: './second-page.component.html',
  styleUrl: './second-page.component.css'
})
export class SecondPageComponent {
  constructor(private route: ActivatedRoute) {}
  ngOnInit() {
    const query = this.route.snapshot.queryParamMap.get('query');
    console.log('query ',query);
  }
}
