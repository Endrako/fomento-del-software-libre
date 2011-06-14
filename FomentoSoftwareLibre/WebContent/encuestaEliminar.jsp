<%@page import="pos.domain.EncuestaStore"%>
<%@page import="pos.data.IEncuestaDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/encuesta.css">
<script language="JavaScript" >
function redirigir(){
	window.location="encuestaindex.jsp";
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Fomento del SoftWare Libre - Eliminar encuesta</title>
</head>
<body>
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

<%
EncuestaStore eStore = new EncuestaStore();
eStore.borrarEncuesta(request.getParameter("idEncuesta"));
%>
<table>
	<tr>
		<td colspan="2" class="datos_tabla">
			<h1>Su encuesta ha sido Eliminada satisfactoriamente</h1> <br>
		</td>
	</tr>
</table>
<input type="button" onClick="javascript:redirigir()"
						value="Volver a la seccion de encuestas" />
</body>
</html>