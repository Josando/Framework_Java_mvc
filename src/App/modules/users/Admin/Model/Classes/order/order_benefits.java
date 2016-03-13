package App.modules.users.Admin.Model.Classes.order;

import java.util.Comparator;

import App.modules.users.User.User;

public class order_benefits implements Comparator <User> {

public int compare(User u1, User u2) {
		
		if(u1.getbenefits() > u2.getbenefits())
			
			return 1;
		
		if(u1.getbenefits() > u2.getbenefits())
			
			return -1;
		
		return 0;
	}
	
	
	
}
