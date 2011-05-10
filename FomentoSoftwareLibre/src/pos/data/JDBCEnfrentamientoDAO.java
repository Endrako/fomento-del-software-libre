package pos.data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mysql.jdbc.Connection;

import pos.domain.Aplicacion;
import pos.domain.Enfrentamiento;
import pos.domain.EnfrentamientoImpl;
import pos.domain.Usuario;

public class JDBCEnfrentamientoDAO implements IEnfrentamientoDAO {

	// Para obtener un objeto Aplicacion mediante la ID utiliza el método
	// getAplicacionByID
	// de la clase JDBCAplicacionDAO

	public List<Enfrentamiento> selectAll() {
		Connection con = (Connection) ConnectionManager.getInstance()
				.checkOut();

		Enfrentamiento enfrentamiento = null;
		List<Enfrentamiento> lista = new ArrayList<Enfrentamiento>();
		String sql = "SELECT * FROM enfrentamientos";
		PreparedStatement stm = null;
		ResultSet result = null;

		try {
			stm = con.prepareStatement(sql);
			result = stm.executeQuery(sql);
			//para poder acceder a los datos del ResultSet hay que hacerle el .next()
			//si el método solo figurase dentro del while se saltaria la primera tupla
			enfrentamiento = createEnfrentamientoFromBD(enfrentamiento,result);
			lista.add(enfrentamiento);
			
			while (result.next()) {
				enfrentamiento = createEnfrentamientoFromBD(enfrentamiento,result);
				lista.add(enfrentamiento);
			}
		} catch (SQLException e) {
			System.out.println("Message: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("ErrorCode: " + e.getErrorCode());
		} finally {
			try {
				if (result != null) {
					result.close();
				}
				if (stm != null) {
					stm.close();
				}
			} catch (SQLException e) {
			}
		}
		return lista;
	}

	public Enfrentamiento selectEnfrentamientoByID(String IDEnfrentamiento) {
		Connection con = (Connection) ConnectionManager.getInstance()
				.checkOut();
		Enfrentamiento enfrentamiento = null;
		String sql = "SELECT * FROM enfrentamientos WHERE (IDEnfrentamiento = ?)";
		PreparedStatement stm = null;
		ResultSet result = null;

		try {
			stm = con.prepareStatement(sql);
			stm.setInt(1, new Integer(IDEnfrentamiento));
			result = stm.executeQuery();
			enfrentamiento = createEnfrentamientoFromBD(enfrentamiento, result);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Message: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("ErrorCode: " + e.getErrorCode());
		} finally {
			try {
				if (result != null) {
					result.close();
				}
				if (stm != null) {
					stm.close();
				}
			} catch (SQLException e) {
			}
		}
		return enfrentamiento;
	}

	public List<Enfrentamiento> selectEnfrentamientoByUserCreator(String IDUser) {
		// En la BD no hay un usuario creador.
		return null;
	}

	public List<Enfrentamiento> selectEnfrentamientoByAply(String IDAply) {

		Connection con = (Connection) ConnectionManager.getInstance()
				.checkOut();

		List<Enfrentamiento> lista = new ArrayList<Enfrentamiento>();
		Enfrentamiento enfrentamiento = null;
		String sql = "SELECT * FROM enfrentamientos WHERE ( IDAplicacion1 = ? ) OR (idAplicacion2 = ? )";
		PreparedStatement stm = null;
		ResultSet result = null;

		try {
			stm = con.prepareStatement(sql);
			stm.setString(1, IDAply);
			stm.setString(2, IDAply);
			result = stm.executeQuery();
			//para poder acceder a los datos del ResultSet hay que hacerle el .next()
			//si el método solo figurase dentro del while se saltaria la primera tupla
			enfrentamiento = createEnfrentamientoFromBD(enfrentamiento,result);
			lista.add(enfrentamiento);
			
			while (result.next()) {
				enfrentamiento = createEnfrentamientoFromBD(enfrentamiento,
						result);
				lista.add(enfrentamiento);
			}
		} catch (SQLException e) {
			System.out.println("Message: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("ErrorCode: " + e.getErrorCode());
		} finally {
			try {
				if (result != null) {
					result.close();
				}
				if (stm != null) {
					stm.close();
				}
			} catch (SQLException e) {
			}
		}
		return lista;
	}

	public List<Enfrentamiento> selectEnfrentamientosAcept() {
		Connection con = (Connection) ConnectionManager.getInstance()
				.checkOut();

		Enfrentamiento enfrentamiento = null;
		List<Enfrentamiento> lista = new ArrayList<Enfrentamiento>();
		String sql = "SELECT * FROM enfrentamientos WHERE aceptado=1";
		PreparedStatement stm = null;
		ResultSet result = null;

		try {
			stm = con.prepareStatement(sql);
			result = stm.executeQuery();
			//para poder acceder a los datos del ResultSet hay que hacerle el .next()
			//si el método solo figurase dentro del while se saltaria la primera tupla
			enfrentamiento = createEnfrentamientoFromBD(enfrentamiento,result);
			lista.add(enfrentamiento);
			
			while (result.next()) {
				enfrentamiento = createEnfrentamientoFromBD(enfrentamiento,
						result);
				lista.add(enfrentamiento);
			}
		} catch (SQLException e) {
			System.out.println("Message: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("ErrorCode: " + e.getErrorCode());
		} finally {
			try {
				if (result != null) {
					result.close();
				}
				if (stm != null) {
					stm.close();
				}
			} catch (SQLException e) {
			}
		}
		return lista;
	}

	@Override
	public List<Enfrentamiento> selectEnfrentamientosNonAcept() {
		Connection con = (Connection) ConnectionManager.getInstance()
				.checkOut();

		Enfrentamiento enfrentamiento = null;
		List<Enfrentamiento> lista = new ArrayList<Enfrentamiento>();
		String sql = "SELECT * FROM enfrentamientos WHERE aceptado=0";
		PreparedStatement stm = null;
		ResultSet result = null;

		try {
			stm = con.prepareStatement(sql);
			result = stm.executeQuery();
			//para poder acceder a los datos del ResultSet hay que hacerle el .next()
			//si el método solo figurase dentro del while se saltaria la primera tupla
			enfrentamiento = createEnfrentamientoFromBD(enfrentamiento,result);
			lista.add(enfrentamiento);
			
			while (result.next()) {
				enfrentamiento = createEnfrentamientoFromBD(enfrentamiento,result);
				lista.add(enfrentamiento);
			}
		} catch (SQLException e) {
			System.out.println("Message: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("ErrorCode: " + e.getErrorCode());
		} finally {
			try {
				if (result != null) {
					result.close();
				}
				if (stm != null) {
					stm.close();
				}
			} catch (SQLException e) {
			}
		}
		return lista;

	}

	@Override
	public void insertEnfrentamiento(Enfrentamiento enfrentamiento) {
		Connection con = (Connection) ConnectionManager.getInstance()
				.checkOut();

		String sql = "INSERT INTO enfrentamientos (IDAplicacion1,idAplicacion2,descripcion,votosApp1,votosApp2,fechaCreacion,fechaFin,aceptado) VALUES (?,?,?,?,?,?,?,?) ";
		PreparedStatement stm = null;

		Aplicacion aplicacion1 = enfrentamiento.getAplicacion1();
		Aplicacion aplicacion2 = enfrentamiento.getAplicacion2();
		Integer IDAply1 = new Integer(aplicacion1.getIDAplicacion());
		Integer IDAply2 = new Integer(aplicacion2.getIDAplicacion());
		String descripcion = enfrentamiento.getDescripcion();
		Date fechaCreacion = enfrentamiento.getFechaCreacion();
		Date fechaFin = enfrentamiento.getFechaFin();
		// Votos se inicializan a 0, y aceptado a FALSE (0)
		try {
			stm = con.prepareStatement(sql);

			stm.setInt(1, IDAply1);
			stm.setInt(2, IDAply2);
			stm.setString(3, descripcion);
			stm.setInt(4, 0);// votosApp1
			stm.setInt(5, 0);// votosApp2
			stm.setDate(6, (java.sql.Date) fechaCreacion);
			stm.setDate(7, (java.sql.Date) fechaFin);
			stm.setInt(8, 0);

			stm.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Message: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("ErrorCode: " + e.getErrorCode());
		} finally {
			try {
				if (stm != null) {
					stm.close();
				}
			} catch (SQLException e) {

			}
		}
	}

	@Override
	public void deleteEnfrentamiento(Enfrentamiento enfrentamiento) {
		Connection con = (Connection) ConnectionManager.getInstance()
				.checkOut();
		Integer IDEnfrentamiento = new Integer(
				enfrentamiento.getIDEnfrentamiento());
		// Integer IDAply1=
		// getIDFromAplication(enfrentamiento.getAplicacion1());
		// Integer IDAply2=
		// getIDFromAplication(enfrentamiento.getAplicacion2());

		// Me hace falta un método que dandole una aplicacion me de su ID
		String sql = "DELETE FROM enfrentamientos WHERE (IDEnfrentamiento = ?)";
		// String sql =
		// "DELETE FROM Enfrentamientos WHERE ( IDAplicacion1 = ?) AND (idAplicacion2 = ?)";
		PreparedStatement stm = null;

		try {
			stm = con.prepareStatement(sql);
			stm.setInt(1, IDEnfrentamiento);
			// stm.setInt(1,IDAply1);
			// stm.setInt(2,IDAply2);
			stm.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Message: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("ErrorCode: " + e.getErrorCode());
		} finally {
			try {
				if (stm != null) {
					stm.close();
				}
			} catch (SQLException e) {

			}
		}
	}

	public void acceptEnfrentamiento(String IDEnfrentamiento) {

		Connection con = (Connection) ConnectionManager.getInstance()
				.checkOut();

		String sql = "UPDATE enfrentamientos SET enfrentamientos.aceptado=1 WHERE (enfrentamientos.IDEnfrentamiento = ?)";
		PreparedStatement stm = null;
		try {
			stm = con.prepareStatement(sql);
			stm.setInt(1, new Integer(IDEnfrentamiento));
			stm.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Message: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("ErrorCode: " + e.getErrorCode());
		} finally {
			try {
				if (stm != null) {
					stm.close();
				}
			} catch (SQLException e) {

			}
		}
	}

	public Enfrentamiento getEnfrentamientoByAplications(Aplicacion aply1,
			Aplicacion aply2) {
		Connection con = (Connection) ConnectionManager.getInstance()
				.checkOut();

		Enfrentamiento enfrentamiento = null;
		Integer IDAply1 = new Integer(aply1.getIDAplicacion());
		Integer IDAply2 = new Integer(aply2.getIDAplicacion());
		String sql = "SELECT * FROM enfrentamientos WHERE (IDAplicacion1=? AND idAplicacion2=?) OR (IDAplicacion1=? AND idAplicacion2=?)";
		ResultSet result = null;
		PreparedStatement stm = null;

		try {
			stm = con.prepareStatement(sql);
			stm.setInt(1, IDAply1);
			stm.setInt(2, IDAply2);
			stm.setInt(3, IDAply2);
			stm.setInt(4, IDAply1);

			result = stm.executeQuery();

			enfrentamiento = createEnfrentamientoFromBD(enfrentamiento, result);
		} catch (SQLException e) {
			System.out.println("Message: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("ErrorCode: " + e.getErrorCode());
		} finally {
			try {
				if (stm != null) {
					stm.close();
				}
				if (result != null) {
					stm.close();
				}
			} catch (SQLException e) {

			}
		}
		return enfrentamiento;
	}

	public void votar(String IDEnfrentamiento, String IDUser,
			String IDAplicacion) {
		Connection con = (Connection) ConnectionManager.getInstance()
				.checkOut();

		String sql = "INSERT INTO votosusuarioenfrentamiento(IDEnfrentamiento,IDUsuario,IDAplicacion) VALUES (?,?,?)";
		PreparedStatement stm = null;

		try {
			stm = con.prepareStatement(sql);
			stm.setInt(1, new Integer(IDEnfrentamiento));
			stm.setInt(2, new Integer(IDUser));
			stm.setInt(3, new Integer(IDAplicacion));
			stm.executeUpdate();

			puntuar(con, IDEnfrentamiento, IDAplicacion);
		} catch (SQLException e) {
			System.out.println("Message: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("ErrorCode: " + e.getErrorCode());
		} finally {
			try {
				if (stm != null) {
					stm.close();
				}
			} catch (SQLException e) {

			}
		}
	}

	public List<Usuario> getUsuariosPorEnfrentamiento(String IDEnfrentamiento) {
		Connection con = (Connection) ConnectionManager.getInstance()
				.checkOut();

		Usuario usuario = null;
		List<Usuario> listaUsuarios = new ArrayList<Usuario>();
		PreparedStatement stm = null;
		ResultSet result = null;
		String sql = "SELECT IDUsuario FROM votosusuarioenfrentamiento WHERE IDEnfrentamiento = ?";

		Integer currentIDEnfrentamiento = new Integer(IDEnfrentamiento);

		try {
			stm = con.prepareStatement(sql);
			stm.setInt(1, currentIDEnfrentamiento);
			result = stm.executeQuery();
			while (result.next()) {
				usuario = (new JDBCUsuarioDAO()).recuperarUsuario(result
						.getString("IDUsuario"));
				listaUsuarios.add(usuario);
			}

		} catch (SQLException e) {
			System.out.println("Message: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("ErrorCode: " + e.getErrorCode());
		} finally {
			try {
				if (stm != null) {
					stm.close();
				}
				if (result != null) {
					result.close();
				}
			} catch (SQLException e) {

			}
		}
		return listaUsuarios;
	}

	private void puntuar(Connection con, String IDEnfrentamiento,
			String IDAplicacion) {
		Integer currentenIDEnfrentamiento = new Integer(IDEnfrentamiento);
		Integer currentIDAplicacion = new Integer(IDAplicacion);
		String sql1 = "UPDATE enfrentamientos SET enfrentamientos.votosApp1 = ? WHERE enfrentamientos.IDEnfrentamiento = ?";
		String sql2 = "UPDATE enfrentamientos SET enfrentamientos.votosApp2 = ? WHERE enfrentamientos.IDEnfrentamiento = ?";
		PreparedStatement stm = null;

		Enfrentamiento currentEnfrentamiento = selectEnfrentamientoByID(IDEnfrentamiento);
		Integer IDAply1 = new Integer(currentEnfrentamiento.getAplicacion1()
				.getIDAplicacion());
		Integer votosAply1 = currentEnfrentamiento.getVotosAplicacion1();
		Integer votosAply2 = currentEnfrentamiento.getVotosAplicacion2();

		try {
			if (currentIDAplicacion.equals(IDAply1)) {
				stm = con.prepareStatement(sql1);
				stm.setInt(1, (votosAply1 + 1));
				stm.setInt(2, currentenIDEnfrentamiento);
				stm.executeUpdate();
			} else {
				stm = con.prepareStatement(sql2);
				stm.setInt(1, (votosAply2 + 1));
				stm.setInt(2, currentenIDEnfrentamiento);
				stm.executeUpdate();
			}
		} catch (SQLException e) {
			System.out.println("Message: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("ErrorCode: " + e.getErrorCode());
		} finally {
			try {
				if (stm != null) {
					stm.close();
				}
			} catch (SQLException e) {

			}
		}
	}

	private Enfrentamiento createEnfrentamientoFromBD(Enfrentamiento enfrent,
			ResultSet resSet) {
		enfrent = new EnfrentamientoImpl();
		JDBCAplicacionDAO apliDAO = new JDBCAplicacionDAO();

		try {
			while (resSet.next()) {

				Integer IDEnfrentamiento = resSet.getInt("IDEnfrentamiento");
				Integer IDapl1 = resSet.getInt("IDAplicacion1");
				Integer IDapl2 = resSet.getInt("idAplicacion2");
				String descripcion = resSet.getString("descripcion");
				Integer votosAply1 = resSet.getInt("votosApp1");
				Integer votosAply2 = resSet.getInt("votosApp2");
				Date fechaCreacion = resSet.getDate("fechaCreacion");
				Date fechaFin = resSet.getDate("fechaFin");
				// Cuidaaaaaaaaaoooooooo!
				Aplicacion aplicacion1 = apliDAO.selectAplicacionByID(IDapl1.toString());
				Aplicacion aplicacion2 = apliDAO.selectAplicacionByID(IDapl2.toString());
				enfrent.setIDEnfrentamiento(IDEnfrentamiento.toString());
				enfrent.setAplicacion1(aplicacion1);
				enfrent.setAplicacion2(aplicacion2);
				enfrent.setDescripcion(descripcion);
				enfrent.setFechaCreacion(fechaCreacion);
				enfrent.setFechaFin(fechaFin);
				enfrent.setVotosAplicacion1(votosAply1);
				enfrent.setVotosAplicacion2(votosAply2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return enfrent;
	}

}
