package com.example.cookbook.impl;

import com.example.cookbook.model.Recipe;

public interface RecipeServise {
    long addRecipe(Recipe recipe);


    Recipe getRecipe(long recId, Recipe recipe);

    Recipe editRec(long id, Recipe recipe);

    boolean delRec(long id);
}
