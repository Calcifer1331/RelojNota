package com.mytools.swings;

import com.mytools.swings.JComponents.BotonColor;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JPanel;

public class PanelDegradadoLabelTitle extends JPanel {

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

    private static final int MAX_ICON_SIZE = 30; // Tamaño máximo del icono en píxeles

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
    private boolean exitado;
    private boolean press = false;

    public PanelDegradadoLabelTitle() {
        initComponents();
        cargarConfigurarcion();
        BotonColor bc = new BotonColor();
        cargarConfigurarcion(bc);
    }

    private void cargarConfigurarcion(BotonColor bc) {
        setBackground(bc.getBackground());
        setForeground(bc.getForeground());
    }

    private void cargarConfigurarcion() {
        setOpaque(false);
        setFont(new Font("Segoe UI Semibold", 0, 18));
        setForeground(Color.WHITE);
        setBackground(Color.decode("#26D0CE"));
        //setSelecionado(true); // Iniciar como seleccionado
        setBorderRedondeado(10);
        setGrosorBorde(1);
        setOpacidad(25);
        setGrosorBarra(5);
        setRedondeadoBarra(5);
        setSelecionado(false);
        setExitado(false);

    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int width = getWidth();
        int height = getHeight();

        int centroWidth = width / 2;
        int centroHeigt = height / 2;

        // Dibujar fondo degradado y borde redondeado
        //Dibujar barra de selector
        dibujarFondoYBorde(g2, width, height);
        //g2.fillRoundRect(isSelecionado() ? width / 10 : centroWidth - 10, height - (height / 6), isSelecionado() ? width - (2 * (width / 10)) : 20, getGrosorBarra(), getRedondeadoBarra(), getRedondeadoBarra());

        super.paintComponent(grphcs);
    }

    public void dibujarFondoYBorde(Graphics2D g2, int width, int height) {
        // Dibujar fondo degradado
        g2.setColor(isSelecionado() || isExitado() ? isPress() ? new Color(204, 204, 204, getOpacidad() - 5) : new Color(204, 204, 204, getOpacidad()) : new Color(0, 0, 60, 0));
        g2.fillRoundRect(0, 0, width, height, getBorderRedondeado(), getBorderRedondeado());
        g2.setColor(isSelecionado() ? getBackground() : new Color(204, 204, 204, 140));

        // Dibujar el borde redondeado
        if (isSelecionado() || isExitado() && getGrosorBorde() > 0) {
            g2.fillRoundRect(1, 10, 5, height - 20, getRedondeadoBarra(), getRedondeadoBarra());
            g2.setColor(new Color(250, 250, 250, (getOpacidad()) / 3));
            g2.setStroke(new java.awt.BasicStroke(getGrosorBorde()));

            g2.draw(new RoundRectangle2D.Double(getGrosorBorde() / 2.0, getGrosorBorde() / 2.0, width - getGrosorBorde(), height - getGrosorBorde(), getBorderRedondeado(), getBorderRedondeado()));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label = new com.mytools.swings.JComponents.Label.LabelText();

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(label, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.mytools.swings.JComponents.Label.LabelText label;
    // End of variables declaration//GEN-END:variables

    public com.mytools.swings.JComponents.Label.LabelText getLabel() {
        return label;
    }

    public void setLabel(com.mytools.swings.JComponents.Label.LabelText label) {
        this.label = label;
    }
}
