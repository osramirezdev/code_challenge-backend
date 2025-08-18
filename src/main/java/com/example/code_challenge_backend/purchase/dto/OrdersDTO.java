package com.example.code_challenge_backend.purchase.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.example.code_challenge_backend.purchase.enums.OrderStatusEnum;
import com.example.code_challenge_backend.store.dto.CustomerDTO;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrdersDTO {
  private Long id;
  private CustomerDTO customer;
  private LocalDateTime orderDate;
  private OrderStatusEnum status;
  private Double totalAmount;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
  private LocalDateTime deletedAt;

  @JsonManagedReference
  private List<OrderDetailDTO> details;

}
