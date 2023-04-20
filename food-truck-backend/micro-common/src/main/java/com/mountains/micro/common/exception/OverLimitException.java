package com.mountains.micro.common.exception;


import com.mountains.micro.common.api.ApiCode;

import java.io.Serial;

public class OverLimitException extends ApplicationException {

    @Serial
    private static final long serialVersionUID = -6245530024176826581L;

    public OverLimitException() {
        super();
        setErrorCode(ApiCode.OVER_LIMIT_EXCEPTION.getCode());
        setMessage(ApiCode.OVER_LIMIT_EXCEPTION.getMessage());
    }

    public OverLimitException(String message) {
        super(message);
        setErrorCode(ApiCode.OVER_LIMIT_EXCEPTION.getCode());
    }

    public OverLimitException(ApiCode apiCode) {
        super(apiCode.getMessage());
        setErrorCode(apiCode.getCode());
    }

    public OverLimitException(ApiCode apiCode, String message) {
        super(message);
        setErrorCode(apiCode.getCode());
    }

    public OverLimitException(int errorCode, String message) {
        super(message);
        setErrorCode(errorCode);
    }

    public OverLimitException(String attributeName, Number limit) {
        super();
        setErrorCode(ApiCode.OVER_LIMIT_EXCEPTION.getCode());
        setMessage(String.format(ApiCode.OVER_LIMIT_EXCEPTION.getMessage(), attributeName,limit));
    }
}
