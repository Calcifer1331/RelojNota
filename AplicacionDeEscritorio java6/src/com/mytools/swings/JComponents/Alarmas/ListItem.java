package com.mytools.swings.JComponents.Alarmas;
public class ListItem extends javax.swing.JPanel {

    public Alarma_Timbre getAlarma() {
        return alarma;
    }

    public void setAlarma(Alarma_Timbre alarma) {
        this.alarma = alarma;
    }

    private Alarma_Timbre alarma;
    
    public ListItem() {
        initComponents();
        panel.getLabel().setIconTextGap(7);
        
        
        cargarConf();
    }

    public void setItem(Object obj) {
        if (obj instanceof Alarma_Timbre) {
            setAlarma((Alarma_Timbre) obj);

            getPanel().getLabel().setText(getAlarma().getNombre());

        } else {
            getPanel().getLabel().setText(obj + "");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new com.mytools.swings.PanelDegradadoLabelTitle();

        setOpaque(false);

        panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 6, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void panelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelMouseClicked
          }//GEN-LAST:event_panelMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.mytools.swings.PanelDegradadoLabelTitle panel;
    // End of variables declaration//GEN-END:variables

    public com.mytools.swings.PanelDegradadoLabelTitle getPanel() {
        return panel;
    }

    public void setPanel(com.mytools.swings.PanelDegradadoLabelTitle panel) {
        this.panel = panel;
    }

    private void cargarConf() {

    }
}
