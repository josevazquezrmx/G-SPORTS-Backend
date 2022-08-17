package GSport.ECommerce.servicios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import GSport.ECommerce.model.Usuarios;

public interface UsuariosRepositorios extends JpaRepository<Usuarios, Long>{
	
		@Query("SELECT p FROM Usuarios p WHERE p.nombre=?1")
	
	Optional<Usuarios>findByNombre(String username);

}
