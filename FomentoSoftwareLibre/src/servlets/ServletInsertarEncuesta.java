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
    	List<Pregunta> lpaux = new LinkedList<Pregunta>();
    	List<Pregunta> lp = new LinkedList<Pregunta>();
    	List<Respuesta>lr = new LinkedList<Respuesta>();

    	
    	response.getWriter().println("HAS LOGRADO TENER CHANCE!!!!!! JAVA CHANCEADO CON JSP");
    	//response.getWriter().println(numpreg);

    	Enumeration<?> e=request.getParameterNames(); 	
    	
    	//Recogida de información
    	
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
    				response.getWriter().println("illo que "+lraux.get(lraux.size()-1).getDescripcionRespuesta());
    			}
    			else{
    				List<Respuesta> lraux = new LinkedList<Respuesta>();
    				lraux.add(r);
    				mp.put(c1.toString(), lraux);
    			}
    			response.getWriter().println(cad+" "+mp.keySet());
    		}
    		
    		if (cad.contains("pre")){
    			Pregunta p = new PreguntaImpl();
    			Character c = cad.charAt(cad.length()-1);//numero de pregunta
    			p.setIDPregunta(c.toString());
    			p.setEnunciado(request.getParameter(cad));
    			lpaux.add(p);
    			response.getWriter().println("enun "+lpaux);
    		}
    		
    	}
    	
    	// agrupado de la información y ordenación.
    	
    	//ordenación de preguntas por inserción
    	
    	for (Integer i =1 ; i<=lpaux.size(); i++){
    		for (Integer j =0; j< lpaux.size();j++){
    			if (lpaux.get(j).getIDPregunta().equals(i.toString())){
    				lp.add(lpaux.get(j));
    				break;
    			}
    		}
    	}
    	
    	//inserción de respuestas
    	//System.out.print(mp.get(0).get(0).getDescripcionRespuesta());
    	//MAPEO INCORRECTO
    	
    	for (Integer i =0; i <lpaux.size(); i ++){
    		lr = mp.get(i.toString()); 
    		lp.get(i).setRespuestas(lr);
    	}
    	
    	/*for (Respuesta r : lp.get(0).getRespuestas()){
    		response.getWriter().println("Respuestas "+r.getDescripcionRespuesta());
    	}*/
    	
    }
}
