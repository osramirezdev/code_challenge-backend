package com.example.code_challenge_backend.purchase.dto;

import java.time.LocalDateTime;

import com.example.code_challenge_backend.warehouse.dto.ProductDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PriceListDTO {

  private Long id;
  private String name;
  private String description;
  private ProductDTO product;
  private Double minPrice;
  private Double avgDiscount;
  private Double finalPrice;
  private Integer stock;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
  private LocalDateTime deletedAt;
    
}
