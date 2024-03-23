package com.mytools.db;

import com.mytools.swings.JComponents.Constantes;
import com.mytools.swings.JComponents.Label.LabelText;
import com.mytools.swings.JComponents.PanelDegradado;
import com.mytools.swings.JComponents.PanelDegradadoBack;
import java.awt.Color;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

import java.util.Properties;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ConfiguracionArchivo implements Constantes {

    private static final String CONFIG_FILE = "cinfig.properties";

    public static void setPanelDegradadoBack(PanelDegradadoBack componente) {
        Properties properties = new Properties();
        properties.setProperty("PanelDegradadoBack_posicionCentral", componente.getPosicionCentral().toString());
        properties.setProperty("PanelDegradadoBack_colorInicial", Integer.toString(componente.getColorInicial().getRGB()));
        properties.setProperty("PanelDegradadoBack_colorMedia1", Integer.toString(componente.getColorMedia1().getRGB()));
        properties.setProperty("PanelDegradadoBack_colorMedia2", Integer.toString(componente.getColorMedia2().getRGB()));
        properties.setProperty("PanelDegradadoBack_colorFinal", Integer.toString(componente.getColorFinal().getRGB()));
        properties.setProperty("PanelDegradadoBack_radioIncremento", Integer.toString(componente.getRadioIncremento()));
        properties.setProperty("PanelDegradadoBack_tipoFondo", componente.getTipoFondo().toString());
        properties.setProperty("PanelDegradadoBack_numeroColores", componente.getNumeroColores().toString());
        properties.setProperty("PanelDegradadoBack_fraccionInicial", Float.toString(componente.getFraccionInicial()));
        properties.setProperty("PanelDegradadoBack_fraccionMedia1", Float.toString(componente.getFraccionMedia1()));
        properties.setProperty("PanelDegradadoBack_fraccionMedia2", Float.toString(componente.getFraccionMedia2()));
        properties.setProperty("PanelDegradadoBack_fraccionFinal", Float.toString(componente.getFraccionFinal()));

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("PanelDegradadoBack.properties"))) {
            properties.store(writer, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void getPanelDegradadoBack(PanelDegradadoBack componente) {
        Properties properties = new Properties();

        try (InputStream input = new FileInputStream("PanelDegradadoBack.properties")) {
            properties.load(input);

            componente.setPosicionCentral(PosicionCentral.valueOf(properties.getProperty("PanelDegradadoBack_posicionCentral")));
            componente.setColorInicial(new Color(Integer.parseInt(properties.getProperty("PanelDegradadoBack_colorInicial"))));
            componente.setColorMedia1(new Color(Integer.parseInt(properties.getProperty("PanelDegradadoBack_colorMedia1"))));
            componente.setColorMedia2(new Color(Integer.parseInt(properties.getProperty("PanelDegradadoBack_colorMedia2"))));
            componente.setColorFinal(new Color(Integer.parseInt(properties.getProperty("PanelDegradadoBack_colorFinal"))));
            componente.setRadioIncremento(Integer.parseInt(properties.getProperty("PanelDegradadoBack_radioIncremento")));
            componente.setTipoFondo(TipoFondo.valueOf(properties.getProperty("PanelDegradadoBack_tipoFondo")));
            componente.setNumeroColores(NumeroColores.valueOf(properties.getProperty("PanelDegradadoBack_numeroColores")));
            componente.setFraccionInicial(Float.parseFloat(properties.getProperty("PanelDegradadoBack_fraccionInicial")));
            componente.setFraccionMedia1(Float.parseFloat(properties.getProperty("PanelDegradadoBack_fraccionMedia1")));
            componente.setFraccionMedia2(Float.parseFloat(properties.getProperty("PanelDegradadoBack_fraccionMedia2")));
            componente.setFraccionFinal(Float.parseFloat(properties.getProperty("PanelDegradadoBack_fraccionFinal")));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void setPanelDegradado(PanelDegradado componente) {
        Properties properties = new Properties();
        properties.setProperty("PanelDegradado_grosorBorde", Integer.toString(componente.getGrosorBorde()));
        properties.setProperty("PanelDegradado_opacidadBorde", Integer.toString(componente.getOpacidadBorder()));
        properties.setProperty("PanelDegradado_opacidadInicia", Integer.toString(componente.getOpacidadInical()));
        properties.setProperty("PanelDegradado_opacidadFinal", Integer.toString(componente.getOpacidadFinal()));
        properties.setProperty("PanelDegradado_bordeRedondeado", Integer.toString(componente.getBorderRedondeado()));

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("PanelDegradado.properties"))) {
            properties.store(writer, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void getPanelDegradado(PanelDegradado componente) {
        Properties properties = new Properties();

        try (InputStream input = new FileInputStream("PanelDegradado.properties")) {
            properties.load(input);

            componente.setGrosorBorde(Integer.parseInt(properties.getProperty("PanelDegradado_grosorBorde")));
            componente.setOpacidadBorder(Integer.parseInt(properties.getProperty("PanelDegradado_opacidadBorde")));
            componente.setOpacidadInical(Integer.parseInt(properties.getProperty("PanelDegradado_opacidadInicia")));
            componente.setOpacidadFinal(Integer.parseInt(properties.getProperty("PanelDegradado_opacidadFinal")));
            componente.setBorderRedondeado(Integer.parseInt(properties.getProperty("PanelDegradado_bordeRedondeado")));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
    public static void setForeground(JComponent componente) {
        Properties properties = new Properties();
        properties.setProperty("PanelDegradadoBack_colorMedia1", Integer.toString(componente.getForeground().getRGB()));

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("LabelFore.properties"))) {
            properties.store(writer, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void getForeground(PanelDegradado componente) {
        Properties properties = new Properties();

        try (InputStream input = new FileInputStream("LabelFore.properties")) {
            properties.load(input);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
    public static void setForeground(String className, JComponent componente) {
        Properties properties = new Properties();
        properties.setProperty("foreground", Integer.toString(componente.getForeground().getRGB()));

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(className + ".properties"))) {
            properties.store(writer, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void getForeground(String className, JComponent componente) {
        Properties properties = new Properties();

        try (InputStream input = new FileInputStream(className + ".properties")) {
            properties.load(input);

            int rgb = Integer.parseInt(properties.getProperty("foreground"));
            componente.setForeground(new Color(rgb));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void setBoton(String className, JButton componente) {
        Properties properties = new Properties();
        properties.setProperty("foreground", Integer.toString(componente.getForeground().getRGB()));
        properties.setProperty("background", Integer.toString(componente.getBackground().getRGB()));

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(className + ".properties"))) {
            properties.store(writer, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void getBoton(String className, JButton componente) {
        Properties properties = new Properties();

        try (InputStream input = new FileInputStream(className + ".properties")) {
            properties.load(input);

            int rgb = Integer.parseInt(properties.getProperty("foreground"));
            componente.setForeground(new Color(rgb));
            rgb = Integer.parseInt(properties.getProperty("background"));
            componente.setBackground(new Color(rgb));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
