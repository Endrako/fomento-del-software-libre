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
		<td width="40%" align="left">
			<strong><h3 style="color: blue;">&nbsp;&nbsp;&nbsp;&nbsp;1º Selecciona un tag</h3></strong>
		</td>
		<td class="titular" align="center" width="30%">
			
		</td>
		<td width="15%" align="right">
		</td>
	</tr>
</table>

<form id="formularioTags" name="formularioTags" action="FrontController?accion=TagsEnfrentamiento" method="post" onsubmit="return validar(this,1)">

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
			&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" id=<%=t.getIdTag()%> name =<%=t.getIdTag()%> value=<%=t.getNombre()%>>
		</td>
		
	</tr>
	<% } %>
	</table>
	<br>
	<br>
	
	
	<table>
		<tr>
			<td width="60%" aling="left">
				<input type="button" id="atras" name="atras" value=" Atrás " onclick="javascript:redirigir()">
			</td>
			<td class="titular "width="15%" aling="center">
				<input type="submit" value="Enviar" id="submit" />
				<input type="reset" value="Limpiar" />
				
			</td>
			<td width="15%" aling="right">
			</td>
		</tr>
	
	</table>

</form>

</body>
</html>