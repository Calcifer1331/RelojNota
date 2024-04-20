package com.mywebmanager.views;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.mywebmanager.ilib.Dashboard;
import com.mywebmanager.implement.DAOGalleryImpl;
import com.mywebmanager.interfaces.DAOGallery;
import com.mywebmanager.models.Category_Perfume;
import com.mywebmanager.models.Gallery;
import java.awt.Toolkit;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class EdictBanner extends javax.swing.JPanel {

    boolean isEdition = false;
    private FlatSVGIcon svgIcon;
    Gallery gallery = null;
    DAOGallery dao = new DAOGalleryImpl();

    ;

    public EdictBanner() {
        initComponents();
        LoadUsers();
    }

    private FlatSVGIcon setSVG(String img) {
        svgIcon = new FlatSVGIcon(img, 25, 25);
        return svgIcon;
    }

    private void LoadUsers() {
        try {
            btnGuardar.setIcon(setSVG("resource/Save.svg"));
            btnCargar.setIcon(setSVG("resource/Picture.svg"));
            gallery = dao.getGallery();
            textAreaImagenURL.setText(gallery.getImage());
            imageView1.loadBackgroundImage(gallery.getImage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelDegradadocontent = new com.mywebmanager.swings.JComponents.PanelDegradado();
        imageView1 = new com.mywebmanager.swings.ImageView();
        panelDegradadoFooter = new com.mywebmanager.swings.JComponents.PanelDegradado();
        btnGuardar = new com.mywebmanager.swings.JComponents.BotonColor();
        btnCargar = new com.mywebmanager.swings.JComponents.BotonColor();
        labelTitle6 = new com.mywebmanager.swings.JComponents.Label.LabelTitle();
        scrollPanel1 = new com.mywebmanager.swings.JComponents.ScrollPanel();
        textAreaImagenURL = new com.mywebmanager.swings.JComponents.TextAreaTransparente();

        setOpaque(false);

        jPanel1.setOpaque(false);

        javax.swing.GroupLayout imageView1Layout = new javax.swing.GroupLayout(imageView1);
        imageView1.setLayout(imageView1Layout);
        imageView1Layout.setHorizontalGroup(
            imageView1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        imageView1Layout.setVerticalGroup(
            imageView1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 421, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelDegradadocontentLayout = new javax.swing.GroupLayout(panelDegradadocontent);
        panelDegradadocontent.setLayout(panelDegradadocontentLayout);
        panelDegradadocontentLayout.setHorizontalGroup(
            panelDegradadocontentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDegradadocontentLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imageView1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelDegradadocontentLayout.setVerticalGroup(
            panelDegradadocontentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDegradadocontentLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imageView1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCargar.setText("Cargar Imagen");
        btnCargar.setBorderPainted(true);
        btnCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarActionPerformed(evt);
            }
        });

        labelTitle6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelTitle6.setText("URL de la Imagen");

        textAreaImagenURL.setColumns(20);
        textAreaImagenURL.setRows(5);
        textAreaImagenURL.setText("");
        scrollPanel1.setViewportView(textAreaImagenURL);

        javax.swing.GroupLayout panelDegradadoFooterLayout = new javax.swing.GroupLayout(panelDegradadoFooter);
        panelDegradadoFooter.setLayout(panelDegradadoFooterLayout);
        panelDegradadoFooterLayout.setHorizontalGroup(
            panelDegradadoFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDegradadoFooterLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(labelTitle6, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
                .addGap(50, 50, 50)
                .addComponent(btnCargar, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
        panelDegradadoFooterLayout.setVerticalGroup(
            panelDegradadoFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDegradadoFooterLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(panelDegradadoFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDegradadoFooterLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(labelTitle6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelDegradadoFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCargar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDegradadoFooterLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelDegradadocontent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelDegradadoFooter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelDegradadocontent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelDegradadoFooter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 874, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(0, 0, 0)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 515, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(0, 0, 0)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        gallery = new Gallery(1, textAreaImagenURL.getText());
        try {
            URL url = new URL(gallery.getImage());
        } catch (IOException ex) {
            Toolkit.getDefaultToolkit().beep();
            javax.swing.JOptionPane.showMessageDialog(Dashboard.content, "No contiene una URL valida \n", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            dao.modify(gallery);
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(Dashboard.content, "Listo", "Aviso", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception ex) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(Dashboard.content, "Ocurrió un error al Modificar el Banner \n", "Error", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(EdictBanner.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarActionPerformed
        imageView1.loadBackgroundImage(textAreaImagenURL.getText());
    }//GEN-LAST:event_btnCargarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.mywebmanager.swings.JComponents.BotonColor btnCargar;
    private com.mywebmanager.swings.JComponents.BotonColor btnGuardar;
    private com.mywebmanager.swings.ImageView imageView1;
    private javax.swing.JPanel jPanel1;
    private com.mywebmanager.swings.JComponents.Label.LabelTitle labelTitle6;
    private com.mywebmanager.swings.JComponents.PanelDegradado panelDegradadoFooter;
    private com.mywebmanager.swings.JComponents.PanelDegradado panelDegradadocontent;
    private com.mywebmanager.swings.JComponents.ScrollPanel scrollPanel1;
    private com.mywebmanager.swings.JComponents.TextAreaTransparente textAreaImagenURL;
    // End of variables declaration//GEN-END:variables
}
