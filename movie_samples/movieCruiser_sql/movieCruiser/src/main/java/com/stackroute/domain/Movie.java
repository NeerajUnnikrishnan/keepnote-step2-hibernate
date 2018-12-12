package com.stackroute.domain;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Movie {

        @Id
        int id;
        String movieName;
        int rating;
        String comments;

    public Movie() {
    }

    public Movie(int id, String movieName, int rating, String comments) {
        this.id = id;
        this.movieName = movieName;
        this.rating = rating;
        this.comments = comments;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", movieName='" + movieName + '\'' +
                ", rating=" + rating +
                ", comments='" + comments + '\'' +
                '}';
    }
}
