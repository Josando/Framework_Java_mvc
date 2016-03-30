package  App.modules.users.Admin.Model.Classes;
import App.classes.date_class;
import App.modules.main_menu.model.Config;
import App.modules.main_menu.model.Language.Language;
import App.modules.users.Admin.Model.Classes.Admin;
import App.modules.users.Admin.Model.Classes.Singleton;
import App.modules.users.Admin.Model.Utils.Pager.pagina;
import static App.modules.users.Admin.controler.Controlador_Admin.combo;
import App.modules.users.Admin.views.interfaz_Admin;
import java.sql.Timestamp;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.table.AbstractTableModel;
//import static App.modules.users.Admin.views.interfaz_Admin.combo;
import App.utils.Format;
import App.utils.Funciones;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.print.attribute.Size2DSyntax.MM;
import javax.swing.JOptionPane;
//import pager.modules.actores.interfaz_actor;
//import static App.modules.user.views.interfaz_actor.combo;
//import static pager.modules.actores.singleton.AL_actores;
//import pager.modules.pager.pagina;
//import static pager.resources.fnes.fnes.*;
public class miniSimpleTableModel_Admin extends AbstractTableModel {
    public static ArrayList<Admin> datos = new ArrayList<Admin>();
    public static ArrayList<Admin> datosaux = new ArrayList<Admin>();
    String[] columnas = {Language.getinstance().getProperty("id"), Language.getinstance().getProperty("name"), Language.getinstance().getProperty("surname"), Language.getinstance().getProperty("email"), Language.getinstance().getProperty("hire_date"),Language.getinstance().getProperty("salary")};

    ////////////////////estos métodos son necesarios para que jtable funcione/////////////////////
    @Override
    public String getColumnName(int col) {
        return columnas[col].toString();
    }

    //Devuelve el numero de filas
    @Override
    public int getRowCount() {
        return datos.size();
    }

    //Devuelve el numero de columnas
    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    //Devuelve el valor del objeto en la fila y columna
    @Override
    public Object getValueAt(int row, int col) {
        
       
        Object dev = null;
        Admin fila = (Admin) datos.get(row);
                       
        switch (col) {
            case 0:
                dev = fila.getDni();
                break;

            case 1:
                dev = fila.getNom();
                break;

            case 2:
                dev = fila.getCognom();
                break;

            case 3:
                dev = fila.getEmail();
                break;
                
            case 4:                             
                dev = fila.getFecha_cont();
                             
                break;
                
            case 5:
                dev = Format.Currency_Format(Funciones.Convert_Currency(fila.getSueldo(), Config.getinstance().getCurrency()));
                
        }
        return dev;
    }

    //Determina si una fila y columna ha de ser editable
    @Override
    public boolean isCellEditable(int row, int col) {
        return false;
    }

    //Actualiza un objeto de una fila y columna
    @Override
    public void setValueAt(Object value, int row, int col) {
        Admin fila = (Admin) datos.get(row);
        date_class date = null;
       
        switch (col) {
            case 0:
                fila.setDni((value.toString()));
                break;

            case 1:
                fila.setNom(value.toString());
                break;

            case 2:
                fila.setCognom(value.toString());
                break;
            
            case 3:
                fila.setEmail(value.toString());
                break;

            case 4://///ojo////
                                              
                fila.setFecha_cont( (date_class) value);
                
                break;
        }
        fireTableCellUpdated(row, col);
    }

    public void addRow(Admin usu) {
        
        datos.add(usu);
        
        fireTableDataChanged();
    }

    public void cargar() {
        datos.clear();
        datosaux.clear();
        
       
        java.util.Date date= new java.util.Date();
        for(int i=0;i<Singleton.ad.size();i++) {
      
            addRow(Singleton.ad.get(i));
            datosaux.add(Singleton.ad.get(i));
           /*
            try {
                Thread.sleep(1); //1 milliseconds
            } catch (Exception e) {
              System.out.println(e);
            }
            */
       }
    }

    public void filtrar() {
        datos.clear();
        int cont=0;
        
        String nom=(String) ((JComboBox)combo).getSelectedItem();   
        if(nom!=null){
            for(int i=0;i<datosaux.size();i++) {
                //if(datosaux.get(i).getFirst_name().contains(nom)){
                if(datosaux.get(i).getNom().toLowerCase().startsWith(nom.toLowerCase())){
                    addRow(datosaux.get(i));
                    cont++;
                }
            }
            interfaz_Admin.jLabel3.setText(String.valueOf(cont));
            System.out.println("word selected: " + nom);
            pagina.initLinkBox();
        }
    }
    
    public Admin buscar(String u) {
        datos.clear();
        cargar();

        String res;
        for (int i = 0; i < datos.size(); i++) {
            res = datos.get(i).toString();
            if (res.contains(u)) {
                return datos.get(i);
            }
        }
        return null;
    }

    public int buscaUsuario(Admin u) {
        datos.clear();
        cargar();

        for (int i = 0; i < datos.size(); i++) {
            if (datos.get(i).equals(u)) {
                return i;
            }
        }
        return -1;
    }

    public void removeRow(int fila) {
        datos.remove(fila);
        fireTableDataChanged();
    }
}
