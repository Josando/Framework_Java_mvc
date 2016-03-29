package App.modules.users.User_reg.Model.Files.File_utils.utils;

import App.modules.main_menu.model.Config;
import App.modules.users.User_reg.Model.Classes.Singleton_user_reg;
import javax.swing.JOptionPane;
import App.utils.Menus;

public class options_files {

	
	/////////////////////////////////////////////	
	
	public static void option_saves_user_reg() {
	
	if(Singleton_user_reg.us.size()!=0){
	
	
	switch (Config.getinstance().getFile()) {
	
	case "json":
		
		json_user_reg.save_user_reg_json();;
		
		break;

	case "txt":
		
		txt_user_reg.save_user_reg_txt();
		
		break;	
		
	case "xml":
	
		xml_user_reg.save_user_reg_xml();
	
		break;
	}
	
	}else 
		
		JOptionPane.showMessageDialog(null, "admin vacio", "Error", JOptionPane.ERROR_MESSAGE);
}
	
	public static void option_open_user_reg() {
		
		boolean s = false;
		
		if(Singleton_user_reg.us.size()!=0){
		
		s = Menus.yes_no("Guardar", "¿Quieres guardar antes de abrir un nuevo fichero?");
		
		}
		
		if(s==true){
			
			options_files.option_saves_user_reg();
			
		}else{
			
			
		switch (Config.getinstance().getFile()) {
		
		case "json":
			
			json_user_reg.open_user_reg_json();
			
			break;

		case "txt":
			
			txt_user_reg.open_user_reg_txt();
			
			break;	
			
		case "xml":
		
			xml_user_reg.open_user_reg_xml();
		
			break;
		}
		
		
	}
	
	}
	
	
}
