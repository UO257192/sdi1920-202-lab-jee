package com.uniovi.sdi;

public class Publicacion {
	private String nombre;
	private String comentario;

	public Publicacion() {
	}

	public Publicacion(String nombre, String comentario) {
		super();
		this.nombre = nombre;
		this.comentario = comentario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

}
