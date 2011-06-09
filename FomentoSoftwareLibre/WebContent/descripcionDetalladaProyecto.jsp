<%@page import="pos.domain.ProyectoStore"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="pos.domain.Usuario"%>
<%@ page import="pos.domain.Proyecto"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Date"%>
<%@ page import="pos.utils.FuncionesImpl"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Descripción Proyecto</title>
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

	function votarafavor() {
		document.formulario.action = "FrontController?accion=votarAFavor";
		document.formulario.submit();
	}
	function votarencontra() {
		document.formulario.action = "FrontController?accion=votarEnContra";
		document.formulario.submit();
	}
</script>

<%
	String idProyecto = request.getParameter("idProyecto");
	ProyectoStore pstore = ProyectoStore.getInstance();
	Proyecto p = pstore.obtenerProyectoPorID(idProyecto);
%>


</head>



<body background="Imagenes/fondo.jpg">
	<!--  INICIO TABLA CONTENEDORA DE TODAS LAS JSP / HTML -->
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
	<!--  FIN TABLA CONTENEDORA DE TODAS LAS JSP / HTML -->
	<!--  INICIO TABLA CONTENEDORA DE TODAS LAS JSP / HTML -->
	<table border="0">
		<tr>
			<td width="30%" class="datos_tabla" align="left">Bienvenido <a
				href="ActualizarPerfil.jsp"><%=usuario.getNombreUsuario()%></a>, Hoy
				es <%=FuncionesImpl.formateoFecha(new Date())%></td>
			<td width="30%" class="datos_tabla" align="left">Karma
				acumulado, <%=usuario.getKarma()%></td>
			<td width="40%" class="datos_tabla" align="right"><a
				href="FrontController?accion=logout">Salir</a>
			</td>
		</tr>
	</table>
	<!--  FIN TABLA CONTENEDORA DE TODAS LAS JSP / HTML -->

	<table align="center" class="borde">
		<tr>
			<td width="100%" class="tabla_principal" align="center" colspan="2">
				<strong>Proyecto</strong></td>
		</tr>
		<tr>
			<td width="50%" class="datos_tabla" align="left">Nombre:</td>
			<td width="50%" class="datos_tabla" align="left"><%=p.getNombreProyecto()%>
			</td>
		</tr>
		<tr>
			<td width="50%" class="datos_tabla" align="left">Descripción:</td>
			<td width="50%" class="datos_tabla" align="left"><%=p.getDescripcionProyecto()%>
			</td>
		</tr>
		<tr>
			<td width="50%" class="datos_tabla" align="left">Fecha de
				Inicio:</td>
			<td width="50%" class="datos_tabla" align="left"><%=p.getFechaInicio()%>
			</td>
		</tr>
		<tr>
			<td width="50%" class="datos_tabla" align="left">Fecha de Fin:</td>
			<td width="50%" class="datos_tabla" align="left"><%=p.getFechaFin()%>
			</td>
		</tr>

		<!-- 	FALTA CREAR EL STORE DE PROYECTOS <tr> -->
		<!-- 		<td width="50%" class="datos_tabla" align="left"> -->
		<!-- 			Proyecto al que pertenece: -->
		<!-- 		</td> -->
		<%-- 		<% --%>
		<!-- 			ProyectoStore storeP =  -->
		<!-- 		%> -->
		<!-- 		<td width="50%" class="datos_tabla" align="left"> -->
		<%-- 			<%=api.getVotosEnContra() %> --%>
		<!-- 		</td> -->
		<!-- 	</tr> -->
		<tr>
			<td width="50%" class="datos_tabla" align="left">Aplicación
				asociada:</td>
			<td width="50%" class="datos_tabla" align="left"><a
				href=<%=p.getAplicacion().getNombre()%>></a></td>
		</tr>
		<tr>
			<td width="100%" align="center" class="datos_tabla" colspan="2">
				<input type="button" id="atras" name="atras" value=" Atrás "
				onclick="javascript:redirigir()"></td>
		</tr>
	</table>


</body>
</html>