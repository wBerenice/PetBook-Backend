package com.petbook.backendPetbook.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petbook.backendPetbook.models.Usuarios;

public interface UsuariosRepository extends JpaRepository<Usuarios,Long> {

}
