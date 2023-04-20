package com.mountains.micro.common.exception;

import com.mountains.micro.common.api.ApiCode;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

@Data
@EqualsAndHashCode(callSuper = true)
public class ApplicationException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = -7470461654663264392L;

    private Integer errorCode;
    private String message;

    public ApplicationException() {
        super();
        this.errorCode = ApiCode.APPLICATION_EXCEPTION.getCode();
        this.message = ApiCode.APPLICATION_EXCEPTION.getMessage();
    }

    public ApplicationException(String message) {
        super(message);
        this.errorCode = ApiCode.APPLICATION_EXCEPTION.getCode();
        this.message = message;
    }

    public ApplicationException(String message, Throwable cause) {
        super(message, cause);
        this.errorCode = ApiCode.APPLICATION_EXCEPTION.getCode();
        this.message = message;
    }

    public ApplicationException(Throwable cause) {
        super(cause);
        this.errorCode = ApiCode.APPLICATION_EXCEPTION.getCode();
        this.message = ApiCode.APPLICATION_EXCEPTION.getMessage();
    }

}
