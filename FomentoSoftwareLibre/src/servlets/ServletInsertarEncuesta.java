package servlets;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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
    	Map<String,List<Respuesta>> mp = new HashMap<String,List<Respuesta>>();
    	List<Pregunta> lp = new LinkedList<Pregunta>();
    	List<Respuesta>lr = new LinkedList<Respuesta>();
    	Integer numpreg = new Integer(request.getParameter("num"));

    	
    	response.getWriter().println("HAS LOGRADO TENER CHANCE!!!!!! JAVA CHANCEADO CON JSP");
    	response.getWriter().println(numpreg);

    	Enumeration<?> e=request.getParameterNames(); 	

    	while (e.hasMoreElements()){
    		String cad = (String) e.nextElement();
    		response.getWriter().println("Enumeration : "+cad);
    		if (cad.contains("tit")){
    			encuesta.setTituloEncuesta(request.getParameter(cad));
    			response.getWriter().println(encuesta.getTituloEncuesta());
    		}
    		if (cad.contains("res")){
    			Character c1 = cad.charAt(cad.length()-1);//pregunta a la que pertenece
    			Character c2 = cad.charAt(cad.length()-3);//orden de la respuesta
    			Respuesta r = new RespuestaImpl();
    			r.setIDRespuesta(c2.toString());
    			r.setDescripcion(request.getParameter(cad));
    			
    			if(mp.containsKey(c1.toString())){
    				List<Respuesta> lraux =mp.get(c1.toString());
    				response.getWriter().println("Valor "+lraux);
    				lraux.add(r);
    				mp.put(c1.toString(), lraux);
    			}
    			else{
    				List<Respuesta> lraux = new LinkedList<Respuesta>();
    				lraux.add(r);
    				mp.put(c1.toString(), lraux);
    				response.getWriter().println("illo que "+lraux.size());
    			}
    			response.getWriter().println(cad+" "+mp.keySet());//+" "+mp.get("1").size());
    		}
    		if (cad.contains("pre")){
    			
    		}
    	}
    }
}
