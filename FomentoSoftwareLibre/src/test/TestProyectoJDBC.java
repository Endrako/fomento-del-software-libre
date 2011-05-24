package test;

import java.util.Date;

import pos.data.JDBCAplicacionDAO;
import pos.data.JDBCProyectoDAO;
import pos.data.JDBCUsuarioDAO;
import pos.domain.Aplicacion;
import pos.domain.AplicacionImpl;
import pos.domain.Proyecto;
import pos.domain.ProyectoImpl;
import pos.domain.Usuario;
import pos.domain.UsuarioImpl;

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
		Aplicacion a = new AplicacionImpl();
		a.setIDAplicacion("2");
		p.setIDProyecto("3");
		p.setAplicacion(a);
		p.setDescripcionProyecto("Los cerdos merecen su venganza");
		p.setNombreProyecto("Angry pigs");
		p.setDisponibilidad(0);
		p.setFechaInicio(new Date(2011, 9, 25));
		p.setFechaFin(new Date(2012, 9, 25));
		
		Usuario u = uDAO.recuperarUsuarioByNick("marc");
		
		p.toString();
		
		
		pDAO.crearProyecto(p, u);
		
		
		
		
		
	}

}
