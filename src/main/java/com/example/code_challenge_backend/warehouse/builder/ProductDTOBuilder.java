package com.example.code_challenge_backend.warehouse.builder;

import com.example.code_challenge_backend.warehouse.dto.ProductDTO;
import com.example.code_challenge_backend.warehouse.entity.ProductEntity;

public interface ProductDTOBuilder {

    public ProductDTO build(ProductEntity product);
    
}
