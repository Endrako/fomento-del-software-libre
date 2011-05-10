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
	public List<PerfilImpl> recuperarPerfiles() {
		return dao.recuperarPerfiles();
	}

	@Override
	public void insertarPerfil(Perfil p) {
		dao.insertarPerfil(p);
	}

	@Override
	public Perfil recuperarPerfil(int idPerfil) {
		return dao.recuperarPerfil(idPerfil);
	}
	
	
	
	
}
