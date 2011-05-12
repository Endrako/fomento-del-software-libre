function soloNumeros(event){
	var key=event.keyCode;
	if (key < 48 || key > 57){
		window.event.keyCode=0;
	}
}