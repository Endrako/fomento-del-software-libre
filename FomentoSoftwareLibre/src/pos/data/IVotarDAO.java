package pos.data;

import java.util.List;

import pos.domain.Voto;

public interface IVotarDAO {
	public List<Voto> selectAll();
	public List<Voto> selectVotosByUser(String idUser);
	public List<Voto> selectVotoByAplicacion (String Aplicacion);
	public void insertVoto(Voto voto);
	public void deleteVoto(String voto);
	public Voto selectVotoByID(String voto);
}
