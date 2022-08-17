
package GSport.ECommerce.servicios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import GSport.ECommerce.model.Productos;

public interface ProductosRepositorio extends JpaRepository<Productos, Long>{
	
	@Query("SELECT p FROM Productos p WHERE p.nombre=?1")
	
	Optional<Productos>findByNombre(String NombreProducto);

}