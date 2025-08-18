package com.example.code_challenge_backend.store.service.impl;

import java.util.List;
import java.util.Optional;

import com.example.code_challenge_backend.web.exceptions.ApiException;
import org.springframework.stereotype.Service;

import com.example.code_challenge_backend.store.dto.CustomerDTO;
import com.example.code_challenge_backend.store.entity.CustomerEntity;
import com.example.code_challenge_backend.store.mapper.CustomerDTOMapper;
import com.example.code_challenge_backend.store.repository.CustomerRepository;
import com.example.code_challenge_backend.store.service.CustomerService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerDTOMapper customerDTOMapper;
    private final CustomerRepository customerRepository;

    public List<CustomerDTO> findAll() {
        List<CustomerEntity> entities = this.customerRepository.findAll();
        return customerDTOMapper.toDtoList(entities);
    }

    public CustomerDTO findById(Long id) throws ApiException {
        CustomerEntity entity = this.customerRepository.findById(id)
                .orElseThrow(() -> new ApiException("Customer not found with id " + id));
        return customerDTOMapper.toDto(entity);
    }
}

