package pos.domain;

import java.util.List;

import pos.data.JDBCAplicacionDAO;

public class AplicacionStore {
	
	private static AplicacionStore repositorio;
	private List<Aplicacion> aplicaciones;
	
	public static synchronized AplicacionStore getInstance(){
		if(repositorio == null){
			repositorio = new AplicacionStore();
		}
		return repositorio;
	}
	
	private AplicacionStore(){
		aplicaciones = (new JDBCAplicacionDAO()).selectAll();
	}
	
	public List<Aplicacion> getAplicaciones(){
		return aplicaciones;
	}
	
	public Aplicacion getAplicacion(String aplyId){
		return (new JDBCAplicacionDAO()).selectAplicacionByID(aplyId);
	}
	
//	public Anuncio getAnuncioAply(String aplyId){
//		return ;
//	}
	
	//Cambiado tagname:String por tag:Tag
	public List<Aplicacion> getAplicationByTag(Tag tag){
		//Putadon dar un nombre del tag en vez de dar un Objeto tag:Implica hacer métodos nuevos.
		return (new JDBCAplicacionDAO()).selectAplicationByTag(tag.getIdTag());
	}
}
