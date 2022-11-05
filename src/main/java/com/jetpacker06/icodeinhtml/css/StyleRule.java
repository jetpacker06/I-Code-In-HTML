package com.jetpacker06.icodeinhtml.css;

import com.jetpacker06.icodeinhtml.css.kv.Declaration;
import com.jetpacker06.icodeinhtml.css.selector.Selector;

import java.util.ArrayList;
import java.util.Arrays;

public class StyleRule {
    private ArrayList<Selector> selectors = new ArrayList<>();
    private ArrayList<Declaration> declarations = new ArrayList<>();
    public StyleRule(Selector... selectors) {
        this.selectors.addAll(Arrays.asList(selectors));
    }
    public StyleRule addSelectors(Selector... selectors) {
        this.selectors.addAll(Arrays.asList(selectors));
        return this;
    }
    public StyleRule addDeclarations(Declaration... declarations) {
        this.declarations.addAll(Arrays.asList(declarations));
        return this;
    }
    public String build() {
        int counter = 1;
        StringBuilder out = new StringBuilder();
        for (Selector selector : this.selectors) {
            out.append(selector.build());
            System.out.println(counter);
            System.out.println(this.selectors.size());
            if (!(counter == this.selectors.size())) {
                out.append(", ");
            }
            counter++;
        }
        out.append(" {");
        for (Declaration declaration : this.declarations) {
            out.append("\n   ");
            out.append(declaration.build());
        }
        out.append("\n}\n");
        return out.toString();
    }
}
