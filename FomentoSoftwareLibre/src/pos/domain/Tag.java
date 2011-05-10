package pos.domain;

public interface Tag {

	public String getIdTag();

	/* (non-Javadoc)
	 * @see pos.domain.Tag#setIdTag(java.lang.String)
	 */
	public void setIdTag(String idTag);

	//Borrados los métodos que relacionan a un Tag con una Aplicacion
	//MOTIVO: Un Tag no tiene una Aplicacion, si no que una Aplicacion contiene a un Tag
	//o a varios. Esta relacion se establece en la tabla de relacion, a la cual se
	//accede desde el DAO de Aplicacion
	public void setNombre(String nombre);
	
	public String getNombre();

}