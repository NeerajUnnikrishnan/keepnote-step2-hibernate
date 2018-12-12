import { MovieService } from './../movie.service';
import { MOVIES } from './../mock-movies';
import { Movie } from './../movie';;
import { Component, OnInit, Input } from '@angular/core';
import { InputMovie } from '../input-movie';
import { HttpClient, HttpHeaders } from '@angular/common/http';


@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {
  movieName: string ;
  @Input() selectedMovie : Movie;
  movies: Movie[] ;
  inputMovie: InputMovie[];

  constructor(private movieService: MovieService,private http:HttpClient) { }

  ngOnInit() {
      
    }

  onSearch(movieName: string): void{
    // this.movies = this.getMovies(movieName);
    // for(let movie of this.movies){
    //   if(movie.movieName == movieName){
    //     this.selectedMovie = movie;
    //   }
    // }
    let preomdburl = "http://www.omdbapi.com/?s=";
    let postomdburl = "&type=movie&apikey=54cc5fda"
    let url = `${preomdburl}${movieName}${postomdburl}`;
    // return this.http.get<Input>(this.url);
    console.log(this.http.get(url));
  }

  getMovies(movieName: string): Movie[] {
    this.movieService.getMovies(movieName)
          .subscribe((data) => {
            this.inputMovie = data.totalResults['Search'];});
    return this.movies;
  }
}
