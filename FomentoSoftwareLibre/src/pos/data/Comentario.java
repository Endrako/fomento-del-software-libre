package pos.data;

import java.util.Date;

public class Comentario implements IComentario {

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

	/* (non-Javadoc)
	 * @see pos.data.IComentario#getIdComentario()
	 */
	@Override
	public String getIdComentario() {
		return idComentario;
	}

	/* (non-Javadoc)
	 * @see pos.data.IComentario#setIdComentario(java.lang.String)
	 */
	@Override
	public void setIdComentario(String idComentario) {
		this.idComentario = idComentario;
	}

	/* (non-Javadoc)
	 * @see pos.data.IComentario#getDescripcion()
	 */
	@Override
	public String getDescripcion() {
		return descripcion;
	}

	/* (non-Javadoc)
	 * @see pos.data.IComentario#setDescripcion(java.lang.String)
	 */
	@Override
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/* (non-Javadoc)
	 * @see pos.data.IComentario#getIdUser()
	 */
	@Override
	public String getIdUser() {
		return idUser;
	}

	/* (non-Javadoc)
	 * @see pos.data.IComentario#setIdUser(java.lang.String)
	 */
	@Override
	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}

	/* (non-Javadoc)
	 * @see pos.data.IComentario#getIdAplicacion()
	 */
	@Override
	public String getIdAplicacion() {
		return idAplicacion;
	}

	/* (non-Javadoc)
	 * @see pos.data.IComentario#setIdAplicacion(java.lang.String)
	 */
	@Override
	public void setIdAplicacion(String idAplicacion) {
		this.idAplicacion = idAplicacion;
	}

	/* (non-Javadoc)
	 * @see pos.data.IComentario#getFechaPublicacion()
	 */
	@Override
	public Date getFechaPublicacion() {
		return fechaPublicacion;
	}

	/* (non-Javadoc)
	 * @see pos.data.IComentario#setFechaPublicacion(java.util.Date)
	 */
	@Override
	public void setFechaPublicacion(Date fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}
	
	
}
