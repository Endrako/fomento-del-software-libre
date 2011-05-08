<%@page import="pos.data.JDBCRespuestaDAO"%>
<%@page import="pos.data.IRespuestaDAO"%>
<%@page import="org.apache.catalina.connector.Request"%>
<%@page import="pos.data.JDBCEncuestaDAO"%>
<%@page import="pos.data.IEncuestaDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="pos.domain.*" %>
<%@page import="java.util.*" %>
<%@page import="pos.*" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Panel de control de Encuestas</title>
</head>
<body>
<table align="center">
	<tr>
		<td width="15%" align="left">
			<img src="Imagenes/tux.jpg">
		</td>
		<td class="titular" align="center" width="70%">
			<strong>Web Del Fomento Del Sofware Libre</strong>
		</td>
		<td width="15%" align="right">
			<img src="Imagenes/tux.jpg">
		</td>
	</tr>
</table>
<%Respuesta r = new RespuestaImpl();
  IRespuestaDAO edao = new JDBCRespuestaDAO();
  String cad = new String();
  Pregunta paux = new PreguntaImpl();
  List<Pregunta> lp = new LinkedList<Pregunta>();
%>
<h3>Pagina provisional para probar la "Inserción de la encuesta"</h3>
Nota informativa: Hay que rellenar todos los campos si no petará.<br>
<form id="formulario" name="formulario" action="encuesta.jsp" method="post">
<label>Introduzca Titulo de la Encuesta: </label><input type="text" size="50" id="tit" name="tit">
<br><br> 
<label>Introduzca Pregunta: </label><input type="text" size="50">
<br><br>
<label>Introduzca Respuesta 1: </label><input type="text" size="50">
<br>
<label>Introduzca Respuesta 2: </label><input type="text" size="50">
<br>
<button type="button" onclick="
<%cad=request.getParameter("tit");
r.setDescripcion(cad);
edao.insertarRespuesta(0,r);
%>"> Enviar Encuesta</button>
</form>
<br>
</body>
</html>