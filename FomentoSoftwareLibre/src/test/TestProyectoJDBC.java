package test;

import java.util.Date;
import java.util.List;

import pos.data.JDBCAplicacionDAO;
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
		p.setIDProyecto("13063112828323e1353ff");
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
		System.out.println(u.getIdUser());

		
		//u.setKarma(50);		
		
		// pStore.crearProyecto(p, u);
		//pStore.unirUsuarioAProyecto(p, u);
		// pStore.borrarUsuarioDeProyecto(p, u);
		
//		Aplicacion a = new JDBCProyectoDAO().obtenerAplicacionDeProyecto(p);
//		System.out.println(a.toString());
	
		List<Proyecto> abiertosKarma = new ProyectoStore().obtenerProyectosAbiertosPorKarma(u);
		System.out.println(abiertosKarma.toString());
		
		
		
		
		
	}

}
