package pos.data;

import java.util.List;

import pos.domain.Pais;
import pos.domain.PaisImpl;

public interface IPaisDAO {

	public List<Pais> recuperarPaises();
}
