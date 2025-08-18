package com.example.code_challenge_backend.warehouse.mapper;

import com.example.code_challenge_backend.mapper.DateMapper;
import com.example.code_challenge_backend.warehouse.dto.CategoriaDTO;
import com.example.code_challenge_backend.warehouse.entity.CategoriaEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = { DateMapper.class })
public interface CategoriaDTOMapper {

    CategoriaDTO toDto(CategoriaEntity entity);

    CategoriaEntity toEntity(CategoriaDTO dto);

    List<CategoriaDTO> toDtoList(List<CategoriaEntity> entities);

    List<CategoriaEntity> toEntityList(List<CategoriaDTO> dtos);
}
