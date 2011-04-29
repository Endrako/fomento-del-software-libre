package pos.data;

import java.util.Date;

public class Comentario {

	/**
	 * Atributo que almancena el id del comentario
	 */
	private String idComentario;
	
	/**
	 * Atributo que almacena la descripcion del comentario
	 */
	private String descripcion;
	
	/**
	 * Atributo que almacena el id del usuario
	 */
	private String idUser;
	
	/**
	 * Atributo que almancena el id de la Aplicacion
	 */
	private String idAplicacion;
	
	/**
	 * Atributo que almancena la fecha de publicacion
	 */
	private Date fechaPublicacion;
	
	/**
	 * Constructor de la clase
	 * 
	 */
	public Comentario(){
		
	}

	/**
	 * GETTERS AND SETTERS
	 * 
	 */
	public String getIdComentario() {
		return idComentario;
	}

	public void setIdComentario(String idComentario) {
		this.idComentario = idComentario;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getIdUser() {
		return idUser;
	}

	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}

	public String getIdAplicacion() {
		return idAplicacion;
	}

	public void setIdAplicacion(String idAplicacion) {
		this.idAplicacion = idAplicacion;
	}

	public Date getFechaPublicacion() {
		return fechaPublicacion;
	}

	public void setFechaPublicacion(Date fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}
	
	
}
