package com.example.code_challenge_backend.purchase.dto;

import com.example.code_challenge_backend.warehouse.dto.ProductDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDetailDTO {

  private Long id;

  @JsonBackReference
  private OrdersDTO order;
  private ProductDTO product;
  private Integer quantity;
  private Double unitPrice;
  private Double subTotal;
    
}
