
package com.mytools.swings;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import javax.swing.Icon;

public class TextFildIcono extends javax.swing.JPanel {


    public void setPlaceholderText(String placeholderText) {
        campo.setPlaceholderText(placeholderText);
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getImagen2() {
        return imagen2;
    }

    public void setImagen2(String imagen2) {
        this.imagen2 = imagen2;
    }
    
    public String getText(){
        return campo.getText();
    }
    
    public void setText(String text){
        campo.setText(text);
    } 

    private FlatSVGIcon svgIcon;
    private String placeholderText;
    private int tamanoImageSvg;
    private String imagen;
    private String imagen2;

    public TextFildIcono() {
        initComponents();
        init();
        LabelIcono.setIcon(setSVG(getImagen2()));
    }

    private void init() {
        setImagen2("resource/Search_apagado.svg");
        setImagen("resource/Search.svg");
    }

    private FlatSVGIcon setSVG(String img) {
        svgIcon = new FlatSVGIcon(img, 20, 20);
        return svgIcon;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtFieldPanel1 = new com.mytools.swings.JComponents.TxtFieldPanel();
        LabelIcono = new javax.swing.JLabel();
        campo = new com.mytools.swings.JComponents.TxtFieldTransparente();

        setOpaque(false);

        txtFieldPanel1.setBorderRedondeado(40);

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

        javax.swing.GroupLayout txtFieldPanel1Layout = new javax.swing.GroupLayout(txtFieldPanel1);
        txtFieldPanel1.setLayout(txtFieldPanel1Layout);
        txtFieldPanel1Layout.setHorizontalGroup(
            txtFieldPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, txtFieldPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(LabelIcono, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(campo, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                .addGap(17, 17, 17))
        );
        txtFieldPanel1Layout.setVerticalGroup(
            txtFieldPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(txtFieldPanel1Layout.createSequentialGroup()
                .addComponent(LabelIcono, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(campo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtFieldPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtFieldPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void campoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoFocusGained
        LabelIcono.setIcon(setSVG(getImagen()));
    }//GEN-LAST:event_campoFocusGained

    private void campoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoFocusLost
        LabelIcono.setIcon(setSVG(getImagen2()));
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
    private com.mytools.swings.JComponents.TxtFieldPanel txtFieldPanel1;
    // End of variables declaration//GEN-END:variables
}
