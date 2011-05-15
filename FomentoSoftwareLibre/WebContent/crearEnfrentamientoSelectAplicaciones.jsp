<%@page import="com.sun.xml.internal.stream.writers.WriterUtility"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import     = "pos.domain.AplicacionStore" %>
<%@ page import     = "pos.domain.Tag" %>
<%@ page import     = "pos.domain.Aplicacion" %>
<%@ page import     = "java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Crea un enfrentamiento</title>

<script type="text/javascript">
	function maximoCheckboxarCheckbox(nombre, maximoCheckbox){
	    for (var i=0; i<nombre.length; i++){
	        nombre[i].onclick=function(){
	        var num_chequeados=0;
	        for (var i=0; i<nombre.length; i++)
	            num_chequeados+=(nombre[i].checked)? 1 : 0
	            if (num_chequeados>maximoCheckbox){
	                alert("El numero maximo de aplicaciones que puedes seleccionar son "+maximoCheckbox+"");
	                this.checked=false;
	            }
	        }
	    }
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
			<% List<Tag> tags =	(List<Tag>)request.getAttribute("tags");
			String nombreTags ="";
			for(int i=0;i<tags.size();i++){
				nombreTags+=tags.get(i).getNombre();
				if(i+1==tags.size()){
					nombreTags+="";
				}else{
					nombreTags+=", ";
				}
			}%>
			<strong><%=nombreTags %></strong>
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

<form id="formularioTags" name="formularioAplicaciones" action="FrontController?accion=AplicacionesEnfrentamiento" method="post">

	<table align="center">
	<% 
	AplicacionStore aplSt = AplicacionStore.getInstance();
	List<Aplicacion> listAplis = aplSt.getAplicacionByTagList((List<Tag>)request.getAttribute("tags"));
	
	if(listAplis.size()<2){%>
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
			&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" id=<%=ap.getIDAplicacion()%> name ="aplicaciones" value=<%=ap.getNombre()%>>
		</td>
		
	</tr>
		
	
	<%}
	} %>
	</table>
	<br>
	<br>
	
	
	<table>
		<tr>
			<td width="60%" aling="left">
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
<!-- INVOCACION DEL SCRIPT  -->
<script type="text/javascript">
	maximoCheckboxarCheckbox(document.formularioAplicaciones.aplicaciones, 2);
</script>

</body>
</html>