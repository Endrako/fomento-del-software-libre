package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pos.domain.Usuario;
import pos.domain.UsuarioStore;

/**
 * Servlet implementation class Logear
 */
public class Logear extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Logear() {
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