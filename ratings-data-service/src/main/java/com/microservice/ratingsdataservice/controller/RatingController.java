package com.microservice.ratingsdataservice.controller;

import com.microservice.ratingsdataservice.model.Rating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rating")
public class RatingController {
    @RequestMapping("/{movieId}")
    public Rating getMovieInfo(@PathVariable("movieId")String movieId){

        return new Rating(movieId,4);
    }

}
