package pos.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import pos.domain.Encuesta;
import pos.domain.EncuestaImpl;
import pos.domain.Pregunta;
import pos.domain.PreguntaImpl;

public class JDBCPreguntaDAO implements IPreguntaDAO {
	
	 private Connection conn;
	 private IPreguntaDAO pdao;
	 private IRespuestaDAO rdao;
	 
	 public JDBCPreguntaDAO(){
		 conn = ConnectionManager.getInstance().checkOut();
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
	public void insertarPregunta(Pregunta p) {
		// TODO Auto-generated method stub

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

}
