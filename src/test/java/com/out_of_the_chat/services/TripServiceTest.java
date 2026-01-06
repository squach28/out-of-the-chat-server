package com.out_of_the_chat.services;

import com.out_of_the_chat.entities.Trip;
import com.out_of_the_chat.exceptions.TripNotFoundException;
import com.out_of_the_chat.repositories.TripRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;

import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

import static org.assertj.core.api.Assertions.assertThat;
@ExtendWith(MockitoExtension.class)
public class TripServiceTest {

    @Mock
    private TripRepository tripRepository;

    @InjectMocks
    private TripService tripService;

    @Test
    public void shouldReturnTripWhenFound() {
        int tripId = ThreadLocalRandom.current().nextInt(1, 101);
        String name = "Trip Name";
        String description = "Trip Description";

        Trip trip = new Trip();
        trip.setId(tripId);
        trip.setName(name);
        trip.setDescription(description);

        when(tripRepository.findById(tripId))
                .thenReturn(Optional.of(trip));

        Optional<Trip> foundTrip = tripRepository.findById(tripId);

        assertThat(foundTrip.get().getName()).isEqualTo(name);
        assertThat(foundTrip.get().getDescription()).isEqualTo(description);
        verify(tripRepository).findById(tripId);
    }

    @Test
    public void shouldThrowWhenTripNotFound() {
        int tripId = ThreadLocalRandom.current().nextInt(1, 101);

        when(tripRepository.findById(tripId))
                .thenReturn(Optional.empty());

        assertThatThrownBy(() -> tripService.getTripById(tripId))
                .isInstanceOf(TripNotFoundException.class);

        verify(tripRepository).findById(tripId);
    }
}

