package com.out_of_the_chat.services;

import com.out_of_the_chat.entities.Trip;
import com.out_of_the_chat.repositories.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TripService {

    private final TripRepository tripRepository;

    @Autowired
    public TripService(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    public Trip getTripById(int id) {
        return this.tripRepository.getReferenceById(id);
    }

    public Trip createTrip(Trip trip) {
        Trip savedTrip = this.tripRepository.save(trip);

        return savedTrip;
    }
}
