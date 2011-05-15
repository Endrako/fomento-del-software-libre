<%@page import="pos.data.JDBCRespuestaDAO"%>
<%@page import="pos.data.IRespuestaDAO"%>
<%@page import="pos.data.JDBCEncuestaDAO"%>
<%@page import="pos.data.IEncuestaDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="pos.domain.*"%>
<%@page import="java.util.*"%>
<%@page import="pos.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="JavaScript" src="js/jsencuesta.js"type="text/javascript"></script>
<title>Panel de control de Encuestas</title>
</head>
<body>
	<table align="center">
		<tr>
			<td width="15%" align="left"><img src="Imagenes/tux.jpg">
			</td>
			<td class="titular" align="center" width="70%"><strong>Web
					Del Fomento Del Sofware Libre</strong>
			</td>
			<td width="15%" align="right"><img src="Imagenes/tux.jpg">
			</td>
		</tr>
	</table>
	<div id="capa">
		<form>
			<label for=texto">Texto:</label><input id="texto" type="text" size=40 />
			<input type="button"
				onClick="addElement(getElementById('texto').value);"
				value="Añadir Elemento" />
		</form>
	</div>
</body>
</html>