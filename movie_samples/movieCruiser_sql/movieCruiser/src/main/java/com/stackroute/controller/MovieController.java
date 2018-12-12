package com.stackroute.controller;


import com.stackroute.domain.Movie;
import com.stackroute.exceptions.MovieAlreadyExistsException;
import com.stackroute.exceptions.MovieNotFoundException;
import com.stackroute.service.MovieService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="api/v1/movie")
public class MovieController {

    MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping("/")
    public ResponseEntity<?> saveMovie(@RequestBody Movie movie){
        ResponseEntity responseEntity;
        try{
            movieService.saveMovie(movie);
            responseEntity = new ResponseEntity<String>("Successfully Created", HttpStatus.CREATED);
        }catch (MovieAlreadyExistsException e){
            responseEntity = new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
            e.printStackTrace();
        }
        return responseEntity;
    }

    @GetMapping("/")
    public ResponseEntity<?>getAllMovies(){
        return new ResponseEntity<List<Movie>>(movieService.getAllMovies(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Movie getMovie(@PathVariable int id){

        Movie movie = new Movie();

        try{
            movie = movieService.getMovie(id);
        }
        catch(MovieNotFoundException e ) {
            e.printStackTrace();
        }

        return movie;
    }

    @PutMapping(value = "/{id}")
    public void updateMovies(@RequestBody Movie movie, @PathVariable int id){
        try{
            movieService.updateMovie(movie,id);
        }
        catch(MovieNotFoundException e ) {
            e.printStackTrace();
        }
    }


    @DeleteMapping(value = "/{id}")
    public void deleteMovies(@PathVariable int id){
        try{
            movieService.deleteMovie(id);
        }
        catch(MovieNotFoundException e ) {
            e.printStackTrace();
        }
    }

};