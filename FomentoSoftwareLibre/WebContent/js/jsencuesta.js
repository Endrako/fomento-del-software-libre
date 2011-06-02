var n = 3;
var p = 2;

function addRespuesta(divactual){
	var capa = document.getElementById(divactual);
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
	var div_preg = document.createElement("div");
	var div_enun = document.createElement("div");
	var div_res1 = document.createElement("div");
	var div_res2 = document.createElement("div");
	var div_boton = document.createElement("div");
	var label_enun = document.createElement("label");
	var label_res1 = document.createElement("label");
	var label_res2 = document.createElement("label");
	var texto_enun = document.createElement("input");
	var texto_res1 = document.createElement("input");
	var texto_res2 = document.createElement("input");
	var boton = document.createElement("input");
	
	div_preg.id = "preg"+p;
	
	var cadena = "preg"+p;
		
	//Enunciado preg
	label_enun.innerHTML ="Enunciado de la pregunta "+p+": ";
	texto_enun.id = "enun"+p;
	texto_enun.type = "text";
	div_enun.id= "enunpreg"+p;
	div_enun.appendChild(label_enun);
	div_enun.appendChild(texto_enun);
	
	//Respuesta1
	label_res1.innerHTML="Respuesta 1 ";
	texto_res1.id = "res"+p+"_1";
	texto_res1.type = "text";
	texto_res1.name = "res"+p+"_1";
	div_res1.id = "res"+p+"-1";
	div_res1.appendChild(label_res1);
	div_res1.appendChild(texto_res1);
	
	//Respuesta2
	label_res2.innerHTML="Respuesta 2 ";
	texto_res2.id = "res"+p+"_2";
	texto_res2.type = "text";
	texto_res2.name = "res"+p+"_2";
	div_res2.id = "res"+p+"-2";
	div_res2.appendChild(label_res2);
	div_res2.appendChild(texto_res2);
	
	//boton
	div_boton.id = "addres"+p;
	boton.type = "button";
	boton.value = "Añadir Respuesta";
	boton.onclick = function () {
		addRespuesta(cadena);
	};
	div_boton.appendChild(boton);
	
	
	div_preg.appendChild (div_enun);
	div_preg.appendChild (div_boton);
	div_preg.appendChild (div_res1);
	div_preg.appendChild (div_res2);
	capa.appendChild(div_preg);
	/*capa2.appendChild(label);
	capa2.appendChild(texto);
	capa2.innerHTML+="<br/>";
	capa2.appendChild(labelp1);
	capa2.appendChild(textop1);
	capa2.innerHTML+="<br/>";
	capa2.appendChild(labelp2);
	capa2.appendChild(textop2);
	capa2.innerHTML+="<br/>";
	capa2.appendChild(boton);
	//capa2.innerHTML+="<hr>";*/
	p++;
}

/*
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
} */
