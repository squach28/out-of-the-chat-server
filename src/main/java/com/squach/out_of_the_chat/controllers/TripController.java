package com.squach.out_of_the_chat.controllers;

import com.squach.out_of_the_chat.entities.Trip;
import com.squach.out_of_the_chat.services.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/trips")
public class TripController {
    private final TripService tripService;

    @Autowired
    public TripController(TripService tripService) {
        this.tripService = tripService;
    }

    @GetMapping
    public Trip getTrip(@PathVariable int tripId) {
        return this.tripService.getTripById(tripId);
    }

    @PostMapping
    public Trip createTrip() {
        String name = "name";
        String description = "description";
        return this.tripService.createTrip(name, description);
    }
}
