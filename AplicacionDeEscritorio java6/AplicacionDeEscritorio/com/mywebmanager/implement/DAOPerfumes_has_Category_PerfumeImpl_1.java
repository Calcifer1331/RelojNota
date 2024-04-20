package com.mywebmanager.implement;

import com.mywebmanager.db.Database;
import com.mywebmanager.interfaces.DAOPerfumes_has_Category_Perfume;
import com.mywebmanager.models.Perfumes_has_Category_Perfume;
import java.sql.PreparedStatement;

public class DAOPerfumes_has_Category_PerfumeImpl extends Database implements DAOPerfumes_has_Category_Perfume {

    @Override
    public void register(Perfumes_has_Category_Perfume object) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.conexion.prepareStatement("INSERT INTO Perfumes_has_Category_Perfume (`Perfumes_Id`, `Category_Perfume_Id`) VALUES(?,?)");
            st.setInt(1, object.getPerfumes_Id());
            st.setInt(2, object.getCategory_Perfume_Id());
            st.executeUpdate();
            st.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public void delete(Perfumes_has_Category_Perfume object, boolean e) throws Exception {
        try {
            this.Conectar();
            this.conexion.setAutoCommit(false); // Inicia la transacción
            // Eliminar el registro de Perfumes
            String codeSql = e ? "Perfumes_Id" : "Category_Perfume_Id";
            try (PreparedStatement st = this.conexion.prepareStatement("DELETE FROM Perfumes WHERE " + codeSql + " = ?")) {
                st.setInt(1, e ? object.getPerfumes_Id() : object.getCategory_Perfume_Id());
                st.executeUpdate();
            }

            this.conexion.commit(); // Confirma la transacción
        } catch (Exception x) {
            // En caso de error, realiza un rollback para revertir los cambios
            if (this.conexion != null) {
                this.conexion.rollback();
            }
            throw x;
        } finally {
            this.Cerrar();
        }
    }

}
