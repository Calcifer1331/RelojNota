package com.mywebmanager.views;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.mywebmanager.ilib.Dashboard;
import com.mywebmanager.implement.DAOPerfumesImpl;
import com.mywebmanager.interfaces.DAOPerfumes;
import com.mywebmanager.models.Perfumes;
import com.mywebmanager.swings.JComponents.Constantes;
import java.awt.Toolkit;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.DataTruncation;
import javax.swing.JOptionPane;

public class UpPerfume extends javax.swing.JPanel implements Constantes {

    boolean isEdition = false;
    Perfumes perfumeEdition;
    private FlatSVGIcon svgIcon;

    public UpPerfume() {
        initComponents();
        InitStyles();
    }

    public UpPerfume(Perfumes perfumes) {
        initComponents();
        isEdition = true;
        perfumeEdition = perfumes;
        InitStyles();
    }

    private FlatSVGIcon setSVG(String img) {
        svgIcon = new FlatSVGIcon(img, 25, 25);
        return svgIcon;
    }

    private void InitStyles() {
        btnRegresar.setIcon(setSVG("resource/Return.svg"));
        btnRegistrar.setIcon(setSVG("resource/Save.svg"));
        btnCargarImagen.setIcon(setSVG("resource/Picture.svg"));
        textFildNombre.putClientProperty("JTextField.placeholderText", "Ingrese un nombre");
        textFildNombre.requestFocus();

        if (isEdition) {
            btnRegistrar.setText("Guardar");
            if (perfumeEdition != null) {
                textFildNombre.setText(perfumeEdition.getName());
                spinnerPrecio.setValue(perfumeEdition.getPrice());
                comboBoxCate1.selectCategoryById(perfumeEdition.getCategory_Perfume_Id());
                spinnerCantidadInventario.setValue(perfumeEdition.getInventoryQuantity());
                textAreaDescripcion.setText(perfumeEdition.getDescription());
                textAreaImagenURL.setText(perfumeEdition.getImage());
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelDegradado4 = new com.mywebmanager.swings.JComponents.PanelDegradado();
        textFildNombre = new com.mywebmanager.swings.TextFild();
        labelTitle1 = new com.mywebmanager.swings.JComponents.Label.LabelTitle();
        labelTitle2 = new com.mywebmanager.swings.JComponents.Label.LabelTitle();
        labelTitle3 = new com.mywebmanager.swings.JComponents.Label.LabelTitle();
        labelTitle4 = new com.mywebmanager.swings.JComponents.Label.LabelTitle();
        spinnerPrecio = new com.mywebmanager.swings.JComponents.Spinner();
        spinnerCantidadInventario = new com.mywebmanager.swings.JComponents.Spinner();
        labelTitle5 = new com.mywebmanager.swings.JComponents.Label.LabelTitle();
        scrollPanel3 = new com.mywebmanager.swings.JComponents.ScrollPanel();
        textAreaDescripcion = new com.mywebmanager.swings.JComponents.TextAreaTransparente();
        comboBoxCate1 = new com.mywebmanager.swings.ComboBoxCate();
        panelDegradadoFooter = new com.mywebmanager.swings.JComponents.PanelDegradado();
        btnRegistrar = new com.mywebmanager.swings.JComponents.BotonColor();
        btnRegresar = new com.mywebmanager.swings.JComponents.BotonColor();
        panelDegradado1 = new com.mywebmanager.swings.JComponents.PanelDegradado();
        imageView1 = new com.mywebmanager.swings.ImageView();
        labelTitle6 = new com.mywebmanager.swings.JComponents.Label.LabelTitle();
        scrollPanel1 = new com.mywebmanager.swings.JComponents.ScrollPanel();
        textAreaImagenURL = new com.mywebmanager.swings.JComponents.TextAreaTransparente();
        btnCargarImagen = new com.mywebmanager.swings.JComponents.BotonColor();

        setOpaque(false);

        labelTitle1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelTitle1.setText("Nombre del Perfume*");

        labelTitle2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelTitle2.setText("Precio del Perfume");

        labelTitle3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelTitle3.setText("Categoria del Perfume*");

        labelTitle4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelTitle4.setText("Cantidad en Inventario");

        spinnerPrecio.setModel(new javax.swing.SpinnerNumberModel(0.0d, null, null, 1.0d));

        spinnerCantidadInventario.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        labelTitle5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelTitle5.setText("Descripcion del Perfume*");

        textAreaDescripcion.setColumns(20);
        textAreaDescripcion.setRows(5);
        textAreaDescripcion.setText("");
        scrollPanel3.setViewportView(textAreaDescripcion);

        javax.swing.GroupLayout panelDegradado4Layout = new javax.swing.GroupLayout(panelDegradado4);
        panelDegradado4.setLayout(panelDegradado4Layout);
        panelDegradado4Layout.setHorizontalGroup(
            panelDegradado4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDegradado4Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(panelDegradado4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(comboBoxCate1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scrollPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                    .addComponent(labelTitle5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(spinnerPrecio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelTitle3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textFildNombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(labelTitle1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelTitle2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelTitle4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(spinnerCantidadInventario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(40, 40, 40))
        );
        panelDegradado4Layout.setVerticalGroup(
            panelDegradado4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDegradado4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(labelTitle1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textFildNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelTitle2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spinnerPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelTitle3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboBoxCate1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelTitle4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spinnerCantidadInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelTitle5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                .addGap(32, 32, 32))
        );

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnRegresar.setText("Regresar");
        btnRegresar.setBorderPainted(true);
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelDegradadoFooterLayout = new javax.swing.GroupLayout(panelDegradadoFooter);
        panelDegradadoFooter.setLayout(panelDegradadoFooterLayout);
        panelDegradadoFooterLayout.setHorizontalGroup(
            panelDegradadoFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDegradadoFooterLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
        panelDegradadoFooterLayout.setVerticalGroup(
            panelDegradadoFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDegradadoFooterLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(panelDegradadoFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegresar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        imageView1.setPreferredSize(new java.awt.Dimension(200, 200));

        javax.swing.GroupLayout imageView1Layout = new javax.swing.GroupLayout(imageView1);
        imageView1.setLayout(imageView1Layout);
        imageView1Layout.setHorizontalGroup(
            imageView1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        imageView1Layout.setVerticalGroup(
            imageView1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 293, Short.MAX_VALUE)
        );

        labelTitle6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelTitle6.setText("URL de la Imagen del Perfume*");

        textAreaImagenURL.setColumns(20);
        textAreaImagenURL.setRows(5);
        textAreaImagenURL.setText("");
        scrollPanel1.setViewportView(textAreaImagenURL);

        btnCargarImagen.setText("Cargar imagen");
        btnCargarImagen.setBorderPainted(true);
        btnCargarImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarImagenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelDegradado1Layout = new javax.swing.GroupLayout(panelDegradado1);
        panelDegradado1.setLayout(panelDegradado1Layout);
        panelDegradado1Layout.setHorizontalGroup(
            panelDegradado1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDegradado1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imageView1, javax.swing.GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(panelDegradado1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(panelDegradado1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDegradado1Layout.createSequentialGroup()
                        .addComponent(btnCargarImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelDegradado1Layout.createSequentialGroup()
                        .addGroup(panelDegradado1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(scrollPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
                            .addComponent(labelTitle6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(40, 40, 40))))
        );
        panelDegradado1Layout.setVerticalGroup(
            panelDegradado1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDegradado1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(labelTitle6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCargarImagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(imageView1, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelDegradadoFooter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelDegradado4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelDegradado1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelDegradado4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelDegradado1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelDegradadoFooter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed

        String nom = textFildNombre.getText();
        double pre = Double.parseDouble(spinnerPrecio.getValue().toString());
        int canInv = Integer.parseInt(spinnerCantidadInventario.getValue().toString());
        int cate = comboBoxCate1.getIdSelectedCategory();
        String desc = textAreaDescripcion.getText();
        String url = textAreaImagenURL.getText();

        if (nom.isEmpty() || desc.isEmpty() || url.isEmpty()) {
            Toolkit.getDefaultToolkit().beep();
            javax.swing.JOptionPane.showMessageDialog(this, "Debe llenar todos los campos (*) \n", "AVISO", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            textFildNombre.requestFocus();
            return;
        }
        Perfumes perfumes = isEdition ? perfumeEdition : new Perfumes();

        perfumes.setName(nom);
        perfumes.setPrice(pre);
        perfumes.setInventoryQuantity(canInv);
        perfumes.setCategory_Perfume_Id(cate);
        perfumes.setDescription(desc);
        perfumes.setImage(url);

        try {
            DAOPerfumes dao = new DAOPerfumesImpl();

            if (!isEdition) {
                dao.register(perfumes);
            } else {
                dao.modify(perfumes);
            }

            String successMsg = isEdition ? "modificado" : "registrado";
            Toolkit.getDefaultToolkit().beep();
            javax.swing.JOptionPane.showMessageDialog(Dashboard.content, "Perfume " + successMsg + " exitosamente \n", "AVISO", javax.swing.JOptionPane.INFORMATION_MESSAGE);

            if (!isEdition) {
                textFildNombre.setText("");
                spinnerPrecio.setValue(0);
                spinnerCantidadInventario.setValue(0);
                textAreaDescripcion.setText("");
                textAreaImagenURL.setText("");
            }

        } catch (DataTruncation e) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(Dashboard.content, "No se pudo realizar la accion.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            String errorMsg = isEdition ? "modificar" : "registrar";
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(Dashboard.content, "Ocurrió un error al " + errorMsg + " el perfume \n", "Error", JOptionPane.ERROR_MESSAGE);
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        Dashboard.ShoJPanel(new VerPerfume());
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnCargarImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarImagenActionPerformed
        imageView1.loadBackgroundImage(textAreaImagenURL.getText());
    }//GEN-LAST:event_btnCargarImagenActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.mywebmanager.swings.JComponents.BotonColor btnCargarImagen;
    private com.mywebmanager.swings.JComponents.BotonColor btnRegistrar;
    private com.mywebmanager.swings.JComponents.BotonColor btnRegresar;
    private com.mywebmanager.swings.ComboBoxCate comboBoxCate1;
    private com.mywebmanager.swings.ImageView imageView1;
    private com.mywebmanager.swings.JComponents.Label.LabelTitle labelTitle1;
    private com.mywebmanager.swings.JComponents.Label.LabelTitle labelTitle2;
    private com.mywebmanager.swings.JComponents.Label.LabelTitle labelTitle3;
    private com.mywebmanager.swings.JComponents.Label.LabelTitle labelTitle4;
    private com.mywebmanager.swings.JComponents.Label.LabelTitle labelTitle5;
    private com.mywebmanager.swings.JComponents.Label.LabelTitle labelTitle6;
    private com.mywebmanager.swings.JComponents.PanelDegradado panelDegradado1;
    private com.mywebmanager.swings.JComponents.PanelDegradado panelDegradado4;
    private com.mywebmanager.swings.JComponents.PanelDegradado panelDegradadoFooter;
    private com.mywebmanager.swings.JComponents.ScrollPanel scrollPanel1;
    private com.mywebmanager.swings.JComponents.ScrollPanel scrollPanel3;
    private com.mywebmanager.swings.JComponents.Spinner spinnerCantidadInventario;
    private com.mywebmanager.swings.JComponents.Spinner spinnerPrecio;
    private com.mywebmanager.swings.JComponents.TextAreaTransparente textAreaDescripcion;
    private com.mywebmanager.swings.JComponents.TextAreaTransparente textAreaImagenURL;
    private com.mywebmanager.swings.TextFild textFildNombre;
    // End of variables declaration//GEN-END:variables
}
