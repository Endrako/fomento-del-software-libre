package pos.data;

import java.util.List;
import com.mysql.jdbc.Connection;
import pos.domain.Enfrentamiento;

public interface IEnfrentamientoDAO {
	
	public List<Enfrentamiento> selectAll();
	public Enfrentamiento selectEnfrentamientoByID(String IDEnfrentamiento);
	public List<Enfrentamiento> selectEnfrentamientoByUserCreator(String IDUser);
	public List<Enfrentamiento> selectEnfrentamientoByAply(String IDAply);
	public List<Enfrentamiento> selectEnfrentamientosAcept();
	public List<Enfrentamiento> selectEnfrentamientosNonAcept();
	public void insertEnfrentamiento(Enfrentamiento enfrentamiento);
	public void deleteEnfrentamiento(Enfrentamiento enfrentamiento);
	

}
