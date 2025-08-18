package com.example.code_challenge_backend.purchase.builder;

import com.example.code_challenge_backend.purchase.dto.OrdersDTO;
import com.example.code_challenge_backend.purchase.entity.OrdersEntity;

public interface OrdersDTOBuilder {

    public OrdersDTO build(OrdersEntity orders);
    
}
