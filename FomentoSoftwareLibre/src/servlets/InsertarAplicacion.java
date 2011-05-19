package servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pos.domain.Aplicacion;
import pos.domain.AplicacionImpl;
import pos.domain.AplicacionStore;
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
		
		// recuperamos sesion
		HttpSession sesion = request.getSession();
		
		// recuperamos parametros del formulario
		String nombreAplicacion = request.getParameter("nombre");
		String descripcion = request.getParameter("descripcion");
		Date fechaPublicacion = new Date();
		String sitioWeb = request.getParameter("sitioWeb");
		
		// cogemos usuario de la sesion y actualizamos su karma por insertar la aplicacion 
		Usuario user = (Usuario)sesion.getAttribute("usuario");
		UsuarioStore storeUser = new UsuarioStore();
		storeUser.actualizaKarmaUsuario(user.getIdUser(), 20);
		
		// creamos BO y TO
		AplicacionStore storeAplicacion = AplicacionStore.getInstance();
		Aplicacion api = new AplicacionImpl();
		
		//Introducimos nuevos parametros recogidos
		api.setNombre(nombreAplicacion);
		api.setDescripcion(descripcion);
		api.setVotosEnContra(0);
		api.setVotosAFavor(0);
		api.setURLWeb(sitioWeb);
		api.setFechaPublicacion(fechaPublicacion);
		
		
		// insertarmos Aplicacion en bd
	}

}
