package com.example.code_challenge_backend.purchase.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.code_challenge_backend.purchase.dto.OrderRequestDTO;
import com.example.code_challenge_backend.purchase.dto.OrdersDTO;
import com.example.code_challenge_backend.web.exceptions.ApiException;

@Service
public interface OrderService {

    List<OrdersDTO> findAllWithDetails();

    OrdersDTO findById(Long id) throws ApiException;

    OrdersDTO createOrder(OrderRequestDTO orderRequest) throws ApiException;
}
