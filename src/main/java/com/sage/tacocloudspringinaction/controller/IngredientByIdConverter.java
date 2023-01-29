package com.sage.tacocloudspringinaction.controller;

import com.sage.tacocloudspringinaction.Ingredient;
import com.sage.tacocloudspringinaction.data.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;
import org.springframework.stereotype.Component;

@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {

    private final IngredientRepository ingredientRepo;

    @Autowired
    public IngredientByIdConverter(IngredientRepository ingredientRepo){
        this.ingredientRepo = ingredientRepo;
    }

    @Override
    public Ingredient convert(String id) {
        return ingredientRepo.findOne(id);
    }

//    @Override
//    public <T extends Ingredient> Converter<String, T> getConverter(Class<T> targetType) {
//        return null;
//    }
}