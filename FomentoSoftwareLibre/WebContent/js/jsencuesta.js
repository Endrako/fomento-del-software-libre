var n = 2;
function addElement(){
	var capa = document.getElementById("capa");
	var label = document.createElement("label");
	var texto = document.createElement("input");
	label.innerHTML = "Respuesta "+n;
	texto.type = "text";
	texto.name = "resp"+n;
	texto.id ="res"+n;
	capa.appendChild(label);
	capa.appendChild(texto);
	capa.innerHTML+="<br/>";
	n++;
	
} 