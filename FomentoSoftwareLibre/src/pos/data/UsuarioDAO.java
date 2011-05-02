package pos.data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {

	/**
	 * Atributo que crea la conexion a la bd
	 */
	private ConnectionManager cm;
	
	/**
	 * Constructor de la clase
	 */
	public UsuarioDAO(){
		cm = ConnectionManager.getInstance();
	}
	
	public boolean comprobarUsuario(String idUser, String password){
		boolean res = false;
		        PreparedStatement stmt = null;
		        ResultSet result = null;
		        String sql = "SELECT * FROM Usuario WHERE (IDUsuario = ?) AND ( password = ? )";

		        try {
		            stmt = cm.checkOut().prepareStatement(sql);
		            stmt.setString(1, idUser);
		            stmt.setString(2,password);
		            result = stmt.executeQuery();
		            if ( result != null ){
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
}
