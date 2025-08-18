package com.example.code_challenge_backend.purchase.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.example.code_challenge_backend.purchase.dto.PriceListDTO;
import com.example.code_challenge_backend.purchase.entity.PriceListEntity;
import com.example.code_challenge_backend.warehouse.mapper.ProductDTOMapper;

@Mapper(componentModel = "spring", uses = {ProductDTOMapper.class})
public interface PriceListDTOMapper {

    PriceListDTO toDto(PriceListEntity entity);

    PriceListEntity toEntity(PriceListDTO dto);

    List<PriceListDTO> toDtoList(List<PriceListEntity> entities);

    List<PriceListEntity> toEntityList(List<PriceListDTO> dtos);
}
