package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class Recipe extends Ingredient {
    private String name;
    private int minTime;
    private ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
    private String cookingSteps;
    static int counterId;
    private int id;



    public Recipe get(long id) {

        return get(id);
    }
}
