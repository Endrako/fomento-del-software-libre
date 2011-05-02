package pos.domain;

import java.util.Date;

public interface Comentario {

	public String getIdComentario();

	public void setIdComentario(String idComentario);

	public String getDescripcion();

	public void setDescripcion(String descripcion);

	public String getIdUser();

	public void setIdUser(String idUser);

	public String getIdAplicacion();

	public void setIdAplicacion(String idAplicacion);

	public Date getFechaPublicacion();

	public void setFechaPublicacion(Date fechaPublicacion);

}