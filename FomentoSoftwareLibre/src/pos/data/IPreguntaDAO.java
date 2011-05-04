package pos.data;

import java.util.List;

import pos.domain.Pregunta;

public interface IPreguntaDAO {
    void borrar(String PreguntaID);
    List<Pregunta> seleccionarTodasPreguntas();
    void insertarPregunta(Pregunta p);
    Pregunta recuperarPregunta();
}
