/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App.modules.users.Admin.controler;

import App.modules.main_menu.Controler.Controler_main_menu;
import static App.modules.main_menu.Controler.Controler_main_menu.Menu_users;
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
             
             
             
         }//Fi del if Create_Admin
         
         
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
                
             break;
             
         }   
                
                
                
        }
        
        
    }

    @Override
    public void focusGained(FocusEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void focusLost(FocusEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
      public static void comboActionPerformed(java.awt.event.ActionEvent evt) {                                            
                    
        System.out.println("word selected: " + ((JComboBox)combo).getSelectedItem());
        pagina.currentPageIndex = 1;
        ((miniSimpleTableModel_Admin)TABLA.getModel()).filtrar();
      


    combo.requestFocus();
    } 
    
    
}
