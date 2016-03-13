package App.modules.main_menu.model;

import App.modules.main_menu.views.First_menu;
import static App.modules.main_menu.views.First_menu.charge_config;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import App.modules.users.Admin.Model.Classes.Admin;
import App.modules.users.Client.Model.Classes.Client;
import App.modules.users.Admin.Model.Classes.Singleton;
import App.modules.users.User_reg.Model.Classes.User_reg;
import App.modules.users.Admin.Model.Files.File_utils.utils.Dummies;
import App.modules.users.Admin.Model.Files.File_utils.utils.json;
import App.modules.users.Admin.Model.Files.File_utils.utils.txt;
import App.modules.users.Admin.Model.Files.File_utils.utils.xml;
import App.utils.Format;
import App.utils.Funciones;
import App.utils.Menus;
import App.utils.themes;

@XStreamAlias("Config")
public class Config implements Serializable{

	@XStreamAlias("Date_format")
	private String Date_format;
	@XStreamAlias("Currency")
	private String Currency;
	@XStreamAlias("File")
	private String File;
	@XStreamAlias("Language")
	private String Language;
	@XStreamAlias("Decimals")
	private int Decimals;
	@XStreamAlias("Theme")
	private String Theme;
	
	
	private static Config instance;
	
	public static Config getinstance(){
	
		if (instance==null){
			
			instance= new Config();	
			
			json.open_config_json();	
			charge_config();
			Singleton.cli = new ArrayList <Client>();
			Singleton.us = new ArrayList <User_reg>();
			Singleton.ad = new ArrayList <Admin>();	
			
			themes.Choicethemes();
			//Dummies.Load_Dummies();
			json.auto_open_admin_json();
			
		}
		
		return instance;
	}
		
	
	
	public Config() {
		
	
		this.Date_format = "dd/MM/yyyy";
		this.Currency = "€";
		this.File = "json";
		this.Language ="English";
		this.Decimals =2;
		this.Theme = "GTK-Windows";

	
	}


	public String getDate_format() {
		return Date_format;
	}

	public void setDate_format(String date_format) {
		this.Date_format = date_format;
		
	}

	public String getFile() {
		return File;
	}

	public void setFile(String file) {
		this.File = file;
	}

	public String getLanguage() {
		return Language;
	}

	public void setLanguage(String language) {
		this.Language = language;
		
	}

	public int getDecimals() {
		return Decimals;
	}

	public void setDecimals(int decimals) {
		this.Decimals = decimals;
		
	}

	public String getTheme() {
		return Theme;
		
	}

	public void setTheme(String theme) {
		this.Theme = theme;
		themes.Choicethemes();
		
	}
	
	public String getCurrency() {
		return Currency;
	}

	public void setCurrency(String theme) {
		this.Currency = theme;
	}
	
        
        
        
	
	public String toString( ) {// para el constructor que inicializa a un estado
		// determinado
                         
               			
String cad = " ";


cad = cad + "The date format is: " + this.getDate_format() + " \n ";
cad = cad + "The currency is: " + this.getCurrency() + " \n ";
cad = cad + "The File: " + this.getFile() + " \n ";
cad = cad + "The Lenguage: " +  this.getLanguage() + " \n ";
cad = cad + "The Decimals: " +  this.getDecimals()+ " \n";
cad = cad + "The Theme: " + this.getTheme() + " \n ";

return cad;
		
	}
	
	
        
        
	
	
}
