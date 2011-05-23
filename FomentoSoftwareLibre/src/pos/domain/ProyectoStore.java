package pos.domain;

import java.util.LinkedList;
import java.util.List;

import pos.data.JDBCProyectoDAO;

public class ProyectoStore {

	private List<Proyecto> proyectos;
	private static ProyectoStore proyectoStore;

	public static synchronized ProyectoStore getInstance() {
		if (proyectoStore == null) {
			proyectoStore = new ProyectoStore();
		}
		return proyectoStore;
	}

	public ProyectoStore() {
		proyectos = new JDBCProyectoDAO().obtenerTodosProyectos();
	}

	public List<Proyecto> obtenerTodosProyectos() {

		return proyectos;
	}

	public Proyecto obtenerProyectoPorID(String IDProyecto) {

		return new JDBCProyectoDAO().obtenerProyectoPorID(IDProyecto);
	}
	

	public Aplicacion obtenerAplicacionDeProyecto(Proyecto p) {

		return new JDBCProyectoDAO().obtenerAplicacionDeProyecto(p);
	}

	public List<Proyecto> obtenerProyectosAbiertosPorKarma(Usuario user) {

		List<Proyecto> listaProyectos = new LinkedList<Proyecto>();
		List<Proyecto> listaAux = new JDBCProyectoDAO()
				.obtenerProyectosAbiertos();

		if (user.getKarma() < 0) {
			throw new IllegalArgumentException(
					"El nivel de karma no puede ser nulo ni menor que 0");
		}

		for (Proyecto p : listaAux) {
			if (p.getNivelKarma() >= user.getKarma()) {
				listaProyectos.add(p);
			}
		}
		return listaProyectos;

	}
	
	public List<Proyecto> obtenerProyectoPorUsuario(Usuario u){
		return new JDBCProyectoDAO().obtenerProyectosPorUsuario(u);
	}

	public void crearProyecto(Proyecto p, Usuario u) {
		if (obtenerProyectoPorID(p.getIDProyecto()) != null) {
			throw new IllegalArgumentException(
					"Ya existe un proyecto con este nombre");
		} else {
			new JDBCProyectoDAO().crearProyecto(p, u);
			new JDBCProyectoDAO().asociarProyectoAUsuario(u, p);
		}
	}

	public void unirUsuarioAProyecto(Proyecto p, Usuario u) {
		Boolean b = new JDBCProyectoDAO().existeTuplaUsuarioProyecto(p, u);
		if (!b) // si no está ya asociado se une.
			new JDBCProyectoDAO().asociarProyectoAUsuario(u, p);
		else
			throw new IllegalArgumentException("El usuario ya existe");
	}

	public void borrarUsuarioDeProyecto(Proyecto p, Usuario u) {
		Boolean b = new JDBCProyectoDAO().existeTuplaUsuarioProyecto(p, u);
		if (b)
			new JDBCProyectoDAO().borrarUnUsuarioDeProyecto(p, u);
		else {
			throw new IllegalArgumentException("El usuario no existe");
		}
	}
	
	public void borrarProyecto(Proyecto p) {
		new JDBCProyectoDAO().borrarProyecto(p);
		new JDBCProyectoDAO().borrarAsociacionTodosUsuariosConProyecto(p);

	}

}
