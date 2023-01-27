package com.petbook.backendPetbook.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="likes")
public class Likes {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id", unique=true, nullable=false)
	private Long id;
	@Column
	private Long id_usuario;
	@Column
	private Long id_publicaciones;
	
	public Likes() {
		// TODO Auto-generated constructor stub
	}

	public Likes(Long id, Long id_usuario, Long id_publicaciones) {
		this.id = id;
		this.id_usuario = id_usuario;
		this.id_publicaciones = id_publicaciones;
	}

	public Long getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
	}

	public Long getId_publicaciones() {
		return id_publicaciones;
	}

	public void setId_publicaciones(Long id_publicaciones) {
		this.id_publicaciones = id_publicaciones;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Likes [id=" + id + ", id_usuario=" + id_usuario + ", id_publicaciones=" + id_publicaciones + "]";
	}
	
	

}
