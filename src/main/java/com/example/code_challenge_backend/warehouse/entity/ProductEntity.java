package com.example.code_challenge_backend.warehouse.entity;

import java.time.OffsetDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "product", schema = "warehouse")
@Getter
@Setter
public class ProductEntity {

  @Id
  @Column(name = "id")
  private Long id;

  @Column(name="name")
  private String name;

  @Column(name="description")
  private String description;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "categoria_id", referencedColumnName = "id")
  private CategoriaEntity categoria;

  @Column(name="created_at")
  private OffsetDateTime createdAt;

  @Column(name="updated_at")
  private OffsetDateTime updatedAt;
  
  @Column(name="deleted_at")
  private OffsetDateTime deletedAt;
    
}
