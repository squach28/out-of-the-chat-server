package com.out_of_the_chat.exceptions;

public class TripNotFoundException extends RuntimeException {

    public TripNotFoundException(int id) {
        super("Trip not found: " + id);
    }
}
