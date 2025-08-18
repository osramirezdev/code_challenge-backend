package com.example.code_challenge_backend.store.factory;

import com.example.code_challenge_backend.store.builder.CustomerDTOBuilder;
import com.example.code_challenge_backend.store.builder.impl.CustomerDTOBuilderImpl;

public class CustomerDTOBuilderFactory {

    private CustomerDTOBuilderFactory() {}

    public static CustomerDTOBuilder create() {
        return new CustomerDTOBuilderImpl();
    }

}

