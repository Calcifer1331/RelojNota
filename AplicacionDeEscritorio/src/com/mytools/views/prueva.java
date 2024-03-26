package com.mytools.views;

import com.mytools.swings.JComponents.jlist.Item;
import javax.swing.ImageIcon;

public class prueva extends javax.swing.JPanel {

    public prueva() {
        initComponents();
        myList1.addItem(new Item("text 1", "resource/IconMenu/Settings.svg"));
        myList1.addItem(new Item("text 2", "resource/IconMenu/Settings.svg"));
        myList1.addItem(new Item("text 3", "resource/IconMenu/Settings.svg"));
        myList1.addItem(new Item("text 4", "resource/IconMenu/Settings.svg"));
        Item[] a = {new Item("text 5", "resource/IconMenu/Settings.svg"), new Item("text 6", "resource/IconMenu/Settings.svg")};
        myList1.addItem(a);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelDegradado1 = new com.mytools.swings.JComponents.PanelDegradado();
        scrollPanelTransparente1 = new com.mytools.swings.JComponents.ScrollPanelTransparente();
        myList1 = new com.mytools.swings.JComponents.jlist.MyList<>();
        labelTitle1 = new com.mytools.swings.JComponents.Label.LabelTitle();
        botonMenu1 = new com.mytools.swings.JComponents.BotonMenu();
        botonMenu2 = new com.mytools.swings.JComponents.BotonMenu();
        panelDegradadoLabelTitle1 = new com.mytools.swings.PanelDegradadoLabelTitle();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 255, 204));
        setOpaque(false);

        myList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        myList1.setOpaque(false);
        scrollPanelTransparente1.setViewportView(myList1);

        labelTitle1.setText("Lista de Notas");

        botonMenu1.setText("+");

        botonMenu2.setText("-");

        javax.swing.GroupLayout panelDegradado1Layout = new javax.swing.GroupLayout(panelDegradado1);
        panelDegradado1.setLayout(panelDegradado1Layout);
        panelDegradado1Layout.setHorizontalGroup(
            panelDegradado1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDegradado1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDegradado1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollPanelTransparente1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                    .addComponent(labelTitle1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelDegradado1Layout.createSequentialGroup()
                        .addComponent(botonMenu1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonMenu2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelDegradado1Layout.setVerticalGroup(
            panelDegradado1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDegradado1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTitle1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPanelTransparente1, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDegradado1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonMenu1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonMenu2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11))
        );

        panelDegradadoLabelTitle1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelDegradadoLabelTitle1MouseClicked(evt);
            }
        });

        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelDegradado1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 156, Short.MAX_VALUE)
                        .addComponent(panelDegradadoLabelTitle1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(148, 148, 148))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelDegradado1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(panelDegradadoLabelTitle1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void panelDegradadoLabelTitle1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelDegradadoLabelTitle1MouseClicked
        // TODO add your handling code here:
        //System.out.println(myList1.getSelectedValue().toString());
//        Item i =
        int a = myList1.getSelectedIndex();
        Item i =(Item) myList1.getModel().get(a);
        myList1.getModel().remove(a);
        System.out.println(i.getText() + "  " + i.getIcon());
    }//GEN-LAST:event_panelDegradadoLabelTitle1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.mytools.swings.JComponents.BotonMenu botonMenu1;
    private com.mytools.swings.JComponents.BotonMenu botonMenu2;
    private javax.swing.JLabel jLabel1;
    private com.mytools.swings.JComponents.Label.LabelTitle labelTitle1;
    private com.mytools.swings.JComponents.jlist.MyList<String> myList1;
    private com.mytools.swings.JComponents.PanelDegradado panelDegradado1;
    private com.mytools.swings.PanelDegradadoLabelTitle panelDegradadoLabelTitle1;
    private com.mytools.swings.JComponents.ScrollPanelTransparente scrollPanelTransparente1;
    // End of variables declaration//GEN-END:variables
}
