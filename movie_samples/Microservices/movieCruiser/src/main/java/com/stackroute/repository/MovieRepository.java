package com.stackroute.repository;

import com.stackroute.domain.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MovieRepository extends MongoRepository<Movie, Integer> {

  //  @Query("SELECT movie FROM Movie movie WHERE movie.movieName = :movieName")
    List<Movie> findBymovieName(String movieName);
}
