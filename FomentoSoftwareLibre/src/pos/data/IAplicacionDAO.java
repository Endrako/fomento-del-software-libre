package pos.data;

import java.util.List;

import pos.domain.Aplicacion;
import pos.domain.Tag;

public interface IAplicacionDAO {

	public List<Aplicacion> selectAll();
	public void insertAplicacion(Aplicacion aplicacion);
	public Aplicacion selectAplicacionByID(String IDAplicacion);
	public Aplicacion selectAplicacionByName(String name);
	public List<Aplicacion> selectAplicationByTag(String IDTag);
	public void deleteAplication(Aplicacion aplicacion);
//	public List<Aplicacion> selectAplicationsByTags (List<Tag> tags);
}
