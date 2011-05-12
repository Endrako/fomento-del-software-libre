package pos.domain;

import java.util.List;

public interface Encuesta {
	
	public String getEncuestaId();
	public void setEncuestaID(String id);
	public String getTituloEncuesta();
	void setTituloEncuesta(String t);
	public List<Pregunta> getPreguntas();
	public void setPreguntas(List<Pregunta> lp);
	
}
