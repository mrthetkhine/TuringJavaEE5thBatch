import {Component, inject, TemplateRef, ViewChild} from '@angular/core';
import {FormArray, FormBuilder, FormGroup, ReactiveFormsModule, Validators} from "@angular/forms";
import {MovieService} from "../../services/movie.service";
import {NgbModal, NgbModalRef} from "@ng-bootstrap/ng-bootstrap";
import {CommonModule} from "@angular/common";
import {Movie} from "../../models/movie.model";

@Component({
  selector: 'app-movie-form',
  standalone: true,
  imports: [
    CommonModule,
    ReactiveFormsModule,
  ],
  templateUrl: './movie-form.component.html',
  styleUrl: './movie-form.component.css'
})
export class MovieFormComponent {
  @ViewChild('content', { static: false }) private content:any;
  private modalService = inject(NgbModal);
  closeResult = '';
  modalDialog !: NgbModalRef;
  editMode =false;
  movieToEdit! :Movie;
  movieForm = this.fb.group({
    name:['', [Validators.required,Validators.minLength(3),Validators.maxLength(15)]],
    year: [0, [Validators.required]],
    director : ['', [Validators.required]],
    details : ['', [Validators.required]],
    genres:this.fb.array([
      this.fb.control('')
    ]),
    actors: this.fb.array([
      //this.fb.control('')
      this.createItem()
    ])
  });
  createItem(): FormGroup {
    return this.fb.group({
      firstName: [''],
      lastName: ['']
    });
  }

  constructor(private fb:FormBuilder,
              private movieService:MovieService) {

  }

  open(content: TemplateRef<any>) {
    //this.movieForm.reset();
    if(this.editMode==false)
    {
      this.movieForm.reset();
    }
    this.modalDialog = this.modalService.open(content, {  size: 'lg' ,ariaLabelledBy: 'modal-basic-title' });

  }


  get name()
  {
    return this.movieForm.controls.name;
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
  get actors() {
    return this.movieForm.get('actors') as FormArray;
  }
  addNewActor()
  {
    this.actors.push(this.createItem());
  }
  get genres() {
    return this.movieForm.get('genres') as FormArray;
  }
  addNewGenre()
  {
    this.genres.push(this.fb.control(''));
  }
  openDialogForNew()
  {
    this.editMode = false;
    this.open(this.content);
  }
  showEditDialog(movie:Movie)
  {
    this.editMode = true;
    this.movieToEdit = movie;

    this.patchGenres(movie);
    this.patchActor(movie);

    //console.log('Actors ',this.actors);
    this.movieForm.patchValue({
      name: movie.name,
      year:movie.year,
      director:movie.director,
      details:movie.details.details,
      //genres: movie.genres,
      //actors:movie.actors,
    });
    this.open(this.content);
  }

  private patchGenres(movie: Movie) {
    this.genres.controls = [];
    if (movie.genres) {

      movie.genres.forEach(() => {
        this.genres.push(this.fb.control(''));
      });
      this.movieForm.patchValue({
        genres: movie.genres,
      })
    }
  }

  private patchActor(movie: Movie) {
    this.actors.controls = [];
    if (movie.actors) {

      movie.actors.forEach(() => {
        this.actors.push(this.createItem());
      })

      this.movieForm.patchValue({
        actors: movie.actors,
      })
    }
  }

  saveOrUpdateMovie()
  {
    console.log('Save Movie ',this.movieForm.value);
    let json = this.movieForm.value;
    let movie:any = {
      ...json,
      details: {
        details:json.details
      }
    }

    if(this.editMode==false)
    {
      console.log('save movie ',movie);
      this.movieService.saveMovie(movie);
    }
    else
    {
      this.updateMovie(movie);
    }
    this.modalDialog.close();
  }

  private updateMovie(movie: any) {
    movie.id = this.movieToEdit.id;
    //for actors
    if (this.movieToEdit.actors) {
      for (let i = 0; i < this.movieToEdit.actors.length; i++) {
        movie.actors[i].id = this.movieToEdit.actors[i].id;
      }
    }
    console.log('update movie ', movie);
    this.movieService.updateMovie(movie);
    //update
  }

  onSubmit()
  {
    console.log('Movie ',this.movieForm.value);
  }
}
