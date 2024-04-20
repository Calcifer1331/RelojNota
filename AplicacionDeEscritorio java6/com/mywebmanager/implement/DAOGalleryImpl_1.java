package com.mywebmanager.implement;

import com.mywebmanager.db.Database;
import com.mywebmanager.interfaces.DAOGallery;
import com.mywebmanager.models.Category_Perfume;
import com.mywebmanager.models.Gallery;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DAOGalleryImpl extends Database implements DAOGallery {

    @Override
    public void modify(Gallery object) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.conexion.prepareStatement("UPDATE Gallery SET `Image` = ? WHERE `Id` = 1");
            st.setString(1, object.getImage());
            st.executeUpdate();
            st.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public Gallery getGallery() {
        Gallery object = new Gallery();
        try {
            this.Conectar();
            PreparedStatement st = this.conexion.prepareStatement("SELECT * FROM Gallery WHERE `Id` = 1 LIMIT 1");

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                object.setId(rs.getInt("Id"));
                object.setImage(rs.getString("Image"));
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
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
