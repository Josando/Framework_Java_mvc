/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App.modules.main_menu.model.bll;

import App.modules.main_menu.model.dao.First_menu_config_dao;

/**
 *
 * @author Jorge
 */
public class First_menu_config_bll {
    
    
    public static void Charge_Config_to_class_config(){
        
        First_menu_config_dao.Charge_Config_to_class_config();
        
    }
    
    
    public static void Charge_config(){
        
        First_menu_config_dao.Charge_config();
    }
    
}
