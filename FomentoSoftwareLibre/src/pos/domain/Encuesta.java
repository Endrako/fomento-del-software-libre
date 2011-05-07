package pos.domain;

import java.util.List;

public interface Encuesta {
	
	public Integer getEncuestaId();
	public void setEncuestaID(Integer id);
	public String getTituloEncuesta();
	void setTituloEncuesta(String t);
	public List<Pregunta> getPreguntas();
	public void setPreguntas(List<Pregunta> lp);
	
}
