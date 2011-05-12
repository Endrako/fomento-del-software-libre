package pos.domain;

import java.util.Date;
import java.util.List;

public class AplicacionImpl implements Aplicacion {
	private String IDAplicacion;
	private String nombre;
	private String descripcion;
	private Date fechaPublicacion;
	private String URLWeb;
	private Integer votosAFavor;
	private Integer votosEnContra;
	private List<Tag> tags;
	private String IDProyecto; 
	
	
	public String getIDAplicacion(){
		return IDAplicacion;
	}
	public void setIDAplicacion(String IDAplicacion){
		this.IDAplicacion=IDAplicacion;
	}

	@Override
	public String getNombre() {
		return nombre;
	}

	@Override
	public void setNombre(String nombre) {
		this.nombre = nombre;

	}

	@Override
	public String getDescripcion() {
		return descripcion;
	}

	@Override
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;

	}

	@Override
	public Date getFechaPublicacion() {
		return fechaPublicacion;
	}

	@Override
	public void setFechaPublicacion(Date fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	@Override
	public String getURLWeb() {
		return URLWeb;
	}

	@Override
	public void setURLWeb(String URLWeb) {
		this.URLWeb = URLWeb;
	}

	@Override
	public Integer getVotosAFavor() {
		return votosAFavor;
	}

	@Override
	public void anadirVotoAFavor(Integer votos) {
		votosAFavor = votosAFavor+votos;
	}

	@Override
	public Integer getVotosEnContra() {
		return votosEnContra;
	}

	@Override
	public void anadirVotoEnContra(Integer votos) {
		votosEnContra = votosEnContra+votos;
	}
	
	public void setVotosAFavor(Integer votos){
		this.votosAFavor = votos;
	}
	
	public void setVotosEnContra(Integer votos){
		this.votosEnContra = votos;
	}
	@Override
	public List<Tag> getTags() {
		return tags;
	}
	@Override
	public void setTags(List<Tag> tags) {
		this.tags=tags;
		
	}
	public String getIDProyecto(){
		return this.IDProyecto;
	}
	public void setIDProyecto(String IDProyecto){
		this.IDProyecto=IDProyecto;
	}

}
