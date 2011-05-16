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
			List<Tag> tags = new ArrayList<Tag>();
			
			for(Tag t : tagSt.getTags()){
				if(request.getParameter(t.getIdTag()) !=null){
					tags.add(t);
				}
			}			
			request.setAttribute("tags", tags);
			request.getRequestDispatcher("crearEnfrentamientoSelectAplicaciones.jsp").include(request, response);	
		
		}else if(request.getAttribute("evento").equals("selectAplicaciones")){
			TagStore tagSt = TagStore.getInstance();
			EnfrentamientoStore enfSt = EnfrentamientoStore.getInstance();
			//NO LE LLEGA EL ATRIBUTO
			String tags = (String) request.getAttribute("tagString");
			String [] wuf = tags.split(", ");
			AplicacionStore aplSt = AplicacionStore.getInstance();
			List<Tag> listaTags = new ArrayList<Tag>();
			for(int i = 0; i<wuf.length;i++){
				listaTags.add(tagSt.getTagByName(wuf[i]));
			}
			
			//LA LISTA DE TAGS ESTA VACIA!!!
			List<Aplicacion> listAplis = aplSt.getAplicacionByTagList(listaTags);
			
//			List<Aplicacion> aplicaciones = new ArrayList<Aplicacion>();
//			//AQUI PIFIA mete nulos
//			for(Aplicacion ap : aplSt.getAplicaciones()){
//				if(!(request.getParameter(ap.getIDAplicacion()) ==null)){
//					aplicaciones.add(ap);
//				}
//			}	
			System.out.println("tamaño de aplisStore: "+aplSt.getAplicaciones().size());
			System.out.println("tamaño de listaplis: "+listAplis.size());


			//TODO sumar karma? agregar IDUsuario a tabla enfrentamientos
			// como se yo el usuario que está trasteando?
			Aplicacion apli1 = listAplis.get(0);
			Aplicacion apli2 = listAplis.get(1);
			String descripcion = request.getParameter("descripcion");
			
			//El enfrentamiento finaliza tras una semana
			Date fechaInicio = (Date) request.getAttribute("fecha");
			Date fechaFin = fechaMas(fechaInicio,7);
			
			boolean noExiste = enfSt.crearEnfrentamiento(apli1,apli2,descripcion,fechaInicio,fechaFin);
			if(noExiste == true){
				request.getRequestDispatcher("indexEnfrentamientos.jsp");				
			}else{
				request.setAttribute("aplicaciones", listAplis);
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
