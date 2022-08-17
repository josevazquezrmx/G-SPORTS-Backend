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

import GSport.ECommerce.model.Usuarios;
import GSport.ECommerce.servicios.UsuariosServicios;

@RestController // importar este. 
@RequestMapping (path="/api/usuarios/")

@CrossOrigin(origins="*")
public class UsuariosController {
	
	private final UsuariosServicios usuarioServicios;
	
	//autoconectado
	@Autowired //indica que el constructor necesita un parametro instanciado de servicio
public UsuariosController(UsuariosServicios usuarioServicios) {
	this.usuarioServicios = usuarioServicios;
}//Constructor
	
	@GetMapping
	public List<Usuarios> getUsuarios()
	{
		return usuarioServicios.getUsuarios();
	}//getAllProducts
	
	@PostMapping
	public Usuarios addUsurio(@RequestBody Usuarios usuario)
	{
		return usuarioServicios.addUsuario(usuario);
	}//addUsuario
	
	@GetMapping (path="{prodId}")
	public Usuarios getusuario(@PathVariable("prodId") Long id)
	{
		return usuarioServicios.getUsuario(id);
	}//getProduct

	@DeleteMapping (path="{prodId}")
	public Usuarios deleteUsuario(@PathVariable("prodId") Long id)
	{
		return usuarioServicios.deleteUsuario(id);
	}//deleteProduct

	@PutMapping (path="{prodId}")
	public Usuarios updateUsuario(@PathVariable("prodId")Long id,
			@RequestParam(required=false) String nombre,
			@RequestParam(required=false) String apaterno,
			@RequestParam(required=false) String amaterno,
			@RequestParam(required=false) String email,
			@RequestParam(required=false) String password
			)
	//@Request Para que no me pida a la de fuerza todos los parametros. 
			{
		return usuarioServicios.updateUsuario(id, nombre, apaterno, amaterno, email, password);

			}
	
	
	
	
	
	

}//classUsuarioController
