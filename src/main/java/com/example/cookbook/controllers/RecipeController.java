package com.example.cookbook.controllers;

import com.example.cookbook.model.Ingredient;
import com.example.cookbook.model.Recipe;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.cookbook.impl.CookServiseIMPL;

@RestController
@RequestMapping("/recipe")
@Tag(name = "работа с рецептами", description =" CRUD  операции с рецептами")
public class RecipeController {
    private CookServiseIMPL cookServiseIMPL;

    public RecipeController(CookServiseIMPL cookServiseIMPL) {
        this.cookServiseIMPL = cookServiseIMPL;
    }
    @PostMapping
    @Operation(
            summary = "Добавление рецепта",
            description = "добавление рецепта и создание Id"
    )
    @ApiResponses( value = {
            @ApiResponse(responseCode="200",
                    description = "рецепт добавлен",
                    content ={
                            @Content(
                                    mediaType = "aplication/json",
                                    array = @ArraySchema(schema = @Schema(implementation = Recipe.class))
                            )
                    }
            )

    }
    )
    public ResponseEntity<Long> addRec (@RequestBody Recipe recipe) {
        final long id = cookServiseIMPL.addRecipe(recipe);
        return ResponseEntity.ok().body(id);
    }
//поиск по ид
@GetMapping("/{id}")
@Operation(
        summary = "Поиск рецепта",
        description = "поиск рецепта по Id"
)
@ApiResponses( value = {
        @ApiResponse(responseCode="200",
                description = "рецепт найден",
                content ={
                        @Content(
                                mediaType = "aplication/json",
                                array = @ArraySchema(schema = @Schema(implementation = Recipe.class))
                        )
                }
        )

}
)
private ResponseEntity <Recipe> getRecById (@PathVariable long id) {
    Recipe rec = cookServiseIMPL.getRecipe(id);
    if (rec == null) {
        ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(rec);
}
@DeleteMapping("/{id}")
@Operation(
        summary = "Удаление рецепта",
        description = "удаление рецепта по Id"
)
@ApiResponses( value = {
        @ApiResponse(responseCode="200",
                description = "рецепт удалён",
                content ={
                        @Content(
                                mediaType = "aplication/json",
                                array = @ArraySchema(schema = @Schema(implementation = Recipe.class))
                        )
                }
        )

}
)
public ResponseEntity<Void> deleteRecipe (@PathVariable long id) {
    if (cookServiseIMPL.delRec(id)) {
        return ResponseEntity.ok().build();
    }
    return ResponseEntity.notFound().build();
}
@PutMapping("/{id}")
@Operation(
        summary = "Редактирование рецепта",
        description = "редактирование рецепта по Id"
)
@ApiResponses( value = {
        @ApiResponse(responseCode="200",
                description = "рецепт изменён",
                content ={
                        @Content(
                                mediaType = "aplication/json",
                                array = @ArraySchema(schema = @Schema(implementation = Recipe.class))
                        )
                }
        )

}
)
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
