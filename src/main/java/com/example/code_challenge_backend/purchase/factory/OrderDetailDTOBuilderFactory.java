package com.example.code_challenge_backend.purchase.factory;

import com.example.code_challenge_backend.purchase.builder.OrderDetailDTOBuilder;
import com.example.code_challenge_backend.purchase.builder.impl.OrderDetailDTOBuilderImpl;

public class OrderDetailDTOBuilderFactory {

    private OrderDetailDTOBuilderFactory() {}

    public static OrderDetailDTOBuilder create() {
        return new OrderDetailDTOBuilderImpl();
    }

}

