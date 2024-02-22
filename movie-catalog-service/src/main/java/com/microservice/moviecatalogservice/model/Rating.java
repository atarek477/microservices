package com.microservice.moviecatalogservice.model;

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
