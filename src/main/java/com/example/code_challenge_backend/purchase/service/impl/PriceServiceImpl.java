package com.example.code_challenge_backend.purchase.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.code_challenge_backend.purchase.dto.CategoryQuantitiesDTO;
import com.example.code_challenge_backend.purchase.dto.PriceListDTO;
import com.example.code_challenge_backend.purchase.entity.PriceListEntity;
import com.example.code_challenge_backend.purchase.mapper.PriceListDTOMapper;
import com.example.code_challenge_backend.purchase.repository.PriceListRepository;
import com.example.code_challenge_backend.purchase.service.PriceService;
import com.example.code_challenge_backend.warehouse.mapper.ProductDTOMapper;
import com.example.code_challenge_backend.web.exceptions.ApiException;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class PriceServiceImpl implements PriceService {

    private final PriceListDTOMapper priceListDTOMapper;
    private final ProductDTOMapper productDTOMapper;
    private final PriceListRepository priceListRepository;

    public List<PriceListDTO> findAll() {
        List<PriceListEntity> entities = this.priceListRepository.findAll();
        return priceListDTOMapper.toDtoList(entities);
    }

    public PriceListDTO findById(Long id) throws ApiException {
        PriceListEntity entity = this.priceListRepository.findById(id)
                .orElseThrow(() -> new ApiException("Price list not found with id " + id));
        return priceListDTOMapper.toDto(entity);
    }

    public List<PriceListDTO> calculatePriceByCategoriaIdCategory(List<CategoryQuantitiesDTO> quantities) throws ApiException {
        List<Long> categoryIds = quantities.stream()
                .map(CategoryQuantitiesDTO::getCategoria_id)
                .collect(Collectors.toList());

        List<PriceListEntity> priceLists = priceListRepository.findByProductCategoriaIdIn(categoryIds);

        return priceLists.stream()
                .map(pl -> {
                    Integer quantity = quantities.stream()
                            .filter(q -> q.getCategoria_id().equals(pl.getProduct().getCategoria().getId()))
                            .map(CategoryQuantitiesDTO::getQuantity)
                            .findFirst()
                            .orElse(0);

                    PriceListDTO dto = priceListDTOMapper.toDto(pl);

                    if (quantity >= pl.getAvgDiscount()) {
                        dto.setMinPrice(pl.getFinalPrice());
                    } else {
                        dto.setFinalPrice(pl.getFinalPrice());
                    }

                    return dto;
                })
                .collect(Collectors.toList());
    }
}

