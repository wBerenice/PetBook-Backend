package com.petbook.backendPetbook.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity 
@Table(name="publicaciones")

public class Publicaciones {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", unique=true, nullable=false)
	private Long id;
	@Column(nullable=false)
private String titulo;
private String descripcion;
private String foto;
private int  likes;

@ManyToOne
@JoinColumn(name = "Id_usuario")
private Usuarios usuario;

public Publicaciones(Long id, String titulo, String descripcion, String foto, int likes, Usuarios usuario) {
	super();
	this.id = id;
	this.titulo = titulo;
	this.descripcion = descripcion;
	this.foto = foto;
	this.likes = likes;
	this.usuario = usuario;
}//Constructor 
public Publicaciones  () {} //constructor sin parámetros
public String getTitulo() {
	return titulo;
}
public void setTitulo(String titulo) {
	this.titulo = titulo;
}
public String getDescripcion() {
	return descripcion;
}
public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}
public String getFoto() {
	return foto;
}
public void setFoto(String foto) {
	this.foto = foto;
}
public int getLikes() {
	return likes;
}
public void setLikes(int likes) {
	this.likes = likes;
}
public Usuarios getUsuario() {
	return usuario;
}
public void setUsuario(Usuarios usuario) {
	this.usuario = usuario;
}
public Long getId() {
	return id;
}
@Override
public String toString() {
	return "Publicaciones [id=" + id + ", titulo=" + titulo + ", descripcion=" + descripcion + ", foto=" + foto
			+ ", likes=" + likes + ", usuario=" + usuario + "]";
}
}//Class Publicaciones
