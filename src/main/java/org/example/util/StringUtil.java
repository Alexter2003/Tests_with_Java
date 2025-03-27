package org.example.util;

public class StringUtil {
    public static String repeat(String str, int times) {
        if (times < 0) {
            throw new IllegalArgumentException("times should be greater than 0");
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < times; i++) {
            result.append(str).append(" ");
        }
        return result.toString();
    }

}
