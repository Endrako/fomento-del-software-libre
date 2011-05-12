package pos.data;

import java.util.List;

import pos.domain.Respuesta;

public interface IRespuestaDAO {
    public List<Respuesta> seleccionarTodasRespuestasPorPregunta(String IdPregunta);
    public void insertarRespuesta(String rID,Respuesta r);
    public Respuesta recuperarRespuesta(String idRespuesta);
	void borrar(String RespuestaID);
	
}
