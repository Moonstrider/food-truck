package com.mountains.micro.common.exception;

import com.mountains.micro.common.api.ApiCode;

import java.io.Serial;

public class NullValidationException extends ParamValidationException {

    @Serial
    private static final long serialVersionUID = 6232838936722311360L;

    public NullValidationException(String message) {
        super();
        setErrorCode(ApiCode.NULL_VALIDATION_EXCEPTION.getCode());
        setMessage(String.format(ApiCode.NULL_VALIDATION_EXCEPTION.getMessage(), message));
    }
}
