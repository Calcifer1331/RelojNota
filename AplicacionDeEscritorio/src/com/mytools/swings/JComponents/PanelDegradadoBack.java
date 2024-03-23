package com.mytools.swings.JComponents;


import com.mytools.db.ConfiguracionArchivo;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LinearGradientPaint;
import java.awt.MultipleGradientPaint;
import java.awt.Point;
import java.awt.RadialGradientPaint;
import java.awt.RenderingHints;
import java.awt.geom.Point2D;
import javax.swing.JPanel;

public class PanelDegradadoBack extends JPanel implements Constantes {

    public float getFraccionMedia1() {
        return fraccionMedia1;
    }

    public void setFraccionMedia1(float fraccionMedia1) {
        this.fraccionMedia1 = fraccionMedia1;
    }

    public float getFraccionMedia2() {
        return fraccionMedia2;
    }

    public void setFraccionMedia2(float fraccionMedia2) {
        this.fraccionMedia2 = fraccionMedia2;
    }

    public Color getColorMedia1() {
        return colorMedia1;
    }

    public void setColorMedia1(Color colorMedia1) {
        this.colorMedia1 = colorMedia1;
    }

    public Color getColorMedia2() {
        return colorMedia2;
    }

    public void setColorMedia2(Color colorMedia2) {
        this.colorMedia2 = colorMedia2;
    }

    public int getRadioIncremento() {
        return radioIncremento;
    }

    public void setRadioIncremento(int radioIncremento) {
        this.radioIncremento = radioIncremento;
    }

    public Color getColorInicial() {
        return colorInicial;
    }

    public void setColorInicial(Color colorInicial) {
        this.colorInicial = colorInicial;
    }

    public Color getColorFinal() {
        return colorFinal;
    }

    public void setColorFinal(Color colorFinal) {
        this.colorFinal = colorFinal;
    }

    public float getFraccionInicial() {
        return fraccionInicial;
    }

    public void setFraccionInicial(float fraccionInicial) {
        this.fraccionInicial = fraccionInicial;
    }

    public float getFraccionFinal() {
        return fraccionFinal;
    }

    public void setFraccionFinal(float fraccionFinal) {
        this.fraccionFinal = fraccionFinal;
    }

    public Point.Double getPuntoInicial() {
        return puntoInicial;
    }

    public void setPuntoInicial(Point.Double puntoInicial) {
        this.puntoInicial = puntoInicial;
    }

    public Point.Double getPuntoFinal() {
        return puntoFinal;
    }

    public void setPuntoFinal(Point.Double puntoFinal) {
        this.puntoFinal = puntoFinal;
    }

    public NumeroColores getNumeroColores() {
        return numeroColores;
    }

    public void setNumeroColores(NumeroColores numeroColores) {
        this.numeroColores = numeroColores;
    }

    public TipoFondo getTipoFondo() {
        return tipoFondo;
    }

    public void setTipoFondo(TipoFondo tipoFondo) {
        this.tipoFondo = tipoFondo;
    }

    public Point2D.Double getCentro() {
        return centro;
    }

    public void setCentro(Point2D.Double centro) {
        this.centro = centro;
    }

    public PosicionCentral getPosicionCentral() {
        return posicionCentral;
    }

    public void setPosicionCentral(PosicionCentral posicionCentral) {
        this.posicionCentral = posicionCentral;
    }

    public void setFracciones(float fraccion1, float fraccion2, float fraccion3, float fraccion4) {
        setFraccionInicial(fraccion1);
        setFraccionMedia1(fraccion2);
        setFraccionMedia2(fraccion3);
        setFraccionFinal(fraccion4);
    }

    public void setColores(Color color1, Color color2, Color color3, Color color4) {
        setColorInicial(color1);
        setColorMedia1(color2);
        setColorMedia2(color3);
        setColorFinal(color4);

    }
    private Color colorInicial;
    private Color colorMedia1;
    private Color colorMedia2;
    private Color colorFinal;
    private int radioIncremento;
    private PosicionCentral posicionCentral;
    private TipoFondo tipoFondo;
    private NumeroColores numeroColores;
    private Point2D.Double centro;
    private float fraccionInicial;
    private float fraccionMedia1;
    private float fraccionMedia2;
    private float fraccionFinal;
    private Point.Double puntoInicial;
    private Point.Double puntoFinal;

    public PanelDegradadoBack(){
        cargarConfiguracion();
        ConfiguracionArchivo configuracion = new ConfiguracionArchivo();
        configuracion.getPanelDegradadoBack(this);
    }

    private void cargarConfiguracion() {
        setColores(hexToColor("#26D0CE"), hexToColor("#1A2980"), hexToColor("#0D1540"), hexToColor("#000000"));
        setRadioIncremento(100);
        setPosicionCentral(PosicionCentral.ARRIBA);
        setFracciones(0.0f, 0.3f, 0.6f, 1.0f);
        setTipoFondo(TipoFondo.RADIAL);
        setNumeroColores(NumeroColores.NUMERO_COLOR_4);
    }
    

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        double width = getWidth();
        double height = getHeight();

        float radio = (float) ((Math.min(width, height)) + getRadioIncremento());

        Color[] ListColores = {getColorInicial(), getColorMedia1(), getColorMedia2(), getColorFinal()};
        float[] Listfractions = {getFraccionInicial(), getFraccionMedia1(), getFraccionMedia2(), getFraccionFinal()};

        switch (getPosicionCentral()) {
            case ARRIBA:
                setCentro(new Point2D.Double(width / 2, 0));
                setPuntoInicial(new Point.Double(width / 2, 0));
                setPuntoFinal(new Point.Double(width / 2, height));
                break;
            case ABAJO:
                setCentro(new Point2D.Double(width / 2, height));
                setPuntoInicial(new Point.Double(width / 2, height));
                setPuntoFinal(new Point.Double(width / 2, 0));
                break;
            case CENTRO:
                setTipoFondo(TipoFondo.RADIAL);
                setCentro(new Point2D.Double(width / 2, height / 2));
                setPuntoInicial(new Point.Double(width / 2, 0));
                setPuntoFinal(new Point.Double(width / 2, height));
                break;
            case DERECHA:
                setCentro(new Point2D.Double(0, height / 2));
                setPuntoInicial(new Point.Double(width, height / 2));
                setPuntoFinal(new Point.Double(0, height / 2));
                break;
            case IZQUIERDA:
                setCentro(new Point2D.Double(width, height / 2));
                setPuntoInicial(new Point.Double(0, height / 2));
                setPuntoFinal(new Point.Double(width, height / 2));
                break;
            case IZQUIERDA_ARRIBA:
                setCentro(new Point2D.Double(0, 0));
                setPuntoInicial(new Point.Double(0, 0));
                setPuntoFinal(new Point.Double(width, height));
                break;
            case IZQUIERDA_ABAJO:
                setCentro(new Point2D.Double(0, height));
                setPuntoInicial(new Point.Double(0, height));
                setPuntoFinal(new Point.Double(width, 0));
                break;
            case DERECHA_ABAJO:
                setCentro(new Point2D.Double(width, height));
                setPuntoInicial(new Point.Double(width, height));
                setPuntoFinal(new Point.Double(0, 0));
                break;
            case DERECHA_ARRIBA:
                setCentro(new Point2D.Double(width, 0));
                setPuntoInicial(new Point.Double(width, 0));
                setPuntoFinal(new Point.Double(0, height));
                break;
            default:
                setCentro(new Point2D.Double(width / 2, 0));
                setPuntoInicial(new Point.Double(width / 2, 0));
                setPuntoFinal(new Point2D.Double(width / 2, height));
                break;
        }

        switch (getNumeroColores()) {
            case NUMERO_COLOR_1:
                setTipoFondo(TipoFondo.SOLID);
                break;
            case NUMERO_COLOR_2:
                ListColores = new Color[]{getColorInicial(), getColorMedia1()};
                Listfractions = new float[]{getFraccionInicial(), getFraccionMedia1()};
                break;
            case NUMERO_COLOR_3:
                ListColores = new Color[]{getColorInicial(), getColorMedia1(), getColorMedia2()};
                Listfractions = new float[]{getFraccionInicial(), getFraccionMedia1(), getFraccionMedia2()};
                break;
            case NUMERO_COLOR_4:
                ListColores = new Color[]{getColorInicial(), getColorMedia1(), getColorMedia2(), getColorFinal()};
                Listfractions = new float[]{getFraccionInicial(), getFraccionMedia1(), getFraccionMedia2(), getFraccionFinal()};
                break;
            default:
                ListColores = new Color[]{getColorInicial(), getColorMedia1(), getColorMedia2(), getColorFinal()};
                Listfractions = new float[]{getFraccionInicial(), getFraccionMedia1(), getFraccionMedia2(), getFraccionFinal()};
                break;
        }

        // Crea el objeto MultipleGradientPaint
        RadialGradientPaint GradienRadial = new RadialGradientPaint(getCentro(), (float) (double) radio, Listfractions, ListColores);

        MultipleGradientPaint GradientLineal = new LinearGradientPaint(getPuntoInicial(), getPuntoFinal(), Listfractions, ListColores);

        switch (getTipoFondo()) {
            case SOLID:
                g2.setPaint(ListColores[0]);
                break;
            case LINEAL:
                g2.setPaint(GradientLineal);
                break;
            case RADIAL:
                g2.setPaint(GradienRadial);
                break;
            default:
                g2.setPaint(ListColores[0]);
                break;
        }

        g2.fillRect(-2, -2, (int) width+2, (int) height+2);

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
    }

    public Color hexToColor(String hex) {
        try {
            return Color.decode(hex);
        } catch (NumberFormatException e) {
            // Manejar la excepción según sea necesario
            e.printStackTrace();
            return Color.BLACK; // Valor predeterminado en caso de error
        }
    }
}
