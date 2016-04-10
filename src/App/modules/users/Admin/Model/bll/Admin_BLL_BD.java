/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App.modules.users.Admin.Model.bll;

import App.classes.BD_Connection;
import App.modules.users.Admin.Model.Classes.Admin;
import App.modules.users.Admin.Model.dao.Admin_DAO_BD;
import java.sql.Connection;
import javax.swing.JOptionPane;

/**
 *
 * @author Jorge
 */
public class Admin_BLL_BD {
    
     public static int New_Admin_BD(Admin a) {

        int correcto;
        Connection _con = null;
        
        BD_Connection connection = new BD_Connection();
        
        _con = connection.AbrirConexion();

        correcto = Admin_DAO_BD.new_admin_BD(_con, a);

        connection.CerrarConexion(_con);

        return correcto;
    }
    
      public static void Charge_admin_BD() {

        Connection _con = null;
        BD_Connection connection = new BD_Connection();

         _con = connection.AbrirConexion();
       
        Admin_DAO_BD A = new Admin_DAO_BD();
        try {
            
            A.Charge_admin_BD(_con);//Recuperamos los empleados 

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ha habido un error Logger2!");
        }
         connection.CerrarConexion(_con);

    }
    
     public static void Change_Admin_BLL(Admin a) {

        Connection _con;

        BD_Connection connection = new BD_Connection();

         _con = connection.AbrirConexion();
         
         Admin_DAO_BD A = new Admin_DAO_BD();

         A.Change_Admin_DAO(_con, a);
        
        connection.CerrarConexion(_con);

    }
      
      
      
}
