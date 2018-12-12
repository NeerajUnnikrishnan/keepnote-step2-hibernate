import { Component, OnInit } from '@angular/core';
import { MovieService } from '../movie.service';
import { Movie } from '../movie.modal';
import { Router } from '@angular/router';

@Component({
  selector: 'app-wishlist',
  templateUrl: './wishlist.component.html',
  styleUrls: ['./wishlist.component.css']
})
export class WishlistComponent implements OnInit {

  constructor(private movieService:MovieService,private router:Router) { }
  movieList=[];
  ngOnInit() {
    this.movieService.getAllMovies().subscribe(data =>{
      this.movieList=data;
      console.log(this.movieList);
    })
  }
  delete(movie:Movie){
    this.movieService.deleteMovie(movie.id).subscribe(data => {
      this.movieList=data;
      this.router.navigate(["/Wish-List"]);
    })
  }
  update(movie:Movie){
    this.router.navigate(["/update",movie.id]);
  }

}
