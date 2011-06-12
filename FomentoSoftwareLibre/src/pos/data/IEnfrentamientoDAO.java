package pos.data;

import java.util.List;
import pos.domain.Enfrentamiento;
import pos.domain.Usuario;

public interface IEnfrentamientoDAO {
	
	public List<Enfrentamiento> selectAll();
	public Enfrentamiento selectEnfrentamientoByID(String IDEnfrentamiento);
	public List<Enfrentamiento> selectEnfrentamientoByUserCreator(String IDUser);
	public void insertEnfrentamiento(Enfrentamiento enfrentamiento,Usuario usuario);
	public void votar(String IDEnfrentamiento,String IDUser,String IDAplicacion);
	public List<String> getIDUsuariosVotantes(String IDEnfrentamiento);
	public List<Enfrentamiento> selectEnfrentamientosVigentes();
	public List<Enfrentamiento> selectEnfrentamientosVotadosPorUsuario(Usuario usuario);
	

}
