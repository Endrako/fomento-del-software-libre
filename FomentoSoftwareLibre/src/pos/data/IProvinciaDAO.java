package pos.data;

import java.util.List;

import pos.domain.ProvinciaImpl;

public interface IProvinciaDAO {

	public List<ProvinciaImpl> recuperarTodasLasProvincias();
}
