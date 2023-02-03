package com.petbook.backendPetbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petbook.backendPetbook.models.Usuarios;
import com.petbook.backendPetbook.service.UsuarioService;

@RestController
@RequestMapping(path="/api/login/")
public class LoginController {
	private final UsuarioService service;
	@Autowired
	public LoginController(UsuarioService service) {
		super();
		this.service = service;
	}//constructor
	
	@PostMapping
	public boolean validarUsuario(@RequestBody Usuarios usuario) {
		return service.validarUsuario(usuario);
	}
	
}
