package App.modules.main_menu.model.Language;

import java.io.IOException;
import java.util.Properties;

import javax.swing.JOptionPane;


import App.modules.main_menu.model.Config;
import App.modules.users.Admin.Model.Classes.Singleton;

public class Language extends Properties {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;	
	
	private static Language instance;
	
	public static Language getinstance(){
	
		if (instance==null){
			
			instance= new Language();		
			
		
			
		}
		
		return instance;
	}
	
	
		
	public Language() {
		
		switch (Config.getinstance().getLanguage()) {			//Config.getinstance().getLanguage()
		
		case "Spanish":
			getProperties("Spanish.properties");
			break;
		case "English":
			getProperties("English.properties");
			break;
		case "Valencian":
			getProperties("Valencia.properties");
			break;			
		case "Espa�ol":			
			getProperties("Spanish.properties");			
			break;			
		case "Ingles":
			getProperties("English.properties");			
			break;			
		case "Valenciano":			
			getProperties("Valencia.properties");		
			break;
		case "Espanyol":			
			getProperties("Spanish.properties");			
			break;			
		case "Valenci�":			
			getProperties("Valencia.properties");
			break;
		default:
			getProperties("English.properties");	
			
			break;
		}
		

	}

	public void Set_Language() {
		
		switch (Config.getinstance().getLanguage()) {			//Config.getinstance().getLanguage()
		
		case "Spanish":
			getProperties("Spanish.properties");
			break;
		case "English":
			getProperties("English.properties");
			break;
		case "Valencian":
			getProperties("Valencia.properties");
			break;			
		case "Espa�ol":			
			getProperties("Spanish.properties");			
			break;			
		case "Ingles":
			getProperties("English.properties");			
			break;			
		case "Valenciano":			
			getProperties("Valencia.properties");		
			break;
		case "Espanyol":			
			getProperties("Spanish.properties");			
			break;			
		case "Valenci�":			
			getProperties("Valencia.properties");
			break;
		default:
			getProperties("English.properties");	
			
			break;
		}
		

	}
	
	
	
	private void getProperties(String idioma) {
		try {
			this.load(getClass().getResourceAsStream(idioma));
		} catch (IOException ex) {

		}
	}

}
