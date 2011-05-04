package test;

import java.util.LinkedList;
import java.util.List;

import pos.data.IVotarDAO;
import pos.data.JDBCVotarDAO;
import pos.domain.Voto;
import pos.domain.VotoImpl;

public class TestVoto {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Voto> lv = new LinkedList<Voto>();
		IVotarDAO vdao = new JDBCVotarDAO();
		lv=vdao.selectAll();
		for(Voto v:lv){
			System.out.print("Voto del usuario " +v.getUsuario() + 
					" de la aplicacion " + v.getAplicacion() + "\n");
		}
		
		
		lv=vdao.selectVotosByUser(3);
		for(Voto v:lv){
			System.out.print("Voto del usuario X " +v.getUsuario() + 
					" de la aplicacion " + v.getAplicacion() + "\n");
		}
		
		
		lv=vdao.selectVotoByAplicacion(2);
		for(Voto v:lv){
			System.out.print("Voto de la aplicacion X " +v.getAplicacion() + 
					" del usuario " + v.getUsuario() + "\n");
		}
		
		Voto v = new VotoImpl();
		v.setAplicacion(4);
		v.setUsuario(5);
		v.setValor(false);
		
		vdao.insertVoto(v);

	}

}
