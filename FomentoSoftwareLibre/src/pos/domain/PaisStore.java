package pos.domain;

import java.util.List;

import pos.data.JDBCPaisDAO;

public class PaisStore {

	private JDBCPaisDAO dao;
	
	public PaisStore(){
		dao = new JDBCPaisDAO();
	}
	
	public List<Pais> recuperarTodosLosPaises(){
		return dao.recuperarPaises();
	}
}
