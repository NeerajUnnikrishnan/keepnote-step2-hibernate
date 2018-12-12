import { MOVIES } from './../mock-movies';
import { Component, OnInit } from '@angular/core';
import { Movie } from './../movie';
import { MovieService } from '../movie.service';

@Component({
  selector: 'app-cards',
  templateUrl: './cards.component.html',
  styleUrls: ['./cards.component.css']
})

export class CardsComponent implements OnInit {

  movies = MOVIES;
  constructor() { }

  ngOnInit() {
  }

}
