package App.classes;

import App.modules.main_menu.model.Config;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import com.thoughtworks.xstream.annotations.XStreamAlias;


@XStreamAlias("date_class")
public class date_class implements Serializable {

	@XStreamAlias("date")
	private String date;
	@XStreamAlias("day")
	private int day;
	@XStreamAlias("month")
	private int month;
	@XStreamAlias("year")
	private int year;

	public date_class(String date, String i) {

		String[] dateArray = null;
		String dateformat = "";

		dateArray = date.split("/");

		this.day = Integer.parseInt(dateArray[0]);
		this.month = Integer.parseInt(dateArray[1]);
		this.year = Integer.parseInt(dateArray[2]);

		dateformat = day + "/" + month + "/" + year;

		this.date = dateformat;

	}
	
	 public date_class(String date) {
		 
	        String[] datearray = new String[3];
	        String dateformat = "";
	        
	        switch (Config.getinstance().getDate_format()) {//Config.getinstance().getDate_format()
	        
	            case "dd/MM/yyyy":
	            	
	                datearray = date.split("/");
	                this.day = Integer.parseInt(datearray[0]);
	                this.month = Integer.parseInt(datearray[1]);
	                this.year = Integer.parseInt(datearray[2]);
	                
	                dateformat = day + "/" + month + "/" + year;

	        		this.date = dateformat;
	                
	        		break;
	        		
	            case "dd-MM-yyyy":
	            	
	                datearray = date.split("-");
	                this.day = Integer.parseInt(datearray[0]);
	                this.month = Integer.parseInt(datearray[1]);
	                this.year = Integer.parseInt(datearray[2]);
	                
	                dateformat = day + "/" + month + "/" + year;

	        		this.date = dateformat;
	        		
	                break;
	                
	            case "yyyy/MM/dd":
	            	
	                datearray = date.split("/");
	                this.day = Integer.parseInt(datearray[2]);
	                this.month = Integer.parseInt(datearray[1]);
	                this.year = Integer.parseInt(datearray[0]);
	                
	                dateformat = day + "/" + month + "/" + year;

	        		this.date = dateformat;
	                
	                break;
	                
	            case "yyyy-MM-dd":
	            	
	                datearray = date.split("-");
	                this.day = Integer.parseInt(datearray[2]);
	                this.month = Integer.parseInt(datearray[1]);
	                this.year = Integer.parseInt(datearray[0]);
	        
	                dateformat = day + "/" + month + "/" + year;

	        		this.date = dateformat;
	                
	                break;
	        }
	    }
	
	
	

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	/**
	public String toString() {
		return this.getDate();
	}
*/
	
	public String toString(){
		
		String dateformat = "";
		
		
		 switch (Config.getinstance().getDate_format()) {
	        
         case "dd/MM/yyyy":
         	
        	 dateformat = String.format("%02d", this.day) + "/" + String.format("%02d", this.month) + "/" + this.year;
             
        
     		break;
     		
         case "dd-MM-yyyy":
         	
        	 dateformat = day + "-" + month + "-" + year;
     		
        	 
        	 
             break;
             
         case "yyyy/MM/dd":
         	
        	 dateformat = year + "/" + month + "/" + day;
             
        	 
        	 
             break;
             
         case "yyyy-MM-dd":
         	
        	 dateformat = year + "-" + month + "-" + day;
        	 
        	 
             
             break;
     }
		
		return dateformat;
		
		
		
	}
        
        public String toStrinng(){
		
		String dateformat = "";
		
		
		 switch (Config.getinstance().getDate_format()) {
	        
         case "dd/MM/yyyy":
         	
        	 dateformat = String.format("%02d", this.day) + "/" + String.format("%02d", this.month) + "/" + this.year;
             
        
     		break;
     		
         case "dd-MM-yyyy":
         	
        	 dateformat = day + "/" + month + "/" + year;
     		
        	 
        	 
             break;
             
         case "yyyy/MM/dd":
         	
        	 dateformat = day + "/" + month + "/" + year;
             
        	 
        	 
             break;
             
         case "yyyy-MM-dd":
         	
        	 dateformat = day + "/" + month + "/" + year;
        	 
        	 
             
             break;
     }
		
		return dateformat;
		
		
		
	}
        
	
	
	public String date_format() {
		
		String formato = "";

		
		switch (Config.getinstance().getDate_format()) {
		
		case "dd/MM/yyyy":
			
			formato = " dd/mm/yyyy";
			
			break;			
			
		case "yyyy/MM/dd":
			
			formato = " yyyy-mm-dd";
			
			break;
			
		case "dd-MM-yyyy":
			
			formato = " dd-mm-yy";
			
			break;
			
		case "yyyy-MM-dd":
			
			formato = " yyyy-mm-dd";

		}

		return formato;
	}
	
	
	
	public Calendar stringtoCalendar(String date) {

		Calendar date2 = Calendar.getInstance();
		
		try {
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

			if (date != null) {

				date2.setTime(sdf.parse(date));

			}
		} catch (Exception e) {
			return date2;

		}

		return date2;
	}

	public String calendarToString(Calendar date) {

		int day, month, year;
		String dateS = null, dateS2 = "XX/XX/XX";

		try {
			day = date.get(Calendar.DATE);
			month = ((date.get(Calendar.MONTH)) + 1);
			year = date.get(Calendar.YEAR);
			dateS = day + "/" + month + "/" + year;
		} catch (Exception e) {
			return dateS2;
		}

		return dateS;

	}

	public boolean testDay() {
		GregorianCalendar calendar = new GregorianCalendar();
		int days[] = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		if (calendar.isLeapYear(this.year)) {
			days[2] = 29;
		}

		if ((this.day >= 1) && (this.day <= days[this.month])) {
			return true;
		} else {
			return false;
		}
	}

	public boolean testMonth() {
		if ((this.month >= 1) && (this.month <= 12)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean testYear() {
		if ((this.year >= 1900) && (this.year <= 2100)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean testDate() {

		boolean ok = true;

		if (!this.testDay()) {
			ok = false;
		}
		if (!this.testMonth()) {
			ok = false;
		}
		if (!this.testYear()) {
			ok = false;
		}

		return ok;
	}

	// restar una fecha a la del sistema
	public int subtractdates() {

		String year2 = " ";
		int age = 0, factor = 0;
		Calendar today = Calendar.getInstance();
		Calendar inyear = Calendar.getInstance();

		year2 = this.getDate();

		inyear = stringtoCalendar(year2);

		if (today.get(Calendar.MONTH) <= inyear.get(Calendar.MONTH)) {

			if (today.get(Calendar.MONTH) == inyear.get(Calendar.MONTH)) {

				if (today.get(Calendar.DATE) < inyear.get(Calendar.DATE)) {

					factor = -1; 

				}

			} else {

				factor = -1; 

			}

		}

		age = (today.get(Calendar.YEAR) - inyear.get(Calendar.YEAR)) + factor;

		return age;

	}

	// comprobar dos fechas introducidas

	public int testdates(date_class date) {

		int c = 0;
		String cal2 = "";
		Calendar cal1 = new GregorianCalendar();
		Calendar cal3 = stringtoCalendar(this.getDate());

		cal2 = date.getDate();

		cal1 = stringtoCalendar(cal2);// Fecha introducida

		// Comparaciones

		if (cal3.before(cal1)) {// fecha que tenia anterior a fecha introducida

			c = 1;

		} else if (cal3.equals(cal1)) { // fecha que tenia igual a la
										// introducida

			c = 2;

		} else if (cal3.after(cal1)) { // fecha que tenia posterior a la
										// introducida

			c = 3;
		}

		return c;

	}

	// comprobar fecha del sistema

	public int testsystemdate() {

		int c = 0;
		Calendar cal2 = this.stringtoCalendar(date);
		Calendar cal1 = Calendar.getInstance();// fecha del sistema

		// Comparaciones

		if (cal1.before(cal2)) {// fecha del sistema anterior a la fecha
								// introducida

			c = 1;

		} else if (cal1.equals(cal2)) { // fecha sistema igual a la introducida

			c = 2;

		} else if (cal1.after(cal2)) { // fecha sistema posterior a la
										// introducida

			c = 3;
		}

		return c;

	}

	public int subtract_in_dates(date_class date) {

		int c = 0, age = 0;
		String cal2 = "";
		Calendar cal1 = new GregorianCalendar();
		Calendar cal3 = stringtoCalendar(this.getDate());

		cal2 = date.getDate();

		cal1 = stringtoCalendar(cal2);// fecha introducida

		if (cal1.get(Calendar.MONTH) <= cal3.get(Calendar.MONTH)) {

			if (cal1.get(Calendar.MONTH) == cal3.get(Calendar.MONTH)) {

				if (cal1.get(Calendar.DATE) < cal3.get(Calendar.DATE)) {

					c = -1; 

				}

			} else {

				c = -1; 

			}

		}

		age = (cal1.get(Calendar.YEAR) - cal3.get(Calendar.YEAR)) + c;

		return age;

	}
	

	

}
