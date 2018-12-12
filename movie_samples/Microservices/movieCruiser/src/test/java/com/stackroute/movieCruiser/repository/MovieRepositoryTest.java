package com.stackroute.movieCruiser.repository;

import com.stackroute.domain.Movie;
import com.stackroute.repository.MovieRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
@RunWith(SpringRunner.class)
@DataMongoTest
public class MovieRepositoryTest {

    @Autowired
    MovieRepository movieRepository;
    Movie movie;

    @Before
    public void setUp()
    {
        movie = new Movie();
        movie.setId(1);
        movie.setMovieName("stree");
        movie.setRating(4);
        movie.setComments("sdsds");

    }

    @Test
    public void testSaveMovie(){
        movieRepository.save(movie);
        Movie fetchMovie = movieRepository.findById(movie.getId()).get();
        Assert.assertEquals(1,fetchMovie.getId());

    }

    @Test
    public void testSaveMovieFailure(){
        Movie testMovie = new Movie(1,"john",3,"Harry123");
        movieRepository.save(testMovie);
        Movie fetchMovie = movieRepository.findById(movie.getId()).get();
        Assert.assertNotSame(movie,fetchMovie);
    }

    @Test
    public void testGetAllMovie(){
        Movie m1 = new Movie(1,"shtree",3,"Harry123");
        Movie m2 = new Movie(2,"sasi",3,"Harry123");
        movieRepository.save(m1);
        movieRepository.save(m2);

        List<Movie> list = movieRepository.findAll();
        Assert.assertEquals("shtree",list.get(0).getMovieName());

    }
    @Test
    public void testGetMovie(){
        Movie movie = new Movie(1,"shtree",3,"Harry123");
        movieRepository.save(movie);

        Movie savedMovie =  movieRepository.findById(movie.getId()).get();;
        Assert.assertEquals("shtree",savedMovie.getMovieName());

    }

    @Test
    public void testFindMovieByName(){
        Movie movie1 = new Movie(1,"shtree",3,"Harry123");
        Movie movie2 = new Movie(2,"shtree",3,"Harry123");
        movieRepository.save(movie1);
        movieRepository.save(movie2);
        List<Movie> movieList = movieRepository.findAll();

        Assert.assertEquals("shtree",movieList.get(0).getMovieName());

    }
    @Test
    public void testUpdateMovie(){
        Movie testMovie = new Movie(1,"venom",3,"sfsdfsdfs");
        movieRepository.save(testMovie);

        Assert.assertEquals(movieRepository.findById(testMovie.getId()).get().getMovieName(),testMovie.getMovieName());
    }

    @Test
    public void testUpdateMovieFailure(){
        Movie testMovie = new Movie(1,"venom",3,"sfsdfsdfs");
        movieRepository.save(testMovie);

        Assert.assertEquals(movieRepository.findById(testMovie.getId()).get().getMovieName(),testMovie.getMovieName());
    }

    @Test
    public void testDeleteMovie(){
        Movie testMovie = new Movie(7,"venom",3,"sfsdfsdfs");
        movieRepository.save(testMovie);
        movieRepository.deleteById(testMovie.getId());

        Assert.assertFalse(movieRepository.existsById(testMovie.getId()));
    }

    @Test
    public void testDeleteMovieFailure(){
        Movie testMovie = new Movie(7,"venom",3,"sfsdfsdfs");
        movieRepository.save(testMovie);
        movieRepository.deleteById(testMovie.getId());

        Assert.assertFalse(movieRepository.existsById(testMovie.getId()));
    }

}