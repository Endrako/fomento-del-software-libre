package pos.domain;

public class EncuestaImpl implements Encuesta {
	
	private Integer encuestaID;
	private String titulo;
	
	
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

}
