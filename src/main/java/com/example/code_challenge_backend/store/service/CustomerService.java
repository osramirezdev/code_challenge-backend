package com.example.code_challenge_backend.store.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.code_challenge_backend.store.dto.CustomerDTO;
import com.example.code_challenge_backend.web.exceptions.ApiException;

@Service
public interface CustomerService {

    List<CustomerDTO> findAll();

    CustomerDTO findById(Long id) throws ApiException;
}
