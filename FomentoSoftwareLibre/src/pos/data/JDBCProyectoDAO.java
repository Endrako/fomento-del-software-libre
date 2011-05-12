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
	IAplicacionDAO adao = new JDBCAplicacionDAO();

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
				proyecto.setIDProyecto(result.getString("idProyecto"));
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
				proyecto.setIDProyecto(result.getString("idProyecto"));
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

		String oid = UIDGenerator.getInstance().getKey();

		String sql = "INSERT INTO proyecto(IDProyecto,nombre,descripcion,fechaInicio,fechaFin,"
				+ "disponible) VALUES (?,?,?,?,?,?)";

		try {
			stmt = conn.prepareStatement(sql);

			stmt.setString(1, oid);
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
	public Proyecto obtenerProyectoPorID(String idProyecto) {

		Proyecto p = new ProyectoImpl();

		ResultSet result = null;
		PreparedStatement stmt = null;

		// Consulta para seleccionar el proyecto

		String sql = "SELECT * FROM proyecto p WHERE (p.IDProyecto = ?)";

		try {
			// Ejecución de consulta
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, idProyecto);
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
			p.setAplicacion(obtenerAplicacionDeProyecto(idProyecto));

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
	public void borrarProyecto(String idProyecto) {

		PreparedStatement stmt = null;
		Aplicacion a = obtenerAplicacionDeProyecto(idProyecto);

		adao.deleteAplication(a);

		// Problemática del método: borrar las aplicaciones vinculadas del
		// proyecto a borrar.

		// Si a nivel de BD estuviera conectado en cascada, se borrarían
		// automáticamente las aplicaciones
		// asociadas al proyecto borrado...

		String sql = "DELETE FROM proyectos WHERE (IDProyecto = ?)";

		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, idProyecto);

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
	public Aplicacion obtenerAplicacionDeProyecto(String idProyecto) {

		Aplicacion a = new AplicacionImpl();

		ResultSet result = null;
		PreparedStatement stmt = null;

		// Consulta para obtener las aplicaciones vinculadas al proyecto

		String sql = "SELECT * FROM aplicaciones a WHERE (a.IDProyecto = ? )";

		try {

			// Ejecución de consulta
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, idProyecto);
			result = stmt.executeQuery();

			// Tratamiento de consulta

			result.next();
			a.setIDAplicacion(result.getString("IDAplicacion")); // Cambiar cuando
																// se hable con
																// Álvaro
			a.setNombre(result.getString("nombre"));
			a.setDescripcion(result.getString("descripcion"));
			a.setFechaPublicacion(result.getDate("fechaPublicacion"));
			a.setURLWeb(result.getString("URLWeb"));
			a.setVotosAFavor(result.getInt("numeroVotosAFavor"));
			a.setVotosEnContra(result.getInt("numeroVotosEnContra"));
			a.setIDProyecto(idProyecto);

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

		return a;
	}

}
