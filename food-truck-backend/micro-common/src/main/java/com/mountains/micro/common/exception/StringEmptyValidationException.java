package com.mountains.micro.common.exception;

import com.mountains.micro.common.api.ApiCode;

import java.io.Serial;

public class StringEmptyValidationException extends ParamValidationException {

    @Serial
    private static final long serialVersionUID = 1682838936722311360L;

    public StringEmptyValidationException(String message) {
        super();
        setErrorCode(ApiCode.STRING_EMPTY_VALIDATION_EXCEPTION.getCode());
        setMessage(String.format(ApiCode.STRING_EMPTY_VALIDATION_EXCEPTION.getMessage(), message));
    }
}
