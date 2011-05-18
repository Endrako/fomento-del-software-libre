package test;

import java.util.List;

import pos.data.IUsuarioDAO;
import pos.data.JDBCUsuarioDAO;
import pos.domain.Usuario;

public class TestUser {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Usuario> users;
		Usuario user;
		IUsuarioDAO iuser = new JDBCUsuarioDAO();
		
		users = iuser.recuperarTODOS();
		
		for(Usuario u : users){
			System.out.print("Usuario " + u.getNombreUsuario());
		}
		
		user = iuser.recuperarUsuario("a");
		System.out.print(user.getNombreUsuario());
		
		user = iuser.recuperarUsuarioByIdUsuario("a");
		System.out.print(user.getNombreUsuario());
	}

}
