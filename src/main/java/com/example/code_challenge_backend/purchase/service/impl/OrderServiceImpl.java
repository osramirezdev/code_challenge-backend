package com.example.code_challenge_backend.purchase.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.example.code_challenge_backend.web.exceptions.ApiException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.code_challenge_backend.purchase.dto.OrderRequestDTO;
import com.example.code_challenge_backend.purchase.dto.OrdersDTO;
import com.example.code_challenge_backend.purchase.entity.OrderDetailEntity;
import com.example.code_challenge_backend.purchase.entity.OrdersEntity;
import com.example.code_challenge_backend.purchase.mapper.OrderDetailDTOMapper;
import com.example.code_challenge_backend.purchase.mapper.OrdersDTOMapper;
import com.example.code_challenge_backend.purchase.repository.OrderDetailRepository;
import com.example.code_challenge_backend.purchase.repository.OrdersRepository;
import com.example.code_challenge_backend.purchase.service.OrderService;
import com.example.code_challenge_backend.store.entity.CustomerEntity;
import com.example.code_challenge_backend.store.repository.CustomerRepository;
import com.example.code_challenge_backend.warehouse.entity.ProductEntity;
import com.example.code_challenge_backend.warehouse.repository.ProductRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrdersRepository orderRepository;
    private final OrdersDTOMapper orderDTOMapper;
    private final OrderDetailRepository orderDetailRepository;
    private final OrderDetailDTOMapper orderDetailDTOMapper;
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;


    public List<OrdersDTO> findAllWithDetails() {
        List<OrdersEntity> entities = this.orderRepository.findAllWithDetails();
        return orderDTOMapper.toDtoList(entities);
    }

    public OrdersDTO findById(Long id) throws ApiException {
        OrdersEntity entity = this.orderRepository.findById(id)
                .orElseThrow(() -> new ApiException("Orders not found with id " + id));
        return orderDTOMapper.toDto(entity);
    }

    @Override
    @Transactional
    public OrdersDTO createOrder(OrderRequestDTO orderRequest) throws ApiException {
        Long customerId = orderRequest.getOrder().getCustomer().getId();
        CustomerEntity customerEntity = this.customerRepository.findById(customerId)
            .orElseThrow(() -> new ApiException("Customer not found with id " + customerId));
        OrdersEntity orderEntity = this.orderDTOMapper.toEntity(orderRequest.getOrder());
        orderEntity.setCustomer(customerEntity);

        this.orderRepository.save(orderEntity);

        List<OrderDetailEntity> detailEntities = orderRequest.getDetails().stream()
            .map(detailDTO -> {
                ProductEntity productEntity = this.productRepository.findById(detailDTO.getProduct().getId())
                    .orElseThrow(() -> new RuntimeException(
                        "Product not found with id " + detailDTO.getProduct().getId()
                    ));

                OrderDetailEntity detailEntity = orderDetailDTOMapper.toEntity(detailDTO);
                detailEntity.setOrder(orderEntity);
                detailEntity.setProduct(productEntity);
                return detailEntity;
            })
            .collect(Collectors.toList());

        orderDetailRepository.saveAll(detailEntities);

        return this.orderDTOMapper.toDto(orderEntity);
    }
}

