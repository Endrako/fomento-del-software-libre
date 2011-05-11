<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Nuevo Usuario</title>
<!--  necesario en todas las html jsp para usar los estilos -->
<script language="JavaScript" >
			var css="css/estilos.css";
		document.write("<link href='" + css + "' rel='stylesheet' type='text/css'>"); 
		
		var nickname = document.getElementById("nick").value ;
		var password = document.getElementById("password").value;
		var conf_password = document.getElementById("conf_password").value;
		var email = document.getElementById("email").value;
		
		function limpiarForm(){
			document.getElementById("nick").value = "";
			document.getElementById("password").value = "";
			document.getElementById("conf_password").value = "";
			document.getElementById("email").value = "";
		}
		
		function comprobarPassword(){
			var validar = true;
			var nickname = document.getElementById("nick").value;
			var password = document.getElementById("password").value;
			var conf_password = document.getElementById("conf_password").value;
			var email = document.getElementById("email").value;
			
			if ( nickname == "" || password == "" || email == "" ){
				alert("Debe introducir todos los datos");
				validar = false;
			}
			
			if ( password != conf_password  ){
				alert("Los password no coinciden");
				validar = false;
			}else{
				if ( validar ){
					if ( document.formulario.checkRecomendado.checked == true  ){
						alert("Al recomendarte un amigo ambos sumareis 10 puntos de Karma además de los 10 por registrarte :)")
					}
					document.formulario.action = "FrontController?accion=registroUsuario";
					document.formulario.submit();
				}
			}
	 	}

		function muestra_oculta(valor){
				if ( document.formulario.checkRecomendado.checked == true  ){
					document.getElementById("recomendado").className="expandido";
				}else{
					document.getElementById("recomendado").className="contraido";
				}
		}
		
		function ini(){
			document.getElementById("recomendado").className="contraido";
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
<form id="formulario" name="formulario" action="" method="post">
<table align="center" class="borde">
	<tr>
		<td width="100%" class="tabla_principal" align="center" colspan="2">
			<strong> Nuevo Usuario </strong>
		</td>
	</tr>
	<tr>
		<td width="50%" class="datos_tabla" align="left">
			<strong>Nick: </strong>
		</td>
		<td width="50%" class="datos_tabla" align="left">
			<input type="text" id="nick" name ="nick" value="">
		</td>
	</tr>
	<tr>
		<td width="50%" class="datos_tabla" align="left">
			<strong>Password: </strong>
		</td>
		<td width="50%" class="datos_tabla" align="left">
			<input type="password" id="password" name="password" value="">
		</td>
	</tr>
	<tr>
		<td width="50%" class="datos_tabla" align="left">
			<strong>Confirmar Password: </strong>
		</td>
		<td width="50%" class="datos_tabla" align="left">
			<input type="password" id="conf_password" name ="conf_password" value="">
		</td>
	</tr>
	<tr>
		<td width="50%" class="datos_tabla" align="left">
			<strong>Email: </strong>
		</td>
		<td width="50%" class="datos_tabla" align="left">
			<input type="text" id="email" name ='email' value="">
		</td>
	</tr>
	<tr>
		<td colspan="2" class="datos_tabla" align="left">
			<input type="checkbox" id="checkRecomendado" name ='checkRecomendado' value="" onclick="javascript:muestra_oculta(this.value);"><font size="3pxl">¿ Vienes Recomendado ?</font>
		</td>
	</tr>
	<tr>
		<td colspan="2" class="datos_tabla" align="left">
			<div id="recomendado">
				Usuario recomendador: <input type="text" id="usuarioRecomendador" name="usuarioRecomendador" size="15">
			</div>
		</td>
	</tr>
	<tr>
		<td width="50%" align="left">
			&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" id="registrarse" name="registrarse" value=" Registrarse" onclick="javascript:comprobarPassword();">
		</td>
		<td width="50%" align="left">
			&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" id="limpiar" name="limpiar" value=" Limpiar Formulario" onclick="javascript:limpiarForm();">
		</td>
	</tr>
</table>
</form>
</body>
</html>