package com.petbook.backendPetbook.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petbook.backendPetbook.models.Publicaciones;

@Service
public class PublicacionesService {
private final PublicacionesRepository publicacionesRepository;
@Autowired
public PublicacionesService(PublicacionesRepository publicacionesRepository) {
	this.publicacionesRepository = publicacionesRepository;
}//constructor
public List<Publicaciones> getAllPublicaciones (){
	return publicacionesRepository.findAll();
}//GetTodas las publicaciones
public Publicaciones getPublicacion(Long id) {
	return publicacionesRepository.findById(id).orElseThrow(
			()-> new IllegalArgumentException("La publicación con el id " + id + " no existe."));
}//GetPublicacion
public Publicaciones deletePublicacion (Long id) {
	Publicaciones tmp = null;
	if(	publicacionesRepository.existsById(id)) {
		tmp=publicacionesRepository.findById(id).get();
		publicacionesRepository.deleteById(id);
	}//if
	return tmp;	
	}//deletePublicaciones
public Publicaciones addPublicacion(Publicaciones  publicacion) {
return 	publicacionesRepository.save(publicacion);
	
}//PostPublicaciones

public Publicaciones updatePublicacion(Long id, String titulo, String descripcion, String foto, Integer likes, String usuario) {
	Publicaciones tmp=null;
if(	publicacionesRepository.existsById(id)) {
	tmp=publicacionesRepository.findById(id).get();
	if(titulo!=null) tmp.setTitulo(titulo);
	if(descripcion!=null) tmp.setDescripcion(descripcion);
	if(foto!=null) tmp.setFoto(foto);
	if(likes!=null) tmp.setLikes(likes);
	if(usuario!=null) tmp.setUsuario(usuario);
	publicacionesRepository.save(tmp);
	
}//if
else {
	System.out.println("Update - La publicación con el id " + id + "no existe");
}
return tmp;
}//updatePublicaciones


}//Service Class