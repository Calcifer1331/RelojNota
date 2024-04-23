package com.mytools.views;

import com.mytools.swings.JComponents.BotonIcono;
import com.mytools.swings.JComponents.tree.Tree;
import java.awt.Color;
import java.awt.Image;
import java.awt.Window;
import java.lang.reflect.Method;
import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class addFileCarpet extends javax.swing.JDialog {
    
    Tree tree;
    
    public addFileCarpet(java.awt.Frame parent, Tree tree, boolean modal) {
        super(parent, modal);
        this.tree = tree;
        initComponents();
        
        setBackground(new Color(0, 0, 0, 0));
        name.setImagen(setImageMin("/resource/File.png"));
        Cerrar.setIcon(setImage("/resource/Close.png"));
        Aceptar.setIcon(setImage("/resource/Like.png"));
        name.getPanelBack().setBorderRedondeado(40);
        
    }
    public ImageIcon setImageMin(String image) {
    URL imageUrl = getClass().getResource(image);
    if (imageUrl != null) {
        ImageIcon icon = new ImageIcon(imageUrl);

        Image scaledImage = icon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);

        return new ImageIcon(scaledImage);
    } else {
        System.err.println("Error: La URL de la imagen es nula para " + image);
        return null;
    }
    }
    public ImageIcon setImage(String image) {
    URL imageUrl = getClass().getResource(image);
    if (imageUrl != null) {
        ImageIcon icon = new ImageIcon(imageUrl);

        Image scaledImage = icon.getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH);

        return new ImageIcon(scaledImage);
    } else {
        System.err.println("Error: La URL de la imagen es nula para " + image);
        return null;
    }
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        panelDegradadoBack1 = new com.mytools.swings.JComponents.PanelDegradadoBack();
        panelDegradado1 = new com.mytools.swings.JComponents.PanelDegradado();
        name = new com.mytools.swings.TextFildIcono();
        fileRBtn = new com.mytools.swings.JComponents.RadioButton();
        carpetaRBtn = new com.mytools.swings.JComponents.RadioButton();
        labelHeader1 = new com.mytools.swings.JComponents.Label.LabelHeader();
        Aceptar = new com.mytools.swings.JComponents.BotonIcono();
        Cerrar = new com.mytools.swings.JComponents.BotonIcono();
        mesaje = new com.mytools.swings.JComponents.Label.LabelDescripcion();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        panelDegradadoBack1.setColorInicial(new java.awt.Color(0, 0, 70));
        panelDegradadoBack1.setColorMedia1(new java.awt.Color(28, 181, 224));
        panelDegradadoBack1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        panelDegradadoBack1.setFraccionMedia1(1.0F);
        panelDegradadoBack1.setNumeroColores(com.mytools.swings.JComponents.PanelDegradadoBack.NumeroColores.NUMERO_COLOR_2);
        panelDegradadoBack1.setPosicionCentral(com.mytools.swings.JComponents.PanelDegradadoBack.PosicionCentral.IZQUIERDA);
        panelDegradadoBack1.setTipoFondo(com.mytools.swings.JComponents.PanelDegradadoBack.TipoFondo.LINEAL);

        panelDegradado1.setOpacidadFinal(80);
        panelDegradado1.setOpacidadInical(80);

        name.setFont(new java.awt.Font("Segoe UI Semibold", 0, 20)); // NOI18N
        name.setPlaceholderText("Nombre del Componente");

        buttonGroup1.add(fileRBtn);
        fileRBtn.setSelected(true);
        fileRBtn.setText("Nota");
        fileRBtn.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        fileRBtn.setName("archivo"); // NOI18N
        fileRBtn.setOpaque(false);
        fileRBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileRBtnActionPerformed(evt);
            }
        });

        buttonGroup1.add(carpetaRBtn);
        carpetaRBtn.setText("Gupo");
        carpetaRBtn.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        carpetaRBtn.setName("carpeta"); // NOI18N
        carpetaRBtn.setOpaque(false);
        carpetaRBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carpetaRBtnActionPerformed(evt);
            }
        });

        labelHeader1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelHeader1.setText("   Agregar");

        Aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AceptarActionPerformed(evt);
            }
        });

        Cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CerrarActionPerformed(evt);
            }
        });

        mesaje.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout panelDegradado1Layout = new javax.swing.GroupLayout(panelDegradado1);
        panelDegradado1.setLayout(panelDegradado1Layout);
        panelDegradado1Layout.setHorizontalGroup(
            panelDegradado1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDegradado1Layout.createSequentialGroup()
                .addComponent(labelHeader1, javax.swing.GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(panelDegradado1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(fileRBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(carpetaRBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                .addGap(271, 271, 271))
            .addGroup(panelDegradado1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(panelDegradado1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDegradado1Layout.createSequentialGroup()
                        .addComponent(mesaje, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                        .addGap(61, 61, 61)
                        .addComponent(Cerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Aceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(209, 209, 209))
        );
        panelDegradado1Layout.setVerticalGroup(
            panelDegradado1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDegradado1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelHeader1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelDegradado1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fileRBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(carpetaRBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(panelDegradado1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(mesaje, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelDegradado1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(Aceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Cerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout panelDegradadoBack1Layout = new javax.swing.GroupLayout(panelDegradadoBack1);
        panelDegradadoBack1.setLayout(panelDegradadoBack1Layout);
        panelDegradadoBack1Layout.setHorizontalGroup(
            panelDegradadoBack1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDegradadoBack1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelDegradado1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelDegradadoBack1Layout.setVerticalGroup(
            panelDegradadoBack1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDegradadoBack1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelDegradado1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
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
    }// </editor-fold>//GEN-END:initComponents

    private void fileRBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileRBtnActionPerformed
        // TODO add your handling code here:
        name.setImagen(setImageMin("/resource/File.png"));
    }//GEN-LAST:event_fileRBtnActionPerformed

    private void carpetaRBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carpetaRBtnActionPerformed
        name.setImagen(setImageMin("/resource/Folder null.png"));
    }//GEN-LAST:event_carpetaRBtnActionPerformed

    private void AceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AceptarActionPerformed
        if(fileRBtn.isSelected()){
            tree.crearArchivoEnCarpetaSeleccionada(name.getText(), mesaje);
            dispose();
        }else if(carpetaRBtn.isSelected()){
            tree.crearCarpetaEnCarpetaSeleccionada(name.getText());
            dispose();
        }
        
    }//GEN-LAST:event_AceptarActionPerformed

    private void CerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CerrarActionPerformed
        // TODO add you
        dispose();
    }//GEN-LAST:event_CerrarActionPerformed
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(addFileCarpet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addFileCarpet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addFileCarpet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addFileCarpet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                addFileCarpet dialog = new addFileCarpet(new javax.swing.JFrame(), new Tree(), true);
                dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.mytools.swings.JComponents.BotonIcono Aceptar;
    private com.mytools.swings.JComponents.BotonIcono Cerrar;
    private javax.swing.ButtonGroup buttonGroup1;
    private com.mytools.swings.JComponents.RadioButton carpetaRBtn;
    private com.mytools.swings.JComponents.RadioButton fileRBtn;
    private com.mytools.swings.JComponents.Label.LabelHeader labelHeader1;
    private com.mytools.swings.JComponents.Label.LabelDescripcion mesaje;
    private com.mytools.swings.TextFildIcono name;
    private com.mytools.swings.JComponents.PanelDegradado panelDegradado1;
    private com.mytools.swings.JComponents.PanelDegradadoBack panelDegradadoBack1;
    // End of variables declaration//GEN-END:variables
}
