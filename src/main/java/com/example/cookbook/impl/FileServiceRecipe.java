package com.example.cookbook.impl;

public interface FileServiceRecipe {
    boolean saveToFile(String json);

    String readFromFile();
}
