package com.stackroute;

import com.stackroute.domain.Movie;
import com.stackroute.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

@SpringBootApplication
public class movieCruiserApplication implements ApplicationListener<ContextRefreshedEvent> {

    public static void main(String[] args)
    {
        SpringApplication.run(movieCruiserApplication.class, args);
    }

    MovieRepository movieRepository;

    @Autowired
    public movieCruiserApplication(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent){
        movieRepository.save(new Movie(1,"name",3,"ssds"));
        movieRepository.save(new Movie(2,"name",3,"ssds"));
        movieRepository.save(new Movie(3,"name",3,"ssds"));
    }
}