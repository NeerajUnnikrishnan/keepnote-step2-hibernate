import { Input } from './input';

import { Injectable } from '@angular/core';
import { Movie } from './movie';
import { Observable, of } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class MovieService {

  private url: string;
  private returnedObj : Object;
  constructor(private http:HttpClient){} 

  getMovies (movieName): Observable<Input> {
    // this.url  = "http://www.omdbapi.com/?s=superman&apikey=54cc5fda"; 
    let preomdburl = "http://www.omdbapi.com/?s=";
    let postomdburl = "&type=movie&apikey=54cc5fda"
    this.url = `${preomdburl}${movieName}${postomdburl}`;
    // return this.http.get<Input>(this.url);
    this.http.get(this.url).subscribe(
      data => {
        console.log("get Request is successful ", data);
        this.returnedObj = data;
      },
      error => {
        console.log("Error", error);
      });
    console.log("hii");
    console.log(this.returnedObj);
    return this.http.get<Input>(this.url);
  }
  
  
//  getMovie(id: number): Observable<Movie> {
  //   // TODO: send the message _after_ fetching the hero
  //   return of(MOVIES.find(movie => movie.id === id));
  // }
}