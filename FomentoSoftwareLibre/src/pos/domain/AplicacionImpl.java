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
	private Proyecto proyecto; // Aqui trabajamos on objetos, no con IDs
	private Usuario usuarioCreador;

	// A ver tios, que estoy empezando a cabrearme. HACED UPDATE CO�O
	// Y si me borrais el constructor, ponedme POR QUE lo habeis borrado,
	// hostia,
	// que me cascan las cosas porque parece que pasais del tema, joder
	// Que luego se me echa en cara a mi que no informo

	public AplicacionImpl(String IDAplicacion, String nombre,
			String descripcion, Date fechaPublicacion, String URLWeb,
			Integer votosAFavor, Integer votosEnContra, List<Tag> listaTags,
			Proyecto proyecto, Usuario usuarioCreador) {
		this.IDAplicacion = IDAplicacion;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fechaPublicacion = fechaPublicacion;
		this.URLWeb = URLWeb;
		this.votosAFavor = votosAFavor;
		this.votosEnContra = votosEnContra;
		this.tags = listaTags;
		this.proyecto = proyecto;
		this.usuarioCreador = usuarioCreador;
	}

	public AplicacionImpl() {

	}

	public String getIDAplicacion() {
		return IDAplicacion;
	}

	public void setIDAplicacion(String IDAplicacion) {
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

	@Override
	public void anadirVotoAFavor(Integer votos) {
		votosAFavor = votosAFavor + votos;
	}

	@Override
	public Integer getVotosEnContra() {
		return votosEnContra;
	}

	@Override
	public void anadirVotoEnContra(Integer votos) {
		votosEnContra = votosEnContra + votos;
	}

	public void setVotosAFavor(Integer votos) {
		this.votosAFavor = votos;
	}

	public void setVotosEnContra(Integer votos) {
		this.votosEnContra = votos;
	}

	@Override
	public List<Tag> getTags() {
		return tags;
	}

	@Override
	public void setTags(List<Tag> tags) {
		this.tags = tags;

	}

	public Proyecto getProyecto() {
		return this.proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

	public boolean equals(Object o) {
		boolean res = false;
		if (o instanceof Aplicacion) {
			Aplicacion ap1 = (Aplicacion) o;
			if (ap1.getNombre().equals(this.getNombre())
					&& (ap1.getIDAplicacion().equals(this.getIDAplicacion()))) {
				res = true;
			}
		}
		return res;
	}

	@Override
	public Usuario getUsuarioCreador() {
		return usuarioCreador;
	}

	@Override
	public void setUsuarioCreador(Usuario usuario) {
		this.usuarioCreador = usuario;
	}
	
	public String toString(){
		String s= "";
		s += "Nombre Aplicación: "+ this.nombre + "\nDescripción: "+ this.descripcion;
		
		return s;
	}

}
