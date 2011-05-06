package pos.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import pos.domain.Proyecto;
import pos.domain.ProyectoImpl;

public class JDBCProyectoDAO implements IProyectoDAO {
	
	private Connection conn;
	 
	 public JDBCProyectoDAO (){
		 conn = ConnectionManager.getInstance().checkOut();
	 }


	@Override
	public List<Proyecto> obtenerTodosProyectos() {
		String sql = "SELECT * FROM Proyectos";
		PreparedStatement stmt = null;
		ResultSet result = null;
		List<Proyecto> listaProyectos=null;
		
		try{
			stmt = conn.prepareStatement(sql);
			
			result = stmt.executeQuery();
			listaProyectos = new LinkedList<Proyecto>();
			
			while(result.next()){
				Proyecto proyecto = new ProyectoImpl();
				proyecto.setIDProyecto(result.getInt("idProyecto"));
				proyecto.setDescripcionProyecto(result.getString("descripcion"));
				proyecto.setFechaFin(result.getDate("fechaFin"));
				proyecto.setFechaInicio(result.getDate("fechaInicio"));
				proyecto.setNombreProyecto(result.getString("nombreProyecto"));
				proyecto.setDisponibilidad(result.getBoolean("disponibilidad"));
				listaProyectos.add(proyecto);
				
			}
			
			
		}catch (SQLException e){
			System.out.println("Message: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("Error Code: " + e.getErrorCode());
			System.out.println("Cause: " + e.getCause());
		}
		finally { 
			try {
				if(result != null){
					conn.close();
				}
				if(stmt != null){
					conn.close();
				}
			}catch (SQLException e){
			}
		}
		
		return listaProyectos;
	}

	@Override
	public List<Proyecto> obtenerProyectoAbierto() {

		String sql = "SELECT * FROM Proyectos p WHERE p.disponibilidad = 'true'"; // o 1, según tipo datos en BD
		
		
		return null;
	}

	@Override
	public void insertarProyecto(Proyecto project) {
		// TODO Auto-generated method stub

	}

	@Override
	public Proyecto obtenerProyectoPorID(Integer idProyect) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void borrarProyecto(Integer idProyect) {
		// TODO Auto-generated method stub

	}

}
