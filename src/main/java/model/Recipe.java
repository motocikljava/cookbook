package model;

import java.util.ArrayList;


public class Recipe extends Ingredient {
    private String name;
    private int minTime;
    private ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
    private String cookingSteps;
    static int counterId;
    private int id;


    public Recipe(String name, int quantityIng, String units) {
        super(name, quantityIng, units);
    }
    public Recipe get(long id) {

        return get(id);
    }
}
