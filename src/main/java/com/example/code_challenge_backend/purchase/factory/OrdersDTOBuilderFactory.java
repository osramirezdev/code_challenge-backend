package com.example.code_challenge_backend.purchase.factory;

import com.example.code_challenge_backend.purchase.builder.OrdersDTOBuilder;
import com.example.code_challenge_backend.purchase.builder.impl.OrdersDTOBuilderImpl;

public class OrdersDTOBuilderFactory {

    private OrdersDTOBuilderFactory() {}

    public static OrdersDTOBuilder create() {
        return new OrdersDTOBuilderImpl();
    }

}

