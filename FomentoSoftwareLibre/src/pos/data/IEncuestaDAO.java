package pos.data;

import java.util.List;

import pos.domain.Encuesta;
import pos.domain.Pregunta;

public interface IEncuestaDAO {
    public List<Encuesta> seleccionarTodasEncuestas();
    public void insertarEncuesta(Encuesta e);
	public Encuesta recuperarEncuesta(Integer idEncuesta);
	void Borrar(Integer encuestaID);
}
