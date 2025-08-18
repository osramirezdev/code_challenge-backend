package com.example.code_challenge_backend.warehouse.builder;

import com.example.code_challenge_backend.warehouse.dto.CategoriaDTO;
import com.example.code_challenge_backend.warehouse.entity.CategoriaEntity;

public interface CategoriaDTOBuilder {

    public CategoriaDTO build(CategoriaEntity categoria);
    
}
