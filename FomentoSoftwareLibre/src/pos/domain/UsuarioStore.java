package pos.domain;

import pos.data.JDBCUsuarioDAO;

public class UsuarioStore {
	
	private JDBCUsuarioDAO userDAO;
	
	/**
	 * 	CONSTRUCTOR DE LA CLASE
	 */
	public UsuarioStore(){
		
	}
	
	public boolean comprobarUsuario(String idUser, String password){
		return userDAO.comprobarUsuario(idUser,password);
	}
}
