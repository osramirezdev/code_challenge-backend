package com.example.code_challenge_backend.web.exceptions;


import com.example.code_challenge_backend.web.response.ObjectResponseDTO;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Locale;
import java.util.Objects;


@RestControllerAdvice
public class ApiExceptionHandler {
    
    private final MessageSource messageSource;

    public ApiExceptionHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ObjectResponseDTO<Void>> handleApiException(ApiException ex) {
        String message = resolveMessage(ex.getErrorCode(), ex.getParams());
        HttpStatus status = mapErrorCodeToStatus(ex.getErrorCode());

        ObjectResponseDTO<Void> body = ObjectResponseDTO.<Void>builder()
                .success(false)
                .httpStatus(status)
                .errorCode(ex.getErrorCode())
                .message(message)
                .build();

        return new ResponseEntity<>(body, status);
    }

    @ExceptionHandler(ApiRuntimeException.class)
    public ResponseEntity<ObjectResponseDTO<Void>> handleApiRuntime(ApiRuntimeException ex) {
        HttpStatus status = mapErrorCodeToStatus(ex.getErrorCode());
        String message = resolveMessage(ex.getErrorCode(), ex.getParams());

        ObjectResponseDTO<Void> body = ObjectResponseDTO.<Void>builder()
                .success(false)
                .httpStatus(status)
                .errorCode(ex.getErrorCode())
                .message(message)
                .build();

        return new ResponseEntity<>(body, status);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ObjectResponseDTO<Void>> handleException(Exception ex) {
        ex.printStackTrace();

        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        ObjectResponseDTO<Void> body = ObjectResponseDTO.<Void>builder()
                .success(false)
                .httpStatus(status)
                .errorCode("internal.server.error")
                .message("Internal server error")
                .build();

        return new ResponseEntity<>(body, status);
    }

    private HttpStatus mapErrorCodeToStatus(String errorCode) {
        if (errorCode == null) return HttpStatus.INTERNAL_SERVER_ERROR;
        String code = errorCode.toLowerCase();

        if (code.contains(".not.found") || code.contains("not.found")) {
            return HttpStatus.NOT_FOUND;
        } else if (code.contains(".persistence") || code.contains("persistence")) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        } else if (code.contains("parameter.required") || code.contains("parameter.invalid")) {
            return HttpStatus.BAD_REQUEST;
        } else if (code.contains(".not.allowed") || code.contains("not.allowed")) {
            return HttpStatus.FORBIDDEN;
        } else if (code.contains("property.duplicate")) {
            return HttpStatus.CONFLICT;
        } else {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }

    private String resolveMessage(String code, Object[] params) {
        try {
            if (messageSource != null && code != null) {
                Locale locale = LocaleContextHolder.getLocale();
                return messageSource.getMessage(code, params, code, locale);
            }
        } catch (Exception ignored) { }

        if (params != null && params.length > 0) {
            return code + " " + java.util.Arrays.toString(params);
        }
        return Objects.toString(code, "error");
    }
}