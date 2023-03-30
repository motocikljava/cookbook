package com.example.cookbook.impl;

import com.example.cookbook.model.Ingredient;
import com.example.cookbook.model.Recipe;

public interface CookServise {




    long addIng(Ingredient ingredient);


    Ingredient getIng(long ingId, Ingredient ingredient);

    Ingredient editIng(long id, Ingredient ingredient);

    boolean delIng(long id);


}
