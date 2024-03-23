package com.mywebmanager.swings;

import com.mywebmanager.implement.DAOCategoria_PerfumeImpl;
import com.mywebmanager.interfaces.DAOCategoria_Perfume;
import com.mywebmanager.models.Category_Perfume;
import com.mywebmanager.swings.JComponents.ComboBox;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.ListCellRenderer;
import java.awt.Component;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JList;

public class ComboBoxCate extends ComboBox<Category_Perfume> {

    private DefaultComboBoxModel<Category_Perfume> comboBoxModel;

    public ComboBoxCate() {
        super();
        cargarCategorias();
    }

    public int getIdSelectedCategory() {
        Category_Perfume selectedCategory = (Category_Perfume) getSelectedItem();
        return (selectedCategory != null) ? selectedCategory.getId() : -1;
    }
    
    public void selectCategoryById(int categoryId) {
        for (int i = 0; i < getItemCount(); i++) {
            Category_Perfume category = getItemAt(i);
            if (category.getId() == categoryId) {
                setSelectedIndex(i);
                return; // Termina el bucle si encuentra la categoría
            }
        }
        // Si no se encuentra la categoría, puedes manejarlo según tus necesidades (por ejemplo, lanzar una excepción)
    }


    private void cargarCategorias() {
        try {
            DAOCategoria_Perfume daoCategoriaPerfume = new DAOCategoria_PerfumeImpl();
            List<Category_Perfume> categorias = daoCategoriaPerfume.list();
            comboBoxModel = new DefaultComboBoxModel<>(categorias.toArray(new Category_Perfume[0]));
            setModel(comboBoxModel);
            setRenderer(new CategoryRenderer());
        } catch (Exception ex) {
            Logger.getLogger(ComboBoxCate.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static class CategoryRenderer extends JLabel implements ListCellRenderer<Category_Perfume> {

        @Override
        public Component getListCellRendererComponent(JList<? extends Category_Perfume> list,
                                                      Category_Perfume value, int index, boolean isSelected, boolean cellHasFocus) {
            setText((value != null) ? value.getName() : "");
            return this;
        }
    }
}
