<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import     = "java.util.ArrayList" %>
<%@ page import     = "java.util.List" %>
<%@ page import     = "java.util.Date" %>
<%@ page import     = "pos.utils.FuncionesImpl" %>
<%@ page import     = "pos.domain.Enfrentamiento" %>
<%@ page import     = "pos.domain.EnfrentamientoImpl" %>
<%@ page import     = "pos.domain.EnfrentamientoStore" %>
<%@ page import     = "pos.domain.Aplicacion" %>
<%@ page import     = "pos.domain.AplicacionImpl" %>
<%@ page import     = "pos.domain.Usuario" %>
<%@ page import     = "pos.domain.UsuarioStore" %>
<%@ page import     = "pos.utils.UIDGenerator" %>
<html>
<head>
<script language="JavaScript" src="js/funcionesComunes.js" type="text/javascript"></script>
<script language="JavaScript" >
			var css="css/estilos.css";
		document.write("<link href='" + css + "' rel='stylesheet' type='text/css'>"); 
		
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bienvenido a la página de enfrentamientos</title>
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
<%Usuario usuario = (Usuario)session.getAttribute("usuario");%>
<table border="0">
	<tr>
		<td width="30%" class="datos_tabla" align="left">
			Bienvenido <a href="ActualizarPerfil.jsp"><%=usuario.getNombreUsuario()%></a>, Hoy es <%=FuncionesImpl.formateoFecha(new Date())%>
		</td>
		<td width="30%" class="datos_tabla" align="left">
			Karma acumulado,<%=usuario.getKarma() %>
			
		</td>
		<td width="40%" class="datos_tabla" align="right">
			<a href="FrontController?accion=logout">Salir</a>
		</td>
	</tr>
</table>

<div id="pestanas">
   <ul>
      <li><a href="indexEnfrentamiento.jsp">Página principal de enfrentamientos</a></li>      
      <li class="activa"><a href="index2.jsp">Página principal</a></li>
   </ul>	
</div>

<div align="center">
<h3 style="color:purple">¿Esto de qué va?</h3>
<p style="color:black">

Bienvenido a la sección de enfrentamientos de nuestra página web.
<br>
¿Qué es un enfrentamiento? Seguro que más de una vez te has preguntado:
 cuál de estas dos aplicaciones es mejor.
 <br>
 Esto vale para obtener una respuesta ayudándote
  de la opinión de la comunidad.
  <br>
Aquí se exponen los principios o reglas básicas para los enfrentamientos:
<br>
<br>
</p>
</div>

<div align="center">
<h3 style="color:purple">Votar</h3>
<p style="color:black">
Al votar recibirás 10 puntos de karma.
<br>
Solo se puede votar una vez por enfrentamiento.
<br>
Solo se puede votar a los enfrentamientos que no hayan finalizado.
<br> 
<br>
</p>
</div>

<div align="center">
<h3 style="color:purple">Crear enfrentamiento</h3>
<p style="color:black">
Al crear un enfrentamiento recibirás 100 puntos de karma.
<br>
Para crearlo deben de darse dos requisitos:
<br><br>
El primero es que no debes de haber creado un enfrentamiento en el mismo día, es decir, la
<br>
cantidad de enfrentamientos a crear está limitada a uno diario. Para saber 
<br>si no cumples este requisito, verás que al lado del enlace 
<br>
para crear enfrentamientos te saldrá 
algo como esto: <img src="Imagenes/prh2.png"> 
<br><br>
El segundo es que debes de tener 200 puntos de karma para poder crear un enfrentamiento.
<br> En la parte superior de la web tendrás tu karma a la vista. 
<br>De todas maneras, si no cumples este 
requisito, verás al lado del enlace otro simbolo como este: <img src="Imagenes/prh3.png">
</p>
</div>

</body>
</html>