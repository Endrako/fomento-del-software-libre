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
		<td width="15%" align="left">		
		</td>
		<td class="titular" align="center" width="70%">
			<strong><h3 style="color: red;">Creación de enfrentamiento</h3></strong>
		</td>
		<td width="15%" align="right">		
		</td>
	</tr>
</table>

<table align="center">
	<tr>
		<td width="15%" align="left">
		<%List<Aplicacion> aplis = new ArrayList<Aplicacion>();
		aplis = (List<Aplicacion>)request.getSession().getAttribute("aplicaciones");%>
		<%= aplis.get(0).getNombre() %>
		</td>
		<td class="titular" align="center" width="70%">
			<img src="Imagenes/Vs.png">
		</td>
		<td width="15%" align="right">
		<%= aplis.get(1).getNombre() %>
		</td>
	</tr>
	<tr>
		<td width="15%" align="left">
		</td>
		<td class="titular" align="center" width="70%">
			<% Tag tag = (Tag)request.getSession().getAttribute("tags");%>
			<strong><%=tag.getNombre() %></strong>
			
		</td>
		<td width="15%" align="right">
		</td>
	</tr>
	
</table>

<table align="center">
	<tr>
		<td width="40%" align="left">
			<strong><h3 style="color: purple;">&nbsp;&nbsp;&nbsp;&nbsp;Este enfrentamiento ya existe</h3></strong>
		</td>
		<td class="titular" align="center" width="30%">
			
		</td>
		<td width="15%" align="right">
		</td>
	</tr>
</table>



</body>
</html>