package com.mywebmanager.ilib;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.mywebmanager.db.Database;
import com.mywebmanager.views.Prueva;
import com.mywebmanager.views.VerPerfume;
import com.mywebmanager.views.Configuracion;
import com.mywebmanager.views.EdictBanner;
import com.mywebmanager.views.Preva;
import com.mywebmanager.views.VerCategoria;
import com.mywebmanager.views.VerFeature;
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
        Conexion();
    }

    private void Init() {
        DBComprobar.setSvgImage("resource/info.svg");
        labelLogo1.setSvgImage("resource/GranFragancia_logo.svg");
        botonMenuVerPerfume.setSvgImage("resource/IconMenu/perfume.svg");
        botonMenuVerCategorias.setSvgImage("resource/IconMenu/Share.svg");
        botonMenuFeature.setSvgImage("resource/IconMenu/web.svg");
        botonMenuBanner.setSvgImage("resource/IconMenu/banner.svg");
        botonMenuConfiguracion.setSvgImage("resource/IconMenu/Settings.svg");
        try {
            SelectorMenu(new VerPerfume(), 2);
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
        botonMenuVerPerfume.setSelecionado(false);
        botonMenuVerCategorias.setSelecionado(false);
        botonMenuFeature.setSelecionado(false);
        botonMenuBanner.setSelecionado(false);
        botonMenuConfiguracion.setSelecionado(false);

        // Seleccionar el botón específico
        switch (indice) {
            case 2:
                botonMenuVerPerfume.setSelecionado(true);
                break;
            case 3:
                botonMenuVerCategorias.setSelecionado(true);
                break;
            case 4:
                botonMenuFeature.setSelecionado(true);
                break;
            case 5:
                botonMenuBanner.setSelecionado(true);
                break;
            case 10:
                botonMenuConfiguracion.setSelecionado(true);
                break;
            default:

        }
        ShoJPanel(Pagina);
    }

    private void Conexion() {
        Database db = new Database();

        try {
            db.Conectar();

            if (db.verificarConexion()) {
                DBConection.setSvgImage("resource/ok.svg");
                DBConection.setText("Conectado a Base de Datos.");
            } else {
                DBConection.setSvgImage("resource/unavailable.svg");
                DBConection.setText("Desconectado a Base de Datos.");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                db.Cerrar();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelDegradadoBack1 = new com.mywebmanager.swings.JComponents.PanelDegradadoBack();
        showMenu = new javax.swing.JLabel();
        scrollPanelTransparente1 = new com.mywebmanager.swings.JComponents.ScrollPanelTransparente();
        content = new javax.swing.JPanel();
        header = new javax.swing.JPanel();
        DBConection = new com.mywebmanager.swings.JComponents.Label.LabelText();
        DBComprobar = new com.mywebmanager.swings.JComponents.Label.LabelText();
        menu = new com.mywebmanager.swings.JComponents.PanelDegradado();
        labelLogo1 = new com.mywebmanager.swings.JComponents.Label.LabelLogo();
        jSeparator1 = new javax.swing.JSeparator();
        botonMenuVerPerfume = new com.mywebmanager.swings.JComponents.BotonMenu();
        botonMenuVerCategorias = new com.mywebmanager.swings.JComponents.BotonMenu();
        botonMenuFeature = new com.mywebmanager.swings.JComponents.BotonMenu();
        botonMenuBanner = new com.mywebmanager.swings.JComponents.BotonMenu();
        botonMenuConfiguracion = new com.mywebmanager.swings.JComponents.BotonMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        header.setOpaque(false);

        DBComprobar.setText("Comprobar Conexion");
        DBComprobar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                DBComprobarMousePressed(evt);
            }
        });

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(DBConection, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(DBComprobar, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DBConection, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DBComprobar, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE))
                .addContainerGap())
        );

        labelLogo1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N

        botonMenuVerPerfume.setText("Perfumes");
        botonMenuVerPerfume.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMenuVerPerfumeActionPerformed(evt);
            }
        });

        botonMenuVerCategorias.setText("Categorias");
        botonMenuVerCategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMenuVerCategoriasActionPerformed(evt);
            }
        });

        botonMenuFeature.setText("Caracteristicas");
        botonMenuFeature.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMenuFeatureActionPerformed(evt);
            }
        });

        botonMenuBanner.setText("Banner");
        botonMenuBanner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMenuBannerActionPerformed(evt);
            }
        });

        botonMenuConfiguracion.setText("Configurarcion");
        botonMenuConfiguracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMenuConfiguracionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout menuLayout = new javax.swing.GroupLayout(menu);
        menu.setLayout(menuLayout);
        menuLayout.setHorizontalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(botonMenuConfiguracion, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonMenuFeature, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botonMenuVerCategorias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelLogo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botonMenuVerPerfume, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botonMenuBanner, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        menuLayout.setVerticalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelLogo1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botonMenuVerPerfume, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonMenuVerCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonMenuBanner, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botonMenuFeature, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 168, Short.MAX_VALUE)
                .addComponent(botonMenuConfiguracion, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
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
                    .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelDegradadoBack1Layout.setVerticalGroup(
            panelDegradadoBack1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDegradadoBack1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDegradadoBack1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(showMenu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDegradadoBack1Layout.createSequentialGroup()
                        .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scrollPanelTransparente1, javax.swing.GroupLayout.DEFAULT_SIZE, 587, Short.MAX_VALUE))
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

    private void showMenuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showMenuMousePressed
        toggleMenu();
    }//GEN-LAST:event_showMenuMousePressed

    private void botonMenuVerPerfumeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMenuVerPerfumeActionPerformed
        SelectorMenu(new Preva(), 2);
    }//GEN-LAST:event_botonMenuVerPerfumeActionPerformed

    private void showMenuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showMenuMouseEntered
        showMenu.setIcon(setSVG(menu.isVisible() ? "resource/chevron-left-solid-selected.svg" : "resource/chevron-right-solid-selected.svg"));
    }//GEN-LAST:event_showMenuMouseEntered

    private void showMenuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showMenuMouseExited
        showMenu.setIcon(setSVG(menu.isVisible() ? "resource/chevron-left-solid.svg" : "resource/chevron-right-solid.svg"));
    }//GEN-LAST:event_showMenuMouseExited

    private void botonMenuVerCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMenuVerCategoriasActionPerformed
        try {
            SelectorMenu(new VerCategoria(), 3);
        } catch (Exception ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_botonMenuVerCategoriasActionPerformed

    private void botonMenuFeatureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMenuFeatureActionPerformed
        try {
            SelectorMenu(new VerFeature(), 4);
        } catch (Exception ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_botonMenuFeatureActionPerformed

    private void botonMenuBannerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMenuBannerActionPerformed
        try {
            SelectorMenu(new EdictBanner(), 5);
        } catch (Exception ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_botonMenuBannerActionPerformed

    private void botonMenuConfiguracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMenuConfiguracionActionPerformed
        SelectorMenu(new Configuracion(), 10);
    }//GEN-LAST:event_botonMenuConfiguracionActionPerformed

    private void DBComprobarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DBComprobarMousePressed
        Toolkit.getDefaultToolkit().beep();
        Conexion();
    }//GEN-LAST:event_DBComprobarMousePressed

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
    private com.mywebmanager.swings.JComponents.Label.LabelText DBComprobar;
    private com.mywebmanager.swings.JComponents.Label.LabelText DBConection;
    private com.mywebmanager.swings.JComponents.BotonMenu botonMenuBanner;
    private com.mywebmanager.swings.JComponents.BotonMenu botonMenuConfiguracion;
    private com.mywebmanager.swings.JComponents.BotonMenu botonMenuFeature;
    private com.mywebmanager.swings.JComponents.BotonMenu botonMenuVerCategorias;
    private com.mywebmanager.swings.JComponents.BotonMenu botonMenuVerPerfume;
    public static javax.swing.JPanel content;
    private static javax.swing.JPanel header;
    private javax.swing.JSeparator jSeparator1;
    private com.mywebmanager.swings.JComponents.Label.LabelLogo labelLogo1;
    private com.mywebmanager.swings.JComponents.PanelDegradado menu;
    public com.mywebmanager.swings.JComponents.PanelDegradadoBack panelDegradadoBack1;
    private com.mywebmanager.swings.JComponents.ScrollPanelTransparente scrollPanelTransparente1;
    private javax.swing.JLabel showMenu;
    // End of variables declaration//GEN-END:variables
}
