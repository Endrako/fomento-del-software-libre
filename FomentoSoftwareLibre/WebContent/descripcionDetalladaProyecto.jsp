<%@page import="pos.domain.UsuarioStore"%>
<%@page import="java.util.LinkedList"%>
<%@page import="pos.domain.VotoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="pos.domain.Usuario"%>
<%@ page import="pos.domain.UsuarioStore"%>
<%@ page import="pos.domain.Proyecto"%>
<%@ page import="pos.domain.Aplicacion"%>
<%@page import="pos.domain.ProyectoStore"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Date"%>
<%@ page import="pos.utils.FuncionesImpl"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Descripción Proyecto</title>
<script language="JavaScript" src="js/funcionesComunes.js"
	type="text/javascript"></script>
<script language="JavaScript">
	var css = "css/estilos.css";
	document
			.write("<link href='" + css + "' rel='stylesheet' type='text/css'>");
<%Usuario usuario = (Usuario) session.getAttribute("usuario");%>
	function redirigir() {
		window.location = "proyectosExistentes.jsp";
	}
	function unirsealproyecto(idProyecto) {
		alert("¡Bien hecho! al unirte a colaborar en un proyecto aparte de aprender recibirás 20 puntos de karma");
		document.formulario.action = "FrontController?accion=unirseAlProyecto&idProyecto="
				+ idProyecto;
		document.formulario.submit();
	}
	function borraproyecto(idProyecto) {
		alert("Al desvincularte de un proyecto se te penalizará con -40 de karma");
		document.formulario.action ="FrontController?accion=borrarmeDeUnProyecto&idProyecto="+ idProyecto;
	
		document.formulario.submit();
	}
</script>

<%
	String idProyecto = request.getParameter("idProyecto");
	ProyectoStore pstore = ProyectoStore.getInstance();
	Proyecto p = pstore.obtenerProyectoPorID(idProyecto);
	Usuario userProyecto = new UsuarioStore()
			.recuperarUsuarioByIdUsuario(p.getUsuarioCreador()
					.getIdUser());
	Aplicacion a = pstore.obtenerAplicacionDeProyecto(p);
%>


</head>



<body background="Imagenes/fondo.jpg">
	<!--  INICIO TABLA CONTENEDORA DE TODAS LAS JSP / HTML -->
	<table align="center">
		<tr>
			<td width="15%" align="left"><img src="Imagenes/tux.jpg">
			</td>
			<td class="titular" align="center" width="70%"><strong>Web
					De Fomento Del Sofware Libre</strong></td>
			<td width="15%" align="right"><img src="Imagenes/tux.jpg">
			</td>
		</tr>
	</table>
	<!--  FIN TABLA CONTENEDORA DE TODAS LAS JSP / HTML -->
	<!--  INICIO TABLA CONTENEDORA DE TODAS LAS JSP / HTML -->
	<table border="0">
		<tr>
			<td width="30%" class="datos_tabla" align="left">Bienvenido <a
				href="ActualizarPerfil.jsp"><%=usuario.getNombreUsuario()%></a>, Hoy
				es <%=FuncionesImpl.formateoFecha(new Date())%></td>
			<td width="30%" class="datos_tabla" align="left">Karma
				acumulado, <%=usuario.getKarma()%></td>
			<td width="40%" class="datos_tabla" align="right"><a
				href="FrontController?accion=logout">Salir</a></td>
		</tr>
	</table>
	<!--  FIN TABLA CONTENEDORA DE TODAS LAS JSP / HTML -->
	<form id="formulario" name="formulario" action="" method="POST">
		<table align="center" class="borde">
			<tr>
				<td width="100%" class="tabla_principal" align="center" colspan="2">
					<strong>Proyecto</strong>
				</td>
			</tr>
			<tr>
				<td width="50%" class="datos_tabla" align="left">Nombre:</td>
				<td width="50%" class="datos_tabla" align="left"><%=p.getNombreProyecto()%>
				</td>
			</tr>
			<tr>
				<td width="50%" class="datos_tabla" align="left">Descripción:</td>
				<td width="50%" class="datos_tabla" align="left"><%=p.getDescripcionProyecto()%>
				</td>
			</tr>
			<tr>
				<td width="50%" class="datos_tabla" align="left">Fecha de
					Inicio:</td>
				<td width="50%" class="datos_tabla" align="left"><%=p.getFechaInicio()%>
				</td>
			</tr>
			<tr>
				<td width="50%" class="datos_tabla" align="left">Fecha de Fin:</td>
				<td width="50%" class="datos_tabla" align="left"><%=p.getFechaFin()%>
				</td>
			</tr>
			<tr>
				<td width=50% class="datos_tabla" align="left">Proyecto
					abierto:</td>

				<%
					// para convertir la disponibilidad en cadena
					String disp = "";

					if (p.getDisponibilidad() == 0) {
				%>
				<td width=50% class="datos_tabla" align="left">No</td>
				<%
					} else {
				%>
				<td width=50% class="datos_tabla" align="left">Sí</td>
				<%
					}
				%>

			</tr>
			<tr>
				<td width=50% class="datos_tabla" align="left">Desarrolladores
					actuales:</td>
				<%%>
				<td width=50% class="datos_tabla" align="left"><%=pstore.obtenerUsuariosDeProyecto(p)%></td>

			</tr>
			<tr>
				<td width=50% class="datos_tabla" align="left">Nivel Karma
					necesario:</td>
				<td width=50% class="datos_tabla" align="left"><%=p.getNivelKarma()%></td>
			</tr>
			<tr>
				<td width=50% class="datos_tabla" align="left">Usuario Creador</td>
				<td width=50% class="datos_tabla" align="left"><%=userProyecto.getNombreUsuario()%></td>
			</tr>

			<tr>
				<td width="50%" class="datos_tabla" align="left">Aplicación
					asociada:</td>
				<td width="50%" class="datos_tabla" align="left"><%=a.getNombre()%>
					<%
						/*
						 * muestro el botón de mostar App si hay aplicación vinculada.
						 */
						Aplicacion aux = pstore.obtenerAplicacionDeProyecto(p);
						if (aux.getNombre() != null) {
					%> <input type="button"
					id="<%=p.getAplicacion().getIDAplicacion()%>"
					name="<%=a.getNombre()%>"
					onClick="javascript:recuperarAplicacion(this.id)"
					;
					value="Ver App"></td>
				<%
					}
				%>
			</tr>



			<tr>

				<%
					/*
						Condiciones para ofrecer la opción de unirse al proyecto: 
									- Compruebo que el proyecto está disponible
									- Compruebo que el usuario no está ya unido al proyecto
									- Compruebo que el usuario tiene el mínimo de karma requerido
									- Compruebo que el proyecto no está obsoleto, ha superado fechaFin
					 */
					// System.out.println(usuario.getIdUser() + p.getIDProyecto());
					boolean existe = pstore.existeUsuarioEnProyecto(p, usuario);
					java.util.Date today = new java.util.Date();
					java.sql.Date fecha = new java.sql.Date(today.getTime());
					Date hoy = fecha;
					if (!existe) {
						if (p.getDisponibilidad() == 1) {
							if (usuario.getKarma() >= p.getNivelKarma()) {
								if (hoy.before(p.getFechaFin())) {
				%>
				<td width="50%" align="center" class="datos_tabla"><input
					type="button" id="<%=p.getIDProyecto()%>" name="unirseAlProyecto"
					onClick="javascript:unirsealproyecto(this.id);"
					value=" Unirse al proyecto"></td>

				<%
					} else {
								}// TODO investigar para enviar un mensaje a pantalla aquí en medio.
							}
						}
					}
				%>

				<%
					/*
					 * Si soy el usuario creador, entonces muestro el botón para borrar el proyecto.
					 */
					if (pstore.existeUsuarioEnProyecto(p, usuario)) {

				%>
				<td width="50%"></td>
				<td width="50%" align="center" class="datos_tabla"><input
					type="button" id="<%=p.getIDProyecto()%>"
					name="borrameproyecto" onClick="javascript:borraproyecto(this.id);" value="Borrarme del proyecto"></td>
				<%			
					}else {
						
					}
				%>
			</tr>
			<tr>
				<td width="100%" align="center" class="datos_tabla" colspan="2">
					<input type="button" id="atras" name="atras" value=" Atrás "
					onclick="javascript:redirigir()">
				</td>
			</tr>
		</table>
	</form>

</body>
</html>