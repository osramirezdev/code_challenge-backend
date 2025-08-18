package com.example.code_challenge_backend.purchase.builder;

import com.example.code_challenge_backend.purchase.dto.PriceListDTO;
import com.example.code_challenge_backend.purchase.entity.PriceListEntity;

public interface PriceListDTOBuilder {

    public PriceListDTO build(PriceListEntity priceList);
    
}
