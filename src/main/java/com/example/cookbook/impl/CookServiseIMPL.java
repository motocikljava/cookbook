package com.example.cookbook.impl;

import com.example.cookbook.model.Ingredient;
import com.example.cookbook.model.Recipe;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
public class CookServiseIMPL implements CookServise {
    final private FileServiceRecipe fileServiceRecipe;

    public static Map<Integer, Recipe> recipeMap = new HashMap<>();
    public static Map<Integer, Ingredient> ingredientMap = new HashMap<>();
    private static int recId = 0;
    private static int ingId = 0;

    public CookServiseIMPL(FileServiceRecipe fileServiceRecipe) {
        this.fileServiceRecipe = fileServiceRecipe;
    }

    @Override
    public long addRecipe(Recipe recipe) {
        final Recipe newRecipe = recipeMap.getOrDefault(recId, recipe);
        recipeMap.put(recId++, recipe);
        saveToFileRecipe();
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
        saveToFileIngr();
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
                saveToFileRecipe();
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
                saveToFileIngr();
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

    private void saveToFileRecipe() {
        try {
            String jsonRe = new ObjectMapper().writeValueAsString(recipeMap);
            fileServiceRecipe.saveToFile(jsonRe);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private void readFileRecipe() {
        final String jsonRe = fileServiceRecipe.readFromFile();
        try {
            recipeMap = new ObjectMapper().readValue(jsonRe, new TypeReference<HashMap<Integer, Recipe>>() {
            });
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
    private void saveToFileIngr() {
        try {
            String jsonIng = new ObjectMapper().writeValueAsString(ingredientMap);
            fileServiceRecipe.saveToFile(jsonIng);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private void readFileIngr() {
        final String jsonIng = fileServiceRecipe.readFromFile();
        try {
            ingredientMap = new ObjectMapper().readValue(jsonIng, new TypeReference<HashMap<Integer, Ingredient>>() {
            });
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}


