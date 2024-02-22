package com.microservice.moviecatalogservice.controller;


import com.microservice.moviecatalogservice.model.CatalogItem;
import com.microservice.moviecatalogservice.model.Movie;
import com.microservice.moviecatalogservice.model.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {
 @Autowired
 RestTemplate restTemplate;
    @RequestMapping("/{userId}")
    public List<CatalogItem>getCatalog(@PathVariable("userId")String userId){

        List<Rating> ratings= Arrays.asList(
                new Rating("123",4),
                new Rating("345",5)

        );



        return ratings.stream().map(rating -> {
            Movie forObject = restTemplate.getForObject("http://localhost:8998/movies/" + rating.getMovieId(), Movie.class);
            return new CatalogItem(forObject.getName(),"testCatalog",rating.getRating());
        }).collect(Collectors.toList());


    }






}
