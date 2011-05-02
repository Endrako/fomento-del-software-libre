package pos.data;

import java.util.Date;

public class UsuarioBean {

	/**
	 *	Atributo que guarda el nombre del usuario
	 */
	private String idUser = "";
	
	/**
	 *  Atributo que guarda el email del usuario
	 */
	private String email = "";
	
	/**
	 * Atributo que guarda la contrase�a del usuario
	 */
	private String contrasena = "";
	
	/**
	 * Atributo que guarda la fecha de registro del usuario
	 */
	private Date fechaRegistro = null ;
	
	/**
	 * Atributo que guarda el id del perfil
	 */
	private String idPerfil = null ;

	/**
	 * Atributo que guarda el id del proyecto suscrito
	 */
	private String idProyecto;
	
	/**
	 * CONSTRUCTOR DE LA CLASE
	 */
	public UsuarioBean(){
		
	}
	
	/**
	 * METODOS GETTERS AND SETTERS
	 * 
	 */
	public String getNombreUsuario() {
		return idUser;
	}

	public void setNombreUsuario(String idUser) {
		this.idUser = idUser;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getIdPerfil() {
		return idPerfil;
	}

	public void setIdPerfil(String idPerfil) {
		this.idPerfil = idPerfil;
	}

	public String getIdProyecto() {
		return idProyecto;
	}

	public void setIdProyecto(String idProyecto) {
		this.idProyecto = idProyecto;
	}
	
	

}
