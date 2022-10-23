package com.jetpacker06.icodeinhtml.css.kv;

import com.jetpacker06.icodeinhtml.css.kv.Value;
import com.jetpacker06.icodeinhtml.css.kv.UnitType;

public class Declaration {
    private final String key;
    private final Value value;
    private final UnitType unitType;
    public Declaration(String key, Value value, UnitType unitType) {
        this.key = key;
        this.value = value;
        this.unitType = unitType;
    }
    public Declaration(String key, Value value) {
        this(key, value, UnitType.NONE);
    }
    public Declaration(String key, String value) {
        this(key, new Value(value), UnitType.NONE);
    }
    public Declaration(String key, String value, UnitType unitType) {
        this(key, new Value(value), unitType);
    }
    public Declaration(String key, Number value) {
        this(key, new Value(value), UnitType.NONE);
    }
    public Declaration(String key, Number value, UnitType unitType) {
        this(key, new Value(value), unitType);
    }
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append(key);
        out.append(": ");
        out.append(this.value.toString());
        if (this.unitType == UnitType.NONE) {
            out.append(";");
            return out.toString();
        }
        out.append(" ");
        out.append(unitType.toString());
        out.append(";");
        return out.toString();
    }
}
