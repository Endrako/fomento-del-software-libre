package pos.data;

import java.util.List;

import pos.domain.Voto;

public interface IVotarDAO {
	public List<Voto> selectAll();
	public List<Voto> selectVotosByUser(Integer idUser);
	public List<Voto> selectVotoByAplicacion (Integer Aplicacion);
	public void insertVoto(Voto voto);
	public void deleteVoto(Integer voto);
	public Voto selectVotoByID(Integer voto);
}
