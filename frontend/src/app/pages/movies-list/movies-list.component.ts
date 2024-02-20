import {Component, ElementRef, inject, TemplateRef, ViewChild} from '@angular/core';
import {Movie} from "../../models/movie.model";
import {CommonModule} from "@angular/common";
import {MovieUiComponent} from "../../component/movie-ui/movie-ui.component";
import {Router} from "@angular/router";
import {ModalDismissReasons, NgbModal, NgbModalRef} from "@ng-bootstrap/ng-bootstrap";
import {FormArray, FormBuilder, FormGroup, ReactiveFormsModule, Validators} from "@angular/forms";
import {MovieService} from "../../services/movie.service";
import {MovieFormComponent} from "../../component/movie-form/movie-form.component";

@Component({
  selector: 'app-movies-list',
  standalone: true,
  imports: [
    CommonModule,
    MovieUiComponent,
    ReactiveFormsModule,
    MovieFormComponent,
  ],
  templateUrl: './movies-list.component.html',
  styleUrl: './movies-list.component.css'
})
export class MoviesListComponent {

  movies:Array<Movie> = [
  ];
  @ViewChild('movieForm') movieForm!: MovieFormComponent;

  constructor(
              private movieService:MovieService) {
    this.movieService.movies.subscribe(movies=>{
      console.log(movies);
      this.movies =movies;
    });
  }

  showEditDialog(movie:Movie)
  {
    //console.log('Show edit movie ',movie);
    this.movieForm.showEditDialog(movie);
    //console.log('Movieform ',this.movieForm);
  }
}
