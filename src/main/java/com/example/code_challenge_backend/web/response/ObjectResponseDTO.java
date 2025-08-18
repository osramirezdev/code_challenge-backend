package com.example.code_challenge_backend.web.response;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class ObjectResponseDTO<T> {
    private boolean success;
    private String errorCode;
    private String message;
    private HttpStatus httpStatus;
    private T dto;

    public static <T> ObjectResponseDTO<T> success(T dto) {
        return ObjectResponseDTO.<T>builder()
                .success(true)
                .httpStatus(HttpStatus.OK)
                .dto(dto)
                .build();
    }

    public static <T> ObjectResponseDTO<T> created(T dto) {
        return ObjectResponseDTO.<T>builder()
                .success(true)
                .httpStatus(HttpStatus.CREATED)
                .dto(dto)
                .build();
    }

    public static ObjectResponseDTO<Void> success() {
        return ObjectResponseDTO.<Void>builder()
                .success(true)
                .httpStatus(HttpStatus.OK)
                .build();
    }

    public static ObjectResponseDTO<Void> noContent() {
        return ObjectResponseDTO.<Void>builder()
                .success(true)
                .httpStatus(HttpStatus.NO_CONTENT)
                .build();
    }

    public static ObjectResponseDTO<Void> error() {
        return ObjectResponseDTO.<Void>builder()
                .success(false)
                .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                .build();
    }

    public static ObjectResponseDTO<Void> badRequest() {
        return ObjectResponseDTO.<Void>builder()
                .success(false)
                .httpStatus(HttpStatus.BAD_REQUEST)
                .build();
    }
}
