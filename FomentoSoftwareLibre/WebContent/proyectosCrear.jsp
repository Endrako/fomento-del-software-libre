<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>

<%@ page import="pos.domain.Usuario"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Date"%>
<%@ page import="pos.utils.FuncionesImpl"%>
<%@ page import="pos.domain.TagStore"%>
<%@ page import="pos.domain.Tag"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Crear Nuevo Proyecto</title>
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
	
	function onlyNumbersDano(evt){
	var keyPressed = (evt.which) ? evt.which : event.keyCode;
	return !(keyPressed > 31 && (keyPressed < 48 || keyPressed > 57));
	}

	function insertarProyecto() {
		alert("¡Buen emprendedor! ¡Por cada proyecto creado recibes 50 puntos de karma adicionales!");
		document.formulario.action = "FrontController?accion=nuevoProyecto";
		document.formulario.submit();
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
					De Fomento Del Sofware Libre</strong></td>
			<td width="15%" align="right"><img src="Imagenes/tux.jpg">
			</td>
		</tr>
	</table>
	<!--  FIN TABLA CONTENEDORA DE TODAS LAS JSP / HTML -->
	<table border="0">
		<tr>
			<td width="50%" class="datos_tabla" align="left">Bienvenido <a
				href="ActualizarPerfil.jsp"><%=usuario.getNombreUsuario()%></a>, Hoy
				es <%=FuncionesImpl.formateoFecha(new Date())%></td>
			<td width="50%" class="datos_tabla" align="left"><a
				href="FrontController?accion=logout">Salir</a></td>
		</tr>
	</table>
<body>

	<div id="pestanas">
		<ul>
			<li><a href="index2.jsp">Inicio</a></li>
			<li><a href="indexProyectos.jsp">Menú proyectos</a>
			<li><a title="Proyectos creados o en los que colaboras"
				href="proyectosUsuario.jsp">Mis Proyectos</a></li>
			<li><a title="Muestra los proyectos existentes"
				href="proyectosExistentes.jsp">Todos los proyectos existentes</a></li>
			<li><a href="proyectosUnirse.jsp">Unirse a un proyecto</a></li>
		</ul>

	</div>

	<form id="formulario" name="formulario" action="" method="POST">
		<table align="center" class="borde">
			<tr>
				<td width="100%" class="tabla_principal" align="center" colspan="2">
					<strong>Proyecto</strong>
				</td>
			</tr>
			<tr>
				<td width="50%" class="datos_tabla" align="left">Nombre:</td>
				<td width="50%" class="datos_tabla" align="left"><input
					type="text" id="nombre" name="nombre" value="">
				</td>
			</tr>
			<tr>
				<td width="50%" class="datos_tabla" align="left">Descripción:</td>
				<td width="50%" class="datos_tabla" align="left"><textarea
						id="descripcion" name="descripcion"></textarea>
				</td>
			</tr>
			<tr>
				<td width="50%" class="datos_tabla" align="left">Fecha de
					Inicio:</td>
				<td width="50%" class="datos_tabla" align="left"><%=FuncionesImpl.formateoFecha(new Date())%>
				</td>
			</tr>
			<tr>
				<td width="50%" class="datos_tabla" align="left">Duración en
					meses:</td>
				<td width="50%" class="datos_tabla" align="left"><input
					type="text" id="meses" name="meses" value=""
					onKeyPress="javascript:return onlyNumbersDano(event)"></td>
			</tr>
			<tr>
				<td width="50%" class="datos_tabla" align="left">Disponibilidad
				</td>
				<td width="50%" class="datos_tabla" align="left"><input
					type="checkbox" id="disponibilidad" name="disponibilidad" value="">
				</td>
			</tr>
			<tr>
				<td width="50%" class="datos_tabla" align="left">Nivel karma
					mínimo:</td>
				<td width="50%" class="datos_tabla" align="left"><input
					type="text" id="karma" name="karma" value=""
					onKeyPress="javascript:return onlyNumbersDano(event)">
				</td>
			</tr>
			<tr>
				<td width="50%" align="center" class="datos_tabla"><input
					type="button" id="aplicacion" name="aplicacion"
					value=" Crear Proyecto " onclick="javascript:insertarProyecto()">
				</td>
				<td width="50%" align="center" class="datos_tabla"><input
					type="button" id="atras" name="atras" value=" Atrás "
					onclick="javascript:redirigir()">
				</td>
			</tr>
		</table>
	</form>

</body>
</html>