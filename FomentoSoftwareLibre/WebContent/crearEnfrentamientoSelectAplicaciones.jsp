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
function validar(nombre, maximoCheckbox){
	var res = true;
	var num_chequeados=0;
    for (var i=0; i<nombre.length; i++){	        
        for (var i=0; i<nombre.length; i++){
            num_chequeados+=(nombre[i].checked)? 1 : 0	            
        }	        
    }
    if (num_chequeados>maximoCheckbox){
        alert("El numero maximo de aplicaciones que puedes seleccionar es "+maximoCheckbox+"");
        res = false;
    } else if (num_chequeados<2){
    	alert("Debes seleccionar 2 aplicaciones");
    	res = false;            	
    }
    return res;
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
			<strong><h3 style="color: blue;">&nbsp;&nbsp;&nbsp;&nbsp;2º Selecciona las aplicaciones</h3></strong>
		</td>
		<td class="titular" align="center" width="30%">
			
		</td>
		<td width="15%" align="right">
		</td>
	</tr>
</table>

<form id="formularioTags" name="formularioAplicaciones" action="FrontController?accion=AplicacionesEnfrentamiento" method="post" onsubmit="return validar(this,2)">
<% 
	AplicacionStore aplSt = AplicacionStore.getInstance();
	List<Aplicacion> listAplis = aplSt.getAplicationByTag((Tag)request.getSession().getAttribute("tags"));%>
	<table align="center">
	
	<%if(listAplis.size()<2){%>
		<tr>
		<td class="titular" width="50%" align="center">
			&nbsp;<h3 style="color: orange;">No hay aplicaciones con los tags seleccionados para hacer un enfrentamiento</h2>
		</td>
		<td align="right" width="5%">
		</td>
		
	</tr>
	<% }else{
	for (int i=0;i<listAplis.size();i++ ) { 
		Aplicacion ap = listAplis.get(i);%>	
	<tr>
		<td class="titular" width="50%" align="center">
			&nbsp;&nbsp;&nbsp;&nbsp;<%=ap.getNombre()%>
		</td>
		<td align="right" width="15%">
			&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" id=<%=ap.getIDAplicacion()%> name =<%=ap.getIDAplicacion()%> value=<%=ap.getNombre()%>>
		</td>		
	</tr>
	
	<%}
	} %>
	</table>
	<br>
	<br>	
	<%if(listAplis.size()>=2){ %>
	<table>
	<tr>
		<td width="60%" align="left">
		</td>
		<td class="titular" width="50%" align="center">
			Pon una descripcion para el enfrentamiento
		</td>
	</tr>
	<tr>
		<td width="50%" align="left">
		</td>
		<td class="titular" width="50%" align="center">
			<textarea id="descripcion" value="descripcion" name="descripcionEnfrentamiento" rows="7" cols="40">..pon una descripcion..</textarea>
			<br /><br />
		</td>		
	</tr>	
	<tr>
		<td width="50%" aling="left">
		</td>
		<td class="titular "width="50%" aling="center">				
			<input type="submit" value="Enviar" id="submit" />
			<input type="reset" value="Limpiar" />
		
		</td>
	</tr>
	
	</table>
	<%}%>
</form>


</body>
</html>