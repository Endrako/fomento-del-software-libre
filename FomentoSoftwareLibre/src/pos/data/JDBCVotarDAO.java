package pos.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import pos.domain.Encuesta;
import pos.domain.EncuestaImpl;
import pos.domain.Voto;
import pos.domain.VotoImpl;

public class JDBCVotarDAO implements IVotarDAO {
	
	 private Connection conn;
	 private IVotarDAO vdao;
	 
	 public JDBCVotarDAO (){
		 conn = ConnectionManager.getInstance().checkOut();
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
		//INSERT INTO `isg3bd`.`votos` 
		//(`IDVoto`, `IDUsuario`, `IDAplicacion`, `valor`) VALUES (NULL, '1', '1', '1');
		
		String sql = "INSERT INTO votos" +
				"(IDVoto, IDUsuario, IDAplicacion, valor) " +
				"VALUES (NULL, ?, ?, ?)" ;
		PreparedStatement stmt = null;
		ResultSet result = null;
		
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, voto.getUsuario());
			stmt.setInt(2, voto.getAplicacion());
			stmt.setBoolean(3, voto.getValor());
						
			
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

	@Override
	public void deleteVoto(Integer Voto) {
		// TODO Auto-generated method stub

	}

}
