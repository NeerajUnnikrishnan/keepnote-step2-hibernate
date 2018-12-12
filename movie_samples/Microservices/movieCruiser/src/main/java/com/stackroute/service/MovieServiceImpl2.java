//package com.stackroute.service;
//
//import com.stackroute.domain.Movie;
//import com.stackroute.exceptions.MovieAlreadyExistsException;
//import com.stackroute.exceptions.MovieNotFoundException;
//import com.stackroute.repository.MovieRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import java.util.List;
//
//@Service
//public class MovieServiceImpl2 implements  MovieService{
//
//    MovieRepository movieRepository;
//
//    @Autowired
//    public MovieServiceImpl2(MovieRepository movieRepository){
//        this.movieRepository = movieRepository;
//        System.out.println("Secondary is running");
//    }
//
//    @Override
//    public Movie saveMovie(Movie movie) throws MovieAlreadyExistsException {
//        if(movieRepository.existsById(movie.getId())){
//            throw new MovieAlreadyExistsException("Movie Already Exists");
//        }
//        Movie savedMovie = movieRepository.save(movie);
//
//        if(savedMovie == null){
//            throw new MovieAlreadyExistsException("Movie Already Exists");
//        }
//        return savedMovie;
//    }
//
//    @Override
//    public List<Movie> getAllMovies(){
//        return movieRepository.findAll();
//    }
//
//    @Override
//    public Movie getMovie(int id) throws MovieNotFoundException {
//        if(!movieRepository.existsById(id)){
//            throw new MovieNotFoundException("Movie not Found");
//        }
//        return movieRepository.findById(id).get();
//    }
//
//    @Override
//    public List<Movie> findMovieByName(String name){
//        List<Movie> movieList = movieRepository.findBymovieName(name);
//        return movieList;
//    }
//
//    @Override
//    public void deleteMovie(int id) throws MovieNotFoundException{
//        if(!movieRepository.existsById(id)){
//            throw new MovieNotFoundException("Movie not Found");
//        }
//        movieRepository.deleteById(id);
//    }
//
//    @Override
//    public void updateMovie(Movie movie, int id) throws MovieNotFoundException{
//
//        if(!movieRepository.existsById(id)){
//            throw new MovieNotFoundException("Movie not Found");
//        }
//        movieRepository.save(movie);
//    }
//
//}
