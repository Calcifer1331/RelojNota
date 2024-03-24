package com.mytools.views;

import com.mytools.utils.Alarma;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Inicio extends javax.swing.JPanel {

    private Alarma alarma;
    private Timer timer;

    public Inicio() {
        initComponents();
        alarma = new Alarma();
        init();

    }

    public Inicio(Alarma alarma) {
        initComponents();
        this.alarma = alarma;
        init();
    }

    private void init() {
        timer = new Timer();
        RelojAlarma.setSvgImage(alarma.getImg());
        actualizarHora();
        loadFromFile(); // Cargar contenido del archivo al iniciar
        TextNota.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                saveToFile();
            }

            public void removeUpdate(DocumentEvent e) {
                saveToFile();
            }

            public void changedUpdate(DocumentEvent e) {
                saveToFile();
            }
        });
    }

    private void actualizarHora() {
        timer.schedule(new MiTarea(), 0, 1000); // ahra MiTarea, indefinidamente, cada 1 segindp
    }

    class MiTarea extends TimerTask {// actualiza el label con la hor actual

        public void run() {
            HoraActual.setText(horaActual());
            HoraRestante.setText(alarma.toString());
        }
    }

    private String horaActual() {// retona hora actual con fomato
        LocalTime horaActual = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss a");
        String horaFormateada = horaActual.format(formatter);
        return horaFormateada;
    }

    private void loadFromFile() {
        File file = new File("texto.txt");
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file, StandardCharsets.UTF_8))) {
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    sb.append(line).append("\n");
                }
                TextNota.setText(sb.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            // Si el archivo no existe, no hay contenido para cargar
            System.out.println("El archivo no existe. Se creará uno nuevo.");
        }
    }

    private void saveToFile() {
        String text = TextNota.getText();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("texto.txt", StandardCharsets.UTF_8))) {
            writer.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollPanel1 = new com.mytools.swings.JComponents.ScrollPanel();
        TextNota = new com.mytools.swings.JComponents.TextAreaTransparente();
        panelDegradado1 = new com.mytools.swings.JComponents.PanelDegradado();
        RelojAlarma = new com.mytools.swings.JComponents.Label.LabelLogo();
        PanelHoraActualk = new com.mytools.swings.JComponents.PanelDegradado();
        labelTitle1 = new com.mytools.swings.JComponents.Label.LabelTitle();
        HoraActual = new com.mytools.swings.JComponents.Label.LabelHeader();
        PanelHoraRestante = new com.mytools.swings.JComponents.PanelDegradado();
        labelTitle2 = new com.mytools.swings.JComponents.Label.LabelTitle();
        HoraRestante = new com.mytools.swings.JComponents.Label.LabelHeader();
        labelHeader1 = new com.mytools.swings.JComponents.Label.LabelHeader();

        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(700, 600));

        TextNota.setColumns(20);
        TextNota.setRows(5);
        TextNota.setText("");
        TextNota.setToolTipText("");
        scrollPanel1.setViewportView(TextNota);

        labelTitle1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelTitle1.setText("  Hora Actual");

        HoraActual.setFont(new java.awt.Font("Cascadia Mono", 1, 36)); // NOI18N

        javax.swing.GroupLayout PanelHoraActualkLayout = new javax.swing.GroupLayout(PanelHoraActualk);
        PanelHoraActualk.setLayout(PanelHoraActualkLayout);
        PanelHoraActualkLayout.setHorizontalGroup(
            PanelHoraActualkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelHoraActualkLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelHoraActualkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(HoraActual, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelTitle1, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE))
                .addContainerGap())
        );
        PanelHoraActualkLayout.setVerticalGroup(
            PanelHoraActualkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelHoraActualkLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTitle1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(HoraActual, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                .addContainerGap())
        );

        labelTitle2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelTitle2.setText("  Tiempo Restante");

        HoraRestante.setFont(new java.awt.Font("Cascadia Mono", 1, 36)); // NOI18N

        javax.swing.GroupLayout PanelHoraRestanteLayout = new javax.swing.GroupLayout(PanelHoraRestante);
        PanelHoraRestante.setLayout(PanelHoraRestanteLayout);
        PanelHoraRestanteLayout.setHorizontalGroup(
            PanelHoraRestanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelHoraRestanteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelHoraRestanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelTitle2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                    .addComponent(HoraRestante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        PanelHoraRestanteLayout.setVerticalGroup(
            PanelHoraRestanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelHoraRestanteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTitle2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(HoraRestante, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout panelDegradado1Layout = new javax.swing.GroupLayout(panelDegradado1);
        panelDegradado1.setLayout(panelDegradado1Layout);
        panelDegradado1Layout.setHorizontalGroup(
            panelDegradado1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDegradado1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(RelojAlarma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(19, 19, 19))
            .addGroup(panelDegradado1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelHoraActualk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelHoraRestante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelDegradado1Layout.setVerticalGroup(
            panelDegradado1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDegradado1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDegradado1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(PanelHoraActualk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PanelHoraRestante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(RelojAlarma, javax.swing.GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
                .addGap(19, 19, 19))
        );

        labelHeader1.setText("Apuntes / Notas");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(labelHeader1, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelDegradado1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelDegradado1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(labelHeader1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.mytools.swings.JComponents.Label.LabelHeader HoraActual;
    private com.mytools.swings.JComponents.Label.LabelHeader HoraRestante;
    private com.mytools.swings.JComponents.PanelDegradado PanelHoraActualk;
    private com.mytools.swings.JComponents.PanelDegradado PanelHoraRestante;
    private com.mytools.swings.JComponents.Label.LabelLogo RelojAlarma;
    private com.mytools.swings.JComponents.TextAreaTransparente TextNota;
    private com.mytools.swings.JComponents.Label.LabelHeader labelHeader1;
    private com.mytools.swings.JComponents.Label.LabelTitle labelTitle1;
    private com.mytools.swings.JComponents.Label.LabelTitle labelTitle2;
    private com.mytools.swings.JComponents.PanelDegradado panelDegradado1;
    private com.mytools.swings.JComponents.ScrollPanel scrollPanel1;
    // End of variables declaration//GEN-END:variables
}
