package com.out_of_the_chat.controllers;

import com.out_of_the_chat.dto.TripRequest;
import com.out_of_the_chat.entities.Trip;
import com.out_of_the_chat.exceptions.TripNotFoundException;
import com.out_of_the_chat.services.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/trips")
public class TripController {
    private final TripService tripService;

    @Autowired
    public TripController(TripService tripService) {
        this.tripService = tripService;
    }

    @GetMapping("/{id}")
    public Trip getTrip(@PathVariable int id) {
        return tripService.getTripById(id);
    }

    @PostMapping
    public ResponseEntity<Trip> createTrip(@RequestBody TripRequest tripRequest) {
        try {
            Trip savedTrip = this.tripService.createTrip(tripRequest);

            return ResponseEntity.ok(savedTrip);

        } catch(Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @ExceptionHandler(TripNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    void handleNotFound() {}
}
