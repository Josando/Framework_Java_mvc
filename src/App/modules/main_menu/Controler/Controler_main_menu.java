/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App.modules.main_menu.Controler;

import App.modules.main_menu.views.First_menu;
import App.modules.main_menu.views.Menu;
import static com.sun.java.accessibility.util.AWTEventMonitor.addWindowListener;
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

    public static First_menu First = new First_menu();
    public static Menu Menu_users = new Menu(); 
    
    
    
    public Controler_main_menu(JFrame Start, int i){
        
        if (i==0){
            
            First = (First_menu) Start;
        }
        
         if (i==0){
            
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
            
        First.setTitle("Main menu");
        First.setLocationRelativeTo(null);
        First.setSize(720, 500);//ancho x alto
        First.setResizable(false);
        Image image = Toolkit.getDefaultToolkit().getImage("src/App/modules/main_menu/views/img/IMG_0279.JPG");
        First.setIconImage(image);
        First_menu.btn_Config.setOpaque(false);
        First_menu.btn_Config.setContentAreaFilled(false);
        First_menu.btn_Config.setBorderPainted(false);
        First_menu.btn_employees.setOpaque(false);
        First_menu.btn_employees.setContentAreaFilled(false);
        First_menu.btn_employees.setBorderPainted(false);

        ////Cerrar ventana
        First.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                JOptionPane.showMessageDialog(null, "Saliendo de la aplicación");
                First.dispose();
                System.exit(0);

            }
        });

    }

   if (i == 1) {
       
       
            
            
            
        }
        
        
        
}
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
    
    
    
    
}
