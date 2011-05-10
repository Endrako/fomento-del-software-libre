package pos.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import pos.domain.Pais;
import pos.domain.PaisImpl;
import pos.domain.Pregunta;
import pos.domain.PreguntaImpl;

public class JDBCPaisDAO implements IPaisDAO {

	 private Connection conn;
	 private IPaisDAO dao;
	 
	public JDBCPaisDAO(){
		conn = ConnectionManager.getInstance().checkOut();
		dao = new JDBCPaisDAO();
	}
	@Override
	public List<PaisImpl> recuperarPaises() {
		List<PaisImpl> p = new ArrayList<PaisImpl>();
		String sql = "SELECT * FROM paises";
		PreparedStatement stmt = null;
		ResultSet result = null;
		
		try {
			stmt = conn.prepareStatement(sql);
			result = stmt.executeQuery();

			while(result.next()){
				PaisImpl pais = new PaisImpl();
				pais.setId(result.getInt("IDPais"));
				pais.setDescripcion(result.getString("nombre"));
				p.add(pais);
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

		return p;
		
	}

}
