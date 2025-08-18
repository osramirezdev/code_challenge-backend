package com.example.code_challenge_backend.purchase.mapper;

import com.example.code_challenge_backend.purchase.dto.OrdersDTO;
import com.example.code_challenge_backend.purchase.entity.OrdersEntity;
import com.example.code_challenge_backend.store.mapper.CustomerDTOMapper;

import java.util.List;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {CustomerDTOMapper.class, OrderDetailDTOMapper.class})
public interface OrdersDTOMapper {

    OrdersDTO toDto(OrdersEntity entity);

    OrdersEntity toEntity(OrdersDTO dto);

    List<OrdersDTO> toDtoList(List<OrdersEntity> entities);

    List<OrdersEntity> toEntityList(List<OrdersDTO> dtos);
}
