package pos.domain;

public class RespuestaImpl implements Respuesta {
	
	private String idRespuesta;
	private String desc;
	private String nvotos;

	public String getIDRespuesta() {
		return idRespuesta;
	}

	@Override
	public String getDescripcionRespuesta() {
		return desc;
	}

	@Override
	public void setIDRespuesta(String id) {
		idRespuesta=id;
		
	}

	@Override
	public void setDescripcion(String d) {
		desc=d;
	}

	@Override
	public String getNumeroVotos() {
		return nvotos;
	}

	@Override
	public void setNumeroVotos(String votos) {
		nvotos=votos;
	}

}
