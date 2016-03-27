/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App.modules.users.Client.Model.dao;

import App.classes.date_class;
import App.modules.main_menu.model.Language.Language;
import App.modules.users.Client.Model.Classes.Client;
import App.modules.users.Client.Model.Classes.Singleton_cli;
import App.modules.users.Client.Model.bll.Client_BLL;
import App.modules.users.Client.views.Change_Client;
import App.modules.users.Client.views.Create_Client;
import App.utils.Funciones;
import App.utils.Singleton_App;
import App.utils.Validate;
import java.awt.HeadlessException;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Jorge
 */
public class Client_DAO {

    /////Validacion para ventana create Admin/////
    
    public static boolean Create_requests_name() {
        boolean b = false;

        if (Create_Client.AdNametext.getText().isEmpty()) {
            Create_Client.name_label.setIcon(Singleton_App.cancel);

        } else if (!Validate.isValidFormatNom_cognom(Create_Client.AdNametext.getText())) {
            Create_Client.name_label.setIcon(Singleton_App.cancel);

        } else {

            Create_Client.name_label.setIcon(Singleton_App.ok);
            b = true;
        }
        return b;
    }

     public static boolean Create_requests_client_type() {
        boolean b = false;

        if (Create_Client.Client_type_text.getText().isEmpty()) {
            Create_Client.Client_type_label.setIcon(Singleton_App.cancel);

        } else if (!Validate.isValidFormatNom_cognom(Create_Client.Client_type_text.getText())) {
            Create_Client.Client_type_label.setIcon(Singleton_App.cancel);

        } else {

            Create_Client.Client_type_label.setIcon(Singleton_App.ok);
            b = true;
        }
        return b;
    }
    
    
     
    
    
    
    public static boolean Create_requests_surname() {
        boolean b = false;

        if (Create_Client.AdSurnametext.getText().isEmpty()) {
            Create_Client.surname_label.setIcon(Singleton_App.cancel);

        } else if (!Validate.isValidFormatNom_cognom(Create_Client.AdSurnametext.getText())) {
            Create_Client.surname_label.setIcon(Singleton_App.cancel);

        } else {

            Create_Client.surname_label.setIcon(Singleton_App.ok);
            b = true;

        }
        return b;
    }

    public static boolean create_ask_mobil() {

        boolean b = false;

        if (Create_Client.AdMobiltext.getText().isEmpty()) {
            Create_Client.mobil_label.setIcon(Singleton_App.cancel);

        } else if (!Validate.isvalidmobil(Create_Client.AdMobiltext.getText())) {
            Create_Client.mobil_label.setIcon(Singleton_App.cancel);

        } else {
            Create_Client.mobil_label.setIcon(Singleton_App.ok);
            b = true;
        }

        return b;

    }

    public static boolean create_ask_email() {

        boolean b = false;

        if (Create_Client.ADEmailtext.getText().isEmpty()) {
            Create_Client.email_label.setIcon(Singleton_App.cancel);

        } else if (!Validate.isValidFormatEmailAddress(Create_Client.ADEmailtext.getText())) {
            Create_Client.email_label.setIcon(Singleton_App.cancel);

        } else {
            Create_Client.email_label.setIcon(Singleton_App.ok);

            b = true;
        }

        return b;

    }

    public static boolean create_ask_username() {

        boolean b = false;

        if (Create_Client.AdUsernametext.getText().isEmpty()) {
            Create_Client.user_name_label.setIcon(Singleton_App.cancel);

        } else if (!Validate.isValidnick(Create_Client.AdUsernametext.getText())) {
            Create_Client.user_name_label.setIcon(Singleton_App.cancel);

        } else {
            Create_Client.user_name_label.setIcon(Singleton_App.ok);
            b = true;
        }
        return b;
    }

    public static boolean create_ask_pass() {
        boolean b = false;

        if (Create_Client.AdPasstext.getText().isEmpty()) {
            Create_Client.pass_label.setIcon(Singleton_App.cancel);

        } else if (!Validate.isvalidpassword(Create_Client.AdPasstext.getText())) {
            Create_Client.pass_label.setIcon(Singleton_App.cancel);
        } else {

            Create_Client.pass_label.setIcon(Singleton_App.ok);
            b = true;

        }
        return b;
    }

    public static boolean create_ask_shopping() {
        boolean b = false;

        if (Create_Client.AdActivitytext.getText().isEmpty()) {
            Create_Client.activity_label.setIcon(Singleton_App.cancel);

        } else if (!Validate.isValidshopping(Create_Client.AdActivitytext.getText())) {
            Create_Client.activity_label.setIcon(Singleton_App.cancel);
        } else {

            Create_Client.activity_label.setIcon(Singleton_App.ok);
            b = true;
        }
        return b;
    }

    public static boolean create_ask_ID() {
        boolean b = false;

        if (Create_Client.AdIDtext.getText().isEmpty()) {
            Create_Client.id_label.setIcon(Singleton_App.cancel);

        } else if (!Validate.isValidFormatDNI(Create_Client.AdIDtext.getText())) {
            Create_Client.id_label.setIcon(Singleton_App.cancel);

        } else {

            Create_Client.id_label.setIcon(Singleton_App.ok);
            b = true;
        }
        return b;
    }

    public static boolean create_control_ID() {

        String dni = " ", aux = "", characters = "TRWAGMYFPDXBNJZSQVHLCKET";
        char control = ' ', letter = ' ';
        boolean b = false;
        String aux1 = "";
        int rest = 0;
        int numb = 0;

        try {

            dni = Create_Client.AdIDtext.getText();
            dni = dni.toUpperCase();

            for (int i = 0; i < 8; i++) {
                aux += dni.charAt(i);

            }

            letter = dni.charAt(8);

            numb = Integer.parseInt(aux);

            rest = numb % 23;

            control = characters.charAt(rest);

            if (control == letter) {

                Create_Client.id_label.setIcon(Singleton_App.ok);
                b = true;

                Singleton_cli.DNI = dni;

                Client c = new Client(Singleton_cli.DNI);

                if (Client_BLL.search_Cli(c)!= -1) {

                    JOptionPane.showMessageDialog(null, Language.getinstance().getProperty("exists"), Language.getinstance().getProperty("admin"),
                            JOptionPane.ERROR_MESSAGE);
                    Create_Client.id_label.setIcon(Singleton_App.cancel);
                    b = false;
                }

            } else {

                Create_Client.id_label.setIcon(Singleton_App.cancel);
                b = false;
            }

        } catch (Exception e) {

            // e.printStackTrace();
        }

        return b;
    }

    public static boolean create_validate_date_birthday() {

        String date_birthday = "";
        date_class date = null;
        boolean ok = false, b = false;
        int ok2 = 0, age = 0;

        try {

            SimpleDateFormat dateFormat = new SimpleDateFormat(Create_Client.Addatebirthdaytext.getDateFormatString());

            date_birthday = dateFormat.format(Create_Client.Addatebirthdaytext.getDate());

            if (date_birthday != null) {

                if (!Validate.isValid_date(date_birthday)) {

                    Create_Client.date_label.setIcon(Singleton_App.cancel);

                } else {

                    date = new date_class(date_birthday);

                    ok = date.testDate();

                    if (ok == false) {

                        Create_Client.date_label.setIcon(Singleton_App.cancel);

                    } else {

                        ok2 = date.testsystemdate();

                        if (ok2 == 1) {

                            JOptionPane.showMessageDialog(null, "The date can't exceed the current ", "Error",
                                    JOptionPane.WARNING_MESSAGE, null);
                            Create_Client.date_label.setIcon(Singleton_App.cancel);

                        } else {

                            age = date.subtractdates();

                            if ((age < 16)) {

                                JOptionPane.showMessageDialog(null, "You are not allowed to continue,\n you haven't 16 years", "Error",
                                        JOptionPane.WARNING_MESSAGE, null);

                            } else {

                                Create_Client.date_label.setIcon(Singleton_App.ok);
                                b = true;
                            }

                        }

                    }

                }

            }

        } catch (Exception e) {
        }
        return b;
    }

    public static boolean create_validate_hire_date() {

        String hire_date = "", date_birthday = "";
        date_class date = null, date1 = null;
        boolean ok = false, b = false;
        int ok2 = 0, year = 0, year1 = 0;

        try {

            SimpleDateFormat dateFormat = new SimpleDateFormat(Create_Client.Addatebirthdaytext.getDateFormatString());

            hire_date = dateFormat.format(Create_Client.Adhiredatetext.getDate());
            date_birthday = dateFormat.format(Create_Client.Addatebirthdaytext.getDate());
            date1 = new date_class(date_birthday);

            if (hire_date != null) {

                if (!Validate.isValid_date(hire_date)) {

                    Create_Client.hiredate_label.setIcon(Singleton_App.cancel);

                } else {

                    date = new date_class(hire_date);

                    ok = date.testDate();

                    if (ok == false) {

                        Create_Client.hiredate_label.setIcon(Singleton_App.cancel);

                    } else {

                        ok2 = date.testsystemdate();

                        if (ok2 == 1) {

                            JOptionPane.showMessageDialog(null, "The date can't exceed the current ", "Error",
                                    JOptionPane.WARNING_MESSAGE, null);
                            Create_Client.hiredate_label.setIcon(Singleton_App.cancel);

                        } else {

                            year = date1.testdates(date);

                            if (year != 1) {

                                JOptionPane.showMessageDialog(null, "The date must be after the date birthday",
                                        "ERROR", JOptionPane.WARNING_MESSAGE);
                                Create_Client.hiredate_label.setIcon(Singleton_App.cancel);

                            } else {

                                year1 = date1.subtract_in_dates(date);

                                if ((year1 < 16)) {

                                    JOptionPane.showMessageDialog(null, "The future Client must be 16 years",
                                            "ERROR", JOptionPane.WARNING_MESSAGE);

                                    Create_Client.hiredate_label.setIcon(Singleton_App.cancel);

                                } else {

                                    Create_Client.hiredate_label.setIcon(Singleton_App.ok);
                                    b = true;

                                }

                            }

                        }

                    }
                }
            }

        } catch (Exception e) {
        }

        return b;
    }

    
    //////Validacion para ventana Change Admin//////
    
    public static boolean Change_requests_name() {
        boolean b = false;

        if (Change_Client.AdNametext.getText().isEmpty()) {
            Change_Client.Ad_name_label.setIcon(Singleton_App.cancel);

        } else if (!Validate.isValidFormatNom_cognom(Change_Client.AdNametext.getText())) {
            Change_Client.Ad_name_label.setIcon(Singleton_App.cancel);

        } else {

            Change_Client.Ad_name_label.setIcon(Singleton_App.ok);
            b = true;
        }
        return b;
    }

     public static boolean Change_requests_client_type() {
        boolean b = false;

        if (Change_Client.Client_type_text.getText().isEmpty()) {
            Change_Client.Client_type_label.setIcon(Singleton_App.cancel);

        } else if (!Validate.isValidFormatNom_cognom(Change_Client.Client_type_text.getText())) {
            Change_Client.Client_type_label.setIcon(Singleton_App.cancel);

        } else {

            Change_Client.Client_type_label.setIcon(Singleton_App.ok);
            b = true;
        }
        return b;
    }
    
               
    
    public static boolean Change_requests_surname() {
        boolean b = false;

        if (Change_Client.AdSurnametext.getText().isEmpty()) {
            Change_Client.Ad_surname_label.setIcon(Singleton_App.cancel);

        } else if (!Validate.isValidFormatNom_cognom(Change_Client.AdSurnametext.getText())) {
            Change_Client.Ad_surname_label.setIcon(Singleton_App.cancel);

        } else {

            Change_Client.Ad_surname_label.setIcon(Singleton_App.ok);
            b = true;

        }
        return b;
    }

    public static boolean Change_ask_mobil() {

        boolean b = false;

        if (Change_Client.AdMobiltext.getText().isEmpty()) {
            Change_Client.Ad_mobil_label.setIcon(Singleton_App.cancel);

        } else if (!Validate.isvalidmobil(Change_Client.AdMobiltext.getText())) {
            Change_Client.Ad_mobil_label.setIcon(Singleton_App.cancel);

        } else {
            Change_Client.Ad_mobil_label.setIcon(Singleton_App.ok);
            b = true;
        }

        return b;

    }

    public static boolean change_ask_email() {

        boolean b = false;

        if (Change_Client.ADEmailtext.getText().isEmpty()) {
            Change_Client.Ad_email_label.setIcon(Singleton_App.cancel);

        } else if (!Validate.isValidFormatEmailAddress(Change_Client.ADEmailtext.getText())) {
            Change_Client.Ad_email_label.setIcon(Singleton_App.cancel);

        } else {
            Change_Client.Ad_email_label.setIcon(Singleton_App.ok);

            b = true;
        }

        return b;

    }

    public static boolean change_ask_username() {

        boolean b = false;

        if (Change_Client.AdUsernametext.getText().isEmpty()) {
            Change_Client.Ad_user_name_label.setIcon(Singleton_App.cancel);

        } else if (!Validate.isValidnick(Change_Client.AdUsernametext.getText())) {
            Change_Client.Ad_user_name_label.setIcon(Singleton_App.cancel);

        } else {
            Change_Client.Ad_user_name_label.setIcon(Singleton_App.ok);
            b = true;
        }
        return b;
    }

    public static boolean change_ask_pass() {
        boolean b = false;

        if (Change_Client.AdPasstext.getText().isEmpty()) {
            Change_Client.Ad_pass_label.setIcon(Singleton_App.cancel);

        } else if (!Validate.isvalidpassword(Change_Client.AdPasstext.getText())) {
            Change_Client.Ad_pass_label.setIcon(Singleton_App.cancel);
        } else {

            Change_Client.Ad_pass_label.setIcon(Singleton_App.ok);
            b = true;

        }
        return b;
    }

    public static boolean change_ask_shopping() {
        boolean b = false;

        if (Change_Client.AdActivitytext.getText().isEmpty()) {
            Change_Client.Ad_activity_label.setIcon(Singleton_App.cancel);

        } else if (!Validate.isValidshopping(Change_Client.AdActivitytext.getText())) {
            Change_Client.Ad_activity_label.setIcon(Singleton_App.cancel);
        } else {

            Change_Client.Ad_activity_label.setIcon(Singleton_App.ok);
            b = true;
        }
        return b;
    }

    public static boolean change_ask_ID() {
        boolean b = false;

        if (Change_Client.AdIDtext.getText().isEmpty()) {
            Change_Client.Ad_ID_label.setIcon(Singleton_App.cancel);

        } else if (!Validate.isValidFormatDNI(Change_Client.AdIDtext.getText())) {
            Change_Client.Ad_ID_label.setIcon(Singleton_App.cancel);

        } else {

            Change_Client.Ad_ID_label.setIcon(Singleton_App.ok);
            b = true;
        }
        return b;
    }

    public static boolean change_control_ID() {

        String dni = " ", aux = "", characters = "TRWAGMYFPDXBNJZSQVHLCKET";
        char control = ' ', letter = ' ';
        boolean b = false;
        String aux1 = "";
        int rest = 0;
        int numb = 0;

        try {

            dni = Change_Client.AdIDtext.getText();
            dni = dni.toUpperCase();

            for (int i = 0; i < 8; i++) {
                aux += dni.charAt(i);

            }

            letter = dni.charAt(8);

            numb = Integer.parseInt(aux);

            rest = numb % 23;

            control = characters.charAt(rest);

            if (control == letter) {

                Change_Client.Ad_ID_label.setIcon(Singleton_App.ok);
                b = true;

                Singleton_cli.DNI = dni;

                Client c = new Client(Singleton_cli.DNI);

                if (Client_BLL.search_Cli(c) != -1) {

                    JOptionPane.showMessageDialog(null, Language.getinstance().getProperty("exists"), Language.getinstance().getProperty("admin"),
                            JOptionPane.ERROR_MESSAGE);
                    Change_Client.Ad_ID_label.setIcon(Singleton_App.cancel);
                    b = false;
                }

            } else {

                Change_Client.Ad_ID_label.setIcon(Singleton_App.cancel);
                b = false;
            }

        } catch (Exception e) {

            // e.printStackTrace();
        }

        return b;
    }

    public static boolean change_validate_date_birthday() {

        String date_birthday = "";
        date_class date = null;
        boolean ok = false, b = false;
        int ok2 = 0, age = 0;

        try {

            SimpleDateFormat dateFormat = new SimpleDateFormat(Change_Client.Addatebirthdaytext.getDateFormatString());

            date_birthday = dateFormat.format(Change_Client.Addatebirthdaytext.getDate());

            if (date_birthday != null) {

                if (!Validate.isValid_date(date_birthday)) {

                    Change_Client.Ad_date_birthday_label.setIcon(Singleton_App.cancel);

                } else {

                    date = new date_class(date_birthday);

                    ok = date.testDate();

                    if (ok == false) {

                        Change_Client.Ad_date_birthday_label.setIcon(Singleton_App.cancel);

                    } else {

                        ok2 = date.testsystemdate();

                        if (ok2 == 1) {

                            JOptionPane.showMessageDialog(null, "The date can't exceed the current ", "Error",
                                    JOptionPane.WARNING_MESSAGE, null);
                            Change_Client.Ad_date_birthday_label.setIcon(Singleton_App.cancel);

                        } else {

                            age = date.subtractdates();

                            if ((age < 18)) {

                                JOptionPane.showMessageDialog(null, "You are not allowed to continue,\n you haven't 18 years", "Error",
                                        JOptionPane.WARNING_MESSAGE, null);

                            } else {

                                Change_Client.Ad_date_birthday_label.setIcon(Singleton_App.ok);
                                b = true;
                            }

                        }

                    }

                }

            }

        } catch (Exception e) {
        }
        return b;
    }

    public static boolean change_validate_hire_date() {

        String hire_date = "", date_birthday = "";
        date_class date = null, date1 = null;
        boolean ok = false, b = false;
        int ok2 = 0, year = 0, year1 = 0;

        try {

            SimpleDateFormat dateFormat = new SimpleDateFormat(Change_Client.Addatebirthdaytext.getDateFormatString());

            hire_date = dateFormat.format(Change_Client.Adhiredatetext.getDate());
            date_birthday = dateFormat.format(Change_Client.Addatebirthdaytext.getDate());
            date1 = new date_class(date_birthday);

            if (hire_date != null) {

                if (!Validate.isValid_date(hire_date)) {

                    Change_Client.Ad_hire_date.setIcon(Singleton_App.cancel);

                } else {

                    date = new date_class(hire_date);

                    ok = date.testDate();

                    if (ok == false) {

                        Change_Client.Ad_hire_date.setIcon(Singleton_App.cancel);

                    } else {

                        ok2 = date.testsystemdate();

                        if (ok2 == 1) {

                            JOptionPane.showMessageDialog(null, "The date can't exceed the current ", "Error",
                                    JOptionPane.WARNING_MESSAGE, null);
                            Change_Client.Ad_hire_date.setIcon(Singleton_App.cancel);

                        } else {

                            year = date1.testdates(date);

                            if (year != 1) {

                                JOptionPane.showMessageDialog(null, "The date must be after the date birthday",
                                        "ERROR", JOptionPane.WARNING_MESSAGE);
                                Change_Client.Ad_hire_date.setIcon(Singleton_App.cancel);

                            } else {

                                year1 = date1.subtract_in_dates(date);

                                if ((year1 < 16)) {

                                    JOptionPane.showMessageDialog(null, "The future client must be 16 years",
                                            "ERROR", JOptionPane.WARNING_MESSAGE);

                                    Change_Client.Ad_hire_date.setIcon(Singleton_App.cancel);

                                } else {

                                    Change_Client.Ad_hire_date.setIcon(Singleton_App.ok);
                                    b = true;

                                }

                            }

                        }

                    }
                }
            }

        } catch (Exception e) {
        }

        return b;
    }
    
    
    
    
    
    ///////////////////////////////////////////////
    
    public static Client Create_Check_and_save() {

        Client c = null;
        String dni = " ", nom = " ", cognom = " ", mobil = " ", email = " ", avatar = Singleton_App.ruta_imagen,
                user = " ", pass = " ", status = (String) Create_Client.Status_combo.getSelectedItem(), client_type = " ";
        date_class f_alta = null;
        date_class date_birthday = null;
        String birthday = "", hire = "";
        float dtos$ = 0.0f, compra$ = 0.0f;
        boolean premium = true;

        boolean Id = create_control_ID(),
                name = Create_requests_name(),
                surname = Create_requests_surname(),
                date_birtday_ = create_validate_date_birthday(),
                movil = create_ask_mobil(),
                Email = create_ask_email(),
                user_name = create_ask_username(),
                password = create_ask_pass(),
                discarge_date = create_validate_hire_date(),
                compras = create_ask_shopping(),
                client_type_ = Create_requests_client_type();

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(Create_Client.Addatebirthdaytext.getDateFormatString());

            hire = dateFormat.format(Create_Client.Adhiredatetext.getDate());
            birthday = dateFormat.format(Create_Client.Addatebirthdaytext.getDate());
            
        } catch (Exception e) {

        }

        if ((Id == true) && (name == true) && (surname == true) && (date_birtday_ == true) && (movil == true) && (Email == true) && (user_name == true) && (password == true) && (discarge_date == true) && (compras == true) && (client_type_ == true) ) {

            
            f_alta = new date_class(hire);
            date_birthday = new date_class(birthday);
            nom = Create_Client.AdNametext.getText();
            cognom = Create_Client.AdSurnametext.getText();
            mobil = Create_Client.AdMobiltext.getText();
            email = Create_Client.ADEmailtext.getText();
            //avatar= Create_Admin.ad.getText();
            user = Create_Client.AdUsernametext.getText();
            pass = Create_Client.AdPasstext.getText();
            //status=
            compra$ = Integer.parseInt(Create_Client.AdActivitytext.getText());
           // premium = (boolean) Create_Client.jComboBox2.getSelectedItem();
            client_type = Create_Client.Client_type_text.getText();
            
            
            c = new Client(Singleton_cli.DNI, nom, cognom, date_birthday, mobil, email,
				avatar, user, pass, status, f_alta, dtos$,
				compra$, premium, client_type);

           
        //  JOptionPane.showMessageDialog(null, c.toString());
            
        } else {

            JOptionPane.showMessageDialog(null, "Revisar los parametros");
            c = null;
        }

        return c;
    }

   public static Client Change_Check_and_save() {

      Client c = null;
        String dni = " ", nom = " ", cognom = " ", mobil = " ", email = " ", avatar = Singleton_App.ruta_imagen,
                user = " ", pass = " ", status = (String) Create_Client.Status_combo.getSelectedItem(), client_type = " ";
        date_class f_alta = null;
        date_class date_birthday = null;
        String birthday = "", hire = "";
        float dtos$ = 0.0f, compra$ = 0.0f;
        boolean premium = true;
        
        boolean //Id = create_control_ID(),
                name = Change_requests_name(),
                surname = Change_requests_surname(),
                date_birtday_ = change_validate_date_birthday(),
                movil = Change_ask_mobil(),
                Email = change_ask_email(),
                user_name = change_ask_username(),
                password = change_ask_pass(),
                hire_date = change_validate_hire_date(),
                compras = change_ask_shopping(),
                 client_type_ = Change_requests_client_type();

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(Change_Client.Addatebirthdaytext.getDateFormatString());

            hire = dateFormat.format(Change_Client.Adhiredatetext.getDate());
            birthday = dateFormat.format(Change_Client.Addatebirthdaytext.getDate());
            
        } catch (Exception e) {

        }

        if ((name == true) && (surname == true) && (date_birtday_ == true) && (movil == true) && (Email == true) && (user_name == true)  && (hire_date == true) && (compras == true) && (client_type_ == true)) {

            dni = Change_Client.AdIDtext.getText();
            f_alta = new date_class(hire);
            date_birthday = new date_class(birthday);
            nom = Change_Client.AdNametext.getText();
            cognom = Change_Client.AdSurnametext.getText();
            mobil = Change_Client.AdMobiltext.getText();
            email = Change_Client.ADEmailtext.getText();
            avatar= Singleton_App.ruta_imagen;           
            user = Change_Client.AdUsernametext.getText();
            pass = Change_Client.AdPasstext.getText();
            compra$ =  Float.parseFloat(Change_Client.AdActivitytext.getText());
            client_type = Change_Client.Client_type_text.getText();
            
            
            c = new Client(dni, nom, cognom, date_birthday, mobil, email,
				avatar, user, pass, status, f_alta, dtos$,
				compra$, premium, client_type);


            JOptionPane.showMessageDialog(null, c.toString());
           
        } else {

            JOptionPane.showMessageDialog(null, "Revisa los parametros");
            c = null;
        }

        return c;
    }

    public static void Create_Charge_Avatar() {
        
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivo de imagen", "png");
        //Creamos objeto filechooser
        JFileChooser dlg= new JFileChooser();
        //llamamos al metodo setFilefilter
        dlg.setFileFilter(filter);
        //para abrir la ventana dialogo
        int option = dlg.showOpenDialog(dlg);
        //Al hacer click en el boton abrir
        if (option==JFileChooser.APPROVE_OPTION){                            
            
                //Create_Admin.AdAvartaimg.setIcon(null);
                
                //Obterner el nombre del archivo seleccionado
                String fil = dlg.getSelectedFile().getPath();
               
              //  Singleton_App.ruta_imagen = "";
                //direcccion donde se guarda la imagen
                String file = dlg.getSelectedFile().toString();                                         
                               
                Create_Client.AdAvartaimg.setIcon(new ImageIcon(fil));
                //
                //
                                
                //para modificar el tamaño de la imagen i adecualo al tamaño de nuestro label
                ImageIcon icon= new ImageIcon(fil);
                //se extrae la imagen del icono
                Image img = icon.getImage();
                //cambiamos el tamaño
                Image newimg = img.getScaledInstance(97, 97, java.awt.Image.SCALE_SMOOTH);
                //se genera la imagen con la nueva imagen
                ImageIcon newIcon = new ImageIcon(newimg);
                
                
                Create_Client.AdAvartaimg.setIcon(newIcon);
                Create_Client.AdAvartaimg.setText("");
                Create_Client.AdAvartaimg.setSize(97,97);
                
              
                
             try {
                    
                File source = new File(file);
                File dest = new File("src\\App\\utils\\img_app\\Users_Avatar_images\\"+source.getName());

                Singleton_App.ruta_imagen = dest.toString();
                //JOptionPane.showMessageDialog(null, Singleton_App.ruta_imagen );
                
                Funciones.copyFileUsingJava7Files(source, dest);
                               
                                    
            } catch (HeadlessException | IOException e) {
                
            }                 
                            
        }
    }
   
    ///////////////////////////////////////////////////
    
    public static void Change_Charge_Avatar() {
        
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivo de imagen", "png");
        //Creamos objeto filechooser
        JFileChooser dlg= new JFileChooser();
        //llamamos al metodo setFilefilter
        dlg.setFileFilter(filter);
        //para abrir la ventana dialogo
        int option = dlg.showOpenDialog(dlg);
        //Al hacer click en el boton abrir
        if (option==JFileChooser.APPROVE_OPTION){                            
            
                //Create_Admin.AdAvartaimg.setIcon(null);
                
                //Obterner el nombre del archivo seleccionado
                String fil = dlg.getSelectedFile().getPath();
               
              //  Singleton_App.ruta_imagen = "";
                //direcccion donde se guarda la imagen
                String file = dlg.getSelectedFile().toString();                                         
                               
                Change_Client.AdAvartaimg.setIcon(new ImageIcon(fil));
                //
                //
                                
                //para modificar el tamaño de la imagen i adecualo al tamaño de nuestro label
                ImageIcon icon= new ImageIcon(fil);
                //se extrae la imagen del icono
                Image img = icon.getImage();
                //cambiamos el tamaño
                Image newimg = img.getScaledInstance(97, 97, java.awt.Image.SCALE_SMOOTH);
                //se genera la imagen con la nueva imagen
                ImageIcon newIcon = new ImageIcon(newimg);
                
                
                Change_Client.AdAvartaimg.setIcon(newIcon);
                Change_Client.AdAvartaimg.setText("");
                Change_Client.AdAvartaimg.setSize(97,97);
                
                try {
                    
                File source = new File(file);
                File dest = new File("src\\App\\utils\\img_app\\Users_Avatar_images\\"+source.getName());

                Singleton_App.ruta_imagen = dest.toString();
                //JOptionPane.showMessageDialog(null, Singleton_App.ruta_imagen );
                
                Funciones.copyFileUsingJava7Files(source, dest);
                               
                                    
            } catch (HeadlessException | IOException e) {
                
            }
                
                
                                       
                            
        }
    }
    
    
    ////////////////////////////////////////////////////////
    /*
    public static void copyFileUsingJava7Files(File source, File dest)

        throws IOException {

    Files.copy(source.toPath(), dest.toPath());
    
    

}

 */  
   
}
