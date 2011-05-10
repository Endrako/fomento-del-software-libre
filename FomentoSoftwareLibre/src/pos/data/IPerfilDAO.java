package pos.data;

import java.util.List;

import pos.domain.Perfil;
import pos.domain.PerfilImpl;

public interface IPerfilDAO {

	public List<PerfilImpl> recuperarPerfiles();
	public void insertarPerfil(Perfil p);
	public Perfil recuperarPerfil(int idPerfil);
}
