package com.example.korber.entity;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {
    
    private UUID id = UUID.randomUUID();

    private String description;
    private Double weight;
    private Double volume;
    private Boolean active;
}
