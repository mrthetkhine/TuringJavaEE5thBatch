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
  saveReview(review:Review)
  {
    return this.http.post<Review>(API+`/${review.movieId}/reviews`,review).subscribe((savedReview:any)=>{
      this._saveReview(savedReview.data);
    });
  }
  _saveReview(review:Review)
  {
    this._reviewData.push(review);
    this.emitChange();
  }
  updateReview(review:Review)
  {
    this.http.put<Movie>(API+"/reviews/"+review.id,review).subscribe((review:any)=>{
      this._updateReview(review.data);
    });
  }
  _updateReview(review:Review)
  {
    this._reviewData = this._reviewData.map(m=>m.id== review.id?review: m);
    this.emitChange();
  }
  deleteReview(review:Review,callback:()=>void )
  {
    this.http.delete<Review>(API+"/reviews/"+review.id).subscribe((rev:any)=>{
      this._deleteReview(rev.data);
      callback();
    });
  }
  _deleteReview(review:Review)
  {
    this._reviewData = this._reviewData.filter(m=>review.id!=m.id);
    this.emitChange();
  }
}
