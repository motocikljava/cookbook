package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.Map;
@SuperBuilder

public class Recipe extends Ingredient {
    private String name;
    private int minTime;
    private ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
    private String cookingSteps;
    static int counterId;
    private int id;



}
