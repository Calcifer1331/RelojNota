package com.mytools.ilib;

import com.formdev.flatlaf.FlatDarkLaf;
import com.mytools.utils.Alarma;
import com.mytools.views.ConfigAlarma;
import com.mytools.views.Configuracion;
import com.mytools.views.Inicio;
import java.awt.BorderLayout;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class Dashboard extends javax.swing.JFrame {

    public static Alarma alarma;
    
    public Dashboard() {
        initComponents();
        alarma=new Alarma();
        Init();
    }

    private void Init() {
        botonMenuConfiguracion.setSvgImage("resource/IconMenu/Settings.svg");
        botonMenuConfgReloj.setSvgImage("resource/IconMenu/reloj.svg");
        botonMenuHome.setSvgImage("resource/IconMenu/Home.svg");
        try {
            SelectorMenu(new Inicio(alarma), 1);
        } catch (Exception ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void ShoJPanel(JPanel p) {
        content.removeAll();
        content.setLayout(new BorderLayout());  // Añade esta línea para restablecer el diseño del Content
        content.add(p, BorderLayout.CENTER);
        content.revalidate();
        content.repaint();
    }
    
    public void sicloReloj(){
        
    }

    private void SelectorMenu(JPanel Pagina, int indice) {
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
            case 4:
                break;
            case 5:
                break;
            case 10:

                break;
            default:

        }
        ShoJPanel(Pagina);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelDegradadoBack1 = new com.mytools.swings.JComponents.PanelDegradadoBack();
        botonMenuConfiguracion = new com.mytools.swings.JComponents.BotonMenu();
        scrollPanelTransparente1 = new com.mytools.swings.JComponents.ScrollPanelTransparente();
        content = new javax.swing.JPanel();
        panelDegradado1 = new com.mytools.swings.JComponents.PanelDegradado();
        botonMenuConfgReloj = new com.mytools.swings.JComponents.BotonMenu();
        botonMenuHome = new com.mytools.swings.JComponents.BotonMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        botonMenuConfiguracion.setGrosorBarra(3);
        botonMenuConfiguracion.setRedondeadoBarra(3);
        botonMenuConfiguracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMenuConfiguracionActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout panelDegradado1Layout = new javax.swing.GroupLayout(panelDegradado1);
        panelDegradado1.setLayout(panelDegradado1Layout);
        panelDegradado1Layout.setHorizontalGroup(
            panelDegradado1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelDegradado1Layout.setVerticalGroup(
            panelDegradado1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        botonMenuConfgReloj.setGrosorBarra(3);
        botonMenuConfgReloj.setRedondeadoBarra(3);
        botonMenuConfgReloj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMenuConfgRelojActionPerformed(evt);
            }
        });

        botonMenuHome.setGrosorBarra(3);
        botonMenuHome.setRedondeadoBarra(3);
        botonMenuHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMenuHomeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelDegradadoBack1Layout = new javax.swing.GroupLayout(panelDegradadoBack1);
        panelDegradadoBack1.setLayout(panelDegradadoBack1Layout);
        panelDegradadoBack1Layout.setHorizontalGroup(
            panelDegradadoBack1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDegradadoBack1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDegradadoBack1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(scrollPanelTransparente1, javax.swing.GroupLayout.DEFAULT_SIZE, 694, Short.MAX_VALUE)
                    .addGroup(panelDegradadoBack1Layout.createSequentialGroup()
                        .addComponent(panelDegradado1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonMenuHome, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonMenuConfgReloj, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonMenuConfiguracion, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panelDegradadoBack1Layout.setVerticalGroup(
            panelDegradadoBack1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDegradadoBack1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDegradadoBack1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(botonMenuConfiguracion, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(panelDegradado1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botonMenuConfgReloj, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(botonMenuHome, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                .addGap(6, 6, 6)
                .addComponent(scrollPanelTransparente1, javax.swing.GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE)
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

    private void botonMenuConfiguracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMenuConfiguracionActionPerformed
        SelectorMenu(new Configuracion(), 2);
    }//GEN-LAST:event_botonMenuConfiguracionActionPerformed

    private void botonMenuConfgRelojActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMenuConfgRelojActionPerformed
        SelectorMenu(new ConfigAlarma(alarma), 3);
    }//GEN-LAST:event_botonMenuConfgRelojActionPerformed

    private void botonMenuHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMenuHomeActionPerformed
        SelectorMenu(new Inicio(alarma), 1);
    }//GEN-LAST:event_botonMenuHomeActionPerformed

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
    private com.mytools.swings.JComponents.BotonMenu botonMenuConfgReloj;
    private com.mytools.swings.JComponents.BotonMenu botonMenuConfiguracion;
    private com.mytools.swings.JComponents.BotonMenu botonMenuHome;
    public static javax.swing.JPanel content;
    private com.mytools.swings.JComponents.PanelDegradado panelDegradado1;
    public com.mytools.swings.JComponents.PanelDegradadoBack panelDegradadoBack1;
    private com.mytools.swings.JComponents.ScrollPanelTransparente scrollPanelTransparente1;
    // End of variables declaration//GEN-END:variables
}
