package App.utils.dates_utils;


import javax.swing.JOptionPane;
import App.classes.date_class;



public class Date_functions {

	
	public static date_class date_not_exceeding(String message, String tittle) {//Fecha no superior a la del sistema

		
		boolean correcte = false;
		int correcto2= 0;
		date_class date = null;
		
		do {
				
			//	date = Core.ask_date(message, tittle);
			
				correcto2=date.testsystemdate();	
				
				if(correcto2==1){
					
					JOptionPane.showMessageDialog(null, "The date can't exceed the current ", "Error",
							JOptionPane.WARNING_MESSAGE, null);
					
					correcte = false;
				}else{
				correcte = true;
				
				}
			
			
			
		} while (correcte == false);

		return date;
	}
	
public static date_class legal_age(String message, String tittle, String date_format, int a, String lang) {//validar mayor de edad
		
		int age=0;
		date_class date = null;
		
		do {
				
				date = Date_functions.date_not_exceeding(message, tittle);
				
				
				age = date.subtractdates();	
				
				if(age<a){
					
					JOptionPane.showMessageDialog(null, "You are not allowed to continue,\n you have less than "+a+" years", "Error",
							JOptionPane.WARNING_MESSAGE, null);
				
				}
			
			
		} while (age <a);

		return date;
	}

public static date_class legal_work_age(String message, String tittle) {//validar edad trabajo
	
	int age=0;
	date_class ok = null;//fecha contrato
	boolean right = false;
	
	do {			
			
		ok = Date_functions.date_not_exceeding(message, tittle);
		
		
		age = ok.subtractdates();	
		
		if ((age < 16) || (age > 65)){
			
			JOptionPane.showMessageDialog(null, "You are not allowed to continue,\n you haven't age work", "Error",
					JOptionPane.WARNING_MESSAGE, null);
		right = false;
				
		}else{
			
			right = true;
		}
		
		
	} while (right == false);

	return ok;
}

public static date_class legal_work_date(String message, String tittle, date_class date_birthday) {
	
	int year=0, year1=0;
	
	date_class dateWork = null;//fecha contrato
	boolean right = false;
	
	do{
		
		dateWork = Date_functions.date_not_exceeding(message, tittle);
	
	 year = date_birthday.testdates(dateWork);

	 if (year!= 1) {
		 
			JOptionPane.showMessageDialog(null, "The date must be after the date birthday",
					"ERROR", JOptionPane.WARNING_MESSAGE);
			
			right = false;
			
		} else{
	 
		year1 = date_birthday.subtract_in_dates(dateWork);
		
		
		if ((year1 < 16) || (year1 > 65)){
			
			JOptionPane.showMessageDialog(null, "The future employee must be between 16 and 65 years",
					"ERROR", JOptionPane.WARNING_MESSAGE);		
			
			right = false;
			
		}else{
	 
			right = true;
			
		}
		}
	 
	}while(right == false);
		
	 return dateWork;
}

public static date_class legal__discarge_date(String message, String tittle, date_class date_birthday, int a) {//validar la fecha de alta
	
	int year=0, year1=0;
	date_class discarge_date = null;
	
	do{
		
		discarge_date = Date_functions.date_not_exceeding(message, tittle);
	
	 year = date_birthday.testdates(discarge_date);

	 if (year!= 1) {
		 
			JOptionPane.showMessageDialog(null, "The date must be after the date birthday",
					"ERROR", JOptionPane.WARNING_MESSAGE);			
		} else{
	 
		year1 = date_birthday.subtract_in_dates(discarge_date);
		
		
		if ((year1 < a) ){
			
			JOptionPane.showMessageDialog(null, "You are not allowed to continue,\n you have less than "+a+" years",
					"ERROR", JOptionPane.WARNING_MESSAGE);		
		}
	 
		}
	 
	}while((year!=1) || (year1 < a) );
		
	 return discarge_date;
}
	 

	
	 
			
}
