<%@page import="pos.domain.VotoImpl"%>
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
<%@ page import     = "pos.domain.*" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script language="JavaScript" src="js/votar.js"
	type="text/javascript"></script>
<title>Descripción Aplicación</title>
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
		
		function votarafavor(idAplicacion){
			document.formulario.action = "FrontController?accion=votarAFavor&idAplicacion="+idAplicacion;
			document.formulario.submit();
			window.location="aplicaciones.jsp";
		}
		function votarencontra(idAplicacion){
			document.formulario.action = "FrontController?accion=votarEnContra&idAplicacion="+idAplicacion;
			document.formulario.submit();
			window.location="aplicaciones.jsp";
		}
		

</script>
<%
	String idAplicacion = request.getParameter("idAplicacion");
	AplicacionStore store = AplicacionStore.getInstance();
	Aplicacion api = store.getAplicacion(idAplicacion);
	VotoStore vstore = VotoStore.getInstance();
	Boolean valido = vstore.isVoto(usuario.getIdUser(),idAplicacion);
	String boton;
%>
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
<!--  INICIO TABLA CONTENEDORA DE TODAS LAS JSP / HTML -->
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
<!--  FIN TABLA CONTENEDORA DE TODAS LAS JSP / HTML -->
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
			<%=api.getNombre() %>
		</td>
	</tr>
	<tr>
		<td width="50%" class="datos_tabla" align="left">
			Descripción:
		</td>
		<td width="50%" class="datos_tabla" align="left">
			<%=api.getDescripcion() %>
		</td>
	</tr>
	<tr>
		<td width="50%" class="datos_tabla" align="left">
			Fecha de Publicación:
		</td>
		<td width="50%" class="datos_tabla" align="left">
			<%=api.getFechaPublicacion() %>
		</td>
	</tr>
	<tr>
		<td width="50%" class="datos_tabla" align="left">
			Número de votos a favor:
		</td>
		<td width="50%" class="datos_tabla" align="left">
			<%=api.getVotosAFavor() %>
		</td>
	</tr>
	<tr>
		<td width="50%" class="datos_tabla" align="left">
			Número de votos en contra:
		</td>
		<td width="50%" class="datos_tabla" align="left">
			<%=api.getVotosEnContra() %>
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
			<a href=<%=api.getURLWeb()%>></a>
		</td>
	</tr>
	<% if(valido){ %>
	<tr>
		<td width="50%" align="left" class="datos_tabla">
			&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" id="votarAFavor" name="votarAFavor"  value=" Votar a Favor " onclick="javascript:votarafavor(<%=idAplicacion%>);">
		</td>
		<td width="50%" align="center" class="datos_tabla">
			<input type="button" id="votarEnContra" name="votarEnContra" value=" Votar en Contra " onclick="javascript:votarencontra(<%=idAplicacion%>);">
		</td>
	</tr>
	<% } %>
	<tr>
		<td width="100%" align="center" class="datos_tabla" colspan="2">
			<input type="button" id="atras" name="atras" value=" Atrás " onclick="javascript:redirigir()">
		</td>
	</tr>
</table>
</form>
</body>
</html>