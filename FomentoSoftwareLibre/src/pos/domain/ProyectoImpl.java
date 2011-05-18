package pos.domain;

import java.util.Date;


public class ProyectoImpl implements Proyecto {
	
	private String idProyecto;
	private String nombreProyecto;
	private String descripcion;
	private Date fechaInicio;
	private Date fechaFin;
	private Boolean disponibilidad;
	private String numeroMaximoDesarrolladores;
	private String numeroActualDesarrolladores;
	private Aplicacion aplicacion;
	private Integer nivelKarma;
	
	
	
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
	public String getNumeroMaximoDesarrolladores() {
		return numeroMaximoDesarrolladores;
	}
	public void setNumeroMaximoDesarrolladores(String numeroMaximoDesarrolladores) {
		this.numeroMaximoDesarrolladores = numeroMaximoDesarrolladores;
	}
	public String getNumeroActualDesarrolladores() {
		return numeroActualDesarrolladores;
	}
	public void setNumeroActualDesarrolladores(String numeroActualDesarrolladores) {
		this.numeroActualDesarrolladores = numeroActualDesarrolladores;
	}
	public String getIDProyecto() {
		return idProyecto;
	}
	@Override
	public void setIDProyecto(String idProyecto) {
		this.idProyecto = idProyecto;
	}
	public Aplicacion getAplicacion(){
		return aplicacion;
	}
	@Override
	public void setAplicacion(Aplicacion aplicacion) {
		this.aplicacion = aplicacion;
	}
	public void setNivelKarma(Integer nivelKarma){
		this.nivelKarma=nivelKarma;
	}
	public Integer getNivelKarma(){
		return nivelKarma;
	}

	
}
