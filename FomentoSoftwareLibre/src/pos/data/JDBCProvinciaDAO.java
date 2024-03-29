package pos.data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pos.domain.Provincia;
import pos.domain.ProvinciaImpl;

import com.mysql.jdbc.Connection;

public class JDBCProvinciaDAO {

	private Connection conn;
	
	public JDBCProvinciaDAO(){
		conn =  (Connection) ConnectionManager.getInstance()
		.checkOut();
	}
	
	public List<Provincia> recuperarTodasLasProvincias(){
		List<Provincia> lista = new ArrayList<Provincia>();
		
		String sql = "SELECT * FROM provincias";
		PreparedStatement stmt = null;
		ResultSet result = null;
		
		try {
			stmt = conn.prepareStatement(sql);
			result = stmt.executeQuery();

			while(result.next()){
				Provincia prov = new ProvinciaImpl();
				prov.setId(result.getString("IDProvincia"));
				prov.setDescripcion(result.getString("nombre"));
				lista.add(prov);
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

		return lista;
	}
}
