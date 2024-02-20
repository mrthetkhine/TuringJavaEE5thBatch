import {Component, Input} from '@angular/core';
import {MovieService} from "../../services/movie.service";
import {Movie} from "../../models/movie.model";
import {MovieDetailsUIComponent} from "../movie-details-ui/movie-details-ui.component";
import {Review} from "../../models/review.model";
import {ReviewService} from "../../services/review.service";
import {CommonModule} from "@angular/common";

@Component({
  selector: 'app-movie-details',
  standalone: true,
  imports: [
    MovieDetailsUIComponent,
    CommonModule,
  ],
  templateUrl: './movie-details.component.html',
  styleUrl: './movie-details.component.css'
})
export class MovieDetailsComponent {
  @Input() id!:string;

  movie!:Movie;
  reviews:Array<Review> = [];
  constructor(private movieService:MovieService,public reviewService:ReviewService) {
  }
  ngOnInit(){
    console.info("id:",this.id);

    let data:any = this.movieService.getMovieById(this.id) ;
    if(data)
    {
      this.movie = data;
      this.reviewService.loadAllReviewByMovieId(this.movie.id||'');
      this.reviewService.reviews.subscribe(reviews=>{
        this.reviews = reviews;
        console.log('Review ',this.reviews);
      });
    }
    console.log('Movie ',this.movie);

  }



}
