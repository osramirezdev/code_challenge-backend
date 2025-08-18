package com.example.code_challenge_backend.web.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.code_challenge_backend.constants.ApiPaths;
import com.example.code_challenge_backend.store.dto.CustomerDTO;
import com.example.code_challenge_backend.store.service.CustomerService;
import com.example.code_challenge_backend.web.exceptions.ApiException;
import com.example.code_challenge_backend.web.response.ObjectResponseDTO;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @RequestMapping(value = ApiPaths.ROOT_CUSTOMER, method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ObjectResponseDTO> getCustomers() throws ApiException {
        return ResponseEntity.ok(ObjectResponseDTO
                .success(this.customerService.findAll()));
    }

    @GetMapping(ApiPaths.CUSTOMER_BY_ID)
    public ResponseEntity<ObjectResponseDTO<CustomerDTO>> getCustomerById(
            @PathVariable("id") Long id) throws ApiException {
        return ResponseEntity.ok(
                ObjectResponseDTO.success(this.customerService.findById(id))
        );
    }

}
