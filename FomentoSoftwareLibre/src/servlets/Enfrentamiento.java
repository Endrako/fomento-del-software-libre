package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pos.domain.Aplicacion;
import pos.domain.AplicacionStore;
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
			AplicacionStore aplSt = AplicacionStore.getInstance();
			List<Aplicacion> aplicaciones = new ArrayList<Aplicacion>();
			
			for(Aplicacion ap : aplSt.getAplicaciones()){
				if(request.getParameter(ap.getIDAplicacion()) !=null){
					aplicaciones.add(ap);
				}
			}
			
			
			
		}
		
	}

}
