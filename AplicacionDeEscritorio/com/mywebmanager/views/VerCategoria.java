package com.mywebmanager.views;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.mywebmanager.ilib.Dashboard;
import com.mywebmanager.implement.DAOCategoria_PerfumeImpl;
import com.mywebmanager.implement.DAOPerfumesImpl;
import com.mywebmanager.interfaces.DAOCategoria_Perfume;
import com.mywebmanager.interfaces.DAOPerfumes;
import java.awt.Toolkit;
import javax.swing.table.DefaultTableModel;

public class VerCategoria extends javax.swing.JPanel {

    private FlatSVGIcon svgIcon;

    public VerCategoria() {
        initComponents();
        init();
        LoadUsers();
    }

    private void init() {
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
            DAOCategoria_Perfume dao = new DAOCategoria_PerfumeImpl();
            DefaultTableModel model = (DefaultTableModel) table1.getModel();
            model.setRowCount(0);
            dao.list().forEach((u) -> model.addRow(new Object[]{u.getId(), u.getName(), u.getImage(), u.getDescription(), u.getDateAdded()}));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelDegradadocontent = new com.mywebmanager.swings.JComponents.PanelDegradado();
        jScrollPane2 = new javax.swing.JScrollPane();
        table1 = new com.mywebmanager.swings.JComponents.Table();
        panelDegradadoFooter = new com.mywebmanager.swings.JComponents.PanelDegradado();
        btnBorrar = new com.mywebmanager.swings.JComponents.BotonColor();
        btnEditar = new com.mywebmanager.swings.JComponents.BotonColor();
        btnAgregar = new com.mywebmanager.swings.JComponents.BotonColor();

        setOpaque(false);

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Nombre", "Imagen", "Descripcion", "Agregado"
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
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 840, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );
        panelDegradadocontentLayout.setVerticalGroup(
            panelDegradadocontentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDegradadocontentLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
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
                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
                    .addComponent(panelDegradadoFooter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelDegradadocontent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelDegradadoFooter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        DAOCategoria_Perfume dao = new DAOCategoria_PerfumeImpl();
        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        if (table1.getSelectedRows().length < 1) {
            Toolkit.getDefaultToolkit().beep();
            javax.swing.JOptionPane.showMessageDialog(Dashboard.content, "Debe seleccionar uno o mas categorias a eliminar \n", "AVISO", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        } else {
            for (int i : table1.getSelectedRows()) {
                try {
                    dao.delete((int) table1.getValueAt(i, 0));
                    model.removeRow(i);
                } catch (Exception e) {
                    Toolkit.getDefaultToolkit().beep();
                    javax.swing.JOptionPane.showMessageDialog(Dashboard.content, "No se pudo realizar la accion.  \n", "AVISO", javax.swing.JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if (table1.getSelectedRow() > -1) {
            try {
                int Id = (int) table1.getValueAt(table1.getSelectedRow(), 0);
                DAOCategoria_Perfume dao = new DAOCategoria_PerfumeImpl();
                System.out.print(Id);
                Dashboard.ShoJPanel(new UpCategorias(dao.getCategoria_PerfumeById(Id)));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else {
            Toolkit.getDefaultToolkit().beep();
            javax.swing.JOptionPane.showMessageDialog(Dashboard.content, "Debe seleccionar categoria a editar \n", "AVISO", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        Dashboard.ShoJPanel(new UpCategorias());
    }//GEN-LAST:event_btnAgregarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.mywebmanager.swings.JComponents.BotonColor btnAgregar;
    private com.mywebmanager.swings.JComponents.BotonColor btnBorrar;
    private com.mywebmanager.swings.JComponents.BotonColor btnEditar;
    private javax.swing.JScrollPane jScrollPane2;
    private com.mywebmanager.swings.JComponents.PanelDegradado panelDegradadoFooter;
    private com.mywebmanager.swings.JComponents.PanelDegradado panelDegradadocontent;
    private com.mywebmanager.swings.JComponents.Table table1;
    // End of variables declaration//GEN-END:variables
}
