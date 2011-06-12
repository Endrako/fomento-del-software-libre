<%@page import="pos.domain.EncuestaStore"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import     = "pos.domain.Usuario" %>
<%@ page import     = "pos.domain.Pregunta" %>
<%@ page import     = "pos.domain.Respuesta" %>
<%@ page import     = "pos.utils.FuncionesImpl" %>
<%@ page import     = "java.util.Date" %>
<%@ page import		= "pos.domain.Encuesta" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/encuesta.css">
<%
	Usuario usuario = (Usuario) session.getAttribute("usuario");
%>
<title>Insert title here</title>
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
<!--  FIN TABLA CONTENEDORA DE TODAS LAS JSP / HTML -->
<table border="0">
	<tr>
		<td width="30%" class="datos_tabla" align="left">
			Bienvenido <a href="ActualizarPerfil.jsp"><%=usuario.getNombreUsuario()%></a>, Hoy es <%=FuncionesImpl.formateoFecha(new Date())%>
		</td>
		<td width="30%" class="datos_tabla" align="left">
			Karma acumulado, <%=usuario.getKarma()%>
		</td>
		<td width="40%" class="datos_tabla" align="right">
			<a href="FrontController?accion=logout">Salir</a>
		</td>
	</tr>
</table>
	<%
		EncuestaStore eStore = new EncuestaStore();
		Encuesta e = eStore.obtenerEncuesta(request
				.getParameter("idEncuesta"));
	%>
	<div id="encuesta">
		<div id="titulo">
			<h1><%=e.getTituloEncuesta()%></h1>
		</div>
		<div id="preguntas">
			<%
				for (Pregunta p : e.getPreguntas()) {
			%>
			<div id="enun">
			<h4><%=p.getEnunciado()%></h4>
			</div>
			<div id=res>
			<%=p.getRespuestas().get(0).getDescripcionRespuesta() %>
			</div>
		<%
		}
		%>
		</div>
	</div>


</body>
</html>