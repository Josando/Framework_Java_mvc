/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App.modules.main_menu.model.dao;

import static App.modules.main_menu.Controler.Controler_main_menu.First;
import App.modules.main_menu.model.Config;
import App.modules.main_menu.model.Language.Language;
import App.modules.main_menu.views.First_menu;
import static App.modules.main_menu.views.First_menu.Dolar;
import static App.modules.main_menu.views.First_menu.English;
import static App.modules.main_menu.views.First_menu.Español;
import static App.modules.main_menu.views.First_menu.Eurobtn;
import static App.modules.main_menu.views.First_menu.Json;
import static App.modules.main_menu.views.First_menu.Libra;
import static App.modules.main_menu.views.First_menu.Txt_;
import static App.modules.main_menu.views.First_menu.Valencia;
import static App.modules.main_menu.views.First_menu.Xml;
import static App.modules.main_menu.views.First_menu.formato_1;
import static App.modules.main_menu.views.First_menu.formato_2;
import static App.modules.main_menu.views.First_menu.formato_3;
import static App.modules.main_menu.views.First_menu.formato_4;
import static App.modules.main_menu.views.First_menu.gtk_windows;
import static App.modules.main_menu.views.First_menu.metal;
import static App.modules.main_menu.views.First_menu.motif;
import static App.modules.main_menu.views.First_menu.ninbus;
import App.modules.users.Admin.Model.Files.File_utils.utils.json;

/**
 *
 * @author Jorge
 */
public class First_menu_config_dao {

    public static void Charge_Config_to_class_config() {

        if (Dolar.isSelected()) {

            Config.getinstance().setCurrency("$");

        } else if (Libra.isSelected()) {

            Config.getinstance().setCurrency("£");

        } else if (Eurobtn.isSelected()) {

            Config.getinstance().setCurrency("€");

        }

        if (English.isSelected()) {

            Config.getinstance().setLanguage("English");

        } else if (Español.isSelected()) {

            Config.getinstance().setLanguage("Español");

        } else if (Valencia.isSelected()) {

            Config.getinstance().setLanguage("Valencia");

        }

        if (formato_1.isSelected()) {

            Config.getinstance().setDate_format("dd/MM/yyyy");

        } else if (formato_2.isSelected()) {

            Config.getinstance().setDate_format("dd-MM-yyyy");

        } else if (formato_3.isSelected()) {

            Config.getinstance().setDate_format("yyyy-MM-dd");

        } else if (formato_4.isSelected()) {

            Config.getinstance().setDate_format("yyyy/MM/dd");

        }

        if (metal.isSelected()) {

            Config.getinstance().setTheme("Metal");

        } else if (gtk_windows.isSelected()) {

            Config.getinstance().setTheme("GTK-Windows");

        } else if (motif.isSelected()) {

            Config.getinstance().setTheme("Motif");

        } else if (ninbus.isSelected()) {

            Config.getinstance().setTheme("Ninbus");

        }

        if (Json.isSelected()) {

            Config.getinstance().setFile("json");

        } else if (Xml.isSelected()) {

            Config.getinstance().setFile("xml");

        } else if (Txt_.isSelected()) {

            Config.getinstance().setFile("txt");
        }

        json.save_config_json();

        First.Dialog_config.dispose();
        
        Language.getinstance().Set_Language();

    }

    public static void Charge_config(){
        
         switch (Config.getinstance().getLanguage()) {

            case "English":

                First_menu.English.setSelected(true);

                break;

            case "Español":

                First_menu.Español.setSelected(true);

                break;
                
            case "Valencia":

                First_menu.Valencia.setSelected(true);
                break;
        }

        switch (Config.getinstance().getCurrency()) {

            case "€":

                First_menu.Eurobtn.setSelected(true);

                break;

            case "£":

                First_menu.Libra.setSelected(true);
                break;

            case "$":

                First_menu.Dolar.setSelected(true);
                break;
        }

        switch (Config.getinstance().getDate_format()) {

            case "dd/MM/yyyy":

                First_menu.formato_1.setSelected(true);
                
                break;
                
            case "dd-MM-yyyy":

                First_menu.formato_2.setSelected(true);
                
                break;

            case "yyyy-MM-dd":

                First_menu.formato_3.setSelected(true);
                
                break;
                
            case "yyyy/MM/dd":

                First_menu.formato_3.setSelected(true);

                break;

        }
        
        switch (Config.getinstance().getFile()) {

            case "json":

                First_menu.Json.setSelected(true);
                break;
            case "xml":

                First_menu.Xml.setSelected(true);
                break;

            case "txt":

                First_menu.Txt_.setSelected(true);
                break;
        }
        
         
        switch (Config.getinstance().getTheme()) {

            case "Metal":

                First_menu.metal.setSelected(true);
                break;
                
            case "GTK-Windows":

                First_menu.gtk_windows.setSelected(true);
                break;

            case "Ninbus":

                First_menu.ninbus.setSelected(true);
                
                break;
                
              case "Motif":

                First_menu.motif.setSelected(true);
                
                break;   
                
                
        }
        
    }
    
    
    
}
