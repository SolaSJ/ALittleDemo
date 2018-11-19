package com.sola.alittledemo.constant;

/**
 * @author Sola
 * @date 2018/11/12
 */
public enum TimeDimensionEnum {

    /**
     * 时间维度-天
     */
    DAY("day"),

    /**
     * 时间维度-月
     */
    MONTH("month"),

    /**
     * 时间维度-合计
     */
    TOTAL("total");

    private String str;

    TimeDimensionEnum(String str) {
        this.str = str;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public static boolean contains(String str) {
        if (str == null) {
            return false;
        }
        TimeDimensionEnum timeDimensionEnum = valueOf(str);
        return false;
    }

}
