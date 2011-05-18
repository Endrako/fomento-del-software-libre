package pos.domain;

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

	public void insertarProyecto(Proyecto proyecto) {
		new JDBCProyectoDAO().insertarProyecto(proyecto);

	}

	public Proyecto obtenerProyectoPorID(String idProyecto) {

		return new JDBCProyectoDAO().obtenerProyectoPorID(idProyecto);
	}

	public void borrarProyecto(String idProyecto) {
		new JDBCProyectoDAO().borrarProyecto(idProyecto);

	}

	public Aplicacion obtenerAplicacionDeProyecto(String idProyecto) {

		return new JDBCProyectoDAO().obtenerAplicacionDeProyecto(idProyecto);
	}

	public List<Proyecto> obtenerProyectosAbiertosPorKarma(Usuario user) {

		return new JDBCProyectoDAO().obtenerProyectosAbiertosPorKarma(user);
	}

}
