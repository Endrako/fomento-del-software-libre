package pos.data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mysql.jdbc.Connection;

import pos.domain.Aplicacion;
import pos.domain.Enfrentamiento;

public class JDBCEnfrentamientoDAO implements IEnfrentamientoDAO{
	
	//Para obtener un objeto Aplicacion mediante la ID utiliza el método getAplicacionByID
	//de la clase JDBCAplicacionDAO
	
	public List<Enfrentamiento> selectAll(Connection con) {
		Enfrentamiento enfrentamiento=null;
		List<Enfrentamiento> lista = new ArrayList<Enfrentamiento>();
		String sql= "SELECT * FROM Enfrentamientos";		
		PreparedStatement stm=null;
		ResultSet result = null;
	
		try {
			stm=con.prepareStatement(sql);
			result =stm.executeQuery(sql);
			while(result.next()){
//				Integer IDapl1=result.getInt("IDAplicacion1");
//				Integer IDapl2=result.getInt("idAplicacion2");
//				String descripcion=result.getString("descripcion");
//				Integer votosAply1=result.getInt("votosApp1");
//				Integer votosAply2=result.getInt("votosApp2");
//				Date fechaCreacion = result.getDate("fechaCreacion");
//				Date fechaFin = result.getDate("fechaFin");
//				Aplicacion aplicacion1= getAplicacionByID(IDapl1.toString());
//				Aplicacion aplicacion2= getAplicacionByID(IDapl2.toString());
//				enfrentamiento.setAplicacion1(aplicacion1);
//				enfrentamiento.setAplicacion2(aplicacion2);
//				enfrentamiento.setDescripcion(descripcion);
//				enfrentamiento.setFechaCreacion(fechaCreacion);
//				enfrentamiento.setFechaFin(fechaFin);
				enfrentamiento = createEnfrentamientoFromBD(enfrentamiento, result);
				lista.add(enfrentamiento);
			}
		} catch (SQLException e) {			
			e.printStackTrace();
		}finally {
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
		return lista;
	}

	public Enfrentamiento selectEnfrentamientoByID(Connection con,String IDEnfrentamiento) {
		Enfrentamiento enfrentamiento =null;
		String sql="SELECT * FROM Enfrentamientos WHERE (IDEnfrentamiento = ?)";
		PreparedStatement stm=null;
		ResultSet result=null;
		
		try {
			stm = con.prepareStatement(sql);
			stm.setString(0, IDEnfrentamiento);
			result=stm.executeQuery();
			enfrentamiento = createEnfrentamientoFromBD(enfrentamiento, result);
//			Integer IDapl1=result.getInt("IDAplicacion1");
//			Integer IDapl2=result.getInt("idAplicacion2");
//			String descripcion=result.getString("descripcion");
//			Integer votosAply1=result.getInt("votosApp1");
//			Integer votosAply2=result.getInt("votosApp2");
//			Date fechaCreacion = result.getDate("fechaCreacion");
//			Date fechaFin = result.getDate("fechaFin");
//			Aplicacion aplicacion1= getAplicacionByID(IDapl1.toString());
//			Aplicacion aplicacion2= getAplicacionByID(IDapl2.toString());
//			enfrentamiento.setAplicacion1(aplicacion1);
//			enfrentamiento.setAplicacion2(aplicacion2);
//			enfrentamiento.setDescripcion(descripcion);
//			enfrentamiento.setFechaCreacion(fechaCreacion);
//			enfrentamiento.setFechaFin(fechaFin);			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
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
		return enfrentamiento;		
	}

	public List<Enfrentamiento> selectEnfrentamientoByUserCreator(Connection con,String IDUser) {
		// En la BD no hay un usuario creador.
		return null;
	}

	@Override
	public List<Enfrentamiento> selectEnfrentamientoByAply(Connection con,String IDAply) {
			
		List<Enfrentamiento> lista=new ArrayList<Enfrentamiento>();
		Enfrentamiento enfrentamiento = null;
		String sql = "SELECT * FROM Enfrentamientos WHERE ( IDAplicacion1 = ? ) OR (idAplicacion2 = ? )";
		PreparedStatement stm= null;
		ResultSet result=null;
		
		try {
			stm=con.prepareStatement(sql);
			stm.setString(0, IDAply);
			stm.setString(1, IDAply);
			result=stm.executeQuery();
			
			while(result.next()){
				enfrentamiento = createEnfrentamientoFromBD(enfrentamiento, result);
//				Integer IDapl1=result.getInt("IDAplicacion1");
//				Integer IDapl2=result.getInt("idAplicacion2");
//				String descripcion=result.getString("descripcion");
//				Integer votosAply1=result.getInt("votosApp1");
//				Integer votosAply2=result.getInt("votosApp2");
//				Date fechaCreacion = result.getDate("fechaCreacion");
//				Date fechaFin = result.getDate("fechaFin");
//				Aplicacion aplicacion1= getAplicacionByID(IDapl1.toString());
//				Aplicacion aplicacion2= getAplicacionByID(IDapl2.toString());
//				enfrentamiento.setAplicacion1(aplicacion1);
//				enfrentamiento.setAplicacion2(aplicacion2);
//				enfrentamiento.setDescripcion(descripcion);
//				enfrentamiento.setFechaCreacion(fechaCreacion);
//				enfrentamiento.setFechaFin(fechaFin);
				lista.add(enfrentamiento);
			}			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
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
		return lista;
	}

	@Override
	public List<Enfrentamiento> selectEnfrentamientosAcept(Connection con) {
		Enfrentamiento enfrentamiento=null;
		List<Enfrentamiento> lista = new ArrayList<Enfrentamiento>();
		String sql="SELECT * FROM Enfrentamientos WHERE aceptado=1";
		PreparedStatement stm=null;
		ResultSet result=null;
		
		try {
			stm = con.prepareStatement(sql);
			result=stm.executeQuery();
			while(result.next()){
				enfrentamiento = createEnfrentamientoFromBD(enfrentamiento, result);
//				Integer IDapl1=result.getInt("IDAplicacion1");
//				Integer IDapl2=result.getInt("idAplicacion2");
//				String descripcion=result.getString("descripcion");
//				Integer votosAply1=result.getInt("votosApp1");
//				Integer votosAply2=result.getInt("votosApp2");
//				Date fechaCreacion = result.getDate("fechaCreacion");
//				Date fechaFin = result.getDate("fechaFin");
//				Aplicacion aplicacion1= getAplicacionByID(IDapl1.toString());
//				Aplicacion aplicacion2= getAplicacionByID(IDapl2.toString());
//				enfrentamiento.setAplicacion1(aplicacion1);
//				enfrentamiento.setAplicacion2(aplicacion2);
//				enfrentamiento.setDescripcion(descripcion);
//				enfrentamiento.setFechaCreacion(fechaCreacion);
//				enfrentamiento.setFechaFin(fechaFin);
				lista.add(enfrentamiento);
			}			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
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
		return lista;
	}

	@Override
	public List<Enfrentamiento> selectEnfrentamientosNonAcept(Connection con) {
		Enfrentamiento enfrentamiento = null;
		List<Enfrentamiento> lista = new ArrayList<Enfrentamiento>();
		String sql="SELECT * FROM Enfrentamientos WHERE aceptado=0";
		PreparedStatement stm = null;
		ResultSet result = null;
		
		try {
			stm = con.prepareStatement(sql);
			result = stm.executeQuery();
			
			while(result.next()){
				enfrentamiento = createEnfrentamientoFromBD(enfrentamiento, result);
				lista.add(enfrentamiento);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try{
				if(result !=null){
					result.close();
				}
				if(stm !=null){
					stm.close();
				}				
			}catch (SQLException e){				
			}
		}
		return lista;
		
	}

	@Override
	public void insertEnfrentamiento(Connection con,Enfrentamiento enfrentamiento) {
		String sql = "INSERT INTO Enfrentamientos (IDAplicacion1,idAplicacion2,descripcion,votosApp1,votosApp2,fechaCreacion,fechaFin,aceptado) VALUES (?,?,?,?,?,?,?,?) ";
		PreparedStatement stm=null;
		
		Aplicacion aplicacion1=enfrentamiento.getAplicacion1();
		Aplicacion aplicacion2=enfrentamiento.getAplicacion2();
		//Me hace falta un método que dandle una aplicacion me de su ID
		Integer IDAply1= ;
		Integer IDAply2= ;
		String descripcion = enfrentamiento.getDescripcion();
		Date fechaCreacion = enfrentamiento.getFechaCreacion();
		Date fechaFin = enfrentamiento.getFechaFin();
		//Votos se inicializan a 0, y aceptado a FALSE (0)
		try{
			stm = con.prepareStatement(sql);
			
			stm.setInt(0,IDAply1);
			stm.setInt(1,IDAply2);
			stm.setString(2,descripcion);
			stm.setInt(3,0);//votosApp1
			stm.setInt(4,0);//votosApp2
			stm.setDate(5,(java.sql.Date) fechaCreacion);
			stm.setDate(6,(java.sql.Date) fechaFin);
			stm.setBoolean(7,false);	
			
			stm.executeUpdate();
		}catch (SQLException e){
			
		}finally{
			try{
				if(stm !=null){
					stm.close();
				}
			}catch (SQLException e){
				
			}
		}		
	}

	@Override
	public void deleteEnfrentamiento(Connection con,Enfrentamiento enfrentamiento) {
		String sql = "DELETE FROM Enfrentamientos WHERE"
			//obtener un enfrentamiento cuyas aplicaciones 1 y 2 coincidan, ya que no tengo OID
		
	}
	
	private Enfrentamiento createEnfrentamientoFromBD(Enfrentamiento enfrent,ResultSet resSet){
		Integer IDapl1=resSet.getInt("IDAplicacion1");
		Integer IDapl2=resSet.getInt("idAplicacion2");
		String descripcion=resSet.getString("descripcion");
		Integer votosAply1=resSet.getInt("votosApp1");
		Integer votosAply2=resSet.getInt("votosApp2");
		Date fechaCreacion = resSet.getDate("fechaCreacion");
		Date fechaFin = resSet.getDate("fechaFin");
		Aplicacion aplicacion1= getAplicacionByID(IDapl1.toString());
		Aplicacion aplicacion2= getAplicacionByID(IDapl2.toString());
		enfrent.setAplicacion1(aplicacion1);
		enfrent.setAplicacion2(aplicacion2);
		enfrent.setDescripcion(descripcion);
		enfrent.setFechaCreacion(fechaCreacion);
		enfrent.setFechaFin(fechaFin);
	}
	
	

}
