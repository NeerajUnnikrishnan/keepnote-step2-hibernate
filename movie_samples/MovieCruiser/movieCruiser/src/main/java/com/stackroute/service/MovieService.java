package com.stackroute.service;

import com.stackroute.domain.Movie;
import com.stackroute.exceptions.MovieAlreadyExistsException;
import com.stackroute.exceptions.MovieNotFoundException;

import java.util.List;

public interface MovieService {

     Movie saveMovie(Movie movie) throws MovieAlreadyExistsException;
     List<Movie> getAllMovies();
     Movie getMovie(int id) throws MovieNotFoundException;
     List<Movie> findMovieByName(String movieName);
     Movie deleteMovie(int id)throws MovieNotFoundException;
     Movie updateMovie(Movie movie, int id) throws MovieNotFoundException;

}
