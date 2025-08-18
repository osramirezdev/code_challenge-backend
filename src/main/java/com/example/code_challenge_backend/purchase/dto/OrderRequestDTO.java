package com.example.code_challenge_backend.purchase.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderRequestDTO {
    private OrdersDTO order;
    private List<OrderDetailDTO> details;
}
