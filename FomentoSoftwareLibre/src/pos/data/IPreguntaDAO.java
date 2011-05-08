package pos.data;

import java.util.List;

import pos.domain.Pregunta;

public interface IPreguntaDAO {
    public List<Pregunta> seleccionarTodasPreguntasPorEncuesta(Integer EncuestaId);
    public void insertarPregunta(Pregunta p,Integer idEncuesta);
    public Pregunta recuperarPregunta(Integer idPregunta);
	void borrar(Integer preguntaID);
}
