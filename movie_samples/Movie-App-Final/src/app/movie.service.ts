import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Movie } from './movie.modal';

@Injectable({
  providedIn: 'root'
})
export class MovieService {

  public _url="https://api.themoviedb.org/3/movie/upcoming?api_key=1974ee8d9f7599f8c6d5f5a2bdc2a403";
  public private_url="http://localhost:8080/movie-api/v1/movie";
  constructor(private http:HttpClient) { }

  getMovies():Observable<any>{
    return this.http.get(this._url);
  }
  addMovie(movie:Movie):Observable<any>{
    return this.http.post(this.private_url,movie);
  }
  getAllMovies():Observable<any>{
    return this.http.get(this.private_url);
  }
  deleteMovie(id:number):Observable<any>{
    return this.http.delete(this.private_url+"/"+id);
  }
  updateMovie(id:number,movie:Movie):Observable<any>{
    return this.http.put(this.private_url+"/"+id,movie);
  }

}
