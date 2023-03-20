package com.example.cookbook.impl;

import com.example.cookbook.model.Ingredient;
import com.example.cookbook.model.Recipe;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
public class CookServiseIMPL implements CookServise {
    public static Map<Integer, Recipe> recipeMap = new HashMap<>();
    public static Map<Integer, Ingredient> ingredientMap = new HashMap<>();
    private static int recId = 0;
    private static int ingId = 0;

    @Override
    public long addRecipe(Recipe recipe) {
        final Recipe newRecipe = recipeMap.getOrDefault(recId, recipe);
        recipeMap.put(recId++, recipe);
        return recId;
    }


    @Override
    public Recipe getRecipe(long id) {
        for (Recipe val : recipeMap.values()) {
            Recipe recipe = val.get(id);
            if (recipe != null) {
                return recipe;
            }
        }
        return null;
    }

    @Override
    public long addIng(Ingredient ingredient) {
        Ingredient newIng = ingredientMap.getOrDefault(ingId, ingredient);
        ingredientMap.put(ingId++, ingredient);
        return ingId;
    }

    public Ingredient getIng(long id) {
        for (Ingredient value : ingredientMap.values()) {
            Ingredient ingredient = value.get(id);
            if (ingredient != null) {
                return ingredient;
            }
        }
        return null;
    }

    @Override
    public Recipe editRec(long id, Recipe recipe) {
        for (Recipe val1 : recipeMap.values()) {
            if (recipeMap.containsKey(recId)) {
                recipeMap.put(recId, recipe);
                return recipe;
            }
        }

        return null;
    }


    @Override
    public Ingredient editIng(long id, Ingredient ingredient) {
        for (Ingredient val : ingredientMap.values()) {
            if (ingredientMap.containsKey(ingId)) {
                ingredientMap.put(ingId, ingredient);
                return ingredient;
            }
        }

        return null;
    }
@Override
    public boolean delIng(long id) {
        for (Ingredient val : ingredientMap.values()) {
            if (ingredientMap.containsKey(id)) {
                ingredientMap.remove(id);
                return true;
            }
        }
        return false;
    }
    @Override
    public boolean delRec(long id) {
        for (Recipe val : recipeMap.values()) {
            if (recipeMap.containsKey(id)) {
                recipeMap.remove(id);
                return true;
            }
        }
        return false;
    }
}


