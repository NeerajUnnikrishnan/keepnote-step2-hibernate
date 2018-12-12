import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MovieService {

  public url = "https://api.themoviedb.org/3/movie/upcoming?api_key=a11a51e2627becc9456d9ef4db35443f";
  //public localUrl = "https://localhost:4200

  constructor(private http: HttpClient) { }

  getMovies():Observable<any>{
    return this.http.get(this.url);
  }


}
