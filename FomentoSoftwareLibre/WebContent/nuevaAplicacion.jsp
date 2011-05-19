<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import     = "java.util.ArrayList" %>
<%@ page import     = "java.util.List" %>
<%@ page import     = "java.util.Date" %>
<%@ page import     = "pos.utils.FuncionesImpl" %>
<%@ page import     = "pos.domain.PaisStore" %>
<%@ page import     = "pos.domain.Pais" %>
<%@ page import     = "pos.domain.ProvinciaStore" %>
<%@ page import     = "pos.domain.AplicacionStore" %>
<%@ page import     = "pos.domain.Provincia" %>
<%@ page import     = "pos.domain.Aplicacion" %>
<%@ page import     = "pos.domain.Usuario" %>
<%@ page import     = "pos.domain.SoStore" %>
<%@ page import     = "pos.domain.SO" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Nueva Aplicacion</title>
 <script language="JavaScript" src="js/funcionesComunes.js" type="text/javascript"></script>
<script language="JavaScript" >
			var css="css/estilos.css";
		document.write("<link href='" + css + "' rel='stylesheet' type='text/css'>"); 
		<%
			Usuario usuario = (Usuario)session.getAttribute("usuario");
		%>
		
		function redirigir(){
			window.location="aplicaciones.jsp";
		}
		
		function insertarA(){
			alert("Debes saber que insertar una nueva aplicación te dará 20 puntos de Karma!! además de 5 puntos más cada vez que la voten positivamente.")
			document.formulario.action = "FrontController?accion=insertarAplicacion";
			document.formulario.submit();
		}
</script>
</head>
<body background="Imagenes/fondo.jpg">
<!--  INICIO TABLA CONTENEDORA DE TODAS LAS JSP / HTML -->
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
		<td width="50%" class="datos_tabla" align="left">
			Bienvenido <a href="ActualizarPerfil.jsp"><%=usuario.getNombreUsuario()%></a>, Hoy es <%=FuncionesImpl.formateoFecha(new Date())%>
		</td>
		<td width="50%" class="datos_tabla" align="left">
			<a href="FrontController?accion=logout">Salir</a>
		</td>
	</tr>
</table>
<form id="formulario" name="formulario" action="" method="POST">
<table align="center" class="borde">
	<tr>
		<td width="100%" class="tabla_principal" align="center" colspan="2">
			<strong>Aplicación</strong>
		</td>
	</tr>
	<tr>
		<td width="50%" class="datos_tabla" align="left">
			Nombre:
		</td>
		<td width="50%" class="datos_tabla" align="left">
			<input type="text" id="nombre" name="nombre" value="">
		</td>
	</tr>
	<tr>
		<td width="50%" class="datos_tabla" align="left">
			Descripción:
		</td>
		<td width="50%" class="datos_tabla" align="left">
			<textarea id="descripcion" name="descripcion"></textarea>
		</td>
	</tr>
	<tr>
		<td width="50%" class="datos_tabla" align="left">
			Fecha de Publicación:
		</td>
		<td width="50%" class="datos_tabla" align="left">
			<%= FuncionesImpl.formateoFecha(new Date()) %>
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
		<td width="50%" class="datos_tabla" align="left">
			Sitio de descarga:
		</td>
		<td width="50%" class="datos_tabla" align="left">
			<input type="text" id="sitioWeb" name="sitioWeb" value="">
		</td>
	</tr>
	<tr>
		<td width="100%" align="center" class="datos_tabla">
			<input type="button" id="aplicacion" name="aplicacion" value=" Insertar Aplicacion " onclick="javascript:insertarA()">
		</td>
		<td width="100%" align="center" class="datos_tabla">
			<input type="button" id="atras" name="atras" value=" Atrás " onclick="javascript:redirigir()">
		</td>
	</tr>
</table>
</form>
</body>
</html>