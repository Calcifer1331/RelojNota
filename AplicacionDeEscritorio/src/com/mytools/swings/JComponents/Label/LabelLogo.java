package com.mytools.swings.JComponents.Label;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.mytools.utils.ConfiguracionArchivo;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.Icon;
import javax.swing.JLabel;

public class LabelLogo extends JLabel {

    private FlatSVGIcon svgIcon;
    private String image;

    public LabelLogo() {
        cargarConfiguraio();
        ConfiguracionArchivo configuracion = new ConfiguracionArchivo();
        configuracion.getForeground("LabelLogo", this);

        // Agregar un ComponentListener para detectar cambios en el tamaño del JLabel
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                // Actualizar el tamaño del icono SVG para que coincida con el nuevo tamaño del JLabel
                if (image != null) {
                    svgIcon = new FlatSVGIcon(image, Math.min(getWidth(), getHeight()), Math.min(getWidth(), getHeight()));
                    setIcon(svgIcon);
                }
            }
        });
    }

    public void cargarConfiguraio() {
        setBackground(new Color(0, 0, 0, 250));
        setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
        setForeground(Color.WHITE);
        setHorizontalAlignment(CENTER);
    }

    public void setSvgImage(String image) {
        this.image = image;
        svgIcon = new FlatSVGIcon(image, Math.min(getWidth(), getHeight()), Math.min(getWidth(), getHeight()));
        setIcon(svgIcon);
    }
}
