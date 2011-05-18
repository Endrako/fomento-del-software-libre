package pos.domain;

import java.util.List;

import pos.data.JDBCVotarDAO;

public class VotoStore {
	private static VotoStore votoStore;
	private List<Voto> votos;
	private JDBCVotarDAO votoDAO = new JDBCVotarDAO();
	
	public static synchronized VotoStore getInstance(){
		if(votoStore ==null){
			votoStore = new VotoStore();
		}
		return votoStore;
	}
	
	private VotoStore(){
		votos =(new JDBCVotarDAO()).selectAll();
	}
	
	public List<Voto> getVotos(){
		return votos;
	}
	
	public Voto getVotoByIDVoto(String IDVoto){
		return votoDAO.selectVotoByID(IDVoto);
	}
	
	public List<Voto> getVotoByIDUser(String IDUser){
		return votoDAO.selectVotosByUser(IDUser);
	}
	
	public List<Voto> getVotoByAplicacion(String IDApli){
		return votoDAO.selectVotoByAplicacion(IDApli);
	}	
	
	public void crearVoto(String IDVoto, String IDUser, String IDApli, Boolean valor){
		Voto voto = new VotoImpl();
		voto.setIDVoto(IDVoto);
		voto.setUsuario(IDUser);
		voto.setAplicacion(IDApli);
		voto.setValor(valor);
		
		votoDAO.insertVoto(voto);
	}
	
	//Funcion para saber si un usuario ha votado ya a una aplicacion.
	public Boolean isVoto(String IDUser, String IDApli){
		Boolean res = true;
		List<Voto> votosuser = votoDAO.selectVotosByUser(IDUser);
		for(Voto v: votosuser){
			if(v.getAplicacion().equals(IDApli)){
				res = false;
				break;
			}
		}
		return res;
	}	

}
