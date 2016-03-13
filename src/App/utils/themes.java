package App.utils;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.OceanTheme;

import App.modules.main_menu.model.Config;

public class themes {

	
	public static void Choicethemes() {
	
	try{
		
		switch (Config.getinstance().getTheme()) {
		
		case  "Metal":
			
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");			
			
			
			break;
			
		case "GTK-Windows":
			
			  UIManager.setLookAndFeel(UIManager
                      .getSystemLookAndFeelClassName());
			
			break;
			
		case "Motif":			
			
			UIManager
            .setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
			
			break;
			
		case  "Nimbus":
			
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
	
			break;
			
	
		}
		
		
		
	}catch (Exception e){
		
		if(Config.getinstance().getTheme()==null){
			
			
			
		}else
			
		JOptionPane.showMessageDialog(null,"No pudo cargarse la apariencia deseada", 
				"Error",JOptionPane.ERROR_MESSAGE);
}
	
	}
	}

/**
catch(ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e){
	
	 JOptionPane.showMessageDialog(null,
            "No pudo cargarse la apariencia deseada\n" + e.getMessage(), "Error",
            JOptionPane.ERROR_MESSAGE);
	
}

*/


	

