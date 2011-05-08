package pos.domain;

import java.util.Date;
import java.util.List;

public class AplicacionImpl implements Aplicacion {
	private Integer IDAplicacion; // cambio a Integer el IDAplicacion
	private String nombre;
	private String descripcion;
	private Date fechaPublicacion;
	private String URLWeb;
	private Integer votosAFavor;
	private Integer votosEnContra;
	private Integer idProyecto;
	private List<Tag> tags;

	public Integer getIDAplicacion() {
		return IDAplicacion;
	}

	public void setIDAplicacion(Integer IDAplicacion) {
		this.IDAplicacion = IDAplicacion;
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

	public void setVotosAFavor(Integer votosAFavor) {
		this.votosAFavor = votosAFavor;
	}

	@Override
	public void anadirVotoAFavor(Integer votos) {
		votosAFavor = votosAFavor + votos;
	}

	@Override
	public Integer getVotosEnContra() {
		return votosEnContra;
	}

	public void setVotosEnContra(Integer votosEnContra) {
		this.votosEnContra = votosEnContra;
	}

	@Override
	public void anadirVotoEnContra(Integer votos) {
		votosEnContra = votosEnContra + votos;
	}

	@Override
	public List<Tag> getTags() {
		return tags;
	}

	@Override
	public void setTags(List<Tag> tags) {
		this.tags = tags;

	}

	@Override
	public Integer getIDProyecto() {
		return this.idProyecto;
	}

	@Override
	public void setIDProyecto(Integer idProyecto) {
		this.idProyecto = idProyecto;
	}

	@Override
	public void anadirVotoAFavor() {
		votosAFavor++;
	}

	@Override
	public void anadirVotoEnContra() {
		votosEnContra++;
	}

}
