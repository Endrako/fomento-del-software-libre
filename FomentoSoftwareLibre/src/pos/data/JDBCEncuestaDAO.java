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
import pos.utils.UIDGenerator;

public class JDBCEncuestaDAO implements IEncuestaDAO {
	
	 private Connection conn;
	 private IPreguntaDAO pdao;
	 
	 public JDBCEncuestaDAO (){
		 conn = ConnectionManager.getInstance().checkOut();
		 pdao = new JDBCPreguntaDAO();
	 }
	 
	 protected void finalize() {
	        ConnectionManager.getInstance().checkIn(conn);
	        
	 }

	@Override
	public void Borrar(Integer encuestaID) {
		List<Integer> pregIDs = seleccionarPreguntasDeEncuesta(encuestaID);
		for (Integer n: pregIDs){
			pdao.borrar(n);
		}
		
		
		String sql = "DELETE FROM encuestas WHERE (IDEncuesta = ?) ";
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, encuestaID);
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
	public List<Encuesta> seleccionarTodasEncuestas() {
		String sql = "SELECT * FROM encuestas";
		PreparedStatement stmt = null;
		ResultSet result = null;
		List<Encuesta> res = new LinkedList<Encuesta>();

		try {
			stmt = conn.prepareStatement(sql);

			result = stmt.executeQuery();

			while(result.next()){
			Encuesta e = new EncuestaImpl();
			e.setTituloEncuesta(result.getString("nombre"));
			res.add(e);
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
	public Encuesta recuperarEncuesta(Integer idEncuesta) {
		String sql = "SELECT * FROM encuestas WHERE (IDEncuesta = ? ) ";
		PreparedStatement stmt = null;
		ResultSet result = null;
		Encuesta res = null;

		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, idEncuesta);

			result = stmt.executeQuery();

			result.next();
			res = new EncuestaImpl();
			res.setTituloEncuesta(result.getString("nombre"));
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
	public void insertarEncuesta(Encuesta enc) {
		Integer eId = UIDGenerator.getInstance().getKey();
		
		for (Pregunta p : enc.getPreguntas()){
			pdao.insertarPregunta(p, eId);
		}

		//insertar Encuesta
		PreparedStatement stmt = null;
		String sql = "INSERT INTO encuestas (IDEncuesta, nombre	) VALUES (?, ?) ";
		try {
			stmt = conn.prepareStatement(sql);

			stmt.setInt(1, eId);
			stmt.setString(2, enc.getTituloEncuesta());

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
	
	private List<Integer> seleccionarPreguntasDeEncuesta(Integer encID) {
		PreparedStatement stmt = null;
		ResultSet result = null;
		String sql = "SELECT * FROM preguntas WHERE (IDEncuesta = ? ) ";
		List<Integer> res = new LinkedList<Integer>();

		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, encID);

			result = stmt.executeQuery();

			while (result.next()){
				Integer id;
				id = result.getInt("IDPregunta");
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
}
