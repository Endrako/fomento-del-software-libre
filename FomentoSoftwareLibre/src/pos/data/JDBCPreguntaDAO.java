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
import pos.utils.UIDGenerator;

public class JDBCPreguntaDAO implements IPreguntaDAO {
	
	 private Connection conn;
	 private IRespuestaDAO rdao;
	 
	 public JDBCPreguntaDAO(){
		 conn = ConnectionManager.getInstance().checkOut();
		 rdao = new JDBCRespuestaDAO();
	 }
	 
	 protected void finalize() {
	        ConnectionManager.getInstance().checkIn(conn);
	 }
	
	 
	@Override
	public void borrar(String PreguntaID) {
		// TODO Auto-generated method stub

	}

	public List<Pregunta> seleccionarTodasPreguntasPorEncuesta(Integer idEncuesta) {
		String sql = "SELECT * FROM preguntas WHERE (IDEncuesta = ? )";
		PreparedStatement stmt = null;
		ResultSet result = null;
		List<Pregunta> res = new LinkedList<Pregunta>();

		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, idEncuesta);

			result = stmt.executeQuery();

			while(result.next()){
				Pregunta p = new PreguntaImpl();
				p.setEnunciado(result.getString("descripcionPregunta"));
				res.add(p);
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
	public void insertarPregunta(Pregunta p,Integer idEncuensta) {
		Integer pID = UIDGenerator.getInstance().getKey();
		//Insertar respuestas
		
		for (Respuesta r :p.getRespuestas()){
			Integer rID = UIDGenerator.getInstance().getKey();
			rdao.insertarRespuesta(rID,r);
			AsociarPreguntaARespuesta(pID, rID);
		}
		
		PreparedStatement stmt = null;
		String sql = "INSERT INTO preguntas (IDPregunta, IDEncuesta, descripcionPregunta) VALUES (?,?,?) ";
		try {
			stmt = conn.prepareStatement(sql);

			stmt.setInt(1, pID);
			stmt.setInt(2, idEncuensta);
			stmt.setString(3, p.getEnunciado());
			
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
	public Pregunta recuperarPregunta(Integer idPregunta) {
		String sql = "SELECT * FROM preguntas WHERE (IDPregunta = ? ) ";
		PreparedStatement stmt = null;
		ResultSet result = null;
		Pregunta res = null;

		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, idPregunta);

			result = stmt.executeQuery();

			result.next();
			res = new PreguntaImpl();
			res.setEnunciado(result.getString("descripcionPregunta"));
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
	
	private void AsociarPreguntaARespuesta(Integer idPregunta, Integer idRespuesta){
		Integer relID = UIDGenerator.getInstance().getKey();
		PreparedStatement stmt = null;
		String sql = "INSERT INTO preguntasrespuestas (IDRelacion, IDRespuesta, IDPregunta) VALUES (?,?,?) ";
		try {
			stmt = conn.prepareStatement(sql);

			stmt.setInt(1, relID);
			stmt.setInt(2, idRespuesta);
			stmt.setInt(3, idPregunta);

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

}
