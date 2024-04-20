package com.mywebmanager.views;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.mywebmanager.ilib.Dashboard;
import com.mywebmanager.implement.DAOCategoria_PerfumeImpl;
import com.mywebmanager.implement.DAOPerfumesImpl;
import com.mywebmanager.interfaces.DAOCategoria_Perfume;
import com.mywebmanager.interfaces.DAOPerfumes;
import com.mywebmanager.models.Category_Perfume;
import com.mywebmanager.swings.JComponents.Constantes;
import java.awt.Toolkit;
import javax.swing.table.DefaultTableModel;

public class VerPerfume extends javax.swing.JPanel implements Constantes {

    private FlatSVGIcon svgIcon;

    public VerPerfume() {
        initComponents();
        init();
        LoadUsers();
    }

    private void init() {
        btnLimpiar.setIcon(setSVG("resource/Clean.svg"));
        btnBuscar.setIcon(setSVG("resource/Search.svg"));
        btnBorrar.setIcon(setSVG("resource/Delete.svg"));
        btnAgregar.setIcon(setSVG("resource/Plus.svg"));
        btnEditar.setIcon(setSVG("resource/Edit.svg"));
    }

    private FlatSVGIcon setSVG(String img) {
        svgIcon = new FlatSVGIcon(img, 25, 25);
        return svgIcon;
    }

    private void LoadUsers() {
        try {
            DAOPerfumes dao = new DAOPerfumesImpl();
            DefaultTableModel model = (DefaultTableModel) table1.getModel();
            model.setRowCount(0);
            dao.list(0, null).forEach((u) -> model.addRow(new Object[]{u.getId(), u.getName(), getNameCategory(u.getCategory_Perfume_Id()), u.getImage(), u.getDescription(), u.getPrice(), u.getInventoryQuantity(), u.getDateAdded()}));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private String getNameCategory(int Category_Perfume_Id) {
        DAOCategoria_Perfume daocp = new DAOCategoria_PerfumeImpl();
        Category_Perfume category_Perfume = daocp.getCategoria_PerfumeById(Category_Perfume_Id);
        return category_Perfume.getName();
    }

    private void buscar() {
        int opcion = opcionBuscar.getSelectedIndex();
        String valorbuscar = campoBuscar.getText();
        if (valorbuscar.isEmpty()) {
            valorbuscar = null;
        }
        try {
            DAOPerfumes dao = new DAOPerfumesImpl();
            DefaultTableModel model = (DefaultTableModel) table1.getModel();
            model.setRowCount(0);

            dao.list(opcion, valorbuscar).forEach((u) -> model.addRow(new Object[]{u.getId(), u.getName(), getNameCategory(u.getCategory_Perfume_Id()), u.getImage(), u.getDescription(), u.getPrice(), u.getInventoryQuantity(), u.getDateAdded()}));
            campoBuscar.setText("");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        panelDegradadoHeader = new com.mywebmanager.swings.JComponents.PanelDegradado();
        btnBuscar = new com.mywebmanager.swings.JComponents.BotonColor();
        btnLimpiar = new com.mywebmanager.swings.JComponents.BotonColor();
        opcionBuscar = new com.mywebmanager.swings.JComponents.ComboBox();
        campoBuscar = new com.mywebmanager.swings.TextFildIcono();
        panelDegradadocontent = new com.mywebmanager.swings.JComponents.PanelDegradado();
        jScrollPane2 = new javax.swing.JScrollPane();
        table1 = new com.mywebmanager.swings.JComponents.Table();
        panelDegradadoFooter = new com.mywebmanager.swings.JComponents.PanelDegradado();
        btnBorrar = new com.mywebmanager.swings.JComponents.BotonColor();
        btnEditar = new com.mywebmanager.swings.JComponents.BotonColor();
        btnAgregar = new com.mywebmanager.swings.JComponents.BotonColor();

        setOpaque(false);

        btnBuscar.setText("Buscar");
        btnBuscar.setBorderPainted(true);
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        opcionBuscar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mostrar todos", "Nombre", "Precio", "Cantidad en Inventario", "Fecha" }));

        campoBuscar.setPlaceholderText("Buscar");
        campoBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoBuscarKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoBuscarKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout panelDegradadoHeaderLayout = new javax.swing.GroupLayout(panelDegradadoHeader);
        panelDegradadoHeader.setLayout(panelDegradadoHeaderLayout);
        panelDegradadoHeaderLayout.setHorizontalGroup(
            panelDegradadoHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDegradadoHeaderLayout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addComponent(opcionBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );
        panelDegradadoHeaderLayout.setVerticalGroup(
            panelDegradadoHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDegradadoHeaderLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(panelDegradadoHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelDegradadoHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLimpiar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(opcionBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Nombre", "Categoria", "Imagen", "Descripcion", "Precio", "En Inventario", "Agregado"
            }
        ));
        table1.setShowGrid(true);
        jScrollPane2.setViewportView(table1);

        javax.swing.GroupLayout panelDegradadocontentLayout = new javax.swing.GroupLayout(panelDegradadocontent);
        panelDegradadocontent.setLayout(panelDegradadocontentLayout);
        panelDegradadocontentLayout.setHorizontalGroup(
            panelDegradadocontentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDegradadocontentLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jScrollPane2)
                .addGap(14, 14, 14))
        );
        panelDegradadocontentLayout.setVerticalGroup(
            panelDegradadocontentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDegradadocontentLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );

        btnBorrar.setText("Borrar");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.setBorderPainted(true);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnAgregar.setText("Agregar");
        btnAgregar.setBorderPainted(true);
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelDegradadoFooterLayout = new javax.swing.GroupLayout(panelDegradadoFooter);
        panelDegradadoFooter.setLayout(panelDegradadoFooterLayout);
        panelDegradadoFooterLayout.setHorizontalGroup(
            panelDegradadoFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDegradadoFooterLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
        panelDegradadoFooterLayout.setVerticalGroup(
            panelDegradadoFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDegradadoFooterLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(panelDegradadoFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelDegradadocontent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelDegradadoFooter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelDegradadoHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelDegradadoHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelDegradadocontent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelDegradadoFooter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        buscar();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        LoadUsers();
        opcionBuscar.setSelectedIndex(0);
        campoBuscar.setText("");
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        DAOPerfumes dao = new DAOPerfumesImpl();
        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        if (table1.getSelectedRows().length < 1) {
            Toolkit.getDefaultToolkit().beep();
            javax.swing.JOptionPane.showMessageDialog(Dashboard.content, "Debe seleccionar uno o mas perfume a eliminar \n", "AVISO", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        } else {
            for (int i : table1.getSelectedRows()) {
                try {
                    dao.delete((int) table1.getValueAt(i, 0));
                    model.removeRow(i);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if (table1.getSelectedRow() > -1) {
            try {
                int perfumeId = (int) table1.getValueAt(table1.getSelectedRow(), 0);
                DAOPerfumes dao = new DAOPerfumesImpl();
                System.out.print(perfumeId);
                Dashboard.ShoJPanel(new UpPerfume(dao.getPerfumeById(perfumeId)));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else {
            Toolkit.getDefaultToolkit().beep();
            javax.swing.JOptionPane.showMessageDialog(Dashboard.content, "Debe seleccionar perfume a editar \n", "AVISO", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        Dashboard.ShoJPanel(new UpPerfume());

    }//GEN-LAST:event_btnAgregarActionPerformed

    private void campoBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoBuscarKeyPressed

    }//GEN-LAST:event_campoBuscarKeyPressed

    private void campoBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoBuscarKeyTyped

    }//GEN-LAST:event_campoBuscarKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.mywebmanager.swings.JComponents.BotonColor btnAgregar;
    private com.mywebmanager.swings.JComponents.BotonColor btnBorrar;
    private com.mywebmanager.swings.JComponents.BotonColor btnBuscar;
    private com.mywebmanager.swings.JComponents.BotonColor btnEditar;
    private com.mywebmanager.swings.JComponents.BotonColor btnLimpiar;
    private javax.swing.ButtonGroup buttonGroup1;
    private com.mywebmanager.swings.TextFildIcono campoBuscar;
    private javax.swing.JScrollPane jScrollPane2;
    private com.mywebmanager.swings.JComponents.ComboBox opcionBuscar;
    private com.mywebmanager.swings.JComponents.PanelDegradado panelDegradadoFooter;
    private com.mywebmanager.swings.JComponents.PanelDegradado panelDegradadoHeader;
    private com.mywebmanager.swings.JComponents.PanelDegradado panelDegradadocontent;
    private com.mywebmanager.swings.JComponents.Table table1;
    // End of variables declaration//GEN-END:variables
}
