package com.mytools.swings.JComponents.Label;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.kitfox.svg.SVGDiagram;
import com.kitfox.svg.SVGException;
import com.kitfox.svg.SVGUniverse;
import com.mytools.utils.ConfiguracionArchivo;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import javax.swing.Icon;
import javax.swing.JLabel;

public class LabelLogo extends JLabel {

    private FlatSVGIcon svgIcon;
    private String image;
    private int originalMaxWidth;
    private int originalMaxHeight;
    private int maxWidth;
    private int maxHeight;

    public LabelLogo() {
        // Obtener el tamaño máximo original del JLabel
        originalMaxWidth = getWidth();
        originalMaxHeight = getHeight();

        cargarConfiguracion();
        ConfiguracionArchivo configuracion = new ConfiguracionArchivo();
        configuracion.getForeground("LabelLogo", this);

        // Agregar un ComponentListener para detectar cambios en el tamaño del JLabel
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                // Actualizar el tamaño del icono SVG para que coincida con el nuevo tamaño del JLabel
                // Actualizar el tamaño del icono SVG para que coincida con el nuevo tamaño del JLabel
                if (image != null && svgIcon != null) {
                    svgIcon = new FlatSVGIcon(image, maxWidth, maxHeight);
                    setIcon(svgIcon);
                }
            }
        });
    }

    public void cargarConfiguracion() {
        setBackground(new Color(0, 0, 0, 250));
        setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
        setForeground(Color.WHITE);
        setHorizontalAlignment(CENTER);
    }

    public void setSvgImage(String image) {
        this.image = image;
        if (svgIcon == null) {
            Dimension a = calcular(image, getWidth(), getHeight());
            maxHeight = (int) a.getHeight();
            maxWidth = (int) a.getWidth();
        }
        svgIcon = new FlatSVGIcon(image, maxWidth, maxHeight);
        setIcon(svgIcon);
    }

    private Dimension calcular(String image, int maxWidth, int maxHeight) {
        try {
            SVGUniverse universe = new SVGUniverse();
            File file = new File("src/" + image);
            if (file.exists()) {
                URI url = universe.loadSVG(file.toURI().toURL());
                SVGDiagram diagram = universe.getDiagram(url);

                // Obtener las dimensiones del diagrama SVG
                float svgWidth = diagram.getWidth();
                float svgHeight = diagram.getHeight();

                // Calcular el scale para ajustarse al JLabel sin deformar la imagen
                float scaleWidth = maxWidth / svgWidth;
                float scaleHeight = maxHeight / svgHeight;
                float scale = Math.min(scaleWidth, scaleHeight);

                // Calcular las nuevas dimensiones
                int newWidth = (int) (svgWidth * scale);
                int newHeight = (int) (svgHeight * scale);

                return new Dimension(newWidth, newHeight);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
