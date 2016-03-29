/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App.modules.users.User_reg.Model.dao;

import App.classes.date_class;
import App.modules.main_menu.model.Language.Language;
import App.modules.users.User_reg.Model.Classes.Singleton_user_reg;
import App.modules.users.User_reg.Model.Classes.User_reg;
import App.modules.users.User_reg.Model.bll.User_reg_BLL;
import App.modules.users.User_reg.Views.Change_User_reg;
import App.modules.users.User_reg.Views.Create_User_reg;


import App.utils.Validate;
import java.awt.HeadlessException;
import java.text.SimpleDateFormat;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import App.utils.Funciones;
import App.utils.Singleton_App;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
/**
 *
 * @author Jorge
 */
public class User_reg_DAO {

    /////Validacion para ventana create Admin/////
    
    public static boolean Create_requests_name() {
        boolean b = false;

        if (Create_User_reg.AdNametext.getText().isEmpty()) {
            Create_User_reg.name_label.setIcon(Singleton_App.cancel);

        } else if (!Validate.isValidFormatNom_cognom(Create_User_reg.AdNametext.getText())) {
            Create_User_reg.name_label.setIcon(Singleton_App.cancel);

        } else {

            Create_User_reg.name_label.setIcon(Singleton_App.ok);
            b = true;
        }
        return b;
    }

    public static boolean Create_requests_surname() {
        boolean b = false;

        if (Create_User_reg.AdSurnametext.getText().isEmpty()) {
            Create_User_reg.surname_label.setIcon(Singleton_App.cancel);

        } else if (!Validate.isValidFormatNom_cognom(Create_User_reg.AdSurnametext.getText())) {
            Create_User_reg.surname_label.setIcon(Singleton_App.cancel);

        } else {

            Create_User_reg.surname_label.setIcon(Singleton_App.ok);
            b = true;

        }
        return b;
    }

    public static boolean create_ask_mobil() {

        boolean b = false;

        if (Create_User_reg.AdMobiltext.getText().isEmpty()) {
            Create_User_reg.mobil_label.setIcon(Singleton_App.cancel);

        } else if (!Validate.isvalidmobil(Create_User_reg.AdMobiltext.getText())) {
            Create_User_reg.mobil_label.setIcon(Singleton_App.cancel);

        } else {
            Create_User_reg.mobil_label.setIcon(Singleton_App.ok);
            b = true;
        }

        return b;

    }

    public static boolean create_ask_email() {

        boolean b = false;

        if (Create_User_reg.ADEmailtext.getText().isEmpty()) {
            Create_User_reg.email_label.setIcon(Singleton_App.cancel);

        } else if (!Validate.isValidFormatEmailAddress(Create_User_reg.ADEmailtext.getText())) {
            Create_User_reg.email_label.setIcon(Singleton_App.cancel);

        } else {
            Create_User_reg.email_label.setIcon(Singleton_App.ok);

            b = true;
        }

        return b;

    }

    public static boolean create_ask_username() {

        boolean b = false;

        if (Create_User_reg.AdUsernametext.getText().isEmpty()) {
            Create_User_reg.user_name_label.setIcon(Singleton_App.cancel);

        } else if (!Validate.isValidnick(Create_User_reg.AdUsernametext.getText())) {
            Create_User_reg.user_name_label.setIcon(Singleton_App.cancel);

        } else {
            Create_User_reg.user_name_label.setIcon(Singleton_App.ok);
            b = true;
        }
        return b;
    }

    public static boolean create_ask_pass() {
        boolean b = false;

        if (Create_User_reg.AdPasstext.getText().isEmpty()) {
            Create_User_reg.pass_label.setIcon(Singleton_App.cancel);

        } else if (!Validate.isvalidpassword(Create_User_reg.AdPasstext.getText())) {
            Create_User_reg.pass_label.setIcon(Singleton_App.cancel);
        } else {

            Create_User_reg.pass_label.setIcon(Singleton_App.ok);
            b = true;

        }
        return b;
    }

    public static boolean create_ask_Activity() {
        boolean b = false;

        if (Create_User_reg.AdActivitytext.getText().isEmpty()) {
            Create_User_reg.activity_label.setIcon(Singleton_App.cancel);

        } else if (!Validate.isValidactivity(Create_User_reg.AdActivitytext.getText())) {
            Create_User_reg.activity_label.setIcon(Singleton_App.cancel);
        } else {

            Create_User_reg.activity_label.setIcon(Singleton_App.ok);
            b = true;
        }
        return b;
    }

    public static boolean create_ask_ID() {
        boolean b = false;

        if (Create_User_reg.AdIDtext.getText().isEmpty()) {
            Create_User_reg.id_label.setIcon(Singleton_App.cancel);

        } else if (!Validate.isValidFormatDNI(Create_User_reg.AdIDtext.getText())) {
            Create_User_reg.id_label.setIcon(Singleton_App.cancel);

        } else {

            Create_User_reg.id_label.setIcon(Singleton_App.ok);
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

            dni = Create_User_reg.AdIDtext.getText();
            dni = dni.toUpperCase();

            for (int i = 0; i < 8; i++) {
                aux += dni.charAt(i);

            }

            letter = dni.charAt(8);

            numb = Integer.parseInt(aux);

            rest = numb % 23;

            control = characters.charAt(rest);

            if (control == letter) {

                Create_User_reg.id_label.setIcon(Singleton_App.ok);
                b = true;

                Singleton_user_reg.DNI = dni;

                User_reg u = new User_reg(Singleton_user_reg.DNI);

                if (User_reg_BLL.search_Us(u) != -1) {

                    JOptionPane.showMessageDialog(null, Language.getinstance().getProperty("exists"), Language.getinstance().getProperty("admin"),
                            JOptionPane.ERROR_MESSAGE);
                    Create_User_reg.id_label.setIcon(Singleton_App.cancel);
                    b = false;
                }

            } else {

                Create_User_reg.id_label.setIcon(Singleton_App.cancel);
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

            SimpleDateFormat dateFormat = new SimpleDateFormat(Create_User_reg.Addatebirthdaytext.getDateFormatString());

            date_birthday = dateFormat.format(Create_User_reg.Addatebirthdaytext.getDate());

            if (date_birthday != null) {

                if (!Validate.isValid_date(date_birthday)) {

                    Create_User_reg.date_label.setIcon(Singleton_App.cancel);

                } else {

                    date = new date_class(date_birthday);

                    ok = date.testDate();

                    if (ok == false) {

                        Create_User_reg.date_label.setIcon(Singleton_App.cancel);

                    } else {

                        ok2 = date.testsystemdate();

                        if (ok2 == 1) {

                            JOptionPane.showMessageDialog(null, "The date can't exceed the current ", "Error",
                                    JOptionPane.WARNING_MESSAGE, null);
                            Create_User_reg.date_label.setIcon(Singleton_App.cancel);

                        } else {

                            age = date.subtractdates();

                            if ((age < 16) || (age > 65)) {

                                JOptionPane.showMessageDialog(null, "You are not allowed to continue,\n you haven't age work", "Error",
                                        JOptionPane.WARNING_MESSAGE, null);

                            } else {

                                Create_User_reg.date_label.setIcon(Singleton_App.ok);
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

    /*
    public static boolean create_validate_hire_date() {

        String hire_date = "", date_birthday = "";
        date_class date = null, date1 = null;
        boolean ok = false, b = false;
        int ok2 = 0, year = 0, year1 = 0;

        try {

            SimpleDateFormat dateFormat = new SimpleDateFormat(Create_User_reg.Addatebirthdaytext.getDateFormatString());

            hire_date = dateFormat.format(Create_User_reg.Adhiredatetext.getDate());
            date_birthday = dateFormat.format(Create_User_reg.Addatebirthdaytext.getDate());
            date1 = new date_class(date_birthday);

            if (hire_date != null) {

                if (!Validate.isValid_date(hire_date)) {

                    Create_User_reg.hiredate_label.setIcon(Singleton_App.cancel);

                } else {

                    date = new date_class(hire_date);

                    ok = date.testDate();

                    if (ok == false) {

                        Create_User_reg.hiredate_label.setIcon(Singleton_App.cancel);

                    } else {

                        ok2 = date.testsystemdate();

                        if (ok2 == 1) {

                            JOptionPane.showMessageDialog(null, "The date can't exceed the current ", "Error",
                                    JOptionPane.WARNING_MESSAGE, null);
                            Create_User_reg.hiredate_label.setIcon(Singleton_App.cancel);

                        } else {

                            year = date1.testdates(date);

                            if (year != 1) {

                                JOptionPane.showMessageDialog(null, "The date must be after the date birthday",
                                        "ERROR", JOptionPane.WARNING_MESSAGE);
                                Create_User_reg.hiredate_label.setIcon(Singleton_App.cancel);

                            } else {

                                year1 = date1.subtract_in_dates(date);

                                if ((year1 < 16) || (year1 > 65)) {

                                    JOptionPane.showMessageDialog(null, "The future employee must be between 16 and 65 years",
                                            "ERROR", JOptionPane.WARNING_MESSAGE);

                                    Create_User_reg.hiredate_label.setIcon(Singleton_App.cancel);

                                } else {

                                    Create_User_reg.hiredate_label.setIcon(Singleton_App.ok);
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

    */
    //////Validacion para ventana change User_reg//////
    
    public static boolean Change_requests_name() {
        boolean b = false;

        if (Change_User_reg.AdNametext.getText().isEmpty()) {
            Change_User_reg.Ad_name_label.setIcon(Singleton_App.cancel);

        } else if (!Validate.isValidFormatNom_cognom(Change_User_reg.AdNametext.getText())) {
            Change_User_reg.Ad_name_label.setIcon(Singleton_App.cancel);

        } else {

            Change_User_reg.Ad_name_label.setIcon(Singleton_App.ok);
            b = true;
        }
        return b;
    }

    public static boolean Change_requests_surname() {
        boolean b = false;

        if (Change_User_reg.AdSurnametext.getText().isEmpty()) {
            Change_User_reg.Ad_surname_label.setIcon(Singleton_App.cancel);

        } else if (!Validate.isValidFormatNom_cognom(Change_User_reg.AdSurnametext.getText())) {
            Change_User_reg.Ad_surname_label.setIcon(Singleton_App.cancel);

        } else {

            Change_User_reg.Ad_surname_label.setIcon(Singleton_App.ok);
            b = true;

        }
        return b;
    }

    public static boolean Change_ask_mobil() {

        boolean b = false;

        if (Change_User_reg.AdMobiltext.getText().isEmpty()) {
            Change_User_reg.Ad_mobil_label.setIcon(Singleton_App.cancel);

        } else if (!Validate.isvalidmobil(Change_User_reg.AdMobiltext.getText())) {
            Change_User_reg.Ad_mobil_label.setIcon(Singleton_App.cancel);

        } else {
            Change_User_reg.Ad_mobil_label.setIcon(Singleton_App.ok);
            b = true;
        }

        return b;

    }

    public static boolean change_ask_email() {

        boolean b = false;

        if (Change_User_reg.ADEmailtext.getText().isEmpty()) {
            Change_User_reg.Ad_email_label.setIcon(Singleton_App.cancel);

        } else if (!Validate.isValidFormatEmailAddress(Change_User_reg.ADEmailtext.getText())) {
            Change_User_reg.Ad_email_label.setIcon(Singleton_App.cancel);

        } else {
            Change_User_reg.Ad_email_label.setIcon(Singleton_App.ok);

            b = true;
        }

        return b;

    }

    public static boolean change_ask_username() {

        boolean b = false;

        if (Change_User_reg.AdUsernametext.getText().isEmpty()) {
            Change_User_reg.Ad_user_name_label.setIcon(Singleton_App.cancel);

        } else if (!Validate.isValidnick(Change_User_reg.AdUsernametext.getText())) {
            Change_User_reg.Ad_user_name_label.setIcon(Singleton_App.cancel);

        } else {
            Change_User_reg.Ad_user_name_label.setIcon(Singleton_App.ok);
            b = true;
        }
        return b;
    }

    public static boolean change_ask_pass() {
        boolean b = false;

        if (Change_User_reg.AdPasstext.getText().isEmpty()) {
            Change_User_reg.Ad_pass_label.setIcon(Singleton_App.cancel);

        } else if (!Validate.isvalidpassword(Change_User_reg.AdPasstext.getText())) {
            Change_User_reg.Ad_pass_label.setIcon(Singleton_App.cancel);
        } else {

            Change_User_reg.Ad_pass_label.setIcon(Singleton_App.ok);
            b = true;

        }
        return b;
    }

    public static boolean change_ask_Activity() {
        boolean b = false;

        if (Change_User_reg.AdActivitytext.getText().isEmpty()) {
            Change_User_reg.Ad_activity_label.setIcon(Singleton_App.cancel);

        } else if (!Validate.isValidactivity(Change_User_reg.AdActivitytext.getText())) {
            Change_User_reg.Ad_activity_label.setIcon(Singleton_App.cancel);
        } else {

            Change_User_reg.Ad_activity_label.setIcon(Singleton_App.ok);
            b = true;
        }
        return b;
    }

    public static boolean change_ask_ID() {
        boolean b = false;

        if (Change_User_reg.AdIDtext.getText().isEmpty()) {
            Change_User_reg.Ad_ID_label.setIcon(Singleton_App.cancel);

        } else if (!Validate.isValidFormatDNI(Change_User_reg.AdIDtext.getText())) {
            Change_User_reg.Ad_ID_label.setIcon(Singleton_App.cancel);

        } else {

            Change_User_reg.Ad_ID_label.setIcon(Singleton_App.ok);
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

            dni = Change_User_reg.AdIDtext.getText();
            dni = dni.toUpperCase();

            for (int i = 0; i < 8; i++) {
                aux += dni.charAt(i);

            }

            letter = dni.charAt(8);

            numb = Integer.parseInt(aux);

            rest = numb % 23;

            control = characters.charAt(rest);

            if (control == letter) {

                Change_User_reg.Ad_ID_label.setIcon(Singleton_App.ok);
                b = true;

                Singleton_user_reg.DNI = dni;

                User_reg u = new User_reg(Singleton_user_reg.DNI);

                if (User_reg_BLL.search_Us(u) != -1) {

                    JOptionPane.showMessageDialog(null, Language.getinstance().getProperty("exists"), Language.getinstance().getProperty("admin"),
                            JOptionPane.ERROR_MESSAGE);
                    Change_User_reg.Ad_ID_label.setIcon(Singleton_App.cancel);
                    b = false;
                }

            } else {

                Change_User_reg.Ad_ID_label.setIcon(Singleton_App.cancel);
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

            SimpleDateFormat dateFormat = new SimpleDateFormat(Change_User_reg.Addatebirthdaytext.getDateFormatString());

            date_birthday = dateFormat.format(Change_User_reg.Addatebirthdaytext.getDate());

            if (date_birthday != null) {

                if (!Validate.isValid_date(date_birthday)) {

                    Change_User_reg.Ad_date_birthday_label.setIcon(Singleton_App.cancel);

                } else {

                    date = new date_class(date_birthday);

                    ok = date.testDate();

                    if (ok == false) {

                        Change_User_reg.Ad_date_birthday_label.setIcon(Singleton_App.cancel);

                    } else {

                        ok2 = date.testsystemdate();

                        if (ok2 == 1) {

                            JOptionPane.showMessageDialog(null, "The date can't exceed the current ", "Error",
                                    JOptionPane.WARNING_MESSAGE, null);
                            Change_User_reg.Ad_date_birthday_label.setIcon(Singleton_App.cancel);

                        } else {

                            age = date.subtractdates();

                            if ((age < 16) || (age > 65)) {

                                JOptionPane.showMessageDialog(null, "You are not allowed to continue,\n you haven't age work", "Error",
                                        JOptionPane.WARNING_MESSAGE, null);

                            } else {

                                Change_User_reg.Ad_date_birthday_label.setIcon(Singleton_App.ok);
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

    /*
    public static boolean change_validate_hire_date() {

        String hire_date = "", date_birthday = "";
        date_class date = null, date1 = null;
        boolean ok = false, b = false;
        int ok2 = 0, year = 0, year1 = 0;

        try {

            SimpleDateFormat dateFormat = new SimpleDateFormat(Change_User_reg.Addatebirthdaytext.getDateFormatString());

            hire_date = dateFormat.format(Change_User_reg.Adhiredatetext.getDate());
            date_birthday = dateFormat.format(Change_User_reg.Addatebirthdaytext.getDate());
            date1 = new date_class(date_birthday);

            if (hire_date != null) {

                if (!Validate.isValid_date(hire_date)) {

                    Change_User_reg.Ad_hire_date.setIcon(Singleton_App.cancel);

                } else {

                    date = new date_class(hire_date);

                    ok = date.testDate();

                    if (ok == false) {

                        Change_User_reg.Ad_hire_date.setIcon(Singleton_App.cancel);

                    } else {

                        ok2 = date.testsystemdate();

                        if (ok2 == 1) {

                            JOptionPane.showMessageDialog(null, "The date can't exceed the current ", "Error",
                                    JOptionPane.WARNING_MESSAGE, null);
                            Change_User_reg.Ad_hire_date.setIcon(Singleton_App.cancel);

                        } else {

                            year = date1.testdates(date);

                            if (year != 1) {

                                JOptionPane.showMessageDialog(null, "The date must be after the date birthday",
                                        "ERROR", JOptionPane.WARNING_MESSAGE);
                                Change_User_reg.Ad_hire_date.setIcon(Singleton_App.cancel);

                            } else {

                                year1 = date1.subtract_in_dates(date);

                                if ((year1 < 16) || (year1 > 65)) {

                                    JOptionPane.showMessageDialog(null, "The future employee must be between 16 and 65 years",
                                            "ERROR", JOptionPane.WARNING_MESSAGE);

                                    Change_User_reg.Ad_hire_date.setIcon(Singleton_App.cancel);

                                } else {

                                    Change_User_reg.Ad_hire_date.setIcon(Singleton_App.ok);
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
    
    
    
    */
    
    ///////////////////////////////////////////////
    
    public static User_reg Create_Check_and_save() {

        User_reg u = null;
        String dni = " ", nom = " ", cognom = " ", mobil = " ", email = " ", avatar = Singleton_App.ruta_imagen,
                user = " ", pass = " ", status = (String) Create_User_reg.Status_combo.getSelectedItem();
        date_class fecha_cont = null;
        date_class date_birthday = null;
        String birthday = "", karma ="";
        int actividad = 0, punts=0;

        boolean Id = create_control_ID(),
                name = Create_requests_name(),
                surname = Create_requests_surname(),
                date_birtday_ = create_validate_date_birthday(),
                movil = create_ask_mobil(),
                Email = create_ask_email(),
                user_name = create_ask_username(),
                password = create_ask_pass(),
              //  hire_date = create_validate_hire_date(),
                activity = create_ask_Activity();

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(Create_User_reg.Addatebirthdaytext.getDateFormatString());

            //hire = dateFormat.format(Create_User_reg.Adhiredatetext.getDate());
            birthday = dateFormat.format(Create_User_reg.Addatebirthdaytext.getDate());
            
        } catch (Exception e) {

        }

        if ((Id == true) && (name == true) && (surname == true) && (date_birtday_ == true) && (movil == true) && (Email == true) && (user_name == true) && (password == true)  && (activity == true)) {

//            fecha_cont = new date_class(hire);
            date_birthday = new date_class(birthday);
            nom = Create_User_reg.AdNametext.getText();
            cognom = Create_User_reg.AdSurnametext.getText();
            mobil = Create_User_reg.AdMobiltext.getText();
            email = Create_User_reg.ADEmailtext.getText();
            //avatar= Create_Admin.ad.getText();
            user = Create_User_reg.AdUsernametext.getText();
            pass = Create_User_reg.AdPasstext.getText();
            //status=
            actividad = Integer.parseInt(Create_User_reg.AdActivitytext.getText());

            u = new User_reg(Singleton_user_reg.DNI, nom, cognom, date_birthday, mobil, email,
                    avatar, user, pass, status, actividad, karma, punts);

           
            // Singleton.ad.add(a);
        } else {

            JOptionPane.showMessageDialog(null, "Revisar los parametros");
            u = null;
        }

        return u;
    }

   public static User_reg Change_Check_and_save() {

        User_reg u = null;
        String dni = " ", nom = " ", cognom = " ", mobil = " ", email = " ", avatar = "",
                user = " ", pass = " ", status = (String) Change_User_reg.Status_combo.getSelectedItem();
        date_class fecha_cont = null;
        date_class date_birthday = null;
        String birthday = "", hire = "", karma="";
        int actividad = 0, punts=0;

        boolean //Id = create_control_ID(),
                name = Change_requests_name(),
                surname = Change_requests_surname(),
                date_birtday_ = change_validate_date_birthday(),
                movil = Change_ask_mobil(),
                Email = change_ask_email(),
                user_name = change_ask_username(),
                password = change_ask_pass(),
               // hire_date = change_validate_hire_date(),
                activity = change_ask_Activity();

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(Change_User_reg.Addatebirthdaytext.getDateFormatString());

           // hire = dateFormat.format(Change_User_reg.Adhiredatetext.getDate());
            birthday = dateFormat.format(Change_User_reg.Addatebirthdaytext.getDate());
            
        } catch (Exception e) {

        }

        if ((name == true) && (surname == true) && (date_birtday_ == true) && (movil == true) && (Email == true) && (user_name == true) && (activity == true)) {

            dni = Change_User_reg.AdIDtext.getText();
//            fecha_cont = new date_class(hire);
            date_birthday = new date_class(birthday);
            nom = Change_User_reg.AdNametext.getText();
            cognom = Change_User_reg.AdSurnametext.getText();
            mobil = Change_User_reg.AdMobiltext.getText();
            email = Change_User_reg.ADEmailtext.getText();
            avatar= Singleton_App.ruta_imagen;           
            user = Change_User_reg.AdUsernametext.getText();
            pass = Change_User_reg.AdPasstext.getText();
            //status=
            actividad = Integer.parseInt(Change_User_reg.AdActivitytext.getText());

            u = new User_reg(dni, nom, cognom, date_birthday, mobil, email,
                    avatar, user, pass, status, actividad, karma, punts);

           // JOptionPane.showMessageDialog(null, a.toString());
           
        } else {

            JOptionPane.showMessageDialog(null, "Revisa los parametros");
            u = null;
        }

        return u;
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
                               
                Create_User_reg.AdAvartaimg.setIcon(new ImageIcon(fil));
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
                
                
                Create_User_reg.AdAvartaimg.setIcon(newIcon);
                Create_User_reg.AdAvartaimg.setText("");
                Create_User_reg.AdAvartaimg.setSize(97,97);
                
              
                
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
                               
                Change_User_reg.AdAvartaimg.setIcon(new ImageIcon(fil));
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
                
                
                Change_User_reg.AdAvartaimg.setIcon(newIcon);
                Change_User_reg.AdAvartaimg.setText("");
                Change_User_reg.AdAvartaimg.setSize(97,97);
                
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
