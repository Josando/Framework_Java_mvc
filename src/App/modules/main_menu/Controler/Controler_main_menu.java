/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App.modules.main_menu.Controler;

//import App.modules.main_menu.model.Config;
import App.classes.BD_Connection;
import App.classes.Mongo_BD_conection;
import App.modules.main_menu.model.Config;
import App.modules.main_menu.model.Language.Language;
import App.modules.main_menu.model.bll.First_menu_config_bll;
import App.modules.main_menu.model.bll.Sign_in_BLL;
import App.modules.main_menu.model.dao.Sign_in_DAO;
import App.modules.main_menu.views.First_menu;
import static App.modules.main_menu.views.First_menu.Dialog_config;
import static App.modules.main_menu.views.First_menu.jPanel14;
import static App.modules.main_menu.views.First_menu.jPanel2;
import static App.modules.main_menu.views.First_menu.jPanel3;
import static App.modules.main_menu.views.First_menu.jPanel5;
import App.modules.main_menu.views.Menu;
import App.modules.main_menu.views.Sign_in;
import static App.modules.main_menu.views.Sign_in.Error_label;
import App.modules.users.Admin.Model.Files.File_utils.utils.json;
import App.modules.users.Admin.controler.Controlador_Admin;
import App.modules.users.Admin.views.interfaz_Admin;
import App.modules.users.Client.Model.bll.Client_BLL;
import App.modules.users.Client.controler.Controlador_Client;
import App.modules.users.Client.views.Change_Client;
import App.modules.users.Client.views.Create_Client;
import App.modules.users.Client.views.interfaz_Client;
import App.modules.users.User_reg.Controler.Controlador_User_reg;
import App.modules.users.User_reg.Model.Classes.Singleton_user_reg;
import App.modules.users.User_reg.Model.Classes.User_reg;
import App.modules.users.User_reg.Model.Files.File_utils.utils.json_user_reg;
import App.modules.users.User_reg.Model.bll.User_reg_BLL;
import App.modules.users.User_reg.Views.Change_User_reg;
import App.modules.users.User_reg.Views.interfaz_User_reg;
import App.utils.Singleton_App;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

/**
 *
 * @author Jorge
 * @version 1.2.7
 * 
 */
public class Controler_main_menu implements ActionListener,FocusListener, KeyListener,  MouseListener {

    public static First_menu First;
    public static Menu Menu_users;
    public static Sign_in sign_in;
    public static Change_Client Change;
    public static Change_User_reg Change_user;
    
    public Controler_main_menu(JFrame Start, int i){


switch(i){
    
    case 0:
        
        First = (First_menu) Start;
        
        break;
        
    case 1:
                 
        Menu_users = (Menu) Start;
                
        break;
        
    case 2:
        
         sign_in = (Sign_in) Start;
        
        break;
        
    case 3:
        
          
         Change = (Change_Client) Start;   
        
        break;
        
    case 4:
        
        Change_user = (Change_User_reg) Start;
        
        break;
        
        
}        

           
       }
    
    
    public enum Action {
        
        ////Fisrt_menu///
        
        btnAplicar,
        btnSalir,
        btn_Config,
        btn_employees,
        btn_sign_out,
        
        ////Menu///
        
        
        bntclient,
        btnrAdministrator,
        btnreturn,
        btnuser_reg,
        
        ///Sign in///
        
        Sign_in_btn,
        
        
        ////Change_client////
        
        Change_ADEmailtext,
        Change_AdActivitytext,
        Change_AdCancelbtn,
        Change_AdChange_Avatar,
        Change_AdIDtext,
        Change_AdMobiltext,
        Change_AdNametext,
        Change_AdPasstext,
        Change_AdReturnbtn,
        Change_AdSavebtn,
        Change_AdSurnametext,
        Change_AdUsernametext,
        Change_Addatebirthdaytext,
        Change_Adhiredatetext,
        Change_Shopping,
        Change_Client_type,
        
        ///User_reg////
        
        Change_UsEmailtext,
        Change_UsActivitytext,
        Change_UsCancelbtn,
        Change_UsChange_Avatar,
        Change_UsIDtext,
        Change_UsMobiltext,
        Change_UsNametext,
        Change_UsPasstext,
        Change_UsReturnbtn,
        Change_UsSavebtn,
        Change_UsSurnametext,
        Change_UsUsernametext,
        Change_Usdatebirthdaytext
        
    }
    
    public void Start (int i){
        
        switch(i){
            
            case 0:
       
                  
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
        First.btn_sign_out.setOpaque(false);
        First.btn_sign_out.setContentAreaFilled(false);
        First.btn_sign_out.setBorderPainted(false);
        
        ////////////////////////////////////////////
        First.btnAplicar.setActionCommand("btnAplicar");
            First.btnAplicar.addActionListener(this);
        First.btnSalir.setActionCommand("btnSalir");
            First.btnSalir.addActionListener(this);
        First.btn_Config.setActionCommand("btn_Config");
            First.btn_Config.addActionListener(this);
        First. btn_employees.setActionCommand("btn_employees");
            First.btn_employees.addActionListener(this); 
            First.btn_sign_out.setActionCommand("btn_sign_out");
            First.btn_sign_out.addActionListener(this); 
            
        ////Cerrar ventana
         this.First.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {

                JOptionPane.showMessageDialog(null,
                        Language.getinstance().getProperty("leave1"), Language.getinstance().getProperty("leave2"),
                        JOptionPane.INFORMATION_MESSAGE);
                
                        new Controler_main_menu(new Sign_in(), 2).Start(2);

                
               // System.exit(0);
            }
        });

         break;
    

   
       
       case 1:
           
        Menu_users.setVisible(true);
       // Config.getinstance().getTheme();
        Menu_users.setTitle("Menu");
	Menu_users.setSize(720,500);//ancho x alto
        Menu_users.setLocationRelativeTo(null);
	Menu_users.setResizable(false);
	Image image1 =Toolkit.getDefaultToolkit().getImage("src/App/modules/main_menu/views/img/Menu_image.JPG");
	Menu_users.setIconImage(image1);  
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
            
           break;
        
        
   
    case 2:
       
       
        json.open_config_json();
       // Singleton_user_reg.us = new ArrayList<User_reg>();
        json_user_reg.auto_open_user_reg_json();
       // Singleton_App.mongo = new Mongo_BD_conection();
       // Singleton_App.nom_bd = Singleton_App.mongo.getNom_bd();
        //Singleton_App.nom_table = Singleton_App.mongo.getNom_table();
        //Singleton_App.client = Mongo_BD_conection.connect();
       // BD_Connection.initialize_BasicDataSourceFactory();
        //BD_Connection.logStatistics();

        sign_in.setTitle("SIGN IN");
        sign_in.setLocationRelativeTo(null);
        sign_in.setSize(300, 300);//ancho x alto
        sign_in.setResizable(false);
        sign_in.setVisible(true);
        Image image2 = Toolkit.getDefaultToolkit().getImage("src/App/modules/main_menu/views/img/sign_in.png");
        sign_in.setIconImage(image2);
        //////////////////////////////////////////////////////////////////////////////
        
         sign_in.Sign_in_btn.setActionCommand("Sign_in_btn");
             sign_in.Sign_in_btn.addActionListener(this);
               
        

         this.sign_in.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {

                JOptionPane.showMessageDialog(null,
                        Language.getinstance().getProperty("leave1"), Language.getinstance().getProperty("leave2"),
                        JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
        });
       
       break;
       
     case 3:
         
         
        Change.setVisible(true);        
        Change.setTitle("Client Table");
	Change.setSize(535,690);//ancho x alto
        Change.setLocationRelativeTo(null);
	Change.setResizable(false);
	Image image3 =Toolkit.getDefaultToolkit().getImage("src/App/modules/users/Client/views/img/1459292729_bag1.png");
	Change.setIconImage(image3);   
        Change.Addatebirthdaytext.setDateFormatString(Config.getinstance().getDate_format());
        Change.Adhiredatetext.setDateFormatString(Config.getinstance().getDate_format());
        Change.AdReturnbtn.setText("Sign out");
        Change.Adhiredatetext.setEnabled(false);
        Change.jComboBox2.setEnabled(false);
        Change.AdActivitytext.setEnabled(false);
       // AdAvatar.setSize(90,90);
        ////Cerrar ventana
       
         this.Change.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		Change.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
               
                Change.dispose();
                 new Controler_main_menu(new Sign_in(), 2).Start(2);
                
                 //new interfaz_Admin().setVisible(true);  
                // new Controlador_Client(new interfaz_Client(), 0).Start(0);                       
            }
        });   
                                  
            Change.ADEmailtext.setActionCommand(" Change_ADEmailtext");
            Change.ADEmailtext.setName("Change_ADEmailtext");
            Change.ADEmailtext.addKeyListener(this);
            Change.ADEmailtext.addActionListener(this);
            
            Change.AdActivitytext.setActionCommand("Change_AdActivitytext");
            Change.AdActivitytext.setName("Change_AdActivitytext");
            Change.AdActivitytext.addKeyListener(this);
            Change.AdActivitytext.addActionListener(this);
            
                
            Change.AdChange_Avatar.setActionCommand("Change_AdChange_Avatar");
            Change.AdChange_Avatar.setName("Change_AdChange_Avatar");
            Change.AdChange_Avatar.addKeyListener(this);
            Change.AdChange_Avatar.addActionListener(this);    
            
            Change.AdIDtext.setActionCommand("Change_AdIDtext");
            Change.AdIDtext.setName("Change_AdIDtext");
            Change.AdIDtext.addKeyListener(this);
            Change.AdIDtext.addActionListener(this);
            
            Change.AdMobiltext.setActionCommand("Change_AdMobiltext");
            Change.AdMobiltext.setName("Change_AdMobiltext");
            Change.AdMobiltext.addKeyListener(this);
            Change.AdMobiltext.addActionListener(this);
            
            Change.AdNametext.setActionCommand("Change_AdNametext");
            Change.AdNametext.setName("Change_AdNametext");
            Change.AdNametext.addKeyListener(this);
            Change.AdNametext.addActionListener(this);    
            
            Change.AdPasstext.setActionCommand("Change_AdPasstext");
            Change.AdPasstext.setName("Change_AdPasstext");
            
            Change.AdPasstext.addKeyListener(this);
            Change.AdPasstext.addActionListener(this); 
            Change.AdPasstext.addFocusListener(this);
            
            Change.AdReturnbtn.setActionCommand("Change_AdReturnbtn");
            Change.AdReturnbtn.setName("Change_AdReturnbtn");            
            Change.AdReturnbtn.addActionListener(this);
            
            Change.AdSavebtn.setActionCommand("Change_AdSavebtn");
            Change.AdSavebtn.setName("Change_AdSavebtn");            
            Change.AdSavebtn.addActionListener(this);
            
            Change.AdSurnametext.setActionCommand("Change_AdSurnametext");
            Change.AdSurnametext.setName("Change_AdSurnametext");
            Change.AdSurnametext.addKeyListener(this);
            Change.AdSurnametext.addActionListener(this); 
            
            Change.AdUsernametext.setActionCommand("Change_AdUsernametext");
            Change.AdUsernametext.setName("Change_AdUsernametext");
            Change.AdUsernametext.addKeyListener(this);
            Change.AdUsernametext.addActionListener(this);
                       
            Change.Addatebirthdaytext.setName("Change_Addatebirthdaytext");
            Change.Addatebirthdaytext.addKeyListener(this);
           
            Change.Adhiredatetext.setName("Change_Adhiredatetext");
            Change.Adhiredatetext.addKeyListener(this);   
            
            Change.Client_type_text.setName("Change_Client_type");
            Change.Client_type_text.addKeyListener(this);
         
         
         
         break;
         
         
         case 4:
             
               
        Change_user.setVisible(true);        
        Change_user.setTitle("Change user reg");
	Change_user.setSize(520,550);//ancho x alto
        Change_user.setLocationRelativeTo(null);
	Change_user.setResizable(false);
	Image image4 =Toolkit.getDefaultToolkit().getImage("src/App/modules/users/Admin/views/img/administrator.png");
	Change_user.setIconImage(image4);   
        Change_user.Addatebirthdaytext.setDateFormatString(Config.getinstance().getDate_format());
        Change_user.AdReturnbtn.setText("Sign out");
        //Change.Adhiredatetext.setEnabled(false);
       // Change_user.jComboBox2.setEnabled(false);
        Change_user.AdActivitytext.setEnabled(false);
       
       
         this.Change_user.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		Change_user.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
               
                Change_user.dispose();
                 //new interfaz_Admin().setVisible(true);  
                 //new Controlador_User_reg(new interfaz_User_reg(), 0).Start(0);                   
                 new Controler_main_menu(new Sign_in(), 2).Start(2);
            
            }
        });   
                                  
            Change_user.ADEmailtext.setActionCommand("Change_UsEmailtext");
            Change_user.ADEmailtext.setName("Change_UsEmailtext");
            Change_user.ADEmailtext.addKeyListener(this);
            Change_user.ADEmailtext.addActionListener(this);
            
            Change_user.AdActivitytext.setActionCommand("Change_UsActivitytext");
            Change_user.AdActivitytext.setName("Change_UsActivitytext");
            Change_user.AdActivitytext.addKeyListener(this);
            Change_user.AdActivitytext.addActionListener(this);                
               
                
            Change_user.AdChange_Avatar.setActionCommand("Change_UsChange_Avatar");
            Change_user.AdChange_Avatar.setName("Change_UsChange_Avatar");
            Change_user.AdChange_Avatar.addKeyListener(this);
            Change_user.AdChange_Avatar.addActionListener(this);    
            
            Change_user.AdIDtext.setActionCommand("Change_UsIDtext");
            Change_user.AdIDtext.setName("Change_UsIDtext");
            Change_user.AdIDtext.addKeyListener(this);
            Change_user.AdIDtext.addActionListener(this);
            
            Change_user.AdMobiltext.setActionCommand("Change_UsMobiltext");
            Change_user.AdMobiltext.setName("Change_UsMobiltext");
            Change_user.AdMobiltext.addKeyListener(this);
            Change_user.AdMobiltext.addActionListener(this);
            
            Change_user.AdNametext.setActionCommand("Change_UsNametext");
            Change_user.AdNametext.setName("Change_UsNametext");
            Change_user.AdNametext.addKeyListener(this);
            Change_user.AdNametext.addActionListener(this);    
            
            Change_user.AdPasstext.setActionCommand("Change_UsPasstext");
            Change_user.AdPasstext.setName("Change_UsPasstext");
            
            Change_user.AdPasstext.addKeyListener(this);
            Change_user.AdPasstext.addActionListener(this); 
            Change_user.AdPasstext.addFocusListener(this);
            
            Change_user.AdReturnbtn.setActionCommand("Change_UsReturnbtn");
            Change_user.AdReturnbtn.setName("Change_UsReturnbtn");            
            Change_user.AdReturnbtn.addActionListener(this);
            
            Change_user.AdSavebtn.setActionCommand("Change_UsSavebtn");
            Change_user.AdSavebtn.setName("Change_UsSavebtn");            
            Change_user.AdSavebtn.addActionListener(this);
            
            Change_user.AdSurnametext.setActionCommand("Change_UsSurnametext");
            Change_user.AdSurnametext.setName("Change_UsSurnametext");
            Change_user.AdSurnametext.addKeyListener(this);
            Change_user.AdSurnametext.addActionListener(this); 
            
            Change_user.AdUsernametext.setActionCommand("Change_UsUsernametext");
            Change_user.AdUsernametext.setName("Change_UsUsernametext");
            Change_user.AdUsernametext.addKeyListener(this);
            Change_user.AdUsernametext.addActionListener(this);
                       
            Change_user.Addatebirthdaytext.setName("Change_Usdatebirthdaytext");
            Change_user.Addatebirthdaytext.addKeyListener(this);
                    
             
             
             
         break;
       
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
           
            case Sign_in_btn:
                
                
                
        if (Sign_in_BLL.Select_Admin_Sql() == 1) {

            // JOptionPane.showMessageDialog(null, Singleton_App.DB_dni);
            sign_in.dispose();
            
            new Controler_main_menu(new First_menu(), 0).Start(0);

        } else if (Sign_in_BLL.Select_client_mongo() == 1) {

            sign_in.dispose();
            
            Client_BLL.modify_from_client();
            //  new Controlador_Client(new Change_Client(), 2).Start(2);

        } else if (Sign_in_DAO.search_Us_array() == 1) {
            
             sign_in.dispose();

            User_reg_BLL.modify_from_user();

        } else {

            sign_in.Error_label.setOpaque(true);
            sign_in.Error_label.setForeground(Color.red);
            sign_in.Error_label.setText("ERROR, USUARIO NO ENCONTRADO!!!");

        }
                
                
                break;   
                
                
          case btn_sign_out:
              
               First.dispose();
               
                new Controler_main_menu(new Sign_in(), 2).Start(2);
              
              break;
              
              
              
         case Change_AdSavebtn:
                 
               if( Client_BLL.change_client()==true){
                    
             Timer timer =new Timer(3000,new ActionListener(){
               
               @Override
               public void actionPerformed(ActionEvent e){
                   //Change.dispose();
                   
                     //  new Controlador_Client(new interfaz_Client(), 0).Start(0);     
                    
                       Change.jLabel1.setOpaque(false);
                        
                        Change.jLabel1.setText(""); 
                       
               }
           });
             
             //jLabel1.setText("Admin creado con gracia");
             
             timer.setRepeats(false);
             timer.start();
             
             Change.AdSavebtn.setEnabled(false);
            // Change.AdReturnbtn.setEnabled(false);
             Change.AdChange_Avatar.setEnabled(false);
             Change.jLabel1.setOpaque(true);
             Change.jLabel1.setBackground(Color.green);
             Change.jLabel1.setText("Cliente modificado correctamente");                         
       
         }  
              
               break;
               
             case Change_AdReturnbtn:
                 
                  Change.dispose();
        
                  new Controler_main_menu(new Sign_in(), 2).Start(2);                    
                                
                 break;
             
             case Change_AdChange_Avatar:
                 
                  Client_BLL.Change_Change_Avatar();
                 
                 break;     
                 
                 
            case Change_UsSavebtn:
                 
               if( User_reg_BLL.change_user_reg() == true){
                    
             Timer timer =new Timer(3000,new ActionListener(){
               
               @Override
               public void actionPerformed(ActionEvent e){
                   //Change_user.dispose();
                   
                       //new Controlador_User_reg(new interfaz_User_reg(), 0).Start(0);                
                       Change_user.jLabel1.setOpaque(false);
                        
                        Change_user.jLabel1.setText(""); 
                         
                       
               }
           });
             
             //jLabel1.setText("Admin creado con gracia");
             
             timer.setRepeats(false);
             timer.start();
             
             Change_user.AdSavebtn.setEnabled(false);             
             Change_user.AdReturnbtn.setEnabled(false);
             //Change_user.AdChange_Avatar.setEnabled(false);
             Change_user.jLabel1.setOpaque(true);
             Change_user.jLabel1.setBackground(Color.green);
             Change_user.jLabel1.setText("User modificado correctamente");                         
       
         }  
              
               break;
               
             case Change_UsReturnbtn:
                 
                  Change_user.dispose();
        
                  //new Controlador_User_reg(new interfaz_User_reg(), 0).Start(0);   
                  new Controler_main_menu(new Sign_in(), 2).Start(2);
                  
                  
                 break;
             
             case Change_UsChange_Avatar:
                 
                  User_reg_BLL.Change_Change_Avatar();
                 
                 break;      
                
        }
        
      
        
        
    }
    
    @Override
    public void focusGained(FocusEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void focusLost(FocusEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
        switch (Action.valueOf(e.getComponent().getName())){
       
        case Change_AdNametext:
                
             Client_BLL.Change_requests_name(); 
                
                break;
                
            case Change_AdSurnametext:
                
               Client_BLL.Change_requests_surname(); 
                
                break;
                
            case Change_AdMobiltext:
                
                Client_BLL.Change_ask_mobil();
                
                break;
                
            case Change_ADEmailtext:
                
                 Client_BLL.Change_ask_email();
                
                break;
                
            case Change_AdUsernametext:
                
                Client_BLL.Change_ask_username();
                
                break;
                
                
            case Change_AdPasstext:
                
                Client_BLL.Change_ask_pass();
                
                break;
                
            case Change_AdActivitytext:
                
                Client_BLL.Change_ask_sopping();
                
                break;
                
                
             case Change_Client_type:
                
                Client_BLL.Change_ask_client_type();
                
                break;    
            
                
                
             case Change_UsNametext:
                
             User_reg_BLL.Change_requests_name(); 
                
                break;
                
            case Change_UsSurnametext:
                
               User_reg_BLL.Change_requests_surname(); 
                
                break;
                
            case Change_UsMobiltext:
                
                User_reg_BLL.Change_ask_mobil();
                
                break;
                
            case Change_UsEmailtext:
                
                 User_reg_BLL.Change_ask_email();
                
                break;
                
            case Change_UsUsernametext:
                
                User_reg_BLL.Change_ask_username();
                
                break;
                
                
            case Change_UsPasstext:
                
                User_reg_BLL.Change_ask_pass();
                
                break;
                
            case Change_UsActivitytext:
                
                User_reg_BLL.Change_ask_Activity();
                
                break;
               
                
                
                
        }
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
        
        
    }
    
    
    
    
    
    
    
    
    

