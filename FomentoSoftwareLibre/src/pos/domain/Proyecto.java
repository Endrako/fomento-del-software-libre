package pos.domain;

import java.util.Date;

public interface Proyecto {
	
	public Integer getIDProyecto();
	public String getNombreProyecto();
	public String getDescripcionProyecto();
	public Date getFechaInicio();
	public Date getFechaFin();
	public Boolean getDisponibilidad();
	public void setIDProyecto(Integer idProyecto);
	public void setNombreProyecto(String nombreProyecto);
	public void setDescripcionProyecto(String descripcionProyecto);
	public void setFechaInicio(Date fechaInicio);
	public void setFechaFin(Date fechaFin);
	public void setDisponibilidad(Boolean disponibilidad);

}