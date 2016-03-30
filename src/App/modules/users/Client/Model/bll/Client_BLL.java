/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App.modules.users.Client.Model.bll;

import App.modules.main_menu.model.Config;
import App.modules.users.Client.Model.Classes.Client;
import static App.modules.users.Client.views.interfaz_Client.TABLA;
import static App.modules.users.Client.views.interfaz_Client.jLabel3;
import App.modules.main_menu.model.Language.Language;
import App.modules.users.Client.Model.Classes.Singleton_cli;
import App.modules.users.Client.Model.Classes.miniSimpleTableModel_Client;
import static App.modules.users.Client.Model.Classes.miniSimpleTableModel_Client.datosaux;
import App.modules.users.Client.Model.Files.File_utils.utils.json_client;
import App.modules.users.Client.Model.Files.File_utils.utils.txt_client;
import App.modules.users.Client.Model.Files.File_utils.utils.xml_client;
import App.modules.users.Client.Model.Utils.Pager.pagina;
import App.modules.users.Client.Model.dao.Client_DAO;
import App.modules.users.Client.controler.Controlador_Client;
import App.modules.users.Client.views.Change_Client;
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
public class Client_BLL {

   

    public static int search_Cli(Client c) {
        
        for (int i = 0; i < Singleton_cli.cli.size(); i++) {
            
            if ((Singleton_cli.cli.get(i).getDni()).equals(c.getDni())) {
                
                return i;
            }
        }
        return -1;
    }
/*
    public static int search_Us(User_reg u) {
        for (int i = 0; i <= (Singleton.us.size() - 1); i++) {
            if ((Singleton.us.get(i)).equals(u)) {
                return i;
            }
        }
        return -1;
    }
*/
    public static void imprime(ArrayList<? extends User> l)// Imprimir cada uno de los empleados del array
    {

        Iterator<? extends User> it = l.iterator();

        while (it.hasNext()) {

            User f = it.next();
            JOptionPane.showMessageDialog(null, f.toString(), "Impresion", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void requests_name() {

        Client_DAO.Create_requests_name();

    }

    public static void requests_surname() {

        Client_DAO.Create_requests_surname();

    }
    
     public static void ask_client_type() {

        Client_DAO.Create_requests_client_type();

    }
    

    public static void ask_mobil() {

        Client_DAO.create_ask_mobil();

    }

    public static void ask_email() {

        Client_DAO.create_ask_email();

    }

    public static void ask_username() {

        Client_DAO.create_ask_username();

    }

    public static void ask_pass() {

        Client_DAO.create_ask_pass();

    }

    public static void ask_Sopping() {

        Client_DAO.create_ask_shopping();

    }

    public static void ask_ID() {

        Client_DAO.create_ask_ID();

    }

    public static void control_ID() {

        Client_DAO.create_control_ID();

    }

    public static void valitate_date_birthday() {

        Client_DAO.create_validate_date_birthday();

    }

    public static void valitate_hire_date() {

        Client_DAO.create_validate_hire_date();

    }

    public static void charge_avatar() {

        Client_DAO.Create_Charge_Avatar();

    }

    public static boolean save_client() {

        boolean b = false;

        Client c = Client_DAO.Create_Check_and_save();

        if (c != null) {

            Singleton_cli.cli.add(c);

                       
            json_client.auto_save_Client_json();

            b = true;

        }

        return b;
    }

    public static boolean Charge_Change_Client() {

        boolean b = false;
        int filaseleccionada;
        Client c = null;
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

                 new Controlador_Client(new Change_Client(), 2).Start(2);
                
               // new Change_Admin().setVisible(true);

                //DefaultTableModel modelotabla = (DefaultTableModel) TABLA.getModel();
                String Id = (String) TABLA.getValueAt(filaseleccionada, 0);

                c = ((miniSimpleTableModel_Client) TABLA.getModel()).buscar(Id);

                // a = new Admin(Id);
                pos = Client_BLL.search_Cli(c);

                if ((pos) != -1) {

                    c = Singleton_cli.cli.get(pos);

                    Change_Client.AdIDtext.setText(c.getDni());
                    Change_Client.AdNametext.setText(c.getNom());
                    Change_Client.AdSurnametext.setText(c.getCognom());
                    Change_Client.AdMobiltext.setText(c.getMobil());
                    Change_Client.ADEmailtext.setText(c.getEmail());
                    Change_Client.AdUsernametext.setText(c.getUser());
                    Change_Client.AdPasstext.setText(c.getPass());
                    Change_Client.AdActivitytext.setText(Float.toString(c.getCompra$()));
                    Change_Client.Client_type_text.setText(c.getClient_type());

                     //////////////////////////
                    Singleton_App.ruta_imagen = c.getAvatar();
                    //Se crea el imagen desde la string del admin
                    ImageIcon icon = new ImageIcon(Singleton_App.ruta_imagen);
                    //se extrae la imagen del icono
                    Image img = icon.getImage();
                    //cambiamos el tamaño
                    Image newimg = img.getScaledInstance(97, 97, java.awt.Image.SCALE_SMOOTH);
                    //se genera la imagen con la nueva imagen
                    ImageIcon newIcon = new ImageIcon(newimg);

                    Change_Client.AdAvartaimg.setIcon(newIcon);
                    Change_Client.AdAvartaimg.setText("");
                    Change_Client.AdAvartaimg.setSize(97, 97);
                    
                    
                    try {

                        Date date_birthday = format.parse(c.getDate_birthday().toString());
                        Change_Client.Addatebirthdaytext.setDate(date_birthday);
                        Date discarge_date = format.parse(c.getF_alta().toString());
                        Change_Client.Adhiredatetext.setDate(discarge_date);

                    } catch (ParseException ex) {

                        Logger.getLogger(Client_DAO.class.getName()).log(Level.SEVERE, null, ex);
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

    public static boolean change_client() {

        Client c = null;
        int pos = 0;
        boolean b = false;

        c = Client_DAO.Change_Check_and_save();


        if (c != null) {

              pos = Client_BLL.search_Cli(c);
            
            Singleton_cli.cli.set(pos, c);
            
            json_client.auto_save_Client_json();

            b = true;

        }

        return b;
    }

    /////////////Validate para change
    public static void Change_requests_name() {

        Client_DAO.Change_requests_name();

    }
    
     public static void Change_ask_client_type() {

        Client_DAO.Change_requests_client_type();

    }
    

    public static void Change_requests_surname() {

        Client_DAO.Change_requests_surname();

    }

    public static void Change_ask_mobil() {

        Client_DAO.Change_ask_mobil();

    }

    public static void Change_ask_email() {

        Client_DAO.change_ask_email();

    }

    public static void Change_ask_username() {

        Client_DAO.change_ask_username();

    }

    public static void Change_ask_pass() {

        Client_DAO.change_ask_pass();

    }

    public static void Change_ask_sopping() {

        Client_DAO.change_ask_shopping();

    }

    public static void Change_ask_ID() {

        Client_DAO.change_ask_ID();

    }

    public static void Change_control_ID() {

        Client_DAO.change_control_ID();

    }

    public static void Change_valitate_date_birthday() {

        Client_DAO.change_validate_date_birthday();

    }

    public static void Change_valitate_hire_date() {

        Client_DAO.change_validate_hire_date();

    }

    public static void Change_Change_Avatar() {

        Client_DAO.Change_Charge_Avatar();

    }

    public static void Delete_Admin() {

        Client c = null;
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

                c = ((miniSimpleTableModel_Client) TABLA.getModel()).buscar(Id);

                 int opc = JOptionPane.showConfirmDialog(null, "Estas seguro que quieres borrar el Dni: " + Id,
                        "Info", JOptionPane.WARNING_MESSAGE);

                if (opc == 0) {
                
                int pos = ((miniSimpleTableModel_Client) TABLA.getModel()).buscaUsuario(c);

                ((miniSimpleTableModel_Client) TABLA.getModel()).removeRow(pos);
                ((miniSimpleTableModel_Client) TABLA.getModel()).cargar();
                // pagina.inicializa();
                // pagina.initLinkBox();

                Singleton_cli.cli.remove(pos);
                datosaux.remove(c);
                jLabel3.setText(String.valueOf(Singleton_cli.cli.size()));
                ((miniSimpleTableModel_Client) TABLA.getModel()).cargar();
                pagina.inicializa();
                pagina.initLinkBox();
                
                json_client.auto_save_Client_json();
                
                if (Singleton_cli.cli.size() < 6) {

                    pagina.currentPageIndex = 1;
                    pagina.initLinkBox();
                }
                }
            }

        } catch (Exception e) {

        }

    }

    public static void save_json() {
        if (!Singleton_cli.cli.isEmpty()) {
            
            json_client.save_client_json();
            
        } else {
            JOptionPane.showMessageDialog(null, "No hay datos que guardar");
        }
    }

    public static void save_txt() {
        if (!Singleton_cli.cli.isEmpty()) {
            txt_client.save_client_txt();
        } else {
            JOptionPane.showMessageDialog(null, "No hay datos que guardar");
        }
    }

    public static void save_xml() {
        if (!Singleton_cli.cli.isEmpty()) {
            
            xml_client.save_client_xml();
            
        } else {
            JOptionPane.showMessageDialog(null, "No hay datos que guardar");
        }
    }

}
