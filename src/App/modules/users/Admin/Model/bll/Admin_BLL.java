/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App.modules.users.Admin.Model.bll;

import App.modules.main_menu.model.Config;
import App.modules.users.Admin.Model.Classes.Singleton;
import App.modules.users.Admin.Model.Classes.Admin;
import App.modules.users.Client.Model.Classes.Client;
import App.modules.users.Admin.Model.Classes.Singleton;
import App.modules.users.User_reg.Model.Classes.User_reg;
import App.modules.users.Admin.Model.Classes.miniSimpleTableModel_Admin;
import static App.modules.users.Admin.Model.Classes.miniSimpleTableModel_Admin.datosaux;
import App.modules.users.Admin.Model.dao.Admin_DAO;
import App.modules.users.Admin.Model.Files.File_utils.utils.json;
import App.modules.users.Admin.Model.Utils.Pager.pagina;
import App.modules.users.Admin.views.Change_Admin;
import App.modules.users.Admin.views.Create_Admin;
import static App.modules.users.Admin.views.interfaz_Admin.TABLA;
import static App.modules.users.Admin.views.interfaz_Admin.jLabel3;
import App.modules.main_menu.model.Language.Language;
import App.modules.users.Admin.Model.Files.File_utils.utils.txt;
import App.modules.users.Admin.Model.Files.File_utils.utils.xml;
import App.modules.users.User.User;
import App.utils.Singleton_App;
import App.utils.Validate;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.Image;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jorge
 */
public class Admin_BLL {

    public static int search_ad(Admin a) {

        for (int i = 0; i < Singleton.ad.size(); i++) {

            if ((Singleton.ad.get(i).getDni()).equals(a.getDni())) {
                return i;
            }
        }
        return -1;
    }

    public static int search_Cli(Client c) {
        for (int i = 0; i <= (Singleton.cli.size() - 1); i++) {
            if ((Singleton.cli.get(i)).equals(c)) {
                return i;
            }
        }
        return -1;
    }

    public static int search_Us(User_reg u) {
        for (int i = 0; i <= (Singleton.us.size() - 1); i++) {
            if ((Singleton.us.get(i)).equals(u)) {
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

        Admin_DAO.Create_requests_name();

    }

    public static void requests_surname() {

        Admin_DAO.Create_requests_surname();

    }

    public static void ask_mobil() {

        Admin_DAO.create_ask_mobil();

    }

    public static void ask_email() {

        Admin_DAO.create_ask_email();

    }

    public static void ask_username() {

        Admin_DAO.create_ask_username();

    }

    public static void ask_pass() {

        Admin_DAO.create_ask_pass();

    }

    public static void ask_Activity() {

        Admin_DAO.create_ask_Activity();

    }

    public static void ask_ID() {

        Admin_DAO.create_ask_ID();

    }

    public static void control_ID() {

        Admin_DAO.create_control_ID();

    }

    public static void valitate_date_birthday() {

        Admin_DAO.create_validate_date_birthday();

    }

    public static void valitate_hire_date() {

        Admin_DAO.create_validate_hire_date();

    }

    public static void charge_avatar() {

        Admin_DAO.Create_Charge_Avatar();

    }

    public static boolean save_admin() {

        boolean b = false;

        Admin a = Admin_DAO.Create_Check_and_save();

        if (a != null) {

            Singleton.ad.add(a);

            json.auto_save_json();

            b = true;

        }

        return b;
    }

    public static boolean Charge_Change_Admin() {

        boolean b = false;
        int filaseleccionada;
        Admin a = null;
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

                new Change_Admin().setVisible(true);

                //DefaultTableModel modelotabla = (DefaultTableModel) TABLA.getModel();
                String Id = (String) TABLA.getValueAt(filaseleccionada, 0);

                a = ((miniSimpleTableModel_Admin) TABLA.getModel()).buscar(Id);

                // a = new Admin(Id);
                pos = Admin_BLL.search_ad(a);

                if ((pos) != -1) {

                    a = Singleton.ad.get(pos);

                    Change_Admin.AdIDtext.setText(a.getDni());
                    Change_Admin.AdNametext.setText(a.getNom());
                    Change_Admin.AdSurnametext.setText(a.getCognom());
                    Change_Admin.AdMobiltext.setText(a.getMobil());
                    Change_Admin.ADEmailtext.setText(a.getEmail());
                    Change_Admin.AdUsernametext.setText(a.getUser());
                    Change_Admin.AdPasstext.setText(a.getPass());
                    Change_Admin.AdActivitytext.setText(Integer.toString(a.getActividad()));
                    //////////////////////////
                    Singleton_App.ruta_imagen = a.getAvatar();
                    //Se crea el imagen desde la string del admin
                    ImageIcon icon = new ImageIcon(Singleton_App.ruta_imagen);
                    //se extrae la imagen del icono
                    Image img = icon.getImage();
                    //cambiamos el tamaño
                    Image newimg = img.getScaledInstance(97, 97, java.awt.Image.SCALE_SMOOTH);
                    //se genera la imagen con la nueva imagen
                    ImageIcon newIcon = new ImageIcon(newimg);

                    Change_Admin.AdAvartaimg.setIcon(newIcon);
                    Change_Admin.AdAvartaimg.setText("");
                    Change_Admin.AdAvartaimg.setSize(97, 97);

                    try {

                        Date date_birthday = format.parse(a.getDate_birthday().toString());
                        Change_Admin.Addatebirthdaytext.setDate(date_birthday);
                        Date hire_date = format.parse(a.getFecha_cont().toString());
                        Change_Admin.Adhiredatetext.setDate(hire_date);

                    } catch (ParseException ex) {

                        Logger.getLogger(Admin_DAO.class.getName()).log(Level.SEVERE, null, ex);
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

    public static boolean change_Admin() {

        Admin a = null;
        int pos = 0;
        boolean b = false;

        a = Admin_DAO.Change_Check_and_save();

        pos = Admin_BLL.search_ad(a);

        if (a != null) {

            Singleton.ad.set(pos, a);
            
            json.auto_save_json();

            b = true;

        }

        return b;
    }

    /////////////Validate para change
    public static void Change_requests_name() {

        Admin_DAO.Change_requests_name();

    }

    public static void Change_requests_surname() {

        Admin_DAO.Change_requests_surname();

    }

    public static void Change_ask_mobil() {

        Admin_DAO.Change_ask_mobil();

    }

    public static void Change_ask_email() {

        Admin_DAO.change_ask_email();

    }

    public static void Change_ask_username() {

        Admin_DAO.change_ask_username();

    }

    public static void Change_ask_pass() {

        Admin_DAO.change_ask_pass();

    }

    public static void Change_ask_Activity() {

        Admin_DAO.change_ask_Activity();

    }

    public static void Change_ask_ID() {

        Admin_DAO.change_ask_ID();

    }

    public static void Change_control_ID() {

        Admin_DAO.change_control_ID();

    }

    public static void Change_valitate_date_birthday() {

        Admin_DAO.change_validate_date_birthday();

    }

    public static void Change_valitate_hire_date() {

        Admin_DAO.change_validate_hire_date();

    }

    public static void Change_Change_Avatar() {

        Admin_DAO.Change_Charge_Avatar();

    }

    public static void Delete_Admin() {

        Admin a = null;
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

                a = ((miniSimpleTableModel_Admin) TABLA.getModel()).buscar(Id);

                 int opc = JOptionPane.showConfirmDialog(null, "Estas seguro que quieres borrar el Dni: " + Id,
                        "Info", JOptionPane.WARNING_MESSAGE);

                if (opc == 0) {
                
                int pos = ((miniSimpleTableModel_Admin) TABLA.getModel()).buscaUsuario(a);

                ((miniSimpleTableModel_Admin) TABLA.getModel()).removeRow(pos);
                ((miniSimpleTableModel_Admin) TABLA.getModel()).cargar();
                // pagina.inicializa();
                // pagina.initLinkBox();

                Singleton.ad.remove(pos);
                datosaux.remove(a);
                jLabel3.setText(String.valueOf(Singleton.ad.size()));
                ((miniSimpleTableModel_Admin) TABLA.getModel()).cargar();
                pagina.inicializa();
                pagina.initLinkBox();
                
                json.auto_save_json();
                
                if (Singleton.ad.size() < 6) {

                    pagina.currentPageIndex = 1;
                    pagina.initLinkBox();
                }
                }
            }

        } catch (Exception e) {

        }

    }

    public static void save_json() {
        if (!Singleton.ad.isEmpty()) {
            json.save_admin_json();
        } else {
            JOptionPane.showMessageDialog(null, "No hay datos que guardar");
        }
    }

    public static void save_txt() {
        if (!Singleton.ad.isEmpty()) {
            txt.save_admin_txt();
        } else {
            JOptionPane.showMessageDialog(null, "No hay datos que guardar");
        }
    }

    public static void save_xml() {
        if (!Singleton.ad.isEmpty()) {
            xml.save_admin_xml();
        } else {
            JOptionPane.showMessageDialog(null, "No hay datos que guardar");
        }
    }

}
