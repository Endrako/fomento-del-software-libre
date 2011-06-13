package pos.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import pos.domain.Respuesta;
import pos.domain.RespuestaImpl;

public class JDBCRespuestaDAO implements IRespuestaDAO {

	private Connection conn;
	
	public JDBCRespuestaDAO (){
		 conn = ConnectionManager.getInstance().checkOut();
	}
	
	 protected void finalize() {
	        ConnectionManager.getInstance().checkIn(conn);
	        
	 }
	
	@Override
	public void borrar(String RespuestaID) {
        String sql = "DELETE FROM respuestas WHERE (IDRespuesta = ?) ";
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, RespuestaID);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Message: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("ErrorCode: " + e.getErrorCode());
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
            }
        }

	}

	@Override
	public List<Respuesta> seleccionarTodasRespuestasPorPregunta(String idPregunta) {
		String sql = "SELECT * FROM preguntasrespuestas a, respuestas r WHERE a.IDRespuesta = r.IDRespuesta AND (a.IDPregunta = ?)" ;
		PreparedStatement stmt = null;
		ResultSet result = null;
		List<Respuesta> res = new LinkedList<Respuesta>();
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, idPregunta);

			result = stmt.executeQuery();

			while(result.next()){
				Respuesta r = new RespuestaImpl();
				r.setIDRespuesta(result.getString("IDRespuesta"));
				r.setDescripcion(result.getString("descripcionRespuesta"));
				r.setNumeroVotos(result.getInt("numeroVotos"));
				res.add(r);
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
	public void insertarRespuesta(String rID,Respuesta r) {
		
		PreparedStatement stmt = null;
		String sql = "INSERT INTO respuestas (IDRespuesta, descripcionRespuesta, numeroVotos) VALUES (?,?,?) ";
		try {
			stmt = conn.prepareStatement(sql);

			stmt.setString(1, rID);
			stmt.setString(2, r.getDescripcionRespuesta());
			stmt.setInt(3, 0);

			stmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Message: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("ErrorCode: " + e.getErrorCode());
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
			}
		}

	}

	@Override
	public Respuesta recuperarRespuesta(String RespuestaId) {
		String sql = "SELECT * FROM respuestas WHERE (IDRespuesta = ? )";
		PreparedStatement stmt = null;
		ResultSet result = null;
		Respuesta res = new RespuestaImpl();

		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, RespuestaId);

			result = stmt.executeQuery();

			result.next();
			res.setIDRespuesta(result.getString("IDRespuesta"));
			res.setDescripcion(result.getString("descripcionRespuesta"));
			res.setNumeroVotos(result.getInt("numeroVotos"));

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
	
	public void votarRespuestas(String RespuestaId) {
		String sql = "UPDATE respuestas SET respuestas.numeroVotos = ? WHERE respuestas.IDRespuesta = ?";
		PreparedStatement stmt = null;
		ResultSet result = null;
		Respuesta res = new RespuestaImpl();

		res = recuperarRespuesta(RespuestaId);
		
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, res.getNumeroVotos()+1);
			stmt.setString(2, RespuestaId);
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
