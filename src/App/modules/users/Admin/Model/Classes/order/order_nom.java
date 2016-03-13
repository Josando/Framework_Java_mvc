package App.modules.users.Admin.Model.Classes.order;

import java.util.Comparator;

import App.modules.users.User.User;

public class order_nom implements Comparator <User> {
	
	public int compare (User u1, User u2) {
		
		if(u1.getNom().compareTo(u2.getNom())>0)
			
			return 1;
		
		if(u1.getNom().compareTo(u2.getNom())<0)
			
			return -1;
		
		return 0;
	}
	
	

}
