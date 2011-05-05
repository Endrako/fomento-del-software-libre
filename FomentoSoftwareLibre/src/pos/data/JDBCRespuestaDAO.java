package pos.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import pos.domain.Pregunta;
import pos.domain.PreguntaImpl;
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
		

	}

	@Override
	public List<Respuesta> seleccionarTodasRespuestasPorPregunta(Integer idPregunta) {
		//Esta mal la consulta
		String sql = "SELECT * FROM preguntasrespuestas pr,respuestas r WHERE (pr.IDPregunta = ? ) AND pr.IDRespuesta=r.IDRespuesta";
		PreparedStatement stmt = null;
		ResultSet result = null;
		List<Respuesta> res = new LinkedList<Respuesta>();

		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, idPregunta);

			result = stmt.executeQuery();

			while(result.next()){
				Respuesta r = new RespuestaImpl();
				r.setIDRespuesta(result.getInt("IDRespuesta"));
				r.setDescripcion(result.getString("descripcionRespuesta"));
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
	public void insertarRespuesta(Respuesta r) {
		// TODO Auto-generated method stub

	}

	@Override
	public Respuesta recuperarRespuesta(Integer RespuestaId) {
		String sql = "SELECT * FROM respuestas WHERE (IDRespuesta = ? )";
		PreparedStatement stmt = null;
		ResultSet result = null;
		Respuesta res = new RespuestaImpl();

		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, RespuestaId);

			result = stmt.executeQuery();

			result.next();
			res.setIDRespuesta(result.getInt("IDRespuesta"));
			res.setDescripcion(result.getString("descripcionRespuesta"));

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

}
