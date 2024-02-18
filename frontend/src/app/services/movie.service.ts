import { Injectable } from '@angular/core';
import {Todo} from "../models/todo.model";
import {BehaviorSubject, Observable} from "rxjs";
import {Movie} from "../models/movie.model";
import {HttpClient} from "@angular/common/http";
import {BASE_URL} from "./Api";

const API  = BASE_URL+"/api/movies";
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
    this.http.get<Movie[]>(API)
      .subscribe(movies=>{
        this._movieData = movies;
        this.emitChange();
      })
  }
  private emitChange() {
    this._movies.next(this._movieData);
  }
  saveMovie(movie:Movie)
  {
    return this.http.post<Movie>(API,movie).subscribe(movie=>{
      this.addMovie(movie);
    });
  }
  addMovie(movie:Movie)
  {
    this._movieData.push(movie);
    this.emitChange();
  }
  _deleteMovie(movie:Movie)
  {
    this._movieData = this._movieData.filter(m=>movie.id!=m.id);
    this.emitChange();
  }

  deleteMovie(movie:Movie,callback:()=>void )
  {
    this.http.delete<Movie>(API+"/"+movie.id).subscribe((m:Movie)=>{
      this._deleteMovie(movie);
      callback();
    });
  }
}
