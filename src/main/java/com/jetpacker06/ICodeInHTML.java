package com.jetpacker06;

import com.jetpacker06.icodeinhtml.css.CSSBuilder;
import com.jetpacker06.icodeinhtml.css.kv.Declaration;
import com.jetpacker06.icodeinhtml.css.StyleRule;
import com.jetpacker06.icodeinhtml.css.kv.Value;
import com.jetpacker06.icodeinhtml.css.selector.Pseudoclass;
import com.jetpacker06.icodeinhtml.css.selector.Pseudoelement;
import com.jetpacker06.icodeinhtml.css.selector.Selector;

import java.io.FileWriter;
import java.io.IOException;

public class ICodeInHTML {
    public static void main(String[] args) {
        Value val = new Value("blue");
        Declaration pair = new Declaration("color", val);
        Declaration pair2 = new Declaration("background-color", "orange");
        Declaration pair3 = new Declaration("font-weight", 55);
        Selector selector = new Selector("a", Pseudoclass.hover);
        Selector selector2 = new Selector("a");
        Selector selector3 = new Selector("h1", Pseudoelement.first_letter);
        StyleRule rule = new StyleRule(selector, selector2, selector3);
        rule.addDeclarations(pair, pair2, pair3);
        try {
            FileWriter w = new FileWriter("out2.css");
            CSSBuilder b = new CSSBuilder(rule, rule);
            w.write(b.build());
            w.close();
        } catch (IOException ignored) {
        }
    }
}