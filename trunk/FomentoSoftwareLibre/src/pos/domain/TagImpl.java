package pos.domain;

public class TagImpl implements Tag{

	/**Atributo que almacena el id del tag
	 * 
	 */
	private String idTag;
	
	/**
	 * Atributo que almacena el id de la aplicacion.
	 */
	private String idAplicacion;
	
	/**
	 * Constructor de la clase
	 */
	public TagImpl(){
		
	}

	/**
	 * GETTERS AND SETTERS
	 */
	public String getIdTag() {
		return idTag;
	}

	public void setIdTag(String idTag) {
		this.idTag = idTag;
	}

	public String getIdAplicacion() {
		return idAplicacion;
	}

	public void setIdAplicacion(String idAplicacion) {
		this.idAplicacion = idAplicacion;
	}
	
}