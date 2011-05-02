package pos.domain;

import java.util.Date;

public class UsuarioImpl implements Usuario{

	/**
	 *	Atributo que guarda el nombre del usuario
	 */
	private String nombreUsuario = null;
	
	/**
	 *  Atributo que guarda el email del usuario
	 */
	private String email = "";
	
	/**
	 * Atributo que guarda la contrase�a del usuario
	 */
	private String contrasena = "";
	
	/**
	 * CONSTRUCTOR DE LA CLASE
	 */
	public UsuarioImpl(){
		
	}
	
	/**
	 * METODOS GETTERS AND SETTERS
	 * 
	 */
	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String idUser) {
		this.nombreUsuario = idUser;
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
}
