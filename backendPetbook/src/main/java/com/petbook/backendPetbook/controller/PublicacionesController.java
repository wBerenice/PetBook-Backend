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

import com.petbook.backendPetbook.models.Publicaciones;
import com.petbook.backendPetbook.service.PublicacionesService;

@RestController
@RequestMapping (path = "/api/publicaciones/")
public class PublicacionesController {
	private final PublicacionesService publicacionesService;
	@Autowired
	public PublicacionesController(PublicacionesService publicacionesService) {
		super();
		this.publicacionesService = publicacionesService;
	}//Constructor
	@GetMapping					//http://localhost:8080/api/publicaciones/
	public List<Publicaciones> getAllPublicaciones(){
		return publicacionesService.getAllPublicaciones();
	}//getAllPublicaciones
	
	@GetMapping(path="{publiId}") //http://localhost:8080/api/publicaciones/1
	public Publicaciones getPublicaciones(@PathVariable("publiId") Long id ) {
		return publicacionesService.getPublicacion(id);
	}// Get id
	
	@DeleteMapping(path="{publiId}") //http://localhost:8080/api/publicaciones/1
	public Publicaciones deletePublicaciones(@PathVariable ("publiId") Long id) {
		return publicacionesService.deletePublicacion(id);
	}//deltePublicacion
	@PostMapping
	public Publicaciones addPublicacion(@RequestBody Publicaciones publicacion) {
		return publicacionesService.addPublicacion(publicacion);}//post
	

	@PutMapping (path="{publiId}")   //http://localhost:8080/api/publicaciones/1
	public Publicaciones updatePublicacion(@PathVariable("publiId") Long id,
		@RequestParam(required = false) String titulo,
		@RequestParam(required=false) String descripcion,
		@RequestParam(required=false) String foto,
		@RequestParam(required=false) Long id_usuario){
	return publicacionesService.updatePublicacion(id, titulo, descripcion, foto, id_usuario);
	}//put
}//publicaciones controller
		
		
		
		
		
		





	

