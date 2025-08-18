package com.example.code_challenge_backend.warehouse.builder.impl;

import com.example.code_challenge_backend.warehouse.builder.CategoriaDTOBuilder;
import com.example.code_challenge_backend.warehouse.dto.CategoriaDTO;
import com.example.code_challenge_backend.warehouse.entity.CategoriaEntity;

public class CategoriaDTOBuilderImpl implements CategoriaDTOBuilder {

    @Override
    public CategoriaDTO build(CategoriaEntity categoria) {
            CategoriaDTO dto = new CategoriaDTO();
    
            dto.setId(categoria.getId());
            dto.setName(categoria.getName());
            dto.setDescription(categoria.getDescription());
            dto.setCreatedAt(categoria.getCreatedAt());
            dto.setUpdatedAt(categoria.getUpdatedAt());
    
            return dto;
        }

}
