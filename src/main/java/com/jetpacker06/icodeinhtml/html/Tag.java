package com.jetpacker06.icodeinhtml.html;

public final class Tag {
    public final String type;
    public final String attributes;

    public Tag(String type, String attributes) {
        this.type = type;
        this.attributes = attributes;
    }
    public Tag(String type) {
        this(type, "");
    }

    public String toString(int spacesPerIndent) {
        int whitespace = spacesPerIndent * 3;
        String out = "\n" + whitespace;
        out += "<" + this.type + " ";
        out += this.attributes;
        out += ">";
        return out;
    }
}