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

		if (request.getAttribute("evento").equals("borrarUnProyecto")) {
			Usuario u = (Usuario) request.getSession().getAttribute("usuario");

			ProyectoStore pstore = ProyectoStore.getInstance();
			
			//if(u)


		} else if (request.getAttribute("evento").equals("nuevoProyecto")) {

			Usuario u = (Usuario) request.getSession().getAttribute("usuario");
			if(u.getKarma()<=200){
				request.getRequestDispatcher("proyectosError.jsp");
			}
			ProyectoStore pstore = ProyectoStore.getInstance();
			Proyecto p = new ProyectoImpl();
			String nombre = request.getParameter("nombre");
			String descripcion = request.getParameter("descripcion");

			String meses = request.getParameter("meses");
			int dias=0;
			java.util.Date today = new java.util.Date();
			java.sql.Date hoy = new java.sql.Date(today.getTime());
			Date fechaFin=hoy;
			if(meses!=""){
				dias = Integer.parseInt(meses) * 30;		
				fechaFin = fechaMas(hoy, dias);
			} else{
				request.getRequestDispatcher("proyectosError.jsp");
			}
			
			String disponible = request.getParameter("disponibilidad");
			int disponibilidad;
			if (disponible != "") {
				disponibilidad = 1;
			} else {
				disponibilidad = 0;
			}
			
			String karma = request.getParameter("karma");			
			int nivelKarma=0;
			if(karma!=""){
			nivelKarma = Integer.parseInt(karma);
			} else {
				request.getRequestDispatcher("proyectosError.jsp");
			}

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
			
			if (nombre=="" || dias <= 30 || nivelKarma <= 0 || u.getKarma()<200) {
				// validación de nivel mínimo de karma para crear un proyecto
				// y que los campos meses y karma no estén en blanco.
				request.getRequestDispatcher("proyectosError.jsp").include(request, response);
			} else {
				boolean correcto = pstore.crearProyecto(p, u);
System.out.println(correcto);
				// TODO actualizar karma en tiempo real al hacer el dispatcher
				if (correcto) {
					ustore.actualizaKarmaUsuario(u, 50);
					Usuario actual = ustore.recuperarUsuarioByIdUsuario(u
							.getIdUser());
					request.setAttribute("usuario", actual);
					request.getRequestDispatcher("proyectosCreadoExito.jsp")
							.include(request, response);
				} else {
					request.getRequestDispatcher("proyectosError.jsp");
				}
			}

		} else if (request.getAttribute("evento").equals("unirseAProyecto")) {
			ProyectoStore pstore = ProyectoStore.getInstance();

			HttpSession sesion = request.getSession();
			Usuario u = (Usuario) sesion.getAttribute("usuario");

			String idProyecto = request.getParameter("idProyecto");
			Proyecto p = pstore.obtenerProyectoPorID(idProyecto);

			UsuarioStore ustore = new UsuarioStore();
			/*
			 * Valido en servidor que: 
			 * - Que la persona no pertenezca ya al proyecto, esto incluye
			 *  si es el creador del mismo, ya que al crearlo se une autom. 
			 * - Que el proyecto está disponible
			 * - Que el usuario tiene el nivel de karma mínimo requerido por el proyecto para unirse.
			 */
			boolean estaba = pstore.existeUsuarioEnProyecto(p, u);
			// System.out.println(estaba);
			if (!estaba) {
				if (p.getDisponibilidad() == 1) {
					if (u.getKarma() >= p.getNivelKarma()) {

						boolean unido = pstore.unirUsuarioAProyecto(p, u);
						// si se une correctamente, se suman los puntitos
						if (unido) {
							ustore.actualizaKarmaUsuario(u, 20);
							Usuario actual = (Usuario) ustore
									.recuperarUsuarioByIdUsuario(u.getIdUser());
							request.setAttribute("usuario", actual);
							request.getRequestDispatcher(
									"descripcionDetalladaProyecto.jsp")
									.include(request, response);
						}
					}
				}
			} else { // Si no cumple alguna condición en servidor al Menú principal de proyectos:
				request.getRequestDispatcher("proyectosError.jsp").include(
						request, response);
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
