package com.petbook.backendPetbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.petbook.backendPetbook.models.Usuarios;
import com.petbook.backendPetbook.service.UsuarioService;

@RestController
@RequestMapping(path="/api/usuarios/")
public class UsuarioController {
private final UsuarioService usuarioService;
	
	@Autowired
  public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}//constructor
	
	@GetMapping//http://localhost:8080/api/productos/
	public List<Usuarios> getAllProductos(){
		return usuarioService.getAllUsuarios();
	}//getAllProductos
	
	@GetMapping(path="{prodId}")//http://localhost:8080/api/productos/1
	public Usuarios getUsuarios(@PathVariable("prodId")Long id){
		return usuarioService.getUsuario(id);
	}//getProducto
	@DeleteMapping(path="{prodId}")//http://localhost:8080/api/productos/1
	public Usuarios deleteUsuario(@PathVariable("prodId")Long id){
		return usuarioService.deleteUsuarios(id);
	}//deleteProducto
	 @PostMapping 
	 public Usuarios addUsuario(@RequestBody Usuarios usuario) {
		 return usuarioService.addUsuarios(usuario);
	 }//addProducto
	 
	@PutMapping (path="{prodId}")//http://localhost:8080/api/productos/1
	public Usuarios updateUsuarios(@PathVariable("prodId")Long id,
    @RequestParam(required= false) String nombre,
	@RequestParam(required = false) String correo,
	@RequestParam(required = false) String especie,
	@RequestParam(required = false) Long telefono,
	@RequestParam(required = false) String contrasena) {
		return usuarioService.updateUsuario(id,nombre,correo,especie,telefono,contrasena);
	}//updateProducto

}//c

