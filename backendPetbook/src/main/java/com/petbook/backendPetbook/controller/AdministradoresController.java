package com.petbook.backendPetbook.controller;


	import java.util.List;

	import com.petbook.backendPetbook.models.Administradores;
	import com.petbook.backendPetbook.service.AdministradoresService; //en creación
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


	@RestController
	@RequestMapping(path = "api/administradores/")  //http://localhost:8080/api/administradores/
	public class AdministradoresController {
		
		private final AdministradoresService administradoresService;//constante
		
		@Autowired
		public AdministradoresController(AdministradoresService administradoresService) {
			super();
			this.administradoresService = administradoresService;
		}//constructor
		
		@GetMapping			//http://localhost:8080/api/administradores/
		public List<Administradores> getAllAdministradores(){
			return administradoresService.getAllAdministradores();
		}//getAllAdministradores
		
		@GetMapping(path = "{prodId}")  //http://localhost:8080/api/administradores/1
		public Administradores getAdministrador(@PathVariable("prodId") Long id) {
			return administradoresService.getAdministrador(id);
		}//getProducto - ID
		
		@DeleteMapping(path = "{prodId}")  //http://localhost:8080/api/administradores/1
		public Administradores deleteAdministrador(@PathVariable("prodId") Long id) {
			return administradoresService.deleteAdministrador(id);
		}//deleteProducto
		
		@PostMapping
		public Administradores addAdministrador(@RequestBody Administradores administrador) {
			return administradoresService.addAdministrador(administrador);
		}//addMapping
		
		@PutMapping (path = "{prodId}")  //http://localhost:8080/api/administradores/1
		public Administradores updateAdministrador(@PathVariable("prodId") Long id,
			@RequestParam(required = false) String nombre,
			@RequestParam(required = false) String contrasena) {
			return administradoresService.updateAdministrador(id, nombre, contrasena);
		}//PutMapping
			
		
	}//class AdministradoresController

