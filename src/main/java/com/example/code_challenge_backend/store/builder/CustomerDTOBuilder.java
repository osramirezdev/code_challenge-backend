package com.example.code_challenge_backend.store.builder;

import com.example.code_challenge_backend.store.dto.CustomerDTO;
import com.example.code_challenge_backend.store.entity.CustomerEntity;

public interface CustomerDTOBuilder {

    public CustomerDTO build(CustomerEntity customer);
    
}
