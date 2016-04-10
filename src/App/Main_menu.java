/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

import App.classes.BD_Connection;
import App.classes.date_class;
import App.modules.main_menu.Controler.Controler_main_menu;
import App.modules.main_menu.views.First_menu;
import App.modules.users.Admin.Model.Classes.Admin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Jorge
 */
public class Main_menu {
    
     //objeto singleton que contendrá la ventana activa
    
     //lo
    
    public static void main(String args[]) {
        
         //First_menu first = new First_menu();
            new Controler_main_menu(new First_menu(), 0).Start(0);
        // first.setLocationRelativeTo(null);
        // first.setVisible(true);
         
        /**
         Connection _con = null;
        BD_Connection _conexion_DB = new BD_Connection();
        PreparedStatement stmt = null;
        int resultado = 0;
        
         _con = _conexion_DB.AbrirConexion();
         
        try {
            Admin a = new Admin ("85301342P", "Pepe", "Sanchis", new date_class("30/12/1970", ""), "646543238", "Josando@gmail.com", "hdgdgfh", "Jogando", "210182", "Online", 5,  new date_class("03/04/2000", ""));
            stmt = _con.prepareStatement("INSERT INTO admin"
                    + "(dni,nom,cognom,date_birthday,mobil,edad"
                    + ",email,avatar,usuario,password,status,incentivo,actividad,antiguedad,sueldo,Hire_date) "
                    + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        
        stmt.setString(1, a.getDni());
            stmt.setString(2, a.getNom());
            stmt.setString(3, a.getCognom());
            stmt.setString(4, a.getDate_birthday().toString());
            stmt.setString(5, a.getMobil());
            stmt.setInt(6, a.getAge());
            stmt.setString(7, a.getEmail());
            stmt.setString(8, a.getAvatar());
            stmt.setString(9, a.getUser());
            stmt.setString(10, a.getPass());
            stmt.setString(11, a.getstatus());
            stmt.setFloat(12, a.getbenefits());
            stmt.setInt(13, a.getActividad());
            stmt.setInt(14, a.getAntiguedad());
            stmt.setFloat(15, a.getSueldo());
            stmt.setString(16, a.getFecha_cont().toString());
            
            
            
        stmt.executeUpdate();
        
         _conexion_DB.CerrarConexion(_con);
         
         
         } catch (SQLException ex) {
            Logger.getLogger(Main_menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        */
        
        
    }
    
    
    
}
