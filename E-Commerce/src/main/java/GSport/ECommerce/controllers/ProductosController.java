package GSport.ECommerce.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import GSport.ECommerce.model.Productos;
import GSport.ECommerce.servicios.ProductoServicios;
@RestController // importar este. 
@RequestMapping (path="/api/productos/")

@CrossOrigin(origins="*")
public class ProductosController {
		
		private final ProductoServicios productoServicios; 
		
		//autoconectado
		@Autowired //indica que el constructor necesita un parametro instanciado de servicio
	public ProductosController(ProductoServicios productoServicios) {
		this.productoServicios = productoServicios;
	}


		//CRUD
	@GetMapping
	public List<Productos> getAllProductos()
	{
		return productoServicios.getProductos();
	}//getAllProducts

	@GetMapping (path="{prodId}")
	public Productos getProducto(@PathVariable("prodId") Long id)
	{
		return productoServicios.getProducto(id);
	}//getProduct

	@DeleteMapping (path="{prodId}")
	public Productos deleteProducto(@PathVariable("prodId") Long id)
	{
		return productoServicios.deleteProducto(id);
	}//deleteProduct


	@PostMapping
	public Productos addProducto(@RequestBody Productos producto)
	{
		return productoServicios.addProducto(producto);
	}//addProduct

	@PutMapping (path="{prodId}")
	public Productos updateProducto(@PathVariable("prodId")Long id,
			@RequestParam(required=false) String nombre,
			@RequestParam(required=false) String descripcion,
			@RequestParam(required=false) String URL_imagen,
			@RequestParam(required=false) Double precio,
			@RequestParam(required=false) Double cantidad
			)
	//@Request Para que no me pida a la de fuerza todos los parametros. 
			{
		return productoServicios.updateProducto(id, nombre, descripcion, URL_imagen, precio, cantidad);

			}
	
	

}//CalssControl