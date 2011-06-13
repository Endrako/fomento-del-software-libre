package pos.domain;

import java.util.List;

public interface IEncuestaStore {
	
	public boolean insertarEncuesta(Encuesta enc);
	public void borrarEncuesta(String idEncuesta);
	public List<Encuesta>  obtenerEncuestas();
	public Encuesta obtenerEncuesta (String idEncuesta);
	public boolean votarRespuestas(String idRespuesta);
	
}
