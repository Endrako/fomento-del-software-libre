<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import     = "java.util.ArrayList" %>
<%@ page import     = "java.util.List" %>
<%@ page import     = "java.util.Date" %>
<%@ page import     = "pos.utils.FuncionesImpl" %>
<%@ page import     = "pos.domain.Enfrentamiento" %>
<%@ page import     = "pos.domain.EnfrentamientoImpl" %>
<%@ page import     = "pos.domain.EnfrentamientoStore" %>
<%@ page import     = "pos.domain.Aplicacion" %>
<%@ page import     = "pos.domain.AplicacionImpl" %>
<%@ page import     = "pos.domain.Usuario" %>
<%@ page import     = "pos.domain.UsuarioStore" %>
<html>
<head>
<script language="JavaScript" src="js/funcionesComunes.js" type="text/javascript"></script>
<script language="JavaScript" >
			var css="css/estilos.css";
		document.write("<link href='" + css + "' rel='stylesheet' type='text/css'>"); 
	
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bienvenido a la página de enfrentamientos</title>
</head>
<body>
<%Usuario usuario = (Usuario)session.getAttribute("usuario"); %>
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
<div id="pestanas">
   <ul>
      <li><a href="todosEnfrentamientos.jsp">Todos los enfrentamientos</a></li>
      <li><a href="crearEnfrentamientoSelectTag.jsp">Crear enfrentamiento</a></li>
      <li class="activa"><a href="index2.jsp">Página principal</a></li>
      <li><a href="enfrentamientosUsuario">Tus enfrentamientos</a></li>
   </ul>
</div>
<div id="#arribaDcha">
<table align="center" class="borde">
<% EnfrentamientoStore enfStore = EnfrentamientoStore.getInstance();
List<Enfrentamiento> enfrentamientos = enfStore.obtenerEnfrentamientosVigentes();
if(enfrentamientos.size()<1){%>
<tr>
	<td width="100%" class="tabla_principal" align="center" colspan="3">
		<strong> No hay enfrentamientos vigentes </strong>
	</td>
</tr>
<%}else{%> 
<tr>
	<td width="100%" class="tabla_principal" align="center" colspan="3">
		<strong> Enfrentamientos vigentes </strong>
	</td>
</tr>
<%for(Enfrentamiento enfrentamiento:enfrentamientos){%>
<tr>
	<td width="35%" class="datos_tabla" align="right">
	<a href
	<%=enfrentamiento.getAplicacion1().getNombre()%>
	</td>
	<td width="30%" class="datos_tabla" align="center">
		<img src="Imagenes/versus.png">
	</td>
	<td width="35%" class="datos_tabla" align="left">
	<%=enfrentamiento.getAplicacion2().getNombre()%>
	</td>
</tr>
<tr>
	<td width="35%" class="datos_tabla" align="right">
	<%=enfrentamiento.getVotosAplicacion1()%>
	</td>
	<td width="30%" class="datos_tabla" align="center">
		Fecha finalizacion:<br>
		<%=FuncionesImpl.formateoFecha(enfrentamiento.getFechaFin())%>
	</td>
	<td width="35%" class="datos_tabla" align="left">
	<%=enfrentamiento.getVotosAplicacion2()%>
	</td>
</tr>
<tr>
	<td width="35%" class="datos_tabla" align="right">
	<%=enfrentamiento.getVotosAplicacion1()%>
	</td>
	<td width="30%" class="datos_tabla" align="center">
		Descripcion:<br>
		<%=enfrentamiento.getDescripcion()%>
	</td>
	<td width="35%" class="datos_tabla" align="left">
	<%=enfrentamiento.getVotosAplicacion2()%>
	</td>
</tr>


<%}%>

<%} %>
</table>


</div>

</body>
</html>