package controllers;

import model.Ingredient;
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
    @PostMapping
    public ResponseEntity<Ingredient> addIngrid (@RequestBody Ingredient ingredient) {
        Ingredient ing = cookServiseIMPL.addIng(ingredient);
        return ResponseEntity.ok().body(ing);
    }
    @GetMapping("{ing}")
    private ResponseEntity <Ingredient> getIngrid (@PathVariable Ingredient ing) {
        Ingredient ing1 = cookServiseIMPL.getIng(ing);
        if (ing1 == null) {
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ing1);
    }

    /*@GetMapping("/addIngredient")
    public Ingredient addIngrid(@RequestParam String name, @RequestParam int quantityIng, @RequestParam String units){

        return cookServiseIMPL.addIng(addIngrid(name, quantityIng, units));
    }

     */

}
