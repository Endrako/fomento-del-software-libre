<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import     = "pos.domain.AplicacionStore" %>
<%@ page import     = "pos.domain.Aplicacion" %>
<%@ page import     = "java.util.ArrayList" %>
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

Crea un enfrentamiento entre dos aplicaciones

2º Selecciona 2 aplicaciones

Aplicaciones:
<%
	AplicacionStore aplisSt = AplicacionStore.getInstance();
	List<Aplicacion> listaAplis = aplisSt.getAplicationByTag(/*El tag de la pantalla anterior*/);
	for(Aplicacion apli:listaAplis){
		//RECORRER LA PUTA LISTA Y METERLO EN UNA DE HTML CON CHECKS
	}
%>
<ul>
<li>Artículo 1</li>
<li>Artículo 2</li>
<li>Artículo 3</li>
<li>Artículo 4</li>
</ul> 

</body>
</html>