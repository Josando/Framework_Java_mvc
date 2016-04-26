/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App.modules.main_menu.Controler;

//import App.modules.main_menu.model.Config;
import App.modules.main_menu.model.Language.Language;
import App.modules.main_menu.model.bll.First_menu_config_bll;
import App.modules.main_menu.views.First_menu;
import static App.modules.main_menu.views.First_menu.Dialog_config;
import static App.modules.main_menu.views.First_menu.jPanel14;
import static App.modules.main_menu.views.First_menu.jPanel2;
import static App.modules.main_menu.views.First_menu.jPanel3;
import static App.modules.main_menu.views.First_menu.jPanel5;
import App.modules.main_menu.views.Menu;
import App.modules.users.Admin.Model.Files.File_utils.utils.json;
import App.modules.users.Admin.controler.Controlador_Admin;
import App.modules.users.Admin.views.interfaz_Admin;
import App.modules.users.Client.controler.Controlador_Client;
import App.modules.users.Client.views.interfaz_Client;
import App.modules.users.User_reg.Controler.Controlador_User_reg;
import App.modules.users.User_reg.Views.interfaz_User_reg;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

/**
 *
 * @author Jorge
 */
public class Controler_main_menu implements ActionListener {

    public static First_menu First;// = new First_menu();
    public static Menu Menu_users;// = new Menu(); 
    
    
    
    public Controler_main_menu(JFrame Start, int i){
        
        if (i==0){
            
            First = (First_menu) Start;
        }
        
         if (i==1){
            
            Menu_users = (Menu) Start;
        }
        
       }

    
    
    public enum Action {
        
        ////Fisrt_menu///
        
        btnAplicar,
        btnSalir,
        btn_Config,
        btn_employees,
        
        ////Menu///
        
        
        bntclient,
        btnrAdministrator,
        btnreturn,
        btnuser_reg
        
        
    }
    
    public void Start (int i){
        
        if(i==0){
                  
        First_menu_config_bll.Charge_config();
        
        First.setTitle("Main menu");
        First.setLocationRelativeTo(null);
        First.setSize(720, 500);//ancho x alto
        First.setResizable(false);
        First.setVisible(true);
        Image image = Toolkit.getDefaultToolkit().getImage("src/App/modules/main_menu/views/img/IMG_0279.JPG");
        First.setIconImage(image);
        First.jTabbedPane1.addTab( Language.getinstance().getProperty("currency"), jPanel3);
        First.jTabbedPane1.addTab( Language.getinstance().getProperty("language"), jPanel5);
         First.jTabbedPane1.addTab( Language.getinstance().getProperty("date"), jPanel2);
         First.jTabbedPane1.addTab( Language.getinstance().getProperty("save"), jPanel14);
        First.btn_Config.setOpaque(false);
        First.btn_Config.setContentAreaFilled(false);
        First.btn_Config.setBorderPainted(false);
        First.btn_employees.setOpaque(false);
        First.btn_employees.setContentAreaFilled(false);
        First.btn_employees.setBorderPainted(false);
        ////////////////////////////////////////////
        First.btnAplicar.setActionCommand("btnAplicar");
            First.btnAplicar.addActionListener(this);
        First.btnSalir.setActionCommand("btnSalir");
            First.btnSalir.addActionListener(this);
        First.btn_Config.setActionCommand("btn_Config");
            First.btn_Config.addActionListener(this);
        First. btn_employees.setActionCommand("btn_employees");
            First.btn_employees.addActionListener(this); 
            
        ////Cerrar ventana
         this.First.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {

//                EFBLLgrafico.Guardar(0);
                JOptionPane.showMessageDialog(null,
                        Language.getinstance().getProperty("leave1"), Language.getinstance().getProperty("leave2"),
                        JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
        });

    }

   if (i == 1) {
       
       
        Menu_users.setVisible(true);
       // Config.getinstance().getTheme();
        Menu_users.setTitle("Menu");
	Menu_users.setSize(720,500);//ancho x alto
        Menu_users.setLocationRelativeTo(null);
	Menu_users.setResizable(false);
	Image image =Toolkit.getDefaultToolkit().getImage("src/App/modules/main_menu/views/img/Menu_image.JPG");
	Menu_users.setIconImage(image);  
        Menu_users.btnrAdministrator.setOpaque(false);
        Menu_users.btnrAdministrator.setContentAreaFilled(false);
        Menu_users.btnrAdministrator.setBorderPainted(false);
        Menu_users.btnrAdministrator.setText(Language.getinstance().getProperty("admin"));
         Menu_users.bntclient.setOpaque(false);
        Menu_users. bntclient.setContentAreaFilled(false);
        Menu_users. bntclient.setBorderPainted(false);
         Menu_users. bntclient.setText(Language.getinstance().getProperty("client"));
         Menu_users.btnuser_reg.setOpaque(false);
        Menu_users.btnuser_reg.setContentAreaFilled(false);
        Menu_users.btnuser_reg.setBorderPainted(false);
        Menu_users.btnuser_reg.setText(Language.getinstance().getProperty("user_reg"));
         Menu_users.btnreturn.setOpaque(false);
        Menu_users.btnreturn.setContentAreaFilled(false);
        Menu_users.btnreturn.setBorderPainted(false);
        //////////////////////////////////////////
        
         Menu_users.bntclient.setActionCommand("bntclient");
             Menu_users.bntclient.addActionListener(this);
        Menu_users.btnrAdministrator.setActionCommand("btnrAdministrator");
             Menu_users.btnrAdministrator.addActionListener(this);
         Menu_users.btnreturn.setActionCommand("btnreturn");
           Menu_users.btnreturn.addActionListener(this);
         Menu_users.btnuser_reg.setActionCommand("btnuser_reg");
            Menu_users.btnuser_reg.addActionListener(this);
        
        
        Menu_users.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
            this.Menu_users.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {              
                
                           Menu_users.dispose();    
                           
                          
                    new Controler_main_menu(new First_menu(), 0).Start(0);
                  
                     
                
            }
        });
            
            
        }
        
        
        
}   
    
    @Override
    public void actionPerformed(ActionEvent e) {
       
        switch (Action.valueOf(e.getActionCommand())) {
            
            case btnAplicar:
                   
                                
                 First_menu_config_bll.Charge_Config_to_class_config();              
                     
                 First.dispose();
                      
                 new Controler_main_menu(new First_menu(), 0).Start(0);
                 
                 
                break;
            case btnSalir:
                
                  Dialog_config.dispose();
                                
                break;
            case btn_Config:
                
                Language.getinstance().Set_Language();
                
                 First_menu_config_bll.Charge_config();
                 
                 Language.getinstance().Set_Language();
        
                 Dialog_config.setSize(550, 350);//ancho x alto

                 Dialog_config.setLocationRelativeTo(null);

                 Dialog_config.setVisible(true);
                                                
                break;
            case btn_employees:
                
                
            First.dispose();

            //new Menu().setVisible(true);
                
            new Controler_main_menu(new Menu(), 1).Start(1);
                
                
                break;
            case bntclient:
                
                 Menu_users.setVisible(false);
      
              new Controlador_Client(new interfaz_Client(), 0).Start(0);
                
                break;    
                
            case btnrAdministrator:
                
             Menu_users.setVisible(false);
      
              new Controlador_Admin(new interfaz_Admin(), 0).Start(0);
             
     // new interfaz_Admin().setVisible(true);
                
                break;        
                
            case btnreturn:
                
                Menu_users.dispose();
                                
        new Controler_main_menu(new First_menu(), 0).Start(0);
        
                break;
                
            case btnuser_reg:
                
                    
             Menu_users.setVisible(false);
      
              new Controlador_User_reg(new interfaz_User_reg(), 0).Start(0);
                
                break;
           
               
        }
        
        
        
        
    }
    
    
    
    
    
    
    
    
    
}
