package pos.data;

import java.util.List;

import pos.domain.UsuarioImpl;

public interface IUsuarioDAO {

	public boolean comprobarUsuario(String idUser, String password);
	public UsuarioImpl recuperarUsuario(String idUser);
	public void insertarUsuario(UsuarioImpl user);
	public List<UsuarioImpl> recuperarTODOS();
	
}
