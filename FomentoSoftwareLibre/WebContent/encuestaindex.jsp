<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import     = "pos.domain.Usuario" %>
<%@ page import     = "pos.utils.FuncionesImpl" %>
<%@ page import     = "java.util.Date" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/encuesta.css">
<title>Fomento Del Software Libre - Encuestas</title>
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
<div id="pestanas">
   <ul>
      <li><a href="encuesta.jsp">Crear una encuesta [Necesario 100 Karma]</a></li>
      <li><a href="">Gestiona tus encuestas</a></li>
      <li><a href="">Ver listado de encuestas</a></li>
      <li><a href="index2.jsp">Volver a la página principal</a></li>
   </ul>
</div>
</body>
</html>