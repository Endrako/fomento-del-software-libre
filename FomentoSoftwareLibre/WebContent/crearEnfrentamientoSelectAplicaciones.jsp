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

<script>



	function maximoChecked(nombre, max) {
		checkboxes = document.getElementsByName(nombre);
		for (a = 0; a < checkboxes.length; a++) { //les aplicamos el evento onclick
			checkboxes[a].onclick = function() {
				if (this.checked == true) { //iba a ponerle el check
					grupo = document.getElementsByName(this.name);
					cuantosChecked = 0;
					for (b = 0; b < grupo.length; b++)
						if (grupo[b].checked)
							cuantosChecked++;
					if (cuantosChecked > max) {
						alert("Lo siento, el maximo de checkados solo puede ser "
								+ max);
						this.checked = false;
					}
				}
			}
		}
	}

	//maximoChecked("entrante",3);
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
			<%=nombreTags %>
		</td>
		<td width="15%" align="right">
		</td>
	</tr>
</table>

<table align="center">
	<tr>
		<td width="30%" align="left">
			<strong><h3 style="color: blue;">&nbsp;&nbsp;&nbsp;&nbsp;2º Selecciona las aplicaciones</h3></strong>
		</td>
		<td class="titular" align="center" width="70%">
			
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
	
	for (int i=0;i<listAplis.size();i++ ) { 
		Aplicacion ap = listAplis.get(i);%>
		
	
	<tr>
		<td class="titular" width="50%" align="center">
			&nbsp;&nbsp;&nbsp;&nbsp;<%=ap.getNombre()%>
		</td>
		<td align="right" width="15%">
			&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" id=<%=ap.getIDAplicacion()%> name = <%=ap.getIDAplicacion()%> value=<%=ap.getNombre()%> onClick="maximoChecked('entrante',2)">
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