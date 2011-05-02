package pos.data;

public class UsuarioBIZ {
	
	private UsuarioDAO userDAO;
	
	/**
	 * 	CONSTRUCTOR DE LA CLASE
	 */
	public UsuarioBIZ(){
		
	}
	
	public boolean comprobarUsuario(String idUser, String password){
		return userDAO.comprobarUsuario(idUser,password);
	}
}
