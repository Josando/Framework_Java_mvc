/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

import App.modules.main_menu.Controler.Controler_main_menu;
import App.modules.main_menu.views.First_menu;


/**
 *
 * @author Jorge
 */
public class Main_menu {
    
     //objeto singleton que contendrá la ventana activa
    
     public static void main(String args[]) {
        
         //First_menu first = new First_menu();
         new Controler_main_menu(new First_menu(), 0).Start(0);
        // first.setLocationRelativeTo(null);
        // first.setVisible(true);
         
        
    }
    
    
    
}
