package com.mountains.micro.common.exception;


import com.mountains.micro.common.api.ApiCode;

import java.io.Serial;

public class ParamValidationException extends BusinessException {

    @Serial
    private static final long serialVersionUID = -3515530024176826581L;

    public ParamValidationException() {
        super();
        setErrorCode(ApiCode.PARAM_VALIDATION_EXCEPTION.getCode());
        setMessage(ApiCode.PARAM_VALIDATION_EXCEPTION.getMessage());
    }

    public ParamValidationException(String message) {
        super(message);
        setErrorCode(ApiCode.PARAM_VALIDATION_EXCEPTION.getCode());
    }
}
