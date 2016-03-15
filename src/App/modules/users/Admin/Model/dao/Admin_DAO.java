/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App.modules.users.Admin.Model.dao;

import App.classes.date_class;
import App.modules.users.Admin.Model.bll.Admin_BLL;
import App.modules.users.Admin.Model.Classes.Admin;
import App.utils.Singleton_App;
import App.modules.users.Admin.views.Change_Admin;
import App.modules.users.Admin.views.Create_Admin;
import App.modules.main_menu.model.Language.Language;
import App.utils.Validate;
import java.awt.HeadlessException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sun.java2d.pipe.SpanShapeRenderer;
import App.modules.users.Admin.Model.Classes.Singleton;
import App.utils.Funciones;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import javax.swing.Icon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
/**
 *
 * @author Jorge
 */
public class Admin_DAO {

    /////Validacion para ventana create Admin/////
    
    public static boolean Create_requests_name() {
        boolean b = false;

        if (Create_Admin.AdNametext.getText().isEmpty()) {
            Create_Admin.name_label.setIcon(Singleton_App.cancel);

        } else if (!Validate.isValidFormatNom_cognom(Create_Admin.AdNametext.getText())) {
            Create_Admin.name_label.setIcon(Singleton_App.cancel);

        } else {

            Create_Admin.name_label.setIcon(Singleton_App.ok);
            b = true;
        }
        return b;
    }

    public static boolean Create_requests_surname() {
        boolean b = false;

        if (Create_Admin.AdSurnametext.getText().isEmpty()) {
            Create_Admin.surname_label.setIcon(Singleton_App.cancel);

        } else if (!Validate.isValidFormatNom_cognom(Create_Admin.AdSurnametext.getText())) {
            Create_Admin.surname_label.setIcon(Singleton_App.cancel);

        } else {

            Create_Admin.surname_label.setIcon(Singleton_App.ok);
            b = true;

        }
        return b;
    }

    public static boolean create_ask_mobil() {

        boolean b = false;

        if (Create_Admin.AdMobiltext.getText().isEmpty()) {
            Create_Admin.mobil_label.setIcon(Singleton_App.cancel);

        } else if (!Validate.isvalidmobil(Create_Admin.AdMobiltext.getText())) {
            Create_Admin.mobil_label.setIcon(Singleton_App.cancel);

        } else {
            Create_Admin.mobil_label.setIcon(Singleton_App.ok);
            b = true;
        }

        return b;

    }

    public static boolean create_ask_email() {

        boolean b = false;

        if (Create_Admin.ADEmailtext.getText().isEmpty()) {
            Create_Admin.email_label.setIcon(Singleton_App.cancel);

        } else if (!Validate.isValidFormatEmailAddress(Create_Admin.ADEmailtext.getText())) {
            Create_Admin.email_label.setIcon(Singleton_App.cancel);

        } else {
            Create_Admin.email_label.setIcon(Singleton_App.ok);

            b = true;
        }

        return b;

    }

    public static boolean create_ask_username() {

        boolean b = false;

        if (Create_Admin.AdUsernametext.getText().isEmpty()) {
            Create_Admin.user_name_label.setIcon(Singleton_App.cancel);

        } else if (!Validate.isValidnick(Create_Admin.AdUsernametext.getText())) {
            Create_Admin.user_name_label.setIcon(Singleton_App.cancel);

        } else {
            Create_Admin.user_name_label.setIcon(Singleton_App.ok);
            b = true;
        }
        return b;
    }

    public static boolean create_ask_pass() {
        boolean b = false;

        if (Create_Admin.AdPasstext.getText().isEmpty()) {
            Create_Admin.pass_label.setIcon(Singleton_App.cancel);

        } else if (!Validate.isvalidpassword(Create_Admin.AdPasstext.getText())) {
            Create_Admin.pass_label.setIcon(Singleton_App.cancel);
        } else {

            Create_Admin.pass_label.setIcon(Singleton_App.ok);
            b = true;

        }
        return b;
    }

    public static boolean create_ask_Activity() {
        boolean b = false;

        if (Create_Admin.AdActivitytext.getText().isEmpty()) {
            Create_Admin.activity_label.setIcon(Singleton_App.cancel);

        } else if (!Validate.isValidactivity(Create_Admin.AdActivitytext.getText())) {
            Create_Admin.activity_label.setIcon(Singleton_App.cancel);
        } else {

            Create_Admin.activity_label.setIcon(Singleton_App.ok);
            b = true;
        }
        return b;
    }

    public static boolean create_ask_ID() {
        boolean b = false;

        if (Create_Admin.AdIDtext.getText().isEmpty()) {
            Create_Admin.id_label.setIcon(Singleton_App.cancel);

        } else if (!Validate.isValidFormatDNI(Create_Admin.AdIDtext.getText())) {
            Create_Admin.id_label.setIcon(Singleton_App.cancel);

        } else {

            Create_Admin.id_label.setIcon(Singleton_App.ok);
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

            dni = Create_Admin.AdIDtext.getText();
            dni = dni.toUpperCase();

            for (int i = 0; i < 8; i++) {
                aux += dni.charAt(i);

            }

            letter = dni.charAt(8);

            numb = Integer.parseInt(aux);

            rest = numb % 23;

            control = characters.charAt(rest);

            if (control == letter) {

                Create_Admin.id_label.setIcon(Singleton_App.ok);
                b = true;

                Singleton.DNI = dni;

                Admin a = new Admin(Singleton.DNI);

                if (Admin_BLL.search_ad(a) != -1) {

                    JOptionPane.showMessageDialog(null, Language.getinstance().getProperty("exists"), Language.getinstance().getProperty("admin"),
                            JOptionPane.ERROR_MESSAGE);
                    Create_Admin.id_label.setIcon(Singleton_App.cancel);
                    b = false;
                }

            } else {

                Create_Admin.id_label.setIcon(Singleton_App.cancel);
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

            SimpleDateFormat dateFormat = new SimpleDateFormat(Create_Admin.Addatebirthdaytext.getDateFormatString());

            date_birthday = dateFormat.format(Create_Admin.Addatebirthdaytext.getDate());

            if (date_birthday != null) {

                if (!Validate.isValid_date(date_birthday)) {

                    Create_Admin.date_label.setIcon(Singleton_App.cancel);

                } else {

                    date = new date_class(date_birthday);

                    ok = date.testDate();

                    if (ok == false) {

                        Create_Admin.date_label.setIcon(Singleton_App.cancel);

                    } else {

                        ok2 = date.testsystemdate();

                        if (ok2 == 1) {

                            JOptionPane.showMessageDialog(null, "The date can't exceed the current ", "Error",
                                    JOptionPane.WARNING_MESSAGE, null);
                            Create_Admin.date_label.setIcon(Singleton_App.cancel);

                        } else {

                            age = date.subtractdates();

                            if ((age < 16) || (age > 65)) {

                                JOptionPane.showMessageDialog(null, "You are not allowed to continue,\n you haven't age work", "Error",
                                        JOptionPane.WARNING_MESSAGE, null);

                            } else {

                                Create_Admin.date_label.setIcon(Singleton_App.ok);
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

            SimpleDateFormat dateFormat = new SimpleDateFormat(Create_Admin.Addatebirthdaytext.getDateFormatString());

            hire_date = dateFormat.format(Create_Admin.Adhiredatetext.getDate());
            date_birthday = dateFormat.format(Create_Admin.Addatebirthdaytext.getDate());
            date1 = new date_class(date_birthday);

            if (hire_date != null) {

                if (!Validate.isValid_date(hire_date)) {

                    Create_Admin.hiredate_label.setIcon(Singleton_App.cancel);

                } else {

                    date = new date_class(hire_date);

                    ok = date.testDate();

                    if (ok == false) {

                        Create_Admin.hiredate_label.setIcon(Singleton_App.cancel);

                    } else {

                        ok2 = date.testsystemdate();

                        if (ok2 == 1) {

                            JOptionPane.showMessageDialog(null, "The date can't exceed the current ", "Error",
                                    JOptionPane.WARNING_MESSAGE, null);
                            Create_Admin.hiredate_label.setIcon(Singleton_App.cancel);

                        } else {

                            year = date1.testdates(date);

                            if (year != 1) {

                                JOptionPane.showMessageDialog(null, "The date must be after the date birthday",
                                        "ERROR", JOptionPane.WARNING_MESSAGE);
                                Create_Admin.hiredate_label.setIcon(Singleton_App.cancel);

                            } else {

                                year1 = date1.subtract_in_dates(date);

                                if ((year1 < 16) || (year1 > 65)) {

                                    JOptionPane.showMessageDialog(null, "The future employee must be between 16 and 65 years",
                                            "ERROR", JOptionPane.WARNING_MESSAGE);

                                    Create_Admin.hiredate_label.setIcon(Singleton_App.cancel);

                                } else {

                                    Create_Admin.hiredate_label.setIcon(Singleton_App.ok);
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

    
    //////Validacion para ventana Create Admin//////
    
    public static boolean Change_requests_name() {
        boolean b = false;

        if (Change_Admin.AdNametext.getText().isEmpty()) {
            Change_Admin.Ad_name_label.setIcon(Singleton_App.cancel);

        } else if (!Validate.isValidFormatNom_cognom(Change_Admin.AdNametext.getText())) {
            Change_Admin.Ad_name_label.setIcon(Singleton_App.cancel);

        } else {

            Change_Admin.Ad_name_label.setIcon(Singleton_App.ok);
            b = true;
        }
        return b;
    }

    public static boolean Change_requests_surname() {
        boolean b = false;

        if (Change_Admin.AdSurnametext.getText().isEmpty()) {
            Change_Admin.Ad_surname_label.setIcon(Singleton_App.cancel);

        } else if (!Validate.isValidFormatNom_cognom(Change_Admin.AdSurnametext.getText())) {
            Change_Admin.Ad_surname_label.setIcon(Singleton_App.cancel);

        } else {

            Change_Admin.Ad_surname_label.setIcon(Singleton_App.ok);
            b = true;

        }
        return b;
    }

    public static boolean Change_ask_mobil() {

        boolean b = false;

        if (Change_Admin.AdMobiltext.getText().isEmpty()) {
            Change_Admin.Ad_mobil_label.setIcon(Singleton_App.cancel);

        } else if (!Validate.isvalidmobil(Change_Admin.AdMobiltext.getText())) {
            Change_Admin.Ad_mobil_label.setIcon(Singleton_App.cancel);

        } else {
            Change_Admin.Ad_mobil_label.setIcon(Singleton_App.ok);
            b = true;
        }

        return b;

    }

    public static boolean change_ask_email() {

        boolean b = false;

        if (Change_Admin.ADEmailtext.getText().isEmpty()) {
            Change_Admin.Ad_email_label.setIcon(Singleton_App.cancel);

        } else if (!Validate.isValidFormatEmailAddress(Change_Admin.ADEmailtext.getText())) {
            Change_Admin.Ad_email_label.setIcon(Singleton_App.cancel);

        } else {
            Change_Admin.Ad_email_label.setIcon(Singleton_App.ok);

            b = true;
        }

        return b;

    }

    public static boolean change_ask_username() {

        boolean b = false;

        if (Change_Admin.AdUsernametext.getText().isEmpty()) {
            Change_Admin.Ad_user_name_label.setIcon(Singleton_App.cancel);

        } else if (!Validate.isValidnick(Change_Admin.AdUsernametext.getText())) {
            Change_Admin.Ad_user_name_label.setIcon(Singleton_App.cancel);

        } else {
            Change_Admin.Ad_user_name_label.setIcon(Singleton_App.ok);
            b = true;
        }
        return b;
    }

    public static boolean change_ask_pass() {
        boolean b = false;

        if (Change_Admin.AdPasstext.getText().isEmpty()) {
            Change_Admin.Ad_pass_label.setIcon(Singleton_App.cancel);

        } else if (!Validate.isvalidpassword(Change_Admin.AdPasstext.getText())) {
            Change_Admin.Ad_pass_label.setIcon(Singleton_App.cancel);
        } else {

            Change_Admin.Ad_pass_label.setIcon(Singleton_App.ok);
            b = true;

        }
        return b;
    }

    public static boolean change_ask_Activity() {
        boolean b = false;

        if (Change_Admin.AdActivitytext.getText().isEmpty()) {
            Change_Admin.Ad_activity_label.setIcon(Singleton_App.cancel);

        } else if (!Validate.isValidactivity(Change_Admin.AdActivitytext.getText())) {
            Change_Admin.Ad_activity_label.setIcon(Singleton_App.cancel);
        } else {

            Change_Admin.Ad_activity_label.setIcon(Singleton_App.ok);
            b = true;
        }
        return b;
    }

    public static boolean change_ask_ID() {
        boolean b = false;

        if (Change_Admin.AdIDtext.getText().isEmpty()) {
            Change_Admin.Ad_ID_label.setIcon(Singleton_App.cancel);

        } else if (!Validate.isValidFormatDNI(Change_Admin.AdIDtext.getText())) {
            Change_Admin.Ad_ID_label.setIcon(Singleton_App.cancel);

        } else {

            Change_Admin.Ad_ID_label.setIcon(Singleton_App.ok);
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

            dni = Change_Admin.AdIDtext.getText();
            dni = dni.toUpperCase();

            for (int i = 0; i < 8; i++) {
                aux += dni.charAt(i);

            }

            letter = dni.charAt(8);

            numb = Integer.parseInt(aux);

            rest = numb % 23;

            control = characters.charAt(rest);

            if (control == letter) {

                Change_Admin.Ad_ID_label.setIcon(Singleton_App.ok);
                b = true;

                Singleton.DNI = dni;

                Admin a = new Admin(Singleton.DNI);

                if (Admin_BLL.search_ad(a) != -1) {

                    JOptionPane.showMessageDialog(null, Language.getinstance().getProperty("exists"), Language.getinstance().getProperty("admin"),
                            JOptionPane.ERROR_MESSAGE);
                    Change_Admin.Ad_ID_label.setIcon(Singleton_App.cancel);
                    b = false;
                }

            } else {

                Change_Admin.Ad_ID_label.setIcon(Singleton_App.cancel);
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

            SimpleDateFormat dateFormat = new SimpleDateFormat(Change_Admin.Addatebirthdaytext.getDateFormatString());

            date_birthday = dateFormat.format(Change_Admin.Addatebirthdaytext.getDate());

            if (date_birthday != null) {

                if (!Validate.isValid_date(date_birthday)) {

                    Change_Admin.Ad_date_birthday_label.setIcon(Singleton_App.cancel);

                } else {

                    date = new date_class(date_birthday);

                    ok = date.testDate();

                    if (ok == false) {

                        Change_Admin.Ad_date_birthday_label.setIcon(Singleton_App.cancel);

                    } else {

                        ok2 = date.testsystemdate();

                        if (ok2 == 1) {

                            JOptionPane.showMessageDialog(null, "The date can't exceed the current ", "Error",
                                    JOptionPane.WARNING_MESSAGE, null);
                            Change_Admin.Ad_date_birthday_label.setIcon(Singleton_App.cancel);

                        } else {

                            age = date.subtractdates();

                            if ((age < 16) || (age > 65)) {

                                JOptionPane.showMessageDialog(null, "You are not allowed to continue,\n you haven't age work", "Error",
                                        JOptionPane.WARNING_MESSAGE, null);

                            } else {

                                Change_Admin.Ad_date_birthday_label.setIcon(Singleton_App.ok);
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

            SimpleDateFormat dateFormat = new SimpleDateFormat(Change_Admin.Addatebirthdaytext.getDateFormatString());

            hire_date = dateFormat.format(Change_Admin.Adhiredatetext.getDate());
            date_birthday = dateFormat.format(Change_Admin.Addatebirthdaytext.getDate());
            date1 = new date_class(date_birthday);

            if (hire_date != null) {

                if (!Validate.isValid_date(hire_date)) {

                    Change_Admin.Ad_hire_date.setIcon(Singleton_App.cancel);

                } else {

                    date = new date_class(hire_date);

                    ok = date.testDate();

                    if (ok == false) {

                        Change_Admin.Ad_hire_date.setIcon(Singleton_App.cancel);

                    } else {

                        ok2 = date.testsystemdate();

                        if (ok2 == 1) {

                            JOptionPane.showMessageDialog(null, "The date can't exceed the current ", "Error",
                                    JOptionPane.WARNING_MESSAGE, null);
                            Change_Admin.Ad_hire_date.setIcon(Singleton_App.cancel);

                        } else {

                            year = date1.testdates(date);

                            if (year != 1) {

                                JOptionPane.showMessageDialog(null, "The date must be after the date birthday",
                                        "ERROR", JOptionPane.WARNING_MESSAGE);
                                Change_Admin.Ad_hire_date.setIcon(Singleton_App.cancel);

                            } else {

                                year1 = date1.subtract_in_dates(date);

                                if ((year1 < 16) || (year1 > 65)) {

                                    JOptionPane.showMessageDialog(null, "The future employee must be between 16 and 65 years",
                                            "ERROR", JOptionPane.WARNING_MESSAGE);

                                    Change_Admin.Ad_hire_date.setIcon(Singleton_App.cancel);

                                } else {

                                    Change_Admin.Ad_hire_date.setIcon(Singleton_App.ok);
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
    
    public static Admin Create_Check_and_save() {

        Admin a = null;
        String dni = " ", nom = " ", cognom = " ", mobil = " ", email = " ", avatar = Singleton_App.ruta_imagen,
                user = " ", pass = " ", status = (String) Create_Admin.Status_combo.getSelectedItem();
        date_class fecha_cont = null;
        date_class date_birthday = null;
        String birthday = "", hire = "";
        int actividad = 0;

        boolean Id = create_control_ID(),
                name = Create_requests_name(),
                surname = Create_requests_surname(),
                date_birtday_ = create_validate_date_birthday(),
                movil = create_ask_mobil(),
                Email = create_ask_email(),
                user_name = create_ask_username(),
                password = create_ask_pass(),
                hire_date = create_validate_hire_date(),
                activity = create_ask_Activity();

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(Create_Admin.Addatebirthdaytext.getDateFormatString());

            hire = dateFormat.format(Create_Admin.Adhiredatetext.getDate());
            birthday = dateFormat.format(Create_Admin.Addatebirthdaytext.getDate());
            
        } catch (Exception e) {

        }

        if ((Id == true) && (name == true) && (surname == true) && (date_birtday_ == true) && (movil == true) && (Email == true) && (user_name == true) && (password == true) && (hire_date == true) && (activity == true)) {

            fecha_cont = new date_class(hire);
            date_birthday = new date_class(birthday);
            nom = Create_Admin.AdNametext.getText();
            cognom = Create_Admin.AdSurnametext.getText();
            mobil = Create_Admin.AdMobiltext.getText();
            email = Create_Admin.ADEmailtext.getText();
            //avatar= Create_Admin.ad.getText();
            user = Create_Admin.AdUsernametext.getText();
            pass = Create_Admin.AdPasstext.getText();
            //status=
            actividad = Integer.parseInt(Create_Admin.AdActivitytext.getText());

            a = new Admin(Singleton.DNI, nom, cognom, date_birthday, mobil, email,
                    avatar, user, pass, status, actividad,
                    fecha_cont);

            JOptionPane.showMessageDialog(null, a.toString());
            // Singleton.ad.add(a);
        } else {

            JOptionPane.showMessageDialog(null, "Revisar los parametros");
            a = null;
        }

        return a;
    }

   public static Admin Change_Check_and_save() {

        Admin a = null;
        String dni = " ", nom = " ", cognom = " ", mobil = " ", email = " ", avatar = "",
                user = " ", pass = " ", status = (String) Change_Admin.Status_combo.getSelectedItem();
        date_class fecha_cont = null;
        date_class date_birthday = null;
        String birthday = "", hire = "";
        int actividad = 0;

        boolean //Id = create_control_ID(),
                name = Change_requests_name(),
                surname = Change_requests_surname(),
                date_birtday_ = change_validate_date_birthday(),
                movil = Change_ask_mobil(),
                Email = change_ask_email(),
                user_name = change_ask_username(),
                password = change_ask_pass(),
                hire_date = change_validate_hire_date(),
                activity = change_ask_Activity();

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(Change_Admin.Addatebirthdaytext.getDateFormatString());

            hire = dateFormat.format(Change_Admin.Adhiredatetext.getDate());
            birthday = dateFormat.format(Change_Admin.Addatebirthdaytext.getDate());
            
        } catch (Exception e) {

        }

        if ((name == true) && (surname == true) && (date_birtday_ == true) && (movil == true) && (Email == true) && (user_name == true)  && (hire_date == true) && (activity == true)) {

            dni = Change_Admin.AdIDtext.getText();
            fecha_cont = new date_class(hire);
            date_birthday = new date_class(birthday);
            nom = Change_Admin.AdNametext.getText();
            cognom = Change_Admin.AdSurnametext.getText();
            mobil = Change_Admin.AdMobiltext.getText();
            email = Change_Admin.ADEmailtext.getText();
            avatar= Singleton_App.ruta_imagen;           
            user = Change_Admin.AdUsernametext.getText();
            pass = Change_Admin.AdPasstext.getText();
            //status=
            actividad = Integer.parseInt(Change_Admin.AdActivitytext.getText());

            a = new Admin(dni, nom, cognom, date_birthday, mobil, email,
                    avatar, user, pass, status, actividad,
                    fecha_cont);

            JOptionPane.showMessageDialog(null, a.toString());
           
        } else {

            JOptionPane.showMessageDialog(null, "Revisa los parametros");
            a = null;
        }

        return a;
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
                               
                Create_Admin.AdAvartaimg.setIcon(new ImageIcon(fil));
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
                
                
                Create_Admin.AdAvartaimg.setIcon(newIcon);
                Create_Admin.AdAvartaimg.setText("");
                Create_Admin.AdAvartaimg.setSize(97,97);
                
              
                
             try {
                    
                File source = new File(file);
                File dest = new File("src\\App\\utils\\img_app\\Users_Avatar_images\\"+source.getName());

                Singleton_App.ruta_imagen = dest.toString();
                JOptionPane.showMessageDialog(null, Singleton_App.ruta_imagen );
                
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
                               
                Change_Admin.AdAvartaimg.setIcon(new ImageIcon(fil));
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
                
                
                Change_Admin.AdAvartaimg.setIcon(newIcon);
                Change_Admin.AdAvartaimg.setText("");
                Change_Admin.AdAvartaimg.setSize(97,97);
                
                try {
                    
                File source = new File(file);
                File dest = new File("src\\App\\utils\\img_app\\Users_Avatar_images\\"+source.getName());

                Singleton_App.ruta_imagen = dest.toString();
                JOptionPane.showMessageDialog(null, Singleton_App.ruta_imagen );
                
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
