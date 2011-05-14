<%@page import="com.sun.xml.internal.stream.writers.WriterUtility"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import     = "pos.domain.TagStore" %>
<%@ page import     = "pos.domain.Tag" %>
<%@ page import     = "java.util.*" %>
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
		</td>
		<td class="titular" align="center" width="70%">
			<img src="Imagenes/Vs.png">
		</td>
		<td width="15%" align="right">
		</td>
	</tr>
</table>

<table align="center">
	<tr>
		<td width="30%" align="left">
			<strong><h3 style="color: blue;">1º Selecciona los tags</h3></strong>
		</td>
		<td class="titular" align="center" width="70%">
			
		</td>
		<td width="15%" align="right">
		</td>
	</tr>
</table>

<form id="formularioTags" name="formularioTags" action="FrontController?accion=TagsEnfrentamiento" method="post">

	<table align="center">
	<% 
	TagStore tagSt = TagStore.getInstance();
	List<Tag> listTags = tagSt.getTags();
	
	for (int i=0;i<listTags.size();i++ ) { 
		Tag t = listTags.get(i);%>
		
	
	<tr>
		<td class="titular" width="50%" align="center">
			&nbsp;&nbsp;&nbsp;&nbsp;<%=t.getNombre()%>
		</td>
		<td align="right" width="15%">
			&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" id=<%=t.getIdTag()%> name = <%=t.getIdTag()%> value=<%=t.getNombre()%>>
		</td>
		
	</tr>
	<% } %>
	</table>
	<br>
	<br>
	
	
	<table>
		<tr>
			<td width="50%" aling="left">
			</td>
			<td class="titular "width="15%" aling="center">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="Enviar" id="submit" />
			</td>
			<td width="15%" aling="right">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="Limpiar" />
			</td>
		</tr>
	
	</table>

</form>

</body>
</html>