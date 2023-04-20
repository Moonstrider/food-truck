package com.mountains.micro.common.util;

public class DatePattern {

    public static final String YYYYMM = "yyyyMM";

    public static final String YYYYMMDD = "yyyyMMdd";

    public static final String YYYY_MM = "yyyy-MM";
    public static final String YYYY_MM_DD = "yyyy-MM-dd";

    public static final String YYYY_MM_DD_HH = "yyyy-MM-dd HH";

    public static final String YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";

    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    public static final String YYYY_MM_DD_HH_MM_SS_S = "yyyy-MM-dd HH:mm:ss.S";

    public static final String YYYY_MM_DD_T_HH_MM_SS_S_Z = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";

    public static final String HH_MM = "HH:mm";

    public static final String HH_MM_SS = "HH:mm:ss";

    public static final String HH_MM_SS_S = "HH:mm:ss:S";

    public static final String YYYY_MM_DD_T_HH_MM_SS = "yyyy-MM-dd'T'HH:mm:ss";

    public static final String YYYY_MM_DD_T_HH_MM_SS_Z = "yyyy-MM-dd'T'HH:mm:ss'Z'";

    private DatePattern() {
        throw new IllegalStateException("Constant class");
    }
}
