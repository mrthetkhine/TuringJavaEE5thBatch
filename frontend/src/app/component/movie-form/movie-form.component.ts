import {Component, inject, TemplateRef} from '@angular/core';
import {FormArray, FormBuilder, FormGroup, ReactiveFormsModule, Validators} from "@angular/forms";
import {MovieService} from "../../services/movie.service";
import {NgbModal, NgbModalRef} from "@ng-bootstrap/ng-bootstrap";
import {CommonModule} from "@angular/common";

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
  private modalService = inject(NgbModal);
  closeResult = '';
  modalDialog !: NgbModalRef;
  movieForm = this.fb.group({
    name:['', [Validators.required,Validators.minLength(3),Validators.maxLength(10)]],
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
    this.movieForm.reset();
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
  saveMovie()
  {
    console.log('Save Movie ',this.movieForm.value);
    let json = this.movieForm.value;
    let movie:any = {
      ...json,
      details: {
        details:json.details
      }
    }
    console.log('save movie ',movie);
    this.movieService.saveMovie(movie);
    this.modalDialog.close();
  }
  onSubmit()
  {
    console.log('Movie ',this.movieForm.value);
  }
}
