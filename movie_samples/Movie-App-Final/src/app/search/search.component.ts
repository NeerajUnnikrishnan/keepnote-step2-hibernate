import { Component, OnInit,Input } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  movieList=[];
  newUrl='';
  input:string='';
  url="https://api.themoviedb.org/3/search/movie?api_key=1974ee8d9f7599f8c6d5f5a2bdc2a403&query=";

  constructor(private http:HttpClient,private activatedRoute:ActivatedRoute) { }

  ngOnInit() {
    this.activatedRoute.params.subscribe(params =>{
      this.input=params['input'];
      console.log(this.input);
      this.newUrl=this.url+this.input;
      console.log(this.newUrl);
      this.getResultMovies(this.newUrl).subscribe(data =>{
        this.movieList=data.results;
        console.log(this.movieList);
    })
    });
    
  }
  getResultMovies(argUrl:string):Observable<any>{
    return this.http.get(argUrl);
  }

}
