package servlets;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pos.domain.Aplicacion;
import pos.domain.AplicacionStore;
import pos.domain.EnfrentamientoStore;
import pos.domain.Tag;
import pos.domain.TagStore;

/**
 * Servlet implementation class Enfrentamiento
 */
public class Enfrentamiento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Enfrentamiento() {
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
		// TODO Auto-generated method stub
		
		if(request.getAttribute("evento").equals("selectTags")){
			TagStore tagSt = TagStore.getInstance();
			Tag tag = null;
			
			for(Tag t : tagSt.getTags()){
				 String par = request.getParameter(t.getNombre());
				 System.out.println(par);
				if(!(par == "")){
					tag=t;
					break;
				}
			}			
			request.setAttribute("tags", tag);
			request.getRequestDispatcher("crearEnfrentamientoSelectAplicaciones.jsp").include(request, response);	
		
		}else if(request.getAttribute("evento").equals("selectAplicaciones")){
			AplicacionStore aplSt = AplicacionStore.getInstance();
			EnfrentamientoStore enfSt = EnfrentamientoStore.getInstance();
			
			List<Aplicacion> aplicaciones = new ArrayList<Aplicacion>();
			//AQUI PIFIA mete nulos
			for(Aplicacion ap : aplSt.getAplicaciones()){
				String par = request.getParameter(ap.getIDAplicacion());
				System.out.println(par);
				if(par !=null){
					if((!(par=="")) && par.equals(ap.getNombre())){
						aplicaciones.add(ap);
					}					
				}
			}	
			System.out.println("tamaño de aplisStore: "+aplSt.getAplicaciones().size());


			//TODO sumar karma? agregar IDUsuario a tabla enfrentamientos
			// como se yo el usuario que está trasteando?
			Aplicacion apli1 = aplicaciones.get(0);
			Aplicacion apli2 = aplicaciones.get(1);
			String descripcion = request.getParameter("descripcionEnfrentamiento");
			
			//El enfrentamiento finaliza tras una semana
			java.util.Date today = new java.util.Date();
			java.sql.Date fechaInicio = new java.sql.Date(today.getTime());
			
			
			
			Date fechaFin = fechaMas(fechaInicio,7);
			
			boolean noExiste = enfSt.crearEnfrentamiento(apli1,apli2,descripcion,fechaInicio,fechaFin);
			if(noExiste == true){
				request.getRequestDispatcher("indexEnfrentamientos.jsp");				
			}else{
				request.setAttribute("aplicaciones", aplicaciones);
				request.getRequestDispatcher("crearEnfrentamientoError.jsp").include(request, response);
			}
			
		}
		
	}
	//Metodo para sumar dias a una fecha
	private java.sql.Date fechaMas(java.sql.Date fch, int dias){ 
	     Calendar cal = new GregorianCalendar(); 
	     cal.setTimeInMillis(fch. getTime()); 
	     cal.add(Calendar. DATE, dias); 
	     return new Date(cal. getTimeInMillis()); 
	} 


}
