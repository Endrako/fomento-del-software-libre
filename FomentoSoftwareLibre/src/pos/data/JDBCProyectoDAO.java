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
import pos.domain.Usuario;
import pos.utils.UIDGenerator;

public class JDBCProyectoDAO implements IProyectoDAO {

	IAplicacionDAO adao = new JDBCAplicacionDAO();

	@Override
	/*
	 * Método para obtener todos los proyectos de la tabla
	 */
	public List<Proyecto> obtenerTodosProyectos() {

		Connection con = (Connection) ConnectionManager.getInstance()
				.checkOut();

		String sql = "SELECT * FROM proyectos";
		PreparedStatement stmt = null;
		ResultSet result = null;
		List<Proyecto> listaProyectos = null;

		try {
			stmt = con.prepareStatement(sql);

			result = stmt.executeQuery();
			listaProyectos = new LinkedList<Proyecto>();

			while (result.next()) {
				Proyecto proyecto = new ProyectoImpl();
				proyecto.setIDProyecto(result.getString("idProyecto"));
				proyecto.setDescripcionProyecto(result.getString("descripcion"));
				proyecto.setFechaFin(result.getDate("fechaFin"));
				proyecto.setFechaInicio(result.getDate("fechaInicio"));
				proyecto.setNombreProyecto(result.getString("nombre"));
				proyecto.setDisponibilidad(result.getBoolean("disponible"));
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
					con.close();
				}
				if (stmt != null) {
					con.close();
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

		Connection con = (Connection) ConnectionManager.getInstance()
				.checkOut();

		String sql = "SELECT * FROM proyectos p WHERE p.disponible = '1'";

		PreparedStatement stmt = null;
		ResultSet result = null;
		List<Proyecto> listaProyectos = null;

		try {
			stmt = con.prepareStatement(sql);
			result = stmt.executeQuery();

			listaProyectos = new LinkedList<Proyecto>();

			while (result.next()) {
				Proyecto proyecto = new ProyectoImpl();

				proyecto.setIDProyecto(result.getString("idProyecto"));
				proyecto.setDescripcionProyecto(result.getString("descripcion"));
				proyecto.setFechaFin(result.getDate("fechaFin"));
				proyecto.setFechaInicio(result.getDate("fechaInicio"));
				proyecto.setNombreProyecto(result.getString("nombre"));
				proyecto.setDisponibilidad(result.getBoolean("disponible"));
				proyecto.setNivelKarma(result.getInt("nivelKarma"));
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
					con.close();

				if (stmt != null)
					con.close();
			} catch (SQLException e) {
			}
		}

		return listaProyectos;
	}

	@Override
	/*
	 * Método para insertar un nuevo proyecto en la tabla
	 */
	public void crearProyecto(Proyecto proyecto) {

		Connection con = (Connection) ConnectionManager.getInstance()
				.checkOut();

		PreparedStatement stmt = null;

		String IDProyecto = UIDGenerator.getInstance().getKey();

		String sql = "INSERT INTO proyecto(IDProyecto,nombre,descripcion,fechaInicio,fechaFin,"
				+ "disponible,nivelKarma) VALUES (?,?,?,?,?,?,?)";

		try {
			stmt = con.prepareStatement(sql);

			stmt.setString(1, IDProyecto);
			stmt.setString(2, proyecto.getNombreProyecto());
			stmt.setString(3, proyecto.getDescripcionProyecto());
			stmt.setString(4, proyecto.getFechaInicio().toString());
			stmt.setString(5, proyecto.getFechaFin().toString());
			stmt.setString(6, proyecto.getDisponibilidad().toString());
			stmt.setString(7, proyecto.getNivelKarma().toString());

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
					con.close();
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
	public Proyecto obtenerProyectoPorID(Proyecto p) {

		Connection con = (Connection) ConnectionManager.getInstance()
				.checkOut();

		Proyecto pRes = new ProyectoImpl();

		ResultSet result = null;
		PreparedStatement stmt = null;

		// Consulta para seleccionar el proyecto

		String sql = "SELECT * FROM proyecto p WHERE (p.IDProyecto = ?)";

		try {
			// Ejecución de consulta
			stmt = con.prepareStatement(sql);
			stmt.setString(1, p.getIDProyecto());
			result = stmt.executeQuery();

			// Tratamiento de consulta
			result.next();

			pRes.setIDProyecto(p.getIDProyecto());
			pRes.setNombreProyecto(result.getString("nombre"));
			pRes.setDescripcionProyecto(result.getString("descripcion"));
			pRes.setFechaInicio(result.getDate("fechaInicio"));
			pRes.setFechaFin(result.getDate("fechaFin"));
			pRes.setDisponibilidad(result.getBoolean("disponible"));
			pRes.setNivelKarma(result.getInt("nivelKarma"));

			// llamo al método creado para obtener la lista de aplicaciones
			// vinculadas al proyecto
			pRes.setAplicacion(obtenerAplicacionDeProyecto(p));

		} catch (SQLException e) {
			System.out.println("Message: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("Error Code: " + e.getErrorCode());
			System.out.println("Cause: " + e.getCause());
		} finally {

			try {
				if (stmt != null) {
					con.close();
				}
				if (result != null) {
					con.close();
				}

			} catch (Exception e) {

			}
		}

		return pRes;
	}

	@Override
	/*
	 * Método para eliminar un proyecto. CUANDO SE BORRA UN PROYECTO, LAS APPS
	 * VINCULADAS VAN DETRÁS CON ÉL!!!
	 */
	public void borrarProyecto(Proyecto p) {

		Connection con = (Connection) ConnectionManager.getInstance()
				.checkOut();

		PreparedStatement stmt = null;
		

		// Problemática del método: borrar las aplicaciones vinculadas del
		// proyecto a borrar.

		// Si a nivel de BD estuviera conectado en cascada, se borrarían
		// automáticamente las aplicaciones
		// asociadas al proyecto borrado...

		String sql = "DELETE FROM proyectos WHERE (IDProyecto = ?)";

		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, p.getIDProyecto());

			stmt.executeUpdate();
			
			Aplicacion a = obtenerAplicacionDeProyecto(p);
			adao.deleteAplication(a);

		} catch (SQLException e) {
			System.out.println("Message: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("Error Code: " + e.getErrorCode());
			System.out.println("Cause: " + e.getCause());
		} finally {

			try {
				if (stmt != null) {
					con.close();
				}
			} catch (Exception e) {

			}
		}
	}
	/*
	 * Este método borra todas las tuplas asociativas de la tabla "colaboracionusuariosproyectos"
	 * en las que se encontraba un proyecto.
	 */
	public void borrarAsociacionUsuariosConProyecto (Proyecto p){
		
		Connection con = (Connection) ConnectionManager.getInstance()
		.checkOut();

		PreparedStatement stmt = null;
		// Borrará todas las tuplas donde se encuentre el proyecto.
		String sql = "DELETE FROM colaboracionusuariosproyectos c WHERE (c.IDProyecto = ?)";
		
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, p.getIDProyecto());

			stmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Message: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("Error Code: " + e.getErrorCode());
			System.out.println("Cause: " + e.getCause());
		} finally {

			try {
				if (stmt != null) {
					con.close();
				}
			} catch (Exception e) {

			}
		}
	}

	@Override
	public Aplicacion obtenerAplicacionDeProyecto(Proyecto p) {

		Connection con = (Connection) ConnectionManager.getInstance()
				.checkOut();

		Aplicacion a = new AplicacionImpl();

		ResultSet result = null;
		PreparedStatement stmt = null;

		// Consulta para obtener la aplicación vinculada al proyecto

		String sql = "SELECT * FROM aplicaciones a WHERE (a.IDProyecto = ? )";

		try {

			// Ejecución de consulta
			stmt = con.prepareStatement(sql);
			stmt.setString(1, p.getIDProyecto());
			result = stmt.executeQuery();

			// Tratamiento de consulta

			result.next();
			a.setIDAplicacion(result.getString("IDAplicacion"));
			a.setNombre(result.getString("nombre"));
			a.setDescripcion(result.getString("descripcion"));
			a.setFechaPublicacion(result.getDate("fechaPublicacion"));
			a.setURLWeb(result.getString("URLWeb"));
			a.setVotosAFavor(result.getInt("numeroVotosAFavor"));
			a.setVotosEnContra(result.getInt("numeroVotosEnContra"));
			a.setIDProyecto(result.getString("IDProyecto"));

		} catch (SQLException e) {
			System.out.println("Message: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("Error Code: " + e.getErrorCode());
			System.out.println("Cause: " + e.getCause());
		} finally {

			try {
				if (stmt != null) {
					con.close();
				}
				if (result != null) {
					con.close();
				}
			} catch (Exception e) {

			}
		}

		return a;
	}

	public boolean existeTuplaUsuarioProyecto(Usuario u,Proyecto p) {
		boolean res = false;

		Connection con = (Connection) ConnectionManager.getInstance()
				.checkOut();

		PreparedStatement stmt = null;
		ResultSet result = null;

		String sql = "SELECT * FROM colaboracionusuariosproyectos c WHERE "
				+ "(c.IDUsuario = ? AND c.IDProyecto = ?)";

		try {
			stmt = con.prepareStatement(sql);

			stmt.setString(1, u.getIdUser());
			stmt.setString(2, p.getIDProyecto());

			result = stmt.executeQuery(sql);

			if (result.getString("IDUsuario") == null
					|| result.getString("IDProyecto") == null) {
				res = false;
			} else {
				res = true;
			}
		} catch (SQLException e) {
			System.out.println("Message: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("Error Code: " + e.getErrorCode());
			System.out.println("Cause: " + e.getCause());
		} finally {
			try {
				if (stmt != null) {
					con.close();
				}
				if (result != null) {
					con.close();
				}
			} catch (Exception e) {
			}
		}
		return res;

	}

	public void asociarProyectoAUsuario(Usuario u,Proyecto p) {

		Connection con = (Connection) ConnectionManager.getInstance()
				.checkOut();

		PreparedStatement stmt = null;

		String sql = "INSERT INTO colaboracionusuariosproyectos (IDUsuario,IDProyecto) VALUES (?,?)";

		try {

			stmt = con.prepareStatement(sql);
			stmt.setString(1, u.getIdUser());
			stmt.setString(2, p.getIDProyecto());

		} catch (SQLException e) {
			System.out.println("Message: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("Error Code: " + e.getErrorCode());
			System.out.println("Cause: " + e.getCause());
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {
					con.close();
				}
			} catch (Exception e) {

			}
		}

	}

}