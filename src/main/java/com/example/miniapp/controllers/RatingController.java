package com.example.miniapp.controllers;
import com.example.miniapp.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rating")
public class RatingController {
    private final RatingService ratingService;
    @Autowired
    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

}
