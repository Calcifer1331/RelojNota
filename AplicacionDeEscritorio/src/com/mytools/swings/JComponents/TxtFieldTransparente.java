package com.mytools.swings.JComponents;

import com.mytools.db.ConfiguracionArchivo;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;

public class TxtFieldTransparente extends JTextField {

    public String getPlaceholderText() {
        return placeholderText;
    }

    public void setPlaceholderText(String placeholderText) {
        putClientProperty("JTextField.placeholderText", placeholderText);
    }
    private String placeholderText;

    public TxtFieldTransparente() {
        cargarConfiguracion();
        ConfiguracionArchivo.getForeground("labelText", this);
    }

    private void cargarConfiguracion() {
        setText("");
        setBorder(null);
        setOpaque(false);
        setBackground(new Color(0, 0, 0, 0));
        setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
        setForeground(Color.WHITE);
    }
}
