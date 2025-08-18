package com.example.code_challenge_backend.warehouse.builder.impl;

import com.example.code_challenge_backend.warehouse.builder.ProductDTOBuilder;
import com.example.code_challenge_backend.warehouse.dto.ProductDTO;
import com.example.code_challenge_backend.warehouse.entity.ProductEntity;

public class ProductDTOBuilderImpl implements ProductDTOBuilder {

    @Override
    public ProductDTO build(ProductEntity product) {
            ProductDTO dto = new ProductDTO();
    
            dto.setId(product.getId());
            dto.setName(product.getName());
            dto.setDescription(product.getDescription());
            dto.setCreatedAt(product.getCreatedAt());
            dto.setUpdatedAt(product.getUpdatedAt());
    
            return dto;
        }

}
