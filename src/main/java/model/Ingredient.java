package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;

@Data
@AllArgsConstructor


public class Ingredient {
    private String name;
    private int quantityIng;
    private String units;


}
