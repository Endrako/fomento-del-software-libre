package pos.domain;

import java.util.Date;

public interface Proyecto {
	
	public String getIDProyecto();
	public String getNombreProyecto();
	public String getDescripcionProyecto();
	public Date getFechaInicio();
	public Date getFechaFin();
	public Boolean getDisponibilidad();
	public void setIDProyecto(String idProyecto);
	public void setNombreProyecto(String nombreProyecto);
	public void setDescripcionProyecto(String descripcionProyecto);
	public void setFechaInicio(Date fechaInicio);
	public void setFechaFin(Date fechaFin);
	public void setDisponibilidad(Boolean disponibilidad);
	public Aplicacion getAplicacion();
	public void setAplicacion(Aplicacion aplicacion);

}
