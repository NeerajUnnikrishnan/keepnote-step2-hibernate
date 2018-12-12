package com.stackroute.controller;


import com.stackroute.domain.Movie;
import com.stackroute.exceptions.MovieAlreadyExistsException;
import com.stackroute.exceptions.MovieNotFoundException;
import com.stackroute.service.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value="movie-api/v1/movie")
@CrossOrigin(origins="http://localhost:4210",maxAge = 3600)
public class MovieController {

    MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;

    }


    @PostMapping("/")
    public ResponseEntity<?> saveMovie(@RequestBody @Valid Movie movie){
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
    public ResponseEntity<?>getMovie(@PathVariable int id){

        ResponseEntity responseEntity;

        try{
            responseEntity = new ResponseEntity<>(movieService.getMovie(id), HttpStatus.OK);

        }
        catch(MovieNotFoundException e ) {
            responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
            e.printStackTrace();
        }

        return responseEntity;
    }


    @GetMapping("/{movieName}")
    public ResponseEntity<?>findMovieByName(@PathVariable String movieName){

        List<Movie> movieList = new ArrayList<Movie>();
        movieList = movieService.findMovieByName(movieName);

        return new ResponseEntity<List<Movie>>(movieList,HttpStatus.OK);
    }


    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateMovies(@RequestBody @Valid Movie movie, @PathVariable  int id){

        ResponseEntity responseEntity;

        try{
            movieService.updateMovie(movie,id);
            responseEntity = new ResponseEntity<>("Movie Updated", HttpStatus.OK);
        }
        catch(MovieNotFoundException e ) {

            e.printStackTrace();
            responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }

        return responseEntity;
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteMovie(@PathVariable int id){

        ResponseEntity responseEntity;

        try{
            movieService.deleteMovie(id);
            responseEntity = new ResponseEntity<>("Movie Deleted", HttpStatus.OK);
        }
        catch(MovieNotFoundException e ) {
            e.printStackTrace();
            responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

};