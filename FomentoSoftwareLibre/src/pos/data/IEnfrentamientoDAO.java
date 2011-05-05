package pos.data;

import java.util.List;
import com.mysql.jdbc.Connection;
import pos.domain.Enfrentamiento;

public interface IEnfrentamientoDAO {
	
	public List<Enfrentamiento> selectAll(Connection con);
	public Enfrentamiento selectEnfrentamientoByID(Connection con,String IDEnfrentamiento);
	public List<Enfrentamiento> selectEnfrentamientoByUserCreator(Connection con,String IDUser);
	public List<Enfrentamiento> selectEnfrentamientoByAply(Connection con,String IDAply);
	public List<Enfrentamiento> selectEnfrentamientosAcept(Connection con);
	public List<Enfrentamiento> selectEnfrentamientosNonAcept(Connection con);
	public void insertEnfrentamiento(Connection con,Enfrentamiento enfrentamiento);
	public void deleteEnfrentamiento(Connection con,Enfrentamiento enfrentamiento);
	

}
