import { Injectable } from '@angular/core';
import {Todo} from "../models/todo.model";
import {BehaviorSubject, Observable} from "rxjs";
import {Movie} from "../models/movie.model";
import {HttpClient} from "@angular/common/http";
import {BASE_URL} from "./Api";

@Injectable({
  providedIn: 'root'
})
export class MovieService {
  private _movieData:Array<Movie> = [];
  private _movies: BehaviorSubject<Array<Movie>> = new BehaviorSubject<Array<Movie>>([]);
  public readonly movies: Observable<Array<Movie>> = this._movies.asObservable();
  constructor(private http:HttpClient) {
    this.loadAllMovies();
  }
  loadAllMovies()
  {
    this.http.get<Movie[]>(BASE_URL+`/api/movies`)
      .subscribe(movies=>{
        this._movieData = movies;
        this.emitChange();
      })
  }
  private emitChange() {
    this._movies.next(this._movieData);
  }
}
