package com.mywebmanager.views;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.mysql.cj.exceptions.DataConversionException;
import com.mywebmanager.ilib.Dashboard;
import com.mywebmanager.implement.DAOFeaturesImpl;
import com.mywebmanager.interfaces.DAOFeatures;
import com.mywebmanager.models.Features;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

public class UpFeature extends javax.swing.JPanel {

    Features features;
    DAOFeatures dao = new DAOFeaturesImpl();
    private FlatSVGIcon svgIcon;

    public UpFeature(Features ejem) {
        initComponents();
        features = ejem;
        InitStyles();
    }

    private FlatSVGIcon setSVG(String img) {
        svgIcon = new FlatSVGIcon(img, 25, 25);
        return svgIcon;
    }

    private void InitStyles() {
        btnRegresar.setIcon(setSVG("resource/Return.svg"));
        btnRegistrar.setIcon(setSVG("resource/Save.svg"));
        if (features != null) {
            textAreaTitulo.setText(features.getTitle());
            textAreaParagrand.setText(features.getParagraph());
            textFildIcono.setText(features.getIcon());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelDegradado4 = new com.mywebmanager.swings.JComponents.PanelDegradado();
        labelTitle5 = new com.mywebmanager.swings.JComponents.Label.LabelTitle();
        scrollPanel3 = new com.mywebmanager.swings.JComponents.ScrollPanel();
        textAreaTitulo = new com.mywebmanager.swings.JComponents.TextAreaTransparente();
        labelTitle6 = new com.mywebmanager.swings.JComponents.Label.LabelTitle();
        scrollPanel1 = new com.mywebmanager.swings.JComponents.ScrollPanel();
        textAreaParagrand = new com.mywebmanager.swings.JComponents.TextAreaTransparente();
        textFildIcono = new com.mywebmanager.swings.TextFild();
        labelTitle1 = new com.mywebmanager.swings.JComponents.Label.LabelTitle();
        jSeparator1 = new javax.swing.JSeparator();
        panelDegradadoFooter = new com.mywebmanager.swings.JComponents.PanelDegradado();
        btnRegistrar = new com.mywebmanager.swings.JComponents.BotonColor();
        btnRegresar = new com.mywebmanager.swings.JComponents.BotonColor();

        setOpaque(false);

        jPanel1.setOpaque(false);

        labelTitle5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelTitle5.setText("Titulo de la Caracteristica");

        textAreaTitulo.setColumns(20);
        textAreaTitulo.setRows(5);
        textAreaTitulo.setText("");
        scrollPanel3.setViewportView(textAreaTitulo);

        labelTitle6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelTitle6.setText("Descripcion de la caracteristica");

        textAreaParagrand.setColumns(20);
        textAreaParagrand.setRows(5);
        textAreaParagrand.setText("");
        scrollPanel1.setViewportView(textAreaParagrand);

        labelTitle1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelTitle1.setText("Icono");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout panelDegradado4Layout = new javax.swing.GroupLayout(panelDegradado4);
        panelDegradado4.setLayout(panelDegradado4Layout);
        panelDegradado4Layout.setHorizontalGroup(
            panelDegradado4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDegradado4Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(panelDegradado4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelTitle6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelDegradado4Layout.createSequentialGroup()
                        .addGroup(panelDegradado4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(labelTitle5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(scrollPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
                            .addComponent(scrollPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDegradado4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textFildIcono, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelTitle1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelDegradado4Layout.setVerticalGroup(
            panelDegradado4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDegradado4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(panelDegradado4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDegradado4Layout.createSequentialGroup()
                        .addComponent(labelTitle1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textFildIcono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelDegradado4Layout.createSequentialGroup()
                        .addComponent(labelTitle5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scrollPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(labelTitle6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scrollPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                        .addGap(88, 88, 88))
                    .addGroup(panelDegradado4Layout.createSequentialGroup()
                        .addComponent(jSeparator1)
                        .addGap(59, 59, 59))))
        );

        btnRegistrar.setText("Guardar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnRegresar.setText("Regresar");
        btnRegresar.setBorderPainted(true);
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelDegradadoFooterLayout = new javax.swing.GroupLayout(panelDegradadoFooter);
        panelDegradadoFooter.setLayout(panelDegradadoFooterLayout);
        panelDegradadoFooterLayout.setHorizontalGroup(
            panelDegradadoFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDegradadoFooterLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
        panelDegradadoFooterLayout.setVerticalGroup(
            panelDegradadoFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDegradadoFooterLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(panelDegradadoFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegresar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelDegradadoFooter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelDegradado4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelDegradado4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelDegradadoFooter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 701, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(0, 0, 0)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 514, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(0, 0, 0)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed

        String tit = textAreaTitulo.getText();
        String par = textAreaParagrand.getText();
        String icon = textFildIcono.getText();

        //validacion de campos
        if (par.isEmpty() || tit.isEmpty() || icon.isEmpty()) {
            Toolkit.getDefaultToolkit().beep();
            javax.swing.JOptionPane.showMessageDialog(Dashboard.content, "Debe llenar todos los campos (*) \n", "AVISO", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            textAreaTitulo.requestFocus();
            return;
        }

        features.setTitle(tit);
        features.setParagraph(par);
        features.setIcon(icon);

        try {

            dao.modify(features);

            Toolkit.getDefaultToolkit().beep();
            javax.swing.JOptionPane.showMessageDialog(Dashboard.content, "Categoria modificado exitosamente \n", "AVISO", javax.swing.JOptionPane.INFORMATION_MESSAGE);

        } catch (DataConversionException e) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(Dashboard.content, "No se pudo realizar la accion.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(Dashboard.content, "Ocurrió un error al modificar la Categoria \n", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        Dashboard.ShoJPanel(new VerFeature());
    }//GEN-LAST:event_btnRegresarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.mywebmanager.swings.JComponents.BotonColor btnRegistrar;
    private com.mywebmanager.swings.JComponents.BotonColor btnRegresar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private com.mywebmanager.swings.JComponents.Label.LabelTitle labelTitle1;
    private com.mywebmanager.swings.JComponents.Label.LabelTitle labelTitle5;
    private com.mywebmanager.swings.JComponents.Label.LabelTitle labelTitle6;
    private com.mywebmanager.swings.JComponents.PanelDegradado panelDegradado4;
    private com.mywebmanager.swings.JComponents.PanelDegradado panelDegradadoFooter;
    private com.mywebmanager.swings.JComponents.ScrollPanel scrollPanel1;
    private com.mywebmanager.swings.JComponents.ScrollPanel scrollPanel3;
    private com.mywebmanager.swings.JComponents.TextAreaTransparente textAreaParagrand;
    private com.mywebmanager.swings.JComponents.TextAreaTransparente textAreaTitulo;
    private com.mywebmanager.swings.TextFild textFildIcono;
    // End of variables declaration//GEN-END:variables
}
