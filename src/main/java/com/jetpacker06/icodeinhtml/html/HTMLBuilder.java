package com.jetpacker06.icodeinhtml.html;

import java.util.ArrayList;
import java.util.Objects;

public class HTMLBuilder {
    private String asStr = "<!DOCTYPE html>\n";
    private final int spacesPerIndent;
    private int indentLevel = 0;
    private ArrayList<Tag> latestTags = new ArrayList<>();
    public HTMLBuilder() {
        this(3);
    }
    public HTMLBuilder(int spacesPerIndent) {
        this.spacesPerIndent = spacesPerIndent;
    }

    private HTMLBuilder openTag(Tag tag) {
        this.latestTags.add(tag);
        this.pasteIndent();
        this.asStr += "<";
        this.asStr += tag.type;
        if (!Objects.equals(tag.attributes, "")) {
            this.asStr += " ";
            String[] splitAttributes = tag.attributes.split("=");
            String toAdd = "";
            boolean toggle = false;
            for (String t : splitAttributes) {
                if (toggle) {
                    t = "=\"" + t + "\"";
                }
                toAdd += t;
                toggle = !toggle;
            }
            this.asStr += toAdd;
        }
        this.asStr += ">";
        this.indentLevel++;
        return this;
    }

    /**
     * @param type The type of tag to open, for example 'html' or 'p'
     * @param attributes Attributes to assign to the element, format without the quotation marks, example "class=class lang=en"
     */
    public HTMLBuilder openTag(String type, String attributes) {
        return this.openTag(new Tag(type, attributes));
    }
    public HTMLBuilder openTag(String type) {
        return this.openTag(new Tag(type));
    }
    public HTMLBuilder closeTag() {
        return this.closeTag(this.latestTags.get(this.latestTags.size() - 1));
    }
    public HTMLBuilder closeTag(String type) {
        return this.closeTag(new Tag(type));
    }
    public HTMLBuilder closeTag(Tag tag) {
        this.latestTags.remove(this.latestTags.size() - 1);
        this.indentLevel--;
        this.pasteIndent();
        this.asStr += "</" + tag.type + ">";
        return this;
    }
    public HTMLBuilder addContent(String content) {
        this.pasteIndent();
        this.asStr += content;
        return this;
    }
    private void pasteIndent() {
        this.asStr += "\n";
        for (int i=0;i<this.indentLevel * this.spacesPerIndent;i++) {
            this.asStr += " ";
        }}
    public String build() {
        ArrayList<Tag> backup = this.latestTags;
        while (this.latestTags.size() > 0) {
            Tag latestTag = this.latestTags.get(this.latestTags.size() - 1);
            this.latestTags.remove(latestTag);
            this.indentLevel--;
            this.pasteIndent();
            this.asStr += "</" + latestTag.type + ">";
        }
        this.latestTags = backup;
        return this.asStr;
    }
}
