package App.modules.users.Client.Model.Classes;

import App.modules.users.User.User;
import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import App.modules.main_menu.model.Config;
import App.classes.date_class;
import App.utils.*;

@XStreamAlias("Client")
public class Client extends User implements Serializable {

	@XStreamAlias("f_alta")
	private date_class f_alta;
	@XStreamAlias("antiguedad")
	private int antiguedad;
	@XStreamAlias("compras")
	private float compra$;
	@XStreamAlias("premium")
	private boolean premium;
	@XStreamAlias("client_type")
	private String client_type;	
	
	//constructor para inicializa un objeto a un estado determinado

	public Client(String dni, String nom, String cognom, date_class date_birthday, String mobil,  String email,
			String avatar, String user, String pass, String status, date_class f_alta, float dtos$,
			float compra$, boolean premium, String client_type) {
		
		super(dni, nom, cognom, date_birthday, mobil, email, avatar, user, pass, status);
		
		this.f_alta = f_alta;
		this.setAntiguedad(f_alta.subtractdates());
		//this.antiguedad = antiguedad;
		this.compra$ = compra$;
		this.premium = premium;
		this.client_type = client_type;
		super.setbenefits(cal_benefits());
	}
	
	
	public Client(){//connstructor por defecto
		
		
	}
	


	public  Client (String dni){//constructor clave primaria
		
		super(dni);
		
	}
	
	public Client (int i, Object parametre){//constructor dinamico
		
		super(i,parametre);
		
		
		switch (i) {
		
		
		case 10:		
			
			this.f_alta = (date_class) parametre;
			
			break;
			
		case 11:
			
			this.antiguedad = (int) parametre;
			
			break;
	
		case 13:
			
			this.compra$ = (float) parametre;
			
			break;
			
		case 14:
			
			this.premium = (boolean) parametre;
			
			break;
			
		case 15:
			
			this.client_type = (String) parametre;
			
			break;
			
		default:
			
			break;
		}
	
		
}


public date_class getF_alta() {
		return f_alta;
	}


	public void setF_alta(date_class f_alta) {
		this.f_alta = f_alta;
		this.setAntiguedad(f_alta.subtractdates());
	}


	public int getAntiguedad() {
		return antiguedad;
	}


	public void setAntiguedad(int antiguedad) {
		this.antiguedad = antiguedad;
		
	}


	public float getCompra$() {
		return compra$;
	}


	public void setCompra$(float compra$) {
		this.compra$ = compra$;
	}


	public boolean isPremium() {
		return premium;
	}


	public void setPremium(boolean premium) {
		this.premium = premium;
		super.setbenefits(cal_benefits());
	}


	public String getClient_type() {
		return client_type;
	}


	public void setClient_type(String client_type) {
		this.client_type = client_type;
	}


public String toString( ){//para el constructor  que inicializa a un estado determinado
		
		String cad= " ";
		
		cad= cad + super.toString();
		cad= cad + "The discarge date is: " + this.getF_alta() + " \n ";
		cad= cad + "The antiguity is: " + this.getAntiguedad() + " \n ";
	//	cad= cad + "The discounts are " + this.getDtos$() + " \n ";
		cad= cad + "The value of shoping are: " +Format.Currency_Format(Funciones.Convert_Currency(this.getCompra$(), Config.getinstance().getCurrency()))+ " \n ";
		cad= cad + "Premium?: " + this.isPremium() + " \n ";
		cad= cad + "The discounts are: " +Format.Currency_Format( Funciones.Convert_Currency(super.getbenefits(), Config.getinstance().getCurrency())) + " \n";
		return cad;
	
}
	
/***

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
			
			cad= cad + this.getF_alta();
			
			break;
			
		case 11:
			
			cad= cad + this.getAntiguedad();
			
			break;
		
		case 13:
			
			cad= cad + this.getCompra$();
		
			
			break;
			
		case 14:
			
			cad= cad + this.isPremium();
			
			
			break;
			
			default:
			
			break;
		}	
	
	return cad;	

}


@Override

public float cal_benefits() {
	
	float disconts=0.0f;
	
	if(premium==true){
		
	disconts = 10;
	
	}
	
	return disconts;
}	

}
