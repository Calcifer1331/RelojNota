package com.mytools.swings.JComponents.Label;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class LabelLogo extends JLabel {

    private String image;
    int scaledWidth=0;
    int scaledHeight=0;

    public LabelLogo() {
        cargarConfiguracion();

        // Agregar un ComponentListener para detectar cambios en el tamaño del JLabel
//        addComponentListener(new ComponentAdapter() {
//            @Override
//            public void componentResized(ComponentEvent e) {
//                // Actualizar el tamaño del icono SVG para que coincida con el nuevo tamaño del JLabel
//                if (image != null) {
//                    setImage(image);
//                }
//            }
//        });
    }

    public void cargarConfiguracion() {
        setBackground(new Color(0, 0, 0, 250));
        setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
        setForeground(Color.WHITE);
        setHorizontalAlignment(CENTER);
    }

//    public void setSvgImage(String image) {
//        this.image = image;
//        Dimension a = calcular(image, getWidth(), getHeight());
//        maxHeight = (int) a.getHeight();
//        maxWidth = (int) a.getWidth();
//
//        ImageIcon icon = new ImageIcon(image);
//        setIcon(icon);
//    }
//
//    private Dimension calcular(String image, int maxWidth, int maxHeight) {
//        File file = new File("src/" + image);
//        if (file.exists()) {
//            ImageIcon icon = new ImageIcon(image);
//            return new Dimension(icon.getIconWidth(), icon.getIconHeight());
//        }
//        return null;
//    }
//    public void setImage(String image) {
//    this.image = image;
//    URL imageUrl = getClass().getResource(image);
//    if (imageUrl != null) {
//        ImageIcon icon = new ImageIcon(imageUrl);
//        
//        // Escalar la imagen al tamaño máximo original del JLabel
//        Image scaledImage = icon.getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
//        ImageIcon scaledIcon = new ImageIcon(scaledImage);
//
//        // Establecer el icono escalado en el JLabel
//        setIcon(scaledIcon);
//       
//        
//    } else {
//        System.err.println("Error: La URL de la imagen es nula para " + image);
//    }
//}
    public void setImage(String image) {
        this.image = image;
        URL imageUrl = getClass().getResource(image);
        if (imageUrl != null) {
            ImageIcon icon = new ImageIcon(imageUrl);

            // Obtener el tamaño del JLabel
            int labelWidth = getWidth();
            int labelHeight = getHeight();

            // Obtener el tamaño original de la imagen
            int imageWidth = icon.getIconWidth();
            int imageHeight = icon.getIconHeight();

            // Calcular el scale para ajustar la imagen al JLabel
            double scaleX = (double) labelWidth / imageWidth;
            double scaleY = (double) labelHeight / imageHeight;
            double scale = Math.min(scaleX, scaleY);

            // Escalar la imagen con el scale calculado
            if(scaledWidth==0){
            scaledWidth = (int) (scale * imageWidth);
            scaledHeight = (int) (scale * imageHeight);
            }
            Image scaledImage = icon.getImage().getScaledInstance(scaledWidth, scaledHeight, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(scaledImage);

            // Establecer el icono escalado en el JLabel
            setIcon(scaledIcon);
        } else {
            System.err.println("Error: La URL de la imagen es nula para " + image);
        }
    }

    public void setImageMas(String image) {
        this.image = image;
        URL imageUrl = getClass().getResource(image);
        if (imageUrl != null) {
            ImageIcon icon = new ImageIcon(imageUrl);

            Image scaledImage = icon.getImage().getScaledInstance(scaledWidth, scaledHeight, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(scaledImage);

            // Establecer el icono escalado en el JLabel
            setIcon(scaledIcon);
        } else {
            System.err.println("Error: La URL de la imagen es nula para " + image);
        }
    }
}
