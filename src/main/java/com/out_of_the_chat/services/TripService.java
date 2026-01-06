package com.out_of_the_chat.services;

import com.out_of_the_chat.dto.TripRequest;
import com.out_of_the_chat.entities.Trip;
import com.out_of_the_chat.exceptions.TripNotFoundException;
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
        return tripRepository.findById(id)
                .orElseThrow(() -> new TripNotFoundException(id));
    }

    public Trip createTrip(TripRequest request) {
        Trip trip = new Trip();

        trip.setName(request.getName());
        trip.setDescription(request.getDescription());

        Trip savedTrip = tripRepository.save(trip);

        return savedTrip;
    }
}
