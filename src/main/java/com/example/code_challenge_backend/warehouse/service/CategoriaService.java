package com.example.code_challenge_backend.warehouse.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.code_challenge_backend.warehouse.dto.CategoriaDTO;
import com.example.code_challenge_backend.web.exceptions.ApiException;

@Service
public interface CategoriaService {

    List<CategoriaDTO> findAll();

    CategoriaDTO findById(Long id) throws ApiException;
}
