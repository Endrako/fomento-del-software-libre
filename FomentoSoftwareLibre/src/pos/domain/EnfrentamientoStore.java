package pos.domain;

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
	

}
