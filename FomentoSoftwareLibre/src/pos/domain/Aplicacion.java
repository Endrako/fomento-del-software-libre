package pos.domain;

import java.util.Date;
import java.util.List;

public interface Aplicacion {
	
	//TODO Completar la interface con lo que vaya a ser necesario
	public String getIDAplicacion();
	public void setIDAplicacion(String idProyecto);
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
	public boolean equals(Object o);
	
	public Proyecto getProyecto();
	public void setProyecto(Proyecto proyecto);
	
	public Usuario getUsuarioCreador();
	public void setUsuarioCreador(Usuario usuario);
	

}
