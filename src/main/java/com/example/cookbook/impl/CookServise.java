package com.example.cookbook.impl;

import com.example.cookbook.model.Ingredient;
import com.example.cookbook.model.Recipe;

public interface CookServise {
    long addRecipe(Recipe recipe);



    Recipe getRecipe(long id);

    long addIng(Ingredient ingredient);

    //Ingredient getIng(Ingredient ingredient);

    Ingredient getIng(long id);

    Recipe editRec(long id, Recipe recipe);


    Ingredient editIng(long id, Ingredient ingredient);

    boolean delIng(long id);

    boolean delRec(long id);
}
