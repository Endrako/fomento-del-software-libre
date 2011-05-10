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
 * Servlet implementation class FrontController
 */
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
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
		String accion = request.getParameter("accion");
		procesarAccion(accion,request,response);
	}
	
	public void procesarAccion(String accion, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		if ( accion.equals("entrar") ){
			entrar(request,response);
		}else if ( accion.equals("registrar") ){
			registrar(request,response);
		}else if ( accion.equals("registroUsuario") ){
			registroUsuario(request,response);
		}
	}
	
	private void registrar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("registroUsuario.jsp").include(request,response);
		
	}
	
	public void registroUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String nick = request.getParameter("nick");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		
		if ( !"".equals(nick) && !"".equals(password) && !"".equals(email) ){
			
			UsuarioStore store = new UsuarioStore();
			UsuarioImpl user = new UsuarioImpl();
			user.setNombreUsuario(nick);
			user.setContrasena(password);
			user.setEmail(email);
			store.insertarUsuario(user);
		}
		request.getRequestDispatcher("registroPerfil.jsp").include(request,response);
	}

	public void entrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String idUser = request.getParameter("user");
		String password = request.getParameter("password");
		
		UsuarioStore userBIZ = new UsuarioStore();
		if ( idUser != null && password != null && !idUser.equals("") && !password.equals("") ){
			if ( userBIZ.comprobarUsuario(idUser,password) ){
				Usuario user = userBIZ.recuperarUsuario(idUser);
				request.getSession().setAttribute("usuario", user);
				request.getRequestDispatcher("index2.html").include(request,response);
			}else{
				request.getRequestDispatcher("falloUsuario.html").include(request,response);
			}
		}
		
	}

}
