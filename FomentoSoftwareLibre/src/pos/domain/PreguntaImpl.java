package pos.domain;

public class PreguntaImpl implements Pregunta {
	
	private Integer idPregunta;
	private String enunciado;
	
	@Override
	public Integer getIDPregunta() {
		return idPregunta;
	}

	public void setIDPregunta(Integer id) {
		idPregunta=id;
	}
	

	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String e) {
		enunciado=e;
	}

}
