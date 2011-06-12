package pos.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import pos.domain.Aplicacion;
import pos.domain.Usuario;
import pos.domain.Voto;
import pos.domain.VotoImpl;

public class JDBCVotarDAO implements IVotarDAO {

	private Connection conn;
	private IAplicacionDAO dapli;
	private IUsuarioDAO duser;

	public JDBCVotarDAO (){
		conn = ConnectionManager.getInstance().checkOut();
		dapli = new JDBCAplicacionDAO();
		duser = new JDBCUsuarioDAO();
	}

	@Override
	public List<Voto> selectAll() {
		String sql = "SELECT * FROM votos ";
		PreparedStatement stmt = null;
		ResultSet result = null;
		List<Voto> res = null;

		try {
			stmt = conn.prepareStatement(sql);

			result = stmt.executeQuery();
			res = new LinkedList<Voto>();

			while(result.next()){
				Voto voto = new VotoImpl();
				voto.setUsuario(result.getString("IDUsuario"));
				voto.setAplicacion(result.getString("IDAplicacion"));
				voto.setValor(result.getBoolean("valor"));
				res.add(voto);
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
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
			}
		}

		return res;
	}
	
	public Voto selectVotoByID(String voto){
		String sq = "Select * FROM votos WHERE IDVoto = ?";

		PreparedStatement stmt = null;
		ResultSet result = null;

		Voto res = new VotoImpl();

		try {
			stmt = conn.prepareStatement(sq);
			stmt.setString(1, voto);
			result = stmt.executeQuery();

			result.next();

			res.setAplicacion(result.getString("IDAplicacion"));
			res.setValor(result.getBoolean("valor"));
			
		} catch (SQLException e) {
			System.out.println("Message: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("ErrorCode: " + e.getErrorCode());
		} finally {
			try {
				if (result != null) {
					result.close();
				}
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
			}
		}
		return res;		
	}

	@Override
	public List<Voto> selectVotosByUser(String idUser) {
		String sql = "SELECT * FROM votos WHERE (IDUsuario = ?)" ;
		PreparedStatement stmt = null;
		ResultSet result = null;
		List<Voto> res = null;

		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, idUser);

			result = stmt.executeQuery();
			res = new LinkedList<Voto>();

			while(result.next()){
				Voto voto = new VotoImpl();
				voto.setUsuario(result.getString("IDUsuario"));
				voto.setAplicacion(result.getString("IDAplicacion"));
				voto.setValor(result.getBoolean("valor"));
				res.add(voto);
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
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
			}
		}

		return res;
	}

	@Override
	public List<Voto> selectVotoByAplicacion(String Aplicacion) {
		String sql = "SELECT * FROM votos WHERE (IDAplicacion = ?)" ;
		PreparedStatement stmt = null;
		ResultSet result = null;
		List<Voto> res = null;

		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, Aplicacion);

			result = stmt.executeQuery();
			res = new LinkedList<Voto>();

			while(result.next()){
				Voto voto = new VotoImpl();
				voto.setUsuario(result.getString("IDUsuario"));
				voto.setAplicacion(result.getString("IDAplicacion"));
				voto.setValor(result.getBoolean("valor"));
				res.add(voto);
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
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
			}
		}

		return res;
	}

	@Override
	public void insertVoto(Voto voto) {
		String sql = "INSERT INTO votos(IDVoto, IDUsuario, IDAplicacion, valor) " +
		"VALUES (?, ?, ?, ?)" ;

		PreparedStatement stmt1 = null;
		ResultSet result1 = null;

		try {
			stmt1 = conn.prepareStatement(sql);
			stmt1.setString(1, voto.getIDVoto());
			stmt1.setString(2, voto.getUsuario());
			stmt1.setString(3, voto.getAplicacion());
			stmt1.setBoolean(4, voto.getValor());

			stmt1.executeUpdate();
			Usuario user = duser.recuperarUsuarioByIdUsuario(voto.getUsuario());
			Aplicacion apli = dapli.selectAplicacionByID(voto.getAplicacion());
			updateAplicacion(voto, apli, 1);
			updateUser(voto, user);


		} catch (SQLException e) {
			System.out.println("Message: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("ErrorCode: " + e.getErrorCode());
		} finally {
			try {
				if (result1 != null) {
					result1.close();
				}
				if (stmt1 != null ) {
					stmt1.close();
				}
			} catch (SQLException e) {
			}
		}
	}

	@Override
	public void deleteVoto(String voto) {
		String sql = "DELETE FROM votos WHERE IDVoto = ?";
		PreparedStatement stmt = null;
		ResultSet result = null;

		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, voto);
			
			
			Voto res = selectVotoByID(voto);
			Aplicacion apli = dapli.selectAplicacionByID(res.getAplicacion().toString());
			updateAplicacion(res, apli, -1);
			
			stmt.executeUpdate();	
			
		} catch (SQLException e) {
			System.out.println("Message: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("ErrorCode: " + e.getErrorCode());
		} finally {
			try {
				if (result != null) {
					result.close();
				}
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
			}
		}
	}
	
// ------------------------------------- X -------------------------------
	
	
	//Tiene un parametro i por si se modifica al final la opcion de votar y en vez de ser solo +1
	//tenemos un rango de valores.
	private void updateAplicacion(Voto voto, Aplicacion apli, Integer i){
		PreparedStatement stmt = null;
		ResultSet result = null;

		String sq;
		if(voto.getValor()){
			sq = "UPDATE aplicaciones SET numeroVotosAFavor = ? " +
			"WHERE aplicaciones.IDAplicacion = ?";
		}else{
			sq = "UPDATE aplicaciones SET numeroVotosEnContra = ? " +
			"WHERE aplicaciones.IDAplicacion = ?";			
		}
		try {

			stmt = conn.prepareStatement(sq);
			if(voto.getValor()){
				stmt.setInt(1, apli.getVotosAFavor()+i);

			}else{
				stmt.setInt(1, apli.getVotosEnContra()+i);
			}
			stmt.setString(2, voto.getAplicacion());

			stmt.executeUpdate();				

		} catch (SQLException e) {
			System.out.println("Message: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("ErrorCode: " + e.getErrorCode());
		} finally {
			try {
				if (result != null) {
					result.close();
				}
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
			}
		}
	}
	
	private void updateUser(Voto voto, Usuario user){
		PreparedStatement stmt = null;
		ResultSet result = null;
		String sq = "UPDATE usuarios SET karma = ? WHERE usuarios.IDUsuario = ?";
		
		try {

			stmt = conn.prepareStatement(sq);
			stmt.setInt(1, user.getKarma()+5);
			stmt.setString(2, user.getIdUser());

			stmt.executeUpdate();				

		} catch (SQLException e) {
			System.out.println("Message: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("ErrorCode: " + e.getErrorCode());
		} finally {
			try {
				if (result != null) {
					result.close();
				}
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
			}
		}
		
	}
}
