package App.utils;

/**
 * @author Jorge
 */
import javax.swing.JOptionPane;

import App.modules.users.Admin.Model.Classes.Singleton;
import App.modules.main_menu.model.Language.Language;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

	public class Funciones {

		/**
		 * 
		 * @param tipo
		 * @param titulo
		 * @param mensaje
		 * @return
		 */
		
		//meno principal
		/**
		
		public static int menu (String[]tipo, String titulo, String mensaje){

			int op=0;
		
			op = JOptionPane.showOptionDialog(null,//En esta obci�n de show coje una variable de tipo int showImput seria String.    
					mensaje,titulo,0,//El men� es el que aparecer� a la parte izquierda de la patalla. 
					JOptionPane.QUESTION_MESSAGE,null,tipo,tipo [0]);//El primer tipo llama a la String tipo el segundo marca por defecto la primera obci�n del menu en este caso suma saldria remarcada.
		
			return op;
			
		}			
		*/
/**
 * 		
 * @param titulo
 * @param mensaje
 * @return
 */
		
		public static String ValidaSring(String titulo, String mensaje) {
			
		String s="";
		boolean correcto=true;
	//	Language idioma = new Language();

		do{
			try{
				s=JOptionPane.showInputDialog(null, mensaje, titulo ,JOptionPane.QUESTION_MESSAGE);
				correcto=true;
				if (s==null){
					//JOptionPane.showMessageDialog(null, "Saliendo de la aplicaci�n","Saliendo",JOptionPane.INFORMATION_MESSAGE);
					//System.exit(0);//al usuario pulsar cancelar o cerrar la vtna del showinputdialog, acaba la ejecuci�n
				}
				if(s.equals("")){
					JOptionPane.showMessageDialog(null, Language.getinstance().getProperty("error3"),"Error",JOptionPane.ERROR_MESSAGE);
					correcto=false;
				}
			}catch(Exception e){
				JOptionPane.showMessageDialog(null, Language.getinstance().getProperty("error3"), "Error",JOptionPane.ERROR_MESSAGE);
				correcto=false;
			}
		}while(correcto==false);
		
		return s;
	}
		public static int validaint (String titulo, String mensaje){//pido los numeros
			
			int num = 0;
			boolean correcto=true;
			String numero;
			//Language idioma = new Language();
			
			do{
				try{
					numero=JOptionPane.showInputDialog(null, mensaje,titulo,JOptionPane.QUESTION_MESSAGE);
					if(numero==null){
						//JOptionPane.showMessageDialog(null, "Saliendo de la aplicaci�n","Saliendo",JOptionPane.INFORMATION_MESSAGE);
						//System.exit(0);//al usuario pulsar cancelar o cerrar la vtna del showinputdialog, acaba la ejecuci�n
					}else {
						num=Integer.parseInt(numero);
						correcto=true;
					}
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, Language.getinstance().getProperty("error5"), "Error",JOptionPane.ERROR_MESSAGE);
					correcto=false;
				}
			}while(correcto==false);
			
			return num;
		}

		public static float validafloat (String titulo, String mensaje){
			
			float num = 0.0f;
			String numero;
			boolean correcto=true;
		//	Language idioma = new Language();
			
			do{
				try{
					numero=JOptionPane.showInputDialog(null, mensaje,titulo,JOptionPane.QUESTION_MESSAGE);
					if(numero==null){
						//JOptionPane.showMessageDialog(null, "Saliendo de la aplicaci�n","Saliendo",JOptionPane.INFORMATION_MESSAGE);
					//System.exit(0);//al usuario pulsar cancelar o cerrar la vtna del showinputdialog, acaba la ejecuci�n
					}else {
						num=Float.parseFloat(numero);
						correcto=true;
					}
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, Language.getinstance().getProperty("error6"), "Error",JOptionPane.ERROR_MESSAGE);
					correcto=false;
				}
			}while(correcto==false);	
			
			return num;
		}
		
		public static float Convert_Currency( float coin, String currency ) {
			
			float  money = 0.0f; 
			
			switch (currency) {

			case "€":// Euro
				
				money = coin;
			
				break;
				

			case "$":// Dolar
				
				money = (float) (coin * 1.093215);
				
				break;

			case "£":// Libra
				
				money = (float) (coin * 0.72834);
				
				break;
			}
			
			return money;
			
			
		}
		
             public static void copyFileUsingJava7Files(File source, File dest)

        throws IOException {

    Files.copy(source.toPath(), dest.toPath());   
                
                
	}

        }
