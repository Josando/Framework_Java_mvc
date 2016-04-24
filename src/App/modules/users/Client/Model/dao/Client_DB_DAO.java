/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App.modules.users.Client.Model.dao;

import App.modules.users.Client.Model.Classes.Client;
import App.modules.users.Client.Model.Classes.Singleton_cli;
import App.utils.Singleton_App;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author Jorge
 */
public class Client_DB_DAO {
    
     public static DateFormat format_fecha = new SimpleDateFormat("dd/MM/yyyy");
    
    public static void insert_Client( Client c) {
        Singleton_App.collection.insert(c.to_DB_Client());
    }
    
    /**
     * 
     */
    
     public static void print_table() {
        DBCursor cursor = null;
       // String rdo = "";
        Client c = new Client();
        
         Singleton_cli.cli.clear();
        try {
            cursor = Singleton_App.collection.find();
            if(cursor.count()!=0){
                
                while(cursor.hasNext()){
                    BasicDBObject document = (BasicDBObject) cursor.next();
                    
                   // JOptionPane.showMessageDialog(null, c.toString());
                    Singleton_cli.cli.add(c.Client_to_DB(document));
                   // JOptionPane.showMessageDialog(null, Singleton_cli.cli.toString());
                   // rdo = rdo + (c.getNombre() + " - " + w.getApellidos() + " - " +w.getEdad() + "\n");
                }
            }else{
                System.out.println("NOT DATA"); 
            }
        } finally {
            if (cursor != null){
		cursor.close();
            }
	}
        //return rdo;	
    }
   
       
   
     
     public static void delete_Client_by_dni(String dni) {
        Singleton_App.collection.remove(new BasicDBObject().append("dni", dni));
    }
    
     public static void update_Client(Client c) {
        //Prepara para insertar un nuevo campo
        BasicDBObject update = new BasicDBObject();
        
        update.append("$set", new BasicDBObject(c.to_DB_Client()));
        
        /**
        update.append("$set", new BasicDBObject().append("nom", c.getNom()) .append("cognom", c.getCognom()) 
                .append("date_birthday", c.getDate_birthday().toStrinng()) 
        .append("mobil", c.getMobil()) .append("email", c.getEmail()) .append("avatar", c.getAvatar())
                .append("user", c.getUser()) .append("pass", c.getPass())
        .append("pass", c.getPass()) .append("status", c.getstatus())
                .append("f_alta", c.getF_alta().toStrinng()) 
        .append("compra$", c.getCompra$()) .append("premium", c.isPremium()) 
                .append("client_type", c.getClient_type()) .append("benefits", c.getbenefits())
        .append("age", c.getAge()) .append("antiguedad", c.getAntiguedad()) );   
        */
                                 
        
        //Busca el/los registro/s con el nombre indicado
        BasicDBObject searchById = new BasicDBObject();
        searchById.append("dni", c.getDni());
 
        //Realiza la actualización
        Singleton_App.collection.updateMulti(searchById, update);
    }
  
    
}
