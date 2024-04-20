
package com.mywebmanager.swings.JComponents;

import com.mywebmanager.db.ConfiguracionArchivo;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JComboBox;

public class ComboBox <T> extends JComboBox<T>{

    public ComboBox() {
        cargarConfiguracion();
        ConfiguracionArchivo.getForeground("labelText", this);
    }
    private void cargarConfiguracion(){
        setFont(new Font("Segoe UI Semibold", 0, 14));
        setForeground(new Color(250, 250, 250));
        setBackground(new Color(0, 0, 0,0));
    }
}
