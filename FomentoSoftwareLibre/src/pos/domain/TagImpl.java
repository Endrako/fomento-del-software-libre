package pos.domain;

public class TagImpl implements Tag{

	/**Atributo que almacena el id del tag
	 * 
	 */
	private String idTag;
	
	private String nombre;
	
	
	public TagImpl(){		
	}
	
	public TagImpl(String idTag,String nombre){
		this.idTag = idTag;
		this.nombre = nombre;
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

	//Borrados los métodos que relacionan a un Tag con una Aplicacion
	//MOTIVO: Un Tag no tiene una Aplicacion, si no que una Aplicacion contiene a un Tag
	//o a varios. Esta relacion se establece en la tabla de relacion, a la cual se
	//accede desde el DAO de Aplicacion
	
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	
	public String getNombre(){
		return nombre;
	}
	
}
