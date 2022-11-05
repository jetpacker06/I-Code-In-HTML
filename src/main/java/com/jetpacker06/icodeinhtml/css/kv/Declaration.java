package com.jetpacker06.icodeinhtml.css.kv;

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
    public String build() {
        StringBuilder bobTheBuilder = new StringBuilder();
        bobTheBuilder.append(key);
        bobTheBuilder.append(": ");
        bobTheBuilder.append(this.value.toString());
        if (this.unitType == UnitType.NONE) {
            bobTheBuilder.append(";");
            return bobTheBuilder.toString();
        }
        bobTheBuilder.append(" ");
        bobTheBuilder.append(unitType.toString());
        bobTheBuilder.append(";");
        return bobTheBuilder.toString();
    }
}
