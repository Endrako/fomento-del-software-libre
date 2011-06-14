<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import     = "pos.domain.Usuario" %>
<%@ page import     = "pos.utils.FuncionesImpl" %>
<%@ page import     = "java.util.Date" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="JavaScript" src="js/jsencuesta.js"
	type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="css/encuesta.css">
<title>Fomento del Software Libre - Formalizar Encuesta</title>
<%Usuario usuario = (Usuario)session.getAttribute("usuario"); %>
</head>
<body background="Imagenes/fondo.jpg">
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
	<div id="info">
	<table border="0">
	<tr>
		<td width="30%" class="datos_tabla" align="left">
			Bienvenido <a href="ActualizarPerfil.jsp"><%=usuario.getNombreUsuario()%></a>, Hoy es <%=FuncionesImpl.formateoFecha(new Date())%>
		</td>
		<td width="30%" class="datos_tabla" align="left">
			Karma acumulado, <%=usuario.getKarma() %> 
		</td>
		<td width="40%" class="datos_tabla" align="right">
			<a href="FrontController?accion=logout">Salir</a>
		</td>
	</tr>
</table>
	</div>
	<form id="formulario" name="formulario" action="" method="POST">
		<div id=titulo>
			<label for=tit>Titulo de la encuesta</label> <input id="tit" name="tit"
				type="text" size=60 />
			<div id="submit">
				<input type="button" value="Publicar encuesta" onclick="validate();" />
				<div id= "atras">
				<input type="button" value="Volver a la sección de encuestas" onclick="redirigir();" />
				</div>
				<div id="removepreg">
					<input id ="quitar_pregunta" type="button" onClick="removePregunta();"name = "quitar_pregunta"
						value="Quitar Pregunta" />
				</div>
				<div id="addpreg">
					<input type="button" onClick="addPregunta();" 
						value="Añadir Pregunta" />
				</div>
			</div>
		</div>
		<div id="preguntas">
			<div id=preg1>
				<div id=removeres>
					<input type="button" onClick="removeRespuesta('preg1') " name ="quitar_respuesta"
						value="Quitar Respuesta" />
				</div>
				<div id=addres>
					<input type="button" onClick="addRespuesta('preg1')"
						value="Añadir Respuesta"/>
				</div>
				<div id="enunpreg1" class="enun">
					<label for=enun1">Enunciado de la pregunta 1:</label> <input
						name= "enunpreg01" id="enun1" type="text" size=40 /><br>
				</div>
				<div id="res1-1">
					<label for=res1> Respuesta 1</label> <input id=res1 name="res01-01"  type="text"
						size=20 /> <br>
				</div>
				<div id="res1-2">
					<label for=res2> Respuesta 2</label> <input id=res2 name="res02-01"  type="text"
						size=20 /> <br>
				</div>
			</div>
		</div>
	</form>
</body>
</html>