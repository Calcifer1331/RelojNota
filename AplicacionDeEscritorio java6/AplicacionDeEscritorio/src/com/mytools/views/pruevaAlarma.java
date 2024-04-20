package com.mytools.views;

import com.mytools.swings.JComponents.Alarmas.Alarma_Timbre;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class pruevaAlarma extends javax.swing.JPanel {

    private List<Alarma_Timbre> alarmas;
    private Alarma_Timbre alarma;

    public pruevaAlarma() {
        initComponents();
        init();
    }

    public pruevaAlarma(List<Alarma_Timbre> alarmas) {
        initComponents();
        //this.alarmas = ArrayList<> (alarmas);
        init();
    }

    private void init() {
        //myList1.addItem(getAlarmas().get(1));
        myList1.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
//                alarma = (Alarma_Timbre) myList1.getModel().get(myList1.getSelectedIndex());
//                System.out.println(alarma.getNombre()+"   "+ myList1.getSelectedValue());
//                nombre.setText(alarma.getNombre());

                System.out.println(myList1.getSelectedIndex());
                System.out.println(myList1.getModel().get(9));

            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollPanelTransparente1 = new com.mytools.swings.JComponents.ScrollPanelTransparente();
        myList1 = new com.mytools.swings.JComponents.Alarmas.MyList<>();
        panelDegradado1 = new com.mytools.swings.JComponents.PanelDegradado();
        labelHeaderAlarmaNormal = new com.mytools.swings.JComponents.Label.LabelHeader();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        spinnerHoras = new com.mytools.swings.JComponents.Spinner();
        spinnerMinutos = new com.mytools.swings.JComponents.Spinner();
        spinnerSegundos = new com.mytools.swings.JComponents.Spinner();
        jSeparator4 = new javax.swing.JSeparator();
        labelHora = new com.mytools.swings.JComponents.Label.LabelTitle();
        labelMinutos = new com.mytools.swings.JComponents.Label.LabelTitle();
        labelSegundos = new com.mytools.swings.JComponents.Label.LabelTitle();
        panelDegradado4 = new com.mytools.swings.JComponents.PanelDegradado();
        labelHeaderTimbre = new com.mytools.swings.JComponents.Label.LabelHeader();
        jSeparator9 = new javax.swing.JSeparator();
        jSeparator10 = new javax.swing.JSeparator();
        jSeparator11 = new javax.swing.JSeparator();
        spinnerHorasTimbre = new com.mytools.swings.JComponents.Spinner();
        spinnerMinutosTimbre = new com.mytools.swings.JComponents.Spinner();
        spinnerSegundosTimbre = new com.mytools.swings.JComponents.Spinner();
        jSeparator12 = new javax.swing.JSeparator();
        labelHora2 = new com.mytools.swings.JComponents.Label.LabelTitle();
        labelMinutos2 = new com.mytools.swings.JComponents.Label.LabelTitle();
        labelSegundos2 = new com.mytools.swings.JComponents.Label.LabelTitle();
        btnGuardarAlarma = new com.mytools.swings.JComponents.BotonColor();
        btnDetenerAlarma = new com.mytools.swings.JComponents.BotonColor();
        nombre = new com.mytools.swings.TextFild();

        setOpaque(false);

        myList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        myList1.setOpaque(false);
        scrollPanelTransparente1.setViewportView(myList1);

        labelHeaderAlarmaNormal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelHeaderAlarmaNormal.setText("      Alarma");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

        spinnerHoras.setModel(new javax.swing.SpinnerNumberModel(2, 0, 24, 1));
        spinnerHoras.setFont(new java.awt.Font("Cascadia Mono", 0, 24)); // NOI18N

        spinnerMinutos.setModel(new javax.swing.SpinnerNumberModel(0, 0, 60, 1));
        spinnerMinutos.setFont(new java.awt.Font("Cascadia Mono", 0, 24)); // NOI18N

        spinnerSegundos.setModel(new javax.swing.SpinnerNumberModel(0, 0, 60, 1));
        spinnerSegundos.setFont(new java.awt.Font("Cascadia Mono", 0, 24)); // NOI18N

        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);

        labelHora.setText("Horas");
        labelHora.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N

        labelMinutos.setText("Minutos");
        labelMinutos.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N

        labelSegundos.setText("Segundos");
        labelSegundos.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N

        javax.swing.GroupLayout panelDegradado1Layout = new javax.swing.GroupLayout(panelDegradado1);
        panelDegradado1.setLayout(panelDegradado1Layout);
        panelDegradado1Layout.setHorizontalGroup(
            panelDegradado1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDegradado1Layout.createSequentialGroup()
                .addGroup(panelDegradado1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDegradado1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelDegradado1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(spinnerHoras, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                            .addComponent(labelHora, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelDegradado1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelMinutos, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spinnerMinutos, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelDegradado1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelSegundos, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spinnerSegundos, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelDegradado1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(labelHeaderAlarmaNormal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelDegradado1Layout.setVerticalGroup(
            panelDegradado1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDegradado1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelHeaderAlarmaNormal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDegradado1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(panelDegradado1Layout.createSequentialGroup()
                        .addGroup(panelDegradado1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelHora, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelMinutos, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                            .addComponent(labelSegundos, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelDegradado1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(spinnerSegundos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spinnerMinutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spinnerHoras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30))
                    .addComponent(jSeparator1)
                    .addComponent(jSeparator2)
                    .addComponent(jSeparator3)
                    .addComponent(jSeparator4))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        labelHeaderTimbre.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelHeaderTimbre.setText("  Timbre");

        jSeparator9.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator10.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator11.setOrientation(javax.swing.SwingConstants.VERTICAL);

        spinnerHorasTimbre.setModel(new javax.swing.SpinnerNumberModel(0, 0, 24, 1));
        spinnerHorasTimbre.setFont(new java.awt.Font("Cascadia Mono", 0, 24)); // NOI18N

        spinnerMinutosTimbre.setModel(new javax.swing.SpinnerNumberModel(2, 0, 60, 1));
        spinnerMinutosTimbre.setFont(new java.awt.Font("Cascadia Mono", 0, 24)); // NOI18N

        spinnerSegundosTimbre.setModel(new javax.swing.SpinnerNumberModel(0, 0, 60, 1));
        spinnerSegundosTimbre.setFont(new java.awt.Font("Cascadia Mono", 0, 24)); // NOI18N

        jSeparator12.setOrientation(javax.swing.SwingConstants.VERTICAL);

        labelHora2.setText("Horas");
        labelHora2.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N

        labelMinutos2.setText("Minutos");
        labelMinutos2.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N

        labelSegundos2.setText("Segundos");
        labelSegundos2.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N

        javax.swing.GroupLayout panelDegradado4Layout = new javax.swing.GroupLayout(panelDegradado4);
        panelDegradado4.setLayout(panelDegradado4Layout);
        panelDegradado4Layout.setHorizontalGroup(
            panelDegradado4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDegradado4Layout.createSequentialGroup()
                .addGroup(panelDegradado4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDegradado4Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator12, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelDegradado4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(spinnerHorasTimbre, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                            .addComponent(labelHora2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelDegradado4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelMinutos2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spinnerMinutosTimbre, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelDegradado4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelSegundos2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spinnerSegundosTimbre, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelDegradado4Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(labelHeaderTimbre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelDegradado4Layout.setVerticalGroup(
            panelDegradado4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDegradado4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelHeaderTimbre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDegradado4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(panelDegradado4Layout.createSequentialGroup()
                        .addGroup(panelDegradado4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelHora2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelMinutos2, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                            .addComponent(labelSegundos2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelDegradado4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(spinnerSegundosTimbre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spinnerMinutosTimbre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spinnerHorasTimbre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30))
                    .addComponent(jSeparator9)
                    .addComponent(jSeparator10)
                    .addComponent(jSeparator11)
                    .addComponent(jSeparator12))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        btnGuardarAlarma.setText("Guardar");
        btnGuardarAlarma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarAlarmaActionPerformed(evt);
            }
        });

        btnDetenerAlarma.setText("Detener");
        btnDetenerAlarma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetenerAlarmaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(scrollPanelTransparente1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardarAlarma, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDetenerAlarma, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelDegradado1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelDegradado4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelDegradado1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scrollPanelTransparente1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelDegradado4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGuardarAlarma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDetenerAlarma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarAlarmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarAlarmaActionPerformed
        /*alarma.detener();
        alarma.inicir((int) spinnerHoras.getValue(), (int) spinnerMinutos.getValue(), (int) spinnerSegundos.getValue());
        alarma.getTimbre().setHoraInicio((int) spinnerHorasTimbre.getValue());
        alarma.getTimbre().setMinutoInicio((int) spinnerMinutosTimbre.getValue());
        alarma.getTimbre().setSegundoInicio((int) spinnerSegundosTimbre.getValue());
        Dashboard.alarma = alarma;*/
    }//GEN-LAST:event_btnGuardarAlarmaActionPerformed

    private void btnDetenerAlarmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetenerAlarmaActionPerformed
        //alarma.detener();
    }//GEN-LAST:event_btnDetenerAlarmaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.mytools.swings.JComponents.BotonColor btnDetenerAlarma;
    private com.mytools.swings.JComponents.BotonColor btnGuardarAlarma;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator9;
    private com.mytools.swings.JComponents.Label.LabelHeader labelHeaderAlarmaNormal;
    private com.mytools.swings.JComponents.Label.LabelHeader labelHeaderTimbre;
    private com.mytools.swings.JComponents.Label.LabelTitle labelHora;
    private com.mytools.swings.JComponents.Label.LabelTitle labelHora2;
    private com.mytools.swings.JComponents.Label.LabelTitle labelMinutos;
    private com.mytools.swings.JComponents.Label.LabelTitle labelMinutos2;
    private com.mytools.swings.JComponents.Label.LabelTitle labelSegundos;
    private com.mytools.swings.JComponents.Label.LabelTitle labelSegundos2;
    private com.mytools.swings.JComponents.Alarmas.MyList<String> myList1;
    private com.mytools.swings.TextFild nombre;
    private com.mytools.swings.JComponents.PanelDegradado panelDegradado1;
    private com.mytools.swings.JComponents.PanelDegradado panelDegradado4;
    private com.mytools.swings.JComponents.ScrollPanelTransparente scrollPanelTransparente1;
    private com.mytools.swings.JComponents.Spinner spinnerHoras;
    private com.mytools.swings.JComponents.Spinner spinnerHorasTimbre;
    private com.mytools.swings.JComponents.Spinner spinnerMinutos;
    private com.mytools.swings.JComponents.Spinner spinnerMinutosTimbre;
    private com.mytools.swings.JComponents.Spinner spinnerSegundos;
    private com.mytools.swings.JComponents.Spinner spinnerSegundosTimbre;
    // End of variables declaration//GEN-END:variables

}
