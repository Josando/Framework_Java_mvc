package App.modules.users.User_reg.Model.Files.File_utils.utils;

import App.modules.users.User_reg.Model.Classes.Singleton_user_reg;
import App.modules.users.User_reg.Model.Classes.User_reg;
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


public class txt_user_reg {
    ////////////////////////////////////////////////
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
				
				o.writeObject(Singleton_user_reg.us);
				
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
    			
    			Singleton_user_reg.us = (ArrayList<User_reg>) oi.readObject();
    			
    			oi.close();
            }
        } catch (Exception e) {
        	
        	JOptionPane.showMessageDialog(null, "Error al leer el TXT", "Error", JOptionPane.ERROR_MESSAGE);
        }
    	return Singleton_user_reg.us;
    } 
    
    
    /////////////////////////////////////////////
    
    public static void auto_save_user_reg_txt() {
    	
    	  String PATH = null;
          
    	  
    	/////////////////////Save user_reg
  	  
  	  
  	try {
        PATH = new java.io.File(".").getCanonicalPath()
        		
                + "/src/App/Modules/user/model/files/User_reg_files/user_reg.txt";
        
    } catch (IOException e) {
    	
        e.printStackTrace();
    }

  	if (Singleton_user_reg.us.size() > 0) {

	  try {
      	
          File f;
          
          	                
              f = new File(PATH);
             
          
              FileOutputStream fo=new FileOutputStream(f);
              
				ObjectOutputStream o=new ObjectOutputStream(fo);
				
				o.writeObject(Singleton_user_reg.us);
				
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
    
	public static void auto_open_user_reg_txt(){
		
		String PATH = null;
    	
        
        
        ///////////////open_user
        
        
 try {
        	
            File f;
            
            
            PATH = new java.io.File(".").getCanonicalPath()
                    + "/src/App/Modules/user/model/files/User_files/user_reg.txt";

                           
                f = new File(PATH);
                
                FileInputStream fi = new FileInputStream(f);
                
    			ObjectInputStream oi = new ObjectInputStream(fi);
    			
    			Singleton_user_reg.us = (ArrayList<User_reg>) oi.readObject();
    			
    			oi.close();    			
    			
        } catch (Exception e) {
        	
        	JOptionPane.showMessageDialog(null, "Error al leer el TXT.USER", "Error", JOptionPane.ERROR_MESSAGE);
       }		
            
        
	}







}
