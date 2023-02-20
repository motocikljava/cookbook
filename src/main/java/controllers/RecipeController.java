package controllers;

import model.Ingredient;
import model.Recipe;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.impl.CookServiseIMPL;

@RestController
@RequestMapping("/recipe")
public class RecipeController {
    private CookServiseIMPL cookServiseIMPL;

    public RecipeController(CookServiseIMPL cookServiseIMPL) {
        this.cookServiseIMPL = cookServiseIMPL;
    }
    @PostMapping
    public ResponseEntity<Recipe> addRecipe (@RequestBody Recipe recipe) {
        Recipe rec = cookServiseIMPL.addRecipe(recipe);
        return ResponseEntity.ok().body(recipe);
    }
    @GetMapping("{rec}")
    private ResponseEntity<Recipe> getRecipe (@PathVariable Recipe rec) {
        Recipe rec1 = cookServiseIMPL.getRecipe(rec);
        if (rec1 == null) {
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(rec1);
    }
}
