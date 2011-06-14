
function recuperarProyecto(idProyecto) {
	document.formulario.action = "FrontController?accion=recuperarPerfilProyecto&idProyecto="
			+ idProyecto;
	document.formulario.submit();
}
function recuperarProyecto2(idProyecto) {
	document.formulario2.action = "FrontController?accion=recuperarPerfilProyecto&idProyecto="
			+ idProyecto;
	document.formulario2.submit();
}
function recuperarAplicacion(idAplicacion) {
	document.formulario.action = "FrontController?accion=recuperarPerfilAplicacion&idAplicacion="
			+ idAplicacion;
	document.formulario.submit();
}
function borrameproyecto(idProyecto) {
	alert("Al desvincularte de un proyecto se te penalizará con -40 de karma");
	document.formulario.action ="FrontController?accion=borrarmeDeUnProyecto&idProyecto="+ idProyecto;
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
function crearProyecto() {
	document.formulario.action = "FrontController?accion=creacionProyectos";
	document.formulario.submit();
}
function muestraAlert(mensaje){
	alert(mensaje);
}


