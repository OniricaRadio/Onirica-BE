package com.onirica.onirica.util;

public class SanitizerUtil {

    public static String sanitize(String input) {
        if (input == null) return null;
        return input
                .replaceAll("<", "&lt;")
                .replaceAll(">", "&gt;")
                .replaceAll("\"", "&quot;")
                .replaceAll("'", "&#x27;")
                .replaceAll("&", "&amp;");
    }
}
