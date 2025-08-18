package com.example.code_challenge_backend.warehouse.service.impl;

import java.util.List;

import com.example.code_challenge_backend.web.exceptions.ApiException;
import org.springframework.stereotype.Service;

import com.example.code_challenge_backend.warehouse.dto.CategoriaDTO;
import com.example.code_challenge_backend.warehouse.entity.CategoriaEntity;
import com.example.code_challenge_backend.warehouse.mapper.CategoriaDTOMapper;
import com.example.code_challenge_backend.warehouse.repository.CategoriaRepository;
import com.example.code_challenge_backend.warehouse.service.CategoriaService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaDTOMapper productDTOMapper;
    private final CategoriaRepository productRepository;

    public List<CategoriaDTO> findAll() {
        List<CategoriaEntity> entities = this.productRepository.findAll();
        return productDTOMapper.toDtoList(entities);
    }

    public CategoriaDTO findById(Long id) throws ApiException {
        CategoriaEntity entity = this.productRepository.findById(id)
                .orElseThrow(() -> new ApiException("Categoria not found with id " + id));
        return productDTOMapper.toDto(entity);
    }
}

