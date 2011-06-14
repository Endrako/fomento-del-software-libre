package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pos.domain.Tag;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String accion = request.getParameter("accion");
		procesarAccion(accion, request, response);
	}

	public void procesarAccion(String accion, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if (accion.equals("entrar")) {
			entrar(request, response);
		} else if (accion.equals("TagsEnfrentamiento")) {
			seleccionarTagParaEnfrentamiento(request, response);
		} else if (accion.equals("AplicacionesEnfrentamiento")) {
			seleccionarAplicacionesEnfrentamiento(request, response);
		} else if (accion.equals("logout")) {
			logout(request, response);
		} else if (accion.equals("registrar")) {
			registrar(request, response);
		} else if (accion.equals("registroUsuario")) {
			registroUsuario(request, response);
		} else if (accion.equals("recuperarPerfilAplicacion")) {
			recuperarPerfilAplicacion(request, response);
		} else if (accion.equals("nuevaAplicacion")) {
			nuevaAplicacion(request, response);
		} else if (accion.equals("nuevoPerfil")) {
			guardarNuevoPerfil(request, response);
		} else if (accion.equals("insertarAplicacion")) {
			insertarApliacion(request, response);
		} else if (accion.equals("votarAFavor")) {
			votarAFavor(request, response);
		} else if (accion.equals("votarEnContra")) {
			votarEnContra(request, response);
		} else if (accion.equals("votarEnfrentamiento")) {
			votarEnfrentamiento(request, response);
		} else if (accion.equals("borrarmeDeUnProyecto")) {
			borrarmeDeUnProyecto(request, response);
		} else if (accion.equals("recuperarPerfilProyecto")) {
			recuperarPerfilProyecto(request, response);
		} else if (accion.equals("insertarEncuesta")) {
			insertarEncuesta(request, response);
		} else if (accion.equals("votosAplicacion")){
			votosAplicacion(request, response);
		} else if(accion.equals("nuevoProyecto")){
			crearNuevoProyecto(request, response);
		} else if(accion.equals("recuperarEncuesta")){
			recuperarEncuesta(request,response);
		} else if(accion.equals("creacionProyectos")){
			creacionProyectos(request, response);
		}else if(accion.equals("unirseAlProyecto")){
			unirseAUnProyecto(request,response);
		} else if(accion.equals("datosencuesta")){
			datosEncuesta(request,response);
		} else if (accion.equals("verEncuesta")){
			verEncuesta(request,response);
		} else if (accion.equals("eliminarEncuesta")){
			eliminarEncuesta(request,response);
		} 
		
	}

	private void eliminarEncuesta(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("encuestaEliminar.jsp").include(request, response);
		
	}

	private void unirseAUnProyecto(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		request.setAttribute("evento", "unirseAProyecto");
		request.getRequestDispatcher("ServletProyecto").include(request, response);
	}

	private void verEncuesta(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("encuestaResultado.jsp").include(request, response);
		
	}

	private void datosEncuesta(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("ServletRealizarEncuesta").include(request, response);

	}

	private void recuperarEncuesta(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("encuestaHacer.jsp").include(request, response);
		
	}

	private void insertarEncuesta(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("ServletInsertarEncuesta").include(
				request, response);

	}

	private void recuperarPerfilAplicacion(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("descripcionDetalladaAplicacion.jsp")
				.include(request, response);
	}

	private void insertarApliacion(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("InsertarAplicacion").include(request,
				response);
	}

	private void nuevaAplicacion(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("nuevaAplicacion.jsp").include(request,
				response);
	}

	private void registrar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("registroUsuario.jsp").include(request,
				response);

	}

	private void logout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("logout", "si");
		request.getRequestDispatcher("Logear").include(request, response);

	}

	private void guardarNuevoPerfil(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("nuevoPerfil").include(request, response);

	}

	public void registroUsuario(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("NuevoUsuario").include(request, response);
	}

	public void entrar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("Logear").include(request, response);

	}

	private void seleccionarTagParaEnfrentamiento(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("evento", "selectTags");
		request.getRequestDispatcher("Enfrentamiento").include(request,
				response);
	}

	private void seleccionarAplicacionesEnfrentamiento(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("evento", "selectAplicaciones");
		request.setAttribute("tags", (Tag) request.getAttribute("tags"));
		request.getRequestDispatcher("Enfrentamiento").include(request,
				response);
	}

	private void votarAFavor(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("ServletVotarAFavor").include(request, response);
	}

	private void votarEnContra(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("ServletVotarEnContra").include(request, response);
	}

	private void votarEnfrentamiento(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("evento", "votar");
		request.setAttribute("IDEnfrentamiento",
				request.getParameter("idEnfrentamiento"));
		request.setAttribute("NumeroAplicacion",
				request.getParameter("aplicacion"));
		request.getRequestDispatcher("Enfrentamiento").include(request,
				response);
	}

	private void borrarmeDeUnProyecto(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		request.setAttribute("evento", "borrarmeDeUnProyecto");
		request.getRequestDispatcher("ServletProyecto");
	}

	private void recuperarPerfilProyecto(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("descripcionDetalladaProyecto.jsp")
				.include(request, response);
	}
	
	private void votosAplicacion(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		request.getRequestDispatcher("votosApli.jsp").include(request, response);
	}
	private void crearNuevoProyecto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("evento", "nuevoProyecto");
		request.getRequestDispatcher("ServletProyecto").include(request, response);
	}
	private void creacionProyectos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("proyectosCrear.jsp").include(request, response);
	}

}
