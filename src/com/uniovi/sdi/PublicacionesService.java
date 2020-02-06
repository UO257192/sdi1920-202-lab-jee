package com.uniovi.sdi;

import java.util.LinkedList;
import java.util.List;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;

public class PublicacionesService {
	public List<Publicacion> getPublicaciones() {
		List<Publicacion> publicaciones = new LinkedList<Publicacion>();
		ObjectContainer db = null;
		try {
			db = Db4oEmbedded.openFile("bdPublicaciones");
			List<Publicacion> respuesta = db.queryByExample(Publicacion.class);
			// NO RETORNAR LA MISMA LISTA DE LA RESPUESTA
			publicaciones.addAll(respuesta);

		} finally {
			db.close();
		}
		return publicaciones;
	}

	public void setNuevaPublicacion(Publicacion nuevaPublicacion) {
		ObjectContainer db = null;
		try {
			db = Db4oEmbedded.openFile("bdPublicaciones");
			db.store(nuevaPublicacion);
		} finally {
			db.close();
		}
	}
}