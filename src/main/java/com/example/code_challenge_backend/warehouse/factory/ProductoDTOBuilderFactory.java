package com.example.code_challenge_backend.warehouse.factory;

import com.example.code_challenge_backend.warehouse.builder.ProductDTOBuilder;
import com.example.code_challenge_backend.warehouse.builder.impl.ProductDTOBuilderImpl;

public class ProductoDTOBuilderFactory {

    private ProductoDTOBuilderFactory() {}

    public static ProductDTOBuilder create() {
        return new ProductDTOBuilderImpl();
    }

}

