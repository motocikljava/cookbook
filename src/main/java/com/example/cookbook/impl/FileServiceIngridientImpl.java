package com.example.cookbook.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class FileServiceIngridientImpl implements FileServiceIngridient {
    @Value("${path.to.data.file.ingr}")
    private String ingrDataFilePath;

    @Value("${name.of.data.file.ingr}")
    private String ingrDataFileName;
    @Override
    public boolean saveToFileToIngr(String json) {
        try {
            Files.writeString(Path.of(ingrDataFileName, ingrDataFilePath), json);
            return true;
        } catch (IOException e) {
            return false;
        }

    }
    @Override
    public String readFromFileToIngr() {
        try {
            return Files.readString(Path.of(ingrDataFileName, ingrDataFilePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    private boolean deleteDataFileToIngr() {
        try {
            Path path = Path.of(ingrDataFileName, ingrDataFilePath);
            Files.deleteIfExists(path);
            Files.createFile(path);
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
