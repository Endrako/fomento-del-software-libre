package servlets;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pos.domain.EncuestaStore;
import pos.domain.Usuario;
import pos.domain.UsuarioStore;

/**
 * Servlet implementation class ServletRealizarEncuesta
 */
public class ServletRealizarEncuesta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletRealizarEncuesta() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EncuestaStore eStore = new EncuestaStore();
		Enumeration<?> e=request.getParameterNames(); 
		HttpSession sesion = request.getSession();
		
		//Actualizar Karma
		Usuario user = (Usuario)sesion.getAttribute("usuario");
		UsuarioStore storeUser = new UsuarioStore();
		storeUser.actualizaKarmaUsuario(user, 10);
		Usuario userNuevo = storeUser.recuperarUsuarioByIdUsuario(user.getIdUser());
		sesion.setAttribute("usuario", userNuevo);
		
		while (e.hasMoreElements()){
			String cad = (String) e.nextElement();
			if (cad.contains("resp")){
				System.out.println(request.getParameter(cad));
			eStore.votarRespuestas(request.getParameter(cad));
			}
		}
		
		request.getRequestDispatcher("encuestaVotarOk.jsp").include(request, response);
	}

}
