package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		
		//RECUPERAMOS LAS VARIABLES DEL FORMULARIO
		String nick = request.getParameter("nick");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String nickRecomendador = request.getParameter("usuarioRecomendador");
		String check = request.getParameter("checkRecomendado");
		
		// RECUPERAMOS LA SESSION SI EXISTE O LA CREAMOS SI NO EXISTE
		HttpSession sesion = request.getSession();
		
		// CREAMOS EL BO Y EL TO
		UsuarioStore store = new UsuarioStore();
		Usuario user = new UsuarioImpl();
		
		// HACEMOS LA VALIDACION EN SERVIDOR DE QUE LO QUE VENGA NO SEA VACIO
		if ( !"".equals(nick) && !"".equals(password) && !"".equals(email) ){
			
			// Comprobamos que no exista el usuario. Si es vacio es que no existe ese usuario
			Usuario usuarioNuevo = store.recuperarUsuarioByNick(nick);
			if ( "".equals(usuarioNuevo.getIdUser()) ){
				// Intrudicoms datos en el TO
				user.setNombreUsuario(nick);
				user.setContrasena(password);
				user.setEmail(email);
				user.setKarma(10);
				// Comprobamos si viene recomendado el usuario
				if ( "".equals(check) ){
					// Recuperamos el usuarioRecomendador
					Usuario userRecomendador = store.recuperarUsuarioByNick(nickRecomendador);
					// COMPROBAMOS QUE QUE NO HAYA RECOMENDADO MAS DE 5 VECES Y ACTUALIZAMOS DATOS Y SESSION
					if (  userRecomendador.getNombreUsuario().equals(nickRecomendador) ){
						if ( userRecomendador.getNumeroRecomendaciones() < 5 ){
							user.setKarma(user.getKarma()+10);
							userRecomendador.setKarma(userRecomendador.getKarma()+10);
							userRecomendador.setNumeroRecomendaciones(userRecomendador.getNumeroRecomendaciones()+1);
							store.actualizarUsuario(userRecomendador);
							sesion.setAttribute("existeRecomendador", true);
							sesion.setAttribute("haSidoRecomendado", true);
						}else{
							sesion.setAttribute("existeRecomendador", true);
							sesion.setAttribute("haSidoRecomendado", false);
						}
						
					}else{
						sesion.setAttribute("existeRecomendador", false);
					}
					
				}
				store.insertarUsuario(user);
			}else{
				RequestDispatcher resq = request.getRequestDispatcher("usuarioExistente.jsp");	
				resq.forward(request, response);
			}
		}
		// ACTUALIZAMOS USUARIO RECIEN REGISTRADO PARA QUE ESTE EN SESSION CON TODOS SUS DATOS
		user = store.recuperarUsuarioByNick(nick);
		sesion.setAttribute("usuario", user);
		RequestDispatcher resq = request.getRequestDispatcher("nuevoPerfil.jsp");
		resq.forward(request, response);
	}

}
