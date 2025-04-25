package com.example.miniapp.controllers;
import com.example.miniapp.models.Trip;
import com.example.miniapp.services.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/trip")
public class TripController {
    private final TripService tripService;
    @Autowired
    public TripController(TripService tripService) {
        this.tripService = tripService;
    }
    //Post request to schedule a new trip.
    @PostMapping("/addTrip")
    public Trip addTrip(@RequestBody Trip trip)
    {
        return tripService.addTrip(trip);
    }

    //Get request to retrieve all trips
    @GetMapping("/allTrips")
    public List<Trip> getAllTrips()
    {
        return tripService.getAllTrips();
    }

    //Get request to retrieve a trip by ID.
    @GetMapping("/{id}")
    public Trip getTripById(@PathVariable Long id)
    {
        return tripService.getTripById(id);
    }

    //Put request to update the details of a trip.
    @PutMapping("/update/{id}")
    public Trip updateTrip(@PathVariable Long id, @RequestBody Trip trip)
    {
        return tripService.updateTrip(id, trip);
    }

    //Delete request to cancel a trip
    @DeleteMapping("/delete/{id}")
    public String deleteTrip(@PathVariable Long id)
    {
        tripService.deleteTrip(id);
        return "Trip with ID " + id + " has been deleted.";
    }

    //Get request to retrieve trips that occurred between two dates.
    @GetMapping("/findByDateRange")
    public List<Trip> findTripsWithinDateRange(@RequestParam LocalDateTime startDate, @RequestParam
    LocalDateTime endDate)
    {
        return tripService.findTripsWithinDateRange(startDate, endDate);

    }

    //Get request to retrieve trips associated with a specific captain.
    @GetMapping("/findByCaptainId")
    public List<Trip> findTripsByCaptainId(@RequestParam Long captainId)
    {
        return tripService.findTripsByCaptainId(captainId);
    }

}