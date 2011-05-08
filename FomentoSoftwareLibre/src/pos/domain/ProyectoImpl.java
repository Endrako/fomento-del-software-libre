package pos.domain;

import java.util.Date;
import java.util.List;

public class ProyectoImpl implements Proyecto {
	
	private Integer idProyecto;
	private String nombreProyecto;
	private String descripcion;
	private Date fechaInicio;
	private Date fechaFin;
	private Boolean disponibilidad;
	private Integer numeroMaximoDesarrolladores;
	private Integer numeroActualDesarrolladores;
	private List<Aplicacion> listaAplicaciones;
	
	
	
	/*
	 * MÉTODOS GETTERS Y SETTERS
	 */
	
	
	public String getNombreProyecto() {
		return nombreProyecto;
	}
	public void setNombreProyecto(String nombreProyecto) {
		this.nombreProyecto = nombreProyecto;
	}
	public String getDescripcionProyecto() {
		return descripcion;
	}
	public void setDescripcionProyecto(String descripcion) {
		this.descripcion = descripcion;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	public Boolean getDisponibilidad() {
		return disponibilidad;
	}
	public void setDisponibilidad(Boolean disponibilidad) {
		this.disponibilidad = disponibilidad;
	}
	public Integer getNumeroMaximoDesarrolladores() {
		return numeroMaximoDesarrolladores;
	}
	public void setNumeroMaximoDesarrolladores(Integer numeroMaximoDesarrolladores) {
		this.numeroMaximoDesarrolladores = numeroMaximoDesarrolladores;
	}
	public Integer getNumeroActualDesarrolladores() {
		return numeroActualDesarrolladores;
	}
	public void setNumeroActualDesarrolladores(Integer numeroActualDesarrolladores) {
		this.numeroActualDesarrolladores = numeroActualDesarrolladores;
	}
	public Integer getIDProyecto() {
		return idProyecto;
	}
	@Override
	public void setIDProyecto(Integer idProyecto) {
		this.idProyecto = idProyecto;
	}
	public List<Aplicacion> getListaAplicaciones(){
		return listaAplicaciones;
	}
	@Override
	public void setListaAplicaciones(List<Aplicacion> listaAplicaciones) {
		this.listaAplicaciones = listaAplicaciones;
	}

	
}
