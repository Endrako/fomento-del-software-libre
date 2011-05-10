package test;


import java.sql.Date;
import pos.data.JDBCAplicacionDAO;
import pos.data.JDBCEnfrentamientoDAO;
import pos.domain.Aplicacion;
import pos.domain.Enfrentamiento;
import pos.domain.EnfrentamientoImpl;
import pos.domain.EnfrentamientoStore;

public class TestEnfrentamientoJDBC {
	
	public static void main (String [] args){
		
		JDBCEnfrentamientoDAO testDAO = new JDBCEnfrentamientoDAO();
		JDBCAplicacionDAO aplyTestDAO = new JDBCAplicacionDAO();
		Enfrentamiento enfrentamiento = testDAO.selectEnfrentamientoByID("1");
		
		EnfrentamientoStore store = EnfrentamientoStore.getInstance();
		
//		List<Enfrentamiento> lista = testDAO.selectAll();
//		for(Enfrentamiento e:lista){
//			System.out.println(e.toString());
//		}
		
//		System.out.println("-----> Método toString <-----");
//		System.out.println(enfrentamiento.toString()+"\n");
//		
//		System.out.println("-----> Propiedades del enfrentamiento <-----");
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
//		Aplicacion aplicacion1 = aplyTestDAO.selectAplicacionByID("1");
//		Aplicacion aplicacion2 = aplyTestDAO.selectAplicacionByID("2");
//		Enfrentamiento enfrentamiento2 = new EnfrentamientoImpl();
//		enfrentamiento2.setAplicacion1(aplicacion1);
//		enfrentamiento2.setAplicacion2(aplicacion2);
//		enfrentamiento2.setDescripcion("El enfrentamiento del siglo! Esten atentos para ver \n cual de los dos colosos saldra triunfante");
//		enfrentamiento2.setFechaCreacion(new Date(3, 3, 03));
//		enfrentamiento2.setFechaFin(new Date(12,12,12));
//		enfrentamiento2.setVotosAplicacion1(0);
//		enfrentamiento2.setVotosAplicacion2(0);
//		
//		testDAO.insertEnfrentamiento(enfrentamiento2);
//		
//		System.out.println(testDAO.selectEnfrentamientoByID("2"));
		
//		store.votar(enfrentamiento.getIDEnfrentamiento(),"1","1");
		
		Aplicacion aplicacion3 = aplyTestDAO.selectAplicacionByID("1");
		Aplicacion aplicacion4 = aplyTestDAO.selectAplicacionByID("3");
		Enfrentamiento enfrentamiento3 = new EnfrentamientoImpl();
		enfrentamiento3.setAplicacion1(aplicacion3);
		enfrentamiento3.setAplicacion2(aplicacion4);
		enfrentamiento3.setDescripcion("El enfrentamiento del siglo! Esten atentos para ver \n cual de los dos colosos saldra triunfante");
		enfrentamiento3.setFechaCreacion(new Date(3, 3, 03));
		enfrentamiento3.setFechaFin(new Date(12,12,12));
		enfrentamiento3.setVotosAplicacion1(0);
		enfrentamiento3.setVotosAplicacion2(0);
		
		Date fechaInicio = new Date(3, 3, 03);
		Date fechaFin = new Date(12,12,12);
		String desc = "El enfrentamiento del siglo! Esten atentos para ver \n cual de los dos colosos saldra triunfante";
		//store.crearEnfrentamiento(aplicacion3, aplicacion4, desc, fechaInicio, fechaFin);
		
		store.crearEnfrentamiento(aplicacion4, aplicacion3, desc, fechaInicio, fechaFin);

//		for(Usuario u:testDAO.getUsuariosPorEnfrentamiento(enfrentamiento.getIDEnfrentamiento())){
//			System.out.println(u.getNombreUsuario());
//		}
		
		
//		System.out.println("-----> Votacion <-----");
//		
//		testDAO.votar(enfrentamiento.getIDEnfrentamiento(), "1", "1");
//		System.out.println("Votos Aplicacion 1: "+enfrentamiento.getVotosAplicacion1());
//		System.out.println("Votos Aplicacion 2: "+enfrentamiento.getVotosAplicacion2());
	
		
	}

}
