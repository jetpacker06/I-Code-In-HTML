package com.jetpacker06.icodeinhtml.css.kv;

import java.util.Arrays;

public enum UnitType {
    NONE, em, px, percent;

    public UnitType fromString(String value) {
        if (!Arrays.asList(new String[]{"em", "px", "percent", "p", "%"}).contains(value.toLowerCase())) {
            throw new IllegalArgumentException();
        }
        return switch (value.toLowerCase()) {
            case "em" -> em;
            case "none" -> NONE;
            case "percent", "p", "%" -> percent;
            default -> px;
        };
    }
}
