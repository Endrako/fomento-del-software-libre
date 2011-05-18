package test;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import pos.data.JDBCAplicacionDAO;
import pos.data.JDBCProyectoDAO;
import pos.data.JDBCUsuarioDAO;
import pos.domain.Aplicacion;
import pos.domain.Proyecto;

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
		Proyecto p = null;
		Aplicacion a = null;
		a.setIDAplicacion("2");
		p.setIDProyecto("3");
		p.setAplicacion(a);
		p.setDescripcionProyecto("Los cerdos merecen su venganza");
		p.setNombreProyecto("Angry pigs");
		p.setDisponibilidad(false);
		p.setFechaInicio(new Date(2011, 9, 25));
		p.setFechaFin(new Date(2012, 9, 25));
		
		p.toString();
		
		
		pDAO.crearProyecto(p);
		
		
		
		
		
	}

}
