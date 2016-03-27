/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App.modules.users.Client.controler;

import App.modules.main_menu.Controler.Controler_main_menu;
import App.modules.main_menu.model.Config;
import App.modules.main_menu.views.Menu;
import App.modules.users.Client.Model.Classes.Singleton_cli;
import App.modules.users.Client.Model.Classes.miniSimpleTableModel_Client;
import App.modules.users.Client.Model.Utils.Pager.pagina;
import App.modules.users.Client.Model.Utils.autocomplete.AutocompleteJComboBox;
import App.modules.users.Client.Model.Utils.autocomplete.StringSearchable;
import App.modules.users.Client.Model.bll.Client_BLL;
import App.modules.users.Client.views.Change_Client;
import App.modules.users.Client.views.Create_Client;
import App.modules.users.Client.views.interfaz_Client;
import static App.modules.users.Client.views.interfaz_Client.TABLA;
import static App.modules.users.Client.views.interfaz_Client.jComboBox1;
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
public class Controlador_Client implements ActionListener, FocusListener, KeyListener,  MouseListener{

    public static JTable tabla =null;
    public static int e = 0;
    public static TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(new miniSimpleTableModel_Client());
    public static interfaz_Client Table_Client = new interfaz_Client();
    public static Create_Client Create_client = new Create_Client();
    public static Change_Client Change = new Change_Client();
    public static AutocompleteJComboBox combo = null;
    
    public Controlador_Client (JFrame Start, int i) {
        
        if (i==0){
            
            Table_Client = (interfaz_Client) Start;
            
        }
        
        if (i==1){
            
            Create_client = (Create_Client) Start;
                      
        }
        
        if (i==2){
            
            Change = (Change_Client) Start;           
            
        }
        
    }
    
    public enum Action {
        
        /////Table_client////
        
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
        
        //////Create_client/////
        
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
        Create_Shopping,
        Create_Client_type,
        
        
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
    }
    
        
     public void Start (int i){
         
         if (i==0){
        
        Create_client.dispose();
        Table_Client.setVisible(true);     
        Table_Client.setLocationRelativeTo(null);
        Table_Client.setTitle("Gestión Actores");
        Table_Client.setResizable(false);
        Image image =Toolkit.getDefaultToolkit().getImage("src/App/modules/users/Client/views/img/administrator.png");
	Table_Client.setIconImage(image);   
        
                
        Table_Client.TABLA.setModel(new miniSimpleTableModel_Client() );
        ((miniSimpleTableModel_Client)TABLA.getModel()).cargar();
        Table_Client.TABLA.setFillsViewportHeight(true);
        
       
        Table_Client.TABLA.setRowSorter(sorter);
        pagina.inicializa();
        pagina.initLinkBox();
        
        Table_Client.jLabel3.setText(String.valueOf(Singleton_cli.cli.size()));
        
        //Cerrar ventana
        
        this.Table_Client.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.Table_Client.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Table_Client.dispose();
                
                new Controler_main_menu(new Menu(), 1).Start(1);
            }
        });
          
          List<String> myWords = new ArrayList<String>();
          
        for(int e = 0;i<=Singleton_cli.cli.size()-1;i++) {
            
            myWords.add(Singleton_cli.cli.get(i).getNom());
        }

	StringSearchable searchable = new StringSearchable(myWords);
	combo = new AutocompleteJComboBox(searchable);
        //JPanel5 se utiliza solamente para que JPanel3 que contendrá combo, no se redimensione
        Table_Client.jPanel3.setLayout(new java.awt.BorderLayout());
        Table_Client.jPanel3.add(combo);
        
         combo.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboActionPerformed(evt);
                
            }
        });                        
                
         ///////////////////////
         
          Table_Client.ANTERIOR.setActionCommand("ANTERIOR");
            Table_Client.ANTERIOR.addActionListener(this);
            
          Table_Client.Adcreate.setActionCommand("Adcreate");
            Table_Client.Adcreate.addActionListener(this);  
         
          Table_Client.Adedit.setActionCommand("Adedit");
            Table_Client.Adedit.addActionListener(this); 
         
         Table_Client.Adreturnbtn.setActionCommand("Adreturnbtn");
            Table_Client.Adreturnbtn.addActionListener(this);           
            
          Table_Client.Delete_btn.setActionCommand("Delete_btn");
            Table_Client.Delete_btn.addActionListener(this);   
            
           Table_Client.Jsonbnt.setActionCommand("Jsonbnt");
            Table_Client.Jsonbnt.addActionListener(this);  
            
             Table_Client.SIGUIENTE.setActionCommand("SIGUIENTE");
            Table_Client.SIGUIENTE.addActionListener(this);
            
            Table_Client.Txtbtn.setActionCommand("Txtbtn");
            Table_Client.Txtbtn.addActionListener(this);
            
            Table_Client.Xmlbnt.setActionCommand("Xmlbnt");
            Table_Client.Xmlbnt.addActionListener(this);
            
            Table_Client.primero.setActionCommand("primero");
            Table_Client.primero.addActionListener(this);
            
            Table_Client.ultimo.setActionCommand("ultimo");
            Table_Client.ultimo.addActionListener(this);
            
            Table_Client.jComboBox1.setActionCommand("jComboBox1");
            Table_Client.jComboBox1.addActionListener(this);
            
         
        }//Fi del if Tabla_client
         
         if (i == 1) {
             
             //Config.getinstance().getTheme();
        Create_client.setVisible(true);        
        Create_client.setTitle("Client_Table");
	Create_client.setSize(535,730);//ancho x alto
        Create_client.setLocationRelativeTo(null);
	Create_client.setResizable(false);
	Image image =Toolkit.getDefaultToolkit().getImage("src/App/modules/users/Client/views/img/administrator.png");
	Create_client.setIconImage(image);   
        Create_client.Addatebirthdaytext.setDateFormatString(Config.getinstance().getDate_format());
        Create_client.Adhiredatetext.setDateFormatString(Config.getinstance().getDate_format());
       // AdAvatar.setSize(90,90);
        ////Cerrar ventana
       
         this.Create_client.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		Create_client.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
               
                Create_client.dispose();
                 //new interfaz_Admin().setVisible(true);  
                 new Controlador_Client(new interfaz_Client(), 0).Start(0);                       
            }
        });   
                                  
            Create_client.ADEmailtext.setActionCommand("Create_ADEmailtext");
            Create_client.ADEmailtext.setName("Create_ADEmailtext");
            Create_client.ADEmailtext.addKeyListener(this);
            Create_client.ADEmailtext.addActionListener(this);
            
            Create_client.AdActivitytext.setActionCommand("Create_AdActivitytext");
            Create_client.AdActivitytext.setName("Create_AdActivitytext");
            Create_client.AdActivitytext.addKeyListener(this);
            Create_client.AdActivitytext.addActionListener(this);
                
            Create_client.AdCancelbtn.setActionCommand("Create_AdCancelbtn");
            Create_client.AdCancelbtn.setName("Create_AdCancelbtn");            
            Create_client.AdCancelbtn.addActionListener(this);    
                
            Create_client.AdCargarAvatar.setActionCommand("Create_AdCargarAvatar");
            Create_client.AdCargarAvatar.setName("Create_AdCargarAvatar");
            Create_client.AdCargarAvatar.addKeyListener(this);
            Create_client.AdCargarAvatar.addActionListener(this);    
            
            Create_client.AdIDtext.setActionCommand("Create_AdIDtext");
            Create_client.AdIDtext.setName("Create_AdIDtext");
            Create_client.AdIDtext.addKeyListener(this);
            Create_client.AdIDtext.addActionListener(this);
            
            Create_client.AdMobiltext.setActionCommand("Create_AdMobiltext");
            Create_client.AdMobiltext.setName("Create_AdMobiltext");
            Create_client.AdMobiltext.addKeyListener(this);
            Create_client.AdMobiltext.addActionListener(this);
            
            Create_client.AdNametext.setActionCommand("Create_AdNametext");
            Create_client.AdNametext.setName("Create_AdNametext");
            Create_client.AdNametext.addKeyListener(this);
            Create_client.AdNametext.addActionListener(this);    
            
            Create_client.AdPasstext.setActionCommand("Create_AdPasstext");
            Create_client.AdPasstext.setName("Create_AdPasstext");
            
            Create_client.AdPasstext.addKeyListener(this);
            Create_client.AdPasstext.addActionListener(this); 
            Create_client.AdPasstext.addFocusListener(this);
            
            Create_client.AdReturnbtn.setActionCommand("Create_AdReturnbtn");
            Create_client.AdReturnbtn.setName("Create_AdReturnbtn");            
            Create_client.AdReturnbtn.addActionListener(this);
            
            Create_client.AdSavebtn.setActionCommand("Create_AdSavebtn");
            Create_client.AdSavebtn.setName("Create_AdSavebtn");            
            Create_client.AdSavebtn.addActionListener(this);
            
            Create_client.AdSurnametext.setActionCommand("Create_AdSurnametext");
            Create_client.AdSurnametext.setName("Create_AdSurnametext");
            Create_client.AdSurnametext.addKeyListener(this);
            Create_client.AdSurnametext.addActionListener(this); 
            
            Create_client.AdUsernametext.setActionCommand("Create_AdUsernametext");
            Create_client.AdUsernametext.setName("Create_AdUsernametext");
            Create_client.AdUsernametext.addKeyListener(this);
            Create_client.AdUsernametext.addActionListener(this);
                       
            Create_client.Addatebirthdaytext.setName("Create_Addatebirthdaytext");
            Create_client.Addatebirthdaytext.addKeyListener(this);
           
            Create_client.Adhiredatetext.setName("Change_Adhiredatetext");
            Create_client.Adhiredatetext.addKeyListener(this);     
            
            Create_client.Client_type_text.setName("Create_Client_type");
            Create_client.Client_type_text.addKeyListener(this);
            
            
            
      //  
            
            
         }//Fi del if Create_Admin
         
         
          if (i == 2) {
              
        Change.setVisible(true);        
        Change.setTitle("Admin_Table");
	Change.setSize(535,690);//ancho x alto
        Change.setLocationRelativeTo(null);
	Change.setResizable(false);
	Image image =Toolkit.getDefaultToolkit().getImage("src/App/modules/users/Client/views/img/administrator.png");
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
                 new Controlador_Client(new interfaz_Client(), 0).Start(0);                       
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
            Create_client.AdPasstext.setName("Change_AdPasstext");
            
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
            
            
              
          }//Fi del if Change_Admin
         
         
         
         
     }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        switch (Controlador_Client.Action.valueOf(e.getActionCommand())){
            
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
                
                 Table_Client.setVisible(false);

        //new Create_Admin().setVisible(true);
                 new Controlador_Client(new Create_Client(), 1).Start(1);
                 
                 break;
                 
            case  Adreturnbtn:
                
                 Table_Client.dispose();

                 new Controler_main_menu(new Menu(), 1).Start(1);
                 
       // new Menu().setVisible(true);
                 
                 break;
                 
            case  Delete_btn:
                
              Client_BLL.Delete_Admin();
              
            break;
              
            case  Jsonbnt:
                              
               Client_BLL.save_json();
         
               break;
               
               
            case  Xmlbnt:
                
                Client_BLL.save_xml();
                
               break;
                
            case   Txtbtn:
                
                Client_BLL.save_txt();
                
                break;
                
            case  Adedit:
                
                if (Client_BLL.Charge_Change_Client()==true){
        
             Table_Client.dispose();//estava set visible false      
                                        
         }   
                
               break;
                
            case  Create_AdMobiltext:
                
                Client_BLL.ask_mobil();
                
               break;     
               
               
             case  Create_AdSavebtn:
                
                if( Client_BLL.save_client()==true){                                 
                    
                    
           Timer timer =new Timer(3000,new ActionListener(){
               
               @Override
               public void actionPerformed(ActionEvent e){
                   
                   
                   Create_client.dispose();
                   
                    new Controlador_Client(new interfaz_Client(), 0).Start(0); 
                   
                    Create_client.dispose();
                             
               }
           });                  
             
             timer.setRepeats(false);
             timer.start();
             Create_client.AdSavebtn.setEnabled(false);
             Create_client.AdCancelbtn.setEnabled(false);
             Create_client.AdReturnbtn.setEnabled(false);
             Create_client.AdCargarAvatar.setEnabled(false);
             Create_client.jLabel1.setOpaque(true);
             Create_client.jLabel1.setBackground(Color.green);
             Create_client.jLabel1.setText("Client creado correctamente");                      
           
       } 
                
               break;   
               
             case  Create_AdReturnbtn:
                 
                 Create_client.dispose();
        
                 new Controlador_Client(new interfaz_Client(), 0).Start(0);
                 
                 break;
               
             case  Create_AdCargarAvatar:
                 
                 Client_BLL.charge_avatar();
                 
                 
                 break;
               
             case Change_AdSavebtn:
                 
               if( Client_BLL.change_client()==true){
                    
             Timer timer =new Timer(3000,new ActionListener(){
               
               @Override
               public void actionPerformed(ActionEvent e){
                   Change.dispose();
                   
                       new Controlador_Client(new interfaz_Client(), 0).Start(0);                
                                     
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
        
                  new Controlador_Client(new interfaz_Client(), 0).Start(0);                    
                                
                 break;
             
             case Change_AdChange_Avatar:
                 
                  Client_BLL.Change_Change_Avatar();
                 
                 break; 
                                  
               
         }
        
        
    }

    @Override
    public void focusGained(FocusEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
      switch (Action.valueOf(e.getComponent().getName())){
          
          case Create_AdPasstext:
              
              Create_client.AdPasstext.setText("");
              
              break;
              
          case Change_AdPasstext:
              
               Create_client.AdPasstext.setText("");
              
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
            
               Client_BLL.requests_name(); 
                
            break;        
            
           }
        
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
        switch (Action.valueOf(e.getComponent().getName())){
            
            case Create_AdSurnametext:
            
                Client_BLL.requests_surname(); 
                
            break;      
            
            
            case Create_AdMobiltext:
            
               Client_BLL.ask_mobil();
                
            break;  
            
             case Create_ADEmailtext:
            
               Client_BLL.ask_email();
                
            break; 
            
            case Create_AdUsernametext:
            
              Client_BLL.ask_username();
                
            break;
            
            case Create_AdPasstext:
            
             Client_BLL.ask_pass();
                
            break;
            
             case  Create_AdActivitytext:
            
             Client_BLL.ask_Sopping();
                
            break;
            
            
             case  Create_AdIDtext:
            
             Client_BLL.ask_ID();
                
            break;
            
            
            case  Create_AdNametext:
            
             Client_BLL.requests_name();
                
            break;
            
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
                
                  
            case Create_Client_type:
                
                Client_BLL.ask_client_type();
                
                break;
                
                
             case Change_Client_type:
                
                Client_BLL.Change_ask_client_type();
                
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
        ((miniSimpleTableModel_Client)TABLA.getModel()).filtrar();
      


    combo.requestFocus();
    } 
    
    
}
