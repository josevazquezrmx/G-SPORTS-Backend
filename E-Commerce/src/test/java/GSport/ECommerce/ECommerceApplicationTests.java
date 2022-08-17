package GSport.ECommerce;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import GSport.ECommerce.model.Productos;


@SpringBootTest
@AutoConfigureMockMvc
class EcommerceApplicationTests {
	
	@Autowired
	private MockMvc mockMvc; 

	@Disabled
	@Test
	public void pruebaPUT() throws Exception
	{
		this.mockMvc.perform(put("/api/productos/4").queryParam("nombre", "Xiaomi Mi Watch Ros")
				//.header("Authoritation", "Bearer:  XXXXXXXXXXXXX")
				)
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().string(containsString("Xiaomi")));
		
	}
	
	@Test
	@Disabled("Se validará posteriormente")
	public  void prueba404() throws Exception
	{
		this.mockMvc.perform(get("/api/productos/4")).andDo(print()).andExpect(status().isNotFound());
	}
	
	@Test
	void pruebaDELETE() throws Exception 
	{
		this.mockMvc.perform(delete("/api/productos/8") ).andDo(print()).andExpect(status().isOk())
							.andExpect(content().string(containsString("Cuaderno italiana doble raya")));
		
	}//Prueba delete
	
	@Test
	void pruebaGET() throws Exception 
	{
		this.mockMvc.perform(get("/api/productos/2") ).andDo(print()).andExpect(status().isOk())
							.andExpect(content().string(containsString("Ligas")));
		
		this.mockMvc.perform(get("/api/productos/4") ).andDo(print()).andExpect(status().isOk())
							.andExpect(content().string(containsString("Polainas")));
		
	}//Prueba GET
	
	@Test
	@Disabled
	void pruebaPOST() throws Exception 
	{
		
		Productos p=new Productos();
		p.setNombre("Xiaomi Mi Watch Rosa");
		p.setDescripcion("CXiaomi Mi Watch Rosa");
		p.setURL_imagen("Xiaomi Mi Watch Rosa.jpg");
		p.setPrecio(2999.90);
		p.setCantidad(12);
		
		this.mockMvc.perform(post("/api/productos/") 
						.contentType(MediaType.APPLICATION_JSON)
						.content(asJsonString(p)))
						.andDo(print()).andExpect(status().isOk())
						.andExpect(content().string(containsString("Xiaomi Mi Watch Rosa")));
		
	}//Prueba GET
	
	public static String asJsonString(final Object obj) 
	{ 
		try 
		{ 
			return new ObjectMapper().writeValueAsString(obj); 
		} 
		catch (Exception e) 
		{ 
			throw new RuntimeException(e); 
		}//catch  
	}//asJsonString
	


}//EcommerceTests
