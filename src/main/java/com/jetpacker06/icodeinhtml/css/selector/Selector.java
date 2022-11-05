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
        StringBuilder bobTheBuilder = new StringBuilder();
        bobTheBuilder.append(this.element);
        if (this.pseudoclass != Pseudoclass.NONE) {
            bobTheBuilder.append(":");
            bobTheBuilder.append(this.pseudoclass.toString().replace("_", "-"));
        }
        else if (this.pseudoelement != Pseudoelement.NONE) {
            bobTheBuilder.append("::");
            bobTheBuilder.append(this.pseudoelement.toString().replace("_", "-"));
        }
        return bobTheBuilder.toString();
    }
}
