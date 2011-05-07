package pos.domain;

import java.util.List;


public interface Pregunta {
	
	public Integer getIDPregunta();
	public void setIDPregunta(Integer id); 
	public String getEnunciado();
	public void setEnunciado(String e);
	public List<Respuesta> getRespuestas();
	public void setRespuestas (List<Respuesta> lr);
}
