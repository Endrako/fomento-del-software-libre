package pos.domain;

import java.util.Date;
import java.util.List;

import pos.data.JDBCEnfrentamientoDAO;
import pos.data.JDBCUsuarioDAO;


public class EnfrentamientoStore {
	
	private static EnfrentamientoStore enfStore;
	private List<Enfrentamiento> enfrentamientos;
	
	public static synchronized EnfrentamientoStore getInstance(){
		if(enfStore ==null){
			enfStore = new EnfrentamientoStore();
		}
		return enfStore;
	}
	
	private EnfrentamientoStore(){
		enfrentamientos =(new JDBCEnfrentamientoDAO()).selectAll();
	}
	
	public List<Enfrentamiento> getEnfrentamientos(){
		return enfrentamientos;
	}
	
	public Enfrentamiento getEnfrentamiento(String enfrenID){
		return (new JDBCEnfrentamientoDAO()).selectEnfrentamientoByID(enfrenID);
	}
	
	public void crearEnfrentamiento(Aplicacion aply1,Aplicacion aply2,String descripcion,Date fechaInicio,Date fechaFin){
		Enfrentamiento enfrentamiento = new EnfrentamientoImpl();
		enfrentamiento.setAplicacion1(aply1);
		enfrentamiento.setAplicacion2(aply2);
		enfrentamiento.setDescripcion(descripcion);
		enfrentamiento.setFechaCreacion(fechaInicio);
		enfrentamiento.setFechaFin(fechaFin);
		if(!enfrentamientos.contains(enfrentamiento)){
			(new JDBCEnfrentamientoDAO()).insertEnfrentamiento(enfrentamiento);
		}else{
			System.out.println("Que este ya estaaa, hostiaaa");
		}
	}
	
	public void votar(String IDEnfrentamiento,String IDUser,String IDAplicacion){
		JDBCEnfrentamientoDAO enfDAO = new JDBCEnfrentamientoDAO();
		List<String> listaVotantes = enfDAO.getIDUsuariosVotantes(IDEnfrentamiento);
				
		if(!listaVotantes.contains(IDUser)){
			enfDAO.votar(IDEnfrentamiento, IDUser, IDAplicacion);
		}
	}
	
	public void aceptarEnfrentamiento(String IDEnfrentamiento){
		(new JDBCEnfrentamientoDAO()).acceptEnfrentamiento(IDEnfrentamiento);
	}
	
	public void borrarEnfrentamiento(Enfrentamiento enfrentamiento){
		new JDBCEnfrentamientoDAO().deleteEnfrentamiento(enfrentamiento);
	}
	

}
