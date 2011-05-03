package pos.domain;

public class RespuestaImpl implements Respuesta {
	
	private Integer idRespuesta;
	private String desc;

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

}
