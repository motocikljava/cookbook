package services.impl;

import model.Ingredient;
import model.Recipe;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
@Service
public class CookServiseIMPL implements CookServise {
    public static Map<Integer, Recipe> recipeMap = new HashMap<>();
    public static Map<Integer, Ingredient> ingredientMap = new HashMap<>();
    private static int recId = 0;
    private static int ingId = 0;

@Override
    public Recipe addRecipe(Recipe recipe) {
        final model.Recipe newRecipe = recipeMap.getOrDefault(recId, recipe);
        recipeMap.put(recId++, recipe);
    return newRecipe;
}
@Override
    public Recipe getRecipe(Recipe recipe) {
        ArrayList<Recipe> recipeArrayList = new ArrayList<>();
        for (Recipe recipe1 : recipeMap.values()) {
            recipeArrayList.add(recipe);
        }
    return recipe;
}
@Override
    public Ingredient addIng(Ingredient ingredient) {
        Ingredient newIng = ingredientMap.getOrDefault(ingId, ingredient);
        ingredientMap.put(ingId++, ingredient);
    return newIng;
}
@Override
    public Ingredient getIng(Ingredient ingredient) {
        ArrayList<Ingredient> ingArrayList = new ArrayList<>();
        for (Ingredient ingredient1 : ingredientMap.values()) {
            ingArrayList.add(ingredient);
        }
        System.out.println("забыл в прошлый раз отправить на гитхаб");
    return ingredient;
}
}

