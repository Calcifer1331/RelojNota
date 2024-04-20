package com.mytools.views;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.mytools.ilib.Dashboard;
import static com.mytools.ilib.Dashboard.alarma;
import com.mytools.swings.JComponents.BotonColor;
import com.mytools.utils.Alarma;
import com.mytools.utils.Alarma.AlarmaListener;
import com.mytools.utils.Timbre;
import java.awt.Color;
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

public class Inicio extends javax.swing.JPanel implements AlarmaListener, Timbre.TimbreListener {

    public com.mytools.swings.JComponents.tree.Tree getTree() {
        return tree;
    }

    public void setTree(com.mytools.swings.JComponents.tree.Tree tree) {
        this.tree = tree;
    }

    Dashboard dashboard;
    ConfigAlarm configAlarm;

    private Alarma alarma;
    private Timer timer;
    private boolean alarmaActiva;
    String[] imagenes = {
        "resource/IconoReloj/relojAlarma-abajo.svg",
        "resource/IconoReloj/relojAlarma-abajo.svg",
        "resource/IconoReloj/relojAlarma-abajo.svg",
    };
    private BotonColor botonColor = new BotonColor();

    public Inicio(Alarma alarma, Dashboard dashboard) {
        initComponents();
        this.alarma = alarma;
        this.dashboard = dashboard;
        init();
    }

    @Override
    public void cicloCompletado(boolean activo) {
        alarmaActiva = activo;
        AlarmaDetener.setVisible(activo);
        System.out.println(activo);
    }

    @Override
    public void cicloCompletado(int ciclo) {
        RelojAlarma.setSvgImage(imagenes[ciclo % imagenes.length]);
    }

    private void init() {

        timer = new Timer();
        RelojAlarma.setSvgImage("resource/IconoReloj/reloj.svg");
        actualizarHora();

        initComponents();
        getTree().setTextArea(textAreaNota);
        getTree().setLabelMensaje(mesajeDescripcyion);
        getTree().setLabelTitle(TitleNodo);
        Nuevo.setIconSvg("resource/Plus.svg");
        Eliminar.setIconSvg("resource/Delete.svg");
        showMenu.setIcon(new FlatSVGIcon(menuTree.isVisible() ? "resource/chevron-left-solid.svg" : "resource/chevron-right-solid.svg", 13, 20));
        AlarmaConfig.setIconSvg("resource/Support.svg");
        AlarmaDetener.setIconSvg("resource/Rstop.svg");
        AlarmaDetener.setVisible(false);

        textAreaNota.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                System.out.println("listener insert" + getTree().getSelectedFolder());
                saveToFile(getTree().getSelectedFolder());

            }

            public void removeUpdate(DocumentEvent e) {
                System.out.println("listener remove" + getTree().getSelectedFolder());

                saveToFile(getTree().getSelectedFolder());
            }

            public void changedUpdate(DocumentEvent e) {
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

    private void saveToFile(File file) {
        String text = textAreaNota.getText();
        if (file.exists()) {
            if (file.isFile()) {
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, StandardCharsets.UTF_8))) {
                    writer.write(text);
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("error");
                }
            } else {
                System.out.println("no es file");
            }
        } else {
            System.out.println("no existe");
        }

    }

    private void toggleMenu() {
        // Cambiar la visibilidad del menú
        menuTree.setVisible(!menuTree.isVisible());
        showMenu.setIcon(new FlatSVGIcon(menuTree.isVisible() ? "resource/chevron-left-solid.svg" : "resource/chevron-right-solid.svg", 13, 20));
        revalidate();
        repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelDegradado1 = new com.mytools.swings.JComponents.PanelDegradado();
        RelojAlarma = new com.mytools.swings.JComponents.Label.LabelLogo();
        PanelHoraActualk = new com.mytools.swings.JComponents.PanelDegradado();
        labelTitle1 = new com.mytools.swings.JComponents.Label.LabelTitle();
        HoraActual = new com.mytools.swings.JComponents.Label.LabelHeader();
        PanelHoraRestante = new com.mytools.swings.JComponents.PanelDegradado();
        labelTitle2 = new com.mytools.swings.JComponents.Label.LabelTitle();
        HoraRestante = new com.mytools.swings.JComponents.Label.LabelHeader();
        AlarmaConfig = new com.mytools.swings.JComponents.BotonIcono();
        AlarmaDetener = new com.mytools.swings.JComponents.BotonIcono();
        menuTree = new com.mytools.swings.JComponents.PanelDegradado();
        labelHeader1 = new com.mytools.swings.JComponents.Label.LabelHeader();
        scrollPanelTransparente1 = new com.mytools.swings.JComponents.ScrollPanelTransparente();
        tree = new com.mytools.swings.JComponents.tree.Tree();
        mesajeDescripcyion = new com.mytools.swings.JComponents.Label.LabelDescripcion();
        Eliminar = new com.mytools.swings.JComponents.BotonIcono();
        Nuevo = new com.mytools.swings.JComponents.BotonIcono();
        scrollPanel1 = new com.mytools.swings.JComponents.ScrollPanel();
        textAreaNota = new com.mytools.swings.JComponents.TextAreaTransparente();
        TitleNodo = new com.mytools.swings.JComponents.Label.LabelHeader();
        showMenu = new javax.swing.JLabel();

        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(700, 600));

        labelTitle1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelTitle1.setText("  Hora Actual");

        HoraActual.setFont(new java.awt.Font("Cascadia Mono", 1, 36)); // NOI18N

        javax.swing.GroupLayout PanelHoraActualkLayout = new javax.swing.GroupLayout(PanelHoraActualk);
        PanelHoraActualk.setLayout(PanelHoraActualkLayout);
        PanelHoraActualkLayout.setHorizontalGroup(
            PanelHoraActualkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelHoraActualkLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelHoraActualkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(HoraActual, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelTitle1, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                .addContainerGap())
        );
        PanelHoraActualkLayout.setVerticalGroup(
            PanelHoraActualkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelHoraActualkLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTitle1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(HoraActual, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        labelTitle2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelTitle2.setText("  Tiempo Restante");

        HoraRestante.setFont(new java.awt.Font("Cascadia Mono", 1, 36)); // NOI18N

        AlarmaConfig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AlarmaConfigActionPerformed(evt);
            }
        });

        AlarmaDetener.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AlarmaDetenerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelHoraRestanteLayout = new javax.swing.GroupLayout(PanelHoraRestante);
        PanelHoraRestante.setLayout(PanelHoraRestanteLayout);
        PanelHoraRestanteLayout.setHorizontalGroup(
            PanelHoraRestanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelHoraRestanteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelHoraRestanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(HoraRestante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(PanelHoraRestanteLayout.createSequentialGroup()
                        .addComponent(labelTitle2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(AlarmaDetener, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(AlarmaConfig, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)))
                .addContainerGap())
        );
        PanelHoraRestanteLayout.setVerticalGroup(
            PanelHoraRestanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelHoraRestanteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelHoraRestanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(AlarmaConfig, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(AlarmaDetener, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(labelTitle2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(HoraRestante, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout panelDegradado1Layout = new javax.swing.GroupLayout(panelDegradado1);
        panelDegradado1.setLayout(panelDegradado1Layout);
        panelDegradado1Layout.setHorizontalGroup(
            panelDegradado1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDegradado1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDegradado1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(RelojAlarma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelDegradado1Layout.createSequentialGroup()
                        .addComponent(PanelHoraActualk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PanelHoraRestante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelDegradado1Layout.setVerticalGroup(
            panelDegradado1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDegradado1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDegradado1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(PanelHoraActualk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PanelHoraRestante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RelojAlarma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        labelHeader1.setText("Notas");

        tree.setFont(new java.awt.Font("Segoe UI Semibold", 1, 1815)); // NOI18N
        scrollPanelTransparente1.setViewportView(tree);

        mesajeDescripcyion.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarActionPerformed(evt);
            }
        });

        Nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NuevoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout menuTreeLayout = new javax.swing.GroupLayout(menuTree);
        menuTree.setLayout(menuTreeLayout);
        menuTreeLayout.setHorizontalGroup(
            menuTreeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelHeader1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuTreeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(menuTreeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(scrollPanelTransparente1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(menuTreeLayout.createSequentialGroup()
                        .addComponent(Eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(menuTreeLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(mesajeDescripcyion, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        menuTreeLayout.setVerticalGroup(
            menuTreeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuTreeLayout.createSequentialGroup()
                .addComponent(labelHeader1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollPanelTransparente1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(15, 15, 15)
                .addGroup(menuTreeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(mesajeDescripcyion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        textAreaNota.setColumns(20);
        textAreaNota.setRows(5);
        scrollPanel1.setViewportView(textAreaNota);

        TitleNodo.setText("Notas");

        showMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                showMenuMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                showMenuMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                showMenuMousePressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(menuTree, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(showMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(TitleNodo, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(6, 6, 6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelDegradado1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelDegradado1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(menuTree, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(TitleNodo, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 543, Short.MAX_VALUE))
            .addComponent(showMenu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
        getTree().eliminarArchivoODirectorioSeleccionado();
    }//GEN-LAST:event_EliminarActionPerformed

    private void NuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NuevoActionPerformed
        addFileCarpet fileCarpet = new addFileCarpet(dashboard, getTree(), true);
        fileCarpet.setVisible(true);
    }//GEN-LAST:event_NuevoActionPerformed

    private void showMenuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showMenuMouseEntered
        showMenu.setIcon(new FlatSVGIcon(menuTree.isVisible() ? "resource/chevron-left-solid-selected.svg" : "resource/chevron-right-solid-selected.svg", 13, 20));
    }//GEN-LAST:event_showMenuMouseEntered

    private void showMenuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showMenuMouseExited
        showMenu.setIcon(new FlatSVGIcon(menuTree.isVisible() ? "resource/chevron-left-solid.svg" : "resource/chevron-right-solid.svg", 13, 20));
    }//GEN-LAST:event_showMenuMouseExited

    private void showMenuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showMenuMousePressed
        toggleMenu();
    }//GEN-LAST:event_showMenuMousePressed

    private void AlarmaConfigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AlarmaConfigActionPerformed
        // TODO add your handling code here:
        configAlarm = new ConfigAlarm(dashboard, alarma, true);
        configAlarm.setVisible(true);
    }//GEN-LAST:event_AlarmaConfigActionPerformed

    private void AlarmaDetenerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AlarmaDetenerActionPerformed
        if (alarmaActiva) {
            alarma.getTimbre().detener();
        }
    }//GEN-LAST:event_AlarmaDetenerActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.mytools.swings.JComponents.BotonIcono AlarmaConfig;
    private com.mytools.swings.JComponents.BotonIcono AlarmaDetener;
    private com.mytools.swings.JComponents.BotonIcono Eliminar;
    private com.mytools.swings.JComponents.Label.LabelHeader HoraActual;
    private com.mytools.swings.JComponents.Label.LabelHeader HoraRestante;
    private com.mytools.swings.JComponents.BotonIcono Nuevo;
    private com.mytools.swings.JComponents.PanelDegradado PanelHoraActualk;
    private com.mytools.swings.JComponents.PanelDegradado PanelHoraRestante;
    private com.mytools.swings.JComponents.Label.LabelLogo RelojAlarma;
    private com.mytools.swings.JComponents.Label.LabelHeader TitleNodo;
    private com.mytools.swings.JComponents.Label.LabelHeader labelHeader1;
    private com.mytools.swings.JComponents.Label.LabelTitle labelTitle1;
    private com.mytools.swings.JComponents.Label.LabelTitle labelTitle2;
    private com.mytools.swings.JComponents.PanelDegradado menuTree;
    private com.mytools.swings.JComponents.Label.LabelDescripcion mesajeDescripcyion;
    private com.mytools.swings.JComponents.PanelDegradado panelDegradado1;
    private com.mytools.swings.JComponents.ScrollPanel scrollPanel1;
    private com.mytools.swings.JComponents.ScrollPanelTransparente scrollPanelTransparente1;
    private javax.swing.JLabel showMenu;
    private com.mytools.swings.JComponents.TextAreaTransparente textAreaNota;
    private com.mytools.swings.JComponents.tree.Tree tree;
    // End of variables declaration//GEN-END:variables
}
