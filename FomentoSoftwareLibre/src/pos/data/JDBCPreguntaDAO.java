package pos.data;

import java.sql.Connection;
import java.util.List;

import pos.domain.Pregunta;

public class JDBCPreguntaDAO implements IPreguntaDAO {
	
	 private Connection conn;
	 private IPreguntaDAO pdao;
	 private IRespuestaDAO rdao;
	 
	 public JDBCPreguntaDAO(){
		 conn = ConnectionManager.getInstance().checkOut();
		 pdao = new JDBCPreguntaDAO();
	 }
	 
	 protected void finalize() {
	        ConnectionManager.getInstance().checkIn(conn);
	 }
	
	 
	@Override
	public void borrar(String PreguntaID) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Pregunta> seleccionarTodasPreguntas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertarPregunta(Pregunta p) {
		// TODO Auto-generated method stub

	}

	@Override
	public Pregunta recuperarPregunta() {
		// TODO Auto-generated method stub
		return null;
	}

}
