<%@page import="pos.domain.ProyectoStore"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="java.util.Date"%>
<%@ page import="pos.utils.FuncionesImpl"%>
<%@ page import="pos.domain.Usuario"%>
<%@ page import="pos.domain.UsuarioStore"%>



<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- <link rel="stylesheet" type="text/css" href="css/estilos_proyecto.css"> -->
<title>Área de proyectos</title>
<script language="JavaScript" src="js/funcionesComunes.js"
	type="text/javascript"></script>
<script language="JavaScript">
	var css = "css/estilos.css";
	document
			.write("<link href='" + css + "' rel='stylesheet' type='text/css'>");
<%Usuario usuario = (Usuario) session.getAttribute("usuario");%>
	function redirigir() {
		window.location = "indexProyectos.jsp";
	}
</script>
</head>
<body background="Imagenes/fondo.jpg">
	<!--  INICIO TABLA CONTENEDORA DE TODAS LAS JSP / HTML -->
	<table align="center">
		<tr>
			<td width="15%" align="left"><img src="Imagenes/tux.jpg">
			</td>
			<td class="titular" align="center" width="70%"><strong>Web
					De Fomento Del Sofware Libre</strong>
			</td>
			<td width="15%" align="right"><img src="Imagenes/tux.jpg">
			</td>
		</tr>
	</table>
	<!--  FIN TABLA CONTENEDORA DE TODAS LAS JSP / HTML -->

	<table border="0">
		<tr>
			<td width="30%" class="datos_tabla" align="left">Bienvenido <a
				href="ActualizarPerfil.jsp"><%=usuario.getNombreUsuario()%></a>, Hoy
				es <%=FuncionesImpl.formateoFecha(new Date())%></td>
			<td width="30%" class="datos_tabla" align="left">Karma
				acumulado, <%=usuario.getKarma()%></td>
			<td width="40%" class="datos_tabla" align="right"><a
				href="FrontController?accion=logout">Salir</a></td>
		</tr>
	</table>
	<!--  FIN TABLA CONTENEDORA DE TODAS LAS JSP / HTML -->

	<div id="pestanas">
		<ul>
			<li><a href="javascript:redirigir()">Inicio</a></li>
			<li><a href="indexProyectos.jsp">Menú proyectos</a>
			<li><a title="Proyectos creados o en los que colaboras"
				href="proyectosUsuario.jsp">Mis Proyectos</a></li>
			<li><a title="Muestra los proyectos existentes"
				href="proyectosExistentes.jsp">Todos los proyectos existentes</a></li>
			<li><a href="proyectosCrear.jsp">Crear un nuevo proyecto</a></li>
		</ul>

	</div>

	<h1 align="center" >Vaya...parece que hay un error</h1>
	<br>
	<h2>Comprueba uno de los siguientes puntos:</h2>
	<br>
	<ul>
	<li><h3> Has dejado el campo "nombre", "karma" o "meses" en blanco en el
		formulario de crear proyectos. Bastante que no te permita meter
		letras... no seas malo ;).</h3></li>
	<li><h3>Has creado un proyecto con el mismo nombre que uno existente! Venga ya!
		Ya es casualidad, tío, si pegas 2 cabezazos en el teclado y ocurre de nuevo te subo 2000 de karma! (es broma, gánatelos...).</h3></li>
		<li><h3> Has intentado crear un proyecto y tienes menos de 200 puntos de karma, ¿no pillín? Si es que no puede ser, tanta ansia...</h3></li>
</ul>
</body>
</html>