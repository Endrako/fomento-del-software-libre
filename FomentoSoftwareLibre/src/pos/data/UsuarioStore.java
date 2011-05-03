package pos.data;

import java.util.List;

import pos.domain.UsuarioImpl;

public class UsuarioStore {
	
	private JDBCUsuarioDAO userDAO;
	
	/**
	 * 	CONSTRUCTOR DE LA CLASE
	 */
	public UsuarioStore(){
		userDAO = new JDBCUsuarioDAO();
	}
	
	public boolean comprobarUsuario(String idUser, String password){
		return userDAO.comprobarUsuario(idUser,password);
	}
	
	public UsuarioImpl recuperarUsuario(String idUser){
		return (UsuarioImpl) userDAO.recuperarUsuario(idUser);
	}
	
	public void insertarUsuario(UsuarioImpl user){
		userDAO.insertarUsuario(user);
	}
	
	public List<UsuarioImpl> recuperarTODOS(){
		return userDAO.recuperarTODOS();
	}
}
