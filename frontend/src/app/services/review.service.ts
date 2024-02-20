import { Injectable } from '@angular/core';
import {BASE_URL} from "./Api";
import {HttpClient} from "@angular/common/http";
import {Movie} from "../models/movie.model";
import {Review} from "../models/review.model";
import {BehaviorSubject, Observable} from "rxjs";


const API  = BASE_URL+"/api/movies";
@Injectable({
  providedIn: 'root'
})
export class ReviewService {

  private _reviewData:Array<Review> = [];
  private _reviews: BehaviorSubject<Array<Review>> = new BehaviorSubject<Array<Review>>([]);
  public readonly reviews: Observable<Array<Review>> = this._reviews.asObservable();
  constructor(private http:HttpClient)
  {

  }
  loadAllReviewByMovieId(movieId:string)
  {
    this.http.get<Review[]>(API+`/${movieId}/reviews`)
      .subscribe(reviews=>{
        console.log('Subscribe ',reviews);
        this._reviewData = reviews;
        this.emitChange();
      })
  }
  private emitChange() {
    this._reviews.next(this._reviewData);
  }
}
