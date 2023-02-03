package com.petbook.backendPetbook.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petbook.backendPetbook.models.Usuarios;

@Service
public class UsuarioService {
	private final UsuarioRepository usuarioRepository;
     @Autowired
	public UsuarioService(UsuarioRepository usuarioRepository) {
     this.usuarioRepository = usuarioRepository;
	}// constructor
     public List<Usuarios> getAllUsuarios(){
    	 return usuarioRepository.findAll();
     }//getAllUsuario
     public Usuarios getUsuario(Long id){
     	return usuarioRepository.findById(id).orElseThrow(
     			()-> new IllegalArgumentException ("El Usuario  con el id " + id + " no existe.")
     			);
     			
     }//getUsuario
     public Usuarios deleteUsuarios(Long id) {
    	 Usuarios tmp = null;
    	 if(usuarioRepository.existsById(id)) {
    		 tmp = usuarioRepository.findById(id).get();
    		 usuarioRepository.deleteById(id);
    	 }//if
    	 return tmp;
     }
     //deleteusuario
     public Usuarios addUsuarios(Usuarios usuario) {
    	 return usuarioRepository.save(usuario);
     }//addUsuarios
     
     public Usuarios updateUsuario(Long id, String nombre, String correo, String especie, Long telefono, String contrasena) {
     	Usuarios tmp=null;
     	if(usuarioRepository.existsById(id)) {
     		tmp = usuarioRepository.findById(id).get();
     		if(nombre !=null)tmp.setNombre(nombre);
     		if(correo !=null)tmp.setCorreo(correo);
     		if(especie !=null)tmp.setEspecie(especie);
     		if(telefono !=null)tmp.setTelefono(telefono);
     		if(contrasena !=null)tmp.setContrasena(contrasena);
     		usuarioRepository.save(tmp);
     	}else {
     			
     		System.out.println(" Update-El Usuario con el id " + id + " no existe. ");
     	}//else
     	return tmp;
     	
     }//updateProducto
     
     public boolean validarUsuario(Usuarios usuario) {
    	 Optional<Usuarios> userByEmail =  usuarioRepository.findByeEmail(usuario.getCorreo());
    	 if(userByEmail.isPresent()) {
    		 Usuarios u = userByEmail.get();
    		 if(u.getContrasena().equals(usuario.getContrasena())) {
    			 return true;
    		 }
    	 }
    	 return false;
     }
    	 
     

}
