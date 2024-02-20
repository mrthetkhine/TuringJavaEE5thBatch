import {Component, EventEmitter, Input, Output} from '@angular/core';
import Swal from 'sweetalert2'
import {Movie} from "../../models/movie.model";
import {Router} from "@angular/router";
import {MovieService} from "../../services/movie.service";

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

  @Output() onEditClick = new EventEmitter<Movie>();

  constructor(private router:Router,
              private movieService:MovieService) {

  }

  gotoMovieDetails()
  {
    this.router.navigate(['movie-details',this.movie.id]);
  }
  showDeleteMovieDialog()
  {
    Swal.fire({
      title: "Are you sure?",
      text: "You won't be able to revert this!",
      icon: "warning",
      showCancelButton: true,
      confirmButtonColor: "#3085d6",
      cancelButtonColor: "#d33",
      confirmButtonText: "Yes, delete it!"
    }).then((result) => {
      if (result.isConfirmed) {
        console.log('Delete ',this.movie);
        this.movieService.deleteMovie(this.movie,this.deleteCallBack);
      }
    });

    //
  }
  deleteCallBack()
  {
    console.log('Successfully deleted');
    Swal.fire({
      title: "Deleted!",
      text: "Your movie has been deleted.",
      icon: "success"
    });
  }
  showEdit()
  {
    console.log('Show edit');
    this.onEditClick.emit(this.movie);
  }
}
