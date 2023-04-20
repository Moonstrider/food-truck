package com.mountains.micro.common.exception;


import com.mountains.micro.common.api.ApiCode;

import java.io.Serial;

public class BusinessException extends ApplicationException {

    @Serial
    private static final long serialVersionUID = -1403357122330162359L;

    public BusinessException() {
        super();
        setErrorCode(ApiCode.BUSINESS_EXCEPTION.getCode());
        setMessage(ApiCode.BUSINESS_EXCEPTION.getMessage());
    }

    public BusinessException(String message) {
        super(message);
        setErrorCode(ApiCode.BUSINESS_EXCEPTION.getCode());
    }
}
