package pos.data;

import java.util.List;

import pos.domain.Pregunta;

public interface IPreguntaDAO {
    public void borrar(String PreguntaID);
    public List<Pregunta> seleccionarTodasPreguntasPorEncuesta(Integer EncuestaId);
    public void insertarPregunta(Pregunta p);
    public Pregunta recuperarPregunta(Integer idPregunta);
}
