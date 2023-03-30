package com.example.cookbook.impl;

import com.example.cookbook.model.Recipe;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

public class RecipeServiseImpl implements RecipeServise {
    final private FileServiceRecipe fileServiceRecipe;
    public static Map<Integer, Recipe> recipeMap = new HashMap<>();
    public RecipeServiseImpl (FileServiceRecipe fileServiceRecipe) {
        this.fileServiceRecipe = fileServiceRecipe;
    }
    private static int recId = 0;
    @Override
    public long addRecipe(Recipe recipe) {
        recipeMap.getOrDefault(recId, recipe);
        recipeMap.put(recId++, recipe);
        saveToFileRecipe();
        return recId;
    }
    @Override
    public Recipe getRecipe(long recId, Recipe recipe) {
        recipeMap.getOrDefault(recId, recipe);
        return recipe;
    }
    @Override
    public Recipe editRec(long id, Recipe recipe) {
        recipeMap.containsKey(recId);
        recipeMap.put(recId, recipe);
        saveToFileRecipe();
        return recipe;
            }


    @Override
    public boolean delRec(long id) {
        recipeMap.containsKey(id);
        recipeMap.remove(id);
        return true;
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


}
