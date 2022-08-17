package GSport.ECommerce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuarios")
public class Usuarios {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idusuarios",unique=true,nullable=false)
	private Long id;
	private String nombre; 
	private String apaterno;
	private String amarterno; 
	private String email;
	private String password;
	
	
	public Usuarios(Long id, String nombre, String apaterno, String amarterno, String email, String password) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apaterno = apaterno;
		this.amarterno = amarterno;
		this.email = email;
		this.password = password;
	}

	
	public Usuarios() {}


	public Long getId() {
		return id;
	}


//	public void setId(Long id) {
//		this.id = id;
//	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApaterno() {
		return apaterno;
	}


	public void setApaterno(String apaterno) {
		this.apaterno = apaterno;
	}


	public String getAmarterno() {
		return amarterno;
	}


	public void setAmarterno(String amarterno) {
		this.amarterno = amarterno;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "Usuarios [id=" + id + ", nombre=" + nombre + ", apaterno=" + apaterno + ", amarterno=" + amarterno
				+ ", email=" + email + ", password=" + password + "]";
	}//toString

	
	

}//ClassUsuarios
