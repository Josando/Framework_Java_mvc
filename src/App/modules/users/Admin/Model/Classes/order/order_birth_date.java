package App.modules.users.Admin.Model.Classes.order;

import java.util.Comparator;

import App.modules.users.User.User;

public class order_birth_date  implements Comparator <User> {
	
	
	public int compare(User v1, User v2){
		
		if(v1.getDate_birthday().testdates(v2.getDate_birthday())==1)
			
			return 1;
		
		if(v1.getDate_birthday().testdates(v2.getDate_birthday())==3)
			
			return -1;
		
		return 0;
		}

	

}
