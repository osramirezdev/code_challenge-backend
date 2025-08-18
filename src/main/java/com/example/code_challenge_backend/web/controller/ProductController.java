package com.example.code_challenge_backend.web.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.code_challenge_backend.constants.ApiPaths;
import com.example.code_challenge_backend.warehouse.dto.ProductDTO;
import com.example.code_challenge_backend.warehouse.service.ProductService;
import com.example.code_challenge_backend.web.exceptions.ApiException;
import com.example.code_challenge_backend.web.response.ObjectResponseDTO;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @RequestMapping(value = ApiPaths.ROOT_PRODUCT, method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ObjectResponseDTO> getProducts() throws ApiException {
        return ResponseEntity.ok(ObjectResponseDTO
                .success(this.productService.findAll()));
    }

    @GetMapping(ApiPaths.PRODUCT_BY_ID)
    public ResponseEntity<ObjectResponseDTO<ProductDTO>> getProductById(
            @PathVariable("id") Long id) throws ApiException {
        return ResponseEntity.ok(
                ObjectResponseDTO.success(this.productService.findByIdWithCat(id))
        );
    }

    @GetMapping(ApiPaths.PRODUCT_PRICE_BY_ID)
    public ResponseEntity<ObjectResponseDTO<ProductDTO>> getProductPriceById(
            @PathVariable("id") Long id) throws ApiException {
        return ResponseEntity.ok(
                ObjectResponseDTO.success(this.productService.findByIdWithCat(id))
        );
    }
}
