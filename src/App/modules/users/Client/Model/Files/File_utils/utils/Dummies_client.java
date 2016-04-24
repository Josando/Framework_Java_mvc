package App.modules.users.Client.Model.Files.File_utils.utils;

import java.util.ArrayList;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import App.modules.main_menu.model.Config;
import App.classes.date_class;
import App.modules.users.Admin.Model.Classes.Admin;
import App.modules.users.Client.Model.Classes.Client;
import App.modules.users.Client.Model.Classes.Singleton_cli;
import App.modules.users.User_reg.Model.Classes.User_reg;
import App.utils.Menus;

public class Dummies_client {

	private static final int LONGDUMMIES = 5;

	// Atributos Admin
	
	
	private static String[] dni = { "07261935F", "48604856Z", "73099467Q", "00000005M", "48294155C" };
	private static String[] nom = {"Ana", "Maria", "Leticia", "Rafael", "Raul"};
	private static String[] cognom = {"Sanchis", "Pascual", "Soler", "Martinez", "Tortosa"}; 
	private static date_class[] date_birthday = {new date_class("30/12/1970", ""), new date_class("03/01/1986", ""), new date_class("03/02/1960",""),new date_class("22/02/1975",""), new date_class("21/01/1982","")};
	private static String[] mobil = {"646543238", "678542556", "625478964", "645785235", "689555458" };
	private static  String[] email = {"josefato@gmail.com", "ffeppps@gmail.com", "tulipan@gmail.com", "federico@gmail.com", "galiana@gmail.com"};
	private static  String[] avatar = {"", "", "", "", ""};
	private static  String[] user = {"josefato", "ffeppps", "tulipan", "federico", "galiana"};
	private static  String[] pass = {"212585Hj0", "Epiphonesg400", "Letspaul485", "Mmx486der", "Merqulete123"};
	private static  String[] status = {"Online", "Outline", "Outline", "Online", "Online"};
	private static date_class[] f_alta = { new date_class("03/04/2000", ""), new date_class("18/11/2003",""), new date_class("12/3/2014",""),
			new date_class("23/9/2009","4"), new date_class("25/4/2014","5")};
	//private static int[] dtos$= {0, 5, 15, 25, 50};
	private static  float[] compras$ = {100, 25, 45, 32, 567};
        private static  boolean[] premium = {true, true, false, true, false};
        private static  String[] client_type = {"a", "s", "f", "f", "s"};
        
        
        
	// Atributos Cliente
	

	// Atributos User_reg
	
	
	
	public static void Load_Dummies() {
		
		boolean r = false;
		Client c = null;
		//Client c = null;
		//User_reg u = null;
		
		//r = Menus.yes_no("Dummies", "�Quieres trabajar con Dummies?");
		
		//if (r==true){
		
		for (int i = 0; i < LONGDUMMIES; i++) { //

			c = new Client(dni[i], nom[i], cognom[i], date_birthday[i], mobil[i], email[i], avatar[i], user[i], pass[i], status[i], f_alta[i], compras$[i], premium[i], client_type[i]);
			
			Singleton_cli.cli.add(c);
			
		//}
		
		//}else{
			
			//json.auto_open_admin_json();
			
		}
	}

	
}
