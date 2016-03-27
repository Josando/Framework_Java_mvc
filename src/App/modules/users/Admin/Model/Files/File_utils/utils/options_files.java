package App.modules.users.Admin.Model.Files.File_utils.utils;

import javax.swing.JOptionPane;

import App.modules.main_menu.model.Config;
import App.modules.users.Admin.Model.Classes.Singleton;
import App.utils.Menus;

public class options_files {

	
	public static void option_saves_admin() {
		
		if(Singleton.ad.size()!=0){
		
		
		switch (Config.getinstance().getFile()) {
		
		case "json":
			
			json.save_admin_json();
			
			break;

		case "txt":
			
			txt.save_admin_txt();
			
			break;	
			
		case "xml":
		
			xml.save_admin_xml();
		
			break;
		}
		
		}else 
			
			JOptionPane.showMessageDialog(null, "admin vacio", "Error", JOptionPane.ERROR_MESSAGE);
	}
	
	public static void option_open_admin() {
		
		boolean s = false;
		
		if(Singleton.ad.size()!=0){
		
		s = Menus.yes_no("Guardar", "�Quieres guardar antes de abrir un nuevo fichero?");
		
		}
		
		if(s==true){
			
			options_files.option_saves_admin();
			
		}else{
			
			
		switch (Config.getinstance().getFile()) {
		
		case "json":
			
			json.open_admin_json();
			
			
			
			break;

		case "txt":
			
			txt.open_admin_txt();
			
			
			
			break;	
			
		case "xml":
		
			xml.open_admin_xml();
			
			break;
			
			
		}
		
		
		
		
	}
	
	}
		
	/////////////////////////////////////////////
	
	/////////////////////////////////////////////	
	
	
	
}
