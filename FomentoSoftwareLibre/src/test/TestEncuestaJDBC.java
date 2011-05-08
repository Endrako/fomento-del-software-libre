package test;

import java.util.LinkedList;
import java.util.List;

import pos.data.IEncuestaDAO;
import pos.data.IPreguntaDAO;
import pos.data.IRespuestaDAO;
import pos.data.JDBCEncuestaDAO;
import pos.data.JDBCPreguntaDAO;
import pos.data.JDBCRespuestaDAO;
import pos.domain.Encuesta;
import pos.domain.EncuestaImpl;
import pos.domain.Pregunta;
import pos.domain.PreguntaImpl;
import pos.domain.Respuesta;
import pos.domain.RespuestaImpl;

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
		List<Respuesta> lr= new LinkedList<Respuesta>();
		IRespuestaDAO rdao = new JDBCRespuestaDAO();
		Respuesta r = new RespuestaImpl();
		
		
		//Insertar una encuesta
		Pregunta preg = new PreguntaImpl();
		Respuesta r1 = new RespuestaImpl();
		Respuesta r2 = new RespuestaImpl();
		Respuesta r3 = new RespuestaImpl();
		Respuesta r4 = new RespuestaImpl();
		preg.setEnunciado("¿Que sistema operativo usas?");
		r1.setDescripcion("windows");
		r2.setDescripcion("Linux");
		r3.setDescripcion("Mac");
		r4.setDescripcion("Soy Chuck Norris y no necesito un sistema operativo");
		lr.clear();
		lr.add(r1);
		lr.add(r2);
		lr.add(r3);
		lr.add(r4);
		preg.setRespuestas(lr);
		
		Pregunta preg2 = new PreguntaImpl();
		Respuesta r5 = new RespuestaImpl();
		Respuesta r6 = new RespuestaImpl();
		Respuesta r7 = new RespuestaImpl();
		Respuesta r8 = new RespuestaImpl();
		preg2.setEnunciado("¿Que personaje de los siguientes te pone más cachondo?");
		r5.setDescripcion("Bill Gates");
		r6.setDescripcion("Papa Pitufo");
		r7.setDescripcion("David el Gnomo");
		r8.setDescripcion("Chuck Norris");
		List<Respuesta> lr2= new LinkedList<Respuesta>();
		lr2.clear();
		lr2.add(r5);
		lr2.add(r6);
		lr2.add(r7);
		lr2.add(r8);
		preg2.setRespuestas(lr2);
		
		List<Pregunta> lp1 = new LinkedList<Pregunta>();
		lp1.add(preg);
		lp1.add(preg2);
		e.setTituloEncuesta("Encuesta sobre el sexo de los grillos");
		e.setPreguntas(lp1);
		edao.insertarEncuesta(e);
		
		//Borrar encuesta
		
		//edao.Borrar(1127659404);
		
		//borrar pregunta
		
		//pdao.borrar(1509550783);
		
		//recuperar encuesta
	/*	e=edao.recuperarEncuesta(1);
		System.out.println(e.getTituloEncuesta());
		
		//lista de todas las encuestas
		le = edao.seleccionarTodasEncuestas();
		for (Encuesta enc :le){
			System.out.println(enc.getTituloEncuesta());
		}
		
		//recuperarPregunta
		
		//p=pdao.recuperarPregunta(1);
		//System.out.println(p.getEnunciado());
		
		preguntas de una encuesta
		lp = pdao.seleccionarTodasPreguntasPorEncuesta(2);
		for (Pregunta pr :lp){
			System.out.println(pr.getEnunciado());
		}
		
		//Respuesta de una pregunta
		lr = rdao.seleccionarTodasRespuestasPorPregunta(1);
		for (Respuesta res:lr){
			System.out.println(res.getDescripcionRespuesta());
		}
		
		//rescuperar una respuesta
		
		r=rdao.recuperarRespuesta(1);
		System.out.println("RespID: "+r.getIDRespuesta()+" "+r.getDescripcionRespuesta());
		*/
	}

}
