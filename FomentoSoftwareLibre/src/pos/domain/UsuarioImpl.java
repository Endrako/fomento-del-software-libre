package pos.domain;

public class UsuarioImpl implements Usuario{

	/**
	 * 	Atributo que almacena el id
	 */
	private String idUser;
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
	 * 	Atributo que almacena el perfil del usuario
	 */
	private Perfil idPerfil;
	
	/**
	 * Atributo que almacena el karma del usuario
	 */
	private int Karma;
	
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

	public String getIdUser() {
		return idUser;
	}

	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}

	public Perfil getPerfil() {
		return idPerfil;
	}

	public void setPerfil(Perfil perfilUser) {
		this.idPerfil = perfilUser;
	}

	public int getKarma() {
		return Karma;
	}

	public void setKarma(int karma) {
		Karma = karma;
	}
	
	
	
}
