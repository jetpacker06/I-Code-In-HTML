package com.jetpacker06.icodeinhtml.html;

import java.io.FileWriter;
import java.io.IOException;

public class HTMLWriter extends HTMLBuilder {
    private String filepath;
    public HTMLWriter(String filepath) {
        super();
        this.filepath = filepath;
    }
    public void write() {
        try {
            FileWriter w = new FileWriter(this.filepath);
            w.write(this.build());
            w.close();
        } catch (IOException ignored) {
        }
    }
}
