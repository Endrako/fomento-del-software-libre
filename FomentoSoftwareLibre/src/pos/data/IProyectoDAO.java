package pos.data;

import java.util.List;

import pos.domain.Aplicacion;
import pos.domain.Proyecto;

public interface IProyectoDAO {
	
	public List<Proyecto> obtenerTodosProyectos();
	public List<Proyecto> obtenerProyectosAbiertos();
	public void insertarProyecto(Proyecto project);
	public Proyecto obtenerProyectoPorID(String idProyecto);
	public void borrarProyecto(String idProyecto);
	
	// Un proyecto no tiene N aplicaciones, solo tiene 1. No existen proyectos de varias apps a la vez
	
	public Aplicacion obtenerAplicacionDeProyecto(String idProyecto);

}