package com.out_of_the_chat.repositories;

import com.out_of_the_chat.entities.Trip;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest
@Transactional
public class TripRepositoryTest {

    @Autowired
    private TripRepository tripRepository;

    @BeforeEach
    public void setup() {
        tripRepository.deleteAll();
    }

    @Test
    public void createTripTest() {
        String tripName = "Test Name";
        String tripDescription = "Test Description";

        Trip trip = new Trip();
        trip.setName(tripName);
        trip.setDescription(tripDescription);

        Trip savedTrip = tripRepository.save(trip);

        long expectedCount = 1;

        assertThat(savedTrip.getId()).isNotNull();
        assertThat(savedTrip.getName()).isEqualTo(tripName);
        assertThat(savedTrip.getDescription()).isEqualTo(tripDescription);
        assertThat(tripRepository.count()).isEqualTo(expectedCount);
    }

    @Test
    public void getTripByIdTest() {
        String tripName = "Test Name";
        String tripDescription = "Test Description";

        Trip trip = new Trip();
        trip.setName(tripName);
        trip.setDescription(tripDescription);

        Trip savedTrip = tripRepository.save(trip);

        Trip expectedTrip = tripRepository.getReferenceById(savedTrip.getId());

        assertThat(expectedTrip).isNotNull();
        assertThat(expectedTrip.getName()).isEqualTo(tripName);
        assertThat(expectedTrip.getDescription()).isEqualTo(tripDescription);
    }
}
