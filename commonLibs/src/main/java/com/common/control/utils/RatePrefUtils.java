package com.common.control.utils;

public class RatePrefUtils {

    public static boolean isRated() {
        return SharePrefUtils.getInstance().getBoolean("rate", false);
    }

    public static void forceRate() {
        SharePrefUtils.getInstance().put("rate", Boolean.class);
    }

    public static int getCountRate() {
        return SharePrefUtils.getInstance().getInt("count_rate", 0);
    }

    public static void increaseCountRate() {
        SharePrefUtils.getInstance().put("count_rate", getCountRate() + 1);
    }

}
