package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pos.domain.Usuario;
import pos.domain.Voto;
import pos.domain.VotoImpl;
import pos.domain.VotoStore;

public class votarAFavor extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public votarAFavor() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// recuperamos Variables
		String idVoto = request.getParameter("idVoto");
		String idAplicacion = request.getParameter("idAplicacion");
		Boolean valor = true;
		
		HttpSession sesion = request.getSession();
		Usuario user = (Usuario) sesion.getAttribute("usuario");
		
		String idUsuario = user.getIdUser();
		
		// BO necesarios
		VotoStore store = VotoStore.getInstance();
		
		// TO necesarios
		Voto voto;
		
		if ( !"".equals(idVoto) && idVoto != null ){
			voto = store.getVotoByIDVoto(idVoto);

		}else{
			voto = new VotoImpl();
		}
		voto.setUsuario(idUsuario);
		voto.setAplicacion(idAplicacion);
		voto.setValor(valor);
		store.crearVoto(voto);
	}
}
