package pos.domain;

public class PerfilImpl implements Perfil{

	/**
	 * Atributo que almacena el id del usuario
	 */
	private String idUser;
	
	/**
	 * Atributo que almacena el nombre del usuario
	 */
	private String nombreUsuario;
	
	/**
	 * Atributo que almacena el apellido del usuario
	 */
	private String apellidos;
	
	/**
	 * Atributo que almacena la edad del usuario
	 */
	private Integer edad;
	
	/**
	 * Atributo que almacena el pais del usuario
	 */
	private String idPais;
	
	/**
	 * Atributo que almacena la ciudad del usuario
	 */
	private String idCiudad;
	
	/**
	 * Atributo que almacena la poblacion del usuario
	 */
	private String idPoblacion;
	
	/**
	 * Atributo que almancena el OS del pc
	 */
	private String pcOS;
	
	/**
	 * Atributo que almancena el OS del movil
	 */
	private String movilOS;
	
	/**
	 * Constructor de la clase
	 */
	public PerfilImpl(){
		
	}

	/** METODOS GETTERS AND SETTERS
	 * 
	 */
	public String getIdUser() {
		return idUser;
	}

	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getIdPais() {
		return idPais;
	}

	public void setIdPais(String idPais) {
		this.idPais = idPais;
	}

	public String getIdCiudad() {
		return idCiudad;
	}

	public void setIdCiudad(String idCiudad) {
		this.idCiudad = idCiudad;
	}

	public String getIdPoblacion() {
		return idPoblacion;
	}

	public void setIdPoblacion(String idPoblacion) {
		this.idPoblacion = idPoblacion;
	}

	public String getPcOS() {
		return pcOS;
	}

	public void setPcOS(String pcOS) {
		this.pcOS = pcOS;
	}

	public String getMovilOS() {
		return movilOS;
	}

	public void setMovilOS(String movilOS) {
		this.movilOS = movilOS;
	}
	
}
