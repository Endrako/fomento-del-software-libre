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

	public String getIdTag() {
		return idTag;
	}

	/* (non-Javadoc)
	 * @see pos.domain.Tag#setIdTag(java.lang.String)
	 */
	public void setIdTag(String idTag) {
		this.idTag = idTag;
	}

	/* (non-Javadoc)
	 * @see pos.domain.Tag#getIdAplicacion()
	 */
	public String getIdAplicacion() {
		return idAplicacion;
	}

	/* (non-Javadoc)
	 * @see pos.domain.Tag#setIdAplicacion(java.lang.String)
	 */
	public void setIdAplicacion(String idAplicacion) {
		this.idAplicacion = idAplicacion;
	}
	
}
