package controllers;

import model.Ingredient;
import model.Recipe;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.impl.CookServiseIMPL;

@RestController
@RequestMapping("/ingridient")
public abstract class IngridientController {
    private CookServiseIMPL cookServiseIMPL;

    public IngridientController(CookServiseIMPL cookServiseIMPL) {
        this.cookServiseIMPL = cookServiseIMPL;
    }
// добавление
    @PostMapping
    public ResponseEntity<Long> addIng (@RequestBody Ingredient ingredient) {
        final long id = cookServiseIMPL.addIng(ingredient);
        return ResponseEntity.ok().body(id);
    }
//поиск по ид

    @GetMapping("/{id}")
    private ResponseEntity <Ingredient> getIngridById (@PathVariable long id) {
        Ingredient ing = cookServiseIMPL.getIng(id);
        if (ing == null) {
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ing);

    }
    @PutMapping("/{id}")
    private ResponseEntity <Ingredient> editIng (@RequestBody Ingredient ingredient, @PathVariable long id) {
        Ingredient ing = cookServiseIMPL.editIng(id, ingredient);
        if (ing == null) {
            ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(ing);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIng (@PathVariable long id) {
        if (cookServiseIMPL.delIng(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
    /*@PostMapping
    public ResponseEntity<Ingredient> addIngrid (@RequestBody Ingredient ingredient) {
        Ingredient ing = cookServiseIMPL.addIng(ingredient);
        return ResponseEntity.ok().body(ing);
    }


    @GetMapping("/{ing}")
    private ResponseEntity <Ingredient> getIngridById (@PathVariable Ingredient ing) {
        Ingredient ing1 = cookServiseIMPL.getIng(ing);
        if (ing1 == null) {
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ing1);

    }

     */


}
