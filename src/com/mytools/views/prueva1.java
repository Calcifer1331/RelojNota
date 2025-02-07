package com.mytools.views;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.mytools.ilib.Dashboard;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class prueva1 extends javax.swing.JPanel {

    Dashboard dashboard;

    public prueva1(Dashboard dashboard) {
        this.dashboard = dashboard;
        initComponents();
        tree.setTextArea(textAreaNota);
        tree.setLabelMensaje(mesajeDescripcyion);
        tree.setLabelTitle(TitleNodo);
        Nuevo.setIconSvg("resource/Plus.svg");
        Eliminar.setIconSvg("resource/Delete.svg");
        showMenu.setIcon(new FlatSVGIcon(menuTree.isVisible() ? "resource/chevron-left-solid.svg" : "resource/chevron-right-solid.svg", 13, 20));

        textAreaNota.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                System.out.println("listener insert" + tree.getSelectedFolder());
                saveToFile(tree.getSelectedFolder());

            }

            public void removeUpdate(DocumentEvent e) {
                System.out.println("listener remove" + tree.getSelectedFolder());

                saveToFile(tree.getSelectedFolder());
            }

            public void changedUpdate(DocumentEvent e) {
            }
        });
    }

    private void saveToFile(File file) {
        String text = textAreaNota.getText();
        if (file.exists()) {
            if (file.isFile()) {
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, StandardCharsets.UTF_8))) {
                    writer.write(text);
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("error");
                }
            } else {
                System.out.println("no es file");
            }
        } else {
            System.out.println("no existe");
        }

    }

    private void toggleMenu() {
        // Cambiar la visibilidad del menú
        menuTree.setVisible(!menuTree.isVisible());
        showMenu.setIcon(new FlatSVGIcon(menuTree.isVisible() ? "resource/chevron-left-solid.svg" : "resource/chevron-right-solid.svg", 13, 20));
        revalidate();
        repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuTree = new com.mytools.swings.JComponents.PanelDegradado();
        labelHeader1 = new com.mytools.swings.JComponents.Label.LabelHeader();
        scrollPanelTransparente1 = new com.mytools.swings.JComponents.ScrollPanelTransparente();
        tree = new com.mytools.swings.JComponents.tree.Tree();
        mesajeDescripcyion = new com.mytools.swings.JComponents.Label.LabelDescripcion();
        Eliminar = new com.mytools.swings.JComponents.BotonIcono();
        Nuevo = new com.mytools.swings.JComponents.BotonIcono();
        scrollPanel1 = new com.mytools.swings.JComponents.ScrollPanel();
        textAreaNota = new com.mytools.swings.JComponents.TextAreaTransparente();
        TitleNodo = new com.mytools.swings.JComponents.Label.LabelHeader();
        showMenu = new javax.swing.JLabel();

        setOpaque(false);

        labelHeader1.setText("Notas");

        scrollPanelTransparente1.setViewportView(tree);

        mesajeDescripcyion.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarActionPerformed(evt);
            }
        });

        Nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NuevoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout menuTreeLayout = new javax.swing.GroupLayout(menuTree);
        menuTree.setLayout(menuTreeLayout);
        menuTreeLayout.setHorizontalGroup(
            menuTreeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelHeader1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuTreeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(menuTreeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(scrollPanelTransparente1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(menuTreeLayout.createSequentialGroup()
                        .addComponent(Eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(menuTreeLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(mesajeDescripcyion, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
        );
        menuTreeLayout.setVerticalGroup(
            menuTreeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuTreeLayout.createSequentialGroup()
                .addComponent(labelHeader1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollPanelTransparente1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(15, 15, 15)
                .addGroup(menuTreeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(mesajeDescripcyion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        textAreaNota.setColumns(20);
        textAreaNota.setRows(5);
        scrollPanel1.setViewportView(textAreaNota);

        TitleNodo.setText("Apuntes / Notas");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(menuTree, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(showMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TitleNodo, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(scrollPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(568, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(menuTree, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(TitleNodo, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scrollPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE))
                    .addComponent(showMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
        tree.eliminarArchivoODirectorioSeleccionado();
    }//GEN-LAST:event_EliminarActionPerformed

    private void NuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NuevoActionPerformed
        addFileCarpet fileCarpet = new addFileCarpet(dashboard, tree, true);
        
    }//GEN-LAST:event_NuevoActionPerformed

    private void showMenuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showMenuMouseEntered
        showMenu.setIcon(new FlatSVGIcon(menuTree.isVisible() ? "resource/chevron-left-solid-selected.svg" : "resource/chevron-right-solid-selected.svg", 13, 20));
    }//GEN-LAST:event_showMenuMouseEntered

    private void showMenuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showMenuMouseExited
        showMenu.setIcon(new FlatSVGIcon(menuTree.isVisible() ? "resource/chevron-left-solid.svg" : "resource/chevron-right-solid.svg", 13, 20));
    }//GEN-LAST:event_showMenuMouseExited

    private void showMenuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showMenuMousePressed
        toggleMenu();
    }//GEN-LAST:event_showMenuMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.mytools.swings.JComponents.BotonIcono Eliminar;
    private com.mytools.swings.JComponents.BotonIcono Nuevo;
    private com.mytools.swings.JComponents.Label.LabelHeader TitleNodo;
    private com.mytools.swings.JComponents.Label.LabelHeader labelHeader1;
    private com.mytools.swings.JComponents.PanelDegradado menuTree;
    private com.mytools.swings.JComponents.Label.LabelDescripcion mesajeDescripcyion;
    private com.mytools.swings.JComponents.ScrollPanel scrollPanel1;
    private com.mytools.swings.JComponents.ScrollPanelTransparente scrollPanelTransparente1;
    private javax.swing.JLabel showMenu;
    private com.mytools.swings.JComponents.TextAreaTransparente textAreaNota;
    private com.mytools.swings.JComponents.tree.Tree tree;
    // End of variables declaration//GEN-END:variables
}
