package com.example.code_challenge_backend.web.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.code_challenge_backend.constants.ApiPaths;
import com.example.code_challenge_backend.warehouse.dto.CategoriaDTO;
import com.example.code_challenge_backend.warehouse.service.CategoriaService;
import com.example.code_challenge_backend.web.exceptions.ApiException;
import com.example.code_challenge_backend.web.response.ObjectResponseDTO;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CategoriaController {

    private final CategoriaService customerService;

    @RequestMapping(value = ApiPaths.ROOT_CATEGORIA, method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ObjectResponseDTO> getCategorias() throws ApiException {
        return ResponseEntity.ok(ObjectResponseDTO
                .success(this.customerService.findAll()));
    }

    @GetMapping(ApiPaths.CATEGORIA_BY_ID)
    public ResponseEntity<ObjectResponseDTO<CategoriaDTO>> getCategoriaById(
            @PathVariable("id") Long id) throws ApiException {
        return ResponseEntity.ok(
                ObjectResponseDTO.success(this.customerService.findById(id))
        );
    }

}
