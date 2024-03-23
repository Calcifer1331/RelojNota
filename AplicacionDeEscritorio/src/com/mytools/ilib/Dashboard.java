package com.mytools.ilib;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.demo.intellijthemes.IJThemesPanel;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.mytools.views.Configuracion;
import com.mytools.views.Inicio;
import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class Dashboard extends javax.swing.JFrame {

    private final int MAX_ICON_SIZE = 20;

    private FlatSVGIcon svgIcon;

    public Dashboard() {
        initComponents();
        Init();
    }

    private void Init() {
        botonMenuConfiguracion.setSvgImage("resource/IconMenu/Settings.svg");
        try {
            ShoJPanel(new Inicio());
        } catch (Exception ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        toggleMenu();
    }

    public static void ShoJPanel(JPanel p) {
        content.removeAll();
        content.setLayout(new BorderLayout());  // Añade esta línea para restablecer el diseño del Content
        content.add(p, BorderLayout.CENTER);
        content.revalidate();
        content.repaint();
    }

    private void toggleMenu() {
        // Cambiar la visibilidad del menú
        menu.setVisible(!menu.isVisible());
        showMenu.setIcon(setSVG(menu.isVisible() ? "resource/chevron-left-solid.svg" : "resource/chevron-right-solid.svg"));
        revalidate();
        repaint();
    }

    private FlatSVGIcon setSVG(String img) {
        svgIcon = new FlatSVGIcon(img, 13, 20);
        return svgIcon;
    }

    private void SelectorMenu(JPanel Pagina, int indice) {
        // Deseleccionar todos los botones
        botonMenuConfiguracion.setSelecionado(false);

        // Seleccionar el botón específico
        switch (indice) {

            case 10:
                botonMenuConfiguracion.setSelecionado(true);
                botonMenuConfiguracion.setSelecionado(true);
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
        showMenu = new javax.swing.JLabel();
        scrollPanelTransparente1 = new com.mytools.swings.JComponents.ScrollPanelTransparente();
        content = new javax.swing.JPanel();
        menu = new com.mytools.swings.JComponents.PanelDegradado();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        botonMenuConfiguracion.setGrosorBarra(3);
        botonMenuConfiguracion.setRedondeadoBarra(3);
        botonMenuConfiguracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMenuConfiguracionActionPerformed(evt);
            }
        });

        showMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                showMenuMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                showMenuMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                showMenuMousePressed(evt);
            }
        });

        scrollPanelTransparente1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        content.setOpaque(false);

        javax.swing.GroupLayout contentLayout = new javax.swing.GroupLayout(content);
        content.setLayout(contentLayout);
        contentLayout.setHorizontalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 721, Short.MAX_VALUE)
        );
        contentLayout.setVerticalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 716, Short.MAX_VALUE)
        );

        scrollPanelTransparente1.setViewportView(content);

        javax.swing.GroupLayout menuLayout = new javax.swing.GroupLayout(menu);
        menu.setLayout(menuLayout);
        menuLayout.setHorizontalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 280, Short.MAX_VALUE)
        );
        menuLayout.setVerticalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 628, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelDegradadoBack1Layout = new javax.swing.GroupLayout(panelDegradadoBack1);
        panelDegradadoBack1.setLayout(panelDegradadoBack1Layout);
        panelDegradadoBack1Layout.setHorizontalGroup(
            panelDegradadoBack1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDegradadoBack1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(showMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDegradadoBack1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollPanelTransparente1, javax.swing.GroupLayout.DEFAULT_SIZE, 689, Short.MAX_VALUE)
                    .addGroup(panelDegradadoBack1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(botonMenuConfiguracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panelDegradadoBack1Layout.setVerticalGroup(
            panelDegradadoBack1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDegradadoBack1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDegradadoBack1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(showMenu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDegradadoBack1Layout.createSequentialGroup()
                        .addComponent(botonMenuConfiguracion, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scrollPanelTransparente1, javax.swing.GroupLayout.DEFAULT_SIZE, 582, Short.MAX_VALUE))
                    .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        JPanel Pagina = null;
        boolean a = botonMenuConfiguracion.isSelecionado();
        if (a) {
            Pagina=(new Inicio());
            
        } else {

            Pagina=(new Configuracion());
        }
        botonMenuConfiguracion.setSelecionado(!botonMenuConfiguracion.isSelecionado());
        ShoJPanel(Pagina);
    }//GEN-LAST:event_botonMenuConfiguracionActionPerformed

    private void showMenuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showMenuMousePressed
        toggleMenu();
    }//GEN-LAST:event_showMenuMousePressed

    private void showMenuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showMenuMouseExited
        showMenu.setIcon(setSVG(menu.isVisible() ? "resource/chevron-left-solid.svg" : "resource/chevron-right-solid.svg"));
    }//GEN-LAST:event_showMenuMouseExited

    private void showMenuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showMenuMouseEntered
        showMenu.setIcon(setSVG(menu.isVisible() ? "resource/chevron-left-solid-selected.svg" : "resource/chevron-right-solid-selected.svg"));
    }//GEN-LAST:event_showMenuMouseEntered

    public static void main(String args[]) {

        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.mytools.swings.JComponents.BotonMenu botonMenuConfiguracion;
    public static javax.swing.JPanel content;
    private com.mytools.swings.JComponents.PanelDegradado menu;
    public com.mytools.swings.JComponents.PanelDegradadoBack panelDegradadoBack1;
    private com.mytools.swings.JComponents.ScrollPanelTransparente scrollPanelTransparente1;
    private javax.swing.JLabel showMenu;
    // End of variables declaration//GEN-END:variables
}
