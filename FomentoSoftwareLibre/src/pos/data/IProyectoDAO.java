package pos.data;

import java.util.List;

import pos.domain.Proyecto;

public interface IProyectoDAO {
	
	public List<Proyecto> obtenerTodosProyectos();
	public List<Proyecto> obtenerProyectoAbierto();
	public void insertarProyecto(Proyecto project);
	public Proyecto obtenerProyectoPorID(Integer idProyect);
	public void borrarProyecto(Integer idProyect);

}