package com.mywebmanager.implement;

import com.mywebmanager.db.Database;
import com.mywebmanager.interfaces.DAOCategoria_Perfume;
import com.mywebmanager.interfaces.DAOPerfumes;
import com.mywebmanager.models.Category_Perfume;
import com.mywebmanager.models.Perfumes;
import java.util.List;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSet;

public class DAOPerfumesImpl extends Database implements DAOPerfumes {

    @Override
    public void register(Perfumes object) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.conexion.prepareStatement("INSERT INTO Perfumes (`Name`, `Image`,`Description`,`Price`,`InventoryQuantity`, `Category_Perfume_Id`) VALUES(?,?,?,?,?,?)");
            st.setString(1, object.getName());
            st.setString(2, object.getImage());
            st.setString(3, object.getDescription());
            st.setDouble(4, object.getPrice());
            st.setInt(5, object.getInventoryQuantity());
            st.setInt(6, object.getCategory_Perfume_Id());
            st.executeUpdate();
            st.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public void modify(Perfumes object) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.conexion.prepareStatement("UPDATE Perfumes SET `Name` = ?, `Image` = ?, `Description` = ?, `Price` = ?, `InventoryQuantity` = ?, `Category_Perfume_Id` = ?  WHERE `Id` = ?");
            st.setString(1, object.getName());
            st.setString(2, object.getImage());
            st.setString(3, object.getDescription());
            st.setDouble(4, object.getPrice());
            st.setInt(5, object.getInventoryQuantity());
            st.setInt(6, object.getCategory_Perfume_Id());
            st.setInt(7, object.getId());
            st.executeUpdate();
            st.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public List<Perfumes> list(int optionSearch, String valueSearch) throws Exception {
        List<Perfumes> lista = null;
        try {
            String codigosql;
            if (optionSearch > 0 && optionSearch <= 4 && valueSearch != null) {
                codigosql = "SELECT * FROM Perfumes WHERE ";
                switch (optionSearch) {
                    case 1:
                        codigosql += "`Name` LIKE ?";
                        valueSearch = "%" + valueSearch + "%";
                        break;
                    case 2:
                        codigosql += "`Price` LIKE ?";
                        valueSearch = "%" + valueSearch + "%"; // Modificación para la búsqueda de semejanza
                        break;
                    case 3:
                        codigosql += "`InventoryQuantity` LIKE ?";
                        valueSearch = "%" + valueSearch + "%"; // Modificación para la búsqueda de semejanza
                        break;
                    case 4:
                        codigosql += "`DateAdded` LIKE ?";
                        valueSearch = "%" + valueSearch + "%"; // Modificación para la búsqueda de semejanza
                        break;
                }
            } else {
                codigosql = "SELECT * FROM Perfumes";
            }

            this.Conectar();
            PreparedStatement st = this.conexion.prepareStatement(codigosql);
            if (optionSearch > 0 && optionSearch <= 4 && valueSearch != null) {
                st.setString(1, valueSearch);
            }

            lista = new ArrayList();
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Perfumes object = new Perfumes();
                object.setId(rs.getInt("Id"));
                object.setName(rs.getString("Name"));
                object.setImage(rs.getString("Image"));
                object.setDescription(rs.getString("Description"));
                object.setPrice(rs.getDouble("Price"));
                object.setInventoryQuantity(rs.getInt("InventoryQuantity"));
                object.setDateAdded(rs.getDate("DateAdded"));
                object.setCategory_Perfume_Id(rs.getInt("Category_Perfume_Id"));
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
    public void delete(int perfumeId) throws Exception {
        try {
            this.Conectar();
            this.conexion.setAutoCommit(false); // Inicia la transacción

            // Eliminar el registro de Perfumes
            try (PreparedStatement st = this.conexion.prepareStatement("DELETE FROM Perfumes WHERE `Id` = ?")) {
                st.setInt(1, perfumeId);
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
    public Perfumes getPerfumeById(int perfumeId) throws Exception {
        Perfumes object = new Perfumes();
        try {
            this.Conectar();
            PreparedStatement st = this.conexion.prepareStatement("SELECT * FROM Perfumes WHERE `Id` = ? LIMIT 1");
            st.setInt(1, perfumeId);

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                object.setId(rs.getInt("Id"));
                object.setName(rs.getString("Name"));
                object.setImage(rs.getString("Image"));
                object.setDescription(rs.getString("Description"));
                object.setPrice(rs.getDouble("Price"));
                object.setInventoryQuantity(rs.getInt("InventoryQuantity"));
                object.setDateAdded(rs.getDate("DateAdded"));
                object.setCategory_Perfume_Id(rs.getInt("Category_Perfume_Id"));
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            e.printStackTrace();  // Agrega esta línea para imprimir el seguimiento de la pila
        } finally {
            this.Cerrar();
        }
        return object;
    }

}
