package pos.domain;

import java.util.List;

public class EncuestaImpl implements Encuesta {
	
	private Integer encuestaID;
	private String titulo;
	private List<Pregunta> lp;
	
	
	public Integer getEncuestaId() {
		return encuestaID;
	}

	public String getTituloEncuesta() {
		return titulo;
	}

	public void setTituloEncuesta(String t) {
		titulo=t;
	}

	public void setEncuestaID(Integer id) {
		encuestaID=id;
	}

	@Override
	public List<Pregunta> getPreguntas() {
		return lp;
	}

	@Override
	public void setPreguntas(List<Pregunta> lpreg) {
		lp=lpreg;
	}

}
