package pos.domain;

import java.util.List;

import pos.data.IEncuestaDAO;
import pos.data.IRespuestaDAO;
import pos.data.JDBCEncuestaDAO;
import pos.data.JDBCRespuestaDAO;

public class EncuestaStore implements IEncuestaStore {
	
	private IEncuestaDAO edao;
	private IRespuestaDAO rdao;

	
	public EncuestaStore(){
		edao = new JDBCEncuestaDAO();
		rdao = new JDBCRespuestaDAO();
	}

	@Override
	public boolean insertarEncuesta(Encuesta enc) {
		boolean res = false;
		if (enc.getUsuario().isEmpty()){
			res=false;
		}else{
		if (enc.getTituloEncuesta().isEmpty()){
			res = true;
		}else{
			List<Pregunta> l1= enc.getPreguntas();
			for (Pregunta p : l1){
				for (Respuesta r : p.getRespuestas()){
					if (r.getDescripcionRespuesta().isEmpty()){
						res = true;
						break;
					}
				}
				if (p.getEnunciado().isEmpty()){
					res= true;
					break;
				}
			}
		}
		}

		if (res == false){
			edao.insertarEncuesta(enc);
		}
		return res;
	}
	
	public Encuesta obtenerEncuesta (String idEncuesta){
		return edao.recuperarEncuesta(idEncuesta);
	}

	@Override
	public void borrarEncuesta(String idEncuesta) {
		edao.Borrar(idEncuesta);

	}

	@Override
	public List<Encuesta> obtenerEncuestas() {
		return edao.seleccionarTodasEncuestas();
	}

	@Override
	public boolean votarRespuestas(String idRespuesta) {
		rdao.votarRespuestas(idRespuesta);
		return false;
	}

}
