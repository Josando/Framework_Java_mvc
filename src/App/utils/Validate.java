package App.utils;


import App.modules.main_menu.model.Config;

public class Validate {

	public static boolean isValidFormatNom_cognom(String nom) {

		String nomPattern = "^([A-Za-z ÁÀÉÈÍÓÒÚñáàéèíóòú]{2,60})";

		return nom.matches(nomPattern);
	}

	public static boolean isValidFormatDNI(String nif) {

		String nifPattern = "^[X-Zx-z0-9]{1}[0-9]{7}[A-Za-z]{1}$";

		return nif.matches(nifPattern);

	}

	public static boolean isValidFormatEmailAddress(String email) {
		String emailPattern = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";

		return email.matches(emailPattern);
	}

	public static boolean isvalidmobil(String telf) {// phone number "^[67][0-9]{8}$"

		String telfPattern = "^[67][0-9]{8}$";
				

		return telf.matches(telfPattern);

	}

	public static boolean isvalidpassword(String pass) {

		String passPattern = "(?=^.{8,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$";

		return pass.matches(passPattern);

	}

	public static boolean isvalidage(String age) {

		String agePattern = "^[0-9]{1,2}$";

		return age.matches(agePattern);

	}

	public static boolean isValidnick(String nick) {

		String nickPattern = "^[A-Za-z0-9_-]{3,15}$";

		return nick.matches(nickPattern);
	}
        
        
        public static boolean isValidactivity (String Activity){
            
            String nickPattern = "[0-9]{1,3}";

		return Activity.matches(nickPattern);
            
        }
        
          public static boolean isValidshopping (String Shopping){
            
            String nickPattern = "^-?[0-9]+([\\.][0-9]*)?$";

		return Shopping.matches(nickPattern);
            
        }
        

	public static boolean isValid_date(String date) {

		String datePattern = "";
		
		switch (Config.getinstance().getDate_format()) {
		
		case "dd/MM/yyyy":
			
			datePattern = "^(([0-2]?\\d)|([3][0-1]))\\/(([0]?\\d)|([1][0-2]))\\/(\\d{4})$"; 
		
			break;
			
		case  "dd-MM-yyyy":
			
			datePattern = "^(([0-2]?\\d)|([3][0-1]))\\-(([0]?\\d)|([1][0-2]))\\-(\\d{4})$";
			
			break;
			
			
		case "yyyy/MM/dd":
			
			datePattern = "^(19|20)?[0-9]{2}[/](0?[1-9]|1[012])[/](0?[1-9]|[12][0-9]|3[01])$";
			
			break;
			
		case "yyyy-MM-dd":
			
			datePattern = "^(19|20)?[0-9]{2}[-](0?[1-9]|1[012])[-](0?[1-9]|[12][0-9]|3[01])$";
			
			break;
		}
		
		//String datePattern = "(0[1-9]|[12][0-9]|3[01])[/](0[1-9]|1[012])[/]((175[7-9])|(17[6-9][0-9])|(1[8-9][0-9][0-9])|([2-9][0-9][0-9][0-9]))";

		return date.matches(datePattern);
	}

}
