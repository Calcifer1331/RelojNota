package com.mytools.views;

import com.mytools.swings.JComponents.jlist.Item;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class prueva extends javax.swing.JPanel {

    private Item item;
    private Item[] ListItems;
    private String icon;
    private String folderPath = "notas"; // Ruta a la carpeta donde se guardarán los archivos
    private List<String> nombres;

    public prueva() {

        initComponents();
        icon = "resource/file.svg";
        Nuevo.setSvgImage("resource/Plus.svg");
        Eliminar.setSvgImage("resource/Delete.svg");
        /*myList1.addItem(new Item("text 1", icon));
        myList1.addItem(new Item("text 2", icon));
        myList1.addItem(new Item("text 3", icon));
        myList1.addItem(new Item("text 4", icon));
        Item[] ListItems = {new Item("text 5", icon), new Item("text 6", icon)};*/
        CargarList();

        /*item = (Item) myList1.getModel().firstElement();
            myList1.setSelectedIndex(0);
            loadFromFile(item.getText()); // Cargar contenido del archivo al iniciar*/
        myList1.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                item = (Item) myList1.getModel().get(myList1.getSelectedIndex());
                System.out.println(item.getText());
                loadFromFile(item.getText()); // Cargar contenido del archivo al iniciar
            }
        });
        TextNota.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                saveToFile(item.getText());
            }

            public void removeUpdate(DocumentEvent e) {
                saveToFile(item.getText());
            }

            public void changedUpdate(DocumentEvent e) {
                saveToFile(item.getText());
            }
        });

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelDegradado1 = new com.mytools.swings.JComponents.PanelDegradado();
        scrollPanelTransparente1 = new com.mytools.swings.JComponents.ScrollPanelTransparente();
        myList1 = new com.mytools.swings.JComponents.jlist.MyList<>();
        labelTitle1 = new com.mytools.swings.JComponents.Label.LabelTitle();
        Nuevo = new com.mytools.swings.JComponents.BotonMenu();
        Eliminar = new com.mytools.swings.JComponents.BotonMenu();
        panelDegradadoLabelTitle1 = new com.mytools.swings.PanelDegradadoLabelTitle();
        jLabel1 = new javax.swing.JLabel();
        NombreNota = new javax.swing.JTextField();
        scrollPanel1 = new com.mytools.swings.JComponents.ScrollPanel();
        TextNota = new com.mytools.swings.JComponents.TextAreaTransparente();

        setBackground(new java.awt.Color(204, 255, 204));
        setOpaque(false);

        myList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        myList1.setOpaque(false);
        scrollPanelTransparente1.setViewportView(myList1);

        labelTitle1.setText("Lista de Notas");

        Nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NuevoActionPerformed(evt);
            }
        });

        Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarActionPerformed(evt);
            }
        });

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
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panelDegradado1Layout.setVerticalGroup(
            panelDegradado1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDegradado1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTitle1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPanelTransparente1, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDegradado1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11))
        );

        panelDegradadoLabelTitle1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelDegradadoLabelTitle1MouseClicked(evt);
            }
        });

        jLabel1.setText("jLabel1");

        NombreNota.setText("nombre");

        TextNota.setColumns(20);
        TextNota.setRows(5);
        TextNota.setText("\n");
        scrollPanel1.setViewportView(TextNota);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelDegradado1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(panelDegradadoLabelTitle1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(NombreNota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(scrollPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)))
                .addGap(32, 32, 32))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jLabel1))
                            .addComponent(panelDegradadoLabelTitle1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addComponent(scrollPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(NombreNota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelDegradado1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void panelDegradadoLabelTitle1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelDegradadoLabelTitle1MouseClicked
        // TODO add your handling code here:
        //System.out.println(myList1.getSelectedValue().toString());
//        Item i =
        int a = myList1.getSelectedIndex();
        Item i = (Item) myList1.getModel().get(a);
        myList1.getModel().remove(a);
        System.out.println(i.getText() + "  " + i.getIcon());
    }//GEN-LAST:event_panelDegradadoLabelTitle1MouseClicked

    private void NuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NuevoActionPerformed
        String nombre = NombreNota.getText().isEmpty() ? "Nota" : NombreNota.getText();
        if (saveToFile(nombre)) {
            myList1.addItem(new Item(nombre, icon));
            myList1.setSelectedIndex(myList1.getModel().size()-1);
            TextNota.setText("");
        }
    }//GEN-LAST:event_NuevoActionPerformed

    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
        int index = myList1.getSelectedIndex();
        myList1.setSelectedIndex(index-1);
        deleteFile(((Item) myList1.getModel().get(index)).getText());
        
    }//GEN-LAST:event_EliminarActionPerformed

    private List<String> listFilesInFolder() {
        List<String> fileNames = new ArrayList<>();
        File folder = new File(folderPath);
        if (folder.exists() && folder.isDirectory()) {
            File[] files = folder.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        String fileName = file.getName();
                        // Eliminar la extensión .txt
                        String nameWithoutExtension = fileName.substring(0, fileName.lastIndexOf('.'));
                        fileNames.add(nameWithoutExtension);
                    }
                }
            }
        } else {
            System.out.println("La carpeta no existe o no es un directorio válido.");
            // Crea la carpeta si no existe
            if (folder.mkdirs()) {
                System.out.println("Carpeta creada: " + folder.getPath());
                saveToFile("Default");
            } else {
                System.out.println("No se pudo crear la carpeta.");
            }
        }
        return fileNames;
    }

    private void loadFromFile(String name) {

        File file = new File(folderPath, name + ".txt");
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
            TextNota.setText("");
        }
    }

    private boolean saveToFile(String name) {
        String text = TextNota.getText();
        File file = new File(folderPath, name + ".txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, StandardCharsets.UTF_8))) {
            writer.write(text);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean deleteFile(String name) {
        File file = new File(folderPath, name + ".txt");
        if (file.exists()) {
            if (file.delete()) {
                System.out.println("Archivo eliminado correctamente: " + file.getName());
                return true;
            } else {
                System.out.println("No se pudo eliminar el archivo: " + file.getName());
                return false;
            }
        } else {
            System.out.println("El archivo no existe: " + file.getName());
            return false;
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.mytools.swings.JComponents.BotonMenu Eliminar;
    private javax.swing.JTextField NombreNota;
    private com.mytools.swings.JComponents.BotonMenu Nuevo;
    private com.mytools.swings.JComponents.TextAreaTransparente TextNota;
    private javax.swing.JLabel jLabel1;
    private com.mytools.swings.JComponents.Label.LabelTitle labelTitle1;
    private com.mytools.swings.JComponents.jlist.MyList<String> myList1;
    private com.mytools.swings.JComponents.PanelDegradado panelDegradado1;
    private com.mytools.swings.PanelDegradadoLabelTitle panelDegradadoLabelTitle1;
    private com.mytools.swings.JComponents.ScrollPanel scrollPanel1;
    private com.mytools.swings.JComponents.ScrollPanelTransparente scrollPanelTransparente1;
    // End of variables declaration//GEN-END:variables

    private void CargarList() {
        nombres = null;
        nombres = listFilesInFolder();
        for (String nombre : nombres) {
            myList1.addItem(new Item(nombre, icon));
            System.out.println("ugs: " + nombre);
        }
    }
}
