package GSport.ECommerce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="productos")
public class Productos {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idproductos",unique=true,nullable=false)
	private Long id;

	
		private String nombre; 
		private String descripcion; 
		@Column(name="URL_imagen")//POr el uso de mayusculas y minuscula. Solo usa minisculas y si tiene alguna mayus se usa esto.
		private String URL_imagen; 
		private double precio;
		private double cantidad;
		
		
		public Productos(Long id, String nombre, String descripcion, String uRL_imagen, double precio, double cantidad) {
			super();
			this.id = id;
			this.nombre = nombre;
			this.descripcion = descripcion;
			URL_imagen = uRL_imagen;
			this.precio = precio;
			this.cantidad = cantidad;
		}//Constructor
		
		public Productos() {}

		public Long getId() {
			return id;
		}


//		public void setId(Long id) {
//			this.id = id;
//		}


		public String getNombre() {
			return nombre;
		}


		public void setNombre(String nombre) {
			this.nombre = nombre;
		}


		public String getDescripcion() {
			return descripcion;
		}


		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}


		public String getURL_imagen() {
			return URL_imagen;
		}


		public void setURL_imagen(String uRL_imagen) {
			URL_imagen = uRL_imagen;
		}


		public double getPrecio() {
			return precio;
		}


		public void setPrecio(double precio) {
			this.precio = precio;
		}


		public double getCantidad(double cantidad) {
			return cantidad;
		}


		public void setCantidad(double cantidad) {
			this.cantidad = cantidad;
		}


		@Override
		public String toString() {
			return "Productos [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", URL_imagen="
					+ URL_imagen + ", precio=" + precio + ", cantidad=" + cantidad + "]";
		}
		
		
		
	
	
	
	
	
}//Producto