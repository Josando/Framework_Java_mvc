package App.modules.users.Client.Model.Files.File_utils.utils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collection;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.Annotations;
import App.modules.users.Client.Model.Classes.Client;
import App.modules.users.Client.Model.Classes.Singleton_cli;

public class xml_client {

	
	 private static final String ENCODING = "UTF-8";

	
	    ////////////////////////////////////////////
	    
	    public static void save_client_xml() {
	    	
	        String PATH=null;
	        
			try {
				
				OutputStream os = new ByteArrayOutputStream();
				
				OutputStreamWriter osw = new OutputStreamWriter(os);
				
				XStream xstream = new XStream();
				
				Annotations.configureAliases(xstream, Client.class);

	            String header = "<?xml version=\"1.0\" encoding=\"" + ENCODING + "\"?>\n";
	            
	            xstream.toXML(Singleton_cli.cli, osw);
	            
	            StringBuffer xml = new StringBuffer();
	            
	            xml.append(header);
	            
	            xml.append(os.toString());
	            
		    
	            JFileChooser fileChooser = new JFileChooser();
	            
	            fileChooser.setAcceptAllFileFilterUsed(false);
	            fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("XML (*.xml)", "xml"));
	            
	            int seleccion = fileChooser.showSaveDialog(null);
	            
	            if (seleccion == JFileChooser.APPROVE_OPTION) {
	            	
	            	File JFC = fileChooser.getSelectedFile();
	            	
	                PATH = JFC.getAbsolutePath();
	                
	                PATH = PATH+".xml";
	                
	                FileWriter fileXml = new FileWriter(PATH);
	                
	                fileXml.write(xml.toString());
	                
	                fileXml.close();
	                
	                osw.close();
	                
	                os.close();
	                
	                JOptionPane.showMessageDialog(null, "Archivo XML guardado con exito", "Archivo XML", JOptionPane.INFORMATION_MESSAGE);
	            }
		    }catch (Exception e1){
		    	JOptionPane.showMessageDialog(null, "Error al grabar el XML", "Error", JOptionPane.ERROR_MESSAGE);
		    } 
	    }
	    
	    public static ArrayList<Client> open_client_xml() {
 	
 	String PATH=null;
 	
 	try {
 		
         XStream xstream = new XStream();
         
         Annotations.configureAliases(xstream, Client.class);

         JFileChooser fileChooser = new JFileChooser();
         
         fileChooser.setAcceptAllFileFilterUsed(false);
         fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("XML (*.xml)", "xml"));
         
         int seleccion = fileChooser.showOpenDialog(null);
         
         if (seleccion == JFileChooser.APPROVE_OPTION) {
         	
         	File JFC = fileChooser.getSelectedFile();
         	
             PATH = JFC.getAbsolutePath();
             
             Singleton_cli.cli = (ArrayList <Client>)xstream.fromXML(new FileReader(PATH));
         }
         
     } catch (Exception e1) {
     	
     	JOptionPane.showMessageDialog(null, "Error al leer el XML", "Error", JOptionPane.ERROR_MESSAGE);
     }
     return Singleton_cli.cli;
 }
 
    
 
	    /////////////////////////////////////////
	    
	    public static void auto_open_client_xml() {
	        String PATH;

	        //////////////////Client
	        
	        
	        try {
	            XStream xstream = new XStream();
	            Annotations.configureAliases(xstream, Client.class);

	            PATH = new java.io.File(".").getCanonicalPath()
	                    + "/src/App/Modules/users/Client/Model/Files/client_files/client.xml";

	            File path = new File(PATH);

	            if (path.exists()) {
	                Singleton_cli.cli = (ArrayList<Client>) xstream.fromXML(new FileReader(PATH));
	            }

	        } catch (IOException e) {
	             JOptionPane.showMessageDialog(null, "Error al leer el XML.CLIENT",
	             "Error", JOptionPane.ERROR_MESSAGE);
	        }
	        
	        
            }        
	       	    
	    
	    public static void auto_save_client_xml() {
	 	   
	 	
	    	String PATH = null;

	       	    	
	        //////////////Client
	        
  try {
	        	
	            PATH = new java.io.File(".").getCanonicalPath()
	            		
	                    + "/src/App/Modules/users/Client/Model/Files/client_files/client.xml";
	            
	        } catch (IOException e) {
	        	
	            e.printStackTrace();
	        }

	        if (Singleton_cli.cli.size() > 0) {
	        	
	        	try {
					
					OutputStream os = new ByteArrayOutputStream();
					
					OutputStreamWriter osw = new OutputStreamWriter(os);
					
					XStream xstream = new XStream();
					
					Annotations.configureAliases(xstream, Client.class);

		            String header = "<?xml version=\"1.0\" encoding=\"" + ENCODING + "\"?>\n";
		            
		            xstream.toXML(Singleton_cli.cli, osw);
		            
		            StringBuffer xml = new StringBuffer();
		            
		            xml.append(header);
		            
		            xml.append(os.toString());	            
		                     
		                
		                FileWriter fileXml = new FileWriter(PATH);
		                
		                fileXml.write(xml.toString());
		                
		                fileXml.close();
		                
		                osw.close();
		                
		                os.close();
		                
		              		                
			    }catch (Exception e1){
			    	
			    	JOptionPane.showMessageDialog(null, "Error al grabar el XML.CLIENT", "Error", JOptionPane.ERROR_MESSAGE);
			    } 
	            
	        } else {
	        	
	            File path = new File(PATH);

	            path.delete();
	        }
	    
	        
	        
 	        
	    }

	    
	   
	    
}
