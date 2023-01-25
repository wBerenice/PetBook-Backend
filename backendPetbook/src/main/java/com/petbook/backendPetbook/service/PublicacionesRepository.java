package com.petbook.backendPetbook.service;
import org.springframework.data.jpa.repository.JpaRepository;

import com.petbook.backendPetbook.models.Publicaciones;
public interface PublicacionesRepository extends JpaRepository<Publicaciones, Long> {

}
