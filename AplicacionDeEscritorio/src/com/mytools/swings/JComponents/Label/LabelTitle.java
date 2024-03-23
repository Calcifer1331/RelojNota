package com.mytools.swings.JComponents.Label;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.mytools.db.ConfiguracionArchivo;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

public class LabelTitle extends JLabel {

    private final int MAX_ICON_SIZE = 25;

    private FlatSVGIcon svgIcon;

    public LabelTitle() {
        cargarConfiguraio();
        ConfiguracionArchivo configuracion = new ConfiguracionArchivo();
        configuracion.getForeground("LabelTitle", this);
    }

    public void cargarConfiguraio() {
        setBackground(new Color(0, 0, 0, 250));
        setFont(new Font("Segoe UI Semibold", Font.BOLD, 16));
        setForeground(Color.WHITE);
        setHorizontalAlignment(CENTER);
    }

    public void setSvgImage(String image) {
        svgIcon = new FlatSVGIcon(image, MAX_ICON_SIZE, MAX_ICON_SIZE);
        setIcon(svgIcon);
    }
}
