package com.mywebmanager.views;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.mysql.cj.exceptions.DataConversionException;
import com.mywebmanager.ilib.Dashboard;
import com.mywebmanager.implement.DAOCategoria_PerfumeImpl;
import com.mywebmanager.interfaces.DAOCategoria_Perfume;
import com.mywebmanager.models.Category_Perfume;
import com.mywebmanager.models.Perfumes;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

public class UpCategorias extends javax.swing.JPanel {

    int a = 10;
    
    boolean isEdition = false;
    Category_Perfume categoryEdition;
    private FlatSVGIcon svgIcon;

    public UpCategorias() {
        initComponents();
        InitStyles();
    }

    public UpCategorias(Category_Perfume category_Perfume) {
        initComponents();
        isEdition = true;
        categoryEdition = category_Perfume;
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
            if (categoryEdition != null) {
                textFildNombre.setText(categoryEdition.getName());
                textAreaDescripcion.setText(categoryEdition.getDescription());
                textAreaImagenURL.setText(categoryEdition.getImage());
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelDegradado4 = new com.mywebmanager.swings.JComponents.PanelDegradado();
        textFildNombre = new com.mywebmanager.swings.TextFild();
        labelTitle1 = new com.mywebmanager.swings.JComponents.Label.LabelTitle();
        labelTitle5 = new com.mywebmanager.swings.JComponents.Label.LabelTitle();
        scrollPanel3 = new com.mywebmanager.swings.JComponents.ScrollPanel();
        textAreaDescripcion = new com.mywebmanager.swings.JComponents.TextAreaTransparente();
        labelTitle6 = new com.mywebmanager.swings.JComponents.Label.LabelTitle();
        scrollPanel1 = new com.mywebmanager.swings.JComponents.ScrollPanel();
        textAreaImagenURL = new com.mywebmanager.swings.JComponents.TextAreaTransparente();
        btnCargarImagen = new com.mywebmanager.swings.JComponents.BotonColor();
        panelDegradadoFooter = new com.mywebmanager.swings.JComponents.PanelDegradado();
        btnRegistrar = new com.mywebmanager.swings.JComponents.BotonColor();
        btnRegresar = new com.mywebmanager.swings.JComponents.BotonColor();
        panelDegradado1 = new com.mywebmanager.swings.JComponents.PanelDegradado();
        imageView1 = new com.mywebmanager.swings.ImageView();

        setOpaque(false);

        labelTitle1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelTitle1.setText("Nombre de la Categoria*");

        labelTitle5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelTitle5.setText("Descripcion de la Categoria");

        textAreaDescripcion.setColumns(20);
        textAreaDescripcion.setRows(5);
        textAreaDescripcion.setText("");
        scrollPanel3.setViewportView(textAreaDescripcion);

        labelTitle6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelTitle6.setText("URL de la Imagen de la Categoria*");

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

        javax.swing.GroupLayout panelDegradado4Layout = new javax.swing.GroupLayout(panelDegradado4);
        panelDegradado4.setLayout(panelDegradado4Layout);
        panelDegradado4Layout.setHorizontalGroup(
            panelDegradado4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDegradado4Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(panelDegradado4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDegradado4Layout.createSequentialGroup()
                        .addComponent(btnCargarImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelDegradado4Layout.createSequentialGroup()
                        .addGroup(panelDegradado4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(scrollPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(labelTitle6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(scrollPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(labelTitle5, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                            .addComponent(textFildNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(labelTitle1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(40, 40, 40))))
        );
        panelDegradado4Layout.setVerticalGroup(
            panelDegradado4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDegradado4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(labelTitle1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textFildNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelTitle5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(scrollPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(labelTitle6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnCargarImagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79))
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
                .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            .addGap(0, 336, Short.MAX_VALUE)
        );
        imageView1Layout.setVerticalGroup(
            imageView1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelDegradado1Layout = new javax.swing.GroupLayout(panelDegradado1);
        panelDegradado1.setLayout(panelDegradado1Layout);
        panelDegradado1Layout.setHorizontalGroup(
            panelDegradado1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDegradado1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imageView1, javax.swing.GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelDegradado1Layout.setVerticalGroup(
            panelDegradado1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDegradado1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imageView1, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
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
        String desc = textAreaDescripcion.getText();
        String url = textAreaImagenURL.getText();

        //validacion de campos
        if (nom.isEmpty() || desc.isEmpty() || url.isEmpty()) {
            Toolkit.getDefaultToolkit().beep();
            javax.swing.JOptionPane.showMessageDialog(Dashboard.content, "Debe llenar todos los campos (*) \n", "AVISO", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            textFildNombre.requestFocus();
            return;
        }
        Category_Perfume category_Perfume = isEdition ? categoryEdition : new Category_Perfume();

        category_Perfume.setName(nom);
        category_Perfume.setDescription(desc);
        category_Perfume.setImage(url);

        try {
            DAOCategoria_Perfume dao = new DAOCategoria_PerfumeImpl();

            if (!isEdition) {
                dao.register(category_Perfume);
            } else {
                dao.modify(category_Perfume);
            }

            String successMsg = isEdition ? "modificado" : "registrado";
            Toolkit.getDefaultToolkit().beep();
            javax.swing.JOptionPane.showMessageDialog(Dashboard.content, "Categoria " + successMsg + " exitosamente \n", "AVISO", javax.swing.JOptionPane.INFORMATION_MESSAGE);

            if (!isEdition) {
                textFildNombre.setText("");
                textAreaDescripcion.setText("");
                textAreaImagenURL.setText("");
            }

        } catch (DataConversionException e) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(Dashboard.content, "No se pudo realizar la accion.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            String errorMsg = isEdition ? "modificar" : "registrar";
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(Dashboard.content, "Ocurrió un error al " + errorMsg + " la Categoria \n", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        Dashboard.ShoJPanel(new VerCategoria());
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnCargarImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarImagenActionPerformed
        imageView1.loadBackgroundImage(textAreaImagenURL.getText());
    }//GEN-LAST:event_btnCargarImagenActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.mywebmanager.swings.JComponents.BotonColor btnCargarImagen;
    private com.mywebmanager.swings.JComponents.BotonColor btnRegistrar;
    private com.mywebmanager.swings.JComponents.BotonColor btnRegresar;
    private com.mywebmanager.swings.ImageView imageView1;
    private com.mywebmanager.swings.JComponents.Label.LabelTitle labelTitle1;
    private com.mywebmanager.swings.JComponents.Label.LabelTitle labelTitle5;
    private com.mywebmanager.swings.JComponents.Label.LabelTitle labelTitle6;
    private com.mywebmanager.swings.JComponents.PanelDegradado panelDegradado1;
    private com.mywebmanager.swings.JComponents.PanelDegradado panelDegradado4;
    private com.mywebmanager.swings.JComponents.PanelDegradado panelDegradadoFooter;
    private com.mywebmanager.swings.JComponents.ScrollPanel scrollPanel1;
    private com.mywebmanager.swings.JComponents.ScrollPanel scrollPanel3;
    private com.mywebmanager.swings.JComponents.TextAreaTransparente textAreaDescripcion;
    private com.mywebmanager.swings.JComponents.TextAreaTransparente textAreaImagenURL;
    private com.mywebmanager.swings.TextFild textFildNombre;
    // End of variables declaration//GEN-END:variables
}
