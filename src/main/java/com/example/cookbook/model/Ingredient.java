package com.example.cookbook.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Data
@AllArgsConstructor
@NoArgsConstructor


public class Ingredient {

    private String name;

    private int quantityIng;
    private String units;


    public Ingredient get(long id) {

        return get(id);
    }
}
