
package com.mytools.swings.JComponents;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.UIManager;

public class Spinner extends JSpinner{

    public Spinner() {
        cargarConfiguracion();
    }
    
    private void cargarConfiguracion(){
        setFont(new Font("Segoe UI Semibold", 0, 14));
        setForeground(new Color(250, 250, 250));
        setBackground(new Color(0, 0, 0,0));
        UIManager.put("Spinner.background", new Color(0, 0, 0, 0));
    }
    
    
}
