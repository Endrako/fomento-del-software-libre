
function recuperarProyecto(idProyecto) {
	document.formulario.action = "FrontController?accion=recuperarPerfilProyecto&idProyecto="
			+ idProyecto;
	document.formulario.submit();
}

function recuperarAplicacion(idAplicacion) {
	document.formulario.action = "FrontController?accion=recuperarPerfilAplicacion&idAplicacion="
			+ idAplicacion;
	document.formulario.submit();
}

function nuevaA() {
	document.formulario.action = "FrontController?accion=nuevaAplicacion";
	document.formulario.submit();
}
function nuevoProyecto() {
	document.formulario.action = "FrontController?accion=nuevoProyecto";
	document.formulario.submit();
}
