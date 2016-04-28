/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App.modules.users.User_reg.Model.bll;

import App.modules.main_menu.Controler.Controler_main_menu;
import App.modules.main_menu.model.Config;
import App.modules.main_menu.model.Language.Language;
import App.modules.users.Client.views.Change_Client;
import App.modules.users.User.User;
import App.modules.users.User_reg.Controler.Controlador_User_reg;
import App.modules.users.User_reg.Model.Classes.Singleton_user_reg;
import App.modules.users.User_reg.Model.Classes.User_reg;
import App.modules.users.User_reg.Model.Classes.miniSimpleTableModel_User_reg;
import static App.modules.users.User_reg.Model.Classes.miniSimpleTableModel_User_reg.datosaux;
import App.modules.users.User_reg.Model.Files.File_utils.utils.json_user_reg;
import App.modules.users.User_reg.Model.Files.File_utils.utils.txt_user_reg;
import App.modules.users.User_reg.Model.Files.File_utils.utils.xml_user_reg;
import App.modules.users.User_reg.Model.Utils.Pager.pagina;
import App.modules.users.User_reg.Model.dao.User_reg_DAO;
import App.modules.users.User_reg.Views.Change_User_reg;
import static App.modules.users.User_reg.Views.interfaz_User_reg.TABLA;
import static App.modules.users.User_reg.Views.interfaz_User_reg.jLabel3;
import App.utils.Singleton_App;
import java.awt.HeadlessException;
import java.awt.Image;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Jorge
 */
public class User_reg_BLL {
    
     public static int search_Us(User_reg u) {
        for (int i = 0; i <= Singleton_user_reg.us.size(); i++) {
            
            if ((Singleton_user_reg.us.get(i).getDni()).equals(u.getDni())) {
                
                return i;
            }
        }
        return -1;
    }
    
    
    public static void imprime(ArrayList<? extends User> l)// Imprimir cada uno de los empleados del array
    {

        Iterator<? extends User> it = l.iterator();

        while (it.hasNext()) {

            User f = it.next();
            JOptionPane.showMessageDialog(null, f.toString(), "Impresion", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void requests_name() {

        User_reg_DAO.Create_requests_name();

    }

    public static void requests_surname() {

        User_reg_DAO.Create_requests_surname();

    }

    public static void ask_mobil() {

        User_reg_DAO.create_ask_mobil();

    }

    public static void ask_email() {

        User_reg_DAO.create_ask_email();

    }

    public static void ask_username() {

        User_reg_DAO.create_ask_username();

    }

    public static void ask_pass() {

        User_reg_DAO.create_ask_pass();

    }

    public static void ask_Activity() {

        User_reg_DAO.create_ask_Activity();

    }

    public static void ask_ID() {

        User_reg_DAO.create_ask_ID();

    }

    public static void control_ID() {

        User_reg_DAO.create_control_ID();

    }

    public static void valitate_date_birthday() {

        User_reg_DAO.create_validate_date_birthday();

    }
/*
    public static void valitate_hire_date() {

        User_reg_DAO.create_validate_hire_date();

    }
*/
    public static void charge_avatar() {

        User_reg_DAO.Create_Charge_Avatar();

    }

    public static boolean save_user_reg() {

        boolean b = false;

        User_reg u = User_reg_DAO.Create_Check_and_save();

        if (u != null) {

            Singleton_user_reg.us.add(u);

            json_user_reg.auto_save_user_reg_json();

            b = true;

        }

        return b;
    }

    public static boolean Charge_Change_User_reg() {

        boolean b = false;
        int filaseleccionada;
        User_reg u = null;
        int inicio, selection1, pos = 0;

        SimpleDateFormat format = new java.text.SimpleDateFormat(Config.getinstance().getDate_format());

        try {

            inicio = (pagina.currentPageIndex - 1) * pagina.itemsPerPage; //nos situamos al inicio de la página en cuestión
            filaseleccionada = TABLA.getSelectedRow(); //nos situamos en la fila
            selection1 = inicio + filaseleccionada; //nos situamos en la fila correspondiente de esa página

//            filaseleccionada = TABLA.getSelectedRow();
            if (filaseleccionada == -1) {

                JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");
                b = false;

            } else {

                 new Controlador_User_reg(new Change_User_reg(), 2).Start(2);
                
               // new Change_Admin().setVisible(true);

                //DefaultTableModel modelotabla = (DefaultTableModel) TABLA.getModel();
                String Id = (String) TABLA.getValueAt(filaseleccionada, 0);

                u = ((miniSimpleTableModel_User_reg) TABLA.getModel()).buscar(Id);

                // a = new Admin(Id);
                pos = User_reg_BLL.search_Us(u);

                if ((pos) != -1) {

                    u = Singleton_user_reg.us.get(pos);

                    Change_User_reg.AdIDtext.setText(u.getDni());
                    Change_User_reg.AdNametext.setText(u.getNom());
                    Change_User_reg.AdSurnametext.setText(u.getCognom());
                    Change_User_reg.AdMobiltext.setText(u.getMobil());
                    Change_User_reg.ADEmailtext.setText(u.getEmail());
                    Change_User_reg.AdUsernametext.setText(u.getUser());
                    Change_User_reg.AdPasstext.setText(u.getPass());
                    Change_User_reg.AdActivitytext.setText(Integer.toString(u.getActividad()));
                    //////////////////////////
                    Singleton_App.ruta_imagen = u.getAvatar();
                    //Se crea el imagen desde la string del admin
                    ImageIcon icon = new ImageIcon(Singleton_App.ruta_imagen);
                    //se extrae la imagen del icono
                    Image img = icon.getImage();
                    //cambiamos el tamaño
                    Image newimg = img.getScaledInstance(97, 97, java.awt.Image.SCALE_SMOOTH);
                    //se genera la imagen con la nueva imagen
                    ImageIcon newIcon = new ImageIcon(newimg);

                    Change_User_reg.AdAvartaimg.setIcon(newIcon);
                    Change_User_reg.AdAvartaimg.setText("");
                    Change_User_reg.AdAvartaimg.setSize(97, 97);

                    try {

                        Date date_birthday = format.parse(u.getDate_birthday().toString());
                        Change_User_reg.Addatebirthdaytext.setDate(date_birthday);
                       // Date hire_date = format.parse(u.getFecha_cont().toString());
                       // Change_User_reg.Adhiredatetext.setDate(hire_date);

                    } catch (ParseException ex) {

                        Logger.getLogger(User_reg_DAO.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } else {

                    JOptionPane.showMessageDialog(null, Language.getinstance().getProperty("error1"), Language.getinstance().getProperty("client"),
                            JOptionPane.ERROR_MESSAGE);
                    b = false;

                }

                b = true;
            }

        } catch (HeadlessException ex) {

            JOptionPane.showMessageDialog(null, "Error: " + ex + "\nInténtelo nuevamente", " .::Error En la Operacion::.", JOptionPane.ERROR_MESSAGE);

        }

        return b;
    }

    public static boolean change_user_reg() {

        User_reg u = null;
        int pos = 0;
        boolean b = false;

        u = User_reg_DAO.Change_Check_and_save();

        
        
       // pos = Admin_BLL.search_ad(a);

        if (u != null) {

            pos = User_reg_BLL.search_Us(u);
            
            Singleton_user_reg.us.set(pos, u);
            
            json_user_reg.auto_save_user_reg_json();

            b = true;

        }

        return b;
    }

    /////////////Validate para change
    public static void Change_requests_name() {

        User_reg_DAO.Change_requests_name();

    }

    public static void Change_requests_surname() {

        User_reg_DAO.Change_requests_surname();

    }

    public static void Change_ask_mobil() {

        User_reg_DAO.Change_ask_mobil();

    }

    public static void Change_ask_email() {

        User_reg_DAO.change_ask_email();

    }

    public static void Change_ask_username() {

        User_reg_DAO.change_ask_username();

    }

    public static void Change_ask_pass() {

        User_reg_DAO.change_ask_pass();

    }

    public static void Change_ask_Activity() {

        User_reg_DAO.change_ask_Activity();

    }

    public static void Change_ask_ID() {

        User_reg_DAO.change_ask_ID();

    }

    public static void Change_control_ID() {

        User_reg_DAO.change_control_ID();

    }

    public static void Change_valitate_date_birthday() {

        User_reg_DAO.change_validate_date_birthday();

    }

    /*
    public static void Change_valitate_hire_date() {

        User_reg_DAO.change_validate_hire_date();

    }
*/
    public static void Change_Change_Avatar() {

        User_reg_DAO.Change_Charge_Avatar();

    }

    public static void Delete_user_reg() {

        User_reg u = null;
        int inicio, selection, selection1;
        int filaseleccionada;

        try {

            inicio = (pagina.currentPageIndex - 1) * pagina.itemsPerPage; //nos situamos al inicio de la página en cuestión
            filaseleccionada = TABLA.getSelectedRow(); //nos situamos en la fila
            selection1 = inicio + filaseleccionada; //nos situamos en la fila correspondiente de esa página
            // JOptionPane.showMessageDialog(null, filaseleccionada);

            if (filaseleccionada == -1) {

                JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");

            } else {

                //DefaultTableModel modelotabla = (DefaultTableModel) TABLA.getModel();
                String Id = (String) TABLA.getValueAt(filaseleccionada, 0);

                u = ((miniSimpleTableModel_User_reg) TABLA.getModel()).buscar(Id);

                 int opc = JOptionPane.showConfirmDialog(null, Language.getinstance().getProperty("deleted") + Id,
                        "Info", JOptionPane.WARNING_MESSAGE);

                if (opc == 0) {
                
                int pos = ((miniSimpleTableModel_User_reg) TABLA.getModel()).buscaUsuario(u);

                ((miniSimpleTableModel_User_reg) TABLA.getModel()).removeRow(pos);
                ((miniSimpleTableModel_User_reg) TABLA.getModel()).cargar();
                // pagina.inicializa();
                // pagina.initLinkBox();

                Singleton_user_reg.us.remove(pos);
                datosaux.remove(u);
                jLabel3.setText(String.valueOf(Singleton_user_reg.us.size()));
                ((miniSimpleTableModel_User_reg) TABLA.getModel()).cargar();
                pagina.inicializa();
                pagina.initLinkBox();
                
                json_user_reg.auto_save_user_reg_json();
                
                if (Singleton_user_reg.us.size() < 6) {

                    pagina.currentPageIndex = 1;
                    pagina.initLinkBox();
                }
                }
            }

        } catch (Exception e) {

        }

    }

    public static void save_json() {
        if (!Singleton_user_reg.us.isEmpty()) {
            json_user_reg.save_user_reg_json();
        } else {
            JOptionPane.showMessageDialog(null, "No hay datos que guardar");
        }
    }

    public static void save_txt() {
        if (!Singleton_user_reg.us.isEmpty()) {
            txt_user_reg.save_user_reg_txt();
        } else {
            JOptionPane.showMessageDialog(null, "No hay datos que guardar");
        }
    }

    public static void save_xml() {
        if (!Singleton_user_reg.us.isEmpty()) {
            xml_user_reg.save_user_reg_xml();
        } else {
            JOptionPane.showMessageDialog(null, "No hay datos que guardar");
        }
    }

      public static void modify_from_user() {
          
          
                    SimpleDateFormat format = new java.text.SimpleDateFormat(Config.getinstance().getDate_format());
                   
                   // new Controlador_User_reg(new Change_User_reg(), 2).Start(2);
                    new Controler_main_menu(new Change_User_reg(), 4).Start(4);
                    
                    Change_User_reg.AdIDtext.setText(Singleton_App.u.getDni());
                    Change_User_reg.AdNametext.setText(Singleton_App.u.getNom());
                    Change_User_reg.AdSurnametext.setText(Singleton_App.u.getCognom());
                    Change_User_reg.AdMobiltext.setText(Singleton_App.u.getMobil());
                    Change_User_reg.ADEmailtext.setText(Singleton_App.u.getEmail());
                    Change_User_reg.AdUsernametext.setText(Singleton_App.u.getUser());
                    Change_User_reg.AdPasstext.setText(Singleton_App.u.getPass());
                    Change_User_reg.AdActivitytext.setText(Integer.toString(Singleton_App.u.getActividad()));
                    //////////////////////////
                    Singleton_App.ruta_imagen = Singleton_App.u.getAvatar();
                    //Se crea el imagen desde la string del admin
                    ImageIcon icon = new ImageIcon(Singleton_App.ruta_imagen);
                    //se extrae la imagen del icono
                    Image img = icon.getImage();
                    //cambiamos el tamaño
                    Image newimg = img.getScaledInstance(97, 97, java.awt.Image.SCALE_SMOOTH);
                    //se genera la imagen con la nueva imagen
                    ImageIcon newIcon = new ImageIcon(newimg);

                    Change_User_reg.AdAvartaimg.setIcon(newIcon);
                    Change_User_reg.AdAvartaimg.setText("");
                    Change_User_reg.AdAvartaimg.setSize(97, 97);

                    try {

                        Date date_birthday = format.parse(Singleton_App.u.getDate_birthday().toString());
                        Change_User_reg.Addatebirthdaytext.setDate(date_birthday);
                       // Date hire_date = format.parse(u.getFecha_cont().toString());
                       // Change_User_reg.Adhiredatetext.setDate(hire_date);

                    } catch (ParseException ex) {

                        Logger.getLogger(User_reg_DAO.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    
          
      }
    
    
    
}
