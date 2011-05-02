package pos.domain;

import java.util.Date;

public interface Usuario {
	
	public String getNombreUsuario();
	public void setNombreUsuario(String idUser);
	public String getEmail();
	public void setEmail(String email);
	public String getContrasena();
	public void setContrasena(String contrasena);
	public Date getFechaRegistro();
	public void setFechaRegistro(Date fechaRegistro);
	public String getIdPerfil();
	public void setIdPerfil(String idPerfil);
	public String getIdProyecto();
	public void setIdProyecto(String idProyecto);
}
