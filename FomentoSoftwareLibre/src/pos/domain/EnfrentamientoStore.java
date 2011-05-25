package pos.domain;

import java.util.Date;
import java.util.List;

import pos.data.JDBCEnfrentamientoDAO;


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
	
	public boolean crearEnfrentamiento(Aplicacion aply1,Aplicacion aply2,String descripcion,Date fechaInicio,Date fechaFin,Usuario usuario){
		boolean res=true;
		Enfrentamiento enfrentamiento = new EnfrentamientoImpl();
		enfrentamiento.setAplicacion1(aply1);
		enfrentamiento.setAplicacion2(aply2);
		enfrentamiento.setDescripcion(descripcion);
		enfrentamiento.setFechaCreacion(fechaInicio);
		enfrentamiento.setFechaFin(fechaFin);
		if(!enfrentamientos.contains(enfrentamiento)){
			(new JDBCEnfrentamientoDAO()).insertEnfrentamiento(enfrentamiento,usuario);
		}else{
			res=false;
		}
		return res;
	}
	
	public boolean votar(String IDEnfrentamiento,String IDUser,String IDAplicacion){
		boolean res = false;
		JDBCEnfrentamientoDAO enfDAO = new JDBCEnfrentamientoDAO();
		List<String> listaVotantes = enfDAO.getIDUsuariosVotantes(IDEnfrentamiento);
				
		if(!listaVotantes.contains(IDUser)){
			enfDAO.votar(IDEnfrentamiento, IDUser, IDAplicacion);
			res = true;
		}
		return res;
	}
	
	public void aceptarEnfrentamiento(String IDEnfrentamiento){
		(new JDBCEnfrentamientoDAO()).acceptEnfrentamiento(IDEnfrentamiento);
	}
	
	public void borrarEnfrentamiento(Enfrentamiento enfrentamiento){
		new JDBCEnfrentamientoDAO().deleteEnfrentamiento(enfrentamiento);
	}
	
	public List<Enfrentamiento> obtenerEnfrentamientosDeUsuario(String IDUsuario){
		return new JDBCEnfrentamientoDAO().selectEnfrentamientoByUserCreator(IDUsuario);
	}
	
	public List<Enfrentamiento> obtenerEnfrentamientosPorFechaFin(java.sql.Date fecha){
		return new JDBCEnfrentamientoDAO().selectEnfrentamientoByDateEnd(fecha);
	}
	
	public void finalizarEnfrentamiento(Enfrentamiento enfrentamiento){
		new JDBCEnfrentamientoDAO().finalizarEnfrentamiento(enfrentamiento);
	}
	
	public List<Enfrentamiento> obtenerEnfrentamientosVigentes(){
		return new JDBCEnfrentamientoDAO().selectEnfrentamientosVigentes();
	}
	
	public void finalizarEnfrentamientos(){
		JDBCEnfrentamientoDAO enfDAO = new JDBCEnfrentamientoDAO(); 
		List<Enfrentamiento> enfrentamientosVigentes = enfDAO.selectEnfrentamientosVigentes();
		
		java.util.Date today = new java.util.Date();
		java.sql.Date hoy = new java.sql.Date(today.getTime());
		
		for(Enfrentamiento enfrentamiento: enfrentamientosVigentes){
			if(hoy.getTime()>enfrentamiento.getFechaFin().getTime()){
				enfDAO.finalizarEnfrentamiento(enfrentamiento);
			}
		}
	}
	
	public List<Enfrentamiento> obtenerEnfrentamientosVotadosPorUsuario(Usuario usuario){
		return new JDBCEnfrentamientoDAO().selectEnfrentamientosVotadosPorUsuario(usuario);
	}
	

}
