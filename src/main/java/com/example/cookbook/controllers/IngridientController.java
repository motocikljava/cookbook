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
@RequestMapping("/ingridient")
@Tag(name = "работа с ингридиентами", description =" CRUD  операции с ингридиентами")
public class IngridientController {
    private CookServiseIMPL cookServiseIMPL;

    public IngridientController(CookServiseIMPL cookServiseIMPL) {
        this.cookServiseIMPL = cookServiseIMPL;
    }
@Operation (
        summary = "Добавление ингридиента",
        description = "добавление ингридиента и создание Id"
)
@ApiResponses( value = {
       @ApiResponse(responseCode="200",
               description = "ингридиент добавлен",
               content ={
               @Content(
                       mediaType = "aplication/json",
                       array = @ArraySchema(schema = @Schema(implementation = Ingredient.class))
               )
               }
       )

        }
)
    @PostMapping

    public ResponseEntity<Long> addIng (@RequestBody Ingredient ingredient) {
        final long id = cookServiseIMPL.addIng(ingredient);
        return ResponseEntity.ok().body(id);
    }
//поиск по ид

    @GetMapping("/{id}")
    @Operation(
            summary = "Поиск ингридиента",
            description = "поиск ингридиента по Id"
    )
    @ApiResponses( value = {
            @ApiResponse(responseCode="200",
                    description = "ингридиент найден",
                    content ={
                            @Content(
                                    mediaType = "aplication/json",
                                    array = @ArraySchema(schema = @Schema(implementation = Ingredient.class))
                            )
                    }
            )

    }
    )
    private ResponseEntity <Ingredient> getIngridById (@RequestBody Ingredient ingredient,@PathVariable long id) {
        Ingredient ing = cookServiseIMPL.getIng(id, ingredient);
        if (ing == null) {
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ing);

    }
    @PutMapping("/{id}")
    @Operation(
            summary = "Редактирование ингридиента",
            description = "редактирование ингридиента по Id"
    )
    @ApiResponses( value = {
            @ApiResponse(responseCode="200",
                    description = "ингридиент изменён",
                    content ={
                            @Content(
                                    mediaType = "aplication/json",
                                    array = @ArraySchema(schema = @Schema(implementation = Ingredient.class))
                            )
                    }
            )

    }
    )
    private ResponseEntity <Ingredient> editIng (@RequestBody Ingredient ingredient, @PathVariable long id) {
        Ingredient ing = cookServiseIMPL.editIng(id, ingredient);
        if (ing == null) {
            ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(ing);
    }
    @DeleteMapping("/{id}")
    @Operation(
            summary = "Удаление ингридиента",
            description = "удаление ингридинта по Id"
    )
    @ApiResponses( value = {
            @ApiResponse(responseCode="200",
                    description = "ингридиент удалён",
                    content ={
                            @Content(
                                    mediaType = "aplication/json",
                                    array = @ArraySchema(schema = @Schema(implementation = Ingredient.class))
                            )
                    }
            )

    }
    )

    public ResponseEntity<Void> deleteIng (@PathVariable long id) {
        if (cookServiseIMPL.delIng(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }



}
