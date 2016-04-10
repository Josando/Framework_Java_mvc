package App.modules.users.Admin.Model.Files.File_utils.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import App.modules.main_menu.model.Config;
import App.modules.users.Admin.Model.Classes.Admin;
import App.modules.users.Admin.Model.Classes.Singleton;


public class json {

	public static void save_admin_json() {
		
        String PATH = null;
        
	      try {
	    	  
	          XStream xstreamjson = new XStream(new JettisonMappedXmlDriver());
	          
	          xstreamjson.setMode(XStream.NO_REFERENCES);
	          
	          xstreamjson.alias("Admin", Admin.class);
	          
	          JFileChooser fileChooser = new JFileChooser();
	          
	          fileChooser.setAcceptAllFileFilterUsed(false);
	          fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("JSON (*.json)", "json"));
	          
	          int seleccion = fileChooser.showSaveDialog(null);
	          
	          if (seleccion == JFileChooser.APPROVE_OPTION) {
	        	  
	                File JFC = fileChooser.getSelectedFile();
	                
	                PATH = JFC.getAbsolutePath();
	                
	                PATH=PATH+ ".json";
	                	                
	                Gson gson = new Gson();
	                
		            String json = gson.toJson(Singleton.ad);
		            
		            FileWriter fileXml = new FileWriter(PATH);
		            
	                fileXml.write(json.toString());
	                
	                fileXml.close(); 
	                
	                JOptionPane.showMessageDialog(null, "Archivo JSON guardado con exito", "Archivo JSON", JOptionPane.INFORMATION_MESSAGE);
	          }
        } catch (Exception e) {
        	
        	JOptionPane.showMessageDialog(null, "Error al grabar el JSON", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static ArrayList<Admin> open_admin_json() {
    	
    	String PATH = null;
    	
    	Admin e1 = new Admin("");
    	
        try {
        	
        	  XStream xstream = new XStream(new JettisonMappedXmlDriver());
        	  
	          xstream.setMode(XStream.NO_REFERENCES);
	          
			  xstream.alias("Admin", Admin.class);
			  
			  JFileChooser fileChooser = new JFileChooser();
			  
			  fileChooser.setAcceptAllFileFilterUsed(false);
	          fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("JSON (*.json)", "json"));
			  
	          int seleccion = fileChooser.showOpenDialog(null);
	          
	          if (seleccion == JFileChooser.APPROVE_OPTION) {
	        	  
	                File JFC = fileChooser.getSelectedFile();
	                
	                PATH = JFC.getAbsolutePath();
	               
	                Singleton.ad.clear();
	               
	              
	                JsonReader lector = new JsonReader(new FileReader(PATH));
	                
	                JsonParser parseador = new JsonParser();
	                
	                JsonElement raiz = parseador.parse(lector);
	            		  
	            	Gson json = new Gson();
	            	
	            	JsonArray lista = raiz.getAsJsonArray();
	            	
	            	for (JsonElement elemento : lista) {
	            		
	            		e1 = json.fromJson(elemento, Admin.class);
	            		
	            		Singleton.ad.add(e1);
	            	}
	            	
	            JOptionPane.showMessageDialog(null, "Cargado", "Archivo cargado con exito", JOptionPane.INFORMATION_MESSAGE );
	          } 
	          
        } catch (Exception e) {
        	JOptionPane.showMessageDialog(null, "Error al leer el JSON", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        return Singleton.ad;
    }

    /////////////////////////////////////////////
    
    
   ///////////////////////////////////////////////
   

    //////////////////////////////////////////////           
   
    

    
    public static void auto_save_Admin_json() {
	   
	   
	   String PATH = null;
	   
	   /////////Save admin//////////
	   
	   try {
		   
           PATH = new java.io.File(".").getCanonicalPath()
           		
                   + "/src/App/Modules/users/Admin/model/files/admin_files/admin.json";
           
       } catch (IOException e) {
       	
           e.printStackTrace();
       }
	          
	      try {
	    	  
	          XStream xstreamjson = new XStream(new JettisonMappedXmlDriver());
	          
	          xstreamjson.setMode(XStream.NO_REFERENCES);
	          
	          xstreamjson.alias("Admin", Admin.class);
	          
	          /**
	          JFileChooser fileChooser = new JFileChooser();
	          	          
	          int seleccion = fileChooser.showSaveDialog(null);
	          
	          if (seleccion == JFileChooser.APPROVE_OPTION) {
	        	  
	                File JFC = fileChooser.getSelectedFile();
	                
	                PATH = JFC.getAbsolutePath();
	                
	                PATH=PATH+ ".json";
	                	                
	                */
	                	                
	                Gson gson = new Gson();
	                
		            String json = gson.toJson(Singleton.ad);
		            
		            FileWriter fileXml = new FileWriter(PATH);
		            
	                fileXml.write(json.toString());
	                
	                fileXml.close(); 
	                
	               // JOptionPane.showMessageDialog(null, "Archivo JSON guardado con exito", "Archivo JSON", JOptionPane.INFORMATION_MESSAGE);
	        //  }
     } catch (Exception e) {
     	
     	JOptionPane.showMessageDialog(null, "Error al grabar el JSON.ADMIN", "Error", JOptionPane.ERROR_MESSAGE);
     }
	   
	  
		      
	   
   }

    public static void auto_open_admin_json(){
	   
	   
	   String PATH = null;
   	
   	Admin e1 = new Admin("");
   	
   	
       try {
       	    	   
       	  XStream xstream = new XStream(new JettisonMappedXmlDriver());
       	  
	          xstream.setMode(XStream.NO_REFERENCES);
	          
			  xstream.alias("Admin", Admin.class);
			  
			  
			  PATH = new java.io.File(".").getCanonicalPath()
	                   + "/src/App/Modules/users/Admin/model/files/admin_files/admin.json";
	    	   	               
	                Singleton.ad.clear();
	             	              
	                JsonReader lector = new JsonReader(new FileReader(PATH));
	                
	                JsonParser parseador = new JsonParser();
	                
	                JsonElement raiz = parseador.parse(lector);
	            		  
	            	Gson json = new Gson();
	            	
	            	JsonArray lista = raiz.getAsJsonArray();
	            	
	            	for (JsonElement elemento : lista) {
	            		
	            		e1 = json.fromJson(elemento, Admin.class);
	            		
	            		Singleton.ad.add(e1);
	            			            		
	            			            			            		
	            	}
	       //   } 
       } catch (Exception e) {
    	   
       	JOptionPane.showMessageDialog(null, "Error al leer el JSON.ADMIN", "Error", JOptionPane.ERROR_MESSAGE);
       	
       } 
       
   }
   
   
    public static void save_config_json() {
	   
	   
	   String PATH = null;
	   
	   try {
		   
           PATH = new java.io.File(".").getCanonicalPath()
           		
                   + "/src/App/modules/main_menu/model/files/config_files/config.json";
           
       } catch (IOException e) {
       	
           e.printStackTrace();
       }
	          
	      try {
	    	  
	          XStream xstreamjson = new XStream(new JettisonMappedXmlDriver());
	          
	          xstreamjson.setMode(XStream.NO_REFERENCES);
	          
	          xstreamjson.alias("Config", Config.class);
	          
	         
	                	                
	                Gson gson = new Gson();
	                
		            String json = gson.toJson(Config.getinstance());
		            
		            FileWriter fileXml = new FileWriter(PATH);
		            
	                fileXml.write(json.toString());
	                
	                fileXml.close(); 
	                
	                //JOptionPane.showMessageDialog(null, "Archivo JSON guardado con exito", "Archivo JSON", JOptionPane.INFORMATION_MESSAGE);
	        
	      } catch (Exception e) {
     	
     	JOptionPane.showMessageDialog(null, "Error al grabar el JSON.CONFIG", "Error", JOptionPane.ERROR_MESSAGE);
     }	   
	   
	   
   }
      
    public static void open_config_json(){
	   
	   
	   String PATH = null;
		Config c = null;
	 	    
    try {
    	
 	 
 	   
    	  XStream xstream = new XStream(new JettisonMappedXmlDriver());
    	  
	          xstream.setMode(XStream.NO_REFERENCES);
	          
			  xstream.alias("Config", Config.class);
			  
			  
			  PATH = new java.io.File(".").getCanonicalPath()
	                   + "/src/App/modules/main_menu/model/files/config_files/config.json";
	    	   
			
	              
	                JsonReader lector = new JsonReader(new FileReader(PATH));
	                
	                JsonParser parseador = new JsonParser();
	                
	                JsonElement raiz = parseador.parse(lector);
	            		  
	            	Gson json = new Gson();           	
	         	            			          		       			
	            	c = json.fromJson(raiz, Config.class);	           
	            	          		            	 
	            	Config.getinstance().setDate_format(c.getDate_format());
	            	Config.getinstance().setCurrency(c.getCurrency());
	            	Config.getinstance().setFile(c.getFile());
	            	Config.getinstance().setLanguage(c.getLanguage());
	            	Config.getinstance().setDecimals(c.getDecimals());
	            	Config.getinstance().setTheme(c.getTheme());
	                        	
	            	            	
	            	
	            	
    } catch (Exception e) {
 	   
    e.printStackTrace();
    	
    	
    	JOptionPane.showMessageDialog(null, "Error al leer el JSON", "Error", JOptionPane.ERROR_MESSAGE);
    	
    }
    
  //  return Singleton.ad;
	   	   
	   
}
}
