package pos.domain;

import java.util.List;

public class PreguntaImpl implements Pregunta {
	
	private Integer idPregunta;
	private String enunciado;
	private List<Respuesta> lr;
	
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

	@Override
	public List<Respuesta> getRespuestas() {
		return lr;
	}

	@Override
	public void setRespuestas(List<Respuesta> lres) {
		lr=lres;
		
	}

}
