package com.example.code_challenge_backend.store.entity;

import java.time.OffsetDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "customer", schema = "store")
@Getter
@Setter
public class CustomerEntity {

  @Id
  @Column(name = "id")
  private Long id;

  @Column(name="name")
  private String name;

  @Column(name="code")
  private String code;

  @Column(name="description")
  private String description;

  @Column(name="created_at")
  private OffsetDateTime createdAt;

  @Column(name="updated_at")
  private OffsetDateTime updatedAt;

  @Column(name="deleted_at")
  private OffsetDateTime deletedAt;
    
}
