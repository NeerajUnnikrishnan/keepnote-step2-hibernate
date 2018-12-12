import { Component, OnInit,Input } from '@angular/core';
import { Movie } from '../movie.modal';
import { MovieService } from '../movie.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-view-movie',
  templateUrl: './view-movie.component.html',
  styleUrls: ['./view-movie.component.css']
})
export class ViewMovieComponent implements OnInit {

  constructor(private movieservice:MovieService,private router:Router) { }

  addMovie:Movie;
  ngOnInit() {
  }
  @Input('movieList') movieList;

  addToWishList(movie){
    this.addMovie=new Movie();
    this.addMovie.id=movie.id;
    this.addMovie.movieName=movie.title; 
    this.addMovie.comments=movie.overview;
    this.addMovie.rating=1;

    this.movieservice.addMovie(this.addMovie).subscribe(data =>{
      console.log("Succesfully added to Wish-List");
      this.router.navigate(["/Wish-List"]);
    })

  }

}
