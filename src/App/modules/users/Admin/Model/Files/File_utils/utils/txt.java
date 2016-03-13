package App.modules.users.Admin.Model.Files.File_utils.utils;

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
import App.modules.users.Admin.Model.Classes.Admin;
import App.modules.users.Client.Model.Classes.Client;
import App.modules.users.Admin.Model.Classes.Singleton;
import App.modules.users.User_reg.Model.Classes.User_reg;

public class txt {

	public static void save_admin_txt() {
		
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
				
				o.writeObject(Singleton.ad);
				
				o.close();
				
                JOptionPane.showMessageDialog(null, "Archivo TXT guardado con exito", "Archivo TXT", JOptionPane.INFORMATION_MESSAGE);
            }
            
        } catch (Exception e) {
        	
        	JOptionPane.showMessageDialog(null, "Error al grabar el TXT", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static ArrayList<Admin> open_admin_txt() {
    	
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
    			
    			Singleton.ad = (ArrayList<Admin>) oi.readObject();
    			
    			oi.close();
            }
        } catch (Exception e) {
        	
        	JOptionPane.showMessageDialog(null, "Error al leer el TXT", "Error", JOptionPane.ERROR_MESSAGE);
        }
    	return Singleton.ad;
    } 
    
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
				
				o.writeObject(Singleton.cli);
				
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
    			
    			Singleton.cli = (ArrayList<Client>) oi.readObject();
    			
    			oi.close();
            }
        } catch (Exception e) {
        	
        	JOptionPane.showMessageDialog(null, "Error al leer el TXT", "Error", JOptionPane.ERROR_MESSAGE);
        }
    	return Singleton.cli;
    } 
    
    
    ///////////////////////////////////////////////
   
    
    public static void save_user_reg_txt() {
		
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
				
				o.writeObject(Singleton.us);
				
				o.close();
				
                JOptionPane.showMessageDialog(null, "Archivo TXT guardado con exito", "Archivo TXT", JOptionPane.INFORMATION_MESSAGE);
            }
            
        } catch (Exception e) {
        	
        	JOptionPane.showMessageDialog(null, "Error al grabar el TXT", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
 public static ArrayList<User_reg> open_user_reg_txt() {
    	
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
    			
    			Singleton.us = (ArrayList<User_reg>) oi.readObject();
    			
    			oi.close();
            }
        } catch (Exception e) {
        	
        	JOptionPane.showMessageDialog(null, "Error al leer el TXT", "Error", JOptionPane.ERROR_MESSAGE);
        }
    	return Singleton.us;
    } 
    
    
    /////////////////////////////////////////////
    
    public static void auto_save_txt() {
    	
    	  String PATH = null;
          
    	  try {
	            PATH = new java.io.File(".").getCanonicalPath()
	            		
	                    + "/src/App/Modules/users/Admin/Model/Files/admin_files/admin.txt";
	            
	        } catch (IOException e) {
	        	
	            e.printStackTrace();
	        }
    	  
    	  if (Singleton.ad.size() > 0) {
    	  
    		  try {
    	        	
    	            File f;
    	            
    	            	                
    	                f = new File(PATH);
    	               
    	            
    	                FileOutputStream fo=new FileOutputStream(f);
    	                
    					ObjectOutputStream o=new ObjectOutputStream(fo);
    					
    					o.writeObject(Singleton.ad);
    					
    					o.close();
    					
    	              //  JOptionPane.showMessageDialog(null, "Archivo TXT guardado con exito", "Archivo TXT", JOptionPane.INFORMATION_MESSAGE);
    	        
    	            
    	        } catch (Exception e) {
    	        	
    	        	JOptionPane.showMessageDialog(null, "Error al grabar el TXT.ADMIN", "Error", JOptionPane.ERROR_MESSAGE);
    	        	
    	        }
         
    	  }else {
	        	
	            File path = new File(PATH);

	            path.delete();
	        }
    	
    	  ////////////////save client
    	  
    	  try {
	            PATH = new java.io.File(".").getCanonicalPath()
	            		
	                    + "/src/App/Modules/users/Client/Model/Files/client_files/client.txt";
	            
	        } catch (IOException e) {
	        	
	            e.printStackTrace();
	        }
  	  
  	  if (Singleton.cli.size() > 0) {
  	  
  		  try {
  	        	
  	            File f;
  	            
  	            	                
  	                f = new File(PATH);
  	               
  	            
  	                FileOutputStream fo=new FileOutputStream(f);
  	                
  					ObjectOutputStream o=new ObjectOutputStream(fo);
  					
  					o.writeObject(Singleton.cli);
  					
  					o.close();
  					
  	                //JOptionPane.showMessageDialog(null, "Archivo TXT guardado con exito", "Archivo TXT", JOptionPane.INFORMATION_MESSAGE);
  	        
  	            
  	        } catch (Exception e) {
  	        	
  	        	JOptionPane.showMessageDialog(null, "Error al grabar el TXT.CLIENT", "Error", JOptionPane.ERROR_MESSAGE);
  	        }
       
  	  }else {
	        	
	            File path = new File(PATH);

	            path.delete();
	        }
    	  
    	/////////////////////Save user_reg
  	  
  	  
  	try {
        PATH = new java.io.File(".").getCanonicalPath()
        		
                + "/src/App/Modules/users/User_reg/Model/Files/User_reg_files/admin.txt";
        
    } catch (IOException e) {
    	
        e.printStackTrace();
    }

  	if (Singleton.us.size() > 0) {

	  try {
      	
          File f;
          
          	                
              f = new File(PATH);
             
          
              FileOutputStream fo=new FileOutputStream(f);
              
				ObjectOutputStream o=new ObjectOutputStream(fo);
				
				o.writeObject(Singleton.us);
				
				o.close();
				
           //   JOptionPane.showMessageDialog(null, "Archivo TXT guardado con exito", "Archivo TXT", JOptionPane.INFORMATION_MESSAGE);
        
          
      } catch (Exception e) {
      	
      	JOptionPane.showMessageDialog(null, "Error al grabar el TXT.USER", "Error", JOptionPane.ERROR_MESSAGE);
      }

  	}else {
    	
        File path = new File(PATH);

        path.delete();
    }
  	  
  	  
  	  
  	  
    }
    
	public static void auto_open_txt(){
		
		String PATH = null;
    	
        try {
        	
            File f;
            
            
            PATH = new java.io.File(".").getCanonicalPath()
                    + "/src/App/Modules/users/Admin/Model/Files/admin_files/admin.txt";

                           
                f = new File(PATH);
                
                FileInputStream fi = new FileInputStream(f);
                
    			ObjectInputStream oi = new ObjectInputStream(fi);
    			
    			Singleton.ad = (ArrayList<Admin>) oi.readObject();
    			
    			oi.close();    			
    			
        } catch (Exception e) {
        	
        	JOptionPane.showMessageDialog(null, "Error al leer el TXT.ADMIN	", "Error", JOptionPane.ERROR_MESSAGE);
       }		
				
        ///////////OPEN CLIENT
    	
        try {
        	
            File f;
            
            
            PATH = new java.io.File(".").getCanonicalPath()
                    + "/src/App/Modules/users/Client/Model/Files/client_files/client.txt";

                           
                f = new File(PATH);
                
                FileInputStream fi = new FileInputStream(f);
                
    			ObjectInputStream oi = new ObjectInputStream(fi);
    			
    			Singleton.cli = (ArrayList<Client>) oi.readObject();
    			
    			oi.close();    			
    			
        } catch (Exception e) {
        	
        	JOptionPane.showMessageDialog(null, "Error al leer el TXT.CLIENT", "Error", JOptionPane.ERROR_MESSAGE);
       }		
        
        
        ///////////////open_user
        
        
 try {
        	
            File f;
            
            
            PATH = new java.io.File(".").getCanonicalPath()
                    + "/src/App/Modules/users/User_reg/Model/Files/User_files/user_reg.txt";

                           
                f = new File(PATH);
                
                FileInputStream fi = new FileInputStream(f);
                
    			ObjectInputStream oi = new ObjectInputStream(fi);
    			
    			Singleton.us = (ArrayList<User_reg>) oi.readObject();
    			
    			oi.close();    			
    			
        } catch (Exception e) {
        	
        	JOptionPane.showMessageDialog(null, "Error al leer el TXT.USER", "Error", JOptionPane.ERROR_MESSAGE);
       }		
            
        
	}







}
