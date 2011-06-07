package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pos.domain.Proyecto;
import pos.domain.ProyectoStore;

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
		
		if(request.getAttribute("evento").equals("selectProyects")){
			ProyectoStore pstore = ProyectoStore.getInstance();
			List<Proyecto> list = new ArrayList<Proyecto>();
			
			for (Proyecto p: pstore.obtenerTodosProyectos()){
				String par = request.getParameter(p.getIDProyecto());
				if((par!=null) && (par != "")){
					
				}
				
			}
			
			
		}
		
		
	}

}
