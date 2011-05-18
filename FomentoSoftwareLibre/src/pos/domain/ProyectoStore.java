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

	public void crearProyecto(Usuario u,Proyecto p) {
		if(obtenerProyectoPorID(p)!=null){
			throw new IllegalArgumentException("Ya existe un proyecto con este nombre");
		} else{
			new JDBCProyectoDAO().crearProyecto(p);
			new JDBCProyectoDAO().asociarProyectoAUsuario(u, p);
		}
		

	}

	public Proyecto obtenerProyectoPorID(Proyecto p) {

		return new JDBCProyectoDAO().obtenerProyectoPorID(p);
	}

	public void borrarProyecto(Proyecto p) {
		new JDBCProyectoDAO().borrarProyecto(p);
		new JDBCProyectoDAO().borrarAsociacionUsuariosConProyecto(p);

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

	public void unirUsuarioAProyecto(Usuario u, Proyecto p) {
		Boolean b = new JDBCProyectoDAO().existeTuplaUsuarioProyecto(u, p);
		if (b)
			new JDBCProyectoDAO().asociarProyectoAUsuario(u, p);
		if (!b)
			throw new IllegalArgumentException("El usuario ya existe");
	}

}
