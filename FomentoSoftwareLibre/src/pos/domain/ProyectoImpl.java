package pos.domain;

import java.util.Date;


public class ProyectoImpl implements Proyecto {
	
	private String idProyecto;
	private String nombreProyecto;
	private String descripcion;
	private Date fechaInicio;
	private Date fechaFin;
	private Integer disponibilidad;
	private String numeroMaximoDesarrolladores;
	private String numeroActualDesarrolladores;
	private Aplicacion aplicacion;
	private Integer nivelKarma;
	private Usuario usuarioCreador;
	
	
	
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
	public Integer getDisponibilidad() {
		return disponibilidad;
	}
	public void setDisponibilidad(Integer disponibilidad) {
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
	public Usuario getUsuarioCreador(){
		return usuarioCreador;
	}
	public void setUsuarioCreador(Usuario u){
		this.usuarioCreador = u;
	}
	
	public String toString(){
		String s = "";
		s += "Proyecto: " + nombreProyecto + "\n Info: " + descripcion + "\n Karma necesario para unirse al " +
				"proyecto: " + nivelKarma + "\n";
		return s;
	}

	
}
