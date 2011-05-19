package pos.data;

import java.util.List;

import pos.domain.Aplicacion;
import pos.domain.Proyecto;
import pos.domain.Usuario;

public interface IProyectoDAO {
	
	public List<Proyecto> obtenerTodosProyectos();
	public List<Proyecto> obtenerProyectosAbiertos();
	public void crearProyecto(Proyecto proyecto);
	public Proyecto obtenerProyectoPorID(String idProyecto);
	public Aplicacion obtenerAplicacionDeProyecto(Proyecto p);
	public void borrarProyecto(Proyecto p);
	public void borrarAsociacionUsuariosConProyecto(Proyecto p);	
	public boolean existeTuplaUsuarioProyecto(Usuario u,Proyecto p);
	public void asociarProyectoAUsuario(Usuario u,Proyecto p);
	
}