/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App.modules.main_menu.model.dao;

import App.modules.main_menu.views.Sign_in;
import App.modules.users.Client.Model.Classes.Client;
import App.modules.users.User_reg.Model.Classes.Singleton_user_reg;
import App.utils.Singleton_App;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import com.mongodb.DB;
import com.mongodb.DBCollection;

/**
 *
 * @author Jorge
 */
public class Sign_in_DAO {
    
       public static int Select_Admin_dni_sql(Connection con) {

        ResultSet rs = null;   
        PreparedStatement stmt = null;
        int correcto = 0;
       

        try {
            stmt = con.prepareStatement("SELECT dni FROM db_admin.admin WHERE BINARY usuario=? and BINARY password =? ");
            stmt.setString(1, Sign_in.User_txt.getText());
            stmt.setString(2, Sign_in.Pass_txt.getText());                 
          
            rs = stmt.executeQuery();
            
            rs.next();
                   
            rs.getString("dni");
                       
           
       correcto=1;
       
         
            
        } catch (SQLException ex) {
           
            //JOptionPane.showMessageDialog(null, "Usuario no esta en tabla Admin");
           
             correcto=0;
             
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
    
    public static int Select_Admin_dni_mongo() {
        DBCursor cursor = null;
        int ok = 0;
        Singleton_App.c= new Client();
        
        
        try {
           
            BasicDBObject query = new BasicDBObject();
            query.put("user", Sign_in.User_txt.getText());
            query.put("pass", Sign_in.Pass_txt.getText());
            
           // BasicDBObject searchById = new BasicDBObject();
           // searchById.append("dni", 1).append("_id",0);
            
            
            cursor = Singleton_App.collection.find(query);                       
            
            if(cursor.count()!=0){
                
                                
                while(cursor.hasNext()){  
                    
                  BasicDBObject document = (BasicDBObject) cursor.next();
                  
                
               Singleton_App.c =  Singleton_App.c.Client_to_DB(document);
                
               
                 
                  ok=1;
                   
                }
            }else{
                
                 ok=0;
                // JOptionPane.showMessageDialog(null, "Cliente no encontrado "+ ok);
               // System.out.println("NOT DATA"); 
                
            }
        } finally {
            if (cursor != null){
		cursor.close();
            }
	}
        
       // JOptionPane.showMessageDialog(null, Singleton_App.c);
        return ok;	
        
        
    }
    
     public static int search_Us_array() {
         
          int ok = 0;
          Singleton_App.u = null;
         
        for (int i = 0; i < Singleton_user_reg.us.size(); i++) {
            
           if ((Singleton_user_reg.us.get(i).getPass()).equals(Sign_in.Pass_txt.getText()) && (Singleton_user_reg.us.get(i).getUser()).equals(Sign_in.User_txt.getText()))  {
                
               
               Singleton_App.u = Singleton_user_reg.us.get(i);
               
                               
              ok=1;
              
              // JOptionPane.showMessageDialog(null, "Cliente encontrado "+ Singleton_App.u+ ok);
               
           }else{
               
               //  JOptionPane.showMessageDialog(null, "Cliente no encontrado ");
               
                 ok=0;
           }
          
          
          
        }
        return ok;
    }
    
    
    
}
