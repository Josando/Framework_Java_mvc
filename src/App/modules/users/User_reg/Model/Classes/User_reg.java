package App.modules.users.User_reg.Model.Classes;

import App.modules.users.User.User;
import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import App.classes.date_class;

@XStreamAlias("User_reg")
public class User_reg extends User implements Serializable {

	@XStreamAlias("actividad")
	private int actividad;
	@XStreamAlias("karma")
	private String karma;
	
	
	//constructor para inicializa un objeto a un estado determinado
	
	
	public User_reg(String dni, String nom, String cognom, date_class date_birthday, String mobil, String email,
			String avatar, String user, String pass, String status, int actividad, String karma, int punts) {
		
		super(dni, nom, cognom, date_birthday, mobil, email, avatar, user, pass, status);
		
		this.actividad = actividad;
		this.karma = cal_karma();
		//this.setKarma(cal_karma());
		//this.punts = punts;
		super.setbenefits(cal_benefits());
		
	}

	
public User_reg(){//connstructor por defecto
		
		
	}
	
	public  User_reg (String dni){//constructor clave primaria
		
		super (dni);
		
	}
	
public User_reg (int i, Object parametre){	//constructor dinamico
		
	super(i,parametre);
	
		switch (i) {
		
		case 10:		
			
			this.actividad = (int) parametre;
			
		default:
			
			break;
		}
	
}

public int getActividad() {
	return actividad;
}

public void setActividad(int actividad) {
	this.actividad = actividad;
	this.karma = cal_karma();
	super.setbenefits(cal_benefits());
}

public String getKarma() {
	return karma;
}

public void setKarma(String karma) {
	this.karma = cal_karma();
	super.setbenefits(cal_benefits());
}


public String toString (){//para el constructor  que inicializa a un estado determinado
		
		String cad= " ";
		
		cad= cad + super.toString();
		cad= cad + "The activity is: " + this.getActividad() + " \n ";
		cad= cad + "The karma is: " + this.getKarma() + " \n ";
		cad= cad + "The points are: " + (super.getbenefits()) + " \n";//Son los puntos en funcion del Karma
		
		return cad;
	
}
	
/**
public String toString(String dni){//para clave rimaria
	
	return super.toString(dni);
}

*/
public String toString(int i){//para el constructor dinamico
	
	String cad=" ";
		
switch (i) {
		


		case 0:		

				cad= cad + super.getDni();

				break;

		case 1:

				cad= cad + super.getNom();

				break;

		case 2:

				cad= cad + super.getCognom();


				break;

		case 3:

				cad= cad + super.getDate_birthday();


				break;

		case 4:

				cad= cad + super.getMobil();


				break;

		case 5:

				cad= cad + super.getPass();

				break;

		case 6:

				cad= cad + super.getAge();


				break;

		case 7:

				cad= cad + super.getEmail();

				break;

		case 8:

				cad= cad + super.getAvatar();

				break;

		case 9:

				cad= cad + super.getUser();



		case 10:		
			
			cad= cad + this.getActividad();
			
			break;
		
			default:
			
			break;
		}	
	
	return cad;	

}


@Override

public float cal_benefits() {
	int points=0;
	
	if (karma.equals("low")){
		
		points = 10;
	}
	
	if (karma.equals("medium")){
		
		points = 50;
	}

	if (karma.equals("hight")){
		
		points = 100;
	}

	return points;
}

public  String cal_karma() {
	
	String karma =" ";
	
	if (getActividad()<=10){
		
		karma = "low";
	}
	
	if ((getActividad()>10)&&(getActividad()<=20)){
		
		karma = "medium"; 
	}

	if (getActividad()>20){
		
		karma = "hight";
	}

	return karma;
}


	
}
