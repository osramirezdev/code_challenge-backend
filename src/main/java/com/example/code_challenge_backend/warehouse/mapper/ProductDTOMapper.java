package com.example.code_challenge_backend.warehouse.mapper;

import com.example.code_challenge_backend.mapper.DateMapper;
import com.example.code_challenge_backend.warehouse.dto.ProductDTO;
import com.example.code_challenge_backend.warehouse.entity.ProductEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = { CategoriaDTOMapper.class, DateMapper.class })
public interface ProductDTOMapper {

    ProductDTO toDto(ProductEntity entity);

    ProductEntity toEntity(ProductDTO dto);

    List<ProductDTO> toDtoList(List<ProductEntity> entities);

    List<ProductEntity> toEntityList(List<ProductDTO> dtos);
}
