package com.mywebmanager.implement;

import com.mywebmanager.db.Database;
import com.mywebmanager.interfaces.DAOCategoria_Perfume;
import com.mywebmanager.models.Category_Perfume;
import com.mywebmanager.models.Perfumes;
import java.sql.PreparedStatement;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOCategoria_PerfumeImpl extends Database implements DAOCategoria_Perfume {

    @Override
    public void register(Category_Perfume object) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.conexion.prepareStatement("INSERT INTO Category_Perfume (`Name`, `Image`, `Description`) VALUES(?,?,?)");
            st.setString(1, object.getName());
            st.setString(2, object.getImage());
            st.setString(3, object.getDescription());
            st.executeUpdate();
            st.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public void modify(Category_Perfume object) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.conexion.prepareStatement("UPDATE Category_Perfume SET `Name` = ?, `Image` = ?, `Description` = ? WHERE `Id` = ?");
            st.setString(1, object.getName());
            st.setString(2, object.getImage());
            st.setString(3, object.getDescription());
            st.setInt(4, object.getId());
            st.executeUpdate();
            st.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public void delete(int Category_Perfume_Id) throws Exception {
        try {
            this.Conectar();
            this.conexion.setAutoCommit(false); // Inicia la transacción

            // Eliminar el registro de Perfumes
            try (PreparedStatement st = this.conexion.prepareStatement("DELETE FROM Category_Perfume WHERE `Id` = ?")) {
                st.setInt(1, Category_Perfume_Id);
                st.executeUpdate();
            }

            this.conexion.commit(); // Confirma la transacción
        } catch (Exception e) {
            // En caso de error, realiza un rollback para revertir los cambios
            if (this.conexion != null) {
                this.conexion.rollback();
            }
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public List<Category_Perfume> list() throws Exception {
        List<Category_Perfume> lista = null;
        try {

            this.Conectar();
            PreparedStatement st = this.conexion.prepareStatement("SELECT * FROM Category_Perfume");

            lista = new ArrayList();
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Category_Perfume object = new Category_Perfume();
                object.setId(rs.getInt("Id"));
                object.setName(rs.getString("Name"));
                object.setImage(rs.getString("Image"));
                object.setDescription(rs.getString("Description"));
                object.setDateAdded(rs.getDate("DateAdded"));
                lista.add(object);
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            e.printStackTrace();  // Agrega esta línea para imprimir el seguimiento de la pila
        } finally {
            this.Cerrar();
        }
        return lista;
    }

    @Override
    public Category_Perfume getCategoria_PerfumeById(int Category_Perfume_Id){
        Category_Perfume object = new Category_Perfume();
        try {
            this.Conectar();
            PreparedStatement st = this.conexion.prepareStatement("SELECT * FROM Category_Perfume WHERE `Id` = ? LIMIT 1");
            st.setInt(1, Category_Perfume_Id);

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                object.setId(rs.getInt("Id"));
                object.setName(rs.getString("Name"));
                object.setImage(rs.getString("Image"));
                object.setDescription(rs.getString("Description"));
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            e.printStackTrace();  // Agrega esta línea para imprimir el seguimiento de la pila
        } finally {
            try {
                this.Cerrar();
            } catch (SQLException ex) {
                Logger.getLogger(DAOCategoria_PerfumeImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return object;
    }

}
