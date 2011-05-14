package pos.data;

import java.util.List;

import pos.domain.Perfil;
import pos.domain.PerfilImpl;

public interface IPerfilDAO {

	public List<Perfil> recuperarPerfiles();
	public Perfil insertarPerfil(Perfil p);
	public Perfil recuperarPerfil(String idPerfil);
	public void borrarPerfil(String idPerfil);
	public void actualizarPerfil(Perfil p);
}
