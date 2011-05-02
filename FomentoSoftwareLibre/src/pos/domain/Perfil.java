package pos.domain;

public interface Perfil {

	public String getIdUser();

	public void setIdUser(String idUser);

	public String getNombreUsuario();

	public void setNombreUsuario(String nombreUsuario);

	public String getApellidos();

	/* (non-Javadoc)
	 * @see pos.domain.Perfil#setApellidos(java.lang.String)
	 */
	public void setApellidos(String apellidos);

	public Integer getEdad();

	public void setEdad(Integer edad);

	public String getIdPais();

	public void setIdPais(String idPais);

	public String getIdCiudad();

	public void setIdCiudad(String idCiudad);

	public String getIdPoblacion();

	public void setIdPoblacion(String idPoblacion);

	public String getPcOS();

	public void setPcOS(String pcOS);

	public String getMovilOS();

	public void setMovilOS(String movilOS);

}