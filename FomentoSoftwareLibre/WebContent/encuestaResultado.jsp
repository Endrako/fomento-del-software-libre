<%@page import="pos.domain.UsuarioStore"%>
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
<title>Fomento del Software Libre - Realizar encuesta</title>
<script type="text/javascript">

function redirigir(){
	window.location="encuestalistado.jsp";
}

</script>
</head>
<body background="Imagenes/fondo.jpg">
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
<form id="formulario" name="formulario" action="" method="POST">
	<%
		EncuestaStore eStore = new EncuestaStore();
		Encuesta e = eStore.obtenerEncuesta(request.getParameter("idEncuesta"));
		UsuarioStore us = new UsuarioStore();
	%>
	<div id="encuesta">
		<div id="titulo">
			<h1><%=e.getTituloEncuesta()%></h1>
		</div>
			<h4>Encuesta creada por <i><%=us.recuperarUsuarioByIdUsuario(e.getUsuario()).getNombreUsuario()%></i></h4>
		<div id="preguntas">
			<%
				for (int i =0; i<e.getPreguntas().size();i++) {
			%>
			<div id="enun">
			<h4><%=i+1%>) <%=e.getPreguntas().get(i).getEnunciado()%></h4>
			</div>
				<%
				for (Respuesta r : e.getPreguntas().get(i).getRespuestas()){
				%>
			<div id=res>
			<%=r.getDescripcionRespuesta() %> <center><font color="red"><b><%=r.getNumeroVotos() %></b></font> </center>
			</div>
			<%} %>
		<%
		}
		%>
		</div>
	</div>
	 <div id= atras>
	<input type="button" id="atras" name="atras" value=" Atras "
					onclick="javascript:redirigir()">

	</div>
	</form>
</body>
</html>