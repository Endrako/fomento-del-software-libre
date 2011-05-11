package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pos.domain.Usuario;
import pos.domain.UsuarioImpl;
import pos.domain.UsuarioStore;

/**
 * Servlet implementation class NuevoUsuario
 */
public class NuevoUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NuevoUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nick = request.getParameter("nick");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String nickRecomendador = request.getParameter("usuarioRecomendador");
		String check = request.getParameter("checkRecomendado");
		
		UsuarioStore store = new UsuarioStore();
		Usuario user = new UsuarioImpl();
		
		if ( !"".equals(nick) && !"".equals(password) && !"".equals(email) ){
			
			user.setNombreUsuario(nick);
			user.setContrasena(password);
			user.setEmail(email);
			user.setKarma(10);
			if ( "".equals(check) ){
				Usuario userRecomendador = store.recuperarUsuarioByNick(nickRecomendador);
				if (  userRecomendador.getNombreUsuario().equals(nickRecomendador) ){
					if ( userRecomendador.getNumeroRecomendaciones() < 5 ){
						user.setKarma(user.getKarma()+10);
						userRecomendador.setKarma(userRecomendador.getKarma()+10);
						userRecomendador.setNumeroRecomendaciones(userRecomendador.getNumeroRecomendaciones()+1);
						store.actualizarUsuario(userRecomendador);
						request.getSession().setAttribute("haSidoRecomendado", true);
					}
					request.getSession().setAttribute("haSidoRecomendado", false);
				}
				
			}
			store.insertarUsuario(user);
		}
		user = store.recuperarUsuario(user.getIdUser());
		request.getSession().setAttribute("usuario", user);
		request.getRequestDispatcher("creacionPerfil.jsp").include(request,response);
	}

}