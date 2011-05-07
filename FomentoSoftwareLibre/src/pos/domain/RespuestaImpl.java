package pos.domain;

public class RespuestaImpl implements Respuesta {
	
	private Integer idRespuesta;
	private String desc;
	private Integer nvotos;

	public Integer getIDRespuesta() {
		return idRespuesta;
	}

	@Override
	public String getDescripcionRespuesta() {
		return desc;
	}

	@Override
	public void setIDRespuesta(Integer id) {
		idRespuesta=id;
		
	}

	@Override
	public void setDescripcion(String d) {
		desc=d;
	}

	@Override
	public Integer getNumeroVotos() {
		return nvotos;
	}

	@Override
	public void setNumeroVotos(Integer votos) {
		nvotos=votos;
	}

}
