package App.modules.main_menu.model;

import App.classes.BD_Connection;
import App.classes.Mongo_BD_conection;
import App.modules.main_menu.model.bll.First_menu_config_bll;
import App.modules.main_menu.views.First_menu;

import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import App.modules.users.Admin.Model.Classes.Admin;
import App.modules.users.Client.Model.Classes.Client;
import App.modules.users.Admin.Model.Classes.Singleton;
import App.modules.users.Client.Model.Classes.Singleton_cli;
import App.modules.users.User_reg.Model.Classes.User_reg;
import App.modules.users.Admin.Model.Files.File_utils.utils.Dummies;
import App.modules.users.Admin.Model.Files.File_utils.utils.json;
import App.modules.users.Admin.Model.Files.File_utils.utils.txt;
import App.modules.users.Admin.Model.Files.File_utils.utils.xml;
import App.modules.users.Admin.Model.bll.Admin_BLL_BD;
import App.modules.users.Client.Model.Files.File_utils.utils.Dummies_client;
import App.modules.users.Client.Model.Files.File_utils.utils.json_client;
import App.modules.users.User_reg.Model.Files.File_utils.utils.json_user_reg;
import App.modules.users.User_reg.Model.Classes.Singleton_user_reg;
import App.modules.users.User_reg.Model.Files.File_utils.utils.Dummies_user_reg;
import App.utils.Format;
import App.utils.Funciones;
import App.utils.Menus;
import App.utils.Singleton_App;
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
			
			//json.open_config_json();	
                        //First_menu_config_bll.Charge_config(); Esto en el primer menu
			Singleton_cli.cli = new ArrayList <Client>();
			Singleton_user_reg.us = new ArrayList <User_reg>();
			Singleton.ad = new ArrayList <Admin>();	
			
			themes.Choicethemes();
                        
                       // BD_Connection.initialize_BasicDataSourceFactory();
                       // BD_Connection.logStatistics();
                        //Admin_BLL_BD.Charge_admin_BD();
			//Dummies.Load_Dummies();
			//Dummies_client.Load_Dummies();
                        //Dummies_user_reg.Load_Dummies();
                        //json_client.auto_open_client_json();
                       //json.auto_open_admin_json();
                        json_user_reg.auto_open_user_reg_json();
                        
                        
                        Singleton_App.mongo = new Mongo_BD_conection();
                        Singleton_App.nom_bd = Singleton_App.mongo.getNom_bd();
                        Singleton_App.nom_table = Singleton_App.mongo.getNom_table();
        
                        Singleton_App.client = Mongo_BD_conection.connect();
                       
                        
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
