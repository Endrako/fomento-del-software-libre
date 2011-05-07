package pos.data;

import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import pos.domain.Encuesta;
import pos.domain.EncuestaImpl;
import pos.utils.UIDGenerator;

public class JDBCEncuestaDAO implements IEncuestaDAO {
	
	 private Connection conn;
	 private IPreguntaDAO pdao;
	 private IRespuestaDAO rdao;
	 
	 public JDBCEncuestaDAO (){
		 conn = ConnectionManager.getInstance().checkOut();
		 pdao = new JDBCPreguntaDAO();
		 rdao = new JDBCRespuestaDAO();
	 }
	 
	 protected void finalize() {
	        ConnectionManager.getInstance().checkIn(conn);
	        
	 }

	@Override
	public void Borrar(String EncuestaID) {
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
	public void insertarEncuesta(Encuesta enc) {
		//String oidp = UIDGenerator.getInstance().getKey();
		//pdao.insert(conn, oidp, e.getPayment());

		//insert address
		//String oidr = UIDGenerator.getInstance().getKey();
		//rdao.insert(conn, oidr, o.getDeliverto());

		//insertar Encuensta
		Integer oide = UIDGenerator.getInstance().getKey();
		PreparedStatement stmt = null;
		String sql = "INSERT INTO encuestas (IDEncuesta, nombre	) VALUES (?, ?) ";
		try {
			stmt = conn.prepareStatement(sql);

			stmt.setInt(1, oide);
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
}
