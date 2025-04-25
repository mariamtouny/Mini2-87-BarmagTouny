package com.example.miniapp.services;

import com.example.miniapp.models.Rating;
import com.example.miniapp.repositories.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RatingService {

    private final RatingRepository ratingRepository;

    @Autowired
    public RatingService(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    public Rating addRating(Rating rating) {
        return ratingRepository.save(rating);
    }

    public Rating updateRating(String id, Rating updatedRating) {
        Optional<Rating> existingRating = ratingRepository.findById(id);
        if (existingRating.isPresent()) {
            Rating rating = existingRating.get();
            rating.setScore(updatedRating.getScore());
            rating.setComment(updatedRating.getComment());
            return ratingRepository.save(rating);
        } else {
            throw new IllegalArgumentException("Rating with ID " + id + " not found.");
        }
    }

    public void deleteRating(String id) {
        if (ratingRepository.existsById(id)) {
            ratingRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Rating with ID " + id + " not found.");
        }
    }

    public List<Rating> getRatingsByEntity(Long entityId, String entityType) {
        return ratingRepository.findByEntityIdAndEntityType(entityId, entityType);
    }

    public List<Rating> findRatingsAboveScore(int minScore) {
        return ratingRepository.findByScoreGreaterThan(minScore);
    }
}
