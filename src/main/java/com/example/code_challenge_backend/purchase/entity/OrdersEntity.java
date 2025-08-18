package com.example.code_challenge_backend.purchase.entity;

import java.time.LocalDateTime;
import java.util.List;

import com.example.code_challenge_backend.purchase.enums.OrderStatusEnum;
import com.example.code_challenge_backend.store.entity.CustomerEntity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "orders", schema = "purchase")
@Getter
@Setter
public class OrdersEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "customer_id", referencedColumnName = "id")
  private CustomerEntity customer;

  @Column(name="order_date")
  private LocalDateTime orderDate;

  @Column(name="status")
  @Enumerated(EnumType.STRING)
  private OrderStatusEnum status;

  @Column(name="total_amount")
  private Double totalAmount;

  @Column(name="created_at")
  private LocalDateTime createdAt;

  @Column(name="updated_at")
  private LocalDateTime updatedAt;
  
  @Column(name="deleted_at")
  private LocalDateTime deletedAt;

  @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private List<OrderDetailEntity> details;
    
}

