package  App.modules.users.Client.Model.Classes;
import App.classes.date_class;
import App.modules.main_menu.model.Config;
import App.modules.users.Client.Model.Utils.Pager.pagina;
import App.modules.users.Client.Model.bll.Client_DB_BLL;
import App.modules.users.Client.Model.dao.Client_DB_DAO;
import static App.modules.users.Client.controler.Controlador_Client.combo;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.table.AbstractTableModel;
import  App.modules.users.Client.views.interfaz_Client;
import App.utils.Format;
import App.utils.Funciones;

public class miniSimpleTableModel_Client extends AbstractTableModel {
    public static ArrayList<Client> datos = new ArrayList<Client>();
    public static ArrayList<Client> datosaux = new ArrayList<Client>();
    String[] columnas = {"DNI", "First_name", "Last_name", "Email", "Fecha_alta","Compras"};

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
        Client fila = (Client) datos.get(row);
                       
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
                dev = fila.getF_alta();
                             
                break;
                
            case 5:
                dev = Format.Currency_Format(Funciones.Convert_Currency(fila.getCompra$(), Config.getinstance().getCurrency()));
                
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
        Client fila = (Client) datos.get(row);
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
                                              
                fila.setF_alta((date_class) value);
                
                break;
        }
        fireTableCellUpdated(row, col);
    }

    public void addRow(Client usu) {
        
        datos.add(usu);
        
        fireTableDataChanged();
    }

    public void cargar() {
        datos.clear();
        datosaux.clear();
        //Client_DB_DAO.print_table();
        Client_DB_BLL.print_table();
        java.util.Date date= new java.util.Date();
        for(int i=0;i<Singleton_cli.cli.size();i++) {
      
            addRow(Singleton_cli.cli.get(i));
            datosaux.add(Singleton_cli.cli.get(i));
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
            interfaz_Client.jLabel3.setText(String.valueOf(cont));
            System.out.println("word selected: " + nom);
            pagina.initLinkBox();
        }
    }
    
    public Client buscar(String u) {
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

    public int buscaUsuario(Client u) {
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
