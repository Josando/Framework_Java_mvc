/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App.classes;

import App.utils.Singleton_App;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author Jorge
 */
public class Mongo_BD_conection {
    
     private static Properties prop = new Properties();
    private static InputStream input = null;
    private static String machine = null;
    private static String port = null;
    //private static Mongo client = null;
   // private static DB db = null;
    //private static String nom_bd = null;
   // private static DBCollection collection = null;
   // private static String nom_table = null;
   
    public Mongo_BD_conection() {
        try {
            input = new FileInputStream("src/App/classes/Mongo_properties.properties"); 
            try {
                prop.load(input);
            } catch (Exception e) {
                System.out.println("Unable to open mongo.properties");
                e.printStackTrace();
            }
            machine = prop.getProperty("machine");
            port = prop.getProperty("port");
            Singleton_App.nom_bd = prop.getProperty("db");
            Singleton_App.nom_table = prop.getProperty("collection");      
        } catch (FileNotFoundException e) {
            System.out.println("Unable to open mongo.properties");
            e.printStackTrace();
        }finally {
            if (input != null) {
		try {
                    input.close();
		} catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Unable to close mongo.properties"); 
		}
            }
	}
    }
    
    public static Mongo connect() {
        try {
            Singleton_App.client = new Mongo(getMachine(), Integer.parseInt(getPort()));
            Singleton_App.db = Singleton_App.client.getDB(getNom_bd());
            Singleton_App.collection = Singleton_App.db.getCollection(getNom_table());
        } catch (Exception e) {
            System.out.println("Unable to open client");
            e.printStackTrace();
            if (Singleton_App.client != null) {
		try {
                    Singleton_App.client.close();
		} catch (Exception ex) {
                    System.out.println("Unable to close client");
                    ex.printStackTrace();
		}
            }
	}
        return Singleton_App.client;
    }
    
    public static void disconnect() {
	Singleton_App.client.close();
    }

    public static Properties getProp() {
        return prop;
    }

    public static InputStream getInput() {
        return input;
    }

    public static Mongo getClient() {
        return Singleton_App.client;
    }

    public static DB getDb() {
        return Singleton_App.db;
    }

    public static DBCollection getCollection() {
        return Singleton_App.collection;
    }

    public static void setProp(Properties prop) {
        Mongo_BD_conection.prop = prop;
    }

    public static void setInput(InputStream input) {
        Mongo_BD_conection.input = input;
    }

    public static void setClient(Mongo client) {
        Singleton_App.client = client;
    }

    public static void setDb(DB db) {
        Singleton_App.db = db;
    }

    public static void setCollection(DBCollection collection) {
        Singleton_App.collection = collection;
    }

    public static String getNom_bd() {
        return Singleton_App.nom_bd;
    }

    public static void setNom_bd(String nom_bd) {
        Singleton_App.nom_bd = nom_bd;
    }

    public static String getNom_table() {
        return Singleton_App.nom_table;
    }

    public static void setNom_table(String nom_table) {
        Singleton_App.nom_table = nom_table;
    }

    public static String getMachine() {
        return machine;
    }

    public static String getPort() {
        return port;
    }

    public static void setMachine(String machine) {
        Mongo_BD_conection.machine = machine;
    }

    public static void setPort(String port) {
        Mongo_BD_conection.port = port;
    }
}
    
    
    
    
    
    

