package App.modules.users.Client.Model.Files.File_utils.utils;

import java.io.File;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
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

import App.modules.users.Client.Model.Classes.Client;
import App.modules.users.Client.Model.Classes.Singleton_cli;


public class json_client {

	
   public static void save_client_json() {
		
        String PATH = null;
        
	      try {
	    	  
	          XStream xstreamjson = new XStream(new JettisonMappedXmlDriver());
	          
	          xstreamjson.setMode(XStream.NO_REFERENCES);
	          
	          xstreamjson.alias("Client", Client.class);
	          
	          JFileChooser fileChooser = new JFileChooser();
	          
	          fileChooser.setAcceptAllFileFilterUsed(false);
	          fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("JSON (*.json)", "json"));
	          
	          int seleccion = fileChooser.showSaveDialog(null);
	          
	          if (seleccion == JFileChooser.APPROVE_OPTION) {
	        	  
	                File JFC = fileChooser.getSelectedFile();
	                
	                PATH = JFC.getAbsolutePath();
	                
	                PATH=PATH+ ".json";
	                	                
	                Gson gson = new Gson();
	                
		            String json = gson.toJson(Singleton_cli.cli);
		            
		            FileWriter fileXml = new FileWriter(PATH);
		            
	                fileXml.write(json.toString());
	                
	                fileXml.close(); 
	                
	                JOptionPane.showMessageDialog(null, "Archivo JSON guardado con exito", "Archivo JSON", JOptionPane.INFORMATION_MESSAGE);
	          }
        } catch (Exception e) {
        	
        	JOptionPane.showMessageDialog(null, "Error al grabar el JSON", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
                   
    
    /////////////////////////////////////////////
	
     
    public static ArrayList<Client> open_client_json() {
    	
    	String PATH = null;
    	
    	Client e1 = new Client("");
    	
        try {
        	
        	  XStream xstream = new XStream(new JettisonMappedXmlDriver());
        	  
	          xstream.setMode(XStream.NO_REFERENCES);
	          
			  xstream.alias("Client", Client.class);
			  
			  JFileChooser fileChooser = new JFileChooser();
			  
			  fileChooser.setAcceptAllFileFilterUsed(false);
	          fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("JSON (*.json)", "json"));
			  
	          int seleccion = fileChooser.showOpenDialog(null);
	          
	          if (seleccion == JFileChooser.APPROVE_OPTION) {
	        	  
	                File JFC = fileChooser.getSelectedFile();
	                
	                PATH = JFC.getAbsolutePath();
	               
	                Singleton_cli.cli.clear();
	               
	              
	                JsonReader lector = new JsonReader(new FileReader(PATH));
	                
	                JsonParser parseador = new JsonParser();
	                
	                JsonElement raiz = parseador.parse(lector);
	            		  
	            	Gson json = new Gson();
	            	
	            	JsonArray lista = raiz.getAsJsonArray();
	            	
	            	for (JsonElement elemento : lista) {
	            		
	            		e1 = json.fromJson(elemento, Client.class);
	            		
	            		Singleton_cli.cli.add(e1);
	            	}
	          } 
        } catch (Exception e) {
        	JOptionPane.showMessageDialog(null, "Error al leer el JSON", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return Singleton_cli.cli;
    }

    //////////////////////////////////////////////           
   
    

    
    public static void auto_save_Client_json() {
	   
	   
	   String PATH = null;
	   
	   	   
	   /////////////////Save Cli///////////////////////
	      
	      
	      try {
			   
	           PATH = new java.io.File(".").getCanonicalPath()
	           		
	                   + "/src/App/Modules/users/Client/Model/Files/client_files/client.json";
	           
	       } catch (IOException e) {
	       	
	           e.printStackTrace();
	       }
		          
		      try {
		    	  
		          XStream xstreamjson = new XStream(new JettisonMappedXmlDriver());
		          
		          xstreamjson.setMode(XStream.NO_REFERENCES);
		          
		          xstreamjson.alias("Client", Client.class);
		          
		          /**
		          JFileChooser fileChooser = new JFileChooser();
		          	          
		          int seleccion = fileChooser.showSaveDialog(null);
		          
		          if (seleccion == JFileChooser.APPROVE_OPTION) {
		        	  
		                File JFC = fileChooser.getSelectedFile();
		                
		                PATH = JFC.getAbsolutePath();
		                
		                PATH=PATH+ ".json";
		                	                
		                */
		                	                
		                Gson gson = new Gson();
		                
			            String json = gson.toJson(Singleton_cli.cli);
			            
			            FileWriter fileXml = new FileWriter(PATH);
			            
		                fileXml.write(json.toString());
		                
		                fileXml.close(); 
		                
		              //  JOptionPane.showMessageDialog(null, "Archivo JSON guardado con exito", "Archivo JSON", JOptionPane.INFORMATION_MESSAGE);
		        //  }
	     } catch (Exception e) {
	     	
	     	JOptionPane.showMessageDialog(null, "Error al grabar el JSON.CLIENT", "Error", JOptionPane.ERROR_MESSAGE);
	     }
	   
	  
		      
		      
		      
		      
	   
   }

    public static void auto_open_client_json(){
	   
	   
	   String PATH = null;
   	
   	
   	Client c1 = new Client();
   	
   	
   	
     
       
     ////////////////////////////open client
       
       
       try {
	    	   
        	  XStream xstream = new XStream(new JettisonMappedXmlDriver());
        	  
 	          xstream.setMode(XStream.NO_REFERENCES);
 	          
 			  xstream.alias("Client", Client.class);
 			  
 			  
 			  PATH = new java.io.File(".").getCanonicalPath()
 	                   + "/src/App/Modules/users/Client/Model/Files/client_files/client.json";
 	    	   	               
 	                Singleton_cli.cli.clear();
 	             	              
 	                JsonReader lector = new JsonReader(new FileReader(PATH));
 	                
 	                JsonParser parseador = new JsonParser();
 	                
 	                JsonElement raiz = parseador.parse(lector);
 	            		  
 	            	Gson json = new Gson();
 	            	
 	            	JsonArray lista = raiz.getAsJsonArray();
 	            	
 	            	for (JsonElement elemento : lista) {
 	            		
 	            		c1 = json.fromJson(elemento, Client.class);
 	            		
 	            		Singleton_cli.cli.add(c1);
 	            			            		
 	            			            			            		
 	            	}
 	       //   } 
        } catch (Exception e) {
     	   
        	JOptionPane.showMessageDialog(null, "Error al leer el JSON.CLIENT", "Error", JOptionPane.ERROR_MESSAGE);
        	
        }
	   	   
	   ////////////////////open user_reg//////////////////////////////
       
                            
       
   }
   
   
    public static void save_config_json() {
	   
	   
	   String PATH = null;
	   
	   try {
		   
           PATH = new java.io.File(".").getCanonicalPath()
           		
                   + "/src/App/Modules/main_menu/model/files/config_files/config.json";
           
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
	                   + "/src/App/Modules/main_menu/model/files/config_files/config.json";
	    	   
			
	              
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
