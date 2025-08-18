package com.example.code_challenge_backend.purchase.builder.impl;

import com.example.code_challenge_backend.purchase.builder.OrderDetailDTOBuilder;
import com.example.code_challenge_backend.purchase.dto.OrderDetailDTO;
import com.example.code_challenge_backend.purchase.entity.OrderDetailEntity;

public class OrderDetailDTOBuilderImpl implements OrderDetailDTOBuilder {

    @Override
    public OrderDetailDTO build(OrderDetailEntity orders) {
            OrderDetailDTO dto = new OrderDetailDTO();
    
            dto.setId(orders.getId());
            dto.setQuantity(orders.getQuantity());
            dto.setUnitPrice(orders.getUnitPrice());
            dto.setSubTotal(orders.getSubTotal());
    
            return dto;
        }

}
