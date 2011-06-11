package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pos.domain.Perfil;
import pos.domain.PerfilImpl;
import pos.domain.PerfilStore;
import pos.domain.Usuario;
import pos.domain.UsuarioStore;

/**
 * Servlet implementation class nuevoPerfil
 */
public class nuevoPerfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public nuevoPerfil() {
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
		
		// recuperamos Variables
		String idPerfil = request.getParameter("idPerfil");
		String nombre = request.getParameter("nombre");
		String apellidos = request.getParameter("apellidos");
		Integer edad =  Integer.parseInt(request.getParameter("edad"));
		String pais = request.getParameter("paises");
		String provincia = request.getParameter("provincias");
		String soPC = request.getParameter("ssooPC");
		String soMovil = request.getParameter("ssooMv");
		
		// Recuperamos el usuario en session
		HttpSession sesion = request.getSession();
		Usuario user = (Usuario) sesion.getAttribute("usuario");
		
		// BO necesarios
		PerfilStore store = new PerfilStore();
		UsuarioStore storeUser = new UsuarioStore();
		
		// TO necesarios
		Perfil perfil;
		Perfil perfCOM = new PerfilImpl();
		
		// COMPROBAMOS QUE EL PERFIL NO SE VACIO NI NULLO PARA EVITAR NULL POINTER EXCEPTION Y ACTULIZAMOS DATOS
		// SI NO EXISTE EL PERFIL LO CREAMOS VACIO
		if ( !"".equals(idPerfil) && idPerfil != null ){
			perfil = store.recuperarPerfil(idPerfil);
			perfil.setNombreUsuario(nombre);
			perfil.setApellidos(apellidos);
			perfil.setEdad(edad);
			perfil.setIdPais(pais);
			perfil.setIdPoblacion(provincia);
			perfil.setMovilOS(soMovil);
			perfil.setPcOS(soPC);
			store.actualizarPerfil(perfil);
			user.setPerfil(perfil);
			storeUser.actualizarUsuario(user);
		}else{
			perfil = new PerfilImpl();
			perfil.setNombreUsuario(nombre);
			perfil.setApellidos(apellidos);
			perfil.setEdad(edad);
			perfil.setIdPais(pais);
			perfil.setIdPoblacion(provincia);
			perfil.setMovilOS(soMovil);
			perfil.setPcOS(soPC);
			perfCOM = store.insertarPerfil(perfil);
			user.setPerfil(perfCOM);
			storeUser.actualizarUsuario(user);
		}
		
		//Actualizamos el perfil en el user
		
		sesion.setAttribute("usuario", user);
		request.getRequestDispatcher("index2.jsp").include(request, response);

	}

}
