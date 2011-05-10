package pos.data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import pos.domain.PaisImpl;
import pos.domain.Perfil;
import pos.domain.PerfilImpl;
import pos.utils.UIDGenerator;

public class JDBCPerfilDAO implements IPerfilDAO {

	private Connection conn;
	
	public JDBCPerfilDAO(){
		conn = (Connection) ConnectionManager.getInstance().checkOut();
	}
	@Override
	public List<PerfilImpl> recuperarPerfiles() {
		List<PerfilImpl> p = new ArrayList<PerfilImpl>();
		String sql = "SELECT * FROM perfiles";
		PreparedStatement stmt = null;
		ResultSet result = null;
		
		try {
			stmt = conn.prepareStatement(sql);
			result = stmt.executeQuery();

			while(result.next()){
				PerfilImpl perfil = new PerfilImpl();
				perfil.setIdPerfil(result.getInt("IDPerfil"));
				perfil.setNombreUsuario(result.getString("nombre"));
				perfil.setApellidos(result.getString("apellidos"));
				perfil.setEdad(result.getInt("edad"));
				perfil.setIdPais(result.getString("IDPais"));
				perfil.setIdPoblacion(result.getString("IDPoblacion"));
				perfil.setMovilOS(result.getString("IDSO2"));
				perfil.setPcOS(result.getString("IDSO1"));
				p.add(perfil);
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

	@Override
	public void insertarPerfil(Perfil p) {
		String sql = "INSERT INTO perfiles (IDPerfil, nombre, apellidos, edad, IDPais, IDPoblacion,IDSO1, IDSO2) VALUES (?, ?,?,?,?,?,?,?) ";
		PreparedStatement stmt = null;
		ResultSet result = null;
		
		try {
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, UIDGenerator.getInstance().getKey());
			stmt.setString(2, p.getNombreUsuario());
			stmt.setString(3, p.getApellidos());
			stmt.setInt(4, p.getEdad());
			stmt.setInt(5, Integer.parseInt(p.getIdPais()));
			stmt.setInt(6, Integer.parseInt(p.getIdPoblacion()));
			stmt.setInt(7, Integer.parseInt(p.getPcOS()));
			stmt.setInt(8, Integer.parseInt(p.getMovilOS()));
			result = stmt.executeQuery();

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

	@Override
	public Perfil recuperarPerfil(int idPerfil) {
		Perfil perfil = new PerfilImpl();
		String sql = "SELECT * FROM perfiles where ( id = ? )";
		
		PreparedStatement stmt = null;
		ResultSet result = null;
		
		try {
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, idPerfil);
			
			result = stmt.executeQuery();

			while(result.next()){
				perfil.setIdPerfil(result.getInt("IDPerfil"));
				perfil.setNombreUsuario(result.getString("nombre"));
				perfil.setApellidos(result.getString("apellidos"));
				perfil.setEdad(result.getInt("edad"));
				perfil.setIdPais(result.getString("IDPais"));
				perfil.setIdPoblacion(result.getString("IDPoblacion"));
				perfil.setMovilOS(result.getString("IDSO2"));
				perfil.setPcOS(result.getString("IDSO1"));
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

		return perfil;
	}

}
