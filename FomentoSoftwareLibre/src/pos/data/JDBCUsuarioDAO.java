package pos.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pos.domain.Perfil;
import pos.domain.PerfilImpl;
import pos.domain.PerfilStore;
import pos.domain.Usuario;
import pos.domain.UsuarioImpl;
import pos.utils.UIDGenerator;

public class JDBCUsuarioDAO implements IUsuarioDAO {

	/**
	 * Atributo que crea la conexion a la bd
	 */
	private ConnectionManager cm;
	
	/**
	 * Constructor de la clase
	 */
	public JDBCUsuarioDAO(){
		cm = (ConnectionManager) ConnectionManager.getInstance();
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
	            u.setIdUser(result.getInt("IDUser"));
	            
	            // Recuperamos el Perfil Ante de Devolverlo
	            PerfilStore perfilS = new PerfilStore();
	            u.setPerfilUser(result.getInt("IDPerfil"));
	           
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
	// TODO: METODO INSERTAR USUARIO
	public void insertarUsuario(Usuario user) {
		String sql = "INSERT INTO usuarios (IDUsuario,nombreUsuario,password,email,IDPerfil) VALUES (?,?,?,?,?) ";
		PreparedStatement stmt = null;
		ResultSet result = null;
		
		try {
			stmt = cm.checkOut().prepareStatement(sql);
			
			stmt.setInt(1, UIDGenerator.getInstance().getKey());
			stmt.setString(2, user.getNombreUsuario());
			stmt.setString(3, user.getContrasena());
			stmt.setString(4, user.getEmail());
			stmt.setInt(5, 1);
		
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
	public List<Usuario> recuperarTODOS() {
		List<Usuario> p = new ArrayList<Usuario>();
		String sql = "SELECT * FROM usuarios";
		PreparedStatement stmt = null;
		ResultSet result = null;
		
		try {
			stmt = cm.checkOut().prepareStatement(sql);
			result = stmt.executeQuery();

			while(result.next()){
				Usuario u = new UsuarioImpl();
		        u.setEmail(result.getString("email"));
		        u.setContrasena(result.getString("password"));
		        u.setIdUser(result.getInt("IDUser"));
		            
		        // Recuperamos el Perfil Ante de Devolverlo
		        PerfilStore perfilS = new PerfilStore();
		        u.setPerfilUser(result.getInt("IDPerfil"));
				p.add(u);
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
