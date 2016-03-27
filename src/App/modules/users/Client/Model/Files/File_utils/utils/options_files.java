package App.modules.users.Client.Model.Files.File_utils.utils;

import javax.swing.JOptionPane;

import App.modules.main_menu.model.Config;
import App.modules.users.Client.Model.Classes.Singleton_cli;

import App.utils.Menus;

public class options_files {
		
	/////////////////////////////////////////////
	
	public static void option_saves_client() {
		
		if(Singleton_cli.cli.size()!=0){
		
		
		switch (Config.getinstance().getFile()) {
		
		case "json":
			
			json_client.save_client_json();
			
			break;

		case "txt":
			
			txt_client.save_client_txt();
			
			break;	
			
		case "xml":
		
			xml_client.save_client_xml();
		
			break;
		}
		
		}else 
			
			JOptionPane.showMessageDialog(null, "admin vacio", "Error", JOptionPane.ERROR_MESSAGE);
	}
	
	public static void option_open_client() {
		
		boolean s = false;
		
		if(!Singleton_cli.cli.isEmpty()){
		
		s = Menus.yes_no("Guardar", "¿Quieres guardar antes de abrir un nuevo fichero?");
		
		}
		
		if(s==true){
			
			options_files.option_saves_client();
			
		}else{
			
			
		switch (Config.getinstance().getFile()) {
		
		case "json":
			
			json_client.open_client_json();
			
			break;

		case "txt":
			
			txt_client.open_client_txt();
			
			break;	
			
		case "xml":
		
			xml_client.open_client_xml();
		
			break;
		}
		
		
	}
	
        }
	
}
