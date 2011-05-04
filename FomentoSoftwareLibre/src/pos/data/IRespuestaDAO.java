package pos.data;

import java.util.List;

import pos.domain.Respuesta;

public interface IRespuestaDAO {
    void borrar(String RespuestaID);
    List<Respuesta> seleccionarTodasRespuesta();
    void insertarRespuesta(Respuesta r);
    Respuesta recuperarRespuesta();
}
