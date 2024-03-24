package com.mytools.views;

import com.mytools.ilib.Dashboard;
import com.mytools.utils.Alarma;

public class ConfigAlarma extends javax.swing.JPanel {

    private Alarma alarma;

    public ConfigAlarma(Alarma alarma) {
        this.alarma = alarma;
        initComponents();
        init();
    }

    private void init() {
        spinnerHoras.setValue(alarma.getHoraInicio());
        spinnerMinutos.setValue(alarma.getMinutoInicio());
        spinnerSegundos.setValue(alarma.getSegundoInicio());

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        panelDegradado3 = new com.mytools.swings.JComponents.PanelDegradado();
        labelHeaderGuardar = new com.mytools.swings.JComponents.Label.LabelHeader();
        btnGuardarAlarma = new com.mytools.swings.JComponents.BotonColor();

        setOpaque(false);

        labelHeaderAlarmaNormal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelHeaderAlarmaNormal.setText("      Alarma Normal");

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
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(panelDegradado1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(spinnerHoras, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                    .addComponent(labelHora, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(panelDegradado1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelMinutos, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spinnerMinutos, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(panelDegradado1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelSegundos, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spinnerSegundos, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
            .addGroup(panelDegradado1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(labelHeaderAlarmaNormal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        labelHeaderGuardar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelHeaderGuardar.setText("  Guardar");

        btnGuardarAlarma.setText("Guardar");
        btnGuardarAlarma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarAlarmaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelDegradado3Layout = new javax.swing.GroupLayout(panelDegradado3);
        panelDegradado3.setLayout(panelDegradado3Layout);
        panelDegradado3Layout.setHorizontalGroup(
            panelDegradado3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDegradado3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDegradado3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelHeaderGuardar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDegradado3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnGuardarAlarma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelDegradado3Layout.setVerticalGroup(
            panelDegradado3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDegradado3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelHeaderGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnGuardarAlarma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelDegradado1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelDegradado3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(panelDegradado3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelDegradado1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(388, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarAlarmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarAlarmaActionPerformed
        alarma.inicir((int) spinnerHoras.getValue(), (int) spinnerMinutos.getValue(), (int) spinnerSegundos.getValue());
        Dashboard.alarma = alarma;
    }//GEN-LAST:event_btnGuardarAlarmaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.mytools.swings.JComponents.BotonColor btnGuardarAlarma;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private com.mytools.swings.JComponents.Label.LabelHeader labelHeaderAlarmaNormal;
    private com.mytools.swings.JComponents.Label.LabelHeader labelHeaderGuardar;
    private com.mytools.swings.JComponents.Label.LabelTitle labelHora;
    private com.mytools.swings.JComponents.Label.LabelTitle labelMinutos;
    private com.mytools.swings.JComponents.Label.LabelTitle labelSegundos;
    private com.mytools.swings.JComponents.PanelDegradado panelDegradado1;
    private com.mytools.swings.JComponents.PanelDegradado panelDegradado3;
    private com.mytools.swings.JComponents.Spinner spinnerHoras;
    private com.mytools.swings.JComponents.Spinner spinnerMinutos;
    private com.mytools.swings.JComponents.Spinner spinnerSegundos;
    // End of variables declaration//GEN-END:variables

}
