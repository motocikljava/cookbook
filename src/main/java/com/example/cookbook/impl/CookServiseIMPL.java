package com.example.cookbook.impl;

import com.example.cookbook.model.Ingredient;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
public class CookServiseIMPL implements CookServise {
    public static Map<Integer, Ingredient> ingredientMap = new HashMap<>();
    private static int ingId = 0;

    final private FileServiceIngridientImpl fileServiceIngridient;

    public CookServiseIMPL(FileServiceIngridientImpl fileServiceIngridient) {
        this.fileServiceIngridient = fileServiceIngridient;
    }

    @Override
    public long addIng(Ingredient ingredient) {
        ingredientMap.getOrDefault(ingId, ingredient);
        ingredientMap.put(ingId++, ingredient);
        saveToFileIngr();
        return ingId;

    }
@Override
    public Ingredient getIng(long ingId, Ingredient ingredient) {
        ingredientMap.getOrDefault(ingId,ingredient);
        return ingredient;
    }


    @Override
    public Ingredient editIng(long id, Ingredient ingredient) {
        ingredientMap.containsKey(ingId);
        ingredientMap.put(ingId, ingredient);
        saveToFileIngr();
        return ingredient;
            }


@Override
    public boolean delIng(long id) {
        ingredientMap.containsKey(id);
        ingredientMap.remove(id);
        return true;
            }





    private void saveToFileIngr() {
        try {
            String jsonIng = new ObjectMapper().writeValueAsString(ingredientMap);
            fileServiceIngridient.saveToFileToIngr(jsonIng);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private void readFileIngr() {
        final String jsonIng = fileServiceIngridient.readFromFileToIngr();
        try {
            ingredientMap = new ObjectMapper().readValue(jsonIng, new TypeReference<HashMap<Integer, Ingredient>>() {
            });
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}


