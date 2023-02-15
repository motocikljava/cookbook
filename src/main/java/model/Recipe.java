package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Map;
@Data
@AllArgsConstructor
public class Recipe {
    private String name;
    private int minTime;
    private ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
    private String cookingSteps;
    static int counterId;
    private int id;



}
