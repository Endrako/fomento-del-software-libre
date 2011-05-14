package pos.data;

import java.util.List;

import pos.domain.Usuario;

public interface IUsuarioDAO {

	public boolean comprobarUsuario(String idUser, String password);
	public Usuario recuperarUsuario(String idUser);
	public Usuario recuperarUsuarioByIdUsuario(String idUser);
	public void insertarUsuario(Usuario user);
	public List<Usuario> recuperarTODOS();
	public void borrarUsuario(String idUsuario);
	public Usuario recuperarUsuarioByNick(String nick);
	
}
