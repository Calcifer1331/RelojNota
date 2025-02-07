package com.mytools.swings.JComponents.jlist;

import javax.swing.Icon;

public class Item {

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Item(String text, String icon) {
        this.text = text;
        this.icon = icon;
    }

    public Item() {
    }

    private String text;
    private String icon;
}
