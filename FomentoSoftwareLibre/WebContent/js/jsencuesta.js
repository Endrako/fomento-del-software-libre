var n = 3;
var p = 2;

function addRespuesta(divactual){
	var capa = document.getElementById("divactual");
	var capa2 = document.createElement("div");
	var label = document.createElement("label");
	var texto = document.createElement("input");
	label.innerHTML = "Respuesta "+n+" ";
	texto.type = "text";
	texto.name = "resp"+p+""+n;
	texto.id ="res"+p+""+n;
	capa2.id = "res"+p+""+n;
	capa.appendChild(capa2);
	capa2.appendChild(label);
	capa2.appendChild(texto);
	capa2.innerHTML+="<br/>";
	n++;	
} 

function addPregunta(){
	n=3;
	var capa = document.getElementById("preguntas");
	var capa2 = document.createElement("div");
	var label = document.createElement("label");
	var labelp1 = document.createElement("label");
	var labelp2 = document.createElement("label");
	var texto = document.createElement("input");
	var textop1 = document.createElement("input");
	var textop2 = document.createElement("input");
	var boton = document.createElement("input");
	
	label.innerHTML ="Enunciado de la pregunta "+p+": ";
	labelp1.innerHTML="Respuesta 1";
	labelp2.innerHTML="Respuesta 2";
	texto.type = "text";
	texto.name = "preg"+p;
	texto.id = "pre"+p;
	textop1.type = "text";
	textop1.name = "res"+p+"1";
	textop1.id = "res"+p+"1";
	textop2.type = "text";
	textop2.name = "res"+p+"2";
	textop2.id = "res"+p+"2";
	capa2.id= "pre"+p;
	boton.type = "button";
	boton.onclick = function(){addRespuesta(capa2);};
	boton.value = "Añadir Respuesta";
	
	capa.appendChild(capa2);
	capa2.appendChild(label);
	capa2.appendChild(texto);
	capa2.innerHTML+="<br/>";
	capa2.appendChild(labelp1);
	capa2.appendChild(textop1);
	capa2.innerHTML+="<br/>";
	capa2.appendChild(labelp2);
	capa2.appendChild(textop2);
	capa2.innerHTML+="<br/>";
	capa2.appendChild(boton);
	//capa2.innerHTML+="<hr>";
	p++;
}

function addRespuesta2(){
	p=1;
	var capa = document.getElementById("preg1");
	var capa2 = document.createElement("div");
	var label = document.createElement("label");
	var texto = document.createElement("input");
	label.innerHTML = "Respuesta "+n+" ";
	texto.type = "text";
	texto.name = "resp"+p+"-"+n;
	texto.id ="res"+p+"-"+n;
	capa2.id = "res"+p+"-"+n;
	capa.appendChild(capa2);
	capa2.appendChild(label);
	capa2.appendChild(texto);
	capa2.innerHTML+="<br/>";
	n++;	
} 
