package com.mytools.views;

import com.mytools.db.ConfiguracionArchivo;
import com.mytools.ilib.Dashboard;
import com.mytools.swings.JComponents.BotonColor;
import com.mytools.swings.JComponents.BotonMenu;
import com.mytools.swings.JComponents.Constantes;
import com.mytools.swings.JComponents.PanelDegradadoBack;
import com.mytools.swings.JComponents.PanelDegradado;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JColorChooser;
import javax.swing.JComponent;

public class Configuracion extends javax.swing.JPanel implements Constantes {

    PanelDegradadoBack PDB = new PanelDegradadoBack();
    PanelDegradado PD = new PanelDegradado();

    public Configuracion() {
        initComponents();
        cargarConfigurarcionBackground();
        cargarConfigurarcionPanelDegradado();
        cargarConfigurarcionFontColor();
        cargarConfiguracionBoton();
    }

    

    private void cargarConfiguracionBoton() {
        BotonMenu BTN = new BotonMenu();
        ConfiguracionArchivo.getBoton("botonMenu", BTN);
        botonColorFuenteBotonMenu.setBackground(BTN.getForeground());
        esColorOscuro(botonColorFuenteBotonMenu);
        botonColorBackBotonMenu.setBackground(BTN.getBackground());
        esColorOscuro(botonColorBackBotonMenu);

        botonColorFuenteBotonColor.setBackground(botonGuadarBotonColor.getForeground());
        esColorOscuro(botonColorFuenteBotonColor);
    }

    private void cargarConfigurarcionFontColor() {
        botonColorEncabezado.setBackground(labelHeaderEjemplo.getForeground());
        esColorOscuro(botonColorEncabezado);

        botonColorTitulos.setBackground(labelTitleEjemplo.getForeground());
        esColorOscuro(botonColorTitulos);

        botonColorDescripciones.setBackground(labelDescripcionEjemplo.getForeground());
        esColorOscuro(botonColorDescripciones);

        botonColorText.setBackground(txtTextEjemplo.getForeground());
        esColorOscuro(botonColorText);
    }

    private void cargarConfigurarcionPanelDegradado() {
        ConfiguracionArchivo configuracion = new ConfiguracionArchivo();
        configuracion.getPanelDegradado(PD);
        spinnerBordeRedondeado.setValue(PD.getBorderRedondeado());
        spinnerGrosorBorde.setValue(PD.getGrosorBorde());
        spinnerOpacidadBorde.setValue(PD.getOpacidadBorder());
        spinnerOpacidadInicial.setValue(PD.getOpacidadInical());
        spinnerOpacidadFinal.setValue(PD.getOpacidadFinal());
    }

    private void guardarConfigurarcionPanelDegradado() {
        PanelDegradado pd = new PanelDegradado();
        pd.setBorderRedondeado((int) spinnerBordeRedondeado.getValue());
        pd.setGrosorBorde((int) spinnerGrosorBorde.getValue());
        pd.setOpacidadBorder((int) spinnerOpacidadBorde.getValue());
        pd.setOpacidadInical((int) spinnerOpacidadInicial.getValue());
        pd.setOpacidadFinal((int) spinnerOpacidadFinal.getValue());

        ConfiguracionArchivo configuracion = new ConfiguracionArchivo();
        configuracion.setPanelDegradado(pd);
    }

    private void cargarConfigurarcionBackground() {

        ConfiguracionArchivo configuracion = new ConfiguracionArchivo();
        configuracion.getPanelDegradadoBack(PDB);
        botonColorInicial.setBackground(PDB.getColorInicial());
        esColorOscuro(botonColorInicial);
        botonColorMedio1.setBackground(PDB.getColorMedia1());
        esColorOscuro(botonColorMedio1);
        botonColorMedio2.setBackground(PDB.getColorMedia2());
        esColorOscuro(botonColorMedio2);
        botonColorFinal.setBackground(PDB.getColorFinal());
        esColorOscuro(botonColorFinal);

        spinnerRadio.setValue(PDB.getRadioIncremento());

        PosicionCentral[] posicion = PosicionCentral.values();
        DefaultComboBoxModel<PosicionCentral> modelposicion = new DefaultComboBoxModel<>(posicion);
        comboBoxPosicion.setModel(modelposicion);
        comboBoxPosicion.setSelectedItem(PDB.getPosicionCentral());

        sliderFranccionInicial.setValue((int) (PDB.getFraccionInicial() * 100));
        sliderFranccionMedio1.setValue((int) (PDB.getFraccionMedia1() * 100));
        sliderFranccionMedio2.setValue((int) (PDB.getFraccionMedia2() * 100));
        sliderFranccionFinal.setValue((int) (PDB.getFraccionFinal() * 100));

        jSliderNumColores.setValue(setNumeroColor(PDB.getNumeroColores()));

        setTipoFondo(PDB.getTipoFondo());
    }

    private void guardarConfigurarcionBackground() {
        PanelDegradadoBack pdb = new PanelDegradadoBack();
        pdb.setColorInicial(botonColorInicial.getBackground());
        pdb.setColorMedia1(botonColorMedio1.getBackground());
        pdb.setColorMedia2(botonColorMedio2.getBackground());
        pdb.setColorFinal(botonColorFinal.getBackground());
        pdb.setRadioIncremento((int) spinnerRadio.getValue());
        pdb.setPosicionCentral((PosicionCentral) comboBoxPosicion.getSelectedItem());
        pdb.setTipoFondo(getTipoFondo());
        pdb.setNumeroColores(getNumeroColor((int) jSliderNumColores.getValue()));
        pdb.setFraccionInicial(sliderFranccionInicial.getFloatValue());
        pdb.setFraccionMedia1(sliderFranccionMedio1.getFloatValue());
        pdb.setFraccionMedia2(sliderFranccionMedio2.getFloatValue());
        pdb.setFraccionFinal(sliderFranccionFinal.getFloatValue());

        ConfiguracionArchivo configuracion = new ConfiguracionArchivo();
        configuracion.setPanelDegradadoBack(pdb);

    }

    private void setTipoFondo(TipoFondo tipo) {
        switch (tipo) {
            case SOLID:
                jRadioButtonSolido.setSelected(true);
                break;
            case LINEAL:
                jRadioButtonDegradadoLineal.setSelected(true);
                break;
            case RADIAL:
                jRadioButtonDegradadoRadial.setSelected(true);
                break;
            default:
                jRadioButtonSolido.setSelected(true);
        }
    }

    private TipoFondo getTipoFondo() {
        TipoFondo tipo;
        tipo = jRadioButtonSolido.isSelected() ? TipoFondo.SOLID : jRadioButtonDegradadoLineal.isSelected() ? TipoFondo.LINEAL : jRadioButtonDegradadoRadial.isSelected() ? TipoFondo.RADIAL : TipoFondo.SOLID;
        return tipo;
    }

    private int setNumeroColor(NumeroColores color) {
        int num;
        switch (color) {
            case NUMERO_COLOR_1:
                num = 1;
                break;
            case NUMERO_COLOR_2:
                num = 2;
                break;
            case NUMERO_COLOR_3:
                num = 3;
                break;
            case NUMERO_COLOR_4:
                num = 4;
                break;
            default:
                num = 1;
        }
        return num;
    }

    private NumeroColores getNumeroColor(int num) {
        NumeroColores color;
        switch (num) {
            case 1:
                color = NumeroColores.NUMERO_COLOR_1;
                break;
            case 2:
                color = NumeroColores.NUMERO_COLOR_2;
                break;
            case 3:
                color = NumeroColores.NUMERO_COLOR_3;
                break;
            case 4:
                color = NumeroColores.NUMERO_COLOR_4;
                break;
            default:
                color = NumeroColores.NUMERO_COLOR_1;
        }
        return color;
    }

    private void esColorOscuro(BotonColor Boton) {
        // Calcular la luminosidad del color
        double luminosidad = (0.299 * Boton.getBackground().getRed() + 0.587 * Boton.getBackground().getGreen() + 0.114 * Boton.getBackground().getBlue()) / 255;
        boolean aplicar = false;
        // Determinar si la luminosidad es inferior a un umbral (0.5, por ejemplo)
        if (luminosidad < 0.7) {
            aplicar = true;
        }
        Boton.setForeground(aplicar ? Color.WHITE : Color.BLACK);
    }

    private void elegirColor(BotonColor btn, Color color, JComponent component) {
        Color selectedColorBack = JColorChooser.showDialog(Dashboard.content, "Elije el Color", color);
        btn.setBackground(selectedColorBack);
        if (component != null) {
            component.setForeground(selectedColorBack);
        }
        esColorOscuro(btn);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupTipoFondo = new javax.swing.ButtonGroup();
        labelTextNumColores1 = new com.mytools.swings.JComponents.Label.LabelText();
        PanelHeaderBackground = new com.mytools.swings.JComponents.PanelDegradado();
        labelHeaderFondo = new com.mytools.swings.JComponents.Label.LabelHeader();
        panelColores = new com.mytools.swings.JComponents.PanelDegradado();
        botonColorInicial = new com.mytools.swings.JComponents.BotonColor();
        botonColorMedio1 = new com.mytools.swings.JComponents.BotonColor();
        botonColorMedio2 = new com.mytools.swings.JComponents.BotonColor();
        botonColorFinal = new com.mytools.swings.JComponents.BotonColor();
        labelTitleColores = new com.mytools.swings.JComponents.Label.LabelTitle();
        panelFracciones = new com.mytools.swings.JComponents.PanelDegradado();
        sliderFranccionInicial = new com.mytools.swings.JComponents.SliderFranccion();
        sliderFranccionMedio1 = new com.mytools.swings.JComponents.SliderFranccion();
        sliderFranccionMedio2 = new com.mytools.swings.JComponents.SliderFranccion();
        sliderFranccionFinal = new com.mytools.swings.JComponents.SliderFranccion();
        labelTitleFrancciones = new com.mytools.swings.JComponents.Label.LabelTitle();
        panelRadio = new com.mytools.swings.JComponents.PanelDegradado();
        spinnerRadio = new com.mytools.swings.JComponents.Spinner();
        labelTitleRadio = new com.mytools.swings.JComponents.Label.LabelTitle();
        labelDescripcionRadio = new com.mytools.swings.JComponents.Label.LabelDescripcion();
        panelPosicion = new com.mytools.swings.JComponents.PanelDegradado();
        comboBoxPosicion = new com.mytools.swings.JComponents.ComboBox();
        labelTitlePosicion = new com.mytools.swings.JComponents.Label.LabelTitle();
        labelDescripcionPosicion = new com.mytools.swings.JComponents.Label.LabelDescripcion();
        panelNumColores = new com.mytools.swings.JComponents.PanelDegradado();
        labelTitleNumColores = new com.mytools.swings.JComponents.Label.LabelTitle();
        labelDescripcionnumColore = new com.mytools.swings.JComponents.Label.LabelDescripcion();
        jSliderNumColores = new com.mytools.swings.JComponents.Slider();
        panelTipoFondo = new com.mytools.swings.JComponents.PanelDegradado();
        labelTitleTipoFondo = new com.mytools.swings.JComponents.Label.LabelTitle();
        jRadioButtonSolido = new com.mytools.swings.JComponents.RadioButton();
        jRadioButtonDegradadoLineal = new com.mytools.swings.JComponents.RadioButton();
        jRadioButtonDegradadoRadial = new com.mytools.swings.JComponents.RadioButton();
        botonGuardarFondo = new com.mytools.swings.JComponents.BotonColor();
        PanelTitlePanelDegradado = new com.mytools.swings.JComponents.PanelDegradado();
        labelHeaderPanelDegra = new com.mytools.swings.JComponents.Label.LabelHeader();
        panelDegradadoGrosorBorde = new com.mytools.swings.JComponents.PanelDegradado();
        spinnerGrosorBorde = new com.mytools.swings.JComponents.Spinner();
        labelTitleGrosorBorde = new com.mytools.swings.JComponents.Label.LabelTitle();
        panelDegradadoOpacidadBorde = new com.mytools.swings.JComponents.PanelDegradado();
        spinnerOpacidadBorde = new com.mytools.swings.JComponents.Spinner();
        labelTitleOpacidadBorde = new com.mytools.swings.JComponents.Label.LabelTitle();
        panelDegradadoBordeRedondeado = new com.mytools.swings.JComponents.PanelDegradado();
        spinnerBordeRedondeado = new com.mytools.swings.JComponents.Spinner();
        labelTitleBordeRedondeado = new com.mytools.swings.JComponents.Label.LabelTitle();
        panelDegradadoOpacidadInicial = new com.mytools.swings.JComponents.PanelDegradado();
        spinnerOpacidadInicial = new com.mytools.swings.JComponents.Spinner();
        labelTitle1 = new com.mytools.swings.JComponents.Label.LabelTitle();
        panelDegradadoOpacidadFinal = new com.mytools.swings.JComponents.PanelDegradado();
        spinnerOpacidadFinal = new com.mytools.swings.JComponents.Spinner();
        labelTitle2 = new com.mytools.swings.JComponents.Label.LabelTitle();
        panelDegradado1 = new com.mytools.swings.JComponents.PanelDegradado();
        labelHeader1 = new com.mytools.swings.JComponents.Label.LabelHeader();
        panelDegradadoBotonMenu = new com.mytools.swings.JComponents.PanelDegradado();
        labelTitleBotonMenu = new com.mytools.swings.JComponents.Label.LabelTitle();
        botonColorFuenteBotonMenu = new com.mytools.swings.JComponents.BotonColor();
        botonGuadarBotonMenu = new com.mytools.swings.JComponents.BotonColor();
        botonColorBackBotonMenu = new com.mytools.swings.JComponents.BotonColor();
        panelDegradadoBotonColor = new com.mytools.swings.JComponents.PanelDegradado();
        labelTitleBotonMenu1 = new com.mytools.swings.JComponents.Label.LabelTitle();
        botonColorFuenteBotonColor = new com.mytools.swings.JComponents.BotonColor();
        botonGuadarBotonColor = new com.mytools.swings.JComponents.BotonColor();
        botonColorBackBotonColor = new com.mytools.swings.JComponents.BotonColor();
        panelDegradadoFontColor = new com.mytools.swings.JComponents.PanelDegradado();
        labelHeaderFontColor = new com.mytools.swings.JComponents.Label.LabelHeader();
        panelDegradadoEncabezados = new com.mytools.swings.JComponents.PanelDegradado();
        labelTitleEncabezados = new com.mytools.swings.JComponents.Label.LabelTitle();
        botonColorEncabezado = new com.mytools.swings.JComponents.BotonColor();
        labelHeaderEjemplo = new com.mytools.swings.JComponents.Label.LabelHeader();
        botonGuadarEncabezado = new com.mytools.swings.JComponents.BotonColor();
        panelDegradadoTitulos = new com.mytools.swings.JComponents.PanelDegradado();
        labelTitleTitulo = new com.mytools.swings.JComponents.Label.LabelTitle();
        botonColorTitulos = new com.mytools.swings.JComponents.BotonColor();
        botonGuadarTitulos = new com.mytools.swings.JComponents.BotonColor();
        labelTitleEjemplo = new com.mytools.swings.JComponents.Label.LabelTitle();
        panelDegradadoDescripciones = new com.mytools.swings.JComponents.PanelDegradado();
        labelTitleDescripciones = new com.mytools.swings.JComponents.Label.LabelTitle();
        botonColorDescripciones = new com.mytools.swings.JComponents.BotonColor();
        botonGuadarDescripciones = new com.mytools.swings.JComponents.BotonColor();
        labelDescripcionEjemplo = new com.mytools.swings.JComponents.Label.LabelDescripcion();
        panelDegradadoText = new com.mytools.swings.JComponents.PanelDegradado();
        labelTitleText = new com.mytools.swings.JComponents.Label.LabelTitle();
        botonColorText = new com.mytools.swings.JComponents.BotonColor();
        botonGuadarText = new com.mytools.swings.JComponents.BotonColor();
        txtFieldPanelEjemplo = new com.mytools.swings.JComponents.TxtFieldPanel();
        txtTextEjemplo = new com.mytools.swings.JComponents.TxtFieldTransparente();

        labelTextNumColores1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTextNumColores1.setText("Numero de Colores");
        labelTextNumColores1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 16)); // NOI18N

        setOpaque(false);

        labelHeaderFondo.setText("Apariencia de Fondo");

        javax.swing.GroupLayout PanelHeaderBackgroundLayout = new javax.swing.GroupLayout(PanelHeaderBackground);
        PanelHeaderBackground.setLayout(PanelHeaderBackgroundLayout);
        PanelHeaderBackgroundLayout.setHorizontalGroup(
            PanelHeaderBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelHeaderFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PanelHeaderBackgroundLayout.setVerticalGroup(
            PanelHeaderBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelHeaderFondo, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        botonColorInicial.setText("Color 1");
        botonColorInicial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonColorInicialActionPerformed(evt);
            }
        });

        botonColorMedio1.setText("Color 2");
        botonColorMedio1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonColorMedio1ActionPerformed(evt);
            }
        });

        botonColorMedio2.setText("Color 3");
        botonColorMedio2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonColorMedio2ActionPerformed(evt);
            }
        });

        botonColorFinal.setText("Color 4");
        botonColorFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonColorFinalActionPerformed(evt);
            }
        });

        labelTitleColores.setText("Colores de Fondo");

        javax.swing.GroupLayout panelColoresLayout = new javax.swing.GroupLayout(panelColores);
        panelColores.setLayout(panelColoresLayout);
        panelColoresLayout.setHorizontalGroup(
            panelColoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelColoresLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelColoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelTitleColores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botonColorInicial, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botonColorMedio1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botonColorMedio2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botonColorFinal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        panelColoresLayout.setVerticalGroup(
            panelColoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelColoresLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTitleColores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(botonColorInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botonColorMedio1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botonColorMedio2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botonColorFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        labelTitleFrancciones.setText("Fracciones de Colores");

        javax.swing.GroupLayout panelFraccionesLayout = new javax.swing.GroupLayout(panelFracciones);
        panelFracciones.setLayout(panelFraccionesLayout);
        panelFraccionesLayout.setHorizontalGroup(
            panelFraccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFraccionesLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelFraccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelTitleFrancciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sliderFranccionInicial, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sliderFranccionMedio1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sliderFranccionMedio2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sliderFranccionFinal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        panelFraccionesLayout.setVerticalGroup(
            panelFraccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFraccionesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTitleFrancciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sliderFranccionInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sliderFranccionMedio1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sliderFranccionMedio2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sliderFranccionFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        spinnerRadio.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        labelTitleRadio.setText("Radio de Circulo");

        labelDescripcionRadio.setText("Solo es utilizado al usar un fondo degradado radial");

        javax.swing.GroupLayout panelRadioLayout = new javax.swing.GroupLayout(panelRadio);
        panelRadio.setLayout(panelRadioLayout);
        panelRadioLayout.setHorizontalGroup(
            panelRadioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRadioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRadioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelTitleRadio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelRadioLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(spinnerRadio, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(labelDescripcionRadio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelRadioLayout.setVerticalGroup(
            panelRadioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRadioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTitleRadio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelDescripcionRadio, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(spinnerRadio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        labelTitlePosicion.setText("Posición / Orientación ");

        labelDescripcionPosicion.setText("Solo aplica a los degradados radiales o lineales");

        javax.swing.GroupLayout panelPosicionLayout = new javax.swing.GroupLayout(panelPosicion);
        panelPosicion.setLayout(panelPosicionLayout);
        panelPosicionLayout.setHorizontalGroup(
            panelPosicionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPosicionLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(comboBoxPosicion, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(labelTitlePosicion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(labelDescripcionPosicion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelPosicionLayout.setVerticalGroup(
            panelPosicionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPosicionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTitlePosicion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelDescripcionPosicion, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboBoxPosicion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        labelTitleNumColores.setText("Numero de Colores");

        labelDescripcionnumColore.setText("Solo es utilizado al usar un fondo degradado");

        jSliderNumColores.setMajorTickSpacing(1);
        jSliderNumColores.setMaximum(4);
        jSliderNumColores.setMinimum(1);
        jSliderNumColores.setPaintLabels(true);
        jSliderNumColores.setPaintTicks(true);
        jSliderNumColores.setValue(1);

        javax.swing.GroupLayout panelNumColoresLayout = new javax.swing.GroupLayout(panelNumColores);
        panelNumColores.setLayout(panelNumColoresLayout);
        panelNumColoresLayout.setHorizontalGroup(
            panelNumColoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelDescripcionnumColore, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelNumColoresLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelNumColoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelTitleNumColores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelNumColoresLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jSliderNumColores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelNumColoresLayout.setVerticalGroup(
            panelNumColoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelNumColoresLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTitleNumColores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelDescripcionnumColore, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSliderNumColores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        labelTitleTipoFondo.setText("Tipo de Fondo");

        buttonGroupTipoFondo.add(jRadioButtonSolido);
        jRadioButtonSolido.setText("Solido");
        jRadioButtonSolido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonSolidoActionPerformed(evt);
            }
        });

        buttonGroupTipoFondo.add(jRadioButtonDegradadoLineal);
        jRadioButtonDegradadoLineal.setText("Degra. Lineal");
        jRadioButtonDegradadoLineal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonDegradadoLinealActionPerformed(evt);
            }
        });

        buttonGroupTipoFondo.add(jRadioButtonDegradadoRadial);
        jRadioButtonDegradadoRadial.setText("Degra. Radial");

        javax.swing.GroupLayout panelTipoFondoLayout = new javax.swing.GroupLayout(panelTipoFondo);
        panelTipoFondo.setLayout(panelTipoFondoLayout);
        panelTipoFondoLayout.setHorizontalGroup(
            panelTipoFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelTitleTipoFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelTipoFondoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jRadioButtonSolido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonDegradadoLineal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(7, 7, 7)
                .addComponent(jRadioButtonDegradadoRadial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(6, 6, 6))
        );
        panelTipoFondoLayout.setVerticalGroup(
            panelTipoFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTipoFondoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTitleTipoFondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelTipoFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonSolido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButtonDegradadoRadial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButtonDegradadoLineal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        botonGuardarFondo.setText("Guadar");
        botonGuardarFondo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarFondoActionPerformed(evt);
            }
        });

        labelHeaderPanelDegra.setText("Diseño de Panel");

        javax.swing.GroupLayout PanelTitlePanelDegradadoLayout = new javax.swing.GroupLayout(PanelTitlePanelDegradado);
        PanelTitlePanelDegradado.setLayout(PanelTitlePanelDegradadoLayout);
        PanelTitlePanelDegradadoLayout.setHorizontalGroup(
            PanelTitlePanelDegradadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelHeaderPanelDegra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PanelTitlePanelDegradadoLayout.setVerticalGroup(
            PanelTitlePanelDegradadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelHeaderPanelDegra, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        spinnerGrosorBorde.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        labelTitleGrosorBorde.setText("Grosor del Borde");

        javax.swing.GroupLayout panelDegradadoGrosorBordeLayout = new javax.swing.GroupLayout(panelDegradadoGrosorBorde);
        panelDegradadoGrosorBorde.setLayout(panelDegradadoGrosorBordeLayout);
        panelDegradadoGrosorBordeLayout.setHorizontalGroup(
            panelDegradadoGrosorBordeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDegradadoGrosorBordeLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(spinnerGrosorBorde, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(labelTitleGrosorBorde, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelDegradadoGrosorBordeLayout.setVerticalGroup(
            panelDegradadoGrosorBordeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDegradadoGrosorBordeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTitleGrosorBorde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(spinnerGrosorBorde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        spinnerOpacidadBorde.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        labelTitleOpacidadBorde.setText("Opacidad del Borde");

        javax.swing.GroupLayout panelDegradadoOpacidadBordeLayout = new javax.swing.GroupLayout(panelDegradadoOpacidadBorde);
        panelDegradadoOpacidadBorde.setLayout(panelDegradadoOpacidadBordeLayout);
        panelDegradadoOpacidadBordeLayout.setHorizontalGroup(
            panelDegradadoOpacidadBordeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDegradadoOpacidadBordeLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(spinnerOpacidadBorde, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(labelTitleOpacidadBorde, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelDegradadoOpacidadBordeLayout.setVerticalGroup(
            panelDegradadoOpacidadBordeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDegradadoOpacidadBordeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTitleOpacidadBorde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(spinnerOpacidadBorde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        spinnerBordeRedondeado.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        labelTitleBordeRedondeado.setText("Borde Redondeado");

        javax.swing.GroupLayout panelDegradadoBordeRedondeadoLayout = new javax.swing.GroupLayout(panelDegradadoBordeRedondeado);
        panelDegradadoBordeRedondeado.setLayout(panelDegradadoBordeRedondeadoLayout);
        panelDegradadoBordeRedondeadoLayout.setHorizontalGroup(
            panelDegradadoBordeRedondeadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDegradadoBordeRedondeadoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(spinnerBordeRedondeado, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(labelTitleBordeRedondeado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelDegradadoBordeRedondeadoLayout.setVerticalGroup(
            panelDegradadoBordeRedondeadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDegradadoBordeRedondeadoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTitleBordeRedondeado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(spinnerBordeRedondeado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        spinnerOpacidadInicial.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        labelTitle1.setText("Opacidad Inicial del Panel");

        javax.swing.GroupLayout panelDegradadoOpacidadInicialLayout = new javax.swing.GroupLayout(panelDegradadoOpacidadInicial);
        panelDegradadoOpacidadInicial.setLayout(panelDegradadoOpacidadInicialLayout);
        panelDegradadoOpacidadInicialLayout.setHorizontalGroup(
            panelDegradadoOpacidadInicialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDegradadoOpacidadInicialLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(spinnerOpacidadInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(labelTitle1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelDegradadoOpacidadInicialLayout.setVerticalGroup(
            panelDegradadoOpacidadInicialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDegradadoOpacidadInicialLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTitle1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(spinnerOpacidadInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        spinnerOpacidadFinal.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        labelTitle2.setText("Opacidad Final del Panel");

        javax.swing.GroupLayout panelDegradadoOpacidadFinalLayout = new javax.swing.GroupLayout(panelDegradadoOpacidadFinal);
        panelDegradadoOpacidadFinal.setLayout(panelDegradadoOpacidadFinalLayout);
        panelDegradadoOpacidadFinalLayout.setHorizontalGroup(
            panelDegradadoOpacidadFinalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDegradadoOpacidadFinalLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(spinnerOpacidadFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(labelTitle2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelDegradadoOpacidadFinalLayout.setVerticalGroup(
            panelDegradadoOpacidadFinalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDegradadoOpacidadFinalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTitle2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(spinnerOpacidadFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        labelHeader1.setText("Diseño de Botones");

        javax.swing.GroupLayout panelDegradado1Layout = new javax.swing.GroupLayout(panelDegradado1);
        panelDegradado1.setLayout(panelDegradado1Layout);
        panelDegradado1Layout.setHorizontalGroup(
            panelDegradado1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelHeader1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelDegradado1Layout.setVerticalGroup(
            panelDegradado1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelHeader1, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        labelTitleBotonMenu.setText("Boton de menu");

        botonColorFuenteBotonMenu.setForeground(new java.awt.Color(255, 255, 255));
        botonColorFuenteBotonMenu.setText("Elejir Color de Fuente");
        botonColorFuenteBotonMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonColorFuenteBotonMenuActionPerformed(evt);
            }
        });

        botonGuadarBotonMenu.setText("Guardar");
        botonGuadarBotonMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuadarBotonMenuActionPerformed(evt);
            }
        });

        botonColorBackBotonMenu.setForeground(new java.awt.Color(255, 255, 255));
        botonColorBackBotonMenu.setText("Elejir Color de Marcador");
        botonColorBackBotonMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonColorBackBotonMenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelDegradadoBotonMenuLayout = new javax.swing.GroupLayout(panelDegradadoBotonMenu);
        panelDegradadoBotonMenu.setLayout(panelDegradadoBotonMenuLayout);
        panelDegradadoBotonMenuLayout.setHorizontalGroup(
            panelDegradadoBotonMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDegradadoBotonMenuLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botonColorFuenteBotonMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(botonColorBackBotonMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botonGuadarBotonMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(labelTitleBotonMenu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelDegradadoBotonMenuLayout.setVerticalGroup(
            panelDegradadoBotonMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDegradadoBotonMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTitleBotonMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDegradadoBotonMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonColorFuenteBotonMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonGuadarBotonMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonColorBackBotonMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        labelTitleBotonMenu1.setText("Boton de Normal");

        botonColorFuenteBotonColor.setForeground(new java.awt.Color(255, 255, 255));
        botonColorFuenteBotonColor.setText("Elejir Color de Fuente");
        botonColorFuenteBotonColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonColorFuenteBotonColorActionPerformed(evt);
            }
        });

        botonGuadarBotonColor.setText("Guardar");
        botonGuadarBotonColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuadarBotonColorActionPerformed(evt);
            }
        });

        botonColorBackBotonColor.setForeground(new java.awt.Color(255, 255, 255));
        botonColorBackBotonColor.setText("Elejir Color de Fondo");
        botonColorBackBotonColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonColorBackBotonColorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelDegradadoBotonColorLayout = new javax.swing.GroupLayout(panelDegradadoBotonColor);
        panelDegradadoBotonColor.setLayout(panelDegradadoBotonColorLayout);
        panelDegradadoBotonColorLayout.setHorizontalGroup(
            panelDegradadoBotonColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDegradadoBotonColorLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botonColorFuenteBotonColor, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botonColorBackBotonColor, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botonGuadarBotonColor, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(labelTitleBotonMenu1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelDegradadoBotonColorLayout.setVerticalGroup(
            panelDegradadoBotonColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDegradadoBotonColorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTitleBotonMenu1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDegradadoBotonColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonColorFuenteBotonColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonGuadarBotonColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonColorBackBotonColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        labelHeaderFontColor.setText("Colores de Fuentes");

        javax.swing.GroupLayout panelDegradadoFontColorLayout = new javax.swing.GroupLayout(panelDegradadoFontColor);
        panelDegradadoFontColor.setLayout(panelDegradadoFontColorLayout);
        panelDegradadoFontColorLayout.setHorizontalGroup(
            panelDegradadoFontColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelHeaderFontColor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelDegradadoFontColorLayout.setVerticalGroup(
            panelDegradadoFontColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelHeaderFontColor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        labelTitleEncabezados.setText("Encabezados");

        botonColorEncabezado.setForeground(new java.awt.Color(255, 255, 255));
        botonColorEncabezado.setText("Elejir Color");
        botonColorEncabezado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonColorEncabezadoActionPerformed(evt);
            }
        });

        labelHeaderEjemplo.setText("Ejemplo*");

        botonGuadarEncabezado.setText("Guardar");
        botonGuadarEncabezado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuadarEncabezadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelDegradadoEncabezadosLayout = new javax.swing.GroupLayout(panelDegradadoEncabezados);
        panelDegradadoEncabezados.setLayout(panelDegradadoEncabezadosLayout);
        panelDegradadoEncabezadosLayout.setHorizontalGroup(
            panelDegradadoEncabezadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDegradadoEncabezadosLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(botonColorEncabezado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12))
            .addGroup(panelDegradadoEncabezadosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTitleEncabezados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(panelDegradadoEncabezadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDegradadoEncabezadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelHeaderEjemplo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelDegradadoEncabezadosLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(botonGuadarEncabezado, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panelDegradadoEncabezadosLayout.setVerticalGroup(
            panelDegradadoEncabezadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDegradadoEncabezadosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTitleEncabezados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botonColorEncabezado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelHeaderEjemplo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botonGuadarEncabezado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        labelTitleTitulo.setText("Titulos");

        botonColorTitulos.setForeground(new java.awt.Color(255, 255, 255));
        botonColorTitulos.setText("Elejir Color");
        botonColorTitulos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonColorTitulosActionPerformed(evt);
            }
        });

        botonGuadarTitulos.setText("Guardar");
        botonGuadarTitulos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuadarTitulosActionPerformed(evt);
            }
        });

        labelTitleEjemplo.setText("Este es un ejemplo*");

        javax.swing.GroupLayout panelDegradadoTitulosLayout = new javax.swing.GroupLayout(panelDegradadoTitulos);
        panelDegradadoTitulos.setLayout(panelDegradadoTitulosLayout);
        panelDegradadoTitulosLayout.setHorizontalGroup(
            panelDegradadoTitulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDegradadoTitulosLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(botonColorTitulos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDegradadoTitulosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTitleEjemplo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDegradadoTitulosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTitleTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDegradadoTitulosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botonGuadarTitulos, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelDegradadoTitulosLayout.setVerticalGroup(
            panelDegradadoTitulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDegradadoTitulosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTitleTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botonColorTitulos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelTitleEjemplo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botonGuadarTitulos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        labelTitleDescripciones.setText("Descripciones");

        botonColorDescripciones.setForeground(new java.awt.Color(255, 255, 255));
        botonColorDescripciones.setText("Elejir Color");
        botonColorDescripciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonColorDescripcionesActionPerformed(evt);
            }
        });

        botonGuadarDescripciones.setText("Guardar");
        botonGuadarDescripciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuadarDescripcionesActionPerformed(evt);
            }
        });

        labelDescripcionEjemplo.setText("Este es un ejemplo de descripciones*");

        javax.swing.GroupLayout panelDegradadoDescripcionesLayout = new javax.swing.GroupLayout(panelDegradadoDescripciones);
        panelDegradadoDescripciones.setLayout(panelDegradadoDescripcionesLayout);
        panelDegradadoDescripcionesLayout.setHorizontalGroup(
            panelDegradadoDescripcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDegradadoDescripcionesLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(botonColorDescripciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12))
            .addGroup(panelDegradadoDescripcionesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelDescripcionEjemplo, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(panelDegradadoDescripcionesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTitleDescripciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDegradadoDescripcionesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botonGuadarDescripciones, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelDegradadoDescripcionesLayout.setVerticalGroup(
            panelDegradadoDescripcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDegradadoDescripcionesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTitleDescripciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botonColorDescripciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelDescripcionEjemplo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botonGuadarDescripciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        labelTitleText.setText("Textos");

        botonColorText.setForeground(new java.awt.Color(255, 255, 255));
        botonColorText.setText("Elejir Color");
        botonColorText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonColorTextActionPerformed(evt);
            }
        });

        botonGuadarText.setText("Guardar");
        botonGuadarText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuadarTextActionPerformed(evt);
            }
        });

        txtTextEjemplo.setText("Ejemplo*");
        txtTextEjemplo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTextEjemploActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout txtFieldPanelEjemploLayout = new javax.swing.GroupLayout(txtFieldPanelEjemplo);
        txtFieldPanelEjemplo.setLayout(txtFieldPanelEjemploLayout);
        txtFieldPanelEjemploLayout.setHorizontalGroup(
            txtFieldPanelEjemploLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, txtFieldPanelEjemploLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(txtTextEjemplo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        txtFieldPanelEjemploLayout.setVerticalGroup(
            txtFieldPanelEjemploLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtTextEjemplo, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelDegradadoTextLayout = new javax.swing.GroupLayout(panelDegradadoText);
        panelDegradadoText.setLayout(panelDegradadoTextLayout);
        panelDegradadoTextLayout.setHorizontalGroup(
            panelDegradadoTextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDegradadoTextLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(botonColorText, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                .addGap(12, 12, 12))
            .addGroup(panelDegradadoTextLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTitleText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(panelDegradadoTextLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtFieldPanelEjemplo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDegradadoTextLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botonGuadarText, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelDegradadoTextLayout.setVerticalGroup(
            panelDegradadoTextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDegradadoTextLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTitleText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botonColorText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFieldPanelEjemplo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonGuadarText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelDegradadoEncabezados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelDegradadoTitulos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelDegradadoDescripciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelDegradadoText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelDegradado1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelDegradadoFontColor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelHeaderBackground, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelColores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(panelNumColores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(2, 2, 2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(panelRadio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelPosicion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(panelTipoFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(2, 2, 2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelFracciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(botonGuardarFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(PanelTitlePanelDegradado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelDegradadoGrosorBorde, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelDegradadoOpacidadBorde, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelDegradadoBordeRedondeado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelDegradadoOpacidadInicial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelDegradadoOpacidadFinal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(panelDegradadoBotonColor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelDegradadoBotonMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelHeaderBackground, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelColores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panelNumColores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelRadio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelPosicion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelTipoFondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelFracciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonGuardarFondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(PanelTitlePanelDegradado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(panelDegradadoOpacidadInicial, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelDegradadoBordeRedondeado, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelDegradadoOpacidadBorde, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelDegradadoGrosorBorde, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelDegradadoOpacidadFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(panelDegradado1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(panelDegradadoBotonMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelDegradadoBotonColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelDegradadoFontColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelDegradadoEncabezados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelDegradadoTitulos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelDegradadoDescripciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelDegradadoText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(359, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void botonColorMedio2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonColorMedio2ActionPerformed
        elegirColor(botonColorMedio2, PDB.getColorMedia2(), null);
    }//GEN-LAST:event_botonColorMedio2ActionPerformed

    private void botonColorInicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonColorInicialActionPerformed
        elegirColor(botonColorInicial, PDB.getColorInicial(), null);
    }//GEN-LAST:event_botonColorInicialActionPerformed

    private void botonColorMedio1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonColorMedio1ActionPerformed
        elegirColor(botonColorMedio1, PDB.getColorMedia1(), null);
    }//GEN-LAST:event_botonColorMedio1ActionPerformed

    private void botonColorFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonColorFinalActionPerformed
        elegirColor(botonColorFinal, PDB.getColorFinal(), null);
    }//GEN-LAST:event_botonColorFinalActionPerformed

    private void botonGuardarFondoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarFondoActionPerformed
        guardarConfigurarcionBackground();
        guardarConfigurarcionPanelDegradado();
    }//GEN-LAST:event_botonGuardarFondoActionPerformed

    private void botonColorEncabezadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonColorEncabezadoActionPerformed
        elegirColor(botonColorEncabezado, labelHeaderEjemplo.getForeground(), labelHeaderEjemplo);
    }//GEN-LAST:event_botonColorEncabezadoActionPerformed

    private void botonGuadarEncabezadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuadarEncabezadoActionPerformed
        ConfiguracionArchivo.setForeground("LabelHeader", labelHeaderEjemplo);
    }//GEN-LAST:event_botonGuadarEncabezadoActionPerformed

    private void botonColorTitulosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonColorTitulosActionPerformed
        elegirColor(botonColorTitulos, labelTitleEjemplo.getForeground(), labelTitleEjemplo);
    }//GEN-LAST:event_botonColorTitulosActionPerformed

    private void botonGuadarTitulosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuadarTitulosActionPerformed
        ConfiguracionArchivo.setForeground("LabelTitle", labelTitleEjemplo);
    }//GEN-LAST:event_botonGuadarTitulosActionPerformed

    private void botonColorDescripcionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonColorDescripcionesActionPerformed
        elegirColor(botonColorDescripciones, labelDescripcionEjemplo.getForeground(), labelDescripcionEjemplo);
    }//GEN-LAST:event_botonColorDescripcionesActionPerformed

    private void botonGuadarDescripcionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuadarDescripcionesActionPerformed
        ConfiguracionArchivo.setForeground("LabelDescripcion", labelDescripcionEjemplo);
    }//GEN-LAST:event_botonGuadarDescripcionesActionPerformed

    private void botonColorFuenteBotonMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonColorFuenteBotonMenuActionPerformed
        elegirColor(botonColorFuenteBotonMenu, botonColorFuenteBotonMenu.getBackground(), null);
    }//GEN-LAST:event_botonColorFuenteBotonMenuActionPerformed

    private void botonGuadarBotonMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuadarBotonMenuActionPerformed
        BotonMenu btn = new BotonMenu();
        btn.setBackground(botonColorBackBotonMenu.getBackground());
        btn.setForeground(botonColorFuenteBotonMenu.getBackground());
        ConfiguracionArchivo.setBoton("botonMenu", btn);

    }//GEN-LAST:event_botonGuadarBotonMenuActionPerformed

    private void botonColorBackBotonMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonColorBackBotonMenuActionPerformed
        elegirColor(botonColorBackBotonMenu, botonColorBackBotonMenu.getBackground(), null);
    }//GEN-LAST:event_botonColorBackBotonMenuActionPerformed

    private void botonColorFuenteBotonColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonColorFuenteBotonColorActionPerformed
        elegirColor(botonColorFuenteBotonColor, botonColorFuenteBotonColor.getBackground(), null);
    }//GEN-LAST:event_botonColorFuenteBotonColorActionPerformed

    private void botonGuadarBotonColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuadarBotonColorActionPerformed
        BotonColor btn = new BotonColor();
        btn.setBackground(botonColorBackBotonColor.getBackground());
        btn.setForeground(botonColorFuenteBotonColor.getBackground());
        ConfiguracionArchivo.setBoton("botonColor", btn);
    }//GEN-LAST:event_botonGuadarBotonColorActionPerformed

    private void botonColorBackBotonColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonColorBackBotonColorActionPerformed
        elegirColor(botonColorBackBotonColor, botonColorBackBotonColor.getBackground(), null);
    }//GEN-LAST:event_botonColorBackBotonColorActionPerformed

    private void botonColorTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonColorTextActionPerformed
        elegirColor(botonColorText, botonColorText.getBackground(), txtTextEjemplo);
    }//GEN-LAST:event_botonColorTextActionPerformed

    private void botonGuadarTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuadarTextActionPerformed
        ConfiguracionArchivo.setForeground("labelText", txtTextEjemplo);
    }//GEN-LAST:event_botonGuadarTextActionPerformed

    private void txtTextEjemploActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTextEjemploActionPerformed

    }//GEN-LAST:event_txtTextEjemploActionPerformed

    private void jRadioButtonDegradadoLinealActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonDegradadoLinealActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonDegradadoLinealActionPerformed

    private void jRadioButtonSolidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonSolidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonSolidoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.mytools.swings.JComponents.PanelDegradado PanelHeaderBackground;
    private com.mytools.swings.JComponents.PanelDegradado PanelTitlePanelDegradado;
    private com.mytools.swings.JComponents.BotonColor botonColorBackBotonColor;
    private com.mytools.swings.JComponents.BotonColor botonColorBackBotonMenu;
    private com.mytools.swings.JComponents.BotonColor botonColorDescripciones;
    private com.mytools.swings.JComponents.BotonColor botonColorEncabezado;
    private com.mytools.swings.JComponents.BotonColor botonColorFinal;
    private com.mytools.swings.JComponents.BotonColor botonColorFuenteBotonColor;
    private com.mytools.swings.JComponents.BotonColor botonColorFuenteBotonMenu;
    private com.mytools.swings.JComponents.BotonColor botonColorInicial;
    private com.mytools.swings.JComponents.BotonColor botonColorMedio1;
    private com.mytools.swings.JComponents.BotonColor botonColorMedio2;
    private com.mytools.swings.JComponents.BotonColor botonColorText;
    private com.mytools.swings.JComponents.BotonColor botonColorTitulos;
    private com.mytools.swings.JComponents.BotonColor botonGuadarBotonColor;
    private com.mytools.swings.JComponents.BotonColor botonGuadarBotonMenu;
    private com.mytools.swings.JComponents.BotonColor botonGuadarDescripciones;
    private com.mytools.swings.JComponents.BotonColor botonGuadarEncabezado;
    private com.mytools.swings.JComponents.BotonColor botonGuadarText;
    private com.mytools.swings.JComponents.BotonColor botonGuadarTitulos;
    private com.mytools.swings.JComponents.BotonColor botonGuardarFondo;
    private javax.swing.ButtonGroup buttonGroupTipoFondo;
    private com.mytools.swings.JComponents.ComboBox comboBoxPosicion;
    private com.mytools.swings.JComponents.RadioButton jRadioButtonDegradadoLineal;
    private com.mytools.swings.JComponents.RadioButton jRadioButtonDegradadoRadial;
    private com.mytools.swings.JComponents.RadioButton jRadioButtonSolido;
    private com.mytools.swings.JComponents.Slider jSliderNumColores;
    private com.mytools.swings.JComponents.Label.LabelDescripcion labelDescripcionEjemplo;
    private com.mytools.swings.JComponents.Label.LabelDescripcion labelDescripcionPosicion;
    private com.mytools.swings.JComponents.Label.LabelDescripcion labelDescripcionRadio;
    private com.mytools.swings.JComponents.Label.LabelDescripcion labelDescripcionnumColore;
    private com.mytools.swings.JComponents.Label.LabelHeader labelHeader1;
    private com.mytools.swings.JComponents.Label.LabelHeader labelHeaderEjemplo;
    private com.mytools.swings.JComponents.Label.LabelHeader labelHeaderFondo;
    private com.mytools.swings.JComponents.Label.LabelHeader labelHeaderFontColor;
    private com.mytools.swings.JComponents.Label.LabelHeader labelHeaderPanelDegra;
    private com.mytools.swings.JComponents.Label.LabelText labelTextNumColores1;
    private com.mytools.swings.JComponents.Label.LabelTitle labelTitle1;
    private com.mytools.swings.JComponents.Label.LabelTitle labelTitle2;
    private com.mytools.swings.JComponents.Label.LabelTitle labelTitleBordeRedondeado;
    private com.mytools.swings.JComponents.Label.LabelTitle labelTitleBotonMenu;
    private com.mytools.swings.JComponents.Label.LabelTitle labelTitleBotonMenu1;
    private com.mytools.swings.JComponents.Label.LabelTitle labelTitleColores;
    private com.mytools.swings.JComponents.Label.LabelTitle labelTitleDescripciones;
    private com.mytools.swings.JComponents.Label.LabelTitle labelTitleEjemplo;
    private com.mytools.swings.JComponents.Label.LabelTitle labelTitleEncabezados;
    private com.mytools.swings.JComponents.Label.LabelTitle labelTitleFrancciones;
    private com.mytools.swings.JComponents.Label.LabelTitle labelTitleGrosorBorde;
    private com.mytools.swings.JComponents.Label.LabelTitle labelTitleNumColores;
    private com.mytools.swings.JComponents.Label.LabelTitle labelTitleOpacidadBorde;
    private com.mytools.swings.JComponents.Label.LabelTitle labelTitlePosicion;
    private com.mytools.swings.JComponents.Label.LabelTitle labelTitleRadio;
    private com.mytools.swings.JComponents.Label.LabelTitle labelTitleText;
    private com.mytools.swings.JComponents.Label.LabelTitle labelTitleTipoFondo;
    private com.mytools.swings.JComponents.Label.LabelTitle labelTitleTitulo;
    private com.mytools.swings.JComponents.PanelDegradado panelColores;
    private com.mytools.swings.JComponents.PanelDegradado panelDegradado1;
    private com.mytools.swings.JComponents.PanelDegradado panelDegradadoBordeRedondeado;
    private com.mytools.swings.JComponents.PanelDegradado panelDegradadoBotonColor;
    private com.mytools.swings.JComponents.PanelDegradado panelDegradadoBotonMenu;
    private com.mytools.swings.JComponents.PanelDegradado panelDegradadoDescripciones;
    private com.mytools.swings.JComponents.PanelDegradado panelDegradadoEncabezados;
    private com.mytools.swings.JComponents.PanelDegradado panelDegradadoFontColor;
    private com.mytools.swings.JComponents.PanelDegradado panelDegradadoGrosorBorde;
    private com.mytools.swings.JComponents.PanelDegradado panelDegradadoOpacidadBorde;
    private com.mytools.swings.JComponents.PanelDegradado panelDegradadoOpacidadFinal;
    private com.mytools.swings.JComponents.PanelDegradado panelDegradadoOpacidadInicial;
    private com.mytools.swings.JComponents.PanelDegradado panelDegradadoText;
    private com.mytools.swings.JComponents.PanelDegradado panelDegradadoTitulos;
    private com.mytools.swings.JComponents.PanelDegradado panelFracciones;
    private com.mytools.swings.JComponents.PanelDegradado panelNumColores;
    private com.mytools.swings.JComponents.PanelDegradado panelPosicion;
    private com.mytools.swings.JComponents.PanelDegradado panelRadio;
    private com.mytools.swings.JComponents.PanelDegradado panelTipoFondo;
    private com.mytools.swings.JComponents.SliderFranccion sliderFranccionFinal;
    private com.mytools.swings.JComponents.SliderFranccion sliderFranccionInicial;
    private com.mytools.swings.JComponents.SliderFranccion sliderFranccionMedio1;
    private com.mytools.swings.JComponents.SliderFranccion sliderFranccionMedio2;
    private com.mytools.swings.JComponents.Spinner spinnerBordeRedondeado;
    private com.mytools.swings.JComponents.Spinner spinnerGrosorBorde;
    private com.mytools.swings.JComponents.Spinner spinnerOpacidadBorde;
    private com.mytools.swings.JComponents.Spinner spinnerOpacidadFinal;
    private com.mytools.swings.JComponents.Spinner spinnerOpacidadInicial;
    private com.mytools.swings.JComponents.Spinner spinnerRadio;
    private com.mytools.swings.JComponents.TxtFieldPanel txtFieldPanelEjemplo;
    private com.mytools.swings.JComponents.TxtFieldTransparente txtTextEjemplo;
    // End of variables declaration//GEN-END:variables
}
