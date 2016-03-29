package App.modules.users.Admin.Model.Classes;


import java.io.Serializable;
import java.nio.Buffer;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import App.modules.main_menu.model.Config;
import App.classes.date_class;
import App.modules.users.User.User;

import App.utils.*;
import App.modules.main_menu.model.Language.Language;

@XStreamAlias("Admin")
public class Admin extends User implements Serializable {
	@XStreamAlias("actividad")
	private int actividad;
	@XStreamAlias("antiguedad")
	private int antiguedad;
	@XStreamAlias("sueldo")
	private float sueldo;
	@XStreamAlias("fecha_cont")
	private date_class fecha_cont;// fecha contrato

	public Admin(String dni, String nom, String cognom, date_class date_birthday, String mobil, String email,
			String avatar, String user, String pass, String status, int actividad, 
			date_class fecha_cont) {

		super(dni, nom, cognom, date_birthday, mobil, email, avatar, user, pass, status);

		this.actividad = actividad;

		this.setAntiguedad(fecha_cont.subtractdates());
		// this.antiguedad = antiguedad;
		this.setSueldo(cal_sueldo());
		this.fecha_cont = fecha_cont;
		super.setbenefits(cal_benefits());

	}

	public Admin() {// connstructor por defecto

	}

	public Admin(String dni) {// constructor clave primaria

		super(dni);

	}

	public Admin(int i, Object parametre) {// constructor dinamico

		super(i, parametre);

		switch (i) {

		case 10:

			this.actividad = (int) parametre;

			break;

		case 11:

			this.antiguedad = (int) parametre;

			break;

		case 12:

			this.sueldo = (float) parametre;

			break;

		case 13:// Cuidado

			this.fecha_cont = (date_class) parametre;

			break;

		default:

			break;
		}

	}

	public int getActividad() {
		return actividad;
	}

	public void setActividad(int actividad) {
		this.actividad = actividad;
		super.setbenefits(cal_benefits());
	}

	public int getAntiguedad() {
		return antiguedad;
	}

	public void setAntiguedad(int antiguedad) {
		this.antiguedad = antiguedad;
		this.setSueldo(cal_sueldo());

	}

	public float getSueldo() {
		return sueldo;
	}

	public void setSueldo(float sueldo) {
		this.sueldo = sueldo;

	}

	public date_class getFecha_cont() {
		return fecha_cont;

	}

	public void setFecha_cont(date_class fecha_cont) {
		this.fecha_cont = fecha_cont;
		this.setAntiguedad(fecha_cont.subtractdates());
	}

	public String toString( ) {
	
		//Modifico language y utilizo StringBuffer en el admin para probar. Debe sustituirse en toda la aplicacion
		
		StringBuffer a = new StringBuffer();
		
		a.append(super.toString( ));
		a.append(Language.getinstance().getProperty("the_activity") + this.getActividad() + " \n ") ;
		a.append(Language.getinstance().getProperty("the_antiguiti") + this.getAntiguedad() + " \n ");
		a.append(Language.getinstance().getProperty("the_hire_date") + this.getFecha_cont().toString() + " \n ");
		a.append(Language.getinstance().getProperty("the_salary") +  Format.Currency_Format(Funciones.Convert_Currency(this.getSueldo(), Config.getinstance().getCurrency()))+ " \n ");
		a.append(Language.getinstance().getProperty("the_incntive") + Format.Currency_Format(Funciones.Convert_Currency(super.getbenefits(), Config.getinstance().getCurrency())) + " \n");

		
		return a.toString();
		
		
		
		/**
		String cad = " ";

		cad = cad + super.toString( );
		cad = cad + "The activity is: " + this.getActividad() + " \n ";
		cad = cad + "The antiquity is: " + this.getAntiguedad() + " \n ";
		// cad= cad + "The incentive are " + this.getIncentivo() + " \n ";
		cad = cad + "The hire date is: " + this.getFecha_cont().toString() + " \n ";
		cad = cad + "The salari are: " +  Format.Currency_Format(Funciones.Convert_Currency(this.getSueldo(), Config.getinstance().getCurrency()))+ " \n ";
		cad = cad + "The incentive are: " + Format.Currency_Format(Funciones.Convert_Currency(super.getbenefits(), Config.getinstance().getCurrency())) + " \n";

		
		return cad;
*/
	}

        /*
        @Override
    public String toString() {
        return "Admin{" + "Admin_ID" + super.getDni() + "first_name=" + super.getNom() + "last_name=" + super.getCognom() + "Email" + super.getEmail()+ '}';
    }
      */  
        
	/**
	public String toString(String dni) {// para clave rimaria

		return super.toString(dni);
	}
	
	*/
	
	public String toString(int i) {// para el constructor dinamico

		String cad = " ";

		if (i < 10) {

			cad = cad + super.toString(i);

		}

		else {

			switch (i) {

			case 10:

				cad = cad + this.getActividad();

				break;

			case 11:

				cad = cad + this.getAntiguedad();

				break;

			case 12:

				cad = cad + this.getFecha_cont();

				break;

			case 14:

				cad = cad + this.getSueldo();

				break;

			default:

				break;
			}

		}
		return cad;

	}

	@Override

	// caldulo el incentivo en funcion de la actividad del administrador 2$ por
	// cada hora extra de actividad

	public float cal_benefits() {

		float incentive = 2 * getActividad();

		return incentive;
	}

	public float cal_sueldo() {// por defecto el sueldo esta en euros �

		float sueldo = 0.0f;

		if (getAntiguedad() >= 5 && (getAntiguedad() <= 10)) {

			sueldo = 1000 + 50;
		}

		if ((getAntiguedad() > 10)) {

			sueldo = 1000 + 100;

		} else {

			sueldo = 1000;

		}

		return sueldo;
	}
	
	
		
	}
	
	


