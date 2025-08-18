package com.example.code_challenge_backend.store.dto;

import java.time.OffsetDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDTO {

  private Long id;

  private String name;

  private String code;

  private String description;

  private OffsetDateTime createdAt;

  private OffsetDateTime updatedAt;

  private OffsetDateTime deletedAt;
    
}
