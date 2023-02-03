package com.petbook.backendPetbook.service;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.petbook.backendPetbook.models.Usuarios;

public interface UsuarioRepository extends JpaRepository<Usuarios, Long>{
	@Query("SELECT u FROM Usuario u WHERE u.correo=?1") //JPQL JPA Query Languaje
	Optional<Usuarios> findByeEmail(String email);

}
