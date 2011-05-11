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
		            if ( result.getString("contrasenna").equals(password) ){
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
	            u.setContrasena(result.getString("contrasenna"));
	            u.setIdUser(result.getString("IDUser"));
	            u.setNombreUsuario(result.getString("nombreCompleto"));
	            
	            // Recuperamos el Perfil
	            IPerfilDAO daoP = new JDBCPerfilDAO();
	            u.setPerfil(daoP.recuperarPerfil(result.getString("IDPerfil")));
	            
	           
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

	public void insertarUsuario(Usuario user) {
		String sql = "INSERT INTO usuarios (IDUser,nombreUsuario,contrasenna,email,IDPerfil) VALUES (?,?,?,?,?) ";
		PreparedStatement stmt = null;
		
		try {
			stmt = cm.checkOut().prepareStatement(sql);
	
			stmt.setString(1, UIDGenerator.getInstance().getKey());
			stmt.setString(2, user.getNombreUsuario());
			stmt.setString(3, user.getContrasena());
			stmt.setString(4, user.getEmail());
			stmt.setString(5, "");
		
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
		            u.setContrasena(result.getString("contrasenna"));
		            u.setIdUser(result.getString("IDUser"));
		            u.setNombreUsuario(result.getString("nombreCompleto"));
		            
		            // Recuperamos el Perfil
		            IPerfilDAO daoP = new JDBCPerfilDAO();
		            u.setPerfil(daoP.recuperarPerfil(result.getString("IDPerfil")));
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
	
	public void borrarUsuario(String idUsuario) {
		
		String sql = "DELETE FROM encuestas WHERE (IDUsuario = ?) ";
        PreparedStatement stmt = null;

        try {
            stmt = cm.checkOut().prepareStatement(sql);
            stmt.setString(1, idUsuario);
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
