package  App.modules.users.User_reg.Model.Classes;
import App.classes.date_class;
import static App.modules.users.User_reg.Controler.Controlador_User_reg.combo;
import App.modules.users.User_reg.Model.Utils.Pager.pagina;
import App.modules.users.User_reg.Views.interfaz_User_reg;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.table.AbstractTableModel;

public class miniSimpleTableModel_User_reg extends AbstractTableModel {
    public static ArrayList<User_reg> datos = new ArrayList<User_reg>();
    public static ArrayList<User_reg> datosaux = new ArrayList<User_reg>();
    String[] columnas = {"DNI", "First_name", "Last_name", "Email", "Actividad", "Punts"};

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
        User_reg fila = (User_reg) datos.get(row);
                       
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
                dev = fila.getActividad();
                             
                break;
                
            case 5:
                dev = fila.getbenefits();
                
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
        User_reg fila = (User_reg) datos.get(row);
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
                                              
                fila.setActividad(Integer.valueOf(value.toString()));
                
                break;
        }
        fireTableCellUpdated(row, col);
    }

    public void addRow(User_reg usu) {
        
        datos.add(usu);
        
        fireTableDataChanged();
    }

    public void cargar() {
        datos.clear();
        datosaux.clear();
        
       
        java.util.Date date= new java.util.Date();
        
        for(int i=0;i<Singleton_user_reg.us.size();i++) {
      
            addRow(Singleton_user_reg.us.get(i));
            datosaux.add(Singleton_user_reg.us.get(i));
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
            interfaz_User_reg.jLabel3.setText(String.valueOf(cont));
            System.out.println("word selected: " + nom);
            pagina.initLinkBox();
        }
    }
    
    public User_reg buscar(String u) {
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

    public int buscaUsuario(User_reg u) {
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
