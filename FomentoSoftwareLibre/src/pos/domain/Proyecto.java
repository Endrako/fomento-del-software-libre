package pos.domain;

import java.util.Date;

public interface Proyecto {
	
	public String getIDProyecto();
	public String getNombreProyecto();
	public String getDescripcionProyecto();
	public Date getFechaInicio();
	public Date getFechaFin();
	public Integer getDisponibilidad();
	public void setIDProyecto(String idProyecto);
	public void setNombreProyecto(String nombreProyecto);
	public void setDescripcionProyecto(String descripcionProyecto);
	public void setFechaInicio(Date fechaInicio);
	public void setFechaFin(Date fechaFin);
	public void setDisponibilidad(Integer disponibilidad);
	public Aplicacion getAplicacion();
	public void setAplicacion(Aplicacion aplicacion);
	public Integer getNivelKarma();
	public void setNivelKarma(Integer nivelKarma);
	
	// Se añade atributo usuario
	
	public Usuario getUsuarioCreador();
	public void setUsuarioCreador(Usuario u);

}
