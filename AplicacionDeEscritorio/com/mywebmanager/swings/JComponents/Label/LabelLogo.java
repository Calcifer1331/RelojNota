
package com.mywebmanager.swings.JComponents.Label;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.mywebmanager.db.ConfiguracionArchivo;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

public class LabelLogo extends JLabel{
    
    private FlatSVGIcon svgIcon;

    public LabelLogo() {
        cargarConfiguraio();
        ConfiguracionArchivo configuracion = new ConfiguracionArchivo();
        configuracion.getForeground("LabelLogo", this);
    }
    
    
    public void cargarConfiguraio(){
        setBackground(new Color(0,0,0,250));
        setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
        setForeground(Color.WHITE);
        setHorizontalAlignment(CENTER);
    }
    public void setSvgImage(String image) {
        svgIcon = new FlatSVGIcon(image, Math.min(getWidth(), getHeight()), Math.min(getWidth(), getHeight()));
        setIcon(svgIcon);
    }
}