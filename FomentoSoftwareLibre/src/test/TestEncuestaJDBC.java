package test;

import java.util.LinkedList;
import java.util.List;

import pos.data.IEncuestaDAO;
import pos.data.IPreguntaDAO;
import pos.data.JDBCEncuestaDAO;
import pos.data.JDBCPreguntaDAO;
import pos.domain.Encuesta;
import pos.domain.EncuestaImpl;
import pos.domain.Pregunta;
import pos.domain.PreguntaImpl;

public class TestEncuestaJDBC {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Encuesta e = new EncuestaImpl();
		IEncuestaDAO edao = new JDBCEncuestaDAO();
		List<Encuesta> le = new LinkedList<Encuesta>();
		Pregunta p = new PreguntaImpl();
		List<Pregunta> lp = new LinkedList<Pregunta>();
		IPreguntaDAO pdao = new JDBCPreguntaDAO();
		
		//recuperar encuesta
		e=edao.recuperarEncuesta(1);
		System.out.println(e.getTituloEncuesta());
		
		//lista de todas las encuestas
		le = edao.seleccionarTodasEncuestas();
		for (Encuesta enc :le){
			System.out.println(enc.getTituloEncuesta());
		}
		
		//recuperarPregunta
		
		p=pdao.recuperarPregunta(1);
		System.out.println(p.getEnunciado());
		
		//preguntas de una encuesta
		lp = pdao.seleccionarTodasPreguntasPorEncuesta(1);
		for (Pregunta pr :lp){
			System.out.println(pr.getEnunciado());
		}
		
	}

}
