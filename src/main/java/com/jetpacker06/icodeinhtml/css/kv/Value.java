package com.jetpacker06.icodeinhtml.css.kv;

public class Value {
    public Value(String value) {
        this.value = value;
    }

    public Value(Number value) {
        this.value = value;
    }

    private final Object value;

    public String toString() {
        return this.value.toString();
    }

    public boolean isString() {
        return this.value instanceof String;
    }

    public boolean isInt() {
        return this.value instanceof Integer;
    }

    public boolean isLong() {
        return this.value instanceof Long;
    }

    public boolean isFloat() {
        return this.value instanceof Float;
    }

    public boolean isDouble() {
        return this.value instanceof Double;
    }
    public String getAsString() {
        return this.toString();
    }
    public int getAsInt() {
        if (this.value instanceof Integer) {
            return (int) this.value;
        }
        throw new IllegalStateException("The key-value pair's value does not contain an int.");
    }

    public double getAsDouble() {
        if (this.value instanceof Number) {
            return (double) this.value;
        }
        throw new IllegalStateException("The key-value pair's value does not contain a number.");
    }

    public double getAsFloat() {
        if (this.value instanceof Number) {
            return (float) this.value;
        }
        throw new IllegalStateException("The key-value pair's value does not contain a number.");
    }

    public double getAsLong() {
        if (this.value instanceof Number) {
            return (long) this.value;
        }
        throw new IllegalStateException("The key-value pair's value does not contain a number.");
    }
}
