package pos.domain;

public class SoImpl implements SO {

	/**
	 * Atributo que almacena el id del so
	 */
	private String idSO;
	
	/**
	 * Atributo que almacena la descripcion
	 */
	private String descripcion;
	
	/**
	 * Atributo que almacena si es movil o no
	 */
	
	private int esOSmovil;
	
	/**
	 * Constructor de la clase
	 */
	public SoImpl(){

	}

	public String getIdSO() {
		return idSO;
	}

	public void setIdSO(String idSO) {
		this.idSO = idSO;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getEsOSmovil() {
		return esOSmovil;
	}

	public void setEsOSmovil(int esOSmovil) {
		this.esOSmovil = esOSmovil;
	}
	
	/**
	 *  GETTERS AND SETTERS
	 */
	
}
