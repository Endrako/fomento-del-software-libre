package test;


import pos.data.JDBCEnfrentamientoDAO;
import pos.domain.Enfrentamiento;

public class TestEnfrentamientoJDBC {
	
	public static void main (String [] args){
		
		JDBCEnfrentamientoDAO testDAO = new JDBCEnfrentamientoDAO();
		
		Enfrentamiento enfrentamiento = testDAO.selectEnfrentamientoByID("1");
		System.out.println("-----> Método toString <-----");
		System.out.println(enfrentamiento.toString()+"\n");
		
		System.out.println("-----> Propiedades del enfrentamiento <-----");
		System.out.println("IDEnfrentamiento: "+enfrentamiento.getIDEnfrentamiento());
		System.out.println("Aplicacion 1: "+enfrentamiento.getAplicacion1().getNombre());
		System.out.println("Aplicacion 2: "+enfrentamiento.getAplicacion2().getNombre());
		System.out.println("Descripcion: "+enfrentamiento.getDescripcion());
		System.out.println("IDEnfrentamiento: "+enfrentamiento.getIDEnfrentamiento());
		System.out.println("Votos Aplicacion 1: "+enfrentamiento.getVotosAplicacion1());
		System.out.println("Votos Aplicacion 2: "+enfrentamiento.getVotosAplicacion2());
		System.out.println("Fecha Creacion: "+enfrentamiento.getFechaCreacion().toString());
		System.out.println("Fecha Fin: "+enfrentamiento.getFechaFin().toString());
		
		//System.out.println("-----> Inserción de enfrentamiento <-----");
	
		
	}

}
