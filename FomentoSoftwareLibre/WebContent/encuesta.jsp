<%@page import="pos.data.JDBCRespuestaDAO"%>
<%@page import="pos.data.IRespuestaDAO"%>
<%@page import="org.apache.catalina.connector.Request"%>
<%@page import="pos.data.JDBCEncuestaDAO"%>
<%@page import="pos.data.IEncuestaDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="pos.domain.*"%>
<%@page import="java.util.*"%>
<%@page import="pos.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="JavaScript" src="js/jsencuesta.js"
	type="text/javascript"></script>
	<link rel="stylesheet" type="text/css" href="css/encuesta.css"> 
<title>Panel de control de Encuestas</title>
</head>
<body>
	<table align="center">
		<tr>
			<td width="15%" align="left"><img src="Imagenes/tux.jpg">
			</td>
			<td class="titular" align="center" width="70%"><strong>Web
					Del Fomento Del Sofware Libre</strong>
			</td>
			<td width="15%" align="right"><img src="Imagenes/tux.jpg">
			</td>
		</tr>
	</table>
	<form>
	<div id= titulo>
	<label for= tit>Titulo de la encuesta</label> 
	<input id = "tit" type = "text" size = 60 />
	<input type = "button" value = "Publicar encuesta"/>
	<br>
	<hr>
	</div>
		<div id="pregunta">
			<div id="enun">
				<label for=enun">Enunciado de la pregunta 1:</label> <input id="enun"
					type="text" size=40 /> <br>
			</div>
			<label for=res1> Respuesta 1</label> <input id=res1 type="text"
				size=20 /> <br> <label for=res2> Respuesta 2</label> <input
				id=res2 type="text" size=20 /> <br>

			<div id="respu"></div>

			<input type="button" onClick="addRespuesta('respu')"
				value="Añadir Respuesta" />
		</div>
		<hr>
		<div id="preg"></div>
		<input type="button" onClick="addPregunta();" value="Añadir Pregunta" />
	</form>
</body>
</html>