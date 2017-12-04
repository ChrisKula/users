package com.christiankula.users.utils;


public class StringUtils {
    private StringUtils() {

    }

    public static String capitalize(String str) {
        if (str.isEmpty()) {
            return str;
        }

        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}
