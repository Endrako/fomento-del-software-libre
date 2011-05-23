<%@page import="com.sun.xml.internal.stream.writers.WriterUtility"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import     = "pos.domain.AplicacionStore" %>
<%@ page import     = "pos.domain.Tag" %>
<%@ page import     = "pos.domain.Aplicacion" %>
<%@ page import     = "java.util.*" %>
<%@ page import		= "java.sql.Date"%>
<%@ page import 	= "java.util.Calendar" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Crea un enfrentamiento</title>
<script type="text/javascript">
var css="css/estilos.css";
document.write("<link href='" + css + "' rel='stylesheet' type='text/css'>"); 

</script>

</head>
<body background="Imagenes/fondo.jpg" onload="javascript:ini();">
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

<table align="center">
	<tr>
		<td class="titularEnfrentamiento" align="center" width="100%">
			Creación de enfrentamiento
		</td>
	</tr>
</table>
<table align="center">
	<tr>
		<td align="center" width="100%">
			<img src="Imagenes/Vs.png" border="0" height="40" width="40"/>
		</td>
	</tr>
</table>

<form id="formularioTags" name="formularioAplicaciones" action="FrontController?accion=AplicacionesEnfrentamiento" method="post" onsubmit="return validar(this,2)">
<% List<Aplicacion> aplicaciones = (List<Aplicacion>)request.getSession().getAttribute("aplicaciones");
Aplicacion aplicacion1 = aplicaciones.get(0);
Aplicacion aplicacion2 = aplicaciones.get(1);%>

<table align="center" class="borde">
<tr>
	<td width="100%" class="tabla_principal" align="center" colspan="3">
		<strong> Se ha creado el siguiente enfrentamiento </strong>
	</td>
</tr>
<tr>
	<td width="35%" class="datos_tabla" align="right">
	<%=aplicacion1.getNombre()%>
	</td>
	<td width="30%" class="datos_tabla" align="center">
		<img src="Imagenes/versus.png">
	</td>
	<td width="35%" class="datos_tabla" align="left">
	<%=aplicacion2.getNombre()%>
	</td>
</tr>
<tr>
	<td width="35%" class="datos_tabla" align="left">
	
	</td>
	<td width="30%" class="datos_tabla" align="center">
		¡Enhorabuena! Has ganado:
		<br> 100 puntos de karma
	</td>
	<td width="35%" class="datos_tabla" align="right">
	
	</td>
</tr>
<tr>
	<td width="35%" align="left">
	</td>
	<td class="titular "width="30%" align="center">
	<a href="indexEnfrentamiento.jsp">Volver a la página de enfrentamientos</a>
	</td>
	<td width="35%" align="right">
	</td>
</tr>
</table>
</body>
</html>