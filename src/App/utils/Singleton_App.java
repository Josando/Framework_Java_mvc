/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App.utils;

import java.util.logging.Logger;
import javax.swing.ImageIcon;
import org.apache.commons.dbcp.BasicDataSource;


/**
 *
 * @author Jorge
 */
public class Singleton_App {
    
    public static ImageIcon ok = new ImageIcon("src/App/utils/img_app/img/Ok.png");
    public static ImageIcon cancel = new ImageIcon("src/App/utils/img_app/img/Cancel.png");
    public static String ruta_imagen;
    public static BasicDataSource dataSource;
    public static final Logger log = Logger.getLogger("BD_Connection");
    
}
