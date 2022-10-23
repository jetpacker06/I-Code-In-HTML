package com.jetpacker06.icodeinhtml.css;

import java.util.ArrayList;
import java.util.Arrays;

public class CSSBuilder {
    private ArrayList<StyleRule> rules = new ArrayList<>();
    public CSSBuilder(StyleRule...  rules) {
        this.addRules(rules);
    }
    public CSSBuilder addRules(StyleRule... rules) {
        this.rules.addAll(Arrays.asList(rules));
        return this;
    }
    public String toString() {
        StringBuilder out = new StringBuilder();
        for (StyleRule rule : this.rules) {
            out.append(rule.toString());
        }
        return out.toString();
    }
}
