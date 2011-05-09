package pos.domain;

import java.util.Date;
import java.util.List;

public interface Aplicacion {
	
	//TODO Completar la interface con lo que vaya a ser necesario
	public String getIDAplicacion();
	public void setIDAplicacion(String IDAplicacion);
	public String getNombre();
	public void setNombre(String nombre);
	public String getDescripcion();
	public void setDescripcion(String descripcion);
	public Date getFechaPublicacion();
	public void setFechaPublicacion(Date fechaPublicacion);
	public String getURLWeb();
	public void setURLWeb(String URLWeb);
	public Integer getVotosAFavor();
	public void anadirVotoAFavor(Integer votos);
	public void setVotosAFavor(Integer votos);
	public Integer getVotosEnContra();
	public void setVotosEnContra(Integer votos);
	public void anadirVotoEnContra(Integer votos);
	public List<Tag> getTags();
	public void setTags(List<Tag> tags);
	
	// Si una aplicación no tuviera un proyecto, con dejarse a null el atributo valdría?
	public Integer getIDProyecto();
	public void setIDProyecto(Integer IDProyecto);
	

}
