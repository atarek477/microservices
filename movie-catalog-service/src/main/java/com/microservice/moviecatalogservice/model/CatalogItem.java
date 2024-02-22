package com.microservice.moviecatalogservice.model;

import jdk.jfr.DataAmount;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CatalogItem {
    private String name ;
    private String description;
    private int    rating;

}
