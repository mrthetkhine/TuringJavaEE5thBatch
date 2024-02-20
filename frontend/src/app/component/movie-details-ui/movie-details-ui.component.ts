import {Component, Input} from '@angular/core';
import {Movie} from "../../models/movie.model";
import {CommonModule} from "@angular/common";
import {Review} from "../../models/review.model";
import {ReviewService} from "../../services/review.service";

@Component({
  selector: 'app-movie-details-ui',
  standalone: true,
  imports: [
    CommonModule,
  ],
  templateUrl: './movie-details-ui.component.html',
  styleUrl: './movie-details-ui.component.css'
})
export class MovieDetailsUIComponent {
  @Input()
  movie!:Movie;


}
