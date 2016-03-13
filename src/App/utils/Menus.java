package App.utils;

import javax.swing.JOptionPane;

import App.modules.users.Admin.Model.Classes.Singleton;
import App.modules.main_menu.model.Language.Language;

public class Menus {
	
	//main menu
	
			public static int menu (String[]tipo, String titulo, String mensaje){

				int op=0;
			
				op = JOptionPane.showOptionDialog(null,//En esta obci�n de show coje una variable de tipo int showImput seria String.    
						mensaje,titulo,0,//El men� es el que aparecer� a la parte izquierda de la patalla. 
						JOptionPane.QUESTION_MESSAGE,null,tipo,tipo [0]);//El primer tipo llama a la String tipo el segundo marca por defecto la primera obci�n del menu en este caso suma saldria remarcada.
			
				return op;
				
			}			
			
			// combobox menu
			
			public static Object menuk (String[] tipo, String titulo, String mensaje){
				
				Object selection = null;
				
				 selection = JOptionPane.showInputDialog(null, mensaje, titulo,
						JOptionPane.QUESTION_MESSAGE, null,tipo,tipo [0]);		 // null para icono defecto
					
				
				return selection;
				
			}
			
			public static boolean yes_no (String titulo, String mensaje){
				
				boolean state = false;	
				int opt =0;
				//Language idioma = new Language();
				String[] menu = { Language.getinstance().getProperty("yes"),  Language.getinstance().getProperty("no") };
				
				opt=Menus.menu(menu,  titulo, mensaje);
				
				if (opt==0){
					
					state = true;
				}
				
				return state;
				
				}
				
			

}
