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
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.EscapeTokenizer;
import com.sun.org.apache.bcel.internal.generic.NEW;

import pos.domain.Encuesta;
import pos.domain.EncuestaImpl;
import pos.domain.EncuestaStore;
import pos.domain.Pregunta;
import pos.domain.PreguntaImpl;
import pos.domain.Respuesta;
import pos.domain.RespuestaImpl;
import pos.domain.Usuario;

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
    	EncuestaStore encStore = new EncuestaStore();
    	Encuesta encuesta = new EncuestaImpl();
    	Map<String,List<Respuesta>> mp = new HashMap<String,List<Respuesta>>();
    	List<Pregunta> lpaux = new LinkedList<Pregunta>();
    	List<Pregunta> lp = new LinkedList<Pregunta>();
    	List<Respuesta>lr = new LinkedList<Respuesta>();
    	Boolean hayError = false;
    	
    	//response.getWriter().println(numpreg);

    	HttpSession sesion = request.getSession();
    	Enumeration<?> e=request.getParameterNames(); 	
    	//Recogida de información
    	Usuario user = (Usuario)sesion.getAttribute("usuario");
    	encuesta.setUsuario(user.getIdUser());
    	while (e.hasMoreElements()){
    		String cad = (String) e.nextElement();
    		//response.getWriter().println("Enumeration : "+cad);
    		
    		//Recoguda del titulo de la encuesta
    		//OK
    	  		
    		if (cad.contains("tit")){
    			encuesta.setTituloEncuesta(request.getParameter(cad));
    			//response.getWriter().println(encuesta.getTituloEncuesta());
    		}
    		if (cad.contains("res")){
    			Character c1 = cad.charAt(cad.length()-1);//[UNIDADES]pregunta a la que pertenece
    			Character c1aux= cad.charAt(cad.length()-2);//[DECENAS]
    			Character c2 = cad.charAt(cad.length()-4);//[UNIDADES]orden de la respuesta
    			Character c2aux= cad.charAt(cad.length()-5);//[DECENAS]
    			String c3 = new String();
    			Respuesta r = new RespuestaImpl();

    			if (c2aux.equals('0')){
    				r.setIDRespuesta(c2.toString());
    			}
    			else{
    				c3 = c2aux.toString().concat(c2.toString());
    				r.setIDRespuesta(c3);
    			}
    			
    			r.setDescripcion(request.getParameter(cad));
    			
    			if(c1aux.equals('0')){
    				c3= c1.toString();
    			}
    			else{
    				c3=c1aux.toString().concat(c1.toString());
    			}
    			
    			if(mp.containsKey(c3)){
    				List<Respuesta> lraux =mp.get(c3);
    				//response.getWriter().println("Valor "+lraux);
    				lraux.add(r);
    				System.out.println("Soy C3 :"+c3);
    				mp.put(c3, lraux);
    				//response.getWriter().println("DESCRIPCION PREGUNTA --> "+lraux.get(lraux.size()-1).getDescripcionRespuesta());
    			}
    			else{
    				List<Respuesta> lraux = new LinkedList<Respuesta>();
    				lraux.add(r);
    				mp.put(c3, lraux);
    				//response.getWriter().println("DESCRIPCION PREGUNTA --> "+lraux.get(lraux.size()-1).getDescripcionRespuesta());
    			}
    			//response.getWriter().println(cad+" "+mp.keySet());
    		}
    		//ok!
    		if (cad.contains("pre")){
    			Pregunta p = new PreguntaImpl();
    			Character c1 = cad.charAt(cad.length()-1);//numero de pregunta
    			Character c2 = cad.charAt(cad.length()-2);
    			if (c2.equals('0')){
    				p.setIDPregunta(c1.toString());
    			}else{
    				String c3 =c2.toString().concat(c1.toString());
    				p.setIDPregunta(c3);
    			}
    			p.setEnunciado(request.getParameter(cad));
    			lpaux.add(p);
    			//response.getWriter().println("enun "+lpaux);
    		}
    		
    	}
    	
    	// agrupado de la información y ordenación.
    	
    	//ordenación de preguntas por inserción
    	//OK
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
    	//ORDENAR MAPEO
    	
    	for (Pregunta p : lp)
    	System.out.println("new "+p.getIDPregunta());
    	
    	for (Integer i =1; i <=lp.size(); i ++){
    		lr = ordenar(mp.get(i.toString())); //ordenar la lista por orden de inserción
    		lp.get(i-1).setRespuestas(lr);
    	}
    	
    	//inserción de preguntas
    	encuesta.setPreguntas(lp);
    	//inserción en la Base de datos
    	hayError=encStore.insertarEncuesta(encuesta);
    	
    	if (hayError){
    		request.getRequestDispatcher("errorEncuesta.jsp").include(request, response);
    	}else{
    		request.getRequestDispatcher("exitoEncuesta.jsp").include(request, response);
    	}
    	
    	
    	/*for (Respuesta r : lp.get(0).getRespuestas()){
    		response.getWriter().println("Respuestas "+r.getDescripcionRespuesta());
    	}*/
    	/*
    	response.getWriter().println("Titulo de la encuesta: "+encuesta.getTituloEncuesta());
    	List<Pregunta> l1= encuesta.getPreguntas();
    	for (Pregunta p : l1){
    		response.getWriter().println("PREGUNTA "+p.getIDPregunta()+": "+p.getEnunciado());
    		for (Respuesta r : p.getRespuestas()){
    			response.getWriter().println("Respuesta "+r.getIDRespuesta()+": "+r.getDescripcionRespuesta());
    		}
    	}*/
    	
    }
    
    // Metodo privado ordenar respuestas
    private List<Respuesta> ordenar (List<Respuesta> lr){
    	List<Respuesta> laux = new LinkedList<Respuesta>();

    	for (Integer i =1; i<=lr.size(); i++){
    		for (Integer j=0; j<lr.size(); j++){
    			if (lr.get(j).getIDRespuesta().equals(i.toString())){
    				laux.add(lr.get(j));
    				break;
    			}
    		}
    	}
    	return laux;
    }
    
}
