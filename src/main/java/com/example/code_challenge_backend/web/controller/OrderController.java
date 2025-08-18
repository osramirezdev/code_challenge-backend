package com.example.code_challenge_backend.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.code_challenge_backend.constants.ApiPaths;
import com.example.code_challenge_backend.purchase.dto.OrderRequestDTO;
import com.example.code_challenge_backend.purchase.dto.OrdersDTO;
import com.example.code_challenge_backend.purchase.service.OrderService;
import com.example.code_challenge_backend.web.exceptions.ApiException;
import com.example.code_challenge_backend.web.response.ObjectResponseDTO;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @RequestMapping(value = ApiPaths.ROOT_ORDER, method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ObjectResponseDTO> getOrders() throws ApiException {
        return ResponseEntity.ok(ObjectResponseDTO
                .success(this.orderService.findAllWithDetails()));
    }

    @GetMapping(ApiPaths.ORDER_BY_ID)
    public ResponseEntity<ObjectResponseDTO<OrdersDTO>> getOrderById(
            @PathVariable("id") Long id) throws ApiException {
        return ResponseEntity.ok(
                ObjectResponseDTO.success(this.orderService.findById(id))
        );
    }

    @RequestMapping(value = ApiPaths.ORDER_CREATE, method = RequestMethod.POST,
    produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ObjectResponseDTO<OrdersDTO>> createFullOrder(
            @RequestBody OrderRequestDTO orderRequest) throws ApiException {
        OrdersDTO newOrder = this.orderService.createOrder(orderRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(ObjectResponseDTO.success(newOrder));
    }


}
