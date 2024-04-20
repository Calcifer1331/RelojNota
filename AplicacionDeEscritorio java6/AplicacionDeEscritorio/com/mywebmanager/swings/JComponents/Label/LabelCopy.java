
package com.mywebmanager.swings.JComponents.Label;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.mywebmanager.db.ConfiguracionArchivo;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

public class LabelCopy extends JLabel{
    
    private final int  MAX_ICON_SIZE=20;
    
    private FlatSVGIcon svgIcon;

    public LabelCopy() {
        cargarConfiguraio();
        setSvgImage("resource/Calcifer.svg");
        ConfiguracionArchivo configuracion = new ConfiguracionArchivo();
        configuracion.getForeground("LabelText", this);
    }
    
    public void cargarConfiguraio(){
        setBackground(new Color(0,0,0,250));
        setFont(new Font("Segoe UI", Font.PLAIN, 14));
        setForeground(Color.WHITE);
        
        setText("Calcifer ©.");
    }
    public void setSvgImage(String image) {
        svgIcon = new FlatSVGIcon(image, MAX_ICON_SIZE, MAX_ICON_SIZE);
        setIcon(svgIcon);
    }
}
