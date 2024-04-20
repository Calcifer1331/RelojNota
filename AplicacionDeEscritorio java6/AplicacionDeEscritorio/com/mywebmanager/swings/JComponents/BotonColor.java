/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mywebmanager.swings.JComponents;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.mywebmanager.db.ConfiguracionArchivo;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import static java.awt.image.ImageObserver.HEIGHT;
import static java.awt.image.ImageObserver.WIDTH;
import javax.swing.JButton;

public class BotonColor extends JButton {

    public boolean isPress() {
        return press;
    }

    public void setPress(boolean press) {
        this.press = press;
    }

    private static final int MAX_ICON_SIZE = 23; // Tamaño máximo del icono en píxeles

    public int getBorderRedondeado() {
        return borderRedondeado;
    }

    public void setBorderRedondeado(int borderRedondeado) {
        this.borderRedondeado = borderRedondeado;
    }
    private int borderRedondeado;
    private boolean press = false;
    private FlatSVGIcon svgIcon;

    public BotonColor() {
        cargarConfigurarcion();
        ConfiguracionArchivo.getBoton("botonColor", this);
    }

    private void cargarConfigurarcion() {
        setPreferredSize(new Dimension(50, 36));
        setFont(new Font("Segoe UI Semibold", 0, 14));
        setForeground(new Color(250, 250, 250));
        setBackground(Color.decode("#0052D4"));
        setContentAreaFilled(false);
        setBorderPainted(false);
        setIconTextGap(10);
        setBorderRedondeado(40);

        
    }

    public void setSvgImage(String image) {
        svgIcon = new FlatSVGIcon(image, MAX_ICON_SIZE, MAX_ICON_SIZE);
        setIcon(svgIcon);
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int width = getWidth();
        int height = getHeight();

        g2.setColor(isPress() ? new Color(getBackground().getRed(), getBackground().getGreen(), getBackground().getBlue()) : getBackground());
        g2.fillRoundRect(0, 0, width, height, getBorderRedondeado(), getBorderRedondeado());

        // Dibujar el borde redondeado
        g2.setColor(getBackground());
        super.paintComponent(grphcs);
    }

}
