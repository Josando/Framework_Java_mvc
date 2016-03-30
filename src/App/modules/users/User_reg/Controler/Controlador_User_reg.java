/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App.modules.users.User_reg.Controler;

import App.modules.main_menu.Controler.Controler_main_menu;
import App.modules.main_menu.model.Config;
import App.modules.main_menu.views.Menu;
import App.modules.users.User_reg.Model.Classes.Singleton_user_reg;
import App.modules.users.User_reg.Model.Classes.miniSimpleTableModel_User_reg;
import App.modules.users.User_reg.Model.Utils.Pager.pagina;
import App.modules.users.User_reg.Model.Utils.autocomplete.AutocompleteJComboBox;
import App.modules.users.User_reg.Model.Utils.autocomplete.StringSearchable;
import App.modules.users.User_reg.Model.bll.User_reg_BLL;
import App.modules.users.User_reg.Views.Change_User_reg;
import App.modules.users.User_reg.Views.Create_User_reg;
import App.modules.users.User_reg.Views.interfaz_User_reg;
import static App.modules.users.User_reg.Views.interfaz_User_reg.TABLA;
import static App.modules.users.User_reg.Views.interfaz_User_reg.jComboBox1;
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
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.Timer;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Jorge
 */
public class Controlador_User_reg implements ActionListener, FocusListener, KeyListener,  MouseListener{

    public static JTable tabla =null;
    public static int e = 0;
    public static TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(new miniSimpleTableModel_User_reg());
    public static interfaz_User_reg Table_User_reg = new interfaz_User_reg();
    public static Create_User_reg Create = new Create_User_reg();
    public static Change_User_reg Change = new Change_User_reg();
    public static AutocompleteJComboBox combo = null;
    
    public Controlador_User_reg (JFrame Start, int i) {
        
        if (i==0){
            
            Table_User_reg = (interfaz_User_reg) Start;
            
        }
        
        if (i==1){
            
            Create = (Create_User_reg) Start;
                      
        }
        
        if (i==2){
            
            Change = (Change_User_reg) Start;           
            
        }
        
    }
    
    public enum Action {
        
        /////Table_admin////
        
        ANTERIOR,
        Adcreate,
        Adedit,
        Adreturnbtn,
        Delete_btn,
        Jsonbnt,
        SIGUIENTE,
        Txtbtn,
        Xmlbnt,
        //jButton1,
        primero,
        ultimo,
        jComboBox1,
        
        //////Create_Admin/////
        
        Create_ADEmailtext,
        Create_AdActivitytext,
        Create_AdCancelbtn,
        Create_AdCargarAvatar,
        Create_AdIDtext,
        Create_AdMobiltext,
        Create_AdNametext,
        Create_AdPasstext,
        Create_AdReturnbtn,
        Create_AdSavebtn,
        Create_AdSurnametext,
        Create_AdUsernametext,
        Create_Addatebirthdaytext,
        //Create_Adhiredatetext,
        
        
        ////Change_Admin////
        
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
        //Change_Adhiredatetext,
    }
    
        
     public void Start (int i){
         
         if (i==0){
        
        Table_User_reg.setVisible(true);     
        Table_User_reg.setLocationRelativeTo(null);
        Table_User_reg.setTitle("User_reg table");
        Table_User_reg.setResizable(false);
        Image image =Toolkit.getDefaultToolkit().getImage("src/App/modules/users/User_reg/views/img/1459292287_user_anonymous.png");
	Table_User_reg.setIconImage(image);   
        
                
        Table_User_reg.TABLA.setModel(new miniSimpleTableModel_User_reg());
        ((miniSimpleTableModel_User_reg)TABLA.getModel()).cargar();
        Table_User_reg.TABLA.setFillsViewportHeight(true);
        
       
        Table_User_reg.TABLA.setRowSorter(sorter);
        pagina.inicializa();
        pagina.initLinkBox();
        
      Table_User_reg.jLabel3.setText(String.valueOf(Singleton_user_reg.us.size()));
        
        //Cerrar ventana
        
        this.Table_User_reg.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.Table_User_reg.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Table_User_reg.dispose();
                
                new Controler_main_menu(new Menu(), 1).Start(1);
            }
        });
          
          List<String> myWords = new ArrayList<String>();
          
        for(int e = 0;e<=Singleton_user_reg.us.size()-1;e++) {
            
            myWords.add(Singleton_user_reg.us.get(e).getNom());
        }

	StringSearchable searchable = new StringSearchable(myWords);
	combo = new AutocompleteJComboBox(searchable);
        //JPanel5 se utiliza solamente para que JPanel3 que contendrá combo, no se redimensione
        Table_User_reg.jPanel3.setLayout(new java.awt.BorderLayout());
        Table_User_reg.jPanel3.add(combo);
        
         combo.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboActionPerformed(evt);
                
            }
        });                        
                
         ///////////////////////
         
          Table_User_reg.ANTERIOR.setActionCommand("ANTERIOR");
            Table_User_reg.ANTERIOR.addActionListener(this);
            
          Table_User_reg.Adcreate.setActionCommand("Adcreate");
            Table_User_reg.Adcreate.addActionListener(this);  
         
          Table_User_reg.Adedit.setActionCommand("Adedit");
            Table_User_reg.Adedit.addActionListener(this); 
         
         Table_User_reg.Adreturnbtn.setActionCommand("Adreturnbtn");
            Table_User_reg.Adreturnbtn.addActionListener(this);           
            
          Table_User_reg.Delete_btn.setActionCommand("Delete_btn");
            Table_User_reg.Delete_btn.addActionListener(this);   
            
           Table_User_reg.Jsonbnt.setActionCommand("Jsonbnt");
            Table_User_reg.Jsonbnt.addActionListener(this);  
            
             Table_User_reg.SIGUIENTE.setActionCommand("SIGUIENTE");
            Table_User_reg.SIGUIENTE.addActionListener(this);
            
            Table_User_reg.Txtbtn.setActionCommand("Txtbtn");
            Table_User_reg.Txtbtn.addActionListener(this);
            
            Table_User_reg.Xmlbnt.setActionCommand("Xmlbnt");
            Table_User_reg.Xmlbnt.addActionListener(this);
            
            Table_User_reg.primero.setActionCommand("primero");
            Table_User_reg.primero.addActionListener(this);
            
            Table_User_reg.ultimo.setActionCommand("ultimo");
            Table_User_reg.ultimo.addActionListener(this);
            
            Table_User_reg.jComboBox1.setActionCommand("jComboBox1");
            Table_User_reg.jComboBox1.addActionListener(this);
            
         
        }//Fi del if Tabla_admin
         
         if (i == 1) {
             
             //Config.getinstance().getTheme();
              Create.setVisible(true);        
        Create.setTitle("Create user Table");
	Create.setSize(520,550);//ancho x alto
        Create.setLocationRelativeTo(null);
	Create.setResizable(false);
	Image image =Toolkit.getDefaultToolkit().getImage("src/App/modules/users/User_reg/views/img/1459292287_user_anonymous.png");
	Create.setIconImage(image);   
        Create.Addatebirthdaytext.setDateFormatString(Config.getinstance().getDate_format());
       // Create.Adhiredatetext.setDateFormatString(Config.getinstance().getDate_format());
       // AdAvatar.setSize(90,90);
        ////Cerrar ventana
       
         this.Create.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		Create.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
               
                Create.dispose();
                 //new interfaz_Admin().setVisible(true);  
                 new Controlador_User_reg(new interfaz_User_reg(), 0).Start(0);                       
            }
        });   
                                  
            Create.ADEmailtext.setActionCommand("Create_ADEmailtext");
            Create.ADEmailtext.setName("Create_ADEmailtext");
            Create.ADEmailtext.addKeyListener(this);
            Create.ADEmailtext.addActionListener(this);
            
            Create.AdActivitytext.setActionCommand("Create_AdActivitytext");
            Create.AdActivitytext.setName("Create_AdActivitytext");
            Create.AdActivitytext.addKeyListener(this);
            Create.AdActivitytext.addActionListener(this);
               
                
            Create.AdCargarAvatar.setActionCommand("Create_AdCargarAvatar");
            Create.AdCargarAvatar.setName("Create_AdCargarAvatar");
            Create.AdCargarAvatar.addKeyListener(this);
            Create.AdCargarAvatar.addActionListener(this);    
            
            Create.AdIDtext.setActionCommand("Create_AdIDtext");
            Create.AdIDtext.setName("Create_AdIDtext");
            Create.AdIDtext.addKeyListener(this);
            Create.AdIDtext.addActionListener(this);
            
            Create.AdMobiltext.setActionCommand("Create_AdMobiltext");
            Create.AdMobiltext.setName("Create_AdMobiltext");
            Create.AdMobiltext.addKeyListener(this);
            Create.AdMobiltext.addActionListener(this);
            
            Create.AdNametext.setActionCommand("Create_AdNametext");
            Create.AdNametext.setName("Create_AdNametext");
            Create.AdNametext.addKeyListener(this);
            Create.AdNametext.addActionListener(this);    
            
            Create.AdPasstext.setActionCommand("Create_AdPasstext");
            Create.AdPasstext.setName("Create_AdPasstext");
            
            Create.AdPasstext.addKeyListener(this);
            Create.AdPasstext.addActionListener(this); 
            Create.AdPasstext.addFocusListener(this);
            
            Create.AdReturnbtn.setActionCommand("Create_AdReturnbtn");
            Create.AdReturnbtn.setName("Create_AdReturnbtn");            
            Create.AdReturnbtn.addActionListener(this);
            
            Create.AdSavebtn.setActionCommand("Create_AdSavebtn");
            Create.AdSavebtn.setName("Create_AdSavebtn");            
            Create.AdSavebtn.addActionListener(this);
            
            Create.AdSurnametext.setActionCommand("Create_AdSurnametext");
            Create.AdSurnametext.setName("Create_AdSurnametext");
            Create.AdSurnametext.addKeyListener(this);
            Create.AdSurnametext.addActionListener(this); 
            
            Create.AdUsernametext.setActionCommand("Create_AdUsernametext");
            Create.AdUsernametext.setName("Create_AdUsernametext");
            Create.AdUsernametext.addKeyListener(this);
            Create.AdUsernametext.addActionListener(this);
                       
            Create.Addatebirthdaytext.setName("Create_Addatebirthdaytext");
            Create.Addatebirthdaytext.addKeyListener(this);
           
           // Create.Adhiredatetext.setName("Change_Adhiredatetext");
            //Create.Adhiredatetext.addKeyListener(this);            
            
         }//Fi del if Create_Admin
         
         
          if (i == 2) {
              
        Change.setVisible(true);        
        Change.setTitle("Admin_Table");
	Change.setSize(520,550);//ancho x alto
        Change.setLocationRelativeTo(null);
	Change.setResizable(false);
	Image image =Toolkit.getDefaultToolkit().getImage("src/App/modules/users/Admin/views/img/administrator.png");
	Change.setIconImage(image);   
        Change.Addatebirthdaytext.setDateFormatString(Config.getinstance().getDate_format());
       // Change.Adhiredatetext.setDateFormatString(Config.getinstance().getDate_format());
       // AdAvatar.setSize(90,90);
        ////Cerrar ventana
       
         this.Change.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		Change.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
               
                Change.dispose();
                 //new interfaz_Admin().setVisible(true);  
                 new Controlador_User_reg(new interfaz_User_reg(), 0).Start(0);                       
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
            Create.AdPasstext.setName("Change_AdPasstext");
            
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
           
           // Change.Adhiredatetext.setName("Change_Adhiredatetext");
            //Change.Adhiredatetext.addKeyListener(this);           
              
          }//Fi del if Change_Admin
         
         
         
         
     }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        switch (Controlador_User_reg.Action.valueOf(e.getActionCommand())){
            
            case SIGUIENTE:
            
                pagina.currentPageIndex += 1;
                pagina.initLinkBox();
                
                break;
                
            case  ANTERIOR:  
                
                pagina.currentPageIndex -= 1;
                pagina.initLinkBox(); 
                
                break;
            
            case primero:
                
               pagina.currentPageIndex = 1;
               pagina.initLinkBox(); 
                
               break;
               
            case ultimo:
                
               pagina.currentPageIndex = pagina.maxPageIndex;
               pagina.initLinkBox(); 
               
               break;
               
            case  jComboBox1:
                
                pagina.itemsPerPage=Integer.parseInt(jComboBox1.getSelectedItem().toString());
                pagina.currentPageIndex = 1;
                pagina.initLinkBox();
                
                break;
                
            case  Adcreate:
                
                 Table_User_reg.setVisible(false);

        //new Create_Admin().setVisible(true);
                 new Controlador_User_reg(new Create_User_reg(), 1).Start(1);
                 
                 break;
                 
            case  Adreturnbtn:
                
                 Table_User_reg.dispose();

                 new Controler_main_menu(new Menu(), 1).Start(1);
                 
       // new Menu().setVisible(true);
                 
                 break;
                 
            case  Delete_btn:
                
                User_reg_BLL.Delete_user_reg();
              
            break;
              
            case  Jsonbnt:
                              
               User_reg_BLL.save_json();
         
               break;
               
               
            case  Xmlbnt:
                
                User_reg_BLL.save_xml();
                
               break;
                
            case   Txtbtn:
                
                User_reg_BLL.save_txt();
                
                break;
                
            case  Adedit:
                
                if (User_reg_BLL.Charge_Change_User_reg()==true){
        
             Table_User_reg.dispose();//estava set visible false      
                                        
         }   
                
               break;
                
            case  Create_AdMobiltext:
                
                User_reg_BLL.ask_mobil();
                
               break;     
               
               
             case  Create_AdSavebtn:
                
                if( User_reg_BLL.save_user_reg()==true){
             
           Timer timer =new Timer(3000,new ActionListener(){
               
               @Override
               public void actionPerformed(ActionEvent e){
                   Create.dispose();
                   
                  new Controlador_User_reg(new interfaz_User_reg(), 0).Start(0);                 
               }
           });                  
             
             timer.setRepeats(false);
             timer.start();
             Create.AdSavebtn.setEnabled(false);            
             Create.AdReturnbtn.setEnabled(false);
             Create.AdCargarAvatar.setEnabled(false);
             Create.jLabel1.setOpaque(true);
             Create.jLabel1.setBackground(Color.green);
             Create.jLabel1.setText("Admin creado correctamente");                      
           
       } 
                
               break;   
               
             case  Create_AdReturnbtn:
                 
                 Create.dispose();
        
                 new Controlador_User_reg(new interfaz_User_reg(), 0).Start(0);
                 
                 break;
               
             case  Create_AdCargarAvatar:
                 
                 User_reg_BLL.charge_avatar();
                 
                 
                 break;
               
             case Change_AdSavebtn:
                 
               if( User_reg_BLL.change_user_reg() == true){
                    
             Timer timer =new Timer(3000,new ActionListener(){
               
               @Override
               public void actionPerformed(ActionEvent e){
                   Change.dispose();
                   
                       new Controlador_User_reg(new interfaz_User_reg(), 0).Start(0);                
                                     
               }
           });
             
             //jLabel1.setText("Admin creado con gracia");
             
             timer.setRepeats(false);
             timer.start();
             
             Change.AdSavebtn.setEnabled(false);             
             Change.AdReturnbtn.setEnabled(false);
             Change.AdChange_Avatar.setEnabled(false);
             Change.jLabel1.setOpaque(true);
             Change.jLabel1.setBackground(Color.green);
             Change.jLabel1.setText("Admin modificado correctamente");                         
       
         }  
              
               break;
               
             case Change_AdReturnbtn:
                 
                  Change.dispose();
        
                  new Controlador_User_reg(new interfaz_User_reg(), 0).Start(0);                    
                                
                 break;
             
             case Change_AdChange_Avatar:
                 
                  User_reg_BLL.Change_Change_Avatar();
                 
                 break; 
                                  
               
         }
        
        
    }

    @Override
    public void focusGained(FocusEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
      switch (Action.valueOf(e.getComponent().getName())){
          
          case Create_AdPasstext:
              
              Create.AdPasstext.setText("");
              
              break;
              
          case Change_AdPasstext:
              
               Create.AdPasstext.setText("");
              
              break;
              
          
          
    }
    
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
        
        switch (Action.valueOf(e.getComponent().getName())){
            
            case Create_AdNametext:
            
               User_reg_BLL.requests_name(); 
                
            break;        
            
           }
        
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
        switch (Action.valueOf(e.getComponent().getName())){
            
            case Create_AdSurnametext:
            
                User_reg_BLL.requests_surname(); 
                
            break;      
            
            
            case Create_AdMobiltext:
            
               User_reg_BLL.ask_mobil();
                
            break;  
            
             case Create_ADEmailtext:
            
               User_reg_BLL.ask_email();
                
            break; 
            
            case Create_AdUsernametext:
            
              User_reg_BLL.ask_username();
                
            break;
            
            case Create_AdPasstext:
            
             User_reg_BLL.ask_pass();
                
            break;
            
             case  Create_AdActivitytext:
            
             User_reg_BLL.ask_Activity();
                
            break;
            
            
             case  Create_AdIDtext:
            
             User_reg_BLL.ask_ID();
                
            break;
            
            
            case  Create_AdNametext:
            
             User_reg_BLL.requests_name();
                
            break;
            
            case Change_AdNametext:
                
             User_reg_BLL.Change_requests_name(); 
                
                break;
                
            case Change_AdSurnametext:
                
               User_reg_BLL.Change_requests_surname(); 
                
                break;
                
            case Change_AdMobiltext:
                
                User_reg_BLL.Change_ask_mobil();
                
                break;
                
            case Change_ADEmailtext:
                
                 User_reg_BLL.Change_ask_email();
                
                break;
                
            case Change_AdUsernametext:
                
                User_reg_BLL.Change_ask_username();
                
                break;
                
                
            case Change_AdPasstext:
                
                User_reg_BLL.Change_ask_pass();
                
                break;
                
            case Change_AdActivitytext:
                
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
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
      public static void comboActionPerformed(java.awt.event.ActionEvent evt) {                                            
                    
        System.out.println("word selected: " + ((JComboBox)combo).getSelectedItem());
        pagina.currentPageIndex = 1;
        ((miniSimpleTableModel_User_reg)TABLA.getModel()).filtrar();
      


    combo.requestFocus();
    } 
    
    
}
