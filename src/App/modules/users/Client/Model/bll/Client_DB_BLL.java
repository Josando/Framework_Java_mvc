/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App.modules.users.Client.Model.bll;

import App.modules.users.Client.Model.Classes.Client;
import App.modules.users.Client.Model.dao.Client_DB_DAO;

/**
 *
 * @author Jorge
 */
public class Client_DB_BLL {
    
    public static void insert_Client (Client c) {
        
        Client_DB_DAO.insert_Client(c);
        
        
    }
    
public static void print_table() {
    
    Client_DB_DAO.print_table();  
    
    
}
    
public static void delete_client_by_dni(String dni){
    
    Client_DB_DAO.delete_Client_by_dni(dni);
    
}


public static void update_client(Client c){
    
    Client_DB_DAO.update_Client(c);
    
}


    
}
