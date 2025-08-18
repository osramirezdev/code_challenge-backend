package com.example.code_challenge_backend.purchase.builder.impl;

import com.example.code_challenge_backend.purchase.builder.OrdersDTOBuilder;
import com.example.code_challenge_backend.purchase.dto.OrdersDTO;
import com.example.code_challenge_backend.purchase.entity.OrdersEntity;

public class OrdersDTOBuilderImpl implements OrdersDTOBuilder {

    @Override
    public OrdersDTO build(OrdersEntity orders) {
            OrdersDTO dto = new OrdersDTO();
    
            dto.setId(orders.getId());
            dto.setOrderDate(orders.getOrderDate());
            dto.setStatus(orders.getStatus());
            dto.setTotalAmount(orders.getTotalAmount());
            dto.setCreatedAt(orders.getCreatedAt());
            dto.setUpdatedAt(orders.getUpdatedAt());
    
            return dto;
        }

}
