package pos.data;

import java.util.List;

import pos.domain.Aplicacion;
import pos.domain.Proyecto;

public interface IProyectoDAO {
	
	public List<Proyecto> obtenerTodosProyectos();
	public List<Proyecto> obtenerProyectosAbiertos();
	public void insertarProyecto(Proyecto project);
	public Proyecto obtenerProyectoPorID(Integer idProyecto);
	public void borrarProyecto(Integer idProyecto);
	public List<Aplicacion> obtenerListaAplicacionesDeProyecto(Integer idProyecto);

}