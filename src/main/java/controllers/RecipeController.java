package controllers;

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
    public ResponseEntity<Long> addRec (@RequestBody Recipe recipe) {
        final long id = cookServiseIMPL.addRecipe(recipe);
        return ResponseEntity.ok().body(id);
    }
//поиск по ид
@GetMapping("/{id}")
private ResponseEntity <Recipe> getRecById (@PathVariable long id) {
    Recipe rec = cookServiseIMPL.getRecipe(id);
    if (rec == null) {
        ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(rec);
}
@DeleteMapping("/{id}")
public ResponseEntity<Void> deleteRecipe (@PathVariable long id) {
    if (cookServiseIMPL.delRec(id)) {
        return ResponseEntity.ok().build();
    }
    return ResponseEntity.notFound().build();
}
@PutMapping("/{id}")
    private ResponseEntity <Recipe> editRec (@RequestBody Recipe recipe, @PathVariable long id) {
    Recipe rec = cookServiseIMPL.editRec(id, recipe);
    if (rec == null) {
        ResponseEntity.notFound().build();
    }

    return ResponseEntity.ok(rec);
}

    /*@GetMapping("/{id}")
    private ResponseEntity <Recipe> getRecById (@PathVariable long id) {
        Recipe rec = cookServiseIMPL.getRecipe(id);
        if (id == null) {
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(id);

    }

     */
    /*@PostMapping
    public ResponseEntity<Recipe> addRecipe (@RequestBody Recipe recipe) {
        Recipe rec = cookServiseIMPL.addRecipe(recipe);
        return ResponseEntity.ok().body(recipe);
    }
    @GetMapping("/{rec}")
    private ResponseEntity<Recipe> getRecipe (@PathVariable Recipe rec) {
        Recipe rec1 = cookServiseIMPL.getRecipe(rec);
        if (rec1 == null) {
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(rec1);
    }

     */
}
