package com.petbook.backendPetbook.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "administradores")
public class Administradores {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "id", unique = true, nullable = false)
		private Long id;	
		@Column(nullable = false)
		private String nombre;
		@Column(nullable = false)
		private String contrasena;
		
		
		public Administradores() {
			// TODO Auto-generated constructor stub
		}


		public Administradores(Long id, String nombre, String contrasena) {
			super();
			this.id = id;
			this.nombre = nombre;
			this.contrasena = contrasena;
		}


		public String getNombre() {
			return nombre;
		}


		public void setNombre(String nombre) {
			this.nombre = nombre;
		}


		public String getContrasena() {
			return contrasena;
		}


		public void setContrasena(String contrasena) {
			this.contrasena = contrasena;
		}


		public Long getId() {
			return id;
		}
		
	



}
