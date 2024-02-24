import {Component, EventEmitter, Input, Output} from '@angular/core';
import {Movie} from "../../models/movie.model";
import {Review} from "../../models/review.model";
import Swal from 'sweetalert2'
import {NgbRatingConfig, NgbRatingModule} from "@ng-bootstrap/ng-bootstrap";
import {ReviewService} from "../../services/review.service";

@Component({
  selector: 'app-review',
  standalone: true,
  imports: [NgbRatingModule],
  templateUrl: './review.component.html',
  styleUrl: './review.component.css',
  providers:[NgbRatingConfig]
})
export class ReviewComponent {
  @Input()
  review!:Review;

  @Output()
  onEditClick = new EventEmitter<Review>();

  constructor(config: NgbRatingConfig,
              private reviewService:ReviewService) {
    config.max = 5;
  }

  showDeleteDialog()
  {
    console.log('Show delete');
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
        console.log('Delete ',this.review);
        this.reviewService.deleteReview(this.review,()=>{
          console.log('Review deleted');
        });
      }
    });
  }
  showEditDialog()
  {
    console.log('Show edit dialog');
    this.onEditClick.emit(this.review);
  }
}
