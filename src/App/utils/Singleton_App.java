/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App.utils;

import App.classes.Mongo_BD_conection;
import App.modules.users.Client.Model.Classes.Client;
import App.modules.users.User_reg.Model.Classes.User_reg;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import org.apache.commons.dbcp.BasicDataSource;


/**
 *
 * @author Jorge
 */
public class Singleton_App {
    
    public static ImageIcon ok = new ImageIcon("src/App/utils/img_app/img/Ok.png");
    public static ImageIcon cancel = new ImageIcon("src/App/utils/img_app/img/Cancel.png");
    public static String ruta_imagen;
    public static BasicDataSource dataSource;
    public static final Logger log = Logger.getLogger("BD_Connection");
    public static Mongo_BD_conection mongo;
    public static Mongo client;
    public static String nom_bd;
    public static DB db;
    public static String nom_table;
    public static DBCollection collection;
    public static Client c;
    public static User_reg u;
    public static String model_type;
    
    
}
