package com.mytools.swings.JComponents.jlist;

import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import static java.awt.image.ImageObserver.HEIGHT;
import static java.awt.image.ImageObserver.WIDTH;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;

public class ListItem extends javax.swing.JPanel {

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    private Item item;

    public ListItem() {
        initComponents();
        panel.getLabel().setIconTextGap(7);
        
        
        cargarConf();
    }

    public void setItem(Object obj) {
        if (obj instanceof Item) {
            setItem((Item) obj);

            getPanel().getLabel().setText(getItem().getText());
            getPanel().getLabel().setSvgImage(getItem().getIcon());

            //getLb().setText(getItem().getText());
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
