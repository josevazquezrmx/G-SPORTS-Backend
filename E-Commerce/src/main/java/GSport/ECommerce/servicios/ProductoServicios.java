package GSport.ECommerce.servicios;

import java.util.List;
import java.util.Optional;

//import java.util.ArrayList;

import org.springframework.stereotype.Service;

import GSport.ECommerce.model.Productos;

@Service
public class ProductoServicios {
	
//public final ArrayList<Productos>lista=new ArrayList<Productos>(); //Se crea la lista de los productos.
	
	private final ProductosRepositorio productosRepositorio;
	
	
	//se intancia para cuando se levante el servidor se crea una instancia del servicio.
	public ProductoServicios(ProductosRepositorio productosRepositorio)
	{
				
		this.productosRepositorio=productosRepositorio;
		
	}//Constructor
	
	public List<Productos>getProductos()
	{
		return productosRepositorio.findAll();
	}//getProductos
	
	public Productos getProducto(Long id)
	{
		return productosRepositorio.findById(id).orElseThrow(
				()-> new IllegalArgumentException("El producto con el id "+id+"no existe.")
				);
	}//get producto

	public Productos deleteProducto(Long id) {
		Productos tmProducto=null;
		
		if(productosRepositorio.existsById(id))
		{
			tmProducto=productosRepositorio.findById(id).get();
			productosRepositorio.deleteById(id);
		}//if Exist
		return tmProducto;
	}//deleteProducto
	
	public Productos addProducto(Productos producto)
	{
		Productos tmProducto=null;
		Optional <Productos> prodByName=productosRepositorio.findByNombre(producto.getNombre());
		
		if(prodByName.isPresent())
		{
			throw new IllegalArgumentException("El producto con el nombre ["+producto.getNombre()+" ] ya existe");
		}
		else
		{
			productosRepositorio.save(producto);
			tmProducto=producto;
		}//else//if Present
		return tmProducto;
	}//addProducto
	
	public Productos updateProducto(Long id, String nombre, String descripcion, String uRL_img, Double precio, Double cantidad)
	{
		Productos tmProducto=null;
		if(productosRepositorio.existsById(id))
		{
			tmProducto=productosRepositorio.findById(id).get();
			if(nombre!=null)tmProducto.setNombre(nombre); 
			if (descripcion!=null)tmProducto.setDescripcion(descripcion);
			if(uRL_img!=null)tmProducto.setURL_imagen(uRL_img);
			if(precio!=null)tmProducto.setPrecio(precio.doubleValue());
			if(cantidad!=null)tmProducto.setCantidad(cantidad.doubleValue());
		
			productosRepositorio.save(tmProducto);
		}
		else
		{
			System.out.println("El producto con el id:_ "+id+" no existe.");
		}//else//if update
		return tmProducto;
	}//updateProduct
	

}//ClassProductoServicios