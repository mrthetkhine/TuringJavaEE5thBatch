import {Component, Input} from '@angular/core';
import {Movie} from "../../models/movie.model";
import {Router} from "@angular/router";

@Component({
  selector: 'tr[app-movie-ui]',
  standalone: true,
  imports: [],
  templateUrl: './movie-ui.component.html',
  styleUrl: './movie-ui.component.css'
})
export class MovieUiComponent {
  @Input()
  movie!:Movie;



  constructor(private router:Router) {

  }

  gotoMovieDetails()
  {
    this.router.navigate(['movie-details',this.movie.id]);
  }
}
