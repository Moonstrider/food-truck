package com.mountains.micro.common.api;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mountains.micro.common.exception.BusinessException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Data
@Accessors(chain = true)
@Builder
@AllArgsConstructor
public class ApiResult<T> implements Serializable {

    @Serial
    private static final long serialVersionUID = 2004487252556526561L;

    private int code;

    private boolean success;

    private String message;

    private T data;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private Date time;

    public ApiResult() {
        time = new Date();
    }

    public static ApiResult<Boolean> result(boolean flag) {
        if (flag) {
            return ok();
        }
        return fail();
    }

    public static ApiResult<Boolean> result(ApiCode apiCode) {
        return result(apiCode, null);
    }

    public static <T> ApiResult<T> result(ApiCode apiCode, T data) {
        return result(apiCode, null, data);
    }

    @SuppressWarnings("unchecked")
    public static <T> ApiResult<T> result(ApiCode apiCode, String message, T data) {
        boolean success = apiCode.getCode() == ApiCode.SUCCESS.getCode();
        return (ApiResult<T>) ApiResult.builder()
                .code(apiCode.getCode())
                .message(message)
                .data(data)
                .success(success)
                .time(new Date())
                .build();
    }

    public static ApiResult<Boolean> ok() {
        return ok(null);
    }

    public static <T> ApiResult<T> ok(T data) {
        return result(ApiCode.SUCCESS, data);
    }

    public static <T> ApiResult<T> ok(T data, String message) {
        return result(ApiCode.SUCCESS, message, data);
    }

    public static ApiResult<Map<String, Object>> okMap(String key, Object value) {
        Map<String, Object> map = new HashMap<>(1);
        map.put(key, value);
        return ok(map);
    }

    public static ApiResult<Boolean> fail(ApiCode apiCode) {
        return result(apiCode, null);
    }

    public static <T> ApiResult<T> fail(String message) {
        return result(ApiCode.FAIL, message, null);
    }

    public static <T> ApiResult<T> fail(ApiCode apiCode, T data) {
        if (ApiCode.SUCCESS == apiCode) {
            throw new BusinessException("The resonse code of failure can't be " + ApiCode.SUCCESS.getCode());
        }
        return result(apiCode, data);

    }

    public static <T> ApiResult<T> fail(Integer errorCode, String message) {
        return new ApiResult<T>()
                .setSuccess(false)
                .setCode(errorCode)
                .setMessage(message);
    }

    public static ApiResult<Map<String, Object>> fail(String key, Object value) {
        Map<String, Object> map = new HashMap<>(1);
        map.put(key, value);
        return result(ApiCode.FAIL, map);
    }

    public static ApiResult<Boolean> fail() {
        return fail(ApiCode.FAIL);
    }
}
