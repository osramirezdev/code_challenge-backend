package com.example.code_challenge_backend.warehouse.dto;

import java.time.OffsetDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {

  private Long id;

  private String name;

  private String description;

  private CategoriaDTO categoria;

  private OffsetDateTime createdAt;

  private OffsetDateTime updatedAt;

  private OffsetDateTime deletedAt;

}
