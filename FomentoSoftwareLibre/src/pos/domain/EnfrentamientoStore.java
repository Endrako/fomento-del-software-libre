package pos.domain;

import java.util.Date;
import java.util.List;
import java.util.Calendar;
import pos.data.JDBCEnfrentamientoDAO;


public class EnfrentamientoStore {
	
	private static EnfrentamientoStore enfStore;
	private List<Enfrentamiento> enfrentamientos;
	
	public static synchronized EnfrentamientoStore getInstance(){		
		enfStore = new EnfrentamientoStore();		
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
		//validacion
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
		//Validacion de votos	
		if(!listaVotantes.contains(IDUser)){
			enfDAO.votar(IDEnfrentamiento, IDUser, IDAplicacion);
			res = true;
		}
		return res;
	}
	//No se usa
	public void aceptarEnfrentamiento(String IDEnfrentamiento){
		(new JDBCEnfrentamientoDAO()).acceptEnfrentamiento(IDEnfrentamiento);
	}
	//No se usa
	public void borrarEnfrentamiento(Enfrentamiento enfrentamiento){
		new JDBCEnfrentamientoDAO().deleteEnfrentamiento(enfrentamiento);
	}
	
	public List<Enfrentamiento> obtenerEnfrentamientosDeUsuario(String IDUsuario){
		return new JDBCEnfrentamientoDAO().selectEnfrentamientoByUserCreator(IDUsuario);
	}
	//No se usa
	public List<Enfrentamiento> obtenerEnfrentamientosPorFechaFin(java.sql.Date fecha){
		return new JDBCEnfrentamientoDAO().selectEnfrentamientoByDateEnd(fecha);
	}
	//No se usa
	public void finalizarEnfrentamiento(Enfrentamiento enfrentamiento){
		new JDBCEnfrentamientoDAO().finalizarEnfrentamiento(enfrentamiento);
	}
	
	public List<Enfrentamiento> obtenerEnfrentamientosVigentes(){
		return new JDBCEnfrentamientoDAO().selectEnfrentamientosVigentes();
	}
	
	public void finalizarEnfrentamientos(){
		JDBCEnfrentamientoDAO enfDAO = new JDBCEnfrentamientoDAO(); 
		List<Enfrentamiento> enfrentamientosVigentes = enfDAO.selectEnfrentamientosVigentes();
		
		java.sql.Date hoy = fechaDeHoy();
		
		for(Enfrentamiento enfrentamiento: enfrentamientosVigentes){
			if(hoy.getTime()>enfrentamiento.getFechaFin().getTime()){
				enfDAO.finalizarEnfrentamiento(enfrentamiento);
			}
		}
	}
	
	public List<Enfrentamiento> obtenerEnfrentamientosVotadosPorUsuario(Usuario usuario){
		return new JDBCEnfrentamientoDAO().selectEnfrentamientosVotadosPorUsuario(usuario);
	}
	
	public boolean usuarioHaCreadoEnfrentamientoHoy(Usuario usuario){
		JDBCEnfrentamientoDAO enfDAO = new JDBCEnfrentamientoDAO();
		boolean res = false;
		java.sql.Date hoy = fechaDeHoy();
		Calendar cal1 = Calendar.getInstance();
		cal1.setTimeInMillis(hoy.getTime());
		Calendar cal2 = Calendar.getInstance();
		List<Enfrentamiento> enfrentamientosDeUsuario = enfDAO.selectEnfrentamientoByUserCreator(usuario.getIdUser());
		for(Enfrentamiento e:enfrentamientosDeUsuario){
			java.sql.Date fechaCreacion= transformarFechaASQL(e.getFechaCreacion());
			cal2.setTimeInMillis(fechaCreacion.getTime());	
			if((cal1.get(Calendar.DAY_OF_MONTH) == cal2.get(Calendar.DAY_OF_MONTH)) && 
					(cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH) &&
							(cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR)))){
				res = true;
			}
		}
		return res;
	}
	
	public boolean usuarioNoTieneSuficienteKarma(Usuario usuario){
		boolean res = false;
		if(usuario.getKarma()<200){
			res=true;
		}
		return res;
	}
	
	public boolean enfrentamientoTerminado(Enfrentamiento enfrentamiento){
		boolean res = false;
		java.sql.Date hoy = fechaDeHoy();
		java.sql.Date fechaFin = transformarFechaASQL(enfrentamiento.getFechaFin());
		if(fechaFin.before(hoy)){
			res = true;
		}
		return res;
	}
	
	private java.sql.Date transformarFechaASQL(java.util.Date fecha){		
		java.sql.Date hoy = new java.sql.Date(fecha.getTime());
		return hoy;
	}
	
	private java.sql.Date fechaDeHoy(){
		java.util.Date today = new java.util.Date();
		java.sql.Date hoy = new java.sql.Date(today.getTime());
		return hoy;
	}

}
