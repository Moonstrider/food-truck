package com.mountains.micro.common.util;

import cn.hutool.core.lang.Validator;
import com.mountains.micro.common.exception.*;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Map;
import java.util.regex.Pattern;

public class ValidationUtil {

    public static final String NULL = "null";

    private ValidationUtil() {
    }

    public static boolean isStringEmpty(String value) {
        return StringUtils.isBlank(value);
    }

    public static boolean isStringNotEmpty(String value) {
        return StringUtils.isNotBlank(value);
    }

    public static boolean isStringNull(String value) {
        return isStringEmpty(value) || NULL.equals(value);
    }

    public static boolean isStringNotNull(String value) {
        return !isStringNull(value);
    }

    public static void checkStringEmpty(String name, String value) {
        if (isStringEmpty(value)) {
            throw new StringEmptyValidationException(name);
        }
    }

    public static boolean isCollectionEmpty(Collection<?> value) {
        return CollectionUtils.isEmpty(value);
    }

    public static boolean isCollectionNotEmpty(Collection<?> value) {
        return CollectionUtils.isNotEmpty(value);
    }

    public static void checkCollectionEmpty(String name, Collection<?> value) {
        if (isCollectionEmpty(value)) {
            throw new NullValidationException(name);
        }
    }

    public static boolean isMapEmpty(Map<?, ?> value) {
        return MapUtils.isEmpty(value);
    }

    public static boolean isMapNotEmpty(Map<?, ?> value) {
        return MapUtils.isNotEmpty(value);
    }

    public static void checkMapNull(String name, Map<?, ?> value) {
        if (isMapEmpty(value)) {
            throw new NullValidationException(name);
        }
    }

    public static boolean isArrayEmpty(Object[] value) {
        return value == null || value.length == 0;
    }

    public static boolean isArrayNotEmpty(Object[] value) {
        return !isArrayEmpty(value);
    }

    public static void checkArrayEmpty(String name, Object[] value) {
        if (isArrayEmpty(value)) {
            throw new NullValidationException(name);
        }
    }

    public static boolean isObjectNull(Object value) {
        return value == null;
    }

    public static boolean isObjectNotNull(Object value) {
        return !isObjectNull(value);
    }

    public static void checkObjectNull(String name, Object value) {
        if (isObjectNull(value)) {
            throw new NullValidationException(name);
        }
    }

    public static void checkStringRegex(String regex, String str) {
        if (!Pattern.matches(regex, str)) {
            throw new ParamValidationException(str + " not match regex: " + regex);
        }
    }

    public static boolean isEqualZero(BigDecimal value) {
        if (isObjectNull(value)) {
            value = BigDecimal.ZERO;
        }

        return value.compareTo(BigDecimal.ZERO) == 0;
    }

    public static boolean isAnyEqualZero(BigDecimal... values) {
        for (BigDecimal value : values) {
            if (isEqualZero(value)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isNegativeNumber(BigDecimal value) {
        if (isObjectNull(value)) {
            value = BigDecimal.ZERO;
        }

        return value.compareTo(BigDecimal.ZERO) < 0;
    }

    public static boolean isEqualZero(Number value) {
        if (isObjectNull(value)) {
            value = 0;
        }

        return value.equals(0);
    }

    public static boolean isNotEqualZero(Number value) {
        return !isEqualZero(value);
    }

    public static void checkEqualZero(Number value) {
        if (isEqualZero(value)) {
            throw new ParamValidationException("number cant't be zero or null");
        }
    }

    public static void checkEqualZero(BigDecimal value) {
        if (isEqualZero(value)) {
            throw new ParamValidationException("number cant't be zero or null");
        }
    }

    public static void checkLimit(String attributeName, Number value, Number limit) {
        if (value.longValue() >= limit.longValue()) {
            throw new OverLimitException(attributeName, limit);
        }
    }

    public static void checkOverLimit(String attributeName, Number value, Number limit) {
        if (value.longValue() > limit.longValue()) {
            throw new BusinessException(attributeName + " can't over " + limit);
        }
    }

    public static boolean checkEmail(String email) {
        boolean isEmail = Validator.isEmail(email);
        if (isEmail) {
            return true;
        }
        throw new ParamValidationException("email is illegal");
    }

    public static boolean isNumeric(String code) {
        return StringUtils.isNumeric(code);
    }


}
