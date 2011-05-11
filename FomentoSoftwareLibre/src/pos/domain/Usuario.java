package pos.domain;

public interface Usuario {

	/**
	 * METODOS GETTERS AND SETTERS
	 * 
	 */
	public String getNombreUsuario();

	public void setNombreUsuario(String idUser);

	public String getEmail();

	public void setEmail(String email);

	public String getContrasena();

	public void setContrasena(String contrasena);
	
	public Perfil getPerfil();
	
	public void setPerfil(Perfil perfil);
	
	public String getIdUser();
	
	public void setIdUser(String idUser);
	
	public int getKarma();
	
	public void setKarma(int karma);

}