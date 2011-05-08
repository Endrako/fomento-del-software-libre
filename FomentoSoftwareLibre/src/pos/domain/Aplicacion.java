package pos.domain;

import java.util.Date;
import java.util.List;

public interface Aplicacion {
	
	//TODO Completar la interface con lo que vaya a ser necesario
	
	// Puede que alguno encuentre errores aquí porque creo que hemos editado 2 a la vez esto...
	
	public Integer getIDAplicacion();
	public void setIDAplicacion(Integer IDAplicacion);
	public String getNombre();
	public void setNombre(String nombre);
	public String getDescripcion();
	public void setDescripcion(String descripcion);
	public Date getFechaPublicacion();
	public void setFechaPublicacion(Date fechaPublicacion);
	public String getURLWeb();
	public void setURLWeb(String URLWeb);
	public Integer getVotosAFavor();
	public void setVotosAFavor(Integer votosAFavor);
	public void anadirVotoAFavor();
	public void anadirVotoAFavor(Integer votos);
	public Integer getVotosEnContra();
	public void setVotosEnContra(Integer votosEnContra);
	public void anadirVotoEnContra();
	public void anadirVotoEnContra(Integer votos);
	public List<Tag> getTags();
	public void setTags(List<Tag> tags);
		public Integer getIDProyecto();
	public void setIDProyecto(Integer idProyecto);

}
