import {Component, inject, Input, TemplateRef, ViewChild} from '@angular/core';
import {MovieService} from "../../services/movie.service";
import {Movie} from "../../models/movie.model";
import {MovieDetailsUIComponent} from "../movie-details-ui/movie-details-ui.component";
import {Review} from "../../models/review.model";
import {ReviewService} from "../../services/review.service";
import {CommonModule} from "@angular/common";
import {ReviewComponent} from "../review/review.component";
import {Router} from "@angular/router";
import {FormBuilder, ReactiveFormsModule, Validators} from "@angular/forms";
import {NgbModal, NgbModalRef, NgbRatingConfig, NgbRatingModule} from "@ng-bootstrap/ng-bootstrap";

@Component({
  selector: 'app-movie-details',
  standalone: true,
  imports: [
    MovieDetailsUIComponent,
    CommonModule,
    ReviewComponent,
    ReactiveFormsModule,
    NgbRatingModule,
  ],
  templateUrl: './movie-details.component.html',
  styleUrl: './movie-details.component.css'
})
export class MovieDetailsComponent {
  @Input() id!:string;

  movie!:Movie;

  reviews:Array<Review> = [];
  rating=0;

  reviewToEdit!:Review;
  editMode = false;
  reviewForm = this.fb.group({
    review:['', [Validators.required,Validators.minLength(3),Validators.maxLength(15)]],
    //rating: [0, [Validators.required]],

    });

  @ViewChild('content', { static: false }) private content:any;
  private modalService = inject(NgbModal);
  closeResult = '';
  modalDialog !: NgbModalRef;

  constructor(private router:Router,
              private fb:FormBuilder,
              private config: NgbRatingConfig,
              private movieService:MovieService,
              public reviewService:ReviewService) {
    this.config.max = 5;
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
  open(content: TemplateRef<any>) {
    //this.movieForm.reset();
    this.modalDialog = this.modalService.open(content, {  size: 'lg' ,ariaLabelledBy: 'modal-basic-title' });
  }

  back()
  {
    this.router.navigate(['/movies']);
  }
  get review()
  {
    return this.reviewForm.controls.review;
  }

  showNewReviewModal()
  {
    console.log('Show new review modal');
    this.openDialogForNew();
  }
  openDialogForNew()
  {
    this.editMode = false;
    this.rating =0;
    this.reviewForm.reset();
    this.open(this.content);
  }
  openDialogForEdit(review:Review)
  {
    this.reviewToEdit= review;
    this.editMode = true;
    this.reviewForm.patchValue({
      review: review.review
    })
    this.open(this.content);
    this.rating = review.rating;
  }
  saveOrUpdateReview()
  {
    if(this.editMode)
    {
      this.updateNewReview();
    }
    else
    {
      this.saveNewReview();
    }

  }

  private saveNewReview() {
    let json: any = this.reviewForm.value;
    json.rating = this.rating;
    json.movieId = this.movie.id;
    console.log('json ', json);
    this.reviewService.saveReview(json);
    this.modalDialog.close();
  }
  private updateNewReview()
  {
    let json: any = this.reviewForm.value;
    json.id = this.reviewToEdit.id;
    json.rating = this.rating;
    json.movieId = this.movie.id;
    console.log('json ', json);
    this.reviewService.updateReview(json);
    this.modalDialog.close();
  }
  onEditReviewClick(review:Review)
  {
    console.log('Movie detial edit review ',review);
    this.openDialogForEdit(review);
  }
  onSubmit()
  {

  }
}
