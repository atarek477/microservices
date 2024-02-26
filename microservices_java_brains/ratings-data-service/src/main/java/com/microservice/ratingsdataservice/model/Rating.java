package com.microservice.ratingsdataservice.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder

public class Rating {

    private String movieId;
    private int rating;


}
