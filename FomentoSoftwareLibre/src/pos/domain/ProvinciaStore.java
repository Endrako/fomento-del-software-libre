package pos.domain;

import java.util.List;

import pos.data.IProvinciaDAO;
import pos.data.JDBCProvinciaDAO;

public class ProvinciaStore implements IProvinciaDAO {

	JDBCProvinciaDAO dao = new JDBCProvinciaDAO();
	@Override
	public List<Provincia> recuperarTodasLasProvincias() {
		// TODO Auto-generated method stub
		return dao.recuperarTodasLasProvincias();
	}

}
