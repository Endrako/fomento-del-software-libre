package pos.data;

import java.util.List;

import pos.domain.Aplicacion;

public interface IAplicacionDAO {
	
	public List<Aplicacion> obtenerTodasAplicaciones();
	public void insertarAplicacion(Aplicacion a);
	public Aplicacion obtenerAplicacionPorID(Integer idAplicacion);
	public Aplicacion obtenerAplicacionPorNombre(String nombreAplicacion);
	public List<Aplicacion> obtenerAplicacionesPorTag(Integer idTag);
	public void borrarAplicacionPorID(Integer idAplicacion);

}
