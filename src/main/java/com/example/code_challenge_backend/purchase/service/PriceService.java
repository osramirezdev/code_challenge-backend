package com.example.code_challenge_backend.purchase.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.code_challenge_backend.purchase.dto.CategoryQuantitiesDTO;
import com.example.code_challenge_backend.purchase.dto.PriceListDTO;
import com.example.code_challenge_backend.web.exceptions.ApiException;

@Service
public interface PriceService {

    List<PriceListDTO> findAll();

    PriceListDTO findById(Long id) throws ApiException;

    public List<PriceListDTO> calculatePriceByCategoriaIdCategory(List<CategoryQuantitiesDTO> quantities) throws ApiException;
}
