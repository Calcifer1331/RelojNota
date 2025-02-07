package com.mytools.views;

import com.mytools.ilib.Dashboard;
import com.mytools.swings.JComponents.BotonColor;
import com.mytools.swings.JComponents.BotonIcono;
import com.mytools.swings.JComponents.tree.TreeNode;
import com.mytools.utils.Alarma;
import com.mytools.utils.Alarma.AlarmaListener;
import com.mytools.utils.Timbre;
import java.awt.Image;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.tree.TreePath;

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
        "/resource/IconoReloj/relojAlarma-abajo.png",
        "/resource/IconoReloj/relojAlarma-izquierda.png",
        "/resource/IconoReloj/relojAlarma-derecha.png",};
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
        AlarmaDetener.setEnabled(activo);
        System.out.println(activo);
    }

    @Override
    public void cicloCompletado(int ciclo) {
        RelojAlarma.setImage(imagenes[ciclo % imagenes.length]);
    }

    private void init() {
        timer = new Timer();
        actualizarHora();
        getTree().setTextArea(textAreaNota);
        getTree().setLabelMensaje(mesajeDescripcyion);
        getTree().setLabelTitle(TitleNodo);
        
        Nuevo.setIcon(setImage("/resource/Plus.png", Nuevo));
        Eliminar.setIcon(setImage("/resource/Delete.png", Eliminar));
        URL imageUrl = getClass().getResource(menuTree.isVisible() ? "/resource/chevron-left-solid.png" : "/resource/chevron-right-solid.png");
        ImageIcon icon = new ImageIcon(imageUrl);
        Image scaledImage = icon.getImage().getScaledInstance(13, 20, Image.SCALE_SMOOTH);
        showMenu.setIcon(new ImageIcon(scaledImage));
        AlarmaConfig.setIcon(setImage("/resource/Support.png", AlarmaConfig));
        AlarmaDetener.setIcon(setImage("/resource/Rstop.png", AlarmaDetener));
        AlarmaDetener.setEnabled(false);
        
        textAreaNota.getDocument().addDocumentListener(new DocumentListener() {

            public void insertUpdate(DocumentEvent e) {
                System.out.println(tree.getSelectedFolder().isFile());
                if (tree.getSelectedFolder().isFile()) {
                    System.out.println("listener insert" + getTree().getSelectedFolder());
                    saveToFile(getTree().getSelectedFolder());

                }else{
                }
            }

            public void removeUpdate(DocumentEvent e) {
                System.out.println(tree.getSelectedFolder().isFile());
                if (tree.getSelectedFolder().isFile() ) {
                    System.out.println("listener remove" + getTree().getSelectedFolder());

                    saveToFile(getTree().getSelectedFolder());
                }else{
                }
            }

            public void changedUpdate(DocumentEvent e) {
                System.out.println("aaa");
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

    private String horaActual() {
        Date date = new Date(); // Obtiene la fecha y hora actuales
        DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss a"); // Define el formato de la hora
        return dateFormat.format(date); // Formatea la fecha y hora y la devuelve como String
    }

    private void saveToFile(File file) {
        String text = textAreaNota.getText();
        if (file.exists()) {
            if (file.isFile()) {
                BufferedWriter writer = null;
                try {
                    writer = new BufferedWriter(new FileWriter(file));
                    writer.write(text);
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("error");
                } finally {
                    if (writer != null) {
                        try {
                            writer.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                            System.out.println("error al cerrar el escritor");
                        }
                    }
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
        URL imageUrl = getClass().getResource(menuTree.isVisible() ? "/resource/chevron-left-solid.png" : "/resource/chevron-right-solid.png");
        ImageIcon icon = new ImageIcon(imageUrl);
        Image scaledImage = icon.getImage().getScaledInstance(13, 20, Image.SCALE_SMOOTH);
        showMenu.setIcon(new ImageIcon(scaledImage));
        revalidate();
        repaint();
    }

    public ImageIcon setImage(String image, BotonIcono boton) {
        URL imageUrl = getClass().getResource(image);
        if (imageUrl != null) {
            ImageIcon icon = new ImageIcon(imageUrl);

            Image scaledImage = icon.getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH);

            return new ImageIcon(scaledImage);
        } else {
            System.err.println("Error: La URL de la imagen es nula para " + image);
            return null;
        }
    }
    public void eliminarArchivoODirectorioSeleccionado() {
    TreePath path = getTree().getSelectionPath();
    if (path != null) {
        TreeNode selectedNode = (TreeNode) path.getLastPathComponent();
        String selectedPath = getTree().getPath(selectedNode);
        File selectedFile = new File(selectedPath);
        if (selectedFile.exists()) {
            // Obtener el nodo raíz
            TreeNode rootNode = (TreeNode) getTree().getModel().getRoot();
            TreePath rootPath = new TreePath(rootNode);

            // Seleccionar el nodo raíz antes de eliminar
            getTree().setSelectionPath(rootPath);

            if (selectedFile.delete()) {
                getTree().actualizar(getTree().getFolder());
                getTree().getLabelMensaje().setText("Se eliminó correctamente: " + selectedPath);
            } else {
                getTree().getLabelMensaje().setText("No se pudo eliminar: " + selectedPath);
            }
        } else {
            getTree().getLabelMensaje().setText("El archivo o directorio seleccionado no existe.");
        }
    } else {
        getTree().getLabelMensaje().setText("No se ha seleccionado ningún archivo o directorio.");
    }
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
        labelTitle1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N

        HoraActual.setFont(new java.awt.Font("Cascadia Mono", 1, 36));

        javax.swing.GroupLayout PanelHoraActualkLayout = new javax.swing.GroupLayout(PanelHoraActualk);
        PanelHoraActualk.setLayout(PanelHoraActualkLayout);
        PanelHoraActualkLayout.setHorizontalGroup(
            PanelHoraActualkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelHoraActualkLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelHoraActualkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(HoraActual, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                    .addComponent(labelTitle1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        labelTitle2.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N

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
                    .addComponent(HoraRestante, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
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
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelDegradado1Layout = new javax.swing.GroupLayout(panelDegradado1);
        panelDegradado1.setLayout(panelDegradado1Layout);
        panelDegradado1Layout.setHorizontalGroup(
            panelDegradado1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDegradado1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDegradado1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(RelojAlarma, javax.swing.GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
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
                .addGroup(panelDegradado1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(PanelHoraRestante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelHoraActualk, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RelojAlarma, javax.swing.GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)
                .addContainerGap())
        );

        labelHeader1.setText("Notas");
        labelHeader1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N

        tree.setBackground(new java.awt.Color(255, 0, 255));
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
            .addComponent(labelHeader1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuTreeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(menuTreeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(scrollPanelTransparente1, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
                    .addGroup(menuTreeLayout.createSequentialGroup()
                        .addComponent(Eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 181, Short.MAX_VALUE)
                        .addComponent(Nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(menuTreeLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(mesajeDescripcyion, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
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
        textAreaNota.setText("");
        textAreaNota.setEnabled(false);
        textAreaNota.setFont(new java.awt.Font("Segoe UI Semibold", 0, 19)); // NOI18N
        scrollPanel1.setViewportView(textAreaNota);

        TitleNodo.setText("Notas");
        TitleNodo.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N

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
                    .addComponent(scrollPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(TitleNodo, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 542, Short.MAX_VALUE))
            .addComponent(showMenu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
            .addComponent(menuTree, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
        eliminarArchivoODirectorioSeleccionado();
    }//GEN-LAST:event_EliminarActionPerformed

    private void NuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NuevoActionPerformed
        if(getTree().getSelectionPath() != null){
        if(getTree().getSelectedFolder().isDirectory()){
        addFileCarpet fileCarpet = new addFileCarpet(dashboard, getTree(), true);
        fileCarpet.setVisible(true);
        }}
    }//GEN-LAST:event_NuevoActionPerformed

    private void showMenuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showMenuMouseEntered
        URL imageUrl = getClass().getResource(menuTree.isVisible() ? "/resource/chevron-left-solid-selected.png" : "/resource/chevron-right-solid-selected.png");
        ImageIcon icon = new ImageIcon(imageUrl);
        Image scaledImage = icon.getImage().getScaledInstance(13, 20, Image.SCALE_SMOOTH);
        showMenu.setIcon(new ImageIcon(scaledImage));

    }//GEN-LAST:event_showMenuMouseEntered

    private void showMenuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showMenuMouseExited
        URL imageUrl = getClass().getResource(menuTree.isVisible() ? "/resource/chevron-left-solid.png" : "/resource/chevron-right-solid.png");
        ImageIcon icon = new ImageIcon(imageUrl);
        Image scaledImage = icon.getImage().getScaledInstance(13, 20, Image.SCALE_SMOOTH);
        showMenu.setIcon(new ImageIcon(scaledImage));
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
