package pos.domain;

import java.util.Date;

public interface Aplicacion {
	
	//TODO Completar la interface con lo que vaya a ser necesario
	public String getNombre();
	public void setNombre(String nombre);
	public String getDescripcion();
	public void setDescripcion(String descripcion);
	public Date getFechaPublicacion();
	public void setFechaPublicacion(Date fechaPublicacion);
	public String getURLWeb();
	public void setURLWeb(String URLWeb);
	public Proyecto getProyecto();
	public void setProyecto(Proyecto proyecto);
	public Integer getVotosAFavor();
	public void añadirVotoAFavor();
	public Integer getVotosEnContra();
	public void añadirVotoEnContra();

}
