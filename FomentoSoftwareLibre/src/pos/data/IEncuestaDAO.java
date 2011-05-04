package pos.data;

import java.util.List;

import pos.domain.Encuesta;

public interface IEncuestaDAO {
    public void Borrar(String EncuestaID);
    public List<Encuesta> seleccionarTodasEncuestas();
    public void insertarEncuesta(Encuesta e);
    public Encuesta recuperarEncuesta(Encuesta e);
}
