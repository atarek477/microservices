package com.microservice.ratingsdataservice.controller;

import com.microservice.ratingsdataservice.model.Rating;
import com.microservice.ratingsdataservice.model.UserRating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/rating")
public class RatingController {


    @RequestMapping("/user/list/{userId}")
    public UserRating getUserRating(@PathVariable("userId")String userId){

        List<Rating> ratings= Arrays.asList(
                new Rating("123",4),
                new Rating("345",5)

        );



        UserRating userRating = new UserRating();
        userRating.setRatings(ratings);
        return userRating;
    }



}
