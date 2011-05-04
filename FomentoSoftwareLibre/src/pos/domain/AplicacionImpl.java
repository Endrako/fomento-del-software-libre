package pos.domain;

import java.util.Date;

public class AplicacionImpl implements Aplicacion {
	private String nombre;
	private String descripcion;
	private Date fechaPublicacion;
	private String URLWeb;
	private Proyecto proyecto;
	private Integer votosAFavor;
	private Integer votosEnContra;
	

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
	public Proyecto getProyecto() {
		return proyecto;
	}

	@Override
	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

	@Override
	public Integer getVotosAFavor() {
		return votosAFavor;
	}

	@Override
	public void anadirVotoAFavor() {
		votosAFavor++;
	}

	@Override
	public Integer getVotosEnContra() {
		return votosEnContra;
	}

	@Override
	public void anadirVotoEnContra() {
		votosEnContra++;
	}

}
