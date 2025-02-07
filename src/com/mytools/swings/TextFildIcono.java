package com.mytools.swings;

import javax.swing.Icon;

public class TextFildIcono extends javax.swing.JPanel {

    public com.mytools.swings.JComponents.TxtFieldPanel getPanelBack() {
        return panelBack;
    }

    public void setPanelBack(com.mytools.swings.JComponents.TxtFieldPanel panelBack) {
        this.panelBack = panelBack;
    }

    public void setPlaceholderText(String placeholderText) {
        campo.setPlaceholderText(placeholderText);
    }

    public String getImagen() {
        return LabelIcono.getIcon().toString();
    }

    public void setImagen(Icon imagen) {
        LabelIcono.setIcon(imagen);

    }

    public String getText() {
        return campo.getText();
    }

    public void setText(String text) {
        campo.setText(text);
    }

    private String placeholderText;
    private int tamanoImageSvg;
    private String imagen2;

    public TextFildIcono() {
        initComponents();
    }

  

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBack = new com.mytools.swings.JComponents.TxtFieldPanel();
        LabelIcono = new javax.swing.JLabel();
        campo = new com.mytools.swings.JComponents.TxtFieldTransparente();

        setOpaque(false);

        panelBack.setBorderRedondeado(40);

        campo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                campoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoFocusLost(evt);
            }
        });
        campo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoActionPerformed(evt);
            }
        });
        campo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout panelBackLayout = new javax.swing.GroupLayout(panelBack);
        panelBack.setLayout(panelBackLayout);
        panelBackLayout.setHorizontalGroup(
            panelBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBackLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(LabelIcono, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(campo, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelBackLayout.setVerticalGroup(
            panelBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LabelIcono, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
            .addComponent(campo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void campoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoFocusGained

    }//GEN-LAST:event_campoFocusGained

    private void campoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoFocusLost

    }//GEN-LAST:event_campoFocusLost

    private void campoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoActionPerformed

    private void campoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelIcono;
    private com.mytools.swings.JComponents.TxtFieldTransparente campo;
    private com.mytools.swings.JComponents.TxtFieldPanel panelBack;
    // End of variables declaration//GEN-END:variables
}
