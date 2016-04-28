/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App.classes;

import App.modules.users.Admin.Model.Classes.Singleton;
import App.utils.Singleton_App;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import javax.swing.JOptionPane;
import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;

/**
 *
 * @author Jorge
 */
public class BD_Connection {

    /**
     * abrimos conexion en la base de datos
     *
     * @return
     */
    /**
     * public Connection AbrirConexion() {
     *
     * Connection con = null; try { Class.forName("com.mysql.jdbc.Driver");
     * String urlOdbc = "jdbc:mysql://127.0.0.1:3306/db_admin"; con =
     * (java.sql.DriverManager.getConnection(urlOdbc, "root", ""));
     *
     * } catch (Exception e) {
     *
     *
     * //e.printStackTrace(); JOptionPane.showMessageDialog(null, "Ha sido
     * imposible establecer la conexion!"); } return con; }
     *
     * /**
     * cerramos la conexion en la bd
     *
     * @param con
     */
    /*
    
    
    public void CerrarConexion(Connection con) {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Ha sido imposible cerrar la conexion!");
        }
    }
    
     */
    public static void initialize_BasicDataSourceFactory() {
        Properties propiedades = new Properties();
        /*
        setMaxActive(): Nº máx de conexiones que se pueden abrir simultáneamente.
        setMinIdle(): Nº mín de conexiones inactivas que queremos que haya. Si el nº de conexiones baja de este nº, se abriran más.
        setMaxIdle(): Nº máx de conexiones inactivas que queremos que haya. Si hay más, se irán cerrando.
         */
        propiedades.setProperty("driverClassName", "com.mysql.jdbc.Driver");
        propiedades.setProperty("url", "jdbc:mysql://localhost:3306/mysql");
        propiedades.setProperty("maxActive", "10");
        propiedades.setProperty("maxIdle", "8");
        propiedades.setProperty("minIdle", "0");
        propiedades.setProperty("maxWait", "5000");
        propiedades.setProperty("initialSize", "5");
        propiedades.setProperty("defaultAutoCommit", "true");
        propiedades.setProperty("username", "root");
        propiedades.setProperty("password", "");
        propiedades.setProperty("validationQuery", "select 1");
        propiedades.setProperty("validationQueryTimeout", "10000");
        propiedades.setProperty("initConnectionSqls", "SELECT 1;SELECT 2");
        propiedades.setProperty("poolPreparedStatements", "true");
        propiedades.setProperty("maxOpenPreparedStatements", "10");

        try {
            //propiedades.load(new FileInputStream("src/config/datasource_config.properties"));
            Singleton_App.dataSource = (BasicDataSource) BasicDataSourceFactory.createDataSource(propiedades);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }

    public static Connection getConection() {
        Connection conexion = null;
        try {
            conexion = Singleton_App.dataSource.getConnection();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return conexion;
    }

    public static void liberateConection(Connection conection) {
        try {
            if (null != conection) // En realidad no cierra, solo libera la conexion.
            {
                conection.close();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }

    public static void logStatistics() {
        Singleton_App.log.info("active: " + Singleton_App.dataSource.getNumActive() + " (max: "
                + Singleton_App.dataSource.getMaxActive() + ")   " + "idle: " + Singleton_App.dataSource.getNumIdle() + " (max: " + Singleton_App.dataSource.getMaxIdle() + ")\n");
    }

}
