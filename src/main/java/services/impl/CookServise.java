package services.impl;

import model.Ingredient;
import model.Recipe;

public interface CookServise {
    Recipe addRecipe(Recipe recipe);

    Recipe getRecipe(Recipe recipe);

    Ingredient addIng(Ingredient ingredient);

    Ingredient getIng(Ingredient ingredient);
}
