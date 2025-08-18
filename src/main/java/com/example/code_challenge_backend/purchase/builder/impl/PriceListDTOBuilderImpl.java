package com.example.code_challenge_backend.purchase.builder.impl;

import com.example.code_challenge_backend.purchase.builder.PriceListDTOBuilder;
import com.example.code_challenge_backend.purchase.dto.PriceListDTO;
import com.example.code_challenge_backend.purchase.entity.PriceListEntity;

public class PriceListDTOBuilderImpl implements PriceListDTOBuilder {

    @Override
    public PriceListDTO build(PriceListEntity orders) {
            PriceListDTO dto = new PriceListDTO();
    
            dto.setId(orders.getId());
            dto.setName(orders.getName());
            dto.setDescription(orders.getDescription()); // ver mapper DI
            dto.setMinPrice(orders.getMinPrice());
            dto.setAvgDiscount(orders.getAvgDiscount());
            dto.setFinalPrice(orders.getFinalPrice());
    
            return dto;
        }

}
