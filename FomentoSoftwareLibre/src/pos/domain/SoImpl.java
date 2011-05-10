package pos.domain;

public class SoImpl implements SO {

	/**
	 * Atributo que almacena el id del so
	 */
	private int idSO;
	
	/**
	 * Atributo que almacena la descripcion
	 */
	private String descripcion;
	
	/**
	 * Atributo que almacena si es movil o no
	 */
	
	private boolean esOSmovil;
	
	/**
	 * Constructor de la clase
	 */
	public SoImpl(int id, String desc, boolean esmovil){
		idSO = id;
		descripcion = desc;
		esOSmovil = esmovil;
	}

	public int getIdSO() {
		return idSO;
	}

	public void setIdSO(int idSO) {
		this.idSO = idSO;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public boolean isEsOSmovil() {
		return esOSmovil;
	}

	public void setEsOSmovil(boolean esOSmovil) {
		this.esOSmovil = esOSmovil;
	}
	
	/**
	 *  GETTERS AND SETTERS
	 */
	
}
