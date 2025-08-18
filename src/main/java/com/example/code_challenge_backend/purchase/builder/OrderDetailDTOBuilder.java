package com.example.code_challenge_backend.purchase.builder;

import com.example.code_challenge_backend.purchase.dto.OrderDetailDTO;
import com.example.code_challenge_backend.purchase.entity.OrderDetailEntity;

public interface OrderDetailDTOBuilder {

    public OrderDetailDTO build(OrderDetailEntity orderDetail);
    
}
