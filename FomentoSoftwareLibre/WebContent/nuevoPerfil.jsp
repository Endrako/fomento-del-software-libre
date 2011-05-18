<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import     = "java.util.ArrayList" %>
<%@ page import     = "java.util.List" %>
<%@ page import     = "pos.utils.FuncionesImpl" %>
<%@ page import     = "java.util.Date" %>
<%@ page import     = "pos.domain.PaisStore" %>
<%@ page import     = "pos.domain.Pais" %>
<%@ page import     = "pos.domain.ProvinciaStore" %>
<%@ page import     = "pos.domain.Provincia" %>
<%@ page import     = "pos.domain.Usuario" %>
<%@ page import     = "pos.domain.SoStore" %>
<%@ page import     = "pos.domain.SO" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Configura tu Perfil</title>
 <script language="JavaScript" src="js/funcionesComunes.js" type="text/javascript"></script>
<%
			Boolean recomendado = (Boolean) session.getAttribute("haSidoRecomendado");
			Boolean  existeRecomendado = (Boolean)session.getAttribute("existeRecomendador");
			Usuario usuario = (Usuario)session.getAttribute("usuario");
			String nombre = "";
			String apellidos = "";
			String pais = "";
			String provincia = "";
			String soPC = "";
			String soMvl = "";
			Integer edad = 0;
			String idPerfil = "";
%>
<script language="JavaScript" >
			var css="css/estilos.css";
		document.write("<link href='" + css + "' rel='stylesheet' type='text/css'>"); 
		
		function ini(){
			if ( <%=existeRecomendado%> ){
			 	if ( <%= recomendado %> ){
					alert("Bien!! el registro se ha completado y ambos teneis 10 puntos Extras!!");
				}else{
					alert("OOHHHH el registro se ha completado pero tu amigo ya recomendo a más de 5 amigos :(");
				}
			}else{
				alert("El registro se ha completado pero el usuario que te ha recomendado no existe en nuestra Base de Datos");
			}
		}
		
		function limpiarForm(){
			document.getElementById("nombre").value = "";
			document.getElementById("apellidos").value = "";
			document.getElementById("edad").value = "";
		}
		
		function guardar(){
			document.formulario.action = "FrontController?accion=nuevoPerfil";
			document.formulario.submit();
		}
</script>
</head>
<body background="Imagenes/fondo.jpg" onload="javascript:ini();">
<!--  INICIO TABLA CONTENEDORA DE TODAS LAS JSP / HTML -->
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
<table border="0">
	<tr>
		<td width="50%" class="datos_tabla" align="left">
			Bienvenido <a href="ActualizarPerfil.jsp"><%=usuario.getNombreUsuario()%></a>, Hoy es <%=FuncionesImpl.formateoFecha(new Date())%>
		</td>
		<td width="50%" class="datos_tabla" align="left">
			<a href="FrontController?accion=logout">Salir</a>
		</td>
	</tr>
</table>
<form id="formulario" name="formulario" action="" method="post">
	<input type="hidden" id="idPerfil" name="idPerfil" value="<%=idPerfil%>">
	<table align="center" class="borde">
		<tr>
			<td width="100%" class="tabla_principal" align="center" colspan="2">
				<strong> Configura tu Perfil </strong>
			</td>
		</tr>
		<tr>
			<td width="50%" class="datos_tabla" align="left">
				<strong>Nombre: </strong>
			</td>
			<td width="50%" class="datos_tabla" align="left">
				<input type="text" id="nombre" name ="nombre" value="<%=nombre%>">
			</td>
		</tr>
		<tr>
			<td width="50%" class="datos_tabla" align="left">
				<strong>Apellidos: </strong>
			</td>
			<td width="50%" class="datos_tabla" align="left">
				<input type="text" id="apellidos" name ="apellidos" value="<%=apellidos%>">
			</td>
		</tr>
		<tr>
			<td width="50%" class="datos_tabla" align="left">
				<strong>Edad: </strong>
			</td>
			<td width="50%" class="datos_tabla" align="left">
				<input type="text" id="edad" name ="edad" onKeyPress="javascript:soloNumeros(event)" value="<%=edad%>">
			</td>
		</tr>
		<tr>
			<td width="50%" class="datos_tabla" align="left">
				<strong>Pais de Nacimiento: </strong>
			</td>
			<td width="50%" class="datos_tabla" align="left">
				<%
					PaisStore paisStore = new PaisStore();
					List<Pais> paises = paisStore.recuperarTodosLosPaises();
				%>
				<select id="paises" name="paises">
					<% for ( Pais p : paises ){ %>
					<option value="<%=p.getId() %>" <% if (pais.equals(p.getId()) ){%> selected<%}%>><%=p.getDescripcion()%></option>
					<%} %>
				</select>
			</td>
		</tr>
		<tr>
			<td width="50%" class="datos_tabla" align="left">
				<strong>Ciudad de Residencia: </strong>
			</td>
			<td width="50%" class="datos_tabla" align="left">
				<%
					ProvinciaStore pr = new ProvinciaStore();
					List<Provincia> provincias = pr.recuperarTodasLasProvincias();
				%>
				<select id="provincias" name="provincias">
					<% for ( Provincia pro : provincias ){ %>
					<option value="<%=pro.getId()%>" <% if (provincia.equals(pro.getId()) ){%> selected<%} %>><%=pro.getDescripcion()%></option>
					<%} %>
				</select>
			</td>
		</tr>
		<tr>
			<td width="50%" class="datos_tabla" align="left">
				<strong>Sistema Operativo de Sobremesa: </strong>
			</td>
			<td width="50%" class="datos_tabla" align="left">
				<%
					SoStore soStore = new SoStore();
					List<SO> ssoo = soStore.recuperarTodosLosSo();
				%>
				<select id="ssooPC" name="ssooPC">
					<% for ( SO s : ssoo ){
							if ( s.getEsOSmovil() == 0 ){	
					%>
								<option value="<%=s.getIdSO()%>" <% if (soPC.equals(s.getIdSO()) ){%> selected<%} %>><%=s.getDescripcion()%></option>
					<%		}
						}%>
				</select>
			</td>
		</tr>
		<tr>
			<td width="50%" class="datos_tabla" align="left">
				<strong>Sistema Operativo de Móvil: </strong>
			</td>
			<td width="50%" class="datos_tabla" align="left">
				<select id="ssooMv" name="ssooMv">
					<% for ( SO sm : ssoo ){
							if ( sm.getEsOSmovil() == 1 ){	
					%>
								<option value="<%=sm.getIdSO() %>" <% if (soMvl.equals(sm.getIdSO()) ){%> selected<%} %>><%=sm.getDescripcion()%></option>
					<%		}
						}%>
				</select>
			</td>
		</tr>
		<tr>
		<td width="50%" align="left">
			&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" id="registrarse" name="registrarse" value=" Actualizar" onclick="javascript:guardar();">
		</td>
		<td width="50%" align="left">
			&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" id="limpiar" name="limpiar" value=" Limpiar Formulario" onclick="javascript:limpiarForm();">
		</td>
	</tr>
	</table>
</form>
</body>
</html>