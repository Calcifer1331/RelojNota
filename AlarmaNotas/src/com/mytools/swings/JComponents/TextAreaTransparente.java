/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mytools.swings.JComponents;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class TextAreaTransparente extends JTextArea {

    public TextAreaTransparente() {
        cargarConfiguracion();
    }
    private void cargarConfiguracion(){
        setText("est");
        setLineWrap(true);
        setWrapStyleWord(true);
        setOpaque(false);
        setBackground(new Color(0, 0, 0, 0));
        setFont(new Font("Segoe UI Semibold", 0, 14));
        setForeground(new Color(250, 250, 250));
        setBorder(new EmptyBorder(10, 10, 10, 10));
    }
}
