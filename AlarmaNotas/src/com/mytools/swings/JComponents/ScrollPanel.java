/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mytools.swings.JComponents;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JScrollPane;

public class ScrollPanel extends JScrollPane {

    public int getOpacidadBorder() {
        return OpacidadBorder;
    }

    public void setOpacidadBorder(int OpacidadBorder) {
        this.OpacidadBorder = OpacidadBorder;
    }

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
    private int OpacidadBorder;

    public ScrollPanel() {
        cargarConfiguracion();
        PanelDegradado PD = new PanelDegradado();
        setOpacidadBorder(PD.getOpacidadBorder());
        setOpacidad((int)(PD.getOpacidadInical()+PD.getOpacidadFinal())/2);
        setBorderRedondeado(PD.getBorderRedondeado());
        setGrosorBorde(PD.getGrosorBorde());
    }
    
    private void cargarConfiguracion(){
        setOpaque(false);
        setBackground(new Color(0, 0, 0, 0));

        getViewport().setOpaque(false);
        setBorder(null);
        setOpacidadBorder(25);
        setOpacidad(60);
        setBorderRedondeado(30);
        setGrosorBorde(1);
    }

    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int width = getWidth();
        int height = getHeight();

        // Dibuja el fondo con opacidad
        g2.setColor(new Color(0, 0, 0, getOpacidad()));
        g2.fillRoundRect(0, 0, width, height, getBorderRedondeado(), getBorderRedondeado());

        // Dibuja el borde blanco
        g2.setColor(new Color(250, 250, 250, getOpacidadBorder()));
        g2.setStroke(new java.awt.BasicStroke(getGrosorBorde()));
        g2.draw(new RoundRectangle2D.Double(getGrosorBorde() / 2.0, getGrosorBorde() / 2.0, width - getGrosorBorde(), height - getGrosorBorde(), getBorderRedondeado(), getBorderRedondeado()));

        super.paintComponent(grphcs);
    }

}
