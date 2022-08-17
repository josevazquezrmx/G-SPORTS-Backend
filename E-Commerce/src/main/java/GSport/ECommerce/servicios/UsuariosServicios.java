package GSport.ECommerce.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import GSport.ECommerce.model.Usuarios;

@Service
public class UsuariosServicios {
	
	
	private final UsuariosRepositorios usuariosRepositorios;
	
	//public final ArrayList<Usuarios> lista=new ArrayList<Usuarios>();
	//se intancia para cuando se levante el servidor se crea una instancia del servicio.
	
		
		public UsuariosServicios(UsuariosRepositorios usuariosRepositorios)
		{
					
			this.usuariosRepositorios=usuariosRepositorios;
			
		}//Constructor
		
	
		public List<Usuarios> getUsuarios() {
			// TODO Auto-generated method stub
			return usuariosRepositorios.findAll();
		}//getUsuarios
		
		public Usuarios getUsuario(Long id)
		{
			return usuariosRepositorios.findById(id).orElseThrow(
					()-> new IllegalArgumentException("El Usuario con el id "+id+" no existe.")
					);
		}//get usuario

		public Usuarios deleteUsuario(Long id) {
			Usuarios tmpUsuario=null;
			
			if(usuariosRepositorios.existsById(id))
			{
				tmpUsuario=usuariosRepositorios.findById(id).get();
				usuariosRepositorios.deleteById(id);
			}//if Exist
			return tmpUsuario;
		}//deleteProducto
		
		public Usuarios addUsuario(Usuarios usuario)
		{
			Usuarios tmpUsuario=null;
			Optional <Usuarios> userByName=usuariosRepositorios.findByNombre(usuario.getNombre());
			
			if(userByName.isPresent())
			{
				throw new IllegalArgumentException("El usuario con el nombre ["+usuario.getNombre()+" ] ya existe");
			}
			else
			{
				usuariosRepositorios.save(usuario);
				tmpUsuario=usuario;
			}//else//if Present
			return tmpUsuario;
		}//addProducto
		
		public Usuarios updateUsuario(Long id, String nombre, String apaterno, String amaterno, String email, String password)
		{
			Usuarios tmpUsuario=null;
			if(usuariosRepositorios.existsById(id))
			{
				tmpUsuario=usuariosRepositorios.findById(id).get();
				if(nombre!=null)tmpUsuario.setNombre(nombre); 
				if (apaterno!=null)tmpUsuario.setApaterno(apaterno);
				if(amaterno!=null)tmpUsuario.setApaterno(apaterno);
				if(email!=null)tmpUsuario.setEmail(email);
				if(password!=null)tmpUsuario.setPassword(password);
			
				usuariosRepositorios.save(tmpUsuario);
			}
			else
			{
				System.out.println("El usuario con el id:_ "+id+" no existe.");
			}//else//if update
			return tmpUsuario;
		}//updateProduct
		

}//ClassusaiosSerevicios
