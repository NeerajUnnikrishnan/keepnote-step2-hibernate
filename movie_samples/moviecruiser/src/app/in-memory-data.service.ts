import { InMemoryDbService } from 'angular-in-memory-web-api';
import { Movie } from './movie';

export class InMemoryDataService implements InMemoryDbService {
  createDb() {
   const MOVIES: Movie[] = [
      { id: 1, movieName: 'movie1', rating: 3, comments: 'good' },
      { id: 2, movieName: 'movie2', rating: 3, comments: 'good' },
      { id: 3, movieName: 'movie3', rating: 3, comments: 'good' },
      { id: 4, movieName: 'movie4', rating: 3, comments: 'good' },
      { id: 5, movieName: 'movie5', rating: 3, comments: 'good' },
      { id: 6, movieName: 'movie6', rating: 3, comments: 'good' },
      { id: 7, movieName: 'movie7', rating: 3, comments: 'good' },
      { id: 8, movieName: 'movie8', rating: 3, comments: 'good' },
      { id: 9, movieName: 'movie9', rating: 3, comments: 'good' },
      { id: 10, movieName: 'movie10', rating: 3, comments: 'good' }
    ];
    return {MOVIES};
  }

  // Overrides the genId method to ensure that a hero always has an id.
  // If the heroes array is empty,
  // the method below returns the initial number (11).
  // if the heroes array is not empty, the method below returns the highest
  // hero id + 1.
  genId(movies: Movie[]): number {
    return movies.length > 0 ? Math.max(...movies.map(movie => movie.id)) + 1 : 11;
  }
}