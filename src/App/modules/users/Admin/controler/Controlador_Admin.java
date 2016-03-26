/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App.modules.users.Admin.controler;

import App.modules.main_menu.Controler.Controler_main_menu;
import static App.modules.main_menu.Controler.Controler_main_menu.Menu_users;
import App.modules.main_menu.model.Config;
import App.modules.main_menu.views.Menu;
import App.modules.users.Admin.Model.Classes.Singleton;
import App.modules.users.Admin.Model.Classes.miniSimpleTableModel_Admin;
import App.modules.users.Admin.Model.Utils.Pager.pagina;
import App.modules.users.Admin.Model.Utils.autocomplete.AutocompleteJComboBox;
import App.modules.users.Admin.Model.Utils.autocomplete.StringSearchable;
import App.modules.users.Admin.Model.bll.Admin_BLL;
import App.modules.users.Admin.views.Change_Admin;
import App.modules.users.Admin.views.Create_Admin;
import App.modules.users.Admin.views.interfaz_Admin;
import static App.modules.users.Admin.views.interfaz_Admin.TABLA;
import static App.modules.users.Admin.views.interfaz_Admin.jComboBox1;
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
public class Controlador_Admin implements ActionListener, FocusListener, KeyListener,  MouseListener{

    public static JTable tabla =null;
    public static int e = 0;
    public static TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(new miniSimpleTableModel_Admin());
    public static interfaz_Admin Table_Admin = new interfaz_Admin();
    public static Create_Admin Create = new Create_Admin();
    public static Change_Admin Change = new Change_Admin();
    public static AutocompleteJComboBox combo = null;
    
    public Controlador_Admin (JFrame Start, int i) {
        
        if (i==0){
            
            Table_Admin = (interfaz_Admin) Start;
            
        }
        
        if (i==1){
            
            Create = (Create_Admin) Start;
                      
        }
        
        if (i==2){
            
            Change = (Change_Admin) Start;           
            
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
        Create_Adhiredatetext,
        
        
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
        Change_Adhiredatetext,
    }
    
        
     public void Start (int i){
         
         if (i==0){
        
        Table_Admin.setVisible(true);     
        Table_Admin.setLocationRelativeTo(null);
        Table_Admin.setTitle("Gestión Actores");
        Table_Admin.setResizable(false);
        Image image =Toolkit.getDefaultToolkit().getImage("src/App/modules/users/Admin/views/img/administrator.png");
	Table_Admin.setIconImage(image);   
        
                
        Table_Admin.TABLA.setModel(new miniSimpleTableModel_Admin() );
        ((miniSimpleTableModel_Admin)TABLA.getModel()).cargar();
        Table_Admin.TABLA.setFillsViewportHeight(true);
        
       
        Table_Admin.TABLA.setRowSorter(sorter);
        pagina.inicializa();
        pagina.initLinkBox();
        
        Table_Admin.jLabel3.setText(String.valueOf(Singleton.ad.size()));
        
        //Cerrar ventana
        
        this.Table_Admin.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.Table_Admin.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Table_Admin.dispose();
                
                new Controler_main_menu(new Menu(), 1).Start(1);
            }
        });
          
          List<String> myWords = new ArrayList<String>();
          
        for(int e = 0;i<=Singleton.ad.size()-1;i++) {
            
            myWords.add(Singleton.ad.get(i).getNom());
        }

	StringSearchable searchable = new StringSearchable(myWords);
	combo = new AutocompleteJComboBox(searchable);
        //JPanel5 se utiliza solamente para que JPanel3 que contendrá combo, no se redimensione
        Table_Admin.jPanel3.setLayout(new java.awt.BorderLayout());
        Table_Admin.jPanel3.add(combo);
        
         combo.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboActionPerformed(evt);
                
            }
        });                        
                
         ///////////////////////
         
          Table_Admin.ANTERIOR.setActionCommand("ANTERIOR");
            Table_Admin.ANTERIOR.addActionListener(this);
            
          Table_Admin.Adcreate.setActionCommand("Adcreate");
            Table_Admin.Adcreate.addActionListener(this);  
         
          Table_Admin.Adedit.setActionCommand("Adedit");
            Table_Admin.Adedit.addActionListener(this); 
         
         Table_Admin.Adreturnbtn.setActionCommand("Adreturnbtn");
            Table_Admin.Adreturnbtn.addActionListener(this);           
            
          Table_Admin.Delete_btn.setActionCommand("Delete_btn");
            Table_Admin.Delete_btn.addActionListener(this);   
            
           Table_Admin.Jsonbnt.setActionCommand("Jsonbnt");
            Table_Admin.Jsonbnt.addActionListener(this);  
            
             Table_Admin.SIGUIENTE.setActionCommand("SIGUIENTE");
            Table_Admin.SIGUIENTE.addActionListener(this);
            
            Table_Admin.Txtbtn.setActionCommand("Txtbtn");
            Table_Admin.Txtbtn.addActionListener(this);
            
            Table_Admin.Xmlbnt.setActionCommand("Xmlbnt");
            Table_Admin.Xmlbnt.addActionListener(this);
            
            Table_Admin.jButton1.setActionCommand("jButton1");
            Table_Admin.jButton1.addActionListener(this);
            
            Table_Admin.primero.setActionCommand("primero");
            Table_Admin.primero.addActionListener(this);
            
            Table_Admin.ultimo.setActionCommand("ultimo");
            Table_Admin.ultimo.addActionListener(this);
            
            Table_Admin.jComboBox1.setActionCommand("jComboBox1");
            Table_Admin.jComboBox1.addActionListener(this);
            
         
        }//Fi del if Tabla_admin
         
         if (i == 1) {
             
             Config.getinstance().getTheme();
              Create.setVisible(true);        
        Create.setTitle("Admin_Table");
	Create.setSize(520,550);//ancho x alto
        Create.setLocationRelativeTo(null);
	Create.setResizable(false);
	Image image =Toolkit.getDefaultToolkit().getImage("src/App/modules/users/Admin/views/img/administrator.png");
	Create.setIconImage(image);   
        Create.Addatebirthdaytext.setDateFormatString(Config.getinstance().getDate_format());
        Create.Adhiredatetext.setDateFormatString(Config.getinstance().getDate_format());
       // AdAvatar.setSize(90,90);
        ////Cerrar ventana
       
         this.Create.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		Create.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
               
                Create.dispose();
                 //new interfaz_Admin().setVisible(true);  
                 new Controlador_Admin(new interfaz_Admin(), 0).Start(0);                       
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
                
            Create.AdCancelbtn.setActionCommand("Create_AdCancelbtn");
            Create.AdCancelbtn.setName("Create_AdCancelbtn");            
            Create.AdCancelbtn.addActionListener(this);    
                
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
           
            Create.Adhiredatetext.setName("Change_Adhiredatetext");
            Create.Adhiredatetext.addKeyListener(this);            
            
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
        Change.Adhiredatetext.setDateFormatString(Config.getinstance().getDate_format());
       // AdAvatar.setSize(90,90);
        ////Cerrar ventana
       
         this.Change.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		Change.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
               
                Change.dispose();
                 //new interfaz_Admin().setVisible(true);  
                 new Controlador_Admin(new interfaz_Admin(), 0).Start(0);                       
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
                
            Change.AdCancelbtn.setActionCommand("Change_AdCancelbtn");
            Change.AdCancelbtn.setName("Change_AdCancelbtn");            
            Change.AdCancelbtn.addActionListener(this);    
                
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
           
            Change.Adhiredatetext.setName("Change_Adhiredatetext");
            Change.Adhiredatetext.addKeyListener(this);           
              
          }//Fi del if Change_Admin
         
         
         
         
     }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        switch (Controlador_Admin.Action.valueOf(e.getActionCommand())){
            
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
                
                 Table_Admin.setVisible(false);

        //new Create_Admin().setVisible(true);
                 new Controlador_Admin(new Create_Admin(), 1).Start(1);
                 
                 break;
                 
            case  Adreturnbtn:
                
                 Table_Admin.dispose();

                 new Controler_main_menu(new Menu(), 1).Start(1);
                 
       // new Menu().setVisible(true);
                 
                 break;
                 
            case  Delete_btn:
                
              Admin_BLL.Delete_Admin();
              
            break;
              
            case  Jsonbnt:
                              
               Admin_BLL.save_json();
         
               break;
               
               
            case  Xmlbnt:
                
                Admin_BLL.save_xml();
                
               break;
                
            case   Txtbtn:
                
                Admin_BLL.save_txt();
                
                break;
                
            case  Adedit:
                
                if (Admin_BLL.Charge_Change_Admin()==true){
        
             Table_Admin.dispose();//estava set visible false      
                                        
         }   
                
               break;
                
            case  Create_AdMobiltext:
                
                Admin_BLL.ask_mobil();
                
               break;     
               
               
             case  Create_AdSavebtn:
                
                if( Admin_BLL.save_admin()==true){
             
           Timer timer =new Timer(3000,new ActionListener(){
               
               @Override
               public void actionPerformed(ActionEvent e){
                   Create.dispose();
                   
                  new Controlador_Admin(new interfaz_Admin(), 0).Start(0);                 
               }
           });                  
             
             timer.setRepeats(false);
             timer.start();
             Create.AdSavebtn.setEnabled(false);
             Create.AdCancelbtn.setEnabled(false);
             Create.AdReturnbtn.setEnabled(false);
             Create.AdCargarAvatar.setEnabled(false);
             Create.jLabel1.setOpaque(true);
             Create.jLabel1.setBackground(Color.green);
             Create.jLabel1.setText("Admin creado correctamente");                      
           
       } 
                
               break;   
               
             case  Create_AdReturnbtn:
                 
                 Create.dispose();
        
                 new Controlador_Admin(new interfaz_Admin(), 0).Start(0);
                 
                 break;
               
             case  Create_AdCargarAvatar:
                 
                 Admin_BLL.charge_avatar();
                 
                 
                 break;
               
             case Change_AdSavebtn:
                 
               if( Admin_BLL.change_Admin()==true){
                    
             Timer timer =new Timer(3000,new ActionListener(){
               
               @Override
               public void actionPerformed(ActionEvent e){
                   Change.dispose();
                   
                       new Controlador_Admin(new interfaz_Admin(), 0).Start(0);                
                                     
               }
           });
             
             //jLabel1.setText("Admin creado con gracia");
             
             timer.setRepeats(false);
             timer.start();
             
             Change.AdSavebtn.setEnabled(false);
             Change.AdCancelbtn.setEnabled(false);
             Change.AdReturnbtn.setEnabled(false);
             Change.AdChange_Avatar.setEnabled(false);
             Change.jLabel1.setOpaque(true);
             Change.jLabel1.setBackground(Color.green);
             Change.jLabel1.setText("Admin modificado correctamente");                         
       
         }  
              
               break;
               
             case Change_AdReturnbtn:
                 
                  Change.dispose();
        
                  new Controlador_Admin(new interfaz_Admin(), 0).Start(0);                    
                                
                 break;
             
             case Change_AdChange_Avatar:
                 
                  Admin_BLL.Change_Change_Avatar();
                 
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
            
               Admin_BLL.requests_name(); 
                
            break;        
            
           }
        
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
        switch (Action.valueOf(e.getComponent().getName())){
            
            case Create_AdSurnametext:
            
                Admin_BLL.requests_surname(); 
                
            break;      
            
            
            case Create_AdMobiltext:
            
               Admin_BLL.ask_mobil();
                
            break;  
            
             case Create_ADEmailtext:
            
               Admin_BLL.ask_email();
                
            break; 
            
            case Create_AdUsernametext:
            
              Admin_BLL.ask_username();
                
            break;
            
            case Create_AdPasstext:
            
             Admin_BLL.ask_pass();
                
            break;
            
             case  Create_AdActivitytext:
            
             Admin_BLL.ask_Activity();
                
            break;
            
            
             case  Create_AdIDtext:
            
             Admin_BLL.ask_ID();
                
            break;
            
            
            case  Create_AdNametext:
            
             Admin_BLL.requests_name();
                
            break;
            
            case Change_AdNametext:
                
             Admin_BLL.Change_requests_name(); 
                
                break;
                
            case Change_AdSurnametext:
                
               Admin_BLL.Change_requests_surname(); 
                
                break;
                
            case Change_AdMobiltext:
                
                Admin_BLL.Change_ask_mobil();
                
                break;
                
            case Change_ADEmailtext:
                
                 Admin_BLL.Change_ask_email();
                
                break;
                
            case Change_AdUsernametext:
                
                Admin_BLL.Change_ask_username();
                
                break;
                
                
            case Change_AdPasstext:
                
                Admin_BLL.Change_ask_pass();
                
                break;
                
            case Change_AdActivitytext:
                
                Admin_BLL.Change_ask_Activity();
                
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
        ((miniSimpleTableModel_Admin)TABLA.getModel()).filtrar();
      


    combo.requestFocus();
    } 
    
    
}
