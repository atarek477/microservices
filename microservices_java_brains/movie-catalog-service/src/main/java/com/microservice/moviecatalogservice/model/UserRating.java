package com.microservice.moviecatalogservice.model;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class UserRating {
    private List<Rating> ratings;

}
