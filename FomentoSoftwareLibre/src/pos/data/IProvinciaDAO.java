package pos.data;

import java.util.List;

import pos.domain.Provincia;
import pos.domain.ProvinciaImpl;

public interface IProvinciaDAO {

	public List<Provincia> recuperarTodasLasProvincias();
}
