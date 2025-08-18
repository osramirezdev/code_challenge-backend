package com.example.code_challenge_backend.purchase.mapper;

import com.example.code_challenge_backend.purchase.dto.OrderDetailDTO;
import com.example.code_challenge_backend.purchase.entity.OrderDetailEntity;
import com.example.code_challenge_backend.warehouse.mapper.ProductDTOMapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper( componentModel = "spring", uses = { ProductDTOMapper.class }
)
public interface OrderDetailDTOMapper {

    @Mapping(target = "order", ignore = true)
    OrderDetailDTO toDto(OrderDetailEntity entity);

    @Mapping(target = "order", ignore = true)
    OrderDetailEntity toEntity(OrderDetailDTO dto);

    List<OrderDetailDTO> toDtoList(List<OrderDetailEntity> entities);

    List<OrderDetailEntity> toEntityList(List<OrderDetailDTO> dtos);
}
