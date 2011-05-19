package pos.data;

import java.util.List;

import pos.domain.Aplicacion;
import pos.domain.Enfrentamiento;
import pos.domain.Usuario;

public interface IEnfrentamientoDAO {
	
	public List<Enfrentamiento> selectAll();
	public Enfrentamiento selectEnfrentamientoByID(String IDEnfrentamiento);
	public List<Enfrentamiento> selectEnfrentamientoByUserCreator(String IDUser);
	public List<Enfrentamiento> selectEnfrentamientoByAply(String IDAply);
	public List<Enfrentamiento> selectEnfrentamientosAcept();
	public List<Enfrentamiento> selectEnfrentamientosNonAcept();
	public void insertEnfrentamiento(Enfrentamiento enfrentamiento,Usuario usuario);
	public void deleteEnfrentamiento(Enfrentamiento enfrentamiento);
	public void acceptEnfrentamiento(String IDEnfrentamiento);
	public Enfrentamiento getEnfrentamientoByAplications(Aplicacion aply1, Aplicacion aply2);
	public void votar(String IDEnfrentamiento,String IDUser,String IDAplicacion);
	public List<Usuario> getUsuariosPorEnfrentamiento(String IDEnfrentamiento);
	public List<String> getIDUsuariosVotantes(String IDEnfrentamiento);
	

}
