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

<script type="text/javascript">
var css="css/estilos.css";
document.write("<link href='" + css + "' rel='stylesheet' type='text/css'>"); 

	function validar(nombre, maximoCheckbox){
		var res = true;
		var num_chequeados=0;
	    for (var i=0; i<nombre.length; i++){	        
	        for (var i=0; i<nombre.length; i++){
	            num_chequeados+=(nombre[i].checked)? 1 : 0	            
	        }	        
	    }
	    if (num_chequeados>maximoCheckbox){
            alert("El numero maximo de tags que puedes seleccionar es "+maximoCheckbox+"");
            res = false;
        } else if (num_chequeados<1){
        	alert("Debes seleccionar al menos 1 tag");
        	res = false;            	
        }
	    return res;
	}
	function redirigir(){
		window.location="indexEnfrentamiento.jsp";
	}
</script>
<!--  SCRIPT PARA LIMITAR EL NUMERO DE CHECKBOXES -->
<!-- SOLO TOCAR EL MENSAJE DEL alert  -->

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
<form id="formularioTags" name="formularioTags" action="FrontController?accion=TagsEnfrentamiento" method="post" onsubmit="return validar(this,1)">

<table align="center" class="borde">
<tr>
	<td width="100%" class="tabla_principal" align="center" colspan="2">
		<strong> 1º Seleccione un tag </strong>
	</td>
</tr>
<%TagStore tagSt = TagStore.getInstance();
List<Tag> listTags = tagSt.getTags();

for (int i=0;i<listTags.size();i++ ) { 
	Tag t = listTags.get(i);%>
	
<tr>
	<td width="50%" class="datos_tabla" align="left">
		<input type="checkbox" id="<%=t.getIdTag()%>" name="<%=t.getIdTag()%>" value="<%=t.getIdTag() %>"><%=t.getNombre()%>
	</td>
	<td width="50%" class="datos_tabla" align="left">
		&nbsp;
	</td>
</tr>
<% } %>
<tr>
	<td width="50%" align="left">
		<input type="button" id="atras" name="atras" value=" Atrás " onclick="javascript:redirigir()">
	</td>
	<td class="titular "width="50%" align="center">
		<input type="submit" value="Enviar" id="submit" />
	</td>
</tr>
</table>
</form>
</body>
</html>