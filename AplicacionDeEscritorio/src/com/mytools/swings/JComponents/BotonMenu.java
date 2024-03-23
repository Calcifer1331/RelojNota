/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mytools.swings.JComponents;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.mytools.db.ConfiguracionArchivo;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JButton;

public class BotonMenu extends JButton {

    public boolean isPress() {
        return press;
    }

    public void setPress(boolean press) {
        this.press = press;
    }

    public boolean isExitado() {
        return exitado;
    }

    public void setExitado(boolean exitado) {
        this.exitado = exitado;
    }

    public int getRedondeadoBarra() {
        return redondeadoBarra;
    }

    public void setRedondeadoBarra(int redondeadoBarra) {
        this.redondeadoBarra = redondeadoBarra;
    }

    public int getGrosorBarra() {
        return grosorBarra;
    }

    public void setGrosorBarra(int grosorBarra) {
        this.grosorBarra = grosorBarra;
    }

    public boolean isSelecionado() {
        return selecionado;

    }

    public void setSelecionado(boolean selecionado) {
        this.selecionado = selecionado;
        repaint();
    }

    private static final int MAX_ICON_SIZE = 25; // Tamaño máximo del icono en píxeles

    public int getOpacidad() {
        return opacidad;
    }

    public void setOpacidad(int opacidad) {
        this.opacidad = opacidad;
    }

    public int getBorderRedondeado() {
        return borderRedondeado;
    }

    public void setBorderRedondeado(int borderRedondeado) {
        this.borderRedondeado = borderRedondeado;
    }

    public int getGrosorBorde() {
        return grosorBorde;
    }

    public void setGrosorBorde(int grosorBorde) {
        this.grosorBorde = grosorBorde;
    }
    private int opacidad;
    private int borderRedondeado;
    private int grosorBorde;
    private boolean selecionado;
    private int grosorBarra;
    private int redondeadoBarra;
    private FlatSVGIcon svgIcon;
    private boolean exitado;
    private boolean press = false;

    public BotonMenu() {
        cargarConfigurarcion();
        ConfiguracionArchivo.getBoton("botonMenu", this);
        
    }
    private void cargarConfigurarcion(){
        setFont(new Font("Segoe UI Semibold", 0, 18));
        setForeground(Color.WHITE);
        setBackground(Color.decode("#26D0CE"));
        setContentAreaFilled(false);
        setBorderPainted(false);
        setIconTextGap(6);
        //setSelecionado(true); // Iniciar como seleccionado
        setBorderRedondeado(10);
        setGrosorBorde(1);
        setOpacidad(25);
        setGrosorBarra(5);
        setRedondeadoBarra(5);
        setSelecionado(false);
        setExitado(false);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                // Cambiar el color de fondo cuando el mouse entra al botón
                if (isSelecionado() == false) {
                    setExitado(true);
                    Graphics2D g2 = (Graphics2D) getGraphics();
                    dibujarFondoYBorde(g2, WIDTH, HEIGHT);
                    setPress(true);
                    repaint();
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Restaurar el color de fondo cuando el mouse sale del botón
                setPress(false);
                setExitado(false);
                repaint();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                setPress(true);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                setPress(false);
            }

        });
    }

    public void setSvgImage(String image) {
        svgIcon = new FlatSVGIcon(image, MAX_ICON_SIZE, MAX_ICON_SIZE);
        setIcon(svgIcon);
    }

    public void cambiarSeleccion() {
        selecionado = !selecionado;  // Invierte el estado actual

        repaint();  // Vuelve a pintar el botón
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int width = getWidth();
        int height = getHeight();

        int centroWidth = width / 2;

        // Dibujar fondo degradado y borde redondeado
        dibujarFondoYBorde(g2, width, height);

        //Dibujar barra de selector
        g2.setColor(isSelecionado() || isPress() ? getBackground() : new Color(204, 204, 204, 140));

        g2.fillRoundRect(isSelecionado() ? width / 10 : centroWidth - 10, height - (height / 6), isSelecionado() ? width - (2 * (width / 10)) : 20, getGrosorBarra(), getRedondeadoBarra(), getRedondeadoBarra());
        super.paintComponent(grphcs);
    }

    public void dibujarFondoYBorde(Graphics2D g2, int width, int height) {
        // Dibujar fondo degradado
        g2.setColor(isSelecionado() || isExitado()? isPress()?new Color(204, 204, 204, getOpacidad()-5):new Color(204, 204, 204, getOpacidad()): new Color(0, 0, 60, 0));
        g2.fillRoundRect(0, 0, width, height, getBorderRedondeado(), getBorderRedondeado());

        // Dibujar el borde redondeado
        if (isSelecionado() || isExitado() && getGrosorBorde() > 0) {
            g2.setColor(new Color(250, 250, 250, (getOpacidad()) / 3));
            g2.setStroke(new java.awt.BasicStroke(getGrosorBorde()));
            g2.draw(new RoundRectangle2D.Double(getGrosorBorde() / 2.0, getGrosorBorde() / 2.0, width - getGrosorBorde(), height - getGrosorBorde(), getBorderRedondeado(), getBorderRedondeado()));
        }
    }

}
