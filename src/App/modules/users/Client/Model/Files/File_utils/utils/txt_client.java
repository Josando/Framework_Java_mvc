package App.modules.users.Client.Model.Files.File_utils.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import App.modules.users.Client.Model.Classes.Client;
import App.modules.users.Client.Model.Classes.Singleton_cli;

public class txt_client {
    
    ////////////////////////////////////////////////
    
    public static void save_client_txt() {
		
        String PATH = null;
        
        try {
        	
            File f;
            
            JFileChooser fileChooser = new JFileChooser();
            
            fileChooser.setAcceptAllFileFilterUsed(false);
            fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Texto (*.txt)", "txt"));
            
            int seleccion = fileChooser.showSaveDialog(null);
            
            if (seleccion == JFileChooser.APPROVE_OPTION) {
            	
                File JFC = fileChooser.getSelectedFile();
                
                PATH = JFC.getAbsolutePath();
                
                PATH = PATH + ".txt";
                
                f = new File(PATH);
                
                FileOutputStream fo=new FileOutputStream(f);
                
				ObjectOutputStream o=new ObjectOutputStream(fo);
				
				o.writeObject(Singleton_cli.cli);
				
				o.close();
				
                JOptionPane.showMessageDialog(null, "Archivo TXT guardado con exito", "Archivo TXT", JOptionPane.INFORMATION_MESSAGE);
            }
            
        } catch (Exception e) {
        	
        	JOptionPane.showMessageDialog(null, "Error al grabar el TXT", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
                    
 public static ArrayList<Client> open_client_txt() {
    	
    	String PATH = null;
    	
        try {
        	
            File f;
            
            JFileChooser fileChooser = new JFileChooser();
            
            fileChooser.setAcceptAllFileFilterUsed(false);
            fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Texto (*.txt)", "txt"));
            
            int seleccion = fileChooser.showOpenDialog(null);
            
            if (seleccion == JFileChooser.APPROVE_OPTION) {
            	
                File JFC = fileChooser.getSelectedFile();
                
                PATH = JFC.getAbsolutePath();
                
                f = new File(PATH);
                
                FileInputStream fi = new FileInputStream(f);
                
    			ObjectInputStream oi = new ObjectInputStream(fi);
    			
    			Singleton_cli.cli = (ArrayList<Client>) oi.readObject();
    			
    			oi.close();
            }
        } catch (Exception e) {
        	
        	JOptionPane.showMessageDialog(null, "Error al leer el TXT", "Error", JOptionPane.ERROR_MESSAGE);
        }
    	return Singleton_cli.cli;
    } 
    
    
    ///////////////////////////////////////////////
   
     
    
    
    /////////////////////////////////////////////
    
    public static void auto_save_txt() {
    	
    	  String PATH = null;
    	
    	  ////////////////save client
    	  
    	  try {
	            PATH = new java.io.File(".").getCanonicalPath()
	            		
	                    + "/src/App/Modules/users/Client/Model/Files/client_files/client.txt";
	            
	        } catch (IOException e) {
	        	
	            e.printStackTrace();
	        }
  	  
  	  if (Singleton_cli.cli.size() > 0) {
  	  
  		  try {
  	        	
  	            File f;
  	            
  	            	                
  	                f = new File(PATH);
  	               
  	            
  	                FileOutputStream fo=new FileOutputStream(f);
  	                
  					ObjectOutputStream o=new ObjectOutputStream(fo);
  					
  					o.writeObject(Singleton_cli.cli);
  					
  					o.close();
  					
  	                //JOptionPane.showMessageDialog(null, "Archivo TXT guardado con exito", "Archivo TXT", JOptionPane.INFORMATION_MESSAGE);
  	        
  	            
  	        } catch (Exception e) {
  	        	
  	        	JOptionPane.showMessageDialog(null, "Error al grabar el TXT.CLIENT", "Error", JOptionPane.ERROR_MESSAGE);
  	        }
       
  	  }else {
	        	
	            File path = new File(PATH);

	            path.delete();
	        }
    	 	  
  	  
    }
    
	public static void auto_open_client_txt(){
		
		String PATH = null;
    			
				
        ///////////OPEN CLIENT
    	
        try {
        	
            File f;
            
            
            PATH = new java.io.File(".").getCanonicalPath()
                    + "/src/App/Modules/users/Client/Model/Files/client_files/client.txt";

                           
                f = new File(PATH);
                
                FileInputStream fi = new FileInputStream(f);
                
    			ObjectInputStream oi = new ObjectInputStream(fi);
    			
    			Singleton_cli.cli = (ArrayList<Client>) oi.readObject();
    			
    			oi.close();    			
    			
        } catch (Exception e) {
        	
        	JOptionPane.showMessageDialog(null, "Error al leer el TXT.CLIENT", "Error", JOptionPane.ERROR_MESSAGE);
       }		
        
        }


}
