package App.modules.users.User_reg.Model.Files.File_utils.utils;

import App.modules.users.User_reg.Model.Classes.Singleton_user_reg;
import App.modules.users.User_reg.Model.Classes.User_reg;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.Annotations;


public class xml_user_reg {

	
	 private static final String ENCODING = "UTF-8";

	    	    
	    //////////////////////////////////////////
 
	    public static void save_user_reg_xml() {
	    	
	        String PATH=null;
	        
			try {
				
				OutputStream os = new ByteArrayOutputStream();
				
				OutputStreamWriter osw = new OutputStreamWriter(os);
				
				XStream xstream = new XStream();
				
				Annotations.configureAliases(xstream, User_reg.class);

	            String header = "<?xml version=\"1.0\" encoding=\"" + ENCODING + "\"?>\n";
	            
	            xstream.toXML(Singleton_user_reg.us, osw);
	            
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
	    
	    public static ArrayList<User_reg> open_user_reg_xml() {
	     	
	     	String PATH=null;
	     	
	     	try {
	     		
	             XStream xstream = new XStream();
	             
	             Annotations.configureAliases(xstream, User_reg.class);

	             JFileChooser fileChooser = new JFileChooser();
	             
	             fileChooser.setAcceptAllFileFilterUsed(false);
	             fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("XML (*.xml)", "xml"));
	             
	             int seleccion = fileChooser.showOpenDialog(null);
	             
	             if (seleccion == JFileChooser.APPROVE_OPTION) {
	             	
	             	File JFC = fileChooser.getSelectedFile();
	             	
	                 PATH = JFC.getAbsolutePath();
	                 
	                 Singleton_user_reg.us = (ArrayList <User_reg>)xstream.fromXML(new FileReader(PATH));
	             }
	             
	         } catch (Exception e1) {
	         	
	         	JOptionPane.showMessageDialog(null, "Error al leer el XML", "Error", JOptionPane.ERROR_MESSAGE);
	         }
	         return Singleton_user_reg.us;
	     }
	      
 
	    /////////////////////////////////////////
	    
	    public static void auto_open_user_reg_xml() {
	        String PATH;

	        
	        
	        ///////////////////USER_REG
	        
	        try {
	            XStream xstream = new XStream();
	            Annotations.configureAliases(xstream, User_reg.class);

	            PATH = new java.io.File(".").getCanonicalPath()
	                    + "/src/App/Modules/user/model/files/User_reg_files/user.xml";

	            File path = new File(PATH);

	            if (path.exists()) {
	                Singleton_user_reg.us = (ArrayList<User_reg>) xstream.fromXML(new FileReader(PATH));
	            }

	        } catch (IOException e) {
	             JOptionPane.showMessageDialog(null, "Error al leer el XML.USER.REG",
	             "Error", JOptionPane.ERROR_MESSAGE);
	        }
	        
	        
	        
	    }
	    
	    
	    public static void auto_save_user_reg_xml() {
	 	   
	 	
	    	String PATH = null;

	       
	        ///////////User_reg
	        
	        
	        
  try {
	        	
	            PATH = new java.io.File(".").getCanonicalPath()
	            		
	                    + "/src/App/Modules/user/model/files/User_reg_files/user.xml";
	            
	        } catch (IOException e) {
	        	
	            e.printStackTrace();
	        }

	        if (Singleton_user_reg.us.size() > 0) {
	        	
	        	try {
					
					OutputStream os = new ByteArrayOutputStream();
					
					OutputStreamWriter osw = new OutputStreamWriter(os);
					
					XStream xstream = new XStream();
					
					Annotations.configureAliases(xstream, User_reg.class);

		            String header = "<?xml version=\"1.0\" encoding=\"" + ENCODING + "\"?>\n";
		            
		            xstream.toXML(Singleton_user_reg.us, osw);
		            
		            StringBuffer xml = new StringBuffer();
		            
		            xml.append(header);
		            
		            xml.append(os.toString());	            
		                     
		                
		                FileWriter fileXml = new FileWriter(PATH);
		                
		                fileXml.write(xml.toString());
		                
		                fileXml.close();
		                
		                osw.close();
		                
		                os.close();
		                
		              		                
			    }catch (Exception e1){
			    	
			    	JOptionPane.showMessageDialog(null, "Error al grabar el XML.USER", "Error", JOptionPane.ERROR_MESSAGE);
			    } 
	            
	        } else {
	        	
	            File path = new File(PATH);

	            path.delete();
	        }
	        
	    }

	    
	   
	    
}
