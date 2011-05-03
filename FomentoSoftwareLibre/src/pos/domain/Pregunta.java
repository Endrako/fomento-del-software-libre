package pos.domain;

import java.util.List;


public interface Pregunta {
	
	public Integer getIDPregunta();
	public Integer getIDEncuesta(); 
	public String getEnunciado();
	public String setEnunciado();
	public List<Respuesta> getRespuestas();
}
