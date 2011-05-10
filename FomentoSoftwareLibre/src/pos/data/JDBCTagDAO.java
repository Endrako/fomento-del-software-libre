package pos.data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import pos.domain.Tag;
import pos.domain.TagImpl;

public class JDBCTagDAO implements ITagDAO{

	@Override
	public List<Tag> selectAll() {
		Connection con = (Connection) ConnectionManager.getInstance()
		.checkOut();
		
		List<Tag> listaTags = new ArrayList<Tag>();
		Tag tag = null;
		PreparedStatement stm = null;
		ResultSet result = null;
		String sql = "SELECT * FROM tags";
		
		try{
			stm = con.prepareStatement(sql);
			result = stm.executeQuery();
			tag = createTagFromBD(tag, result);
			listaTags.add(tag);
			while(result.next()){
				tag = createTagFromBD(tag, result);
				listaTags.add(tag);				
			}
		}catch (SQLException e){
			System.out.println("Message: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("ErrorCode: " + e.getErrorCode());
		} finally {
			try {
				if (result != null) {
					result.close();
				}
				if (stm != null) {
					stm.close();
				}
			} catch (SQLException e) {
			}			
		}
		return listaTags;
	}

	@Override
	public Tag selectTagByID(String idTag) {
		Connection con = (Connection) ConnectionManager.getInstance()
		.checkOut();
		
		Integer tagid = new Integer(idTag);
		PreparedStatement stm = null;
		ResultSet result = null;
		Tag tag = null;
		String sql = "SELECT * FROM tags WHERE IDTag = ?";
		
		try{
			stm = con.prepareStatement(sql);
			stm.setInt(1,tagid);
			result = stm.executeQuery();
			tag = createTagFromBD(tag, result);
			//TODO terminar
//			while()
		}catch (SQLException e){
			System.out.println("Message: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("ErrorCode: " + e.getErrorCode());
		} finally {
			try {
				if (result != null) {
					result.close();
				}
				if (stm != null) {
					stm.close();
				}
			} catch (SQLException e) {
			}			
		}
		return tag;
	}

	@Override
	public void insertTag(Tag tag) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Tag selectTagByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private Tag createTagFromBD(Tag tag, ResultSet result){
		tag = new TagImpl();
		
		try{
			while(result.next()){
				String nombreTag = result.getString("nombre");
				Integer IDTag = result.getInt("IDTag");
				
				tag.setIdTag(IDTag.toString());
				tag.setNombre(nombreTag);
			}
		}catch (SQLException e){
			System.out.println("Message: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("ErrorCode: " + e.getErrorCode());
		}
		
		return tag;
	}

}
