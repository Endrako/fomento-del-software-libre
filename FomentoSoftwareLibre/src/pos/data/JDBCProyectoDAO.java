package pos.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import pos.domain.Aplicacion;
import pos.domain.AplicacionImpl;
import pos.domain.Proyecto;
import pos.domain.ProyectoImpl;
import pos.utils.UIDGenerator;

public class JDBCProyectoDAO implements IProyectoDAO {

	private Connection conn;

	public JDBCProyectoDAO() {
		conn = ConnectionManager.getInstance().checkOut();
	}

	@Override
	/*
	 * Método para obtener todos los proyectos de la tabla
	 */
	public List<Proyecto> obtenerTodosProyectos() {
		String sql = "SELECT * FROM proyectos";
		PreparedStatement stmt = null;
		ResultSet result = null;
		List<Proyecto> listaProyectos = null;

		try {
			stmt = conn.prepareStatement(sql);

			result = stmt.executeQuery();
			listaProyectos = new LinkedList<Proyecto>();

			while (result.next()) {
				Proyecto proyecto = new ProyectoImpl();
				proyecto.setIDProyecto(result.getInt("idProyecto"));
				proyecto.setDescripcionProyecto(result.getString("descripcion"));
				proyecto.setFechaFin(result.getDate("fechaFin"));
				proyecto.setFechaInicio(result.getDate("fechaInicio"));
				proyecto.setNombreProyecto(result.getString("nombreProyecto"));
				proyecto.setDisponibilidad(result.getBoolean("disponibilidad"));
				listaProyectos.add(proyecto);

			}

		} catch (SQLException e) {
			System.out.println("Message: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("Error Code: " + e.getErrorCode());
			System.out.println("Cause: " + e.getCause());
		} finally {
			try {
				if (result != null) {
					conn.close();
				}
				if (stmt != null) {
					conn.close();
				}
			} catch (SQLException e) {
			}
		}

		return listaProyectos;
	}

	@Override
	/*
	 * Método para obtener solo los proyectos que están aún abiertos
	 */
	public List<Proyecto> obtenerProyectosAbiertos() {

		String sql = "SELECT * FROM proyectos p WHERE p.disponible = '1'";

		PreparedStatement stmt = null;
		ResultSet result = null;
		List<Proyecto> listaProyectos = null;

		try {
			stmt = conn.prepareStatement(sql);
			result = stmt.executeQuery();

			listaProyectos = new LinkedList<Proyecto>();

			while (result.next()) {
				Proyecto proyecto = new ProyectoImpl();
				proyecto.setIDProyecto(result.getInt("idProyecto"));
				proyecto.setDescripcionProyecto(result.getString("descripcion"));
				proyecto.setFechaFin(result.getDate("fechaFin"));
				proyecto.setFechaInicio(result.getDate("fechaInicio"));
				proyecto.setNombreProyecto(result.getString("nombreProyecto"));
				proyecto.setDisponibilidad(result.getBoolean("disponibilidad"));
				listaProyectos.add(proyecto);

			}

		} catch (SQLException e) {
			System.out.println("Message: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("Error Code: " + e.getErrorCode());
			System.out.println("Cause: " + e.getCause());

		} finally {
			try {
				if (result != null)
					conn.close();

				if (stmt != null)
					conn.close();
			} catch (SQLException e) {
			}
		}

		return listaProyectos;
	}

	@Override
	/*
	 * Método para insertar un nuevo proyecto en la tabla
	 */
	public void insertarProyecto(Proyecto proyecto) {

		PreparedStatement stmt = null;

		Integer oid = UIDGenerator.getInstance().getKey();

		String sql = "INSERT INTO proyecto(IDProyecto,nombre,descripcion,fechaInicio,fechaFin,"
				+ "disponible) VALUES (?,?,?,?,?,?)";

		try {
			stmt = conn.prepareStatement(sql);

			stmt.setInt(1, oid);
			stmt.setString(2, proyecto.getNombreProyecto());
			stmt.setString(3, proyecto.getDescripcionProyecto());
			stmt.setString(4, proyecto.getFechaInicio().toString());
			stmt.setString(5, proyecto.getFechaFin().toString());
			stmt.setString(6, proyecto.getDisponibilidad().toString());

			stmt.executeUpdate();

			stmt.close();

		} catch (SQLException e) {
			System.out.println("Message: " + e.getMessage());
			System.out.println("Error Code: " + e.getErrorCode());
			System.out.println("SQL State: " + e.getSQLState());
			System.out.println("Cause: " + e.getCause());

		} finally {
			try {
				if (stmt != null) {
					conn.close();
				}
			} catch (SQLException e) {

			}
		}

	}

	@Override
	/*
	 * Método para obtener un proyecto concreto por su identificador de
	 * referencia
	 */
	public Proyecto obtenerProyectoPorID(Integer idProyecto) {

		Proyecto p = new ProyectoImpl();

		ResultSet result = null;
		PreparedStatement stmt = null;

		// Consulta para seleccionar el proyecto

		String sql = "SELECT * FROM proyecto p WHERE (p.IDProyecto = ?)";

		try {
			// Ejecución de consulta
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, idProyecto);
			result = stmt.executeQuery();

			// Tratamiento de consulta
			result.next();

			p.setIDProyecto(idProyecto);
			p.setNombreProyecto(result.getString("nombre"));
			p.setDescripcionProyecto(result.getString("descripcion"));
			p.setFechaInicio(result.getDate("fechaInicio"));
			p.setFechaFin(result.getDate("fechaFin"));
			p.setDisponibilidad(result.getBoolean("disponibilidad"));

			// llamo al método creado para obtener la lista de aplicaciones
			// vinculadas al proyecto
			p.setListaAplicaciones(obtenerListaAplicacionesDeProyecto(idProyecto));

		} catch (SQLException e) {
			System.out.println("Message: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("Error Code: " + e.getErrorCode());
			System.out.println("Cause: " + e.getCause());
		} finally {

			try {
				if (stmt != null) {
					conn.close();
				}
				if (result != null) {
					conn.close();
				}

			} catch (Exception e) {

			}
		}

		return p;
	}

	@Override
	/*
	 * Método para eliminar un proyecto. CUANDO SE BORRA UN PROYECTO, LAS APPS
	 * VINCULADAS VAN DETRÁS CON ÉL!!!
	 */
	public void borrarProyecto(Integer idProyecto) {

		PreparedStatement stmt = null;
		List<Aplicacion> listaAplicaciones = obtenerListaAplicacionesDeProyecto(idProyecto);

		for (Aplicacion a : listaAplicaciones) {
			/*
			 * Solución elegante, llamando a método:
			 * 
			 * JDBCAplicacionDAO.borrarAplicacionPorID(a.getIDAplicacion());
			 */

			/*
			 * Solución enrebesada pero factible a mi parecer:
			 */
			String sqlAux = "DELETE FROM aplicaciones WHERE IDAplicacion = ?";
			PreparedStatement stmtAux = null;

			try {
				stmtAux = conn.prepareStatement(sqlAux);
				stmtAux.setInt(1, a.getIDAplicacion());
				stmtAux.executeUpdate();

			} catch (SQLException e) {
				System.out.println("Message: " + e.getMessage());
				System.out.println("SQLState: " + e.getSQLState());
				System.out.println("Error Code: " + e.getErrorCode());
				System.out.println("Cause: " + e.getCause());
			} finally {

				try {
					if (stmt != null) {
						conn.close();
					}
				} catch (Exception e) {

				}
			}

		} // fin del bucle de borrado de aplicaciones de los proyectos

		// Parte anterior es discutible...a partir de aquí es correcto pero solo
		// borra proyectos

		String sql = "DELETE FROM proyectos WHERE (IDProyecto = ?)";

		// Problemática del método: borrar las aplicaciones vinculadas del
		// proyecto a borrar.

		// Si a nivel de BD estuviera conectado en cascada, se borrarían
		// automáticamente las aplicaciones
		// asociadas al proyecto borrado... ¿cómo borrar las aplicaciones? ¿cómo
		// acceder a los métodos
		// de JDBCAplicacionDAO? haciéndolos static es un follón. Comentar con
		// esta gente. Solución tomada arriba de hacer un DELETE por aplicación
		// es repetir código que
		// podría tomarse de JDBCAplicacionDAO.

		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, idProyecto);

			stmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Message: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("Error Code: " + e.getErrorCode());
			System.out.println("Cause: " + e.getCause());
		} finally {

			try {
				if (stmt != null) {
					conn.close();
				}
			} catch (Exception e) {

			}
		}
	}

	@Override
	public List<Aplicacion> obtenerListaAplicacionesDeProyecto(
			Integer idProyecto) {

		List<Aplicacion> listaAplicaciones = new LinkedList<Aplicacion>();

		ResultSet result = null;
		PreparedStatement stmt = null;

		// Consulta para obtener las aplicaciones vinculadas al proyecto

		String sql = "SELECT * FROM aplicaciones a WHERE (a.IDProyecto = ? )";

		try {

			// Ejecución de consulta
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, idProyecto);
			result = stmt.executeQuery();

			// Tratamiento de consulta

			while (result.next()) {
				Aplicacion a = new AplicacionImpl();
				a.setIDAplicacion(result.getInt("IDAplicacion"));
				a.setNombre(result.getString("nombre"));
				a.setDescripcion(result.getString("descripcion"));
				a.setFechaPublicacion(result.getDate("fechaPublicacion"));
				a.setURLWeb(result.getString("URLWeb"));
				a.setVotosAFavor(result.getInt("numeroVotosAFavor"));
				a.setVotosEnContra(result.getInt("numeroVotosEnContra"));
				a.setIDProyecto(idProyecto);
				listaAplicaciones.add(a);
			}

		} catch (SQLException e) {
			System.out.println("Message: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("Error Code: " + e.getErrorCode());
			System.out.println("Cause: " + e.getCause());
		} finally {

			try {
				if (stmt != null) {
					conn.close();
				}
				if (result != null) {
					conn.close();
				}
			} catch (Exception e) {

			}
		}

		return listaAplicaciones;
	}

}
