package com.microservice.moviecatalogservice.model;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder

public class Movie
{
    private String movieId;
    private String name;

}
