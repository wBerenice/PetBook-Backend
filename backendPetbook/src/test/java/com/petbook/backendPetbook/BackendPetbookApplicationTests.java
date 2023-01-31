package com.petbook.backendPetbook;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.petbook.backendPetbook.models.Administradores;
import com.petbook.backendPetbook.models.Publicaciones;

@SpringBootTest
@AutoConfigureMockMvc
class BackendPetbookApplicationTests {
	@Autowired
	private MockMvc mockMvc;
	@Test
	@DisplayName("Prueba del método delete en productos")
	public void pruebaDELETE() throws Exception{
		this.mockMvc.perform(  delete("/api/publicaciones/11") )
		.andDo(print() )
		.andExpect(status().isOk() )
		.andExpect(content().string(containsString("Copito esta bien bonito")));	
	}//Prueba delete publicaciones
	
@Test
@DisplayName("Prueba el método UPDATE en publicaciones")
public void pruebaUPDATE() throws Exception{
	this.mockMvc.perform(  put("/api/publicaciones/4").queryParam("foto", "fotodelcopito.jpg") )
	.andDo(print() )
	.andExpect(status().isOk() )
	.andExpect(content().string(containsString("Elrrewwrretrufs")));
}//UpdatePublicaciones

@Test //Se debe implementar el @Test para indicar que es una prueba
@DisplayName("Prueba el método post de publicaciones")
public void pruebaPOST() throws Exception {
	Publicaciones p = new Publicaciones();
	p.setTitulo("Copito");
	p.setDescripcion("Copito esta bien bonito");
	p.setFoto("copito_7.jpg");
	p.setId_usuario((long) 1);
	
	this.mockMvc.perform(  post("/api/publicaciones/")
			.contentType(MediaType.APPLICATION_JSON)
			.content(asJsonString(p))
			)
	.andDo(print() )
	.andExpect(status().isOk() )
	.andExpect(content().string(containsString("copito_7.jpg") ) );
}//pruebapost
private static String asJsonString(final Object obj) {
    try {
      return new ObjectMapper().writeValueAsString(obj);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }//catch
 } // asJsonString

@Test //Se debe implementar el @Test para indicar que es una prueba
@DisplayName("Prueba el método GET de publicaciones con id1")
public void pruebaGET() throws Exception {
	this.mockMvc.perform(  get("/api/publicaciones/1") )
	.andDo(print() )
	.andExpect(status().isOk() )
	.andExpect(content().string(containsString("El marco")));
}//pruebaGet publicaciones



//Pruebas Administradores

@Test //Se debe implementar el @Test para indicar que es una prueba
@DisplayName("Prueba el método post de administradores")
public void pruebaPOST1() throws Exception {
	Administradores a = new Administradores();
	a.setNombre("lapepa");
	a.setContrasena("pig");
	
	
	this.mockMvc.perform(  post("/api/administradores/")
			.contentType(MediaType.APPLICATION_JSON)
			.content(asJsonString(a))
			)
	.andDo(print() )
	.andExpect(status().isOk() )
	.andExpect(content().string(containsString("Horus") ) );
}//pruebapost administradores

//pruebaGet
@Test //Se debe implementar el @Test para indicar que es una prueba
@DisplayName("Prueba el método GET de administradores")

public void pruebaGET2() throws Exception {
	this.mockMvc.perform(  get("/api/administradores/") )
	.andDo(print() )
	.andExpect(status().isOk() );
	//.andExpect(content().string(containsString("Horus")));
}//pruebaGet administradores

@Test
@DisplayName("Prueba del método delete en Admins")

public void pruebaDELETE2() throws Exception{
	this.mockMvc.perform(  delete("/api/administradores/2") )
	.andDo(print() )
	.andExpect(status().isOk() );
		
}//Prueba delete publicaciones

@Test
@DisplayName("Prueba el método UPDATE en administradores")

public void pruebaUPDATE2() throws Exception{
	this.mockMvc.perform(  put("/api/administradores/1").queryParam("contrasena", "elyoyo") )
	.andDo(print() )
	.andExpect(status().isOk() )
	.andExpect(content().string(containsString("Horus")));
}//UpdatePublicaciones
}//Class
