package pos.domain;

public class PerfilImpl implements Perfil{

	/**
	 * Atributo que almacena el id del usuario
	 */
	private int idPerfil;
	
	/**
	 * Atributo que almacena el nombre del usuario
	 */
	private String nombreReal;
	
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
	private String pais;
	
	/**
	 * Atributo que almacena la poblacion del usuario
	 */
	private String poblacion;
	
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

	public int getIdPerfil() {
		return idPerfil;
	}

	public void setIdPerfil(int idPerfil) {
		this.idPerfil = idPerfil;
	}

	public String getNombreUsuario() {
		return nombreReal;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreReal = nombreUsuario;
	}

	public String getApellidos() {
		return apellidos;
	}

	/* (non-Javadoc)
	 * @see pos.domain.Perfil#setApellidos(java.lang.String)
	 */
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
		return pais;
	}

	public void setIdPais(String idPais) {
		this.pais = idPais;
	}

	public String getIdPoblacion() {
		return poblacion;
	}

	public void setIdPoblacion(String idPoblacion) {
		this.poblacion= idPoblacion;
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
