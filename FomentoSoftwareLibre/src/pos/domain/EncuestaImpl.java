package pos.domain;

import java.util.List;

public class EncuestaImpl implements Encuesta {
	
	private String encuestaID;
	private String usuario;
	private String titulo;
	private List<Pregunta> lp;
	
	
	public String getEncuestaId() {
		return encuestaID;
	}

	public String getTituloEncuesta() {
		return titulo;
	}

	public void setTituloEncuesta(String t) {
		titulo=t;
	}

	public void setEncuestaID(String id) {
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

	@Override
	public String getUsuario() {
		return usuario;
	}

	@Override
	public void setUsuario(String user) {
		usuario=user;
	}

}
