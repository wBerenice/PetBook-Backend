package com.petbook.backendPetbook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petbook.backendPetbook.models.Administradores;



@Service
public class AdministradoresService {
    private final AdministradoresRepository administradorRepository;
    @Autowired
	public AdministradoresService(AdministradoresRepository administradorRepository) {
		super();
		this.administradorRepository = administradorRepository;
	}//administradoresServices
    
    public List<Administradores> getAllAdministradores(){
    	return administradorRepository.findAll();
    }//getalladministradores
    
    public Administradores getAdministrador(Long id) {
    	return administradorRepository.findById(id).orElseThrow(
    			()-> new IllegalArgumentException("El administrador con el id " + id + "no existe")
    			);
    }//getAdeministrador
    
    public Administradores updateAdministrador(Long id, String nombre, String contrasena) {
    	Administradores tmp = null; 
    	if (administradorRepository.existsById(id)) {
    		tmp = administradorRepository.findById(id).get(); 
    		if (nombre != null) tmp.setNombre(nombre);
    		if (contrasena != null) tmp.setContrasena(contrasena);
    		administradorRepository.save(tmp);
    		
    	}
    	else {System.out.println("El administrador con el id: " + id + "no existe");
    	}
    	return tmp;
    }
}
