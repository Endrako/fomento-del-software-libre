package test;

import java.util.Date;

import pos.data.JDBCAplicacionDAO;
import pos.data.JDBCProyectoDAO;
import pos.data.JDBCUsuarioDAO;
import pos.domain.Proyecto;
import pos.domain.ProyectoImpl;
import pos.domain.Usuario;
import pos.utils.FuncionesImpl;

public class TestProyectoJDBC {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		
		JDBCProyectoDAO pDAO = new JDBCProyectoDAO();
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
		// a.setIDAplicacion("2");
		p.setIDProyecto("3");
		p.setAplicacion(aDAO.selectAplicacionByID("5"));
		p.setDescripcionProyecto("Los cerdos merecen su venganza");
		p.setNombreProyecto("Angry pigs");
		p.setDisponibilidad(0);
		/*
		 * TODO MANEJO DE FECHAS
		 */
		java.util.Date today = new java.util.Date();
		java.sql.Date hoy = new java.sql.Date(today.getTime());	
		Date fechaInicio = FuncionesImpl.fechaMas(hoy,0);
		Date fechaFin = FuncionesImpl.fechaMas(hoy,365);
		p.setFechaInicio(fechaInicio);
		p.setFechaFin(fechaFin);

		p.setNivelKarma(50);
		
		Usuario u = uDAO.recuperarUsuarioByNick("marc");
		
		p.toString();
		
		
		pDAO.crearProyecto(p, u);
		
		
		
		
		
	}

}
