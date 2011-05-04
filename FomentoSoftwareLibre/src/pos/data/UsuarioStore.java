package pos.data;

import java.util.List;

import pos.domain.Usuario;

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
	
	public Usuario recuperarUsuario(String idUser){
		return (Usuario) userDAO.recuperarUsuario(idUser);
	}
	
	public void insertarUsuario(Usuario user){
		userDAO.insertarUsuario(user);
	}
	
	public List<Usuario> recuperarTODOS(){
		return userDAO.recuperarTODOS();
	}
}
