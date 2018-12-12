import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Movie } from '../movie.modal';
import { MovieService } from '../movie.service';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent implements OnInit {

  id:number;
  movie:Movie;
  constructor(private activatedroute:ActivatedRoute,private movieService:MovieService,private router:Router) { }

  ngOnInit() {
    this.activatedroute.params.subscribe(params =>{
      this.id=params['id'];
      console.log(this.id);
    })
  }
  updateComment(comments:string){
    this.movie=new Movie();
    this.movie.comments=comments;
    this.movie.id=this.id;
    this.movieService.updateMovie(this.id,this.movie).subscribe(data => {
      console.log("Successfully Updated");
      this.router.navigate(["/Wish-List"]);
    })
  }

}
