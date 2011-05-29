package test;

import java.util.Date;
import java.util.List;

import pos.data.JDBCAplicacionDAO;
import pos.data.JDBCProyectoDAO;
import pos.data.JDBCUsuarioDAO;
import pos.domain.Proyecto;
import pos.domain.ProyectoImpl;
import pos.domain.ProyectoStore;
import pos.domain.Usuario;
import pos.utils.FuncionesImpl;

public class TestProyectoJDBC {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		
		ProyectoStore pStore = new ProyectoStore();
		JDBCUsuarioDAO uDAO = new JDBCUsuarioDAO();
		JDBCAplicacionDAO aDAO = new JDBCAplicacionDAO();
		
		/*
		 * Rulz
		 
		List<Proyecto> lp = pDAO.obtenerTodosProyectos();
		for(Proyecto p: lp){
			System.out.println(p.toString());
		}
		*/
		Proyecto p = new ProyectoImpl();
		//a.setIDAplicacion("2");
		p.setIDProyecto("13064321951263b4fd69b");
		p.setAplicacion(aDAO.selectAplicacionByID("5"));
		p.setDescripcionProyecto("Los cerdos merecen su venganza");
		p.setNombreProyecto("Angry pigs");
		p.setDisponibilidad(0);

		// COMO CREAR FECHAS CONCRETAS SIN QUE PETE LA BD!!!
		java.util.Date today = new java.util.Date();
		java.sql.Date hoy = new java.sql.Date(today.getTime());	
		Date fechaInicio = FuncionesImpl.fechaMas(hoy,0);
		Date fechaFin = FuncionesImpl.fechaMas(hoy,365);
		
		p.setFechaInicio(fechaInicio);
		p.setFechaFin(fechaFin);
		p.setNivelKarma(50);
		
		
		Usuario u = uDAO.recuperarUsuarioByNick("francis");
		p.setUsuarioCreador(u);
		
//		OK Proyecto pa = new JDBCProyectoDAO().obtenerProyectoPorID("1306427922189ffffffff9b07f062");
//		System.out.println(pa);
		
		u.setKarma(200);		
		System.out.println(p.getIDProyecto());
		
		//pStore.crearProyecto(p, u); // Y comprobado que no se crean 2 con mismo nombre
		// OK pStore.unirUsuarioAProyecto(p, u);
		 
		 
		// OK pStore.unirUsuarioAProyecto(p, u);
		// OK pStore.borrarUsuarioDeProyecto(p, u);
		
//		OK Aplicacion a = new JDBCProyectoDAO().obtenerAplicacionDeProyecto(p);
//		System.out.println(a.toString());
	
		
//		OK List<Proyecto> abiertosKarma = new ProyectoStore().obtenerProyectosAbiertosPorKarma(u);
//		OK List<Proyecto> creadosUser = new ProyectoStore().obtenerProyectosCreadosPorUsuario(u);
//		System.out.println(abiertosKarma.toString());
		 pStore.borrarProyecto(p);
		
		
		
		
		
	}

}
