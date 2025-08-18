package com.example.code_challenge_backend.web.exceptions;

import com.example.code_challenge_backend.constants.ApiModules;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
public class ApiException extends Exception {
    private static final long serialVersionUID = 1L;
    public static final String NOT_FOUND = ".not.found";
    public static final String PERSISTENCE = ".persistence.error";
    public static final String PARAMETER_REQUIRED = "parameter.required";
    public static final String PARAMETER_INVALID = "parameter.invalid";
    public static final String NOT_ALLOWED = ".not.allowed";
    public static final String PROPERTY_DUPLICATE = "property.duplicate.error";
    private static final String UNSUPPORTED_FILE_EXTENSION = "unsupported.file.extension";
    private static final String MAPPER_ERROR =  "mapper.error";

    private String errorCode;
    private Object[] params;

    public ApiException(String messageKey) {
        super(messageKey);
        this.errorCode = messageKey;
    }

    public ApiException(String messageKey, Object... params) {
        this(messageKey);
        this.params = params;
    }

    private ApiException(Throwable cause){
        super(cause);
    }

    public static ApiException notFound(ApiModules module, Long id) {
        return new ApiException(module.getValue() + NOT_FOUND, id);
    }

    public static ApiException notFound(ApiModules module, String entityIdentifier) {
        return new ApiException(module.getValue() + NOT_FOUND, entityIdentifier);
    }

    public static ApiException notFound(ApiModules module, Object... objects) {
        return new ApiException(module.getValue() + NOT_FOUND, objects);
    }

    public static ApiException notFound( Object... objects) {
        return new ApiException(NOT_FOUND,  objects);
    }

    public static ApiException requiredParameter(String name) {
        return new ApiException(PARAMETER_REQUIRED, name);
    }

    public static ApiException invalidParameter(String name) {
        return new ApiException(PARAMETER_INVALID, name);
    }

    public static ApiException duplicate(String property, String value) {
        return new ApiException(PROPERTY_DUPLICATE, property, value);
    }

    public static ApiException persist(ApiModules module, Long id) {
        return new ApiException(module.getValue() + PERSISTENCE, id);
    }

    public static ApiException persist(ApiModules module) {
        return persist(module, null);
    }

    public static ApiException notAllowed(ApiModules module, String userName) {
        return new ApiException(module.getValue() + NOT_ALLOWED, userName);
    }

    public static ApiException unsupportedFileWithExtension(String fileExtension) {
        return new ApiException(UNSUPPORTED_FILE_EXTENSION, fileExtension);
    }

    public static ApiException fromApiRuntimeException(ApiRuntimeException ex) {
        ApiException apiException  =  new ApiException(ex.getCause());
        apiException.errorCode = ex.getErrorCode();
        apiException.params  = ex.getParams();
        return apiException;
    }

    public static ApiException mapperErrorException(String message) {
        return new ApiException(MAPPER_ERROR, message);
    }
}
