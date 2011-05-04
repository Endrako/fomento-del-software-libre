package pos.data;

import java.util.List;

import pos.domain.Aplicacion;
import pos.domain.Enfrentamiento;

public interface IEnfrentamientoDAO {
	
	public List<Enfrentamiento> selectAll();
	public Enfrentamiento selectEnfrentamientoByID(ConnectionManager con,String IDEnfrentamiento);
	public List<Enfrentamiento> selectEnfrentamientoByUserCreator(ConnectionManager con,String IDUser);
	public List<Enfrentamiento> selectEnfrentamientoByAply(ConnectionManager con,String IDAply);
	public List<Enfrentamiento> selectEnfrentamientosAcept(ConnectionManager con);
	public List<Enfrentamiento> selectEnfrentamientosNonAcept(ConnectionManager con);
	public void insertEnfrentamiento(ConnectionManager con,Enfrentamiento enfrentamiento);
	public void deleteEnfrentamiento(ConnectionManager con,Enfrentamiento enfrentamiento);
	

}
