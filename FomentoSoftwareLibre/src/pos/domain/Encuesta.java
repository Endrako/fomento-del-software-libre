package pos.domain;

import java.util.List;

public interface Encuesta {
	
	public String getEncuestaId();
	public String getTituloEncuesta();
	public void setTituloEncuesta();
	public List<Pregunta> getPreguntas();
	
}
