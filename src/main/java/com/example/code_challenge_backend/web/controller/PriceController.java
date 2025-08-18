package com.example.code_challenge_backend.web.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.code_challenge_backend.constants.ApiPaths;
import com.example.code_challenge_backend.purchase.dto.CategoryQuantitiesDTO;
import com.example.code_challenge_backend.purchase.dto.PriceListDTO;
import com.example.code_challenge_backend.purchase.service.PriceService;
import com.example.code_challenge_backend.web.exceptions.ApiException;
import com.example.code_challenge_backend.web.response.ObjectResponseDTO;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class PriceController {

    private final PriceService priceService;

    @RequestMapping(value = ApiPaths.ROOT_PRICE, method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ObjectResponseDTO> getPriceLists() throws ApiException {
        return ResponseEntity.ok(ObjectResponseDTO
                .success(this.priceService.findAll()));
    }

    @GetMapping(ApiPaths.PRICE_BY_ID)
    public ResponseEntity<ObjectResponseDTO<PriceListDTO>> getPriceListById(
            @PathVariable("id") Long id) throws ApiException {
        return ResponseEntity.ok(
                ObjectResponseDTO.success(this.priceService.findById(id))
        );
    }

    @RequestMapping(value = ApiPaths.PRICE_BY_CATEGORY_ID_AND_QUANTITY, method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ObjectResponseDTO<List<PriceListDTO>>> getPricesByCategoryAndQuantity(
            @RequestBody List<CategoryQuantitiesDTO> quantities) throws ApiException {
        return ResponseEntity.ok(ObjectResponseDTO.success(this.priceService.calculatePriceByCategoriaIdCategory(quantities)));
    }


}
