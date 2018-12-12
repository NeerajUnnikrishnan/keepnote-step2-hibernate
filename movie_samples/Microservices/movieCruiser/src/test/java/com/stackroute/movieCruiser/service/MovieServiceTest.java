package com.stackroute.movieCruiser.service;

import com.stackroute.domain.Movie;
import com.stackroute.exceptions.MovieAlreadyExistsException;
import com.stackroute.exceptions.MovieNotFoundException;
import com.stackroute.repository.MovieRepository;
import com.stackroute.service.MovieServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MovieServiceTest {

    Movie movie;

    //Create a mock for UserRepository
    @Mock//test doubleUserRepository userRepository;
    MovieRepository movieRepository;
    //Inject the mocks as dependencies into UserServiceImpl
    @InjectMocks
    MovieServiceImpl movieService;
    List<Movie> list= null;


    @Before
    public void setUp(){
        //Initialising the mock object
        MockitoAnnotations.initMocks(this);
        movie = new Movie();
        movie.setMovieName("John");
        movie.setId(1);
        movie.setComments("Jenny");
        movie.setRating(3);
        list = new ArrayList<>();
        list.add(movie);
    }
    @Test
    public void saveMovieTestSuccess() throws MovieAlreadyExistsException {

        when(movieRepository.save((Movie)any())).thenReturn(movie);
        Movie savedMovie = movieService.saveMovie(movie);
        Assert.assertEquals(movie,savedMovie);

        //verify here verifies that userRepository save method is only called once
        verify(movieRepository,times(1)).save(movie);

    }

    @Test(expected = MovieAlreadyExistsException.class)
    public void saveMovieTestFailure() throws MovieAlreadyExistsException {
        when(movieRepository.save((Movie)any())).thenReturn(null);
        Movie savedMovie = movieService.saveMovie(movie);
        System.out.println("savedMovie" + savedMovie);
        Assert.assertEquals(movie,savedMovie);
   }
    @Test
    public void getAllMoviesTest(){

        //stubbing the mock to return specific data
        when(movieRepository.findAll()).thenReturn(list);
        List<Movie> movieList = movieService.getAllMovies();
        Assert.assertEquals(list,movieList);
        System.out.println(movieRepository.existsById(1));

    }
    @Test
    public void findMovieByNameTest()throws MovieNotFoundException {

        //stubbing the mock to return specific data
        when(movieRepository.findBymovieName(movie.getMovieName())).thenReturn(list);
        List<Movie> movieList = movieService.findMovieByName(movie.getMovieName());
        Assert.assertEquals(movie,movieList.get(0));

    }
    @Test
    public void updateMovieTest()throws MovieNotFoundException,MovieAlreadyExistsException {

        Movie updatedMovie = new Movie(1,"venom",3,"sdsdsd");

        when(movieRepository.save((Movie)any())).thenReturn(updatedMovie);
        when(movieRepository.existsById(updatedMovie.getId())).thenReturn(true);
        Movie fetchMovie = movieService.updateMovie(updatedMovie,updatedMovie.getId());
//        System.out.println("savedMovie" + updatedMovie);
        Assert.assertEquals(fetchMovie,updatedMovie);


        //verify here verifies that userRepository save method is only called once
//        verify(movieRepository,times(1)).save(movie);
    }

    @Test
    public void deleteMovieTest()throws MovieNotFoundException,MovieAlreadyExistsException {


        Movie updatedMovie = new Movie(1,"venom",3,"sdsdsd");

        when(movieRepository.save((Movie)any())).thenReturn(updatedMovie);
        when(movieRepository.existsById(updatedMovie.getId())).thenReturn(true);

        movieService.deleteMovie(updatedMovie.getId());


        verify(movieRepository, times(1)).deleteById(any(Integer.class));

    }




}