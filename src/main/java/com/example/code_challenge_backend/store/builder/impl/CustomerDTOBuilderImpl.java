package com.example.code_challenge_backend.store.builder.impl;


import com.example.code_challenge_backend.store.builder.CustomerDTOBuilder;
import com.example.code_challenge_backend.store.dto.CustomerDTO;
import com.example.code_challenge_backend.store.entity.CustomerEntity;

public class CustomerDTOBuilderImpl implements CustomerDTOBuilder {

    @Override
    public CustomerDTO build(CustomerEntity customer) {
            CustomerDTO dto = new CustomerDTO();
    
            dto.setId(customer.getId());
            dto.setCode(customer.getCode());
            dto.setDescription(customer.getDescription());
    
            return dto;
        }

}
