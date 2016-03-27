package App.modules.users.Admin.Model.Files.File_utils.utils;

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
import App.modules.users.Admin.Model.Classes.Admin;
import App.modules.users.Client.Model.Classes.Client;
import App.modules.users.Admin.Model.Classes.Singleton;
import App.modules.users.User.User;
import App.modules.users.User_reg.Model.Classes.User_reg;

public class xml {

	
	 private static final String ENCODING = "UTF-8";

	 //Para Admin
	 
	    public static void save_admin_xml() {
	    	
	        String PATH=null;
	        
			try {
				
				OutputStream os = new ByteArrayOutputStream();
				
				OutputStreamWriter osw = new OutputStreamWriter(os);
				
				XStream xstream = new XStream();
				
				Annotations.configureAliases(xstream, Admin.class);

	            String header = "<?xml version=\"1.0\" encoding=\"" + ENCODING + "\"?>\n";
	            
	            xstream.toXML(Singleton.ad, osw);
	            
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
	    
	    public static ArrayList<Admin> open_admin_xml() {
	    	
	    	String PATH=null;
	    	
	    	try {
	    		
	            XStream xstream = new XStream();
	            
	            Annotations.configureAliases(xstream, Admin.class);
	 
	            JFileChooser fileChooser = new JFileChooser();
	            
	            fileChooser.setAcceptAllFileFilterUsed(false);
	            fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("XML (*.xml)", "xml"));
	            
	            int seleccion = fileChooser.showOpenDialog(null);
	            
	            if (seleccion == JFileChooser.APPROVE_OPTION) {
	            	
	            	File JFC = fileChooser.getSelectedFile();
	            	
	                PATH = JFC.getAbsolutePath();
	                
	                Singleton.ad = (ArrayList <Admin>)xstream.fromXML(new FileReader(PATH));
	            }
	            
	        } catch (Exception e1) {
	        	
	        	JOptionPane.showMessageDialog(null, "Error al leer el XML", "Error", JOptionPane.ERROR_MESSAGE);
	        }
	        return Singleton.ad;
	    }
	
	    ////////////////////////////////////////////
	    
	    	    
	    //////////////////////////////////////////
 
	    /////////////////////////////////////////
	    
	    public static void auto_open_Admin_xml() {
	        String PATH;

	        try {
	            XStream xstream = new XStream();
	            Annotations.configureAliases(xstream, Admin.class);

	            PATH = new java.io.File(".").getCanonicalPath()
	                    + "/src/App/Modules/users/Admin/Model/Files/admin_files/admin.xml";

	            File path = new File(PATH);

	            if (path.exists()) {
	                Singleton.ad = (ArrayList<Admin>) xstream.fromXML(new FileReader(PATH));
	            }

	        } catch (IOException e) {
	             JOptionPane.showMessageDialog(null, "Error al leer el XML.ADMIN",
	             "Error", JOptionPane.ERROR_MESSAGE);
	        }
	        
	        	        
	    }
	    
	    	    	
	    	
	    
	   
	    
}
