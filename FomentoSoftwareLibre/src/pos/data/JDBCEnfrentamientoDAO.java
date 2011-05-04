package pos.data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import pos.domain.Enfrentamiento;

public class JDBCEnfrentamientoDAO implements IEnfrentamientoDAO{
	
	
	public List<Enfrentamiento> selectAll(Connection con) {
		List<Enfrentamiento> lista = new ArrayList();
		String sql= "SELECT * FROM Enfrentamientos";
		PreparedStatement stm=null;
		ResultSet result;
		Enfrentamiento enfrentamiento=null;
		
		try {
			stm=con.prepareStatement(sql);
			result =stm.executeQuery(sql);
			while(result.i)
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	@Override
	public Enfrentamiento selectEnfrentamientoByID(String IDEnfrentamiento) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Enfrentamiento> selectEnfrentamientoByUserCreator(String IDUser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Enfrentamiento> selectEnfrentamientoByAply(String IDAply) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Enfrentamiento> selectEnfrentamientosAcept() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Enfrentamiento> selectEnfrentamientosNonAcept() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertEnfrentamiento(Enfrentamiento enfrentamiento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteEnfrentamiento(Enfrentamiento enfrentamiento) {
		// TODO Auto-generated method stub
		
	}

}
