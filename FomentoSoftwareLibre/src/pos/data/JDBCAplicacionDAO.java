package pos.data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mysql.jdbc.Connection;

import pos.domain.Aplicacion;
import pos.domain.AplicacionImpl;
import pos.domain.Tag;

public class JDBCAplicacionDAO implements IAplicacionDAO{

	@Override
	public List<Aplicacion> selectAll() {
		Connection con =(Connection) ConnectionManager.getInstance().checkOut();
		
		List<Aplicacion> listaAplicaciones= new ArrayList<Aplicacion>();
		ResultSet result = null;
		Aplicacion aplicacion = null;
		PreparedStatement stm = null;
		String sql = "SELECT * FROM aplicaciones";
		
		try{			
			stm = con.prepareStatement(sql);
			result = stm.executeQuery();
			while(result.next()){
				aplicacion = createAplicacionFromBD(aplicacion,result);
				listaAplicaciones.add(aplicacion);
			}
		}catch (SQLException e){
			System.out.println("SQLMessage: "+e.getMessage());
			System.out.println("SQLState: "+e.getSQLState());
			System.out.println("ErrorCode: "+e.getErrorCode());
		}finally{
			try{
				if(stm !=null){
					stm.close();
				}
				if(result != null){
					result.close();
				}
			}catch (SQLException e){				
			}
		}
		return listaAplicaciones;		
	}

	@Override
	public void insertAplicacion(Aplicacion aplicacion) {
		Connection con =(Connection) ConnectionManager.getInstance().checkOut();
		
		PreparedStatement stm = null;
		String sql = "INSERT INTO aplicaciones(nombre,descripcion,fechaPublicacion,URLWeb,numeroVotosAFavor,numeroVotosEnContra) VALUES (?,?,?,?,?,?)";
		//TODO HAY QUE RELACIONAR LOS TAGS!!!
		try{
			stm = con.prepareStatement(sql);
			stm.setString(0,aplicacion.getNombre());
			stm.setString(1,aplicacion.getDescripcion());
			stm.setDate(2,(java.sql.Date) aplicacion.getFechaPublicacion());
			stm.setString(3,aplicacion.getURLWeb());
			stm.setInt(4,aplicacion.getVotosAFavor());
			stm.setInt(5,aplicacion.getVotosEnContra());
			
			stm.executeUpdate();
		}catch (SQLException e){
			System.out.println("SQLMessage: "+e.getMessage());
			System.out.println("SQLState: "+e.getSQLState());
			System.out.println("ErrorCode: "+e.getErrorCode());
		}finally{
			try{
				if(stm != null){
					stm.close();
				}
			}catch (SQLException e){
				
			}
		}
	}

	@Override
	public Aplicacion selectAplicacionByID(String IDAplicacion) {
		Connection con =(Connection) ConnectionManager.getInstance().checkOut();
		//Es posible que haya que pasarle una conexion como parametro por estar siendo usado
		//en el JDBCEnfrentamientoDAO
		Aplicacion aplicacion  = null;
		PreparedStatement stm = null;
		ResultSet result = null;
		Integer IDAply = new Integer (IDAplicacion);
		String sql = "SELECT * FROM aplicaciones WHERE (IDAplicacion = ?)";
		
		try{
			stm = con.prepareStatement(sql);
			stm.setInt(0,IDAply);
			result=stm.executeQuery();
			
			aplicacion = createAplicacionFromBD(aplicacion, result);
		}catch (SQLException e){
			System.out.println("SQLMessage: "+e.getMessage());
			System.out.println("SQLState: "+e.getSQLState());
			System.out.println("ErrorCode: "+e.getErrorCode());
		}finally{
			try{
				if(stm != null){
					stm.close();
				}
				if(result != null){
					result.close();
				}
			}catch (SQLException e){
				
			}
		}
		return aplicacion;
	}

	@Override
	public Aplicacion selectAplicacionByName(String name) {
		Connection con =(Connection) ConnectionManager.getInstance().checkOut();

		Aplicacion aplicacion  = null;
		PreparedStatement stm = null;
		ResultSet result = null;
		String sql = "SELECT * FROM aplicaciones WHERE (nombre = ?)";
		
		try{
			stm = con.prepareStatement(sql);
			stm.setString(0,name);
			result=stm.executeQuery();
			
			aplicacion = createAplicacionFromBD(aplicacion, result);
		}catch (SQLException e){
			System.out.println("SQLMessage: "+e.getMessage());
			System.out.println("SQLState: "+e.getSQLState());
			System.out.println("ErrorCode: "+e.getErrorCode());
		}finally{
			try{
				if(stm != null){
					stm.close();
				}
				if(result != null){
					result.close();
				}
			}catch (SQLException e){
				
			}
		}
		return aplicacion;
	}

	@Override
	public List<Aplicacion> selectAplicationByTag(String IDTag) {
		Connection con =(Connection) ConnectionManager.getInstance().checkOut();
		
		List<Aplicacion> listaAplicaciones = new ArrayList<Aplicacion>();
		Aplicacion aplicacion = null;
		String sql = "SELECT IDAplicacion FROM tagsaplicaciones WHERE (IDTag = ?)";
		PreparedStatement stm = null;
		ResultSet result = null;
		Integer idtag = new Integer(IDTag);
		
		try{
			stm = con.prepareStatement(sql);
			stm.setInt(0, idtag);
			result = stm.executeQuery();
			while(result.next()){
				Integer IDAplicacion = result.getInt("IDAplicacion");
				aplicacion = this.selectAplicacionByID(IDAplicacion.toString());
				listaAplicaciones.add(aplicacion);
			}
		}catch (SQLException e){
			System.out.println("SQLMessage: "+e.getMessage());
			System.out.println("SQLState: "+e.getSQLState());
			System.out.println("ErrorCode: "+e.getErrorCode());
		}finally{
			try{
				if(stm != null){
					stm.close();
				}
				if(result != null){
					result.close();
				}
			}catch (SQLException e){
				
			}
		}
		return listaAplicaciones;		
	}

	@Override
	public void deleteAplication(String IDAplicacion) {
		// TODO Auto-generated method stub
		
	}
	
	private Aplicacion createAplicacionFromBD(Aplicacion aplicacion,ResultSet result){
		aplicacion = new AplicacionImpl();
		List<Tag> listaTags = this.getAplicationTags(aplicacion.getIDAplicacion());
		Integer IDAplicacion;
		try {
			IDAplicacion = result.getInt("IDAplicacion");
			String nombre = result.getString("nombre");
			String descripcion = result.getString("descripcion");
			Date fechaPublicacion = result.getDate("fechaPublicacion");
			String URLWeb = result.getString("URLWeb");
			Integer numeroVotosAFavor = result.getInt("numeroVotosAFavor");
			Integer numeroVotosEnContra = result.getInt("numeroVotosEnContra");			
			
			aplicacion.setDescripcion(descripcion);
			aplicacion.setFechaPublicacion(fechaPublicacion);
			aplicacion.setIDAplicacion(IDAplicacion.toString());
			aplicacion.setNombre(nombre);
			aplicacion.setURLWeb(URLWeb);
			aplicacion.setVotosAFavor(numeroVotosAFavor);
			aplicacion.setVotosEnContra(numeroVotosEnContra);
			aplicacion.setTags(listaTags);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return aplicacion;
	}
	
	private void insertAplicationTagRelation(String IDAplicacion,String IDTag){
		//TODO bien gordo
	}

	private void deleteAplicationTagRelation(String IDAplicacion,String IDTag){
		//TODO bien gordo
	}	
	
	private List<Tag> getAplicationTags(String IDAplicacion){
		Connection con =(Connection) ConnectionManager.getInstance().checkOut();
		
		List<Tag> listaTags = new ArrayList<Tag>();
		Tag tag = null;
		PreparedStatement stm = null;
		ResultSet result = null;
		String sql = "SELECT IDTag FROM tagsaplicaciones WHERE (IDAplicacion = ?)";
		Integer idaply = new Integer(IDAplicacion);
		
		try{
			stm = con.prepareStatement(sql);
			stm.setInt(0, idaply);
			result = stm.executeQuery();
			while(result.next()){
				Integer IDTag = result.getInt("IDTag");
				//Cuidaaaooooooooooooo!!
				tag = (new JDBCTagDAO()).selectTagByID(IDTag);
				listaTags.add(tag);
			}
		}catch (SQLException e){
			System.out.println("SQLMessage: "+e.getMessage());
			System.out.println("SQLState: "+e.getSQLState());
			System.out.println("ErrorCode: "+e.getErrorCode());
		}finally{
			try{
				if(stm != null){
					stm.close();
				}
				if(result != null){
					result.close();
				}
			}catch (SQLException e){
				
			}
		}
		return listaTags;
	}

}