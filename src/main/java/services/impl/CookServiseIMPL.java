package services.impl;

import model.Ingredient;
import model.Recipe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CookServiseIMPL {
    public static Map<Integer, Recipe> recipeMap = new HashMap<>();
    public static Map<Integer, Ingredient> ingredientMap = new HashMap<>();
    private static int recId = 0;
    private static int ingId = 0;


    public void addRecipe(Recipe recipe) {
        final model.Recipe newRecipe = recipeMap.getOrDefault(recId, recipe);
        recipeMap.put(recId++, recipe);
    }

    public void getRecipe(Recipe recipe) {
        ArrayList<Recipe> recipeArrayList = new ArrayList<>();
        for (Recipe recipe1 : recipeMap.values()) {
            recipeArrayList.add(recipe);
        }
    }

    public void addIng(Ingredient ingredient) {
        Ingredient newIng = ingredientMap.getOrDefault(ingId, ingredient);
        ingredientMap.put(ingId++, ingredient);
    }

    public void getIng(Ingredient ingredient) {
        ArrayList<Ingredient> ingArrayList = new ArrayList<>();
        for (Ingredient ingredient1 : ingredientMap.values()) {
            ingArrayList.add(ingredient);
        }

    }
}

