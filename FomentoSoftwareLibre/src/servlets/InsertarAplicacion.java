package servlets;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pos.domain.Aplicacion;
import pos.domain.AplicacionImpl;
import pos.domain.AplicacionStore;
import pos.domain.Proyecto;
import pos.domain.ProyectoImpl;
import pos.domain.ProyectoStore;
import pos.domain.Tag;
import pos.domain.TagStore;
import pos.domain.Usuario;
import pos.domain.UsuarioStore;

/**
 * Servlet implementation class InsertarAplicacion
 */
public class InsertarAplicacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertarAplicacion() {
        super();
        // TODO Auto-generated constructor stub
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
		List<Tag> listaTags = new ArrayList<Tag>();
		// recuperamos sesion
		HttpSession sesion = request.getSession();
		
		// recuperamos parametros del formulario
		String nombreAplicacion = request.getParameter("nombre");
		String descripcion = request.getParameter("descripcion");
		java.util.Date today = new java.util.Date();
		java.sql.Date fechaPublicacion = new java.sql.Date(today.getTime());
		String sitioWeb = request.getParameter("sitioWeb");
		
		// Creamos BO de tags para recuperarlos
		TagStore storeT = TagStore.getInstance();
		List<Tag> listaRecuperadaTags = storeT.getTags();
		for ( Tag t : listaRecuperadaTags ){
			String aux = request.getParameter(t.getIdTag());
			if ( aux != null ){
				Tag taux = storeT.getTagByID(aux);
				listaTags.add(taux);
			}
		}
		
		// cogemos usuario de la sesion y actualizamos su karma por insertar la aplicacion 
		Usuario user = (Usuario)sesion.getAttribute("usuario");
		UsuarioStore storeUser = new UsuarioStore();
		storeUser.actualizaKarmaUsuario(user, 20);
		Usuario userNuevo = storeUser.recuperarUsuarioByIdUsuario(user.getIdUser());
		sesion.setAttribute("usuario", userNuevo);
		
		// creamos BO y TO
		AplicacionStore storeAplicacion = AplicacionStore.getInstance();
		// insertarmos Aplicacion en bd
		boolean seInserta = storeAplicacion.crearAplicacion(nombreAplicacion, descripcion, fechaPublicacion, sitioWeb, listaTags, null, user);
		request.getRequestDispatcher("aplicaciones.jsp").include(request,response);
	}
}