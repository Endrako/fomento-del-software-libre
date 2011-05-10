package pos.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import pos.domain.Aplicacion;
import pos.domain.Voto;
import pos.domain.VotoImpl;

public class JDBCVotarDAO implements IVotarDAO {

	private Connection conn;
	private IAplicacionDAO dapli;

	public JDBCVotarDAO (){
		conn = ConnectionManager.getInstance().checkOut();
		dapli = new JDBCAplicacionDAO();
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
				voto.setUsuario(result.getInt("IDUsuario"));
				voto.setAplicacion(result.getInt("IDAplicacion"));
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
	
	public Voto selectVotoByID(Integer voto){
		String sq = "Select * FROM votos WHERE IDVoto = ?";

		PreparedStatement stmt = null;
		ResultSet result = null;

		Voto res = new VotoImpl();

		try {
			stmt = conn.prepareStatement(sq);
			stmt.setInt(1, voto);
			result = stmt.executeQuery();

			result.next();

			res.setAplicacion(result.getInt("IDAplicacion"));
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
	public List<Voto> selectVotosByUser(Integer idUser) {
		String sql = "SELECT * FROM votos WHERE (IDUsuario = ?)" ;
		PreparedStatement stmt = null;
		ResultSet result = null;
		List<Voto> res = null;

		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, idUser);

			result = stmt.executeQuery();
			res = new LinkedList<Voto>();

			while(result.next()){
				Voto voto = new VotoImpl();
				voto.setUsuario(result.getInt("IDUsuario"));
				voto.setAplicacion(result.getInt("IDAplicacion"));
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
	public List<Voto> selectVotoByAplicacion(Integer Aplicacion) {
		String sql = "SELECT * FROM votos WHERE (IDAplicacion = ?)" ;
		PreparedStatement stmt = null;
		ResultSet result = null;
		List<Voto> res = null;

		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, Aplicacion);

			result = stmt.executeQuery();
			res = new LinkedList<Voto>();

			while(result.next()){
				Voto voto = new VotoImpl();
				voto.setUsuario(result.getInt("IDUsuario"));
				voto.setAplicacion(result.getInt("IDAplicacion"));
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
		String sql = "INSERT INTO votos(IDUsuario, IDAplicacion, valor) " +
		"VALUES ( ?, ?, ?)" ;

		PreparedStatement stmt1 = null;
		ResultSet result1 = null;

		try {
			stmt1 = conn.prepareStatement(sql);
			stmt1.setInt(1, voto.getUsuario());
			stmt1.setInt(2, voto.getAplicacion());
			stmt1.setBoolean(3, voto.getValor());

			stmt1.executeUpdate();

			Aplicacion apli = dapli.selectAplicacionByID(voto.getAplicacion().toString());
			updateAplicacion(voto, apli, 1);


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
	public void deleteVoto(Integer voto) {
		String sql = "DELETE FROM votos WHERE IDVoto = ?";
		PreparedStatement stmt = null;
		ResultSet result = null;

		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, voto);
			
			
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
			stmt.setInt(2, voto.getAplicacion());

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
