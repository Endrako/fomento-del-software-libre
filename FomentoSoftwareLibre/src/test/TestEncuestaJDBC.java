package test;

import com.mysql.jdbc.JDBC4CallableStatement;

import pos.data.IEncuestaDAO;
import pos.data.JDBCEncuestaDAO;
import pos.domain.Encuesta;
import pos.domain.EncuestaImpl;

public class TestEncuestaJDBC {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Encuesta e = new EncuestaImpl();
		IEncuestaDAO edao = new JDBCEncuestaDAO();
		e=edao.recuperarEncuesta(1);
		System.out.print(e.getTituloEncuesta());
	}

}
