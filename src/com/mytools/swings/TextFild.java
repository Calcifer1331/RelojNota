
package com.mytools.swings;

public class TextFild extends javax.swing.JPanel {

    public void setPlaceholderText(String placeholderText) {
        campo.setPlaceholderText(placeholderText);
    }

    public String getText(){
        return campo.getText();
    }
    
    public void setText(String text){
        campo.setText(text);
    } 

    private String placeholderText;
    private int tamanoImageSvg;

    public TextFild() {
        initComponents();
        init();
    }

    private void init() {
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtFieldPanel1 = new com.mytools.swings.JComponents.TxtFieldPanel();
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

        javax.swing.GroupLayout txtFieldPanel1Layout = new javax.swing.GroupLayout(txtFieldPanel1);
        txtFieldPanel1.setLayout(txtFieldPanel1Layout);
        txtFieldPanel1Layout.setHorizontalGroup(
            txtFieldPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, txtFieldPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(campo, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                .addGap(17, 17, 17))
        );
        txtFieldPanel1Layout.setVerticalGroup(
            txtFieldPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(campo, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtFieldPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtFieldPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void campoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoFocusGained
        
    }//GEN-LAST:event_campoFocusGained

    private void campoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoFocusLost
        
    }//GEN-LAST:event_campoFocusLost

    private void campoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.mytools.swings.JComponents.TxtFieldTransparente campo;
    private com.mytools.swings.JComponents.TxtFieldPanel txtFieldPanel1;
    // End of variables declaration//GEN-END:variables
}
