package pos.domain;

import java.util.List;

public interface IEncuestaStore {
	
	public void insertarEncuesta(Encuesta enc);
	public void borrarEncuesta(String idEncuesta);
	public void borrarPregunta(Integer idPregunta);
	public void borrarRespuesta(Integer idRespuesta);
	public void modificarPregunta(Integer idPregunta);
	public void modificarRespuesta(Integer idRespuesta);
	public List<Encuesta>  obtenerEncuestas();
	public List<Pregunta> obtenerPreguntas(Integer idEncuesta);
	public List<Respuesta> obtenerRespuestas(Integer idPregunta);
	public Integer obtenerIDEncuesta(Encuesta enc);
	public Integer obtenerIDPregunta(Pregunta preg);
	public Integer obtenerIDRespuesta(Respuesta res);
	
}
