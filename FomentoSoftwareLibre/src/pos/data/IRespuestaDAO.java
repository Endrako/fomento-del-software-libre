package pos.data;

import java.util.List;

import pos.domain.Respuesta;

public interface IRespuestaDAO {
    public List<Respuesta> seleccionarTodasRespuestasPorPregunta(Integer IdPregunta);
    public void insertarRespuesta(Integer rID,Respuesta r);
    public Respuesta recuperarRespuesta(Integer idRespuesta);
	void borrar(Integer RespuestaID);
	
}
