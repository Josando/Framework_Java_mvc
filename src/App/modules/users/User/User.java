package App.modules.users.User;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import App.classes.date_class;


@XStreamAlias("User")

public abstract class User implements Comparable<User>,  Serializable {
	@XStreamAlias("dni")
	private String dni;
	@XStreamAlias("nom")
	private String nom;
	@XStreamAlias("cognom")
	private String cognom;
	@XStreamAlias("date_birthday")
	private date_class date_birthday;
	@XStreamAlias("mobil")
	private String mobil;
	@XStreamAlias("age")
	private int age;
	@XStreamAlias("email")
	private String email;
	@XStreamAlias("avatar")
	private String avatar;
	@XStreamAlias("user")
	private String user;
	@XStreamAlias("pass")
	private String pass;
	@XStreamAlias("status")
	private String status;
	@XStreamAlias("benefits")
	private float benefits;
	
	//constructor para inicializa un objeto a un estado determinado
	public User (String dni, String nom, String cognom, date_class date_birthday, String mobil, String email, String avatar, String user, String pass, String status){
	
	this.dni=dni;
	this.nom=nom;
	this.cognom=cognom;
	this.date_birthday=date_birthday;
	this.mobil=mobil;
	this.setAge(date_birthday.subtractdates());
	this.email=email;
	this.avatar=avatar;
	this.user=user;
	this.pass=pass;
	this.status=status;
	
}
	
public User(){//connstructor por defecto
		
		
	}
	
	public User (String dni){//constructor clave primaria
		
		this.dni=dni;
		
	}
	
	public User (int i, Object parametre){//constructor dinamico
		
		switch (i) {
		
		case 0:		
			
			this.dni = (String) parametre;
			
			break;
			
		case 1:
			
			this.nom = (String) parametre;
			
			break;
			
		case 2:
			
			this.cognom = (String) parametre;
			
			break;
			
		case 3:
			
			this.date_birthday = (date_class) parametre;
			
			break;
			
		case 4:
			
			this.mobil = (String) parametre;
			
			break;
		
		case 5:
			
			this.pass = (String) parametre;
			
			break;
			
		case 6:
			
			this.age = (int) parametre;
			
			break;
			
		case 7:
			
			this.email= (String) parametre;
			
			break;
			
		case 8:
			
			this.avatar = (String) parametre;
			
			break;
			
		case 9:
			
			this.user = (String) parametre;
			
		default:
			
			break;
		}
	
	
	}


	public String getDni() {
		
		return dni;
	}


	public void setDni(String dni) {
		
		this.dni = dni;
	}


	public String getNom() {
		
		return nom;
	}


	public void setNom(String nom) {
		
		this.nom = nom;
	}


	public String getCognom() {
		
		return cognom;
	}


	public void setCognom(String cognom) {
		
		this.cognom = cognom;
	}


	public date_class getDate_birthday() {
		
		return date_birthday;
	}


	public void setDate_birthday(date_class date_birthday) {
		
		this.date_birthday = date_birthday;
		this.setAge(date_birthday.subtractdates());
		
	}

	public String getMobil() {
		
		return mobil;
	}


	public void setMobil(String mobil) {
		
		this.mobil = mobil;
	}


	public int getAge() {
		
		return age;
	}


	public void setAge(int age) {
		
		this.age = age;
	}


	public String getEmail() {
		
		return email;
	}


	public void setEmail(String email) {
		
		this.email = email;
	}


	public String getAvatar() {
		
		return avatar;
	}


	public void setAvatar(String avatar) {
		
		this.avatar = avatar;
	}


	public String getUser() {
		
		return user;
	}


	public void setUser(String user) {
		
		this.user = user;
	}


	public String getPass() {
		
		return pass;
	}


	public void setPass(String pass) {
		
		this.pass = pass;
	}
	
	
	public String getstatus(){
		
		return status;
	}
	
	public void setstatus(String status){
		
		this.status= status;
		
	}
	
	public float getbenefits(){
		
		return benefits;
	}
	
	public void setbenefits(float benefits){
		
		this.benefits= benefits;
		
	}

	public int compareTo(User U) {
		if(this.getDni().compareTo(U.getDni())>0)
			return 1;
		if(this.getDni().compareTo(U.getDni())<0)
			return -1;
		return 0;
	
	}
	
	public boolean equals(Object c){
		return this.getDni().equals(((User)c).getDni());
}		
	
	
	
	//metodos toString
	
public String toString( ){//para el constructor  que inicializa a un estado determinado
		
		String cad= " ";
		
		cad= cad + "The DNI is: " + this.getDni() + " \n ";
		cad= cad + "The Name is: "+ this.getNom() + " \n ";
		cad= cad + "The surname is: " + this.getCognom() + " \n ";
		cad= cad + "The date birthday is: " + this.getDate_birthday().toString() + " \n ";
		cad= cad + "The Mobile is: " + this.getMobil() + " \n ";
		cad= cad + "The Age is: " + this.getAge() + " \n ";
		cad= cad + "The Email is: " + this.getEmail() + " \n ";
		cad= cad + "The Password is: " + this.getPass() + " \n ";
		cad= cad + "The Avatar is: " + this.getAvatar() + " \n ";
		cad= cad + "The User is: " + this.getUser() + " \n ";
		cad= cad + "The status is: " + this.getstatus() + " \n";
		//cad= cad + "The benefits are" + this.getbenefits() + " \n";
		return cad;
	
}
	

/**
public String toString(String dni){//para clave rimaria
	
	String cad=" ";
	
	cad= cad + this.getDni() + " \n";
	
	return cad;
}
*/

public String toString(int i){//para el constructor dinamico
	
	String cad=" ";
		
switch (i) {
		
		case 0:		
			
			cad= cad + this.getDni();
			
			break;
			
		case 1:
			
			cad= cad + this.getNom();
			
			break;
			
		case 2:
			
			cad= cad + this.getCognom();
		
			
			break;
			
		case 3:
			
			cad= cad + this.getDate_birthday();
		
			
			break;
			
		case 4:
			
			cad= cad + this.getMobil();
			
			
			break;
		
		case 5:
			
			cad= cad + this.getPass();
			
			break;
			
		case 6:
			
			cad= cad + this.getAge();
			
			
			break;
			
		case 7:
			
			cad= cad + this.getEmail();
			
			break;
			
		case 8:
			
			cad= cad + this.getAvatar();
			
			break;
			
		case 9:
			
			cad= cad + this.getUser();
			
			default:
			
			break;
		}	
	
	return cad;	

}
public abstract float cal_benefits ();
}
