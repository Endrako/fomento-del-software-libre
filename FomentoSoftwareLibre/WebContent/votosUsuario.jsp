<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import     = "java.util.ArrayList" %>
<%@ page import     = "java.util.List" %>
<%@ page import     = "java.util.Date" %>
<%@ page import     = "pos.utils.FuncionesImpl" %>
<%@ page import     = "pos.domain.VotoStore" %>
<%@ page import     = "pos.domain.Voto" %>
<%@ page import     = "pos.domain.AplicacionStore" %>
<%@ page import     = "pos.domain.Aplicacion" %>
<%@ page import     = "pos.domain.Usuario" %>
<%@ page import     = "pos.domain.UsuarioStore" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Votos</title>
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
			<strong> Listas de Votos </strong>
		</td>
	</tr>
	<tr>
		<td width="50%" class="tabla_principal2" align="left">
			<strong>Nombre aplicación: </strong>
		</td>
		<td width="50%" class="tabla_principal2" align="left">
			<strong>Valor</strong>
		</td>
	</tr>
	<%
		VotoStore store = VotoStore.getInstance();
		List<Voto> lista = store.getVotos();
		for (Voto v : lista){
			if(v.getUsuario().equals(usuario.getIdUser())){
	%>
	<tr>
		<td width="50%" class="datos_tabla" align="left">
			<%=v.getAplicacion() %>
		</td>
		<td width="50%" class="datos_tabla" align="left">
			<%=v.getValor() %>
		</td>
	</tr>
	<%}} %>
	<tr>
		<td width="40%" align="left" class="datos_tabla">
			<input type="button" id="atras" name="atras" value=" Atrás " onclick="javascript:redirigir()">
		</td>
</table>
</form>
</body>
</html>