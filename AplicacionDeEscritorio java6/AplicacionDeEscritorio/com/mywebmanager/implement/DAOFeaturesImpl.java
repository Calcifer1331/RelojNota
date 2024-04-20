package com.mywebmanager.implement;

import com.mywebmanager.db.Database;
import com.mywebmanager.interfaces.DAOFeatures;
import com.mywebmanager.models.Category_Perfume;
import com.mywebmanager.models.Features;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOFeaturesImpl extends Database implements DAOFeatures {

    @Override
    public void modify(Features object) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.conexion.prepareStatement("UPDATE Features SET `Icon` = ?, `Title` = ?, `Paragraph` = ? WHERE `Id` = ?");
            st.setString(1, object.getIcon());
            st.setString(2, object.getTitle());
            st.setString(3, object.getParagraph());
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
    public List<Features> list() throws Exception {
        List<Features> lista = null;
        try {

            this.Conectar();
            PreparedStatement st = this.conexion.prepareStatement("SELECT * FROM Features");

            lista = new ArrayList();
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Features object = new Features();
                object.setId(rs.getInt("Id"));
                object.setTitle(rs.getString("Title"));
                object.setIcon(rs.getString("Icon"));
                object.setParagraph(rs.getString("Paragraph"));
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
    public Features getById(int Features_Id) {
        Features object = new Features();
        try {
            this.Conectar();
            PreparedStatement st = this.conexion.prepareStatement("SELECT * FROM Features WHERE `Id` = ? LIMIT 1");
            st.setInt(1, Features_Id);

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                object.setId(rs.getInt("Id"));
                object.setTitle(rs.getString("Title"));
                object.setIcon(rs.getString("Icon"));
                object.setParagraph(rs.getString("Paragraph"));
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
