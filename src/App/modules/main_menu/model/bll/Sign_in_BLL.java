/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App.modules.main_menu.model.bll;

import App.classes.BD_Connection;
import App.modules.main_menu.model.dao.Sign_in_DAO;
import App.utils.Singleton_App;
import java.sql.Connection;

/**
 *
 * @author Jorge
 */
public class Sign_in_BLL {
    
     public static int Select_Admin_dni() {
        
        int ok=0;
        Connection _con = null;
        
       // BD_Connection connection = new BD_Connection();
        
        //_con = connection.AbrirConexion();
        
        _con = BD_Connection.getConection();

        ok = Sign_in_DAO.Select_Admin_dni_sql(_con);

        //connection.CerrarConexion(_con);
        
        BD_Connection.liberateConection(_con);

        return ok;
    }
    
    public static int Select_Admin_dni_mongo(){
        
        int ok=0;
        
        ok = Sign_in_DAO.Select_Admin_dni_mongo();
        
        
        return ok;
    }
     
     
    public static int search_Us_dni_array() {
        int ok=0;
        
          ok=Sign_in_DAO.search_Us_dni_array();
        
       
    return ok;
            
    }
}
