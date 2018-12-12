import { Hero } from '../movie';
import { Component, OnInit } from '@angular/core';
import { HeroService } from '../movie.service';

@Component({
  selector: 'app-heroes',
  templateUrl: './heroes.component.html',
  styleUrls: ['./heroes.component.css']
})
export class HeroesComponent implements OnInit {

  heroes: Hero[];
 
  constructor(private heroService: HeroService) { }

  ngOnInit() {
    this.getHeroes();
  }
  
 
  getHeroes(): void {
    this.heroService.getHeroes()
        .subscribe(heroes => this.heroes = heroes);
  }
}
