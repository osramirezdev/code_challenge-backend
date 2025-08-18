package com.example.code_challenge_backend.warehouse.service.impl;

import java.util.List;
import java.util.Optional;

import com.example.code_challenge_backend.purchase.dto.PriceListDTO;
import com.example.code_challenge_backend.web.exceptions.ApiException;
import org.springframework.stereotype.Service;

import com.example.code_challenge_backend.warehouse.dto.ProductDTO;
import com.example.code_challenge_backend.warehouse.entity.ProductEntity;
import com.example.code_challenge_backend.warehouse.mapper.ProductDTOMapper;
import com.example.code_challenge_backend.warehouse.repository.ProductRepository;
import com.example.code_challenge_backend.warehouse.service.ProductService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductDTOMapper productDTOMapper;
    private final ProductRepository productRepository;

    public List<ProductDTO> findAll() {
        List<ProductEntity> entities = this.productRepository.findAll();
        return productDTOMapper.toDtoList(entities);
    }

    public ProductDTO findByIdWithCat(Long id) throws ApiException {
        ProductEntity entity = this.productRepository.findByIdWithCat(id)
                .orElseThrow(() -> new ApiException("Product not found with id " + id));
        return productDTOMapper.toDto(entity);
    }

}

