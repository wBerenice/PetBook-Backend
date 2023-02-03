package com.petbook.backendPetbook.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity  
@Table (name = "usuarios")
public class Usuarios {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name= "id", unique=true, nullable=false)
	private Long id;
	@Column (nullable =false)
	private String nombre;
	@Column (nullable =false)
	private String correo;
	@Column (nullable =true)
	private String especie;
	@Column (nullable =false)
	private Long telefono;
	@Column (nullable =false)
	private String contrasena;
	
	public Usuarios(Long id, String nombre, String correo, String especie, Long telefono, String contrasena) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.correo = correo;
		this.especie = especie;
		this.telefono = telefono;
		this.contrasena = contrasena;
	}
	public Usuarios () {
		
	}
	public Long getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public Long getTelefono() {
		return telefono;
	}

	public void setTelefono(Long telefono) {
		this.telefono = telefono;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
	
	
	
}
