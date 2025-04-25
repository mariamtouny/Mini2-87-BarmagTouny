package com.example.miniapp.repositories;

import com.example.miniapp.models.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {

    //Retrieving trips within a specified date range
    List<Trip> findByTripDateBetween(LocalDateTime startDate, LocalDateTime endDate);

    //Filtering Trips by captain id
    List<Trip> findByCaptainId(Long captainId);
}
