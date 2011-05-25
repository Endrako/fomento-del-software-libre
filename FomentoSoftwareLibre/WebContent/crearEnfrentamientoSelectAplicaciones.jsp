<%@page import="com.sun.xml.internal.stream.writers.WriterUtility"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import     = "pos.domain.AplicacionStore" %>
<%@ page import     = "pos.domain.Tag" %>
<%@ page import     = "pos.domain.Aplicacion" %>
<%@ page import     = "java.util.*" %>
<%@ page import		= "java.sql.Date"%>
<%@ page import 	= "java.util.Calendar" %>
<%@ page import     = "pos.utils.FuncionesImpl" %>
<%@ page import     = "pos.domain.Usuario" %>
<%@ page import     = "pos.domain.UsuarioStore" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Crea un enfrentamiento</title>
<script language="JavaScript" src="js/funcionesComunes.js" type="text/javascript"></script>
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
        alert("El numero maximo de aplicaciones que puedes seleccionar es "+maximoCheckbox+"");
        res = false;
    } else if (num_chequeados<2){
    	alert("Debes seleccionar 2 aplicaciones");
    	res = false;            	
    }
    return res;
}

function redirigir(){
	window.location="crearEnfrentamientoSelectTag.jsp";
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
<%Usuario usuario = (Usuario)session.getAttribute("usuario");%>
<table border="0">
	<tr>
		<td width="30%" class="datos_tabla" align="left">
			Bienvenido <a href="ActualizarPerfil.jsp"><%=usuario.getNombreUsuario()%></a>, Hoy es <%=FuncionesImpl.formateoFecha(new java.util.Date())%>
		</td>
		<td width="30%" class="datos_tabla" align="left">
			Karma acumulado, <%=usuario.getKarma() %>
		</td>
		<td width="40%" class="datos_tabla" align="right">
			<a href="FrontController?accion=logout">Salir</a>
		</td>
	</tr>
</table>
<div id="pestanas">
   <ul>
      <li><a href="indexEnfrentamiento.jsp">Volver a página de enfrentamientos</a></li> 
      <li><a href="crearEnfrentamientoSelectTag.jsp">Volver a página de selección de tag</a></li>     
   </ul>	
</div>
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
<table align="center">
	<tr>
		<td align="center" width="100%">
			<% Tag tag = (Tag)request.getSession().getAttribute("tags");%>
			<strong><%=tag.getNombre() %></strong>			
		</td>
	</tr>
</table>
<form id="formularioTags" name="formularioAplicaciones" action="FrontController?accion=AplicacionesEnfrentamiento" method="post" onsubmit="return validar(this,2)">
<% AplicacionStore aplSt = AplicacionStore.getInstance();
	List<Aplicacion> listAplis = aplSt.getAplicationByTag((Tag)request.getSession().getAttribute("tags"));%>
	
<table align="center" class="borde">
<%if(listAplis.size()<2){%>
<tr>
	<td width="100%" class="tabla_principal" align="center" colspan="2">
		<strong> No hay aplicaciones con los tags seleccionados para hacer un enfrentamiento </strong>
	</td>
</tr>
<tr>
	<td width="50%" align="left">
	</td>
	<td class="titular "width="50%" align="center">
		<input type="button" id="atras" name="atras" value=" Atrás " onclick="javascript:redirigir()">
	</td>
</tr>
<%}else{%>
<tr>
	<td width="100%" class="tabla_principal" align="center" colspan="2">
		<strong> 2º Seleccione dos aplicaciones </strong>
	</td>
</tr>
	<%for (int i=0;i<listAplis.size();i++ ) { 
		Aplicacion ap = listAplis.get(i);%>
<tr>
	<td width="50%" class="datos_tabla" align="left">
		<input type="checkbox" id="<%=ap.getIDAplicacion()%>" name="<%=ap.getIDAplicacion()%>" value="<%=ap.getNombre() %>"><%=ap.getNombre()%>
	</td>
	<td width="50%" class="datos_tabla" align="left">
		&nbsp;
	</td>
</tr>
	<%}%>
<tr>
	<td width="50%" class="datos_tabla" align="left">
		Descripción del enfrentamiento:
	</td>
	<td width="50%" class="datos_tabla" align="left">
		<textarea id="descripcion" value="descripcion" name="descripcionEnfrentamiento" rows="3" cols="30">..pon una descripcion..</textarea>
	</td>
</tr>	
<tr>
	<td width="50%" align="left">
		<input type="button" id="atras" name="atras" value=" Atrás " onclick="javascript:redirigir()">
	</td>
	<td class="titular "width="50%" align="center">
		<input type="submit" value="Enviar" id="submit" />
	</td>
</tr>
</table>
	<%}%>
</form>


</body>
</html>