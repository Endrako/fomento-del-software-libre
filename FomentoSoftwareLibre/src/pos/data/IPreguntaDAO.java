package pos.data;

import java.util.List;

import pos.domain.Pregunta;

public interface IPreguntaDAO {
    public List<Pregunta> seleccionarTodasPreguntasPorEncuesta(String EncuestaId);
    public void insertarPregunta(Pregunta p,String eId);
    public Pregunta recuperarPregunta(String idPregunta);
	void borrar(String n);
}
