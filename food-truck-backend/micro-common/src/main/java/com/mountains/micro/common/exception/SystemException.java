package com.mountains.micro.common.exception;

import com.mountains.micro.common.api.ApiCode;

import java.io.Serial;

public class SystemException extends ApplicationException {

    @Serial
    private static final long serialVersionUID = 3218977558715022067L;

    public SystemException(String message) {
        super(message);
        setErrorCode(ApiCode.SYSTEM_EXCEPTION.getCode());
    }

    public SystemException() {
        super();
        setErrorCode(ApiCode.SYSTEM_EXCEPTION.getCode());
        setMessage(ApiCode.SYSTEM_EXCEPTION.getMessage());
    }

    public SystemException(String message, Throwable cause) {
        super(message, cause);
        setErrorCode(ApiCode.SYSTEM_EXCEPTION.getCode());
    }

    public SystemException(Throwable cause) {
        super(cause);
        setErrorCode(ApiCode.SYSTEM_EXCEPTION.getCode());
        setMessage(ApiCode.SYSTEM_EXCEPTION.getMessage());
    }

}
