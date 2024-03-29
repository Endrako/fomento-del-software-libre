package pos.domain;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import pos.data.JDBCProyectoDAO;
import pos.data.JDBCUsuarioDAO;

public class ProyectoStore {

	private List<Proyecto> proyectos;
	private static ProyectoStore proyectoStore;

	public static synchronized ProyectoStore getInstance() {
		proyectoStore = new ProyectoStore();
		
		return proyectoStore;
	}

	public ProyectoStore() {
		proyectos = (new JDBCProyectoDAO()).obtenerTodosProyectos();
	}

	public List<Proyecto> obtenerTodosProyectos() {

		return (new JDBCProyectoDAO()).obtenerTodosProyectos();
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

		/*if (user.getKarma() < 0) {
			throw new IllegalArgumentException(
					"El nivel de karma no puede ser nulo ni menor que 0");
		}*/

		for (Proyecto p : listaAux) {

			if (user.getKarma() >= p.getNivelKarma()
					|| p.getUsuarioCreador().getNombreUsuario()
							.equals(user.getNombreUsuario())) {
				listaProyectos.add(p);
			} // si no hay proyectos abiertos suficientes
			/*else {
				throw new IllegalArgumentException(
						"No existe ningún proyecto disponible para el karma de este usuario, ni es el creador");
			}*/
		}
		return listaProyectos;

	}

	/*
	 * Obtengo todos los proyectos que ha creado el usuario
	 */
	public List<Proyecto> obtenerProyectosCreadosPorUsuario(Usuario u) {
		return new JDBCProyectoDAO().obtenerProyectosCreadosPorUsuario(u);
	}

	public boolean crearProyecto(Proyecto p, Usuario u) {
		boolean res;
		Boolean b = new JDBCProyectoDAO().existeProyecto(p.getNombreProyecto());
		if (b) {
			res = false;
			throw new IllegalArgumentException(
					"Ya existe un proyecto con este nombre");
		} else {
			if (u.getKarma() >= 200) { // Puede crear proyecto si nivel karma
										// >=200
				Proyecto pres = new JDBCProyectoDAO().crearProyecto(p, u);
				new JDBCProyectoDAO().asociarProyectoAUsuario(u, pres);
				res = true;
			} else {
				res = false;
				/*throw new IllegalArgumentException(
						"Karma inferior al requerido para crear proyecto");*/
			}
		}
		return res;
	}

	public boolean unirUsuarioAProyecto(Proyecto p, Usuario u) {
		boolean res = false;
		Boolean b = new JDBCProyectoDAO().existeTuplaUsuarioProyecto(p, u);

		if (!b) {// si no está ya asociado
			if (u.getKarma() >= p.getNivelKarma()) {
				// y su nivel de karma es igual o superior al requerido se une
				new JDBCProyectoDAO().asociarProyectoAUsuario(u, p);
				// new JDBCUsuarioDAO().actualizaKarmaUsuario(u, 20);
				res = true;
			} else {
				res = false;
				throw new IllegalArgumentException(
						"El karma del usuario es insuficiente");
			}
		} else {
			res = false;
			throw new IllegalArgumentException(
					"El usuario ya está en este proyecto");
		}
		return res;
	}

	public boolean existeUsuarioEnProyecto(Proyecto p, Usuario u) {
		return new JDBCProyectoDAO().existeTuplaUsuarioProyecto(p, u);
	}

	public boolean borrarUsuarioDeProyecto(Proyecto p, Usuario u) {
		boolean res=false;
		Boolean b = new JDBCProyectoDAO().existeTuplaUsuarioProyecto(p, u);
		if (b) {
			new JDBCProyectoDAO().borrarUnUsuarioDeProyecto(p, u);
			// new JDBCUsuarioDAO().actualizaKarmaUsuario(u, -40);
			res=true;
		} else {
		/*	throw new IllegalArgumentException(
					"El usuario no está vinculado a este proyecto");*/
		}
		return res;
	}

	public void borrarProyecto(Proyecto p) {
		new JDBCProyectoDAO().borrarProyecto(p);
		new JDBCProyectoDAO().borrarAsociacionTodosUsuariosConProyecto(p);

	}

	public List<String> obtenerUsuariosDeProyecto(Proyecto p) {
		List<Usuario> listaUsuarios = new JDBCProyectoDAO()
				.obtenerUsuariosDeProyecto(p);
		List<String> listaNombres = new ArrayList<String>();
		for (Usuario u : listaUsuarios) {
			listaNombres.add(u.getNombreUsuario());
		}
		return listaNombres;
	}

}
