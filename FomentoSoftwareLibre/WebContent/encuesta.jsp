<%@page import="pos.data.JDBCRespuestaDAO"%>
<%@page import="pos.data.IRespuestaDAO"%>
<%--  <%@page import="org.apache.catalina.connector.Request"%>--%>
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
	<div id="encabezado">
		<table align="center">
			<tr>
				<td width="15%" align="left"><img src="Imagenes/tux.jpg">
				</td>
				<td class="titular" align="center" width="70%"><strong>Web
						Del Fomento Del Sofware Libre</strong></td>
				<td width="15%" align="right"><img src="Imagenes/tux.jpg">
				</td>
			</tr>
		</table>
	</div>
	<form id="formulario" name="formulario" action="" method="POST">
		<div id=titulo>
			<label for=tit>Titulo de la encuesta</label> <input id="tit"
				type="text" size=60 />
			<div id="submit">
				<input type="button" value="Publicar encuesta" onclick="validate();" />
				<div id="removepreg">
					<input id ="quitar_pregunta" type="button" onClick="removePregunta();"name = "quitar_pregunta"
						value="Quitar Pregunta" />
				</div>
				<div id="addpreg">
					<input type="button" onClick="addPregunta();" 
						value="Añadir Pregunta" />
				</div>
			</div>
			<hr>
		</div>
		<div id="preguntas">
			<div id=preg1>
				<div id=removeres>
					<input type="button" onClick="removeRespuesta('preg1') " name ="quitar_respuesta"
						value="Quitar Respuesta" />
				</div>
				<div id=addres>
					<input type="button" onClick="addRespuesta('preg1')"
						value="Añadir Respuesta" />
				</div>
				<div id="enunpreg1">
					<label for=enun1">Enunciado de la pregunta 1:</label> <input
						name= "enunpreg1" id="enun1" type="text" size=40 /> <br>
				</div>
				<div id="res1-1">
					<label for=res1> Respuesta 1</label> <input id=res1 type="text"
						size=20 /> <br>
				</div>
				<div id="res1-2">
					<label for=res2> Respuesta 2</label> <input id=res2 type="text"
						size=20 /> <br>
				</div>
			</div>
		</div>
	</form>
</body>
</html>