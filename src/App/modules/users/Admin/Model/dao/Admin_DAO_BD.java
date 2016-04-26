/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App.modules.users.Admin.Model.dao;

import App.classes.date_class;
import App.modules.users.Admin.Model.Classes.Admin;
import App.modules.users.Admin.Model.Classes.Singleton;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Jorge
 */
public class Admin_DAO_BD {
    
    
        public static int new_admin_BD(Connection _con, Admin a) {
       
        PreparedStatement stmt = null;
        int correcto = 0;
        try {
           
             stmt = _con.prepareStatement("INSERT INTO db_admin.admin"
                    + "(dni,nom,cognom,date_birthday,mobil,edad"
                    + ",email,avatar,usuario,password,status,incentivo,actividad,antiguedad,sueldo,Hire_date) "
                    + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                                   
            stmt.setString(1, a.getDni());
            stmt.setString(2, a.getNom());
            stmt.setString(3, a.getCognom());
            stmt.setString(4, a.getDate_birthday().toStrinng());
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
            stmt.setString(16, a.getFecha_cont().toStrinng());

            correcto = stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "El usuario ha sido dado de alta correctamente!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ha habido un problema al insertar un nuevo usuario!");
            ex.printStackTrace();
            
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Ha habido un error Logger!");
                }
            }
        }
        return correcto;
    }
    
     public void Charge_admin_BD(Connection con) {

        ResultSet rs = null;
        PreparedStatement stmt = null;       
        
        Singleton.ad.clear();
        try {
            stmt = con.prepareStatement("SELECT * FROM db_admin.admin");
            rs = stmt.executeQuery();

            Admin a = null;

            while (rs.next()) {
                
                a = new Admin();
                
          
            a.setDni(rs.getString("dni"));     
            
            a.setNom(rs.getString("nom")); 
           
            a.setCognom(rs.getString("cognom")); 
           
            a.setDate_birthday(new date_class(rs.getString("date_birthday"),"")); 
          
            a.setMobil(rs.getString("mobil"));
            
            a.setAge(rs.getInt("edad"));
           
            a.setEmail(rs.getString("email"));
           
            a.setAvatar(rs.getString("avatar"));
           
            a.setUser(rs.getString("usuario"));
           
            a.setPass(rs.getString("password"));
           
            a.setstatus(rs.getString("status"));
            
            a.setbenefits(rs.getFloat("incentivo"));
            
            a.setActividad(rs.getInt("actividad"));
           
            a.setAntiguedad(rs.getInt("antiguedad"));
           
            a.setSueldo(rs.getInt("sueldo"));
           
            a.setFecha_cont(new date_class(rs.getString("Hire_date"),""));    
            
            Singleton.ad.add(a);

            
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ha habido un problema al obtener los usuarios!");
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Ha habido un error Logger!");
                }
            }
        }
    }
        
        public int Change_Admin_DAO(Connection con, Admin a) {
        PreparedStatement stmt = null;
       int correcto = 0;
       
        try {
                      
            stmt = con.prepareStatement("UPDATE db_admin.admin SET dni=?, "
                    + "nom=?, cognom=?, date_birthday=?, mobil=?, edad=?, email=?, avatar=?, usuario=?,"
                    + "password=?, status=?, incentivo=?, actividad=?, antiguedad=?, "
                    + "sueldo=?, Hire_date=? WHERE dni=?");

                                   
            stmt.setString(1, a.getDni());
            stmt.setString(2, a.getNom());
            stmt.setString(3, a.getCognom());
            stmt.setString(4, a.getDate_birthday().toStrinng());
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
            stmt.setString(16, a.getFecha_cont().toStrinng());

            stmt.setString(17, a.getDni());
            correcto=stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "El usuario ha sido modificado correctamente!");
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ha habido un problema al actualizar el usuario!");
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Ha habido un error Logger!");
                }
            }
        }
    return correcto;
    }
        
        
    public int Delete_Admin_DAO(Connection con, String Id) {

        PreparedStatement stmt = null;
        int correcto = 0;

        try {
            stmt = con.prepareStatement("DELETE FROM db_admin.admin WHERE DNI=?");
            stmt.setString(1, Id);
        correcto = stmt.executeUpdate();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ha habido un error al eliminar el usuario!");
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error en el Logger!");
                }
            }
        }
        return correcto;
    }
    
}
