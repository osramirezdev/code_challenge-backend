package com.example.code_challenge_backend.warehouse.factory;

import com.example.code_challenge_backend.warehouse.builder.CategoriaDTOBuilder;
import com.example.code_challenge_backend.warehouse.builder.impl.CategoriaDTOBuilderImpl;

public class CategoriaDTOBuilderFactory {

    private CategoriaDTOBuilderFactory() {}

    public static CategoriaDTOBuilder create() {
        return new CategoriaDTOBuilderImpl();
    }

}

