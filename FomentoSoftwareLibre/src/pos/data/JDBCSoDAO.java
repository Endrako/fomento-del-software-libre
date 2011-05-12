package pos.data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pos.domain.Provincia;
import pos.domain.ProvinciaImpl;
import pos.domain.SO;
import pos.domain.SoImpl;

import com.mysql.jdbc.Connection;

public class JDBCSoDAO implements ISoDAO {
private Connection conn;
	
	public JDBCSoDAO(){
		conn =  (Connection) ConnectionManager.getInstance()
		.checkOut();
	}
	
	public List<SO> recuperarTodosLosSo(){
		List<SO> lista = new ArrayList<SO>();
		
		String sql = "SELECT * FROM so";
		PreparedStatement stmt = null;
		ResultSet result = null;
		
		try {
			stmt = conn.prepareStatement(sql);
			result = stmt.executeQuery();

			while(result.next()){
				SO prov = new SoImpl();
				prov.setIdSO(result.getString("IDSO"));
				prov.setDescripcion(result.getString("nombre"));
				prov.setEsOSmovil(result.getInt("esSOMovil"));
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
