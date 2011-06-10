var p = 2;


function addRespuesta(divactual){
	var capa = document.getElementById(divactual);
	
	//comprobar numero de respuesta
	var divs = capa.getElementsByTagName("div");
	var cadena =divs[divs.length-1].id;
	var numres = cadena[cadena.length-1];
	var n= parseInt(numres)+1;
	
	var cadena2 = capa.getAttribute("id");
	var numpreg = cadena2[cadena2.length-1];
	var p= parseInt(numpreg);
	
	var capa2 = document.createElement("div");
	var label = document.createElement("label");
	var texto = document.createElement("input");
	label.innerHTML = "Respuesta "+n+" ";
	texto.type = "text";
	texto.name = "res"+p+"-"+n;
	texto.id ="res"+p+"-"+n;
	capa2.id = "res"+p+"-"+n;
	capa.appendChild(capa2);
	capa2.appendChild(label);
	capa2.appendChild(texto);
	capa2.innerHTML+="<br/>";	
} 

function addPregunta(){
	var capa = document.getElementById("preguntas");
	var div_preg = document.createElement("div");
	var div_enun = document.createElement("div");
	var div_res1 = document.createElement("div");
	var div_res2 = document.createElement("div");
	var div_boton = document.createElement("div");
	var div_boton_borrar= document.createElement("div");
	var label_enun = document.createElement("label");
	var label_res1 = document.createElement("label");
	var label_res2 = document.createElement("label");
	var texto_enun = document.createElement("input");
	var texto_res1 = document.createElement("input");
	var texto_res2 = document.createElement("input");
	var boton = document.createElement("input");
	var boton_borrar= document.createElement("input");
	
	div_preg.id = "preg"+p;
	
	var cadena = "preg"+p;
		
	//Enunciado preg
	label_enun.innerHTML ="Enunciado de la pregunta "+p+": ";
	texto_enun.id = "enun"+p;
	texto_enun.type = "text";
	texto_enun.name = "enunpreg"+p;
	div_enun.id= "enunpreg"+p;
	div_enun.appendChild(label_enun);
	div_enun.appendChild(texto_enun);
	
	//Respuesta1
	label_res1.innerHTML="Respuesta 1 ";
	texto_res1.id = "res"+p+"_1";
	texto_res1.type = "text";
	texto_res1.name = "res"+p+"-1";
	div_res1.id = "res"+p+"-1";
	div_res1.appendChild(label_res1);
	div_res1.appendChild(texto_res1);
	
	//Respuesta2
	label_res2.innerHTML="Respuesta 2 ";
	texto_res2.id = "res"+p+"_2";
	texto_res2.type = "text";
	texto_res2.name = "res"+p+"-2";
	div_res2.id = "res"+p+"-2";
	div_res2.appendChild(label_res2);
	div_res2.appendChild(texto_res2);
	
	//boton Añadir respuesta
	div_boton.id = "addres";
	boton.type = "button";
	boton.value = "Añadir Respuesta";
	boton.onclick = function () {
		addRespuesta(cadena);
	};
	div_boton.appendChild(boton);
	
	//boton Eliminar respuesta
	div_boton_borrar.id = "removeres";
	boton_borrar.type = "button";
	boton_borrar.value= "Quitar Respuesta";
	boton_borrar.onclick = function () {
		removeRespuesta(cadena);
	};
	div_boton_borrar.appendChild(boton_borrar);
	
	//añadir todo al contenedor de pregunta.
	div_preg.appendChild (div_boton_borrar);
	div_preg.appendChild (div_boton);
	div_preg.appendChild (div_enun);
	div_preg.appendChild (div_res1);
	div_preg.appendChild (div_res2);
	capa.appendChild(div_preg);
	p++;
	//capa.innerHTML+="<hr>";
}


function removeRespuesta(divactual){
	var capa = document.getElementById(divactual);
	var divs = capa.getElementsByTagName("div");
	var divAEliminar= divs[divs.length-1];
	var cadena =divs[divs.length-1].id;
	var numres = cadena[cadena.length-1];
	var n= parseInt(numres);
	if (n>2){
		capa.removeChild(divAEliminar);
	}
}

function removePregunta(){
	var capa = document.getElementById("preguntas");
	var divs = capa.getElementsByTagName("div");
	var i=0;
	for (i=divs.length-1; i>=0; i--){
		var cadena= divs[i].id;
		if (cadena[0] == 'p' && p!=2){
			var divAEliminar = document.getElementById(cadena);
			p--;
			capa.removeChild(divAEliminar);
			break;
		}
	}
}

function validate (){
	document.formulario.action = "FrontController?accion=insertarEncuesta";
	document.formulario.submit();
}

