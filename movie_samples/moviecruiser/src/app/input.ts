import { Movie } from './movie';
import { InputMovie } from './input-movie';


export interface Input {
    Search: Array<InputMovie>;
    totalResults: string;
    Response: string;
  }