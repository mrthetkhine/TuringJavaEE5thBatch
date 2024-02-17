import {Component, inject, TemplateRef} from '@angular/core';
import {Movie} from "../../models/movie.model";
import {CommonModule} from "@angular/common";
import {MovieUiComponent} from "../../component/movie-ui/movie-ui.component";
import {Router} from "@angular/router";
import {ModalDismissReasons, NgbModal, NgbModalRef} from "@ng-bootstrap/ng-bootstrap";
import {FormBuilder, ReactiveFormsModule, Validators} from "@angular/forms";
import {MovieService} from "../../services/movie.service";

@Component({
  selector: 'app-movies-list',
  standalone: true,
  imports: [
    CommonModule,
    MovieUiComponent,
    ReactiveFormsModule,
  ],
  templateUrl: './movies-list.component.html',
  styleUrl: './movies-list.component.css'
})
export class MoviesListComponent {

  movies:Array<Movie> = [
    {
      "id": "65786a3c3d81ae6743e5af1c",
      "name": "Titanic",
      "year": 2009,
      "director": "Jame Cameron",
      "details": {
        "id": null,
        "details": "Movie 1 details"
      },
      "genres": null,
      "actors": [
        {
          "id": "657868667fdcb23c8e616359",
          "firstName": "Leonardo",
          "lastName": "Dicaprio"
        },
        {
          "id": "657868c237346e26caace809",
          "firstName": "Kate",
          "lastName": "Winselt"
        }
      ]
    },
    {
      "id": "65786c0cf5309b4b72942321",
      "name": "Inception",
      "year": 2010,
      "director": "Chrisopher Nolan",
      "details": {
        "id": null,
        "details": "Good sci-fi-movies"
      },
      "genres": [
        "Sci-Fi",
        "Drama"
      ],
      "actors": [
        {
          "id": "657868667fdcb23c8e616359",
          "firstName": "Leonardo",
          "lastName": "Dicaprio"
        },
        {
          "id": "65786b944df196549f9f1ec4",
          "firstName": "Elliot",
          "lastName": "Page"
        }
      ]
    },
    {
      "id": "657a99a30d1be4109906df11",
      "name": "Movie 3 with manual reference",
      "year": 2010,
      "director": "Chrisopher Nolan",

      "details": {
        "id": null,
        "details": "Good sci-fi-movies"
      },
      "genres": null,
      "actors": []
    },
    {
      "id": "65a285a8b9314f6b792a95ac",
      "name": "Movie 4",
      "year": 2005,
      "director": "Director 4",

      "details": {
        "id": null,
        "details": "This movie test our collection mapping"
      },
      "genres": null,
      "actors": [
        {
          "id": "65a285a8b9314f6b792a95aa",
          "firstName": "Actor 1 for movie 5 updated",
          "lastName": "Decaprio"
        },
        {
          "id": "65a285a8b9314f6b792a95ab",
          "firstName": "Kate",
          "lastName": "Winslect"
        }
      ]
    },
    {
      "id": "65a28625b9314f6b792a95ad",
      "name": "Movie 5",
      "year": 2005,
      "director": "Director 5",

      "details": {
        "id": null,
        "details": "This movie test our collection mapping"
      },
      "genres": null,
      "actors": [
        {
          "id": "65a285a8b9314f6b792a95aa",
          "firstName": "Actor 1 for movie 5 updated",
          "lastName": "Decaprio"
        },
        {
          "id": "65a285a8b9314f6b792a95ab",
          "firstName": "Kate",
          "lastName": "Winslect"
        }
      ]
    }
  ];
  private modalService = inject(NgbModal);
  closeResult = '';
  modalDialog !: NgbModalRef;

  movieForm = this.fb.group({
    title:['', [Validators.required,Validators.minLength(3),Validators.maxLength(10)]],
    year: [0, [Validators.required]],
    director : ['', [Validators.required]],
    details : ['', [Validators.required]],
  });
  constructor(private fb:FormBuilder,
              private movieService:MovieService) {
    this.movieService.movies.subscribe(movies=>{
      console.log(movies);
    });
  }
  open(content: TemplateRef<any>) {
    this.movieForm.reset();
    this.modalDialog = this.modalService.open(content, {  size: 'lg' ,ariaLabelledBy: 'modal-basic-title' });

  }

  saveMovie()
  {
    console.log('Save Movie ',this.movieForm.value);
    this.modalDialog.close();
  }
  get title()
  {
    return this.movieForm.controls.title;
  }
  get year()
  {
    return this.movieForm.controls.year;
  }
  get director()
  {
    return this.movieForm.controls.director;
  }
  get details()
  {
    return this.movieForm.controls.details;
  }
  onSubmit()
  {
    console.log('Movie ',this.movieForm.value);
  }
}
