package com.stackroute.exceptions;

public class MovieAlreadyExistsException extends Exception {

    public String message;

    public MovieAlreadyExistsException(){};

    public MovieAlreadyExistsException(String message){
        super(message);
        this.message = message;
    }
}