package pos.data;

import java.util.Date;
import java.util.List;

import pos.domain.Comentario;

public interface IComentarioDAO {

	public Comentario recuperarComentario(String idComentario);
	public List<Comentario> recuperarTODOS();
	public void borrarComentario(Comentario c);
	public void insertarComentario(Comentario c);

}