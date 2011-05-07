package pos.data;

import java.util.List;

import pos.domain.Pregunta;
import pos.domain.Respuesta;

public interface IPreguntaDAO {
    public void borrar(String PreguntaID);
    public List<Pregunta> seleccionarTodasPreguntasPorEncuesta(Integer EncuestaId);
    public void insertarPregunta(Pregunta p,Integer idEncuesta, List<Respuesta> lr);
    public Pregunta recuperarPregunta(Integer idPregunta);
}
