package pos.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import pos.domain.Usuario;
import pos.domain.UsuarioImpl;

public class JDBCUsuarioDAO implements IUsuarioDAO {

	/**
	 * Atributo que crea la conexion a la bd
	 */
	private ConnectionManager cm;
	
	/**
	 * Constructor de la clase
	 */
	public JDBCUsuarioDAO(){
		cm = ConnectionManager.getInstance();
	}
	
	public boolean comprobarUsuario(String nombreUsuario, String password){
		boolean res = false;
		        PreparedStatement stmt = null;
		        ResultSet result = null;
		        String sql = "SELECT * FROM usuarios WHERE ( nombreUsuario = ? )";

		        try {
		            stmt = cm.checkOut().prepareStatement(sql);
		            stmt.setString(1, nombreUsuario);
		            result = stmt.executeQuery();
		            result.next();
		            if ( result.getString("password").equals(password) ){
		            	res = true;
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
	
	 public UsuarioImpl recuperarUsuario(String idUser) {
	        PreparedStatement stmt = null;
	        ResultSet result = null;
	        UsuarioImpl u = null;
	        String sql = "SELECT * FROM usuarios WHERE (IDUsuario = ?) ";

	        try {
	            stmt = cm.checkOut().prepareStatement(sql);
	            stmt.setString(1, idUser);
	            result = stmt.executeQuery();

	            result.next();
	            u = new UsuarioImpl();
	            u.setEmail(result.getString("email"));
	            u.setContrasena(result.getString("password"));
	            
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
	        return u;
	    }

	@Override
	public void insertarUsuario(UsuarioImpl user) {
		// TODO Auto-generated method stub
	}

	@Override
	public List<UsuarioImpl> recuperarTODOS() {
		// TODO Auto-generated method stub
		return null;
	}
}
