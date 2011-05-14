package pos.domain;

import java.util.List;

import pos.data.IPerfilDAO;
import pos.data.JDBCPerfilDAO;

public class PerfilStore implements IPerfilDAO{

	public JDBCPerfilDAO dao;
	
	public PerfilStore(){
		dao = new JDBCPerfilDAO();
	}

	@Override
	public List<Perfil> recuperarPerfiles() {
		return dao.recuperarPerfiles();
	}

	@Override
	public Perfil insertarPerfil(Perfil p) {
		return dao.insertarPerfil(p);
	}

	@Override
	public Perfil recuperarPerfil(String idPerfil) {
		return dao.recuperarPerfil(idPerfil);
	}
	
	public void borrarPerfil(String idPerfil){
		dao.borrarPerfil(idPerfil);
	}
	
	public void actualizarPerfil(Perfil per){
		dao.actualizarPerfil(per);
	}	
}
