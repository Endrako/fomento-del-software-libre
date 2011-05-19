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
<%@ page import     = "pos.domain.UsuarioStore" %>
<%@ page import     = "pos.domain.SoStore" %>
<%@ page import     = "pos.domain.SO" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Aplicaciones</title>
 <script language="JavaScript" src="js/funcionesComunes.js" type="text/javascript"></script>
<script language="JavaScript" >
			var css="css/estilos.css";
		document.write("<link href='" + css + "' rel='stylesheet' type='text/css'>"); 
		<%
			Usuario usuario = (Usuario)session.getAttribute("usuario");
		%>

		function recuperarAplicacion(idAplicacion){
			document.formulario.action = "FrontController?accion=recuperarPerfilAplicacion&idAplicacion="+ idAplicacion ;
			document.formulario.submit();
		}
		
		function redirigir(){
			window.location="index2.jsp";
		}
		
		function nuevaA(){
			document.formulario.action = "FrontController?accion=nuevaAplicacion";
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
			<strong> Listas de Aplicaciones </strong>
		</td>
	</tr>
	<tr>
		<td width="50%" class="tabla_principal2" align="left">
			<strong>Nombre aplicación: </strong>
		</td>
		<td width="50%" class="tabla_principal2" align="left">
			<strong>Descripción Detallada</strong>
		</td>
	</tr>
	<%
		AplicacionStore store = AplicacionStore.getInstance();
		List<Aplicacion> lista = store.getAplicaciones();
		for ( Aplicacion a : lista){
			
	%>
	<tr>
		<td width="50%" class="datos_tabla" align="left">
			<%=a.getNombre() %>
		</td>
		<td width="50%" class="datos_tabla" align="left">
			 <input type="button" id="<%=a.getIDAplicacion()%>" name="<%=a.getIDAplicacion()%>" onClick="javascript:recuperarAplicacion(this.id)" value="Ver descripción">
		</td>
	</tr>
	<%} %>
	<tr>
		<td width="60%" align="left" class="datos_tabla">
			<input type="button" id="nuevaAplicacion" name="nuevaAplicacion" value=" Nueva aplicación " onclick="javascript:nuevaA();">
		</td>
		<td width="40%" align="left" class="datos_tabla">
			<input type="button" id="atras" name="atras" value=" Atrás " onclick="javascript:redirigir()">
		</td>
</table>
</form>
</body>
</html>