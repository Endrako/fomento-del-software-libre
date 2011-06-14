package servlets;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pos.domain.Proyecto;
import pos.domain.ProyectoImpl;
import pos.domain.ProyectoStore;
import pos.domain.Usuario;
import pos.domain.UsuarioStore;

/**
 * Servlet implementation class ServletProyecto
 */
public class ServletProyecto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletProyecto() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		if (request.getAttribute("evento").equals("selectProyects")) {
			ProyectoStore pstore = ProyectoStore.getInstance();
			List<Proyecto> list = new ArrayList<Proyecto>();

			for (Proyecto p : pstore.obtenerTodosProyectos()) {
				String par = request.getParameter(p.getIDProyecto());
				if ((par != null) && (par != "")) {
					if (par.equals(p.getIDProyecto())) {
						list.add(p);
					}
				}
			}
			if (list.size() <= 0) {
				request.getRequestDispatcher("indexProyectos.jsp");
			} else {

			}

		} else if (request.getAttribute("evento").equals("nuevoProyecto")) {

			Usuario u = (Usuario) request.getSession().getAttribute("usuario");
			ProyectoStore pstore = ProyectoStore.getInstance();
			Proyecto p = new ProyectoImpl();
			String nombre = request.getParameter("nombre");
			String descripcion = request.getParameter("descripcion");

			String meses = request.getParameter("meses");
			int dias = Integer.parseInt(meses) * 30;
			java.util.Date today = new java.util.Date();
			java.sql.Date hoy = new java.sql.Date(today.getTime());
			Date fechaFin = fechaMas(hoy, dias);

			String disponible = request.getParameter("disponibilidad");
			int disponibilidad;

			if (disponible != "") {
				disponibilidad = 1;
			} else {
				disponibilidad = 0;
			}
			String karma = request.getParameter("karma");
			int nivelKarma = Integer.parseInt(karma);

			p.setNombreProyecto(nombre);
			p.setDescripcionProyecto(descripcion);
			p.setFechaInicio(hoy);
			p.setFechaFin(fechaFin);
			p.setNivelKarma(nivelKarma);
			p.setDisponibilidad(disponibilidad);
			

			UsuarioStore ustore = new UsuarioStore();

			/*
			 * Validación en server
			 */
			// en jsp se comprueba que checkbox solo tenga números.
			
			if (dias <= 30 || nivelKarma <= 0 || nivelKarma >= u.getKarma()) {
				// validación de nivel mínimo de karma para crear un proyecto en el BO (Store).
				request.getRequestDispatcher("proyectosCrear.jsp").include(request, response);
			} else {

				boolean correcto = pstore.crearProyecto(p, u);
				

				//TODO actualizar karma en tiempo real al hacer el dispatcher
				if (correcto) {
					ustore.actualizaKarmaUsuario(u, 50);

					Usuario actual = ustore.recuperarUsuarioByIdUsuario(u
							.getIdUser());

					request.setAttribute("usuario", actual);
					request.getRequestDispatcher("proyectosExistentes.jsp")
							.include(request, response);
				}else{
					request.getRequestDispatcher("indexProyectos.jsp").include(request, response);
				}

			}

		}else if(request.getAttribute("evento").equals("unirseAProyecto")){
			ProyectoStore pstore = ProyectoStore.getInstance();
			
			HttpSession sesion = request.getSession();
			Usuario u = (Usuario) sesion.getAttribute("usuario");
			
			String idProyecto = request.getParameter("idProyecto");
			Proyecto p = pstore.obtenerProyectoPorID(idProyecto);
			
			UsuarioStore ustore = new UsuarioStore();


			/*
			 * valido en servidor que la persona no pertenezca ya al proyecto
			 */
			boolean estaba = pstore.existeUsuarioEnProyecto(p, u);
			System.out.println(estaba);
			if(!estaba){
				boolean unido = pstore.unirUsuarioAProyecto(p, u);
				// si se une, se suman los puntitos
				if(unido){
					ustore.actualizaKarmaUsuario(u,20);
					Usuario actual = (Usuario) ustore.recuperarUsuarioByIdUsuario(u.getIdUser());
					request.setAttribute("usuario", actual);
					request.getRequestDispatcher("descripcionDetalladaProyecto.jsp").include(request, response);
				}
			}
			else{
				request.getRequestDispatcher("indexProyectos.jsp").include(request, response);
			}

		}
		

	}

	private java.sql.Date fechaMas(java.sql.Date fch, int dias) {
		Calendar cal = new GregorianCalendar();
		cal.setTimeInMillis(fch.getTime());
		cal.add(Calendar.DATE, dias);
		return new Date(cal.getTimeInMillis());
	}

}
