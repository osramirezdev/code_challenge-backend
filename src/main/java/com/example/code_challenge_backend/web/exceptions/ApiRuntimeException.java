package com.example.code_challenge_backend.web.exceptions;

public class ApiRuntimeException extends RuntimeException {

    private final String errorCode;
    private final transient Object[] params;

    public static ApiRuntimeException fromApiException( ApiException apiEx){
        return new ApiRuntimeException(apiEx.getCause(), apiEx.getErrorCode(), apiEx.getParams());
    }

    public ApiRuntimeException(String messageKey, Object... params) {
        super(messageKey);
        this.errorCode = messageKey;
        this.params = params;
    }

    private ApiRuntimeException(Throwable cause, String errorCode, Object[] params){
        super(cause);
        this.errorCode = errorCode;
        this.params = params;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public Object[] getParams() {
        return params;
    }
}
