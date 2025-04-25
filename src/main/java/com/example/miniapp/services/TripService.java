package com.example.miniapp.services;
import com.example.miniapp.models.Trip;
import com.example.miniapp.repositories.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TripService {
    private final TripRepository tripRepository;
    @Autowired
    public TripService(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    public Trip addTrip(Trip trip)
    {
        return tripRepository.save(trip);
    }


    public List<Trip> getAllTrips()
    {
        return tripRepository.findAll();
    }


    public Trip getTripById(Long id)
    {
        return tripRepository.findById(id).orElseThrow(() -> new RuntimeException("Trip not found"));
    }


    public Trip updateTrip(Long id, Trip trip)
    {
        Trip existingTrip = tripRepository.findById(id).orElseThrow(() -> new RuntimeException("Trip not found"));
        existingTrip.setOrigin(trip.getOrigin());
        existingTrip.setDestination(trip.getDestination());
        existingTrip.setTripCost(trip.getTripCost());
        return tripRepository.save(existingTrip);
    }


    public void deleteTrip(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Trip ID cannot be null");
        }

        Trip existingTrip = tripRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Trip not found"));

        tripRepository.delete(existingTrip);
    }


    public List<Trip> findTripsWithinDateRange(LocalDateTime startDate, LocalDateTime endDate)
    {
        return tripRepository.findByTripDateBetween(startDate, endDate);

    }


    public List<Trip> findTripsByCaptainId(Long captainId)
    {
        return tripRepository.findByCaptainId(captainId);
    }
}