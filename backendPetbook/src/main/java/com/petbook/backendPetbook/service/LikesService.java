package com.petbook.backendPetbook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petbook.backendPetbook.models.Likes;

@Service
public class LikesService {
	private final LikesRepository likesRepository;
	@Autowired
	public LikesService(LikesRepository likesRepository) {
		super();
		this.likesRepository = likesRepository;
	}//constructor
	
	public List<Likes> getAllLikes(){
		return likesRepository.findAll();
	}//getAllLikes
	
	public Likes getLikes (Long id) {
		return likesRepository.findById(id).orElseThrow(
				()-> new IllegalArgumentException("Los likes con el id: " + id + "no existen.")				
				);
	}//getLike
	
	public Likes deleteLikes (Long id) {
		Likes tmp = null;
		if (likesRepository.existsById(id)) {
			tmp= likesRepository.findById(id).get();
			likesRepository.deleteById(id);
		}//if 
		return tmp;
	}//deleteLike
	
	public Likes addLikes(Likes like) {
		return likesRepository.save(like);
	}//addLike
	
	public Likes updateLikes (Long id, Long id_usuario, Long id_publicaciones) {
		Likes tmp = null;
		if (likesRepository.existsById(id)) {
			tmp = likesRepository.findById(id).get();
			if (id_usuario != null) tmp.setId_usuario(id_usuario);
			if (id_publicaciones != null) tmp.setId_publicaciones(id_publicaciones);
			likesRepository.save(tmp);
		} else {
			System.out.println("Update- Los likes con el id: " + id + "no existe");
		}//if
		return tmp;
	}//updateLikes
	
	
	
	
}// class likesService
