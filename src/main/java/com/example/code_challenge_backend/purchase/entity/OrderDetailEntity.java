package com.example.code_challenge_backend.purchase.entity;

import com.example.code_challenge_backend.warehouse.entity.ProductEntity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "order_detail", schema = "purchase")
@Getter
@Setter
public class OrderDetailEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "order_id", referencedColumnName = "id")
  private OrdersEntity order;

  @ManyToOne
  @JoinColumn(name = "product_id", referencedColumnName = "id")
  private ProductEntity product;

  @Column(name="quantity")
  private Integer quantity;

  @Column(name="unit_price")
  private Double unitPrice;

  @Column(name="sub_total")
  private Double subTotal;
    
}
