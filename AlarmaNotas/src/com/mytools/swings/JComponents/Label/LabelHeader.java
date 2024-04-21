package com.mytools.swings.JComponents.Label;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

public class LabelHeader extends JLabel {

    public int getIconSize() {
        return IconSize;
    }

    public void setIconSize(int IconSize) {
        this.IconSize = IconSize;
    }

    private int IconSize;


    public LabelHeader() {
        cargarConfiguraio();
    }

    public void cargarConfiguraio() {
        setBackground(new Color(0, 0, 0, 250));
        setFont(new Font("Segoe UI", Font.BOLD, 24));
        setForeground(Color.WHITE);
        setHorizontalAlignment(CENTER);
        setIconSize(25);
    }

}
