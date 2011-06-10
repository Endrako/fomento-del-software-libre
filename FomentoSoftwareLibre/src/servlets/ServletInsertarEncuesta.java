package servlets;

import java.io.IOException;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pos.domain.Encuesta;
import pos.domain.EncuestaImpl;
import pos.domain.Pregunta;
import pos.domain.PreguntaImpl;
import pos.domain.Respuesta;
import pos.domain.RespuestaImpl;

/**
 * Servlet implementation class TratarEncuesta
 */
public class ServletInsertarEncuesta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletInsertarEncuesta() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Encuesta encuesta = new EncuestaImpl();
		List<Pregunta> lp = new LinkedList<Pregunta>();
		List<Respuesta>lr = new LinkedList<Respuesta>();
		response.getWriter().println("HAS LOGRADO TENER CHANCE!!!!!! JAVA CHANCEADO CON JSP");
		Enumeration<?> e=request.getParameterNames();
		while (e.hasMoreElements()){
		String cad = (String) e.nextElement();
		if (cad.contains("tit")){
			encuesta.setTituloEncuesta(request.getParameter(cad));
			response.getWriter().println(encuesta.getTituloEncuesta());
			}
		if (cad.contains("pre")){
			Pregunta p = new PreguntaImpl();
			p.setEnunciado(request.getParameter(cad));
			lp.add(p);
			}
		if(cad.contains("res")){
			Respuesta r = new RespuestaImpl();
			r.setDescripcion(request.getParameter(cad));
			
			}
		}
	}
}
