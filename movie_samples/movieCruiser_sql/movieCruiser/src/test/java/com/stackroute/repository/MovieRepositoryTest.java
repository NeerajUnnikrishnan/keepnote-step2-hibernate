package com.stackroute.repository;

import com.stackroute.domain.Movie;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
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
    public void findBymovieName() {
    }

    @Test
    public void testSaveMovie(){
        movieRepository.save(movie);
        Movie fetchMovie = movieRepository.findById(movie.getId()).get();
        Assert.assertEquals(1,fetchMovie.getId());

    }

    @Test
    public void testSaveMovieFailure(){
        Movie testUser = new Movie(1,"john",3,"Harry123");
        movieRepository.save(movie);
        Movie fetchUser = movieRepository.findById(movie.getId()).get();
        Assert.assertNotSame(movie,fetchUser);
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
}