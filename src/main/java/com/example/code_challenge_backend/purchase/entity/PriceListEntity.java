package com.example.code_challenge_backend.purchase.entity;

import java.time.LocalDateTime;

import com.example.code_challenge_backend.warehouse.entity.ProductEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "price_list", schema = "purchase")
@Getter
@Setter
public class PriceListEntity {

  @Id
  @Column(name = "id")
  private Long id;

  @Column(name="name")
  private String name;

  @Column(name="description")
  private String description;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "product_id", referencedColumnName = "id")
  private ProductEntity product;

  @Column(name="min_price")
  private Double minPrice;

  @Column(name="avg_discount")
  private Double avgDiscount;

  @Column(name="final_price")
  private Double finalPrice;

  @Column(name="stock")
  private Integer stock;

  @Column(name="created_at")
  private LocalDateTime createdAt;

  @Column(name="updated_at")
  private LocalDateTime updatedAt;
  
  @Column(name="deleted_at")
  private LocalDateTime deletedAt;
    
}
