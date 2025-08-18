package com.example.code_challenge_backend.constants;

import java.util.Arrays;
import java.util.Optional;

public enum ApiModules {
    ORDERS("orders"),
    ORDERDETAIL("order detail"),
    PRODUCT("product"),
    CATEGORIA("categoria"),
    PRICELIST("price list"),
    CUSTOMER("customer");

    private String value;

    ApiModules(String value) {
        this.value = value;
    }

    public static ApiModules fromValue(String value) {
        ApiModules[] values = ApiModules.values();
        Optional<ApiModules> findAny = Arrays.asList(values).stream()
                .filter(v -> v.name().equalsIgnoreCase(value))
                .findAny();
        return findAny.orElse(null);
    }

    public String getValue() {
        return value;
    }
}
