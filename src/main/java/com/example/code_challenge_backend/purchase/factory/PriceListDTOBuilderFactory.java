package com.example.code_challenge_backend.purchase.factory;

import com.example.code_challenge_backend.purchase.builder.PriceListDTOBuilder;
import com.example.code_challenge_backend.purchase.builder.impl.PriceListDTOBuilderImpl;

public class PriceListDTOBuilderFactory {

    private PriceListDTOBuilderFactory() {}

    public static PriceListDTOBuilder create() {
        return new PriceListDTOBuilderImpl();
    }

}

