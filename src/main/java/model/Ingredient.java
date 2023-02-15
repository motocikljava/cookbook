package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;

@SuperBuilder


public class Ingredient extends Recipe {
    private String name;
    private int quantityIng;
    private String units;

    public Ingredient(String name, int minTime, ArrayList<Ingredient> ingredients, String cookingSteps, int id) {
        super(name, minTime, ingredients, cookingSteps, id);
    }
}
