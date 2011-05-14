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

	private Connection conn;
	
	public JDBCTagDAO(){
		conn = (Connection) ConnectionManager.getInstance()
		.checkOut();
	}
	@Override
	public List<Tag> selectAll() {
		List<Tag> listaTags = new ArrayList<Tag>();
		Tag tag = null;
		PreparedStatement stm = null;
		ResultSet result = null;
		String sql = "SELECT * FROM tags";
		
		try{
			stm = conn.prepareStatement(sql);
			result = stm.executeQuery();
			
			while(result.next()){
				tag = new TagImpl(result.getString("IDTag"),result.getString("nombre"));
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
		PreparedStatement stm = null;
		ResultSet result = null;
		Tag tag = null;
		String sql = "SELECT * FROM tags WHERE IDTag = ?";
		
		try{
			stm = conn.prepareStatement(sql);
			stm.setString(1,idTag);
			result = stm.executeQuery();
			while(result.next()){
				tag = new TagImpl(result.getString("IDTag"),result.getString("nombre"));
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
		return tag;
	}

	@Override
	public void insertTag(Tag tag) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Tag selectTagByName(String name) {
		PreparedStatement stm = null;
		ResultSet result = null;
		Tag tag = null;
		String sql = "SELECT * FROM tags WHERE nombre = ?";
		
		try{
			stm = conn.prepareStatement(sql);
			stm.setString(1,name);
			result = stm.executeQuery();
			
			while(result.next()){
				tag = new TagImpl(result.getString("IDTag"),result.getString("nombre"));
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
		return tag;
	}
	
	

}
