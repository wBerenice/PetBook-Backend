package com.petbook.backendPetbook.models;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity  
@Table (name = "usuario")
public class Usuarios {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column ()
}
