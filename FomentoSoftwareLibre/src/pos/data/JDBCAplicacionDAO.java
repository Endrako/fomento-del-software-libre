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

public class JDBCAplicacionDAO implements IAplicacionDAO {

	@Override
	public List<Aplicacion> selectAll() {
		Connection con = (Connection) ConnectionManager.getInstance()
				.checkOut();

		List<Aplicacion> listaAplicaciones = new ArrayList<Aplicacion>();
		ResultSet result = null;
		Aplicacion aplicacion = null;
		PreparedStatement stm = null;
		String sql = "SELECT * FROM aplicaciones";

		try {
			stm = con.prepareStatement(sql);
			result = stm.executeQuery();
			//para poder acceder a los datos del ResultSet hay que hacerle el .next()
			//si el método solo figurase dentro del while se saltaria la primera tupla
			while(result.next()){
				String IDAplicacion = result.getString("IDAplicacion");
				String nombre = result.getString("nombre");
				String descripcion = result.getString("descripcion");
				Date fechaPublicacion = result.getDate("fechaPublicacion");
				String URLWeb = result.getString("URLWeb");
				Integer votosAFavor = result.getInt("numeroVotosAFavor");
				Integer votosEnContra = result.getInt("numeroVotosEnContra");
				String IDProyecto = result.getString("IDProyecto");
				List<Tag> tags = this.getAplicationTags(result.getString("IDAplicacion"));
				
				aplicacion = new AplicacionImpl(IDAplicacion,nombre,descripcion,fechaPublicacion,URLWeb,votosAFavor,votosEnContra,tags,IDProyecto);
				listaAplicaciones.add(aplicacion);
			}
		} catch (SQLException e) {
			System.out.println("SQLMessage: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("ErrorCode: " + e.getErrorCode());
		} finally {
			try {
				if (stm != null) {
					stm.close();
				}
				if (result != null) {
					result.close();
				}
			} catch (SQLException e) {
			}
		}
		return listaAplicaciones;
	}

	@Override
	public void insertAplicacion(Aplicacion aplicacion) {
		Connection con = (Connection) ConnectionManager.getInstance()
				.checkOut();

		List<Tag> tags = aplicacion.getTags();
		PreparedStatement stm = null;
		String sql = "INSERT INTO aplicaciones(nombre,descripcion,fechaPublicacion,URLWeb,numeroVotosAFavor,numeroVotosEnContra) VALUES (?,?,?,?,?,?)";
		try {
			stm = con.prepareStatement(sql);
			stm.setString(1, aplicacion.getNombre());
			stm.setString(2, aplicacion.getDescripcion());
			stm.setDate(3, (java.sql.Date) aplicacion.getFechaPublicacion());
			stm.setString(4, aplicacion.getURLWeb());
			stm.setInt(5, aplicacion.getVotosAFavor());
			stm.setInt(6, aplicacion.getVotosEnContra());

			stm.executeUpdate();
			for (Tag tag : tags) {
				insertAplicationTagRelation(con, aplicacion, tag);
			}
		} catch (SQLException e) {
			System.out.println("SQLMessage: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("ErrorCode: " + e.getErrorCode());
		} finally {
			try {
				if (stm != null) {
					stm.close();
				}
			} catch (SQLException e) {

			}
		}
	}

	@Override
	public Aplicacion selectAplicacionByID(String IDAplicacion) {
		Connection con = (Connection) ConnectionManager.getInstance()
				.checkOut();
		// Es posible que haya que pasarle una conexion como parametro por estar
		// siendo usado
		// en el JDBCEnfrentamientoDAO
		Aplicacion aplicacion = null;
		PreparedStatement stm = null;
		ResultSet result = null;
		String sql = "SELECT * FROM aplicaciones WHERE (IDAplicacion = ?)";

		try {
			stm = con.prepareStatement(sql);
			stm.setString(1, IDAplicacion);
			result = stm.executeQuery();

			while(result.next()){
				String nombre = result.getString("nombre");
				String descripcion = result.getString("descripcion");
				Date fechaPublicacion = result.getDate("fechaPublicacion");
				String URLWeb = result.getString("URLWeb");
				Integer votosAFavor = result.getInt("numeroVotosAFavor");
				Integer votosEnContra = result.getInt("numeroVotosEnContra");
				String IDProyecto = result.getString("IDProyecto");
				List<Tag> tags = this.getAplicationTags(result.getString("IDAplicacion"));
				
				aplicacion = new AplicacionImpl(IDAplicacion,nombre,descripcion,fechaPublicacion,URLWeb,votosAFavor,votosEnContra,tags,IDProyecto);
			}
		} catch (SQLException e) {
			System.out.println("SQLMessage: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("ErrorCode: " + e.getErrorCode());
		} finally {
			try {
				if (stm != null) {
					stm.close();
				}
				if (result != null) {
					result.close();
				}
			} catch (SQLException e) {

			}
		}
		return aplicacion;
	}

	@Override
	public Aplicacion selectAplicacionByName(String name) {
		Connection con = (Connection) ConnectionManager.getInstance()
				.checkOut();

		Aplicacion aplicacion = null;
		PreparedStatement stm = null;
		ResultSet result = null;
		String sql = "SELECT * FROM aplicaciones WHERE (nombre = ?)";

		try {
			stm = con.prepareStatement(sql);
			stm.setString(1, name);
			result = stm.executeQuery();
			while(result.next()){
				String IDAplicacion = result.getString("IDAplicacion");
				String nombre = result.getString("nombre");
				String descripcion = result.getString("descripcion");
				Date fechaPublicacion = result.getDate("fechaPublicacion");
				String URLWeb = result.getString("URLWeb");
				Integer votosAFavor = result.getInt("numeroVotosAFavor");
				Integer votosEnContra = result.getInt("numeroVotosEnContra");
				String IDProyecto = result.getString("IDProyecto");
				List<Tag> tags = this.getAplicationTags(result.getString("IDAplicacion"));
				
				aplicacion = new AplicacionImpl(IDAplicacion,nombre,descripcion,fechaPublicacion,URLWeb,votosAFavor,votosEnContra,tags,IDProyecto);
			}
		} catch (SQLException e) {
			System.out.println("SQLMessage: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("ErrorCode: " + e.getErrorCode());
		} finally {
			try {
				if (stm != null) {
					stm.close();
				}
				if (result != null) {
					result.close();
				}
			} catch (SQLException e) {

			}
		}
		return aplicacion;
	}

	@Override
	public List<Aplicacion> selectAplicationByTag(String IDTag) {
		Connection con = (Connection) ConnectionManager.getInstance()
				.checkOut();

		List<Aplicacion> listaAplicaciones = new ArrayList<Aplicacion>();
		Aplicacion aplicacion = null;
		String sql = "SELECT IDAplicacion FROM tagsaplicaciones WHERE (IDTag = ?)";
		PreparedStatement stm = null;
		ResultSet result = null;

		try {
			stm = con.prepareStatement(sql);
			stm.setString(1, IDTag);
			result = stm.executeQuery();
						
			while (result.next()) {
				String IDAplicacion = result.getString("IDAplicacion");
				aplicacion = this.selectAplicacionByID(IDAplicacion);
				listaAplicaciones.add(aplicacion);
			}
		} catch (SQLException e) {
			System.out.println("SQLMessage: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("ErrorCode: " + e.getErrorCode());
		} finally {
			try {
				if (stm != null) {
					stm.close();
				}
				if (result != null) {
					result.close();
				}
			} catch (SQLException e) {

			}
		}
		return listaAplicaciones;
	}

	@Override
	public void deleteAplication(Aplicacion aplicacion) {
		Connection con = (Connection) ConnectionManager.getInstance().checkOut();

		PreparedStatement stm = null;
		String sql = "DELETE FROM aplicaciones WHERE (IDAplicacion = ?)";
		try {
			stm = con.prepareStatement(sql);
			stm.setString(1,aplicacion.getIDAplicacion());

			stm.executeUpdate();
			deleteAplicationTagRelation(con, aplicacion);
		} catch (SQLException e) {
			System.out.println("SQLMessage: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("ErrorCode: " + e.getErrorCode());
		} finally {
			try {
				if (stm != null) {
					stm.close();
				}
			} catch (SQLException e) {

			}
		}
	}	
	
//	public List<Aplicacion> selectAplicationsByTags (List<Tag> tags){
//		Connection con = (Connection) ConnectionManager.getInstance().checkOut();
//		
//		String inCondition = "";		
//		for(int i=0; i<tags.size();i++){
//			inCondition+="'"+tags.get(i).getIdTag()+"'";	
//			if(i+1==tags.size()){
//				inCondition+="";
//			} else {
//				inCondition+=",";
//			}
//		}
//		
//		System.out.println(inCondition);
//		
//		Aplicacion aplicacion = null;
//		List<Aplicacion> aplicaciones = new ArrayList<Aplicacion>();
//		ResultSet result = null;
//		PreparedStatement stm = null;
//		
////		String sql = "SELECT * FROM tagsaplicaciones WHERE IDTag IN ("+inCondition+")";
//		
//		String sql = "SELECT * FROM tagsaplicaciones ta1 WHERE NOT EXISTS (SELECT * FROM tags t WHERE (t.IDTag IN ("+inCondition+")) AND NOT EXISTS (SELECT * FROM tagsaplicaciones ta2 WHERE (ta2.IDTag = t.IDTag) AND (ta1.IDAplicacion = ta2.IDAplicacion)))";
//		try {
//			stm=con.prepareStatement(sql);
////			stm.setString(1,inCondition);
//			result = stm.executeQuery();
//			while(result.next()){
//				String IDAplicacion = result.getString("IDAplicacion");					
//				aplicacion = this.selectAplicacionByID(IDAplicacion);
//				if(!aplicaciones.contains(aplicacion)){
//					aplicaciones.add(aplicacion);
//				}										
//			}
//		} catch (SQLException e) {
//			System.out.println("consulta: "+sql);
//			System.out.println("SQLMessage: " + e.getMessage());
//			System.out.println("SQLState: " + e.getSQLState());
//			System.out.println("ErrorCode: " + e.getErrorCode());
//		} finally {
//			try {
//				if (stm != null) {
//					stm.close();
//				}
//			} catch (SQLException e) {
//
//			}
//		}
//		return aplicaciones;
//	}

	private void insertAplicationTagRelation(Connection con,
			Aplicacion aplicacion, Tag tag) {
		PreparedStatement stm = null;
		String sql = "INSERT INTO tagsaplicaciones(IDAplicacion,IDTag) VALUES (?,?)";

		try {
			stm = con.prepareStatement(sql);
			stm.setString(1, aplicacion.getIDAplicacion());
			stm.setString(2, tag.getIdTag());

			stm.executeUpdate();

		} catch (SQLException e) {
			System.out.println("SQLMessage: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("ErrorCode: " + e.getErrorCode());
		}
	}

	private void deleteAplicationTagRelation(Connection con,
			Aplicacion aplicacion) {
		PreparedStatement stm = null;
		String sql = "DELETE FROM tagsaplicaciones WHERE (IDAplicacion = ?)";

		try {
			stm = con.prepareStatement(sql);
			stm.setString(1,aplicacion.getIDAplicacion());

			stm.executeUpdate();

		} catch (SQLException e) {
			System.out.println("SQLMessage: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("ErrorCode: " + e.getErrorCode());
		}
	}

	private List<Tag> getAplicationTags(String IDAplicacion) {
		Connection con = (Connection) ConnectionManager.getInstance()
				.checkOut();

		List<Tag> listaTags = new ArrayList<Tag>();
		Tag tag = null;
		PreparedStatement stm = null;
		ResultSet result = null;
		String sql = "SELECT IDTag FROM tagsaplicaciones WHERE (IDAplicacion = ?)";

		try {
			stm = con.prepareStatement(sql);
			stm.setString(1, IDAplicacion);
			result = stm.executeQuery();
			while (result.next()) {
				String IDTag = result.getString("IDTag");
				// Cuidaaaooooooooooooo!!
				tag = (new JDBCTagDAO()).selectTagByID(IDTag);
				listaTags.add(tag);
			}
		} catch (SQLException e) {
			System.out.println("SQLMessage: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("ErrorCode: " + e.getErrorCode());
		} finally {
			try {
				if (stm != null) {
					stm.close();
				}
				if (result != null) {
					result.close();
				}
			} catch (SQLException e) {

			}
		}
		return listaTags;
	}

}
