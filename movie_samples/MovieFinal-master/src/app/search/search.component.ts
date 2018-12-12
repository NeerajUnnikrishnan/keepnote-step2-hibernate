import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  movies = [];

  input = "";
  url="https://api.themoviedb.org/3/search/movie?api_key=a11a51e2627becc9456d9ef4db35443f&query=";

  constructor(private http:HttpClient,private activatedRoute : ActivatedRoute) { }

  ngOnInit() {
    this.activatedRoute.params.subscribe(params => {
      this.input=params['input'];
      this.url = this.url + this.input;
      this.getMovies(this.url).subscribe(data => {
        this.movies=data.results;
      })
    })
  }

  getMovies(url:string) : Observable<any>{
    return this.http.get(url);
  }

}
