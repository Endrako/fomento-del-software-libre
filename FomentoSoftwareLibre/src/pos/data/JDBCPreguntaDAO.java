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
	public void borrar(String preguntaID) {
		
		List<String> respIDs = seleccionarRespuestasDePregunta(preguntaID);
		for (String n: respIDs){
			borrarAsociacionPreguntaRespuesta(n);
			rdao.borrar(n);
		}
		
		
		String sql = "DELETE FROM preguntas WHERE (IDPregunta = ?) ";
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, preguntaID);
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

	public List<Pregunta> seleccionarTodasPreguntasPorEncuesta(String idEncuesta) {
		String sql = "SELECT * FROM preguntas WHERE (IDEncuesta = ? )";
		PreparedStatement stmt = null;
		ResultSet result = null;
		List<Pregunta> res = new LinkedList<Pregunta>();

		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, idEncuesta);

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
	public void insertarPregunta(Pregunta p,String idEncuensta) {
		String pID = UIDGenerator.getInstance().getKey();
		//Insertar respuestas
		
		for (Respuesta r :p.getRespuestas()){
			String rID = UIDGenerator.getInstance().getKey();
			rdao.insertarRespuesta(rID,r);
			AsociarPreguntaARespuesta(pID, rID);
		}
		
		PreparedStatement stmt = null;
		String sql = "INSERT INTO preguntas (IDPregunta, IDEncuesta, descripcionPregunta) VALUES (?,?,?) ";
		try {
			stmt = conn.prepareStatement(sql);

			stmt.setString(1, pID);
			stmt.setString(2, idEncuensta);
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
	public Pregunta recuperarPregunta(String idPregunta) {
		String sql = "SELECT * FROM preguntas WHERE (IDPregunta = ? ) ";
		PreparedStatement stmt = null;
		ResultSet result = null;
		Pregunta res = null;

		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, idPregunta);

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
	
	//============ Métodos Privados de la Asociación entre preguntas y respuestas=============
	
	
	
	private void AsociarPreguntaARespuesta(String idPregunta, String idRespuesta){
		PreparedStatement stmt = null;
		String sql = "INSERT INTO preguntasrespuestas (IDRespuesta, IDPregunta) VALUES (?,?) ";
		try {
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, idRespuesta);
			stmt.setString(2, idPregunta);

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
	
	private List<String> seleccionarRespuestasDePregunta(String pregID) {
		PreparedStatement stmt = null;
		ResultSet result = null;
		String sql = "SELECT * FROM preguntasrespuestas WHERE (IDPregunta = ? ) ";
		List<String> res = new LinkedList<String>();

		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, pregID);

			result = stmt.executeQuery();

			while (result.next()){
				String id;
				id = result.getString("IDRespuesta");
				res.add(id);
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
	
	private void borrarAsociacionPreguntaRespuesta(String respID) {
        String sql = "DELETE FROM preguntasrespuestas WHERE (IDRespuesta = ?) ";
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, respID);
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

}
