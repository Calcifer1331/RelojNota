package com.mytools.views;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.mytools.ilib.Dashboard;
import com.mytools.swings.JComponents.tree.Tree;
import com.mytools.utils.Alarma;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JComponent;
import javax.swing.JPanel;

public class ConfigAlarm extends javax.swing.JDialog {

    private Alarma alarma;

    public ConfigAlarm(java.awt.Frame parent, Alarma alarma, boolean modal) {
        super(parent, modal);
        this.alarma = alarma;
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        Cerrar.setIconSvg("resource/Close.svg");
        Guardar.setIconSvg("resource/Like.svg");
        Detener.setIconSvg("resource/stop.svg");
        if (alarma != null) {
            init();
        }
    }

    private void init() {
        spinnerHoras.setValue(alarma.getHoraInicio());
        spinnerMinutos.setValue(alarma.getMinutoInicio());
        spinnerSegundos.setValue(alarma.getSegundoInicio());

        spinnerHorasTimbre1.setValue(alarma.getTimbre().getHoraInicio());
        spinnerMinutosTimbre1.setValue(alarma.getTimbre().getMinutoInicio());
        spinnerSegundosTimbre1.setValue(alarma.getTimbre().getSegundoInicio());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelDegradado1 = new com.mytools.swings.JComponents.PanelDegradado();
        Guardar = new com.mytools.swings.JComponents.BotonIcono();
        Cerrar = new com.mytools.swings.JComponents.BotonIcono();
        panelDegradado2 = new com.mytools.swings.JComponents.PanelDegradado();
        labelHeaderAlarmaNormal = new com.mytools.swings.JComponents.Label.LabelHeader();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        spinnerHoras = new com.mytools.swings.JComponents.Spinner();
        spinnerMinutos = new com.mytools.swings.JComponents.Spinner();
        spinnerSegundos = new com.mytools.swings.JComponents.Spinner();
        labelHora = new com.mytools.swings.JComponents.Label.LabelTitle();
        labelMinutos = new com.mytools.swings.JComponents.Label.LabelTitle();
        labelSegundos = new com.mytools.swings.JComponents.Label.LabelTitle();
        panelDegradado5 = new com.mytools.swings.JComponents.PanelDegradado();
        labelHeaderTimbre1 = new com.mytools.swings.JComponents.Label.LabelHeader();
        jSeparator13 = new javax.swing.JSeparator();
        jSeparator14 = new javax.swing.JSeparator();
        spinnerHorasTimbre1 = new com.mytools.swings.JComponents.Spinner();
        spinnerMinutosTimbre1 = new com.mytools.swings.JComponents.Spinner();
        spinnerSegundosTimbre1 = new com.mytools.swings.JComponents.Spinner();
        labelHora3 = new com.mytools.swings.JComponents.Label.LabelTitle();
        labelMinutos3 = new com.mytools.swings.JComponents.Label.LabelTitle();
        labelSegundos3 = new com.mytools.swings.JComponents.Label.LabelTitle();
        Detener = new com.mytools.swings.JComponents.BotonIcono();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setType(java.awt.Window.Type.POPUP);

        panelDegradado1.setOpacidadFinal(80);
        panelDegradado1.setOpacidadInical(80);

        Guardar.setText("Guardar");
        Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarActionPerformed(evt);
            }
        });

        Cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CerrarActionPerformed(evt);
            }
        });

        labelHeaderAlarmaNormal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelHeaderAlarmaNormal.setText("  Alarma");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        spinnerHoras.setModel(new javax.swing.SpinnerNumberModel(2, 0, 24, 1));
        spinnerHoras.setFont(new java.awt.Font("Cascadia Mono", 0, 24)); // NOI18N

        spinnerMinutos.setModel(new javax.swing.SpinnerNumberModel(0, 0, 60, 1));
        spinnerMinutos.setFont(new java.awt.Font("Cascadia Mono", 0, 24)); // NOI18N

        spinnerSegundos.setModel(new javax.swing.SpinnerNumberModel(0, 0, 60, 1));
        spinnerSegundos.setFont(new java.awt.Font("Cascadia Mono", 0, 24)); // NOI18N

        labelHora.setText("Horas");
        labelHora.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N

        labelMinutos.setText("Minutos");
        labelMinutos.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N

        labelSegundos.setText("Segundos");
        labelSegundos.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N

        javax.swing.GroupLayout panelDegradado2Layout = new javax.swing.GroupLayout(panelDegradado2);
        panelDegradado2.setLayout(panelDegradado2Layout);
        panelDegradado2Layout.setHorizontalGroup(
            panelDegradado2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDegradado2Layout.createSequentialGroup()
                .addGroup(panelDegradado2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDegradado2Layout.createSequentialGroup()
                        .addContainerGap(27, Short.MAX_VALUE)
                        .addGroup(panelDegradado2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(spinnerHoras, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                            .addComponent(labelHora, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addGroup(panelDegradado2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelMinutos, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spinnerMinutos, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addGroup(panelDegradado2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelSegundos, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spinnerSegundos, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 24, Short.MAX_VALUE))
                    .addGroup(panelDegradado2Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(labelHeaderAlarmaNormal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelDegradado2Layout.setVerticalGroup(
            panelDegradado2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDegradado2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelHeaderAlarmaNormal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDegradado2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelDegradado2Layout.createSequentialGroup()
                        .addGroup(panelDegradado2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelHora, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelMinutos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelSegundos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelDegradado2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(spinnerSegundos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spinnerMinutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spinnerHoras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30))
                    .addComponent(jSeparator1)
                    .addComponent(jSeparator2))
                .addGap(12, 12, 12))
        );

        labelHeaderTimbre1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelHeaderTimbre1.setText("  Timbre");

        jSeparator13.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator14.setOrientation(javax.swing.SwingConstants.VERTICAL);

        spinnerHorasTimbre1.setModel(new javax.swing.SpinnerNumberModel(0, 0, 24, 1));
        spinnerHorasTimbre1.setFont(new java.awt.Font("Cascadia Mono", 0, 24)); // NOI18N

        spinnerMinutosTimbre1.setModel(new javax.swing.SpinnerNumberModel(2, 0, 60, 1));
        spinnerMinutosTimbre1.setFont(new java.awt.Font("Cascadia Mono", 0, 24)); // NOI18N

        spinnerSegundosTimbre1.setModel(new javax.swing.SpinnerNumberModel(0, 0, 60, 1));
        spinnerSegundosTimbre1.setFont(new java.awt.Font("Cascadia Mono", 0, 24)); // NOI18N

        labelHora3.setText("Horas");
        labelHora3.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N

        labelMinutos3.setText("Minutos");
        labelMinutos3.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N

        labelSegundos3.setText("Segundos");
        labelSegundos3.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N

        javax.swing.GroupLayout panelDegradado5Layout = new javax.swing.GroupLayout(panelDegradado5);
        panelDegradado5.setLayout(panelDegradado5Layout);
        panelDegradado5Layout.setHorizontalGroup(
            panelDegradado5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDegradado5Layout.createSequentialGroup()
                .addGroup(panelDegradado5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDegradado5Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelDegradado5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(spinnerHorasTimbre1, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                            .addComponent(labelHora3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelDegradado5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelMinutos3, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spinnerMinutosTimbre1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelDegradado5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelSegundos3, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spinnerSegundosTimbre1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelDegradado5Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(labelHeaderTimbre1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelDegradado5Layout.setVerticalGroup(
            panelDegradado5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDegradado5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelHeaderTimbre1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDegradado5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelDegradado5Layout.createSequentialGroup()
                        .addGroup(panelDegradado5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelHora3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelMinutos3, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                            .addComponent(labelSegundos3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelDegradado5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(spinnerSegundosTimbre1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spinnerMinutosTimbre1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spinnerHorasTimbre1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30))
                    .addComponent(jSeparator13)
                    .addComponent(jSeparator14))
                .addGap(12, 12, 12))
        );

        Detener.setText("Detener");
        Detener.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DetenerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelDegradado1Layout = new javax.swing.GroupLayout(panelDegradado1);
        panelDegradado1.setLayout(panelDegradado1Layout);
        panelDegradado1Layout.setHorizontalGroup(
            panelDegradado1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDegradado1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDegradado1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelDegradado1Layout.createSequentialGroup()
                        .addComponent(Cerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Detener, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Guardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelDegradado2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelDegradado5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelDegradado1Layout.setVerticalGroup(
            panelDegradado1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDegradado1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelDegradado2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelDegradado5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelDegradado1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDegradado1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Detener, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Cerrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelDegradado1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelDegradado1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarActionPerformed
        alarma.detener();
        alarma.inicir((int) spinnerHoras.getValue(), (int) spinnerMinutos.getValue(), (int) spinnerSegundos.getValue());
        alarma.getTimbre().setHoraInicio((int) spinnerHorasTimbre1.getValue());
        alarma.getTimbre().setMinutoInicio((int) spinnerMinutosTimbre1.getValue());
        alarma.getTimbre().setSegundoInicio((int) spinnerSegundosTimbre1.getValue());
        Dashboard.alarma = alarma;
    }//GEN-LAST:event_GuardarActionPerformed

    private void CerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CerrarActionPerformed
        // TODO add you
        dispose();
    }//GEN-LAST:event_CerrarActionPerformed

    private void DetenerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DetenerActionPerformed
        // TODO add your handling code here:
        alarma.detener();
    }//GEN-LAST:event_DetenerActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ConfigAlarm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConfigAlarm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConfigAlarm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConfigAlarm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ConfigAlarm dialog = new ConfigAlarm(new javax.swing.JFrame(), new Alarma(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.mytools.swings.JComponents.BotonIcono Cerrar;
    private com.mytools.swings.JComponents.BotonIcono Detener;
    private com.mytools.swings.JComponents.BotonIcono Guardar;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator2;
    private com.mytools.swings.JComponents.Label.LabelHeader labelHeaderAlarmaNormal;
    private com.mytools.swings.JComponents.Label.LabelHeader labelHeaderTimbre1;
    private com.mytools.swings.JComponents.Label.LabelTitle labelHora;
    private com.mytools.swings.JComponents.Label.LabelTitle labelHora3;
    private com.mytools.swings.JComponents.Label.LabelTitle labelMinutos;
    private com.mytools.swings.JComponents.Label.LabelTitle labelMinutos3;
    private com.mytools.swings.JComponents.Label.LabelTitle labelSegundos;
    private com.mytools.swings.JComponents.Label.LabelTitle labelSegundos3;
    private com.mytools.swings.JComponents.PanelDegradado panelDegradado1;
    private com.mytools.swings.JComponents.PanelDegradado panelDegradado2;
    private com.mytools.swings.JComponents.PanelDegradado panelDegradado5;
    private com.mytools.swings.JComponents.Spinner spinnerHoras;
    private com.mytools.swings.JComponents.Spinner spinnerHorasTimbre1;
    private com.mytools.swings.JComponents.Spinner spinnerMinutos;
    private com.mytools.swings.JComponents.Spinner spinnerMinutosTimbre1;
    private com.mytools.swings.JComponents.Spinner spinnerSegundos;
    private com.mytools.swings.JComponents.Spinner spinnerSegundosTimbre1;
    // End of variables declaration//GEN-END:variables
}
