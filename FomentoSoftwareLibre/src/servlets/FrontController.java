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
		}else if ( accion.equals("nuevoPerfil") ){
			guardarNuevoPerfil(request,response);
		}else if (accion.equals("TagsEnfrentamiento")){
			seleccionarTagParaEnfrentamiento(request,response);
		}else if(accion.equals("AplicacionesEnfrentamiento")){
			seleccionarAplicacionesEnfrentamiento(request,response);
		}
	}
	
	private void registrar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("registroUsuario.jsp").include(request,response);
		
	}
	
	private void guardarNuevoPerfil(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("nuevoPerfil").include(request,response);
		
	}
	
	public void registroUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.getRequestDispatcher("NuevoUsuario").include(request,response);
	}

	public void entrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	
		request.getRequestDispatcher("Logear").include(request,response);
		
	}
	
	private void seleccionarTagParaEnfrentamiento (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setAttribute("evento", "selectTags");
		request.getRequestDispatcher("Enfrentamiento").include(request, response);
	}
	
	private void seleccionarAplicacionesEnfrentamiento (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setAttribute("evento", "selectTags");
	}
	

}
