package com.example.code_challenge_backend.constants;

public class ApiPaths {
    public static final String BASE = "/api";

    public static final String SUFFIX_FILTER = "/filter";
    public static final String SUFFIX_SEARCH = "/search";
    public static final String SUFFIX_ITEMS = "/items";
    public static final String SUFFIX_ITEM = "/item";
    public static final String SUFFIX_FIND = "/find";
    public static final String SUFFIX_STATUS = "/status";
    public static final String SUFFIX_DETAIL = "/detail";

    public static final String PARAM_ID = "/{id}";

    public static final String PARAM_DOCUMENT_NUMBER= "/document-number/{documentNumber}";
    public static final String PARAM_STATUS = "/{status}";
    public static final String PARAM_PRODUCT_CODE = "/{productCode}";
    public static final String PARAM_DOMAIN = "/{domain}";

    /**
     * PRODUCT
    */
    private static final String BASE_PRODUCT = "/product";
    public static final String ROOT_PRODUCT = BASE + BASE_PRODUCT;
    public static final String PRODUCT_BY_ID = ROOT_PRODUCT + PARAM_ID;
    public static final String PRODUCT_PRICE_BY_ID = ROOT_PRODUCT + "price-by-product-id" + PARAM_ID;

    /**
     * PRICELIST
    */
    private static final String BASE_PRICE = "/price";
    public static final String ROOT_PRICE = BASE + BASE_PRICE;
    public static final String PRICE_BY_ID = ROOT_PRICE + PARAM_ID;
    public static final String PRICE_BY_PRODUCT_ID_AND_QUANTITY = ROOT_PRICE + "/by-product-and-quantity/";
    public static final String PRICE_BY_CATEGORY_ID_AND_QUANTITY = ROOT_PRICE + "/by-category-and-quantity/";

    /**
     * CUSTOMER
    */
    private static final String BASE_CUSTOMER = "/customer";
    public static final String ROOT_CUSTOMER = BASE + BASE_CUSTOMER;
    public static final String CUSTOMER_BY_ID = ROOT_CUSTOMER + PARAM_ID;

    /**
     * CAT
    */
    private static final String BASE_CATEGORIA = "/categoria";
    public static final String ROOT_CATEGORIA = BASE + BASE_CATEGORIA;
    public static final String CATEGORIA_BY_ID = ROOT_CATEGORIA + PARAM_ID;

    /**
     * ORDERS
    */
    private static final String BASE_ORDER = "/order";
    public static final String ROOT_ORDER = BASE + BASE_ORDER;
    public static final String ORDER_BY_ID = ROOT_ORDER + PARAM_ID;
    public static final String ORDER_CREATE = ROOT_ORDER + "/create";

    private ApiPaths() {
    }
}
