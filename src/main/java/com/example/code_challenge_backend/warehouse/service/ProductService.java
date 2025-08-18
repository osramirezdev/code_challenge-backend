package com.example.code_challenge_backend.warehouse.service;

import java.util.List;

import com.example.code_challenge_backend.purchase.dto.PriceListDTO;
import org.springframework.stereotype.Service;

import com.example.code_challenge_backend.warehouse.dto.ProductDTO;
import com.example.code_challenge_backend.web.exceptions.ApiException;

@Service
public interface ProductService {

    List<ProductDTO> findAll();

    ProductDTO findByIdWithCat(Long id) throws ApiException;
}
