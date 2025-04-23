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
    //To create and schedule a new trip.
    public Trip addTrip(Trip trip)
    {
        return tripRepository.save(trip);
    }

    //To retrieve all trips in the system.
    public List<Trip> getAllTrips()
    {
        return tripRepository.findAll();
    }

    //To retrieve a specific trip by its ID.
    public Trip getTripById(Long id)
    {
        return tripRepository.findById(id).orElseThrow(() -> new RuntimeException("Trip not found"));
    }

    //To update trip details such as origin, destination, or cost.
    public Trip updateTrip(Long id, Trip trip)
    {
        Trip existingTrip = tripRepository.findById(id).orElseThrow(() -> new RuntimeException("Trip not found"));
        existingTrip.setOrigin(trip.getOrigin());
        existingTrip.setDestination(trip.getDestination());
        existingTrip.setTripCost(trip.getTripCost());
        return tripRepository.save(existingTrip);
    }

    //To delete a trip from the system.
    public void deleteTrip(Long id)
    {
        Trip existingTrip = tripRepository.findById(id).orElseThrow(() -> new RuntimeException("Trip not found"));
        tripRepository.delete(existingTrip);
    }

    //To retrieve all trips that occurred between two specific dates.
    public List<Trip> findTripsWithinDateRange(LocalDateTime startDate, LocalDateTime endDate)
    {
        return tripRepository.findByTripDateBetween(startDate, endDate);

    }

    //To retrieve all trips associated with a specific captain’s ID.
    public List<Trip> findTripsByCaptainId(Long captainId)
    {
        return tripRepository.findByCaptainId(captainId);
    }
}