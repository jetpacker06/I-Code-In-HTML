package com.jetpacker06.icodeinhtml.css.selector;

public class Selector {
    private final String element;
    private final Pseudoclass pseudoclass;
    private final Pseudoelement pseudoelement;
    public Selector(String element) {
        this(element, Pseudoelement.NONE, Pseudoclass.NONE);
    }
    public Selector(String element, Pseudoclass pseudoclass) {
        this(element, Pseudoelement.NONE, pseudoclass);
    }
    public Selector(String element, Pseudoelement pseudoelement) {
        this(element, pseudoelement, Pseudoclass.NONE);
    }
    private Selector(String element, Pseudoelement pseudoelement, Pseudoclass pseudoclass) {
        this.element = element;
        this.pseudoelement = pseudoelement;
        this.pseudoclass = pseudoclass;
    }

    public String build() {
        StringBuilder out = new StringBuilder();
        out.append(this.element);
        if (this.pseudoclass != Pseudoclass.NONE) {
            out.append(":");
            out.append(this.pseudoclass.toString().replace("_", "-"));
        }
        else if (this.pseudoelement != Pseudoelement.NONE) {
            out.append("::");
            out.append(this.pseudoelement.toString().replace("_", "-"));
        }
        return out.toString();
    }
}
