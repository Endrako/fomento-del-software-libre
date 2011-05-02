package pos.domain;

import java.util.Date;

public interface Comentario {

	/**
	 * GETTERS AND SETTERS
	 * 
	 */
	public abstract String getIdComentario();

	public abstract void setIdComentario(String idComentario);

	public abstract String getDescripcion();

	public abstract void setDescripcion(String descripcion);

	public abstract String getIdUser();

	public abstract void setIdUser(String idUser);

	public abstract String getIdAplicacion();

	public abstract void setIdAplicacion(String idAplicacion);

	public abstract Date getFechaPublicacion();

	public abstract void setFechaPublicacion(Date fechaPublicacion);

}