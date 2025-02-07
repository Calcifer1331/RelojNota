package com.mytools.ilib;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.mytools.swings.JComponents.Alarmas.Alarma_Timbre;
import com.mytools.utils.Alarma;
import com.mytools.views.ConfigAlarma;
import com.mytools.views.Configuracion;
import com.mytools.views.Inicio;
import com.mytools.views.detenerAlarma;
import com.mytools.views.prueva;
import com.mytools.views.prueva1;
import com.mytools.views.pruevaAlarma;
import java.awt.AWTException;
import java.awt.BorderLayout;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class Dashboard extends javax.swing.JFrame {

    public static Alarma alarma;
    private Inicio inicio;
    private ConfigAlarma configAlarma;
    private Configuracion configuracion;
    private pruevaAlarma pruAlarma;
    private List<Alarma_Timbre> alarmas = new ArrayList<Alarma_Timbre>();
    private TrayIcon trayIcon;

    public Dashboard() {
        initComponents();
        alarma = new Alarma();
        Init();
    }
    


    private void Init() {
        alarma.setHoraInicio(2);
        alarma.getTimbre().setMinutoInicio(2);
        inicio = new Inicio(alarma, this);
        alarma.addAlarmaListener(inicio);
        alarma.getTimbre().addTimbreListener(inicio);
        configAlarma = new ConfigAlarma(alarma);
        configuracion = new Configuracion();

        Alarma_Timbre alarma_Timbre = new Alarma_Timbre("Yoseph");
        alarmas.add(alarma_Timbre);
        System.out.println(alarmas.get(0).getNombre());
        pruAlarma = new pruevaAlarma(alarmas);
ShoJPanel(inicio);
        /*botonMenuConfiguracion.setSvgImage("resource/IconMenu/Settings.svg");
        botonMenuConfgReloj.setSvgImage("resource/IconMenu/reloj.svg");
        botonMenuHome.setSvgImage("resource/IconMenu/Home.svg");
        try {
            SelectorMenu(inicio, 1);
        } catch (Exception ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }

    public static void ShoJPanel(JPanel p) {
        content.removeAll();
        content.setLayout(new BorderLayout());  // Añade esta línea para restablecer el diseño del Content
        content.add(p, BorderLayout.CENTER);
        content.revalidate();
        content.repaint();
    }

    public void sicloReloj() {

    }

    /*private void SelectorMenu(JPanel Pagina, int indice) {
        // Deseleccionar todos los botones
        botonMenuConfiguracion.setSelecionado(false);
        botonMenuConfgReloj.setSelecionado(false);
        botonMenuHome.setSelecionado(false);

        // Seleccionar el botón específico
        switch (indice) {
            case 1:
                botonMenuHome.setSelecionado(true);
                break;
            case 2:
                botonMenuConfiguracion.setSelecionado(true);
                break;
            case 3:
                botonMenuConfgReloj.setSelecionado(true);
                break;
            default:

        }
        if (Pagina.getClass() == Inicio.class) {
            alarma.addAlarmaListener((Alarma.AlarmaListener) Pagina);
        }
        ShoJPanel(Pagina);
    }*/

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelDegradadoBack1 = new com.mytools.swings.JComponents.PanelDegradadoBack();
        scrollPanelTransparente1 = new com.mytools.swings.JComponents.ScrollPanelTransparente();
        content = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        scrollPanelTransparente1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        content.setOpaque(false);

        javax.swing.GroupLayout contentLayout = new javax.swing.GroupLayout(content);
        content.setLayout(contentLayout);
        contentLayout.setHorizontalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 986, Short.MAX_VALUE)
        );
        contentLayout.setVerticalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 716, Short.MAX_VALUE)
        );

        scrollPanelTransparente1.setViewportView(content);

        javax.swing.GroupLayout panelDegradadoBack1Layout = new javax.swing.GroupLayout(panelDegradadoBack1);
        panelDegradadoBack1.setLayout(panelDegradadoBack1Layout);
        panelDegradadoBack1Layout.setHorizontalGroup(
            panelDegradadoBack1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDegradadoBack1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPanelTransparente1, javax.swing.GroupLayout.DEFAULT_SIZE, 694, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelDegradadoBack1Layout.setVerticalGroup(
            panelDegradadoBack1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDegradadoBack1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPanelTransparente1, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelDegradadoBack1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelDegradadoBack1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Dashboard d = new Dashboard();
                d.setVisible(true);
                d.setExtendedState(MAXIMIZED_BOTH);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JPanel content;
    public com.mytools.swings.JComponents.PanelDegradadoBack panelDegradadoBack1;
    private com.mytools.swings.JComponents.ScrollPanelTransparente scrollPanelTransparente1;
    // End of variables declaration//GEN-END:variables
}
