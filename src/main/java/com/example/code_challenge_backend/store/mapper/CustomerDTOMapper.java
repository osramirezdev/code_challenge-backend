package com.example.code_challenge_backend.store.mapper;

import com.example.code_challenge_backend.store.dto.CustomerDTO;
import com.example.code_challenge_backend.store.entity.CustomerEntity;

import java.util.List;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerDTOMapper {

    CustomerDTO toDto(CustomerEntity entity);

    CustomerEntity toEntity(CustomerDTO dto);

    List<CustomerDTO> toDtoList(List<CustomerEntity> entities);

    List<CustomerEntity> toEntityList(List<CustomerDTO> dtos);
}

