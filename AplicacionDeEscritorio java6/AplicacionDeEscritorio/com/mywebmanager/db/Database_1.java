package com.mywebmanager.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.mywebmanager.db.ConfiguracionArchivo;

public class Database {

    public String getJDBC_DRIVER() {
        return JDBC_DRIVER;
    }

    public void setJDBC_DRIVER(String JDBC_DRIVER) {
        this.JDBC_DRIVER = JDBC_DRIVER;
    }

    public String getBD_URL() {
        return BD_URL;
    }

    public void setBD_URL(String BD_URL) {
        this.BD_URL = BD_URL;
    }

    public String getUSER() {
        return USER;
    }

    public void setUSER(String USER) {
        this.USER = USER;
    }

    public String getPASS() {
        return PASS;
    }

    public void setPASS(String PASS) {
        this.PASS = PASS;
    }

    private String JDBC_DRIVER;
    private String BD_URL;

    private String USER;
    private String PASS;

    protected Connection conexion;

    public Database() {
        ConfiguracionArchivo archivo = new ConfiguracionArchivo();
        archivo.getDatabase(this);
    }

    public void Conectar() throws ClassNotFoundException {
        try {
            conexion = DriverManager.getConnection(getBD_URL(), getUSER(), getPASS());
            Class.forName(getJDBC_DRIVER());
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Cerrar() throws SQLException {
        if (conexion != null) {
            if (conexion.isClosed()) {
                conexion.close();
            }
        }
    }

    public boolean verificarConexion() {
        try {
            return conexion != null && !conexion.isClosed();
        } catch (SQLException e) {
            // Manejo de la excepción
            e.printStackTrace();
            return false;
        } finally{
            
        }
    }

}
