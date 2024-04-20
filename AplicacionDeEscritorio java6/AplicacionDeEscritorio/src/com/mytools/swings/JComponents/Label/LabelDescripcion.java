package com.mytools.swings.JComponents.Label;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.mytools.utils.ConfiguracionArchivo;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

public class LabelDescripcion extends JLabel {

    public int getIconSize() {
        return IconSize;
    }

    public void setIconSize(int IconSize) {
        this.IconSize = IconSize;
    }

    private int IconSize;

    private FlatSVGIcon svgIcon;

    public LabelDescripcion() {
        cargarConfiguraio();
        ConfiguracionArchivo configuracion = new ConfiguracionArchivo();
        configuracion.getForeground("LabelDescripcion", this);

    }

    public void cargarConfiguraio() {
        setBackground(new Color(0, 0, 0, 250));
        setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
        setForeground(Color.WHITE);
        setHorizontalAlignment(CENTER);
        setIconSize(25);
    }

    public void setSvgImage(String image) {
        svgIcon = new FlatSVGIcon(image, getIconSize(), getIconSize());
        setIcon(svgIcon);
    }
}
